package com.runabove.model.instance;

import com.runabove.model.image.Image;
import com.runabove.model.ssh.SSHKeyPair;

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
 * instance detail object
 *
 */
/**
 * The Class InstanceDetail.
 */
public class InstanceDetail {

	/** Instance creation date. */
	private String created;

	/** Instance flavor. */
	private Flavor flavor;

	/** Instance image. */
	private Image image;

	/** Instance id. */
	private String instanceId;

	/** Instance IPs. */
	private InstanceIP[] ips;

	/** Instance main IPv4. */
	private String ipv4;

	/** Instance name. */
	private String name;

	/** Instance region. */
	private String region;

	/** SSH keypair. */
	private SSHKeyPair sshKey;

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
	 * Instance flavor.
	 *
	 * @return the flavor
	 */
	public Flavor getFlavor() {
		return flavor;
	}

	/**
	 * Instance flavor.
	 *
	 * @param flavor the new flavor
	 */
	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	/**
	 * Instance image.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Instance image.
	 *
	 * @param image the new image
	 */
	public void setImage(Image image) {
		this.image = image;
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
	 * Instance IPs.
	 *
	 * @return the ips
	 */
	public InstanceIP[] getIps() {
		return ips;
	}

	/**
	 * Instance IPs.
	 *
	 * @param ips the new ips
	 */
	public void setIps(InstanceIP[] ips) {
		this.ips = ips;
	}

	/**
	 * Instance main IPv4.
	 *
	 * @return the ipv4
	 */
	public String getIpv4() {
		return ipv4;
	}

	/**
	 * Instance main IPv4.
	 *
	 * @param ipv4 the new ipv4
	 */
	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
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
	 * SSH keypair.
	 *
	 * @return the ssh key
	 */
	public SSHKeyPair getSshKey() {
		return sshKey;
	}

	/**
	 * SSH keypair.
	 *
	 * @param sshKey the new ssh key
	 */
	public void setSshKey(SSHKeyPair sshKey) {
		this.sshKey = sshKey;
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