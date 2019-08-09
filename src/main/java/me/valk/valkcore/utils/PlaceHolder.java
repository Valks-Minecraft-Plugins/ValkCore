package me.valk.valkcore.utils;

@SuppressWarnings("ALL")
class PlaceHolder {
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
