package com.runabove;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.javaswift.joss.client.mock.StoredObjectMock;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runabove.api.RunAboveBuilder;
import com.runabove.api.RunAboveConfig;
import com.runabove.error.LoggerErrorHandler;

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
 * Test for runabove api linked with JOSS library
 * 
 * 
 */
/**
 * The Class SwiftTest.
 */
public class SwiftTest {

	/** The Constant void setEndpoints(List<Endpoint> endpoints). */
	private static final Logger LOG = LoggerFactory.getLogger(ApiTest.class);

	/** The login. */
	private static String login = null;

	/** The password. */
	private static String password = null;

	/** The upload bytes. */
	private byte[] uploadBytes = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08 };

	/** The downloaded file. */
	private File downloadedFile = new File("download.tmp");

	/**
	 * Test openstack list.
	 */
	@Test
	public void testOpenstackList() {

		// if no tenant name are provided joss will try to auto discover
		RunAboveConfig config = new RunAboveConfig().setErrorHandlder(new LoggerErrorHandler()).setLogin(login).setPassword(password).setMocked(true);

		Account runAboveSwift = new RunAboveBuilder(config).createSwiftManager();
		assertNotNull(runAboveSwift);

		// ensure there is at least one container
		Container container = runAboveSwift.getContainer("town1");
		container.create();
		assertTrue(container.exists());

		// now let's play into these containers and insert one obejct
		StoredObjectMock object = new StoredObjectMock(container, "someObject");
		byte[] bytes = new byte[] { 0x01, 0x02, 0x03 };
		object.uploadObject(bytes);

		// and list...
		Collection<Container> containers = runAboveSwift.list();
		for (Container currentContainer : containers) {
			LOG.info(currentContainer.getName());
			ArrayList<StoredObject> so = (ArrayList<StoredObject>) currentContainer.list();
			for (StoredObject storedObject : so) {
				LOG.info("so name ------------- ");
				LOG.info("so name getBareName " + storedObject.getBareName());
				LOG.info("so name getContentLength " + storedObject.getContentLength());
				LOG.info("so name getContentLength " + storedObject.getContentLength());
				LOG.info("so name getContentType " + storedObject.getContentType());
				LOG.info("so name getEtag " + storedObject.getEtag());
				LOG.info("so name getLastModified " + storedObject.getLastModified());
				LOG.info("so name getName " + storedObject.getName());
				LOG.info("so name getPath " + storedObject.getPath());
				LOG.info("so name getURL " + storedObject.getURL());

			}
		}
	}

	/**
	 * Test open stack write.
	 */
	@Test
	public void testOpenStackWrite() {
		RunAboveConfig config = new RunAboveConfig().setErrorHandlder(new LoggerErrorHandler()).setLogin(login).setPassword(password).setMocked(true);

		Account runAboveSwift = new RunAboveBuilder(config).createSwiftManager();
		assertNotNull(runAboveSwift);

		// ensure there is at least one container
		Container container = runAboveSwift.getContainer("town1");
		container.create();
		assertTrue(container.exists());

		Collection<Container> containers = runAboveSwift.list();
		assertNotNull(containers);

		// lets play with the first container
		Container currentContainer = containers.iterator().next();
		assertNotNull(currentContainer);
		
		LOG.info(currentContainer.getName());
		// now let's play into these containers and insert objects and downloads and compare
		StoredObjectMock object = new StoredObjectMock(currentContainer, "someObject");
		byte[] bytes = new byte[] { 0x01, 0x02, 0x03 };
		object.uploadObject(bytes);

		object.uploadObject(uploadBytes);
		object.downloadObject(downloadedFile);
		object.delete();
		object.uploadObject(downloadedFile);
		assertTrue(Arrays.equals(uploadBytes, object.downloadObject()));

		LOG.info("Public URL: " + object.getPublicURL());

	}

}
