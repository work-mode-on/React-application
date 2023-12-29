package com.blog.application.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.blog.application.helper.Constant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private Integer id;

//	@NotBlank
	@NotEmpty
	@Size(min = 4, message = "Username must be of 4 characters !!!")
	private String name;

	@Pattern(regexp = Constant.EMAIL_REGEX_PATTERN, message = Constant.INVALID_EMAIL_MESSAGE)
	@NotBlank
	@Email(message = "Email address is not valid !!!")
	private String email;

	@Pattern(regexp = Constant.PASSWORD_REGEX_PATTERN, message = Constant.INVALID_PASSWORD_MESSAGE)
	@NotBlank
	@Size(min = 3, max = 10, message = "Password must be min of 3 characters and max of 10 characters !!!")
	private String password;

	private String about;

	private boolean isEnable;

}
