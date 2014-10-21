package com.runabove.api;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

import com.runabove.model.instance.Instance;
import com.runabove.model.instance.InstanceAlter;
import com.runabove.model.instance.InstanceDetail;
import com.runabove.model.instance.InstanceQuota;
import com.runabove.model.instance.InstanceVNC;

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
 * The Interface InstanceManager.
 */
public interface InstanceManager {

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
	 */
	@POST("/instance")
	void createInstance(InstanceDetail instanceDetail);

	/**
	 * Gets the instance quota.
	 *
	 * @param region the region
	 * @return the instance quota
	 */
	@GET("/instance/quota")
	InstanceQuota getInstanceQuota(@Query("region") String region);

	/**
	 * Gets the single instance of InstanceManager.
	 *
	 * @param instanceId the instance id
	 * @return single instance of InstanceManager
	 */
	@GET("/instance/{instanceId}")
	Instance getInstance(@Path("instanceId") String instanceId);

	/**
	 * Delete instance.
	 *
	 * @param instanceId the instance id
	 */
	@DELETE("/instance/{instanceId}")
	void deleteInstance(@Path("instanceId") String instanceId);

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

}
