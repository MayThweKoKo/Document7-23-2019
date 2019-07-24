package com.dms.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.MessageDao;
import com.dms.dto.MessageDto;
import com.dms.entity.Message;
import com.dms.entity.Message_Send;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public void saveMessage(MessageDto message) {
		// TODO Auto-generated method stub
			
			long msgid=messageDao.saveMessage(convertMessageBean(message));	
			for(long recId : message.getReceiver_list()) {
				Message_Send msgSend=new Message_Send();
				msgSend.getMessage().setId(msgid);
				msgSend.getReceiver().setId(recId);
				messageDao.sendMessage(msgSend);
			}
	}
	private Message convertMessageBean(MessageDto msg) {
		Message messages = new Message();
		messages.setId(msg.getId());
		messages.getSender().setId(msg.getSenderId());	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dFormat.format(new Date());  
			messages.setSend_date( dateFormat.parse(strDate));
		} catch (ParseException e) {
		e.printStackTrace();
		}
		messages.setTitle(msg.getTitle());
		messages.setDescription(msg.getDescription());
		
		return messages;
		
	}
	@Override
	public List<Message> viewAllMessage() {
		// TODO Auto-generated method stub
		return messageDao.viewAllMessage();
	}
	@Override
	public Message searchMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.searchMessage(message);
	}
	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.deleteMessage(message);
		
	}
	@Override
	public List<MessageDto> getSentMessage(long id) {
		// TODO Auto-generated method stub
		return messageDao.getSentMessage(id);
	}
	@Override
	public List<MessageDto> getReceivedMessage(long id) {
		// TODO Auto-generated method stub
		return messageDao.getReceivedMessage(id);
	}
	@Override
	public MessageDto getMessage(long msgId, long userId) {
		// TODO Auto-generated method stub
		return messageDao.getMessage(msgId, userId);
	}
	@Override
	public void updateReceiveDate(long id,long userId) {
		// TODO Auto-generated method stub	
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dFormat.format(new Date());  
		Message msg=messageDao.getMessage(id);
		msg.setSend_date( dateFormat.parse(strDate));
		*/
		messageDao.updateReceiveDate(id,userId);
		
	}

	

}
