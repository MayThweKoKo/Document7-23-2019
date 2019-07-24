package com.dms.dao;

import java.util.List;

import com.dms.dto.MessageDto;
import com.dms.entity.Message;
import com.dms.entity.Message_Send;

public interface MessageDao {
	public List<Message> viewAllMessage();
	public Message searchMessage(Message message);
	public void deleteMessage(Message message);
	public long saveMessage(Message message);
	public void sendMessage(Message_Send msgSend);
	public List<MessageDto> getSentMessage(long id);
	public List<MessageDto> getReceivedMessage(long id);
	public MessageDto getMessage(long msgId,long userId); 
	public void updateReceiveDate(long id,long userId);
	public Message getMessage(long msgId);
	
}
