package com.dolph.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.DAO.MessageDAO;
import com.dolph.model.DeleteMessage;
import com.dolph.model.ReceiveMessage;
import com.dolph.model.SendMessage;
import com.dolph.model.User;
import com.dolph.service.MessageService;
import com.dolph.service.UserService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	private MessageDAO messageDAO;
	private UserService userService;
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource(name="messageDAO")
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@Override
	public void sendMessage(String title, String content, int senderId,
			int[] receiverIds, int groupId) {
		Set<Integer> allReceiverId=new HashSet<Integer>();
		
		List<User> groupReceivers=userService.findUsersbyGroupId(groupId, senderId);
		for(User u:groupReceivers){
			allReceiverId.add(u.getId());
		}
		for(int id:receiverIds){
			allReceiverId.add(id);
		}
		
		User sender=userService.findUserById(senderId);
		
		List<User> receivers=userService.findUsersByIds(allReceiverId);
		StringBuffer receiverNames = new StringBuffer();
		for(User u:receivers){
			ReceiveMessage receiveMessage=new ReceiveMessage();
			receiveMessage.setTitle(title);
			receiveMessage.setContent(content);
			receiveMessage.setIsread(false);
			receiveMessage.setReceiver(u);
			receiveMessage.setReceiveTime(new Date());
			receiveMessage.setSenderName(sender.getUsername());
			messageDAO.saveReceiveMessage(receiveMessage);
			
			receiverNames.append(u.getUsername()+" , ");
		}
		SendMessage sendMessage=new SendMessage();
		sendMessage.setTitle(title);
		sendMessage.setContent(content);
		sendMessage.setReceivername(receiverNames.toString());
		sendMessage.setSender(sender);
		messageDAO.saveSendMessage(sendMessage);
		


	}

	@Override
	public void deleteSendMessage(int sendMessageId) {
		SendMessage sendMessage=messageDAO.showSendMessage(sendMessageId);
		DeleteMessage deleteMessage =new DeleteMessage();
		
		deleteMessage.setContent(sendMessage.getContent());
		deleteMessage.setTitle(sendMessage.getTitle());
		deleteMessage.setDeleteTime(new Date());
		deleteMessage.setOwner(sendMessage.getSender());
		deleteMessage.setReceiverName(sendMessage.getReceivername());
		deleteMessage.setSenderName(sendMessage.getSender().getUsername());
		deleteMessage.setReceiveTime(null);
		deleteMessage.setSendTime(sendMessage.getSendTime());
		messageDAO.saveDeleteMessage(deleteMessage);		
		messageDAO.deleteSendMessage(sendMessageId);
	}

	@Override
	public void deleteReceiveMessage(int receiveMessageId) {
		ReceiveMessage receiveMessage=messageDAO.showReceiveMessage(receiveMessageId);
		DeleteMessage deleteMessage =new DeleteMessage();
		deleteMessage.setContent(receiveMessage.getContent());
		deleteMessage.setTitle(receiveMessage.getTitle());
		deleteMessage.setDeleteTime(new Date());
		deleteMessage.setOwner(receiveMessage.getReceiver());
		deleteMessage.setReceiverName(receiveMessage.getReceiver().getUsername());
		deleteMessage.setSenderName(receiveMessage.getSenderName());
		deleteMessage.setReceiveTime(receiveMessage.getReceiveTime());
		deleteMessage.setSendTime(null);
		
		messageDAO.saveDeleteMessage(deleteMessage);
		System.out.println("123");
		messageDAO.deleteReceiveMessage(receiveMessageId);
	}

	@Override
	public void deleteDeleteMessage(int deleteMessageId) {
		messageDAO.deleteDeleteMessage(deleteMessageId);
	}

	@Override
	public List<SendMessage> findSendMessage(int senderId) {
		return messageDAO.findSendMessage(senderId);
	}

	@Override
	public List<ReceiveMessage> findReceiverMessage(int receiverId) {
		return messageDAO.findReceiveMessage(receiverId);
	}

	@Override
	public List<DeleteMessage> findDeletedMessage(int ownerId) {
		return messageDAO.findDeleteMessage(ownerId);
	}

	@Override
	public SendMessage showSendMessage(int sendMessageId) {
		return messageDAO.showSendMessage(sendMessageId);
	}

	@Override
	public ReceiveMessage showReceiveMessage(int receiveMessageId) {
		return messageDAO.showReceiveMessage(receiveMessageId);
	}

}
