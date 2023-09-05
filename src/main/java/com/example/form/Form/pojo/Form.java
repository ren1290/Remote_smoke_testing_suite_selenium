package com.example.form.Form.pojo;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class Form {

	@NotEmpty(message="URL is required")
	@URL(message="Please enter a valid URL")
	private String url;
	@NotEmpty(message="Atleast one browser must be selected")
	private List<String> browsers;
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<String> getBrowsers() {
		return browsers;
	}


	public void setBrowsers(List<String> browsers) {
		this.browsers = browsers;
	}

	public Form(@NotEmpty(message = "URL is required") @URL(message = "Please enter a valid URL") String url,
			List<String> browsers) {
		super();
		this.url = url;
		this.browsers = browsers;
	}


	public Form() {
		
	}
}
