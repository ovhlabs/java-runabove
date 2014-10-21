package com.runabove.model.auth;

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
 *
 * Credential request to get access to the API
 * 
 */
/**
 * The Class Credential.
 */
public class Credential {

	/** The validation url. */
	private String validationUrl;

	/** The consumer key. */
	private String consumerKey;

	/** The state. */
	private CredentialStateEnum state;

	/**
	 * Gets the validation url.
	 *
	 * @return the validation url
	 */
	public String getValidationUrl() {
		return validationUrl;
	}

	/**
	 * Sets the validation url.
	 *
	 * @param validationUrl the new validation url
	 */
	public void setValidationUrl(String validationUrl) {
		this.validationUrl = validationUrl;
	}

	/**
	 * Gets the consumer key.
	 *
	 * @return the consumer key
	 */
	public String getConsumerKey() {
		return consumerKey;
	}

	/**
	 * Sets the consumer key.
	 *
	 * @param consumerKey the new consumer key
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public CredentialStateEnum getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(CredentialStateEnum state) {
		this.state = state;
	}

}
