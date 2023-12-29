package com.blog.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.application.helper.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFound ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, "failed");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
