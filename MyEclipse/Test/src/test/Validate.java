package test;


import com.opensymphony.xwork2.ActionSupport;

public class Validate extends ActionSupport {
	private String username;
	
	

	public String add() throws Exception {
		return SUCCESS;
	}

	/*public void validateAdd() {
		if(username==null||"".equals(username.trim())){
			this.addFieldError("username", "用户名为空");
		}
	}*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
