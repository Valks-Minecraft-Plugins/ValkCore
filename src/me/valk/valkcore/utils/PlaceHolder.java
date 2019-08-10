package me.valk.valkcore.utils;

public class PlaceHolder {
	private String message;

	public PlaceHolder(String message) {
		this.message = message;
	}

	public void replace(String placeholder, Object value) {
		message = message.replaceAll(placeholder, String.valueOf(value));
	}

	public String getMessage() {
		return message;
	}
}
