package com.dms.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Share_files implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date send_date;
	private Date receive_date;
	private Date seen_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User_info sender_info = new User_info();

	public User_info getSender_info() {
		return sender_info;
	}

	public void setSender_info(User_info sender_info) {
		this.sender_info = sender_info;
	}

	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User_info receiver_info = new User_info();

	public User_info getReceiver_info() {
		return receiver_info;
	}

	public void setReceiver_info(User_info receiver_info) {
		this.receiver_info = receiver_info;
	}
}
