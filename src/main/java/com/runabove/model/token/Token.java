package com.runabove.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
 * openstack token detail object
 *
 */
/**
 * The Class Token.
 */
public class Token {

	/** The token. */
	@Expose
	private OpenstackToken token;

	/** The x_ auth_ token. */
	@SerializedName("X-Auth-Token")
	@Expose
	private String xAuthToken;

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public OpenstackToken getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(OpenstackToken token) {
		this.token = token;
	}

	/**
	 * Gets the x_ auth_ token.
	 *
	 * @return the x_ auth_ token
	 */
	public String getXAuthToken() {
		return xAuthToken;
	}

	/**
	 * Sets the x auth token.
	 *
	 * @param xAuthToken the new xauthtoken
	 */
	public void setXAuthToken(String xAuthToken) {
		this.xAuthToken = xAuthToken;
	}

}