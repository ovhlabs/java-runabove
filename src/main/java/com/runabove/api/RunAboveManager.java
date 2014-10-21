package com.runabove.api;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

import com.runabove.model.account.Account;
import com.runabove.model.account.Balance;
import com.runabove.model.billing.BillingProjectUse;
import com.runabove.model.image.Image;
import com.runabove.model.image.ImageDetail;
import com.runabove.model.instance.Flavor;
import com.runabove.model.instance.Instance;
import com.runabove.model.instance.InstanceAlter;
import com.runabove.model.instance.InstanceDetail;
import com.runabove.model.instance.InstanceQuota;
import com.runabove.model.instance.InstanceVNC;
import com.runabove.model.ssh.SSHKeyPair;
import com.runabove.model.ssh.SSHKeyPairDetail;
import com.runabove.model.storage.StorageContainer;
import com.runabove.model.storage.StorageContainerCreate;
import com.runabove.model.storage.StorageContainerDetail;
import com.runabove.model.token.Token;

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
 */
/**
 * The Interface RunAboveManager.
 */
public interface RunAboveManager {

	/**
	 * Time.
	 *
	 * @return the int
	 */
	@GET("/time")
	int time();

	/**
	 * Gets the instances.
	 *
	 * @return the instances
	 */
	@GET("/instance")
	Instance[] getInstances();

	/**
	 * Creates the instance.
	 *
	 * @param instanceDetail the instance detail
	 * @return the instance detail
	 */
	@POST("/instance")
	InstanceDetail createInstance(@Body InstanceDetail instanceDetail);

	/**
	 * Gets the instance quota.
	 *
	 * @param region the region
	 * @return the instance quota
	 */
	@GET("/instance/quota")
	InstanceQuota getInstanceQuota(@Query("region") String region);

	/**
	 * Gets the single instance of RunAboveManager.
	 *
	 * @param instanceId the instance id
	 * @return single instance of RunAboveManager
	 */
	@GET("/instance/{instanceId}")
	Instance getInstance(@Path("instanceId") String instanceId);

	/**
	 * Delete instance.
	 *
	 * @param instanceId the instance id
	 * @param callback the call back when an instance has been deleted
	 */
	@DELETE("/instance/{instanceId}")
	void deleteInstance(@Path("instanceId") String instanceId, Callback<Void> callback);

	/**
	 * Alter instance.
	 *
	 * @param instanceAlter the instance alter
	 */
	@PUT("/instance/{instanceId}")
	void alterInstance(InstanceAlter instanceAlter);

	/**
	 * Gets the instance vnc.
	 *
	 * @param instanceId the instance id
	 * @return the instance vnc
	 */
	@GET("/instance/{instanceId}/vnc")
	InstanceVNC getInstanceVNC(@Path("instanceId") String instanceId);

	/**
	 * Gets the flavor.
	 *
	 * @return the flavor
	 */
	@GET("/flavor")
	Flavor[] getFlavor();

	/**
	 * Gets the images.
	 *
	 * @return the images
	 */
	@GET("/image")
	Image[] getImages();

	/**
	 * Gets the image.
	 *
	 * @param imageId the image id
	 * @return the image
	 */
	@GET("/image/{imageId}")
	ImageDetail getImage(@Path("imageId") String imageId);

	/**
	 * Gets the regions.
	 *
	 * @return the regions
	 */
	@GET("/region")
	String[] getRegions();

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

	/**
	 * Gets the store containers.
	 *
	 * @return the store containers
	 */
	@GET("/storage")
	StorageContainer[] getStoreContainers();

	/**
	 * Creates the storage container.
	 *
	 * @param storageContainer the storage container
	 * @return the storage container detail
	 */
	@POST("/storage")
	StorageContainerDetail createStorageContainer(@Body StorageContainerCreate storageContainer);

	/**
	 * Gets the store container.
	 *
	 * @param containerName the container name
	 * @param region the region
	 * @return the store container
	 */
	@GET("/storage/{containerName}")
	StorageContainer getStoreContainer(@Path("containerName") String containerName, @Query("region") String region);

	/**
	 * Gets the store container detail.
	 *
	 * @param containerName the container name
	 * @param limit the limit
	 * @param region the region
	 * @param start the start
	 * @return the store container detail
	 */
	@GET("/storage/{containerName}")
	StorageContainerDetail getStoreContainerDetail(@Path("containerName") String containerName, @Query("limit") int limit, @Query("region") String region,
			@Query("start") String start);

	/**
	 * Gets the usage.
	 *
	 * @return the usage
	 */
	@GET("/me/usage")
	BillingProjectUse[] getUsage();

	/**
	 * Gets the usage.
	 *
	 * @param billed the billed
	 * @param from the from
	 * @param projectId the project id
	 * @param to the to
	 * @return the usage
	 */
	@GET("/me/usage")
	BillingProjectUse[] getUsage(@Query("billed") boolean billed, @Query("from") String from, @Query("projectId") String projectId, @Query("to") String to);

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	@GET("/me/balance")
	Balance getBalance();

	/**
	 * Me.
	 *
	 * @return the account
	 */
	@GET("/me")
	Account me();

	/**
	 * Project.
	 *
	 * @return the string[]
	 */
	@GET("/project")
	String[] project();

	/**
	 * Token.
	 *
	 * @return the token
	 */
	@GET("/token")
	Token token();
}
