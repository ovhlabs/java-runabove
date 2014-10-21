package com.runabove.model.auth;

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
 * All states a Credential can be in
 * 
 */
/**
 * The Enum CredentialStateEnum.
 */
public enum CredentialStateEnum {

	/** The expired. */
	EXPIRED("expired"), /** The String get value(). */
	PENDING_VALIDATION("pendingValidation"), /** The refused. */
	REFUSED("refused"), /** The validated. */
	VALIDATED("validated");

	/** The value. */
	private final String value;

	/**
	 * Instantiates a new credential state enum.
	 *
	 * @param value the value
	 */
	CredentialStateEnum(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.value;
	}

	/**
	 * Parses the.
	 *
	 * @param value the value
	 * @return the credential state enum
	 */
	public static CredentialStateEnum parse(String value) {
		for (CredentialStateEnum item : CredentialStateEnum.values()) {
			if (String.valueOf(item.value).equalsIgnoreCase(value)) {
				return item;
			}
		}
		throw new IllegalArgumentException(value + " is not a valid value");
	}

}
