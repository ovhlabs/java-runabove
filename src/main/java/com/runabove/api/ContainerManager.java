package com.runabove.api;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import com.runabove.model.storage.StorageContainer;
import com.runabove.model.storage.StorageContainerCreate;
import com.runabove.model.storage.StorageContainerDetail;

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
 * The Interface ContainerManager.
 */
public interface ContainerManager {

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
	 * Gets the store container.
	 *
	 * @param containerName the container name
	 * @param limit the limit
	 * @param region the region
	 * @param start the start
	 * @return the application key
	 */
	@GET("/storage/{containerName}")
	StorageContainer getStoreContainer(@Path("containerName") String containerName, @Query("limit") int limit, @Query("region") String region,
			@Query("start") String start);

}
