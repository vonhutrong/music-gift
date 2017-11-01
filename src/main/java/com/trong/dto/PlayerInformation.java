package com.trong.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class PlayerInformation {
	@NotEmpty
	private String name;
}
