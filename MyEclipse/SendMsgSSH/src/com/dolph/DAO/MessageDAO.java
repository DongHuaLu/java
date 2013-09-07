package com.dolph.DAO;

import java.util.List;

import com.dolph.model.DeleteMessage;
import com.dolph.model.ReceiveMessage;
import com.dolph.model.SendMessage;

public interface MessageDAO {
	/**
	 * ������Ϣ��������
	 * @param sendMessage
	 */
	public void saveSendMessage(SendMessage sendMessage);
	/**
	 * ������Ϣ���ռ���
	 * @param receiveMessage
	 */
	public void saveReceiveMessage(ReceiveMessage receiveMessage);
	/**
	 * ������Ϣ����������
	 * @param deleteMessage
	 */
	public void saveDeleteMessage(DeleteMessage deleteMessage);
	/**
	 * ���ݷ�����Id��ѯ�������ռ�������
	 * @param senderid
	 * @return
	 */
	public List<SendMessage> findSendMessage(int senderId);
	/**
	 * �����ռ��˲�ѯ�ռ����ռ�������
	 * @param receiverId
	 * @return
	 */
	public List<ReceiveMessage> findReceiveMessage(int receiverId);
	/**
	 * ����������id��ѯ����������
	 * @param ownerid
	 * @return
	 */
	public List<DeleteMessage> findDeleteMessage(int ownerId);
	/**
	 * ���ݷ�����Ϣɾ������������Ϣ
	 * @param sendMessageId
	 */
	public void deleteSendMessage(int sendMessageId);
	/**
	 * ������ϢIdɾ���������ڵ���Ϣ
	 * @param deleteMessageId
	 */
	public void deleteDeleteMessage(int deleteMessageId);
	/**
	 * ������ϢIdɾ���ռ����ڵ���Ϣ
	 * @param receiveMessageId
	 */
	public void deleteReceiveMessage(int receiveMessageId);
	/**
	 * ��ʾ�ռ�����Ϣ����ϸ��Ϣ
	 * @param receiveMessageId
	 * @return
	 */
	public ReceiveMessage showReceiveMessage(int receiveMessageId);
	/**
	 * ��ʾ��������Ϣ����ϸ��Ϣ
	 * @param sendMessageId
	 * @return
	 */
	public SendMessage showSendMessage(int sendMessageId);
}
