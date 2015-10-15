package com.fernandomantoan.latinoware.support;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {
	private String mUrl;

	public WebClient(String url) {
		mUrl = url;
	}

	public String get() {
		String result = null;
		InputStream is = null;
		try {
			URL url = new URL(mUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.connect();
			int responseCode = connection.getResponseCode();

			if (responseCode != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("StatusCode diferente de 200");
			}

			is = connection.getInputStream();

			result = readResponse(is);
		} catch (Exception e) {
			String message = "Não foi possível conectar com o servidor";
			Log.e("WEBCLIENT", message, e);
			throw new RuntimeException(message, e);
		}
		return result;
	}

	protected String readResponse(InputStream is) throws IOException {
		final Reader isReader = new InputStreamReader(is, "UTF-8");
		final BufferedReader reader = new BufferedReader(isReader);

		String result = "";
		String line = "";

		while ((line = reader.readLine()) != null) {
			result += line;
		}
		reader.close();
		isReader.close();
		is.close();

		return result;
	}
}