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
 * storage container detail object
 *
 */
/**
 * The Class StorageContainerDetail.
 */
public class StorageContainerDetail {

	/** Files stored in container. */
	private StorageContainerObject[] objects;

	/** Container name. */
	private String name;

	/** Total bytes stored. */
	private int stored;

	/** Total files stored. */
	private int totalObjects;

	/**
	 * Files stored in container.
	 *
	 * @return the files
	 */
	public StorageContainerObject[] getFiles() {
		return objects;
	}

	/**
	 * Files stored in container.
	 *
	 * @param files the new files
	 */
	public void setFiles(StorageContainerObject[] files) {
		this.objects = files;
	}

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
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Total bytes stored.
	 *
	 * @return the stored
	 */
	public Object getStored() {
		return stored;
	}

	/**
	 * Total bytes stored.
	 *
	 * @param stored the new stored
	 */
	public void setStored(int stored) {
		this.stored = stored;
	}

	/**
	 * Total files stored.
	 *
	 * @return the total objects
	 */
	public int getTotalObjects() {
		return totalObjects;
	}

	/**
	 * Total files stored.
	 *
	 * @param totalFiles the new total objects
	 */
	public void setTotalObjects(int totalFiles) {
		this.totalObjects = totalFiles;
	}

}