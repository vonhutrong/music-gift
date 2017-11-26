package com.trong.model;

import lombok.Data;

@Data
public class Command {
	private String sender;
	private CommandType commandType;
	private String argument;
}
