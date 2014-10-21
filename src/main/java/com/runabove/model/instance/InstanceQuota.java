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
 * instance quota information
 *
 */
/**
 * The Class InstanceQuota.
 */
public class InstanceQuota {

	/** Total cores allowed to create instances. */
	private int cores;

	/** Max instances allowed. */
	private int instances;

	/** Max keypairs allowed. */
	private int keypairs;

	/** Total RAM allowed to create instances. */
	private int ram;

	/** Max security groups allowed. */
	private int securityGroups;

	/**
	 * Total cores allowed to create instances.
	 *
	 * @return the cores
	 */
	public int getCores() {
		return cores;
	}

	/**
	 * Total cores allowed to create instances.
	 *
	 * @param cores the new cores
	 */
	public void setCores(int cores) {
		this.cores = cores;
	}

	/**
	 * Max instances allowed.
	 *
	 * @return the instances
	 */
	public int getInstances() {
		return instances;
	}

	/**
	 * Max instances allowed.
	 *
	 * @param instances the new instances
	 */
	public void setInstances(int instances) {
		this.instances = instances;
	}

	/**
	 * Max keypairs allowed.
	 *
	 * @return the keypairs
	 */
	public int getKeypairs() {
		return keypairs;
	}

	/**
	 * Max keypairs allowed.
	 *
	 * @param keypairs the new keypairs
	 */
	public void setKeypairs(int keypairs) {
		this.keypairs = keypairs;
	}

	/**
	 * Total RAM allowed to create instances.
	 *
	 * @return the ram
	 */
	public int getRam() {
		return ram;
	}

	/**
	 * Total RAM allowed to create instances.
	 *
	 * @param ram the new ram
	 */
	public void setRam(int ram) {
		this.ram = ram;
	}

	/**
	 * Max security groups allowed.
	 *
	 * @return the security groups
	 */
	public int getSecurityGroups() {
		return securityGroups;
	}

	/**
	 * Max security groups allowed.
	 *
	 * @param securityGroups the new security groups
	 */
	public void setSecurityGroups(int securityGroups) {
		this.securityGroups = securityGroups;
	}

}