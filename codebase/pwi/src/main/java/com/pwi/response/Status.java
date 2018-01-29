package com.pwi.response;

public class Status {
	
	private String code;
	private String message;
	private String details;
	private String requestId;

	public Status() {
	}
	/**
	 * @param code
	 * @param message
	 * @param requestId
	 */
	public Status(String code, String message, String requestId) {
		super();
		this.code = code;
		this.message = message;
		this.requestId = requestId;
	}

	/**
	 * @param code
	 * @param message
	 * @param details
	 * @param requestId
	 */
	public Status(String code, String message, String details, String requestId) {
		super();
		this.code = code;
		this.message = message;
		this.details = details;
		this.requestId = requestId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
