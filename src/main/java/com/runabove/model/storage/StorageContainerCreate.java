package com.runabove.model.storage;

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
 * storage container creation object
 *
 */
/**
 * The Class StorageContainerCreate.
 */
public class StorageContainerCreate {

	/** Container name. */
	private String containerName;

	/** Instance region. */
	private String containerRegion;

	/**
	 * Gets the container name.
	 *
	 * @return the container name
	 */
	public String getContainerName() {
		return containerName;
	}

	/**
	 * Sets the container name.
	 *
	 * @param containerName the new container name
	 */
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	/**
	 * Gets the container region.
	 *
	 * @return the region
	 */
	public String getContainerRegion() {
		return containerRegion;
	}

	/**
	 * Sets the container region.
	 *
	 * @param containerRegion the new container region
	 */
	public void setContainerRegion(String containerRegion) {
		this.containerRegion = containerRegion;
	}
}
