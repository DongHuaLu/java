package com.dolph.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dolph.DAO.MessageDAO;
import com.dolph.model.DeleteMessage;
import com.dolph.model.ReceiveMessage;
import com.dolph.model.SendMessage;

@Repository("messageDAO")
public class MessageDAOImpl extends BaseDAO implements MessageDAO {

	@Override
	public void saveSendMessage(SendMessage sendMessage) {
		getSession().save(sendMessage);
	}

	@Override
	public void saveReceiveMessage(ReceiveMessage receiveMessage) {
		getSession().save(receiveMessage);
	}

	@Override
	public void saveDeleteMessage(DeleteMessage deleteMessage) {
		getSession().save(deleteMessage);
	}

	@Override
	public List<SendMessage> findSendMessage(int senderId) {
		String hql = "select m from SendMessage m where m.sender.id=?";
		return (List<SendMessage>) getSession().createQuery(hql)
				.setParameter(0, senderId).list();
	}

	@Override
	public List<ReceiveMessage> findReceiveMessage(int receiverId) {
		String hql = "select m from ReceiveMessage m where m.receiver.id=?";
		return getSession().createQuery(hql).setParameter(0, receiverId).list();
	}

	@Override
	public List<DeleteMessage> findDeleteMessage(int ownerid) {
		String hql = "select m from DeleteMessage m where m.owner.id=?";
		return getSession().createQuery(hql).setParameter(0, ownerid).list();
	}

	@Override
	public void deleteSendMessage(int sendMessageId) {
		getSession()
				.delete(getSession().load(SendMessage.class, sendMessageId));
	}

	@Override
	public void deleteDeleteMessage(int deleteMessageId) {
		getSession().delete(
				getSession().load(DeleteMessage.class, deleteMessageId));

	}

	@Override
	public void deleteReceiveMessage(int receiveMessageId) {
		getSession().delete(
				getSession().load(ReceiveMessage.class, receiveMessageId));

	}

	@Override
	public ReceiveMessage showReceiveMessage(int receiveMessageId) {
		ReceiveMessage receiveMessage=(ReceiveMessage) getSession().load(ReceiveMessage.class,
				receiveMessageId);
		receiveMessage.setIsread(true);
		return receiveMessage;
	}

	@Override
	public SendMessage showSendMessage(int sendMessageId) {
		return (SendMessage) getSession()
				.load(SendMessage.class, sendMessageId);
	}

}
