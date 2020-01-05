package com.ontologie.ontologie.domain;

import java.util.List;

public class JsonResponse {
	public boolean isErrorMessage;
	public String title;
	public List<String> messages;
	public JsonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JsonResponse(boolean isErrorMessage, String title, List<String> messages) {
		super();
		this.isErrorMessage = isErrorMessage;
		this.title = title;
		this.messages = messages;
	}

	public boolean isErrorMessage() {
		return isErrorMessage;
	}
	public void setErrorMessage(boolean isErrorMessage) {
		this.isErrorMessage = isErrorMessage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
}
