package com.runabove.model.storage;

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
 * runabove storage container object
 *
 */
/**
 * The Class StorageContainer.
 */
public class StorageContainer {

	/** Container name. */
	private String name;

	/** Is container public. */
	@SerializedName("_public")
	private Boolean isPublicContainer;

	/** Instance region. */
	private String region;

	/** Total bytes stored. */
	private long stored;

	/** Number of files in container. */
	private int totalObjects;

	/** The objects. */
	private StorageContainerObject[] objects;

	/**
	 * Container name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Container name.
	 *
	 * @param containerName the new region
	 */
	public void setName(String containerName) {
		this.name = containerName;
	}

	/**
	 * Is container public.
	 *
	 * @return the public
	 */
	public Boolean getPublic() {
		return isPublicContainer;
	}

	/**
	 * Is container public.
	 *
	 * @param isPublicContainer the flag that indicate if a container is public
	 */
	public void setPublic(Boolean isPublicContainer) {
		this.isPublicContainer = isPublicContainer;
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
	 * Total bytes stored.
	 *
	 * @return the stored
	 */
	public long getStored() {
		return stored;
	}

	/**
	 * Total bytes stored.
	 *
	 * @param stored the new stored
	 */
	public void setStored(long stored) {
		this.stored = stored;
	}

	/**
	 * Number of files in container.
	 *
	 * @return the total objects
	 */
	public int getTotalObjects() {
		return totalObjects;
	}

	/**
	 * Number of files in container.
	 *
	 * @param totalFiles the new total objects
	 */
	public void setTotalObjects(int totalFiles) {
		this.totalObjects = totalFiles;
	}

	/**
	 * Sets the objects.
	 *
	 * @param files the new objects
	 */
	public void setObjects(StorageContainerObject[] files) {
		this.objects = files;
	}

	/**
	 * Gets the objects.
	 *
	 * @return the objects
	 */
	public StorageContainerObject[] getObjects() {
		return objects;
	}

}