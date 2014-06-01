package com.lebab.datumbox.service.intf;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public interface HitApiService {

	public InputStream postURL(HttpURLConnection connection, URL url, String urlParameters, String request) throws MalformedURLException,
	IOException ;
	 
}
