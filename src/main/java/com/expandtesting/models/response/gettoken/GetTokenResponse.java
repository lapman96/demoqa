package com.expandtesting.models.response.gettoken;


import lombok.*;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTokenResponse{

	private com.expandtesting.models.response.gettoken.Data data;

	private boolean success;

	private String message;

	private int status;
}