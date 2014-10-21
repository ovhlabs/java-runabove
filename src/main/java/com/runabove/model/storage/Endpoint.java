package com.runabove.model.storage;

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
 * endpoint object 
 *
 */
/**
 * The Class Endpoint.
 */
public class Endpoint {

	/** The id. */
	@Expose
	private String id;

	/** The _interface. */
	@SerializedName("interface")
	@Expose
	private String interfaceEndpoint;

	/** The legacy_endpoint_id. */
	@SerializedName("legacy_endpoint_id")
	@Expose
	private String legacyEndpointId;

	/** The region. */
	@Expose
	private String region;

	/** The url. */
	@Expose
	private String url;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the interface.
	 * 
	 * @return the interface
	 */
	public String getInterface() {
		return interfaceEndpoint;
	}

	/**
	 * Sets the interface.
	 * 
	 * @param interfaceEndpoint
	 *            the new interface endpoint
	 */
	public void setInterface(String interfaceEndpoint) {
		this.interfaceEndpoint = interfaceEndpoint;
	}

	/**
	 * Gets the legacy_endpoint_id.
	 * 
	 * @return the legacy_endpoint_id
	 */
	public String getLegacyEndpointId() {
		return legacyEndpointId;
	}

	/**
	 * Sets the legacy_endpoint_id.
	 * 
	 * @param legacyEndpointId
	 *            the new legacy_endpoint_id
	 */
	public void setLegacyEndpointIid(String legacyEndpointId) {
		this.legacyEndpointId = legacyEndpointId;
	}

	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Sets the region.
	 * 
	 * @param region
	 *            the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}