package com.dms.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.dto.MessageDto;
import com.dms.entity.Message;
import com.dms.entity.Message_Send;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Message> viewAllMessage() {
		// TODO Auto-generated method stub
		List<Message> message_list=sessionFactory.getCurrentSession().createCriteria(Message.class).list();
		return message_list;
	}

	@Override
	public Message searchMessage(Message message) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Message sms=(Message) session.get(Message.class, message.getId());
		return sms;
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Message delete_message=(Message) session.get(Message.class,message.getId());
		session.delete(delete_message);
		session.flush();
		
	}

	@Override
	public long saveMessage(Message message) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		long id=(long)session.save(message);
		return id;
	}

	@Override
	public void sendMessage(Message_Send msgSend) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(msgSend);
	}

	@Override
	public List<MessageDto> getSentMessage(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Message.class)
				.createAlias("sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("send_date"),"sendDate")
					.add(Projections.property("title"),"title")
					.add(Projections.property("description"),"description")
					);
			c.add(Restrictions.eq("s.id", id));
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return c.list();
	}

	@Override
	public List<MessageDto> getReceivedMessage(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Message_Send.class)
				.createAlias("receiver", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("message", "m", JoinType.LEFT_OUTER_JOIN)
				.createAlias("m.sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("m.id"),"id")
					.add(Projections.property("m.title"),"title")
					.add(Projections.property("m.send_date"),"sendDate")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("m.description"),"description")
					);
			c.add(Restrictions.eq("r.id", id));
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return c.list();
	}
	
	@Override
	public MessageDto getMessage(long msgId, long userId) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Message.class)
				.createAlias("sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("send_date"),"sendDate")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("title"),"title")
					.add(Projections.property("description"),"description")
					);
			c.add(Restrictions.eq("id", msgId));
			
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return (MessageDto)c.uniqueResult();
	}
	@Override
	public void updateReceiveDate(Date date) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(date);

		
		
	}

}
