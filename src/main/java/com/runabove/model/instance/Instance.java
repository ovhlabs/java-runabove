package com.runabove.model.instance;

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
 * instance object
 *
 */
/**
 * The Class Instance.
 */
public class Instance {

	/** Instance creation date. */
	private String created;

	/** Instance flavor id. */
	private String flavorId;

	/** Instance image id. */
	private String imageId;

	/** Instance id. */
	private String instanceId;

	/** Main IPv4. */
	private String ip;

	/** Instance name. */
	private String name;

	/** Instance region. */
	private String region;

	/** Instance status. */
	private String status;

	/**
	 * Instance creation date.
	 *
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Instance creation date.
	 *
	 * @param created the new created
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Instance flavor id.
	 *
	 * @return the flavor id
	 */
	public String getFlavorId() {
		return flavorId;
	}

	/**
	 * Instance flavor id.
	 *
	 * @param flavorId the new flavor id
	 */
	public void setFlavorId(String flavorId) {
		this.flavorId = flavorId;
	}

	/**
	 * Instance image id.
	 *
	 * @return the image id
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * Instance image id.
	 *
	 * @param imageId the new image id
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	/**
	 * Instance id.
	 *
	 * @return the instance id
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * Instance id.
	 *
	 * @param instanceId the new instance id
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * Main IPv4.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Main IPv4.
	 *
	 * @param ip the new ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Instance name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Instance name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Instance region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Instance region.
	 *
	 * @param region the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Instance status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Instance status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}