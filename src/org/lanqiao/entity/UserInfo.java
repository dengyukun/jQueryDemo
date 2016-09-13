package org.lanqiao.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private int user_id;
	private String user_name;
	private String user_pwd;
	private String user_email;
	private char user_sex;
	private String user_phone;
	private String user_address;
	private int question_id;
	private String question_answer;

	public UserInfo() {
	}
	public UserInfo(String user_name, String user_pwd,
			String user_email, char user_sex, String user_phone,
			String user_address, int question_id, String question_answer) {
		super();
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_email = user_email;
		this.user_sex = user_sex;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.question_id = question_id;
		this.question_answer = question_answer;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public char getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(char user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_answer() {
		return question_answer;
	}

	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}

}
