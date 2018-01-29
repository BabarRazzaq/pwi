package com.pwi.response;

/**
 * 
 *
 * @param <T>
 */
public class ApiResponse<T> {

	private Status status;
	private T apiResponse;

	public ApiResponse() {
	}
	/**
	 * @param status
	 */
	public ApiResponse(Status status) {
		super();
		this.status = status;
	}

	/**
	 * @param status
	 * @param apiResponse
	 */
	public ApiResponse(Status status, T apiResponse) {
		super();
		this.status = status;
		this.apiResponse = apiResponse;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the apiResponse
	 */
	public T getApiResponse() {
		return apiResponse;
	}

	/**
	 * @param apiResponse
	 *            the apiResponse to set
	 */
	public void setApiResponse(T apiResponse) {
		this.apiResponse = apiResponse;
	}

}
