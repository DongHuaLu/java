/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.dolph.struts.form;

import org.apache.struts.action.ActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-02-2013
 * 
 * XDoclet definition:
 * @struts.form name="registerForm"
 */
public class RegisterForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** username property */
	private String username;

	/** email property */
	private String email;

	/** tel property */
	private String tel;

	/** password property */
	private String password;

	/*
	 * Generated Methods
	 */

	/** 
	 * Returns the username.
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 * Set the username.
	 * @param username The username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** 
	 * Returns the email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * Set the email.
	 * @param email The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * Returns the tel.
	 * @return String
	 */
	public String getTel() {
		return tel;
	}

	/** 
	 * Set the tel.
	 * @param tel The tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/** 
	 * Returns the password.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * Set the password.
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}