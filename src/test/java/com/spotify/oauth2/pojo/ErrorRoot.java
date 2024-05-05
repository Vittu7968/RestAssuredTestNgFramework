package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;


//Using lombok Getter And Setter Annotaions

@Getter @Setter
@Jacksonized
@lombok.Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorRoot {
	
	@JsonProperty("error")
	private InnerError error;

//	@JsonProperty("error")
//	public InnerError getError() {
//	return error;
//	}
//
//	@JsonProperty("error")
//	public void setError(InnerError error) {
//	this.error = error;
	
//	}

}
