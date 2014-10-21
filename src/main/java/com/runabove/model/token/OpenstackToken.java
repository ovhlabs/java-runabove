package com.runabove.model.token;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.runabove.model.storage.Catalog;

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
 * openstack token object
 *
 */
/**
 * The Class OpenstackToken.
 */
public class OpenstackToken {

	/** The catalog. */
	@Expose
	private List<Catalog> catalog = new ArrayList<Catalog>();

	/** The expires_at. */
	@Expose
	@SerializedName("expires_at")
	private String expiresAt;

	/** The issued_at. */
	@Expose
	@SerializedName("issued_at")
	private String issuedAt;

	/** The methods. */
	@Expose
	private List<String> methods = new ArrayList<String>();

	/** The project. */
	@Expose
	private TokenProject project;

	/** The roles. */
	@Expose
	private List<Role> roles = new ArrayList<Role>();

	/** The user. */
	@Expose
	private User user;

	/**
	 * Gets the catalog.
	 *
	 * @return the catalog
	 */
	public List<Catalog> getCatalog() {
		return catalog;
	}

	/**
	 * Sets the catalog.
	 *
	 * @param catalog the new catalog
	 */
	public void setCatalog(List<Catalog> catalog) {
		this.catalog = catalog;
	}

	/**
	 * Gets the expires_at.
	 *
	 * @return the expires_at
	 */
	public String getExpiresAt() {
		return expiresAt;
	}

	/**
	 * Sets the expires at.
	 *
	 * @param expiresAt the new expiresAt
	 */
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}

	/**
	 * Gets the issued at.
	 *
	 * @return the issuedAt
	 */
	public String getIssuedAt() {
		return issuedAt;
	}

	/**
	 * Sets the issued_at.
	 *
	 * @param issuedAt the new issuedAt
	 */
	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

	/**
	 * Gets the methods.
	 *
	 * @return the methods
	 */
	public List<String> getMethods() {
		return methods;
	}

	/**
	 * Sets the methods.
	 *
	 * @param methods the new methods
	 */
	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public TokenProject getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project the new project
	 */
	public void setProject(TokenProject project) {
		this.project = project;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
