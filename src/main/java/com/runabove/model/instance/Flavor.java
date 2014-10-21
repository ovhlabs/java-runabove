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
 * instance flavor object
 *
 */
/**
 * The Class Flavor.
 */
public class Flavor {

	/** Number of disks. */
	private int disk;

	/** Flavor unique id. */
	private String id;

	/** Flavor name. */
	private String name;

	/** RAM quantity (Gio). */
	private int ram;

	/** Flavor region. */
	private String region;

	/** Number of VCPUs. */
	private int vcpus;

	/**
	 * Number of disks.
	 *
	 * @return the disk
	 */
	public int getDisk() {
		return disk;
	}

	/**
	 * Number of disks.
	 *
	 * @param disk the new disk
	 */
	public void setDisk(int disk) {
		this.disk = disk;
	}

	/**
	 * Flavor unique id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Flavor unique id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Flavor name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Flavor name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * RAM quantity (Gio).
	 *
	 * @return the ram
	 */
	public int getRam() {
		return ram;
	}

	/**
	 * RAM quantity (Gio).
	 *
	 * @param ram the new ram
	 */
	public void setRam(int ram) {
		this.ram = ram;
	}

	/**
	 * Flavor region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Flavor region.
	 *
	 * @param region the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Number of VCPUs.
	 *
	 * @return the vcpus
	 */
	public int getVcpus() {
		return vcpus;
	}

	/**
	 * Number of VCPUs.
	 *
	 * @param vcpus the new vcpus
	 */
	public void setVcpus(int vcpus) {
		this.vcpus = vcpus;
	}

}