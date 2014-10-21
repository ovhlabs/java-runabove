package com.runabove;

import static org.junit.Assert.assertNotNull;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.runabove.api.AccountManager;
import com.runabove.api.AuthManager;
import com.runabove.api.ContainerManager;
import com.runabove.api.FlavorManager;
import com.runabove.api.ImageManager;
import com.runabove.api.InstanceManager;
import com.runabove.api.RegionManager;
import com.runabove.api.RunAboveBuilder;
import com.runabove.api.RunAboveConfig;
import com.runabove.api.RunAboveManager;
import com.runabove.api.SSHKeyManager;
import com.runabove.error.LoggerErrorHandler;
import com.runabove.model.account.Account;
import com.runabove.model.account.Balance;
import com.runabove.model.account.CurrentUsage;
import com.runabove.model.auth.AccessRule;
import com.runabove.model.auth.Credential;
import com.runabove.model.auth.CredentialParams;
import com.runabove.model.auth.DefaultCredentialParams;
import com.runabove.model.billing.BillingBandwidthInstanceDetails;
import com.runabove.model.billing.BillingInstanceDetails;
import com.runabove.model.billing.BillingProjectDetails;
import com.runabove.model.billing.BillingProjectUse;
import com.runabove.model.image.Image;
import com.runabove.model.image.ImageDetail;
import com.runabove.model.instance.Flavor;
import com.runabove.model.instance.Instance;
import com.runabove.model.instance.InstanceAlter;
import com.runabove.model.instance.InstanceDetail;
import com.runabove.model.instance.InstanceIP;
import com.runabove.model.instance.InstanceQuota;
import com.runabove.model.instance.InstanceVNC;
import com.runabove.model.ssh.SSHKeyPair;
import com.runabove.model.ssh.SSHKeyPairDetail;
import com.runabove.model.storage.Catalog;
import com.runabove.model.storage.Endpoint;
import com.runabove.model.storage.StorageContainer;
import com.runabove.model.storage.StorageContainerCreate;
import com.runabove.model.storage.StorageContainerDetail;
import com.runabove.model.storage.StorageContainerObject;
import com.runabove.model.token.Domain;
import com.runabove.model.token.OpenstackToken;
import com.runabove.model.token.Role;
import com.runabove.model.token.Token;
import com.runabove.model.token.TokenProject;
import com.runabove.model.token.User;

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
 * The Class ApiTest.
 */
public class ApiTest extends AbstractPojoTester {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ApiTest.class);

	

	/**
	 * Test generic builder.
	 */
	@Test
	public void testGenericBuilder() {
		// create a runabove auth api
		AuthManager runAboveAuth = new RunAboveBuilder(getConfig()).createAuthManager();
		assertNotNull(runAboveAuth);

		// create a runabove api
		RunAboveManager runAbove = new RunAboveBuilder(getConfig()).createManager(new MockClient());
		assertNotNull(runAbove);

	}

	/**
	 * Test auth.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testAuth() throws IOException {
		// create a runabove auth api
		AuthManager runAboveAuth = new RunAboveBuilder(getConfig()).createAuthManager(new MockAuthClient());
		assertNotNull(runAboveAuth);

		// everything is merged into a credential params so retrofit can autoconvert it into json (see jake wharton SO answer about it)
		Credential creds = runAboveAuth.credential(new DefaultCredentialParams());

		// we can get the consumer key
		assertNotNull(creds);
		assertNotNull(creds.getConsumerKey());
	}

	
	/**
	 * Test login and me.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testLoginAndMe() throws IOException {
		// create a runabove api
		RunAboveManager runAboveApi = new RunAboveBuilder(getConfig()).createManager(new MockClient());
		assertNotNull(runAboveApi);

		// get my account
		Account account = runAboveApi.me();
		assertNotNull(account);
		assertNotNull(account.getEmail());
		LOG.info("Account getEmail=" + account.getEmail());
		LOG.info("Account getAccountIdentifier=" + account.getAccountIdentifier());
		LOG.info("Account getName=" + account.getName());
		LOG.info("Account getFirstname=" + account.getFirstname());
		LOG.info("Account getCellNumber=" + account.getCellNumber());
		LOG.info("Account getAddress=" + account.getAddress());
		LOG.info("Account getPostalCode=" + account.getPostalCode());
		LOG.info("Account getCity=" + account.getCity());
		LOG.info("Account getArea=" + account.getArea());
		LOG.info("Account getCountry=" + account.getCountry());

	}

	/**
	 * Test projects.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testProjects() throws IOException {
		RunAboveManager runAboveApi = login();

		String[] projects = runAboveApi.project();
		assertNotNull(projects);
		for (int i = 0; i < projects.length; i++) {
			LOG.info("PROJECTS  " + projects[i]);
		}
	}

	/**
	 * Test token.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testToken() throws IOException {

		RunAboveManager runAboveApi = login();

		// request a token for openstack swift from the api (this can also directly asked to keystone)
		Token toekn = runAboveApi.token();
		assertNotNull(toekn); 
		LOG.info("XAUTH TOEKN = " + toekn.getXAuthToken());
		
		List<Catalog> catalogues = toekn.getToken().getCatalog();
		assertNotNull(catalogues); 
		for (Catalog catalog : catalogues) {
			if ("object-store".equals(catalog.getType())) {
				for (Endpoint ep : catalog.getEndpoints()) {
					LOG.info("Store id " + ep.getId());
					LOG.info("Store interface " + ep.getInterface());
					LOG.info("Store region " + ep.getRegion());
					LOG.info("Store url " + ep.getUrl());
				}
			}
		}
	}


	/**
	 * Test create instance.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testCreateInstance() throws IOException {
		RunAboveManager runAboveApi = login();
		InstanceDetail instanceDetail = new InstanceDetail();

		// get a flavor
		Flavor[] flavors = runAboveApi.getFlavor();
		instanceDetail.setFlavor(flavors[0]);

		// get a region
		String[] regions = runAboveApi.getRegions();
		instanceDetail.setRegion(regions[0]);

		// get an image
		Image[] imgs = runAboveApi.getImages();
		instanceDetail.setImage(imgs[0]);

		// create an instance
		InstanceDetail resultInstance = runAboveApi.createInstance(instanceDetail);

		// list all the instances
		Instance[] listInstances = runAboveApi.getInstances();
		assertNotNull(listInstances);
		for (Instance instance : listInstances) {
			LOG.info("instance id " + instance.getInstanceId());
			LOG.info("instance name " + instance.getName());
		}

		runAboveApi.deleteInstance(resultInstance.getInstanceId(), new Callback<Void>() {
			public void failure(RetrofitError arg0) {
				LOG.info("instance deletion failed");
			}

			public void success(Void arg0, Response arg1) {
				LOG.info("instance deletion successful");
			}
		});

	}

	/**
	 * Test images.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testImages() throws IOException {

		RunAboveManager runAboveApi = login();

		// get all available images
		Image[] imgs = runAboveApi.getImages();
		assertNotNull(imgs);
		for (Image image : imgs) {
			LOG.info("image id " + image.getId());
			LOG.info("image name " + image.getName());
			LOG.info("image region " + image.getRegion());
		}
	}

	/**
	 * Test image detail.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testImageDetail() throws IOException {
		RunAboveManager runAboveApi = login();
		// get all available images
		Image[] imgs = runAboveApi.getImages();
		assertNotNull(imgs);
		for (Image image : imgs) {
			ImageDetail imageDetail = runAboveApi.getImage(image.getId());
			LOG.info("imageDetail id " + imageDetail.getId());
			LOG.info("imageDetail name " + imageDetail.getName());
			LOG.info("imageDetail region " + imageDetail.getRegion());
			LOG.info("imageDetail creation date " + imageDetail.getCreationDate());
			LOG.info("imageDetail mindisk " + imageDetail.getMinDisk());
			LOG.info("imageDetail minram " + imageDetail.getMinRam());
			LOG.info("imageDetail status " + imageDetail.getStatus());

		}
	}

	/**
	 * Test instances.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testInstances() throws IOException {

		RunAboveManager runAboveApi = login();

		String[] regions = runAboveApi.getRegions();
		assertNotNull(regions);

		String firstRegion = regions[0];
		assertNotNull(firstRegion);

		// get instance quota
		InstanceQuota instanceQuota = runAboveApi.getInstanceQuota(firstRegion);
		LOG.info("InstanceQuota getCores " + instanceQuota.getCores());
		LOG.info("InstanceQuota getInstances " + instanceQuota.getInstances());
		LOG.info("InstanceQuota getKeypairs " + instanceQuota.getKeypairs());
		LOG.info("InstanceQuota getRam " + instanceQuota.getRam());
		LOG.info("InstanceQuota getSecurityGroups " + instanceQuota.getSecurityGroups());

		// get all available instances
		Instance[] instances = runAboveApi.getInstances();
		assertNotNull(instances);
		for (Instance instance : instances) {
			LOG.info("instance getCreated " + instance.getCreated());
			LOG.info("instance getFlavorId " + instance.getFlavorId());
			LOG.info("instance getImageId " + instance.getImageId());
			LOG.info("instance getInstanceId " + instance.getInstanceId());
			LOG.info("instance getIp " + instance.getIp());
			LOG.info("instance getName " + instance.getName());
			LOG.info("instance getRegion " + instance.getRegion());
			LOG.info("instance getStatus " + instance.getStatus());

			Instance instanceDetail = runAboveApi.getInstance(instance.getInstanceId());
			assertNotNull(instanceDetail);
			LOG.info("instanceDetail getInstanceId " + instanceDetail.getInstanceId());

			InstanceVNC instanceVNC = runAboveApi.getInstanceVNC(instance.getInstanceId());
			assertNotNull(instanceVNC);
			LOG.info("instanceVNC getType " + instanceVNC.getType());
			LOG.info("instanceVNC getUrl " + instanceVNC.getUrl());
		}
	}

	/**
	 * Test regions.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testRegions() throws IOException {

		RunAboveManager runAboveApi = login();

		// get all available regions
		String[] regions = runAboveApi.getRegions();
		assertNotNull(regions);
		for (String string : regions) {
			LOG.info("Regions " + string);
		}
	}

	/**
	 * Test balance usage.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testBalanceUsage() throws IOException {

		RunAboveManager runAboveApi = login();

		// get all available billing info
		BillingProjectUse[] uses = runAboveApi.getUsage(true, "2014-04-19", null, "2014-04-19");
		assertNotNull(uses);
		for (BillingProjectUse billingProjectUse : uses) {

			LOG.info("BillingProjectUse project id " + billingProjectUse.getProjectId());
			LOG.info("BillingProjectUse region " + billingProjectUse.getRegion());
			for (BillingProjectDetails details : billingProjectUse.getDetails()) {
				LOG.info("Details getBandwidthInstance " + details.getBandwidthInstance());
				LOG.info("Details " + details.getBandwidthStorage());
				LOG.info("Details " + details.getBandwidthStorageDetails());
				LOG.info("Details " + details.getFrom());
				LOG.info("Details " + details.getInstance());
				LOG.info("Details " + details.getStorage());
				LOG.info("Details " + details.getStorageDetails());
				LOG.info("Details " + details.getTo());

				for (BillingBandwidthInstanceDetails bwdetail : details.getBandwidthInstanceDetails()) {
					LOG.info("Detaisl BW Id " + bwdetail.getId());
					LOG.info("Detaisl BW Quantity " + bwdetail.getQuantity());
				}
			}
		}

		Balance balance = runAboveApi.getBalance();
		assertNotNull(balance);
		LOG.info("balance " + balance.getCreditLeft());
		if (balance.getCurrentUsages() != null) {
			for (CurrentUsage usage : balance.getCurrentUsages()) {
				LOG.info("balance usage " + usage.getProjectId());
				LOG.info("balance usage " + usage.getCurrentTotal());
			}
		}

	}

	// ssh
	/**
	 * Test ssh.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testSSH() throws IOException {
		RunAboveManager runAboveApi = login();
		SSHKeyPair[] sshKeyPair = runAboveApi.getSSHKeyPairs();
		assertNotNull(sshKeyPair);
		for (SSHKeyPair ssh : sshKeyPair) {
			LOG.info("SSHKeyPair getFingerPrint " + ssh.getFingerPrint());
			LOG.info("SSHKeyPair getName " + ssh.getName());
			LOG.info("SSHKeyPair getPublicKey " + ssh.getPublicKey());
			LOG.info("SSHKeyPair getRegion " + ssh.getRegion());
		}
	}

	// storage
	/**
	 * Test storage get.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testStorageGet() throws IOException {

		RunAboveManager runAboveApi = login();

		// get all available files in a storage container
		StorageContainer[] containers = runAboveApi.getStoreContainers();
		assertNotNull(containers); 
		for (StorageContainer storageContainer : containers) {

			LOG.info("StorageContainer getContainerName " + storageContainer.getName());
			LOG.info("StorageContainer getRegion " + storageContainer.getRegion());
			LOG.info("StorageContainer getStored " + storageContainer.getStored());
			LOG.info("StorageContainer getPublic " + storageContainer.getPublic());
			LOG.info("StorageContainer getRegion " + storageContainer.getRegion());
			LOG.info("StorageContainer getTotalFiles " + storageContainer.getTotalObjects());

			StorageContainerDetail detail = runAboveApi.getStoreContainerDetail(storageContainer.getName(), 10, storageContainer.getRegion(), null);
			assertNotNull(detail);
			if (detail.getFiles() != null) {
				for (StorageContainerObject file : detail.getFiles()) {
					LOG.info("StorageContainerFile getContentType " + file.getContentType());
					LOG.info("StorageContainerFile getLastModified " + file.getLastModified());
					LOG.info("StorageContainerFile getName " + file.getName());
					LOG.info("StorageContainerFile getSize " + file.getSize());
				}
			}
		}
	}

	/**
	 * Test storage create.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testStorageCreate() throws IOException {
		RunAboveManager runAboveApi = login();
		StorageContainerCreate storageContainer = new StorageContainerCreate();
		storageContainer.setContainerName("dummy");
		storageContainer.setContainerRegion("BHS-1");
		StorageContainerDetail containerDetail = runAboveApi.createStorageContainer(storageContainer);
		assertNotNull(containerDetail);
		LOG.info("containerDetail " + containerDetail.getName());
	}

	/**
	 * Test flavor.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testFlavor() throws IOException {

		RunAboveManager runAboveApi = login();

		// get all available instances
		Flavor[] falvors = runAboveApi.getFlavor();
		assertNotNull(falvors);
		for (Flavor flavor : falvors) {
			LOG.info("Flavor getDisk " + flavor.getDisk());
			LOG.info("Flavor getId " + flavor.getId());
			LOG.info("Flavor getName " + flavor.getName());
			LOG.info("Flavor getRam " + flavor.getRam());
			LOG.info("Flavor getRegion " + flavor.getRegion());
			LOG.info("Flavor getVcpus " + flavor.getVcpus());
		}
	}

	/**
	 * Test project.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testProject() throws IOException {
		RunAboveManager runAboveApi = login();

		String[] projects = runAboveApi.project();
		assertNotNull(projects);
		for (String project : projects) {
			LOG.info("Project " + project);
		}
	}

	/**
	 * Test builder.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testBuilder() throws IOException {
		AccountManager acm = new RunAboveBuilder(getConfig()).createAccountManager(new MockClient());
		assertNotNull(acm);
		ContainerManager cm = new RunAboveBuilder(getConfig()).createContainerManager(new MockClient());
		assertNotNull(cm);
		FlavorManager flm = new RunAboveBuilder(getConfig()).createFlavorManager(new MockClient());
		assertNotNull(flm);
		ImageManager imm = new RunAboveBuilder(getConfig()).createImageManager(new MockClient());
		assertNotNull(imm);
		InstanceManager ism = new RunAboveBuilder(getConfig()).createInstanceManager(new MockClient());
		assertNotNull(ism);
		RegionManager rem = new RunAboveBuilder(getConfig()).createRegionManager(new MockClient());
		assertNotNull(rem);
		SSHKeyManager sshm = new RunAboveBuilder(getConfig()).createSSHKeyManager(new MockClient());
		assertNotNull(sshm);

	}

	/**
	 * Login.
	 * 
	 * @return the run above manager
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private RunAboveManager login() throws IOException {
		// to switch from mockup client to real client, just uncomment this line and comment the one below
		// return new RunAboveBuilder(getConfig()).createManager(consummerKey);
		return new RunAboveBuilder(getConfig()).createManager(new MockClient());
	}

	/**
	 * Gets the config.
	 * 
	 * @return the config
	 */
	private RunAboveConfig getConfig() {
		return new RunAboveConfig().setErrorHandlder(new LoggerErrorHandler()).setApplicationKey("").setApplicationSecret("");
	}

	/**
	 * Test pojo.
	 * @throws IntrospectionException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testPojo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IntrospectionException {
		// this is to ensure that pojo with complex getters and setters logic do work properly (if applicable)
		// and increase test coverage to maximum value
		// objects should be used properly in normal tests before entering the pojo phase test

		// instance
		testPojo(InstanceDetail.class);
		testPojo(InstanceAlter.class);
		testPojo(Instance.class);
		testPojo(Flavor.class);
		testPojo(InstanceIP.class);
		testPojo(InstanceQuota.class);
		testPojo(InstanceVNC.class);

		// account
		testPojo(Account.class);
		testPojo(Balance.class);
		testPojo(CurrentUsage.class);

		// auth
		testPojo(AccessRule.class);
		testPojo(Credential.class);
		testPojo(CredentialParams.class);
		testPojo(DefaultCredentialParams.class);

		// billing
		testPojo(BillingBandwidthInstanceDetails.class);
		testPojo(BillingInstanceDetails.class);
		testPojo(BillingProjectDetails.class);
		testPojo(BillingProjectUse.class);

		// ssh
		testPojo(SSHKeyPair.class);
		testPojo(SSHKeyPairDetail.class);

		// storage
		testPojo(Catalog.class);
		testPojo(Endpoint.class);
		testPojo(StorageContainerCreate.class);
		testPojo(StorageContainer.class);
		testPojo(StorageContainerDetail.class);
		testPojo(StorageContainerObject.class);

		// token
		testPojo(Domain.class);
		testPojo(OpenstackToken.class);
		testPojo(Role.class);
		testPojo(Token.class);
		testPojo(TokenProject.class);
		testPojo(User.class);

	}

}
