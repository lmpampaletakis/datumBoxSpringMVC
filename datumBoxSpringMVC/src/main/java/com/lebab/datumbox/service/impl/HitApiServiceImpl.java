package com.lebab.datumbox.service.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.lebab.datumbox.service.intf.HitApiService;

@Service
public class HitApiServiceImpl implements HitApiService{

	@Override
	public InputStream postURL(HttpURLConnection connection, URL url,
			String urlParameters, String request) throws IOException {

		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("charset", "utf-8");
		connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
		connection.setUseCaches(false);

		DataOutputStream wr = null;

		try {
			wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
		} finally {
			wr.close();
		}
		InputStream is = connection.getInputStream();
		return is;
	}

}
