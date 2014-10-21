package com.runabove;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RetrofitError;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

import com.runabove.client.CredentialClient;
import com.runabove.client.SigningClient;
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
 */
/**
 * The Class SigningTest.
 */
public class SigningTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ApiTest.class);

	/**
	 * Test signing client.
	 */
	@Test
	public void testSigningClient() {
		LOG.info("Signing Client test");
		// check that the signing process does what it's supposed to do
		SigningClient sc = new SigningClient(new MockClient(), null, null, null, new ExceptionHandler() {

			public Throwable handleError(RetrofitError arg0) {
				return null;
			}

			public void handleException(Exception exception) {
			}
		});

		try {
			Response rs = sc.execute(new Request("GET", "/test", Collections.EMPTY_LIST, new TypedByteArray("application/json", "".getBytes())));
			assertNotNull(rs);
		} catch (IOException e) {
			LOG.error("Signing Client test error", e);
		}

	}

	/**
	 * Test credential client.
	 */
	@Test
	public void testCredentialClient() {
		LOG.info("Credential Client test");
		// check that the signing process does what it's supposed to do
		CredentialClient cc = new CredentialClient(new MockAuthClient(), null, new ExceptionHandler() {

			public Throwable handleError(RetrofitError arg0) {
				return null;
			}

			public void handleException(Exception exception) {
			}
		});
		try {
			Response rs = cc.execute(new Request("GET", "/test", Collections.EMPTY_LIST, new TypedByteArray("application/json", "".getBytes())));
			assertNotNull(rs);
		} catch (IOException e) {
			LOG.error("Signing Client test error", e);
		}
	}

	/**
	 * Test signing.
	 */
	@Test
	public void testSigning() {
		long timeStamp = 1366560945L;
		String applicationSecret = "EXEgWIz07P0HYwtQDs7cNIqCiQaWSuHF";
		String consumerKey = "MtSwSrPpNjqfVSmJhLbPyr2i45lSwPU1";
		String method = "GET";
		String url = "https://eu.api.ovh.com/1.0/domains/";

		// verify digest
		String dataToDigest = SigningClient.getDataToDigest(applicationSecret, consumerKey, method, url, "", Long.toString(timeStamp));
		assertEquals(dataToDigest, "EXEgWIz07P0HYwtQDs7cNIqCiQaWSuHF+MtSwSrPpNjqfVSmJhLbPyr2i45lSwPU1+GET+https://eu.api.ovh.com/1.0/domains/++1366560945");

		// verify signature
		String signature = SigningClient.getSignature(new ExceptionHandler() {

			public Throwable handleError(RetrofitError arg0) {
				return null;
			}

			public void handleException(Exception exception) {
			}
		}, dataToDigest);
		assertEquals(signature, "$1$d3705e8afb27a0d2970a322b96550abfc67bb798");

	}

}
