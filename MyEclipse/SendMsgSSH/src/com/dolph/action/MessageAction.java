package com.dolph.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dolph.model.DeleteMessage;
import com.dolph.model.Group;
import com.dolph.model.ReceiveMessage;
import com.dolph.model.SendMessage;
import com.dolph.model.User;
import com.dolph.service.GroupService;
import com.dolph.service.MessageService;
import com.dolph.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("messageAction")
public class MessageAction extends ActionSupport {
	private int deleteId;
	private int detailId;
	private String title;
	private String content;
	private int[] receiverIds;
	private int groupId;
	private MessageService messageService;
	private UserService userService;
	private GroupService groupService;
	

	public String deleteReceiveMessage(){
		messageService.deleteReceiveMessage(deleteId);
		return "delete_success";
	}

	public String index(){
		return "index";
	}
	
	public String showReceivebox(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<ReceiveMessage> receiveMessages=messageService.findReceiverMessage(user.getId());
		ActionContext.getContext().put("receiveMessages", receiveMessages);
		return "receivebox";		
	}
		
	public String showSendbox(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<SendMessage> sendMessages=messageService.findSendMessage(user.getId());
		ActionContext.getContext().put("sendMessages", sendMessages);
		return "sendbox";
	}
		
	public String showDeletebox(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<DeleteMessage> deleteMessages=messageService.findDeletedMessage(user.getId());
		ActionContext.getContext().put("deleteMessages", deleteMessages);
		return "deletebox";		
	}
	public String showSendMessage(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<User> users=userService.findAllUsers(user.getId());
		List<Group> groups=groupService.findAllGroup();
		ActionContext.getContext().put("users", users);
		ActionContext.getContext().put("groups", groups);
		return "sendmessage";	
	}
	
	public String send(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		messageService.sendMessage(title, content, user.getId(), receiverIds, groupId);
		return "send_success";
	}
	
	public String detail(){
		ReceiveMessage receiveMessage=messageService.showReceiveMessage(detailId);
		ActionContext.getContext().put("receiveMessage", receiveMessage);
		return "detail";
		
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int[] getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(int[] receiverIds) {
		this.receiverIds = receiverIds;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource(name="messageService")
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Resource(name="groupService")
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
	}
}
