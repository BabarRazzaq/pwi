package com.pwi.response;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ApiResponseBuilder {

	public static <T> ResponseEntity<?> buildSuccessResponse(String message, T payload) {

		Status status = new Status(HttpStatus.OK.toString(), message, UUID.randomUUID().toString());

		return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(status, payload), HttpStatus.OK);

	}
	
	public static <T> ResponseEntity<?> buildSuccessResponseWithHeaders(String message, HttpHeaders httpHeaders,
			T payload) {

		Status status = new Status(HttpStatus.OK.toString(), message, UUID.randomUUID().toString());

		return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(status, payload), httpHeaders, HttpStatus.OK);

	}

	public static <T> ResponseEntity<?> buildSuccessButEmptyResponse(String message) {

		Status status = new Status(HttpStatus.OK.toString(), message, UUID.randomUUID().toString());

		return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(status), HttpStatus.NOT_FOUND);

	}

	public static <T> ResponseEntity<?> buildFailureResponse(String message, String details,
			HttpStatus httpStatus) {

		Status status = new Status(httpStatus.toString(), message, details, UUID.randomUUID().toString());

		return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(status), httpStatus);

	}

}
