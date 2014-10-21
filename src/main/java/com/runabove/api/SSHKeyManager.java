package com.runabove.api;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import com.runabove.model.ssh.SSHKeyPair;
import com.runabove.model.ssh.SSHKeyPairDetail;

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

 * SSHkey manager

 *
 */
/**
 * The Interface void setCores(int cores).
 */
public interface SSHKeyManager {

	/**
	 * Gets the SSH key pairs.
	 *
	 * @return the SSH key pairs
	 */
	@GET("/ssh")
	SSHKeyPair[] getSSHKeyPairs();

	/**
	 * Creates the ssh key pair.
	 *
	 * @param sshKeyPair the ssh key pair
	 */
	@POST("/ssh")
	void createSSHKeyPair(SSHKeyPairDetail sshKeyPair);

	/**
	 * Gets the SSH key pair.
	 *
	 * @param name the name
	 * @return the SSH key pair
	 */
	@GET("/ssh/{name}")
	SSHKeyPair getSSHKeyPair(@Path("name") String name);

	/**
	 * Delete ssh key pair.
	 *
	 * @param name the name
	 */
	@DELETE("/ssh/{name}")
	void deleteSSHKeyPair(@Path("name") String name);

}
