package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.service.UserService;
import com.example.spring_boot_soap_example.GetUserRequest;
import com.example.spring_boot_soap_example.GetUserResponse;
import com.example.spring_boot_soap_example.User;

@Endpoint
public class UserEndpoint {

	@Autowired
	UserService userService;

	@PayloadRoot(namespace = "http://example.com/spring-boot-soap-example", localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
		GetUserResponse response = new GetUserResponse();
		User user = userService.getUser(request.getName());
		response.setUser(user);
		return response;
	}
}
