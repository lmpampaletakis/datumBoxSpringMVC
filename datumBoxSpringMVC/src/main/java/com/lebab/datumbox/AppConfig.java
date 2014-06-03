package com.lebab.datumbox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Value("${api_key}")
	private String api_key;

	@Value("${datumbox.url}")
	private String url;

	public String getApi_key() {
		return api_key;
	}

	public String getUrl() {
		return url;
	}

}
