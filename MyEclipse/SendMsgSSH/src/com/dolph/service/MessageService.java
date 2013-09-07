package com.dolph.service;

import java.util.List;

import com.dolph.model.DeleteMessage;
import com.dolph.model.ReceiveMessage;
import com.dolph.model.SendMessage;

public interface MessageService {
	public void sendMessage(String title,String content,int senderId,int[] receiverIds,int groupId);
	public void deleteSendMessage(int sendMessageId);
	public void deleteReceiveMessage(int receiveMessageId);
	public void deleteDeleteMessage(int deleteMessageId);
	public List<SendMessage> findSendMessage(int senderId);
	public List<ReceiveMessage> findReceiverMessage(int receiverId);
	public List<DeleteMessage> findDeletedMessage(int ownerId);
	public SendMessage showSendMessage(int sendMessageId);
	public ReceiveMessage showReceiveMessage(int receiveMessageId);
	
	
	

}
