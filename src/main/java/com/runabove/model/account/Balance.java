package com.runabove.model.account;

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
 * detail about usage and instance balance
 *
 */
/**
 * The Class Balance.
 */
public class Balance {

	/** The current usages. */
	private CurrentUsage[] currentUsages;

	/** The credit left. */
	private double creditLeft;

	/**
	 * Gets the current usages.
	 *
	 * @return the current usages
	 */
	public CurrentUsage[] getCurrentUsages() {
		return currentUsages;
	}

	/**
	 * Sets the current usages.
	 *
	 * @param currentUsages the new current usages
	 */
	public void setCurrentUsages(CurrentUsage[] currentUsages) {
		this.currentUsages = currentUsages;
	}

	/**
	 * Gets the credit left.
	 *
	 * @return the credit left
	 */
	public double getCreditLeft() {
		return creditLeft;
	}

	/**
	 * Sets the credit left.
	 *
	 * @param creditLeft the new credit left
	 */
	public void setCreditLeft(double creditLeft) {
		this.creditLeft = creditLeft;
	}

}
