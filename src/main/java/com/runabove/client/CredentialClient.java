package com.runabove.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

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
 * Credential client class
 * In short, wrap an existing request with additional header parameters
 * 

 * 
 */
/**
 * The Class CredentialClient.
 */
public class CredentialClient implements Client {

	/** The wrapped. */
	private final Client wrapped;

	/** The application key. */
	private final String applicationKey;

	/** The exception handler. */
	private final ExceptionHandler exceptionHandler;

	/**
	 * Credential client constructor .
	 *
	 * @param client the client
	 * @param applicationKey the application key
	 * @param exceptionHandler the exception handler
	 */
	public CredentialClient(Client client, String applicationKey, ExceptionHandler exceptionHandler) {
		wrapped = client;
		this.applicationKey = applicationKey;
		this.exceptionHandler = exceptionHandler;
	}

	/**
	 * internal sign function of the request.
	 *
	 * @param request the request
	 * @return the request
	 */
	private Request sign(final Request request) {
		if (request != null && request.getHeaders() != null) {
			try {
				List<Header> modifiedHeaders = new ArrayList<Header>();

				// duplicate the headers if there is already something
				if (request.getHeaders().isEmpty()) {
					for (int i = 0; i < request.getHeaders().size(); i++) {
						Header header = request.getHeaders().get(i);
						// avoid duplication otherwise it will repeted forever
						if (!modifiedHeaders.contains(header)) {
							modifiedHeaders.add(header);
						}
					}
				}

				// signing thing
				modifiedHeaders.add(new Header("X-Ovh-Application", applicationKey));
				modifiedHeaders.add(new Header("Content-type", "application/json"));

				return new Request(request.getMethod(), request.getUrl(), modifiedHeaders, request.getBody());
			} catch (Exception e) {
				exceptionHandler.handleException(e);
			}
		}
		return request;
	}

	/**
	 * execute a request and dispatch the response.
	 *
	 * @param request the request
	 * @return response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Response execute(Request request) throws IOException {
		Request newRequest = sign(request);
		return wrapped.execute(newRequest);
	}
}