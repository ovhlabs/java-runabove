package com.runabove.model.billing;

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
 *
 * project details billing informations
 *
 */
/**
 * The Class BillingProjectDetails.
 */
public class BillingProjectDetails {

	/** Details about your storage usage in bytes. */
	private long storageDetails;

	/** Bandwidth instance details. */
	private BillingBandwidthInstanceDetails[] bandwidthInstanceDetails;
	/**
	 * Instances price (micro $). Null if not computed yet
	 * 
	 */
	private long instance;
	/**
	 * Bandwidth storage price (micro $). Null if not computed yet
	 * 
	 */
	private long bandwidthStorage;

	/** Details about your bandwidth storage usage in bytes. */
	private long bandwidthStorageDetails;

	/** Date to (excluded). */
	private String to;
	/**
	 * Bandwidth instance price (micro $). Null if not computed yet
	 * 
	 */
	private long bandwidthInstance;

	/** Details about your instances running. */
	private BillingInstanceDetails[] instanceDetails;

	/** Date from (included). */
	private String from;
	/**
	 * Storage price (micro $). Null if not computed yet
	 * 
	 */
	private long storage;

	/** Is entry already billed. */
	private Boolean isBilled;

	/**
	 * Details about your storage usage in bytes.
	 *
	 * @return the storage details
	 */
	public long getStorageDetails() {
		return storageDetails;
	}

	/**
	 * Details about your storage usage in bytes.
	 *
	 * @param storageDetails the new storage details
	 */
	public void setStorageDetails(long storageDetails) {
		this.storageDetails = storageDetails;
	}

	/**
	 * Bandwidth instance details.
	 *
	 * @return the bandwidth instance details
	 */
	public BillingBandwidthInstanceDetails[] getBandwidthInstanceDetails() {
		return bandwidthInstanceDetails;
	}

	/**
	 * Bandwidth instance details.
	 *
	 * @param bandwidthInstanceDetails the new bandwidth instance details
	 */
	public void setBandwidthInstanceDetails(BillingBandwidthInstanceDetails[] bandwidthInstanceDetails) {
		this.bandwidthInstanceDetails = bandwidthInstanceDetails;
	}

	/**
	 * Instances price (micro $). Null if not computed yet
	 *
	 * @return single instance of BillingProjectDetails
	 */
	public long getInstance() {
		return instance;
	}

	/**
	 * Instances price (micro $). Null if not computed yet
	 *
	 * @param instance the new instance
	 */
	public void setInstance(long instance) {
		this.instance = instance;
	}

	/**
	 * Bandwidth storage price (micro $). Null if not computed yet
	 *
	 * @return the bandwidth storage
	 */
	public long getBandwidthStorage() {
		return bandwidthStorage;
	}

	/**
	 * Bandwidth storage price (micro $). Null if not computed yet
	 *
	 * @param bandwidthStorage the new bandwidth storage
	 */
	public void setBandwidthStorage(long bandwidthStorage) {
		this.bandwidthStorage = bandwidthStorage;
	}

	/**
	 * Details about your bandwidth storage usage in bytes.
	 *
	 * @return the bandwidth storage details
	 */
	public long getBandwidthStorageDetails() {
		return bandwidthStorageDetails;
	}

	/**
	 * Details about your bandwidth storage usage in bytes.
	 *
	 * @param bandwidthStorageDetails the new bandwidth storage details
	 */
	public void setBandwidthStorageDetails(long bandwidthStorageDetails) {
		this.bandwidthStorageDetails = bandwidthStorageDetails;
	}

	/**
	 * Date to (excluded).
	 *
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Date to (excluded).
	 *
	 * @param to the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Bandwidth instance price (micro $). Null if not computed yet
	 *
	 * @return the bandwidth instance
	 */
	public long getBandwidthInstance() {
		return bandwidthInstance;
	}

	/**
	 * Bandwidth instance price (micro $). Null if not computed yet
	 *
	 * @param bandwidthInstance the new bandwidth instance
	 */
	public void setBandwidthInstance(long bandwidthInstance) {
		this.bandwidthInstance = bandwidthInstance;
	}

	/**
	 * Details about your instances running.
	 *
	 * @return the instance details
	 */
	public BillingInstanceDetails[] getInstanceDetails() {
		return instanceDetails;
	}

	/**
	 * Details about your instances running.
	 *
	 * @param instanceDetails the new instance details
	 */
	public void setInstanceDetails(BillingInstanceDetails[] instanceDetails) {
		this.instanceDetails = instanceDetails;
	}

	/**
	 * Date from (included).
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Date from (included).
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Storage price (micro $). Null if not computed yet
	 *
	 * @return the storage
	 */
	public long getStorage() {
		return storage;
	}

	/**
	 * Storage price (micro $). Null if not computed yet
	 *
	 * @param storage the new storage
	 */
	public void setStorage(long storage) {
		this.storage = storage;
	}

	/**
	 * Is entry already billed.
	 *
	 * @return the checks if is billed
	 */
	public Boolean getIsBilled() {
		return isBilled;
	}

	/**
	 * Is entry already billed.
	 *
	 * @param isBilled the new checks if is billed
	 */
	public void setIsBilled(Boolean isBilled) {
		this.isBilled = isBilled;
	}

}