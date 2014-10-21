package com.runabove.api;

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
 * The Class RunAboveConfig.
 */
public class RunAboveConfig {

	/** The application secret. */
	private String applicationSecret;

	/** The application key. */
	private String applicationKey;

	/** The void set x_ auth_ token( string x_ auth_ token). */
	private String login;

	/** The password. */
	private String password;

	/** The tenant id. */
	private String tenantId;

	/** The tenant name. */
	private String tenantName;

	/** The error handler. */
	private ExceptionHandler errorHandler;

	/** The is mocked. */
	private boolean isMocked;

	/**
	 * Sets the error handlder.
	 *
	 * @param errorHandler the error handler
	 * @return the run above config
	 */
	public RunAboveConfig setErrorHandlder(ExceptionHandler errorHandler) {
		this.errorHandler = errorHandler;
		return this;
	}

	/**
	 * Sets the application key.
	 *
	 * @param applicationKey the application key
	 * @return the run above config
	 */
	public RunAboveConfig setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
		return this;
	}

	/**
	 * Sets the application secret.
	 *
	 * @param applicationSecret the application secret
	 * @return the run above config
	 */
	public RunAboveConfig setApplicationSecret(String applicationSecret) {
		this.applicationSecret = applicationSecret;
		return this;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the login
	 * @return the run above config
	 */
	public RunAboveConfig setLogin(String login) {
		this.login = login;
		return this;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password
	 * @return the run above config
	 */
	public RunAboveConfig setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Sets the tenant id.
	 *
	 * @param tenantId the tenant id
	 * @return the run above config
	 */
	public RunAboveConfig setTenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Sets the tenant name.
	 *
	 * @param tenantName the tenant name
	 * @return the run above config
	 */
	public RunAboveConfig setTenantName(String tenantName) {
		this.tenantName = tenantName;
		return this;
	}

	/**
	 * Sets the mocked.
	 *
	 * @param isMocked the is mocked
	 * @return the run above config
	 */
	public RunAboveConfig setMocked(boolean isMocked) {
		this.isMocked = isMocked;
		return this;
	}

	/**
	 * Gets the application secret.
	 *
	 * @return the application secret
	 */
	public String getApplicationSecret() {
		return applicationSecret;
	}

	/**
	 * Gets the application key.
	 *
	 * @return the application key
	 */
	public String getApplicationKey() {
		return applicationKey;
	}

	/**
	 * Gets the exception handler.
	 *
	 * @return the exception handler
	 */
	public ExceptionHandler getExceptionHandler() {
		return errorHandler;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the tenant id.
	 *
	 * @return the tenant id
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * Gets the tenant name.
	 *
	 * @return the tenant name
	 */
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * Checks if is mocked.
	 *
	 * @return true, if is mocked
	 */
	public boolean isMocked() {
		return isMocked;
	}

}
