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
 * default credential utility class
 *
 */
/**
 * The Class DefaultCredentialParams.
 */
public class DefaultCredentialParams extends CredentialParams {

	/**
	 * Instantiates a new default credential params.
	 */
	public DefaultCredentialParams() {

		// create an array of access rules
		AccessRule[] ar = new AccessRule[3];

		// create a lonely access rule that want everything and put it in the array
		AccessRule accessRulesGet = new AccessRule();
		accessRulesGet.setMethod(MethodEnum.GET);
		accessRulesGet.setPath("/*");
		ar[0] = accessRulesGet;

		AccessRule accessRulesPost = new AccessRule();
		accessRulesPost.setMethod(MethodEnum.POST);
		accessRulesPost.setPath("/*");
		ar[1] = accessRulesPost;

		AccessRule accessRulesDelete = new AccessRule();
		accessRulesDelete.setMethod(MethodEnum.DELETE);
		accessRulesDelete.setPath("/*");
		ar[2] = accessRulesDelete;
		setAccessRules(ar);

		String redirection = "";
		setRedirection(redirection);

	}

}
