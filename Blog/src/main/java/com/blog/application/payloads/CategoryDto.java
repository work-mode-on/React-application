package com.blog.application.payloads;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	private Integer categoryId;

	private String categoryTitle;

	private String categoryDescription;

	@NotBlank
	private String title;

}
