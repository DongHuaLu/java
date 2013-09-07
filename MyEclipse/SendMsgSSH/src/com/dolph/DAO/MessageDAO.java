package com.dolph.DAO;

import java.util.List;

import com.dolph.model.DeleteMessage;
import com.dolph.model.ReceiveMessage;
import com.dolph.model.SendMessage;

public interface MessageDAO {
	/**
	 * 保存信息进发件箱
	 * @param sendMessage
	 */
	public void saveSendMessage(SendMessage sendMessage);
	/**
	 * 保存信息进收件箱
	 * @param receiveMessage
	 */
	public void saveReceiveMessage(ReceiveMessage receiveMessage);
	/**
	 * 保存信息进入垃圾箱
	 * @param deleteMessage
	 */
	public void saveDeleteMessage(DeleteMessage deleteMessage);
	/**
	 * 根据发送者Id查询发件人收件箱内容
	 * @param senderid
	 * @return
	 */
	public List<SendMessage> findSendMessage(int senderId);
	/**
	 * 根据收件人查询收件人收件箱内容
	 * @param receiverId
	 * @return
	 */
	public List<ReceiveMessage> findReceiveMessage(int receiverId);
	/**
	 * 根据所有者id查询垃圾箱内容
	 * @param ownerid
	 * @return
	 */
	public List<DeleteMessage> findDeleteMessage(int ownerId);
	/**
	 * 根据发送消息删除发件箱内消息
	 * @param sendMessageId
	 */
	public void deleteSendMessage(int sendMessageId);
	/**
	 * 根据消息Id删除回收箱内的消息
	 * @param deleteMessageId
	 */
	public void deleteDeleteMessage(int deleteMessageId);
	/**
	 * 根据消息Id删除收件箱内的消息
	 * @param receiveMessageId
	 */
	public void deleteReceiveMessage(int receiveMessageId);
	/**
	 * 显示收件箱信息的详细信息
	 * @param receiveMessageId
	 * @return
	 */
	public ReceiveMessage showReceiveMessage(int receiveMessageId);
	/**
	 * 显示发件箱信息的详细信息
	 * @param sendMessageId
	 * @return
	 */
	public SendMessage showSendMessage(int sendMessageId);
}
