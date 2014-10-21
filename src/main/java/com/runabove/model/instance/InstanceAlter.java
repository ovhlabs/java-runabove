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
 * instance modification object
 *
 */
/**
 * The Class InstanceAlter.
 */
public class InstanceAlter {

	/** The flavor id. */
	private String flavorId;

	/** The image id. */
	private String imageId;

	/** The name. */
	private String name;

	/** The region. */
	private String region;

	/** The ssh key name. */
	private String sshKeyName;

	/**
	 * Gets the flavor id.
	 *
	 * @return the flavor id
	 */
	public String getFlavorId() {
		return flavorId;
	}

	/**
	 * Sets the flavor id.
	 *
	 * @param flavorId the new flavor id
	 */
	public void setFlavorId(String flavorId) {
		this.flavorId = flavorId;
	}

	/**
	 * Gets the image id.
	 *
	 * @return the image id
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * Sets the image id.
	 *
	 * @param imageId the new image id
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param region the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Gets the ssh key name.
	 *
	 * @return the ssh key name
	 */
	public String getSshKeyName() {
		return sshKeyName;
	}

	/**
	 * Sets the ssh key name.
	 *
	 * @param sshKeyName the new ssh key name
	 */
	public void setSshKeyName(String sshKeyName) {
		this.sshKeyName = sshKeyName;
	}

}
