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
 * credential parameters
 *
 */
/**
 * The Class CredentialParams.
 */
public class CredentialParams {

	/** The access rules. */
	private AccessRule[] accessRules;

	/** The redirection. */
	private String redirection;

	/**
	 * Instantiates a new credential params.
	 */
	public CredentialParams() {
	}

	/**
	 * Instantiates a new credential params.
	 *
	 * @param accessRules the access rules
	 * @param redirection the redirection
	 */
	public CredentialParams(AccessRule[] accessRules, String redirection) {
		this.accessRules = accessRules;
		this.redirection = redirection;
	}

	/**
	 * Gets the access rules.
	 *
	 * @return the access rules
	 */
	public AccessRule[] getAccessRules() {
		return accessRules;
	}

	/**
	 * Gets the redirection.
	 *
	 * @return the redirection
	 */
	public String getRedirection() {
		return redirection;
	}

	/**
	 * Sets the access rules.
	 *
	 * @param accessRules the new access rules
	 */
	public void setAccessRules(AccessRule[] accessRules) {
		this.accessRules = accessRules;
	}

	/**
	 * Sets the redirection.
	 *
	 * @param redirection the new redirection
	 */
	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}

}
