package com.runabove.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedOutput;

import com.runabove.error.ExceptionHandler;

/*
 * Copyright (c) 2014, OVH

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.

 * Except as contained in this notice, the name of OVH and or its trademarks
 * (and among others RunAbove) shall not be used in advertising or otherwise to
 * promote the sale, use or other dealings in this Software without prior
 * written authorization from OVH.
 * Unit test for run above api
 * 
 * 
 * Signing client class
 * In short, wrap an existing request with additional headers that signs the request
 * 
 * 
 */
/**
 * The Class SigningClient.
 */
public class SigningClient implements Client {

	/** Logger */
	private final static Logger LOG = LoggerFactory.getLogger(SigningClient.class);

	/** The Constant HEXARRAY. */
	private static final char[] HEXARRAY = "0123456789abcdef".toCharArray();

	/** The Constant ALGORITHM. */
	private static final String ALGORITHM = "SHA-1";

	/** The wrapped. */
	private final Client wrapped;

	/** The application key. */
	private final String applicationKey;

	/** The application secret. */
	private final String applicationSecret;

	/** The consumer key. */
	private final String consumerKey;

	/** The exception handler. */
	private final ExceptionHandler exceptionHandler;

	/**
	 * Signing client constructor.
	 * 
	 * @param wrapped
	 *            the wrapped
	 * @param applicationKey
	 *            the application key
	 * @param applicationSecret
	 *            the application secret
	 * @param consumerKey
	 *            the consumer key
	 * @param exceptionHandler
	 *            the exception handler
	 */
	public SigningClient(Client wrapped, String applicationKey, String applicationSecret, String consumerKey, ExceptionHandler exceptionHandler) {
		this.wrapped = wrapped;
		this.applicationSecret = applicationSecret;
		this.applicationKey = applicationKey;
		this.consumerKey = consumerKey;
		this.exceptionHandler = exceptionHandler;
	}

	/**
	 * internal function to sign the request.
	 * 
	 * @param request
	 *            the request
	 * @return the request
	 */
	private Request sign(final Request request) {
		if (request != null && request.getHeaders() != null) {
			try {
				List<Header> modifiedHeaders = new ArrayList<Header>();

				// duplicate the headers if there is already something
				if (request.getHeaders().size() > 0) {
					for (int i = 0; i < request.getHeaders().size(); i++) {
						Header header = request.getHeaders().get(i);
						modifiedHeaders.add(header);
					}
				}

				// signing thing
				String time = Long.toString(System.currentTimeMillis() / 1000l);
				String body = null;
				if (request.getBody() != null) {
					body = typedOutputToString(request.getBody());
				}

				modifiedHeaders.add(new Header("X-Ovh-Application", applicationKey));
				modifiedHeaders.add(new Header("X-Ovh-Consumer", consumerKey));
				modifiedHeaders.add(new Header("X-Ovh-Timestamp", time));
				modifiedHeaders.add(new Header("X-Ovh-Signature", getSignature(exceptionHandler,
						getDataToDigest(applicationSecret, consumerKey, request.getMethod(), request.getUrl(), body, time))));

				return new Request(request.getMethod(), request.getUrl(), modifiedHeaders, request.getBody());
			} catch (IOException e) {
				LOG.error("Network Error during signing process", e);
				exceptionHandler.handleException(e);
			} catch (RuntimeException e) {
				LOG.error("Error during signing process", e);
				exceptionHandler.handleException(e);
			}
		}
		return request;
	}

	/**
	 * util function to convert a typedoutput to a string .
	 * 
	 * @param t
	 *            the t
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String typedOutputToString(TypedOutput t) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		t.writeTo(baos);
		return new String(baos.toByteArray(), "utf-8");
	}

	/**
	 * request execution.
	 * 
	 * @param request
	 *            the request
	 * @return the response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Response execute(Request request) throws IOException {
		Request newRequest = sign(request);
		return wrapped.execute(newRequest);
	}

	/**
	 * trivial data aggregation and joining.
	 * 
	 * @param applicationSecret
	 *            the application secret
	 * @param consumerKey
	 *            the consumer key
	 * @param method
	 *            the method
	 * @param endPoint
	 *            the end point
	 * @param body
	 *            the body
	 * @param ts
	 *            the ts
	 * @return the data to digest
	 */
	public static String getDataToDigest(String applicationSecret, String consumerKey, String method, String endPoint, String body, String ts) {
		String bodyValue = body != null ? body : "";

		List<String> values = new ArrayList<String>();
		values.add(applicationSecret);
		values.add(consumerKey);
		values.add(method);
		values.add(endPoint.toString());
		values.add(bodyValue);
		values.add(ts);
		String result = join(values, "+");
		return result;
	}

	/**
	 * signature computation for the signing request in out process.
	 * 
	 * @param handler
	 *            the handler
	 * @param dataToDigest
	 *            the data to digest
	 * @return the signature
	 */
	public static String getSignature(ExceptionHandler handler, String dataToDigest) {
		try {
			MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
			byte[] hash = digest.digest(dataToDigest.getBytes("UTF-8"));
			return "$1$" + bytesToHex(hash);
		} catch (UnsupportedEncodingException e) {
			handler.handleException(e);
		} catch (NoSuchAlgorithmException e) {
			handler.handleException(e);
		}
		return null;
	}

	/**
	 * util joiner (used for testing encoding) .
	 * 
	 * @param values
	 *            the values
	 * @param separator
	 *            the separator
	 * @return the string
	 */
	private static String join(List<String> values, String separator) {
		Iterator<String> parts = values.iterator();
		StringBuilder builder = new StringBuilder();
		if (parts.hasNext()) {
			builder.append(parts.next());
			while (parts.hasNext()) {
				builder.append(separator);
				builder.append(parts.next());
			}
		}
		return builder.toString();
	}

	/**
	 * util bytes to hex converter.
	 * 
	 * @param bytes
	 *            the bytes
	 * @return the string
	 */
	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEXARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEXARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}
}