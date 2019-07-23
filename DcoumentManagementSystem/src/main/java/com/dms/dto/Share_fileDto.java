package com.dms.dto;

import java.sql.Date;
import java.util.List;

public class Share_fileDto {
	private List<String> receiver;
	private Date send_date;
	private Date receive_date;
	private Date seen_date;
	private long sender_id;
	
	public List<String> getReceiver() {
		return receiver;
	}
	public void setReceiver(List<String> receiver) {
		this.receiver = receiver;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public Date getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}
	public Date getSeen_date() {
		return seen_date;
	}
	public void setSeen_date(Date seen_date) {
		this.seen_date = seen_date;
	}
	public long getSender_id() {
		return sender_id;
	}
	public void setSender_id(long sender_id) {
		this.sender_id = sender_id;
	}
	
}
