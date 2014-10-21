package com.runabove.api;

import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;

import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.UrlConnectionClient;

import com.runabove.client.CredentialClient;
import com.runabove.client.SigningClient;

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

 * Builder class for the different api - createAuthManager manages
 * authentification process against the api - createManager manages all call to
 * the runabove api - *Manager manage only small part of the api (this is done
 * to isolate exposition to broad usage) - createSwiftManager exposes the
 * central account object from the joss stack
 * 
 * 
 */
/**
 * The Class RunAboveBuilder.
 */
public class RunAboveBuilder {

	/** The config. */
	private final RunAboveConfig config;

	/** The Constant RUNABOVE_AUTH_URL. */
	private final static String RUNABOVE_AUTH_URL = "https://api.runabove.com/1.0";

	/** The Constant RUNABOVE_API_URL. */
	private final static String RUNABOVE_API_URL = "https://api.runabove.com/1.0";

	/** The Constant RUNABOVE_KEYSTONE_URL. */
	private final static String RUNABOVE_KEYSTONE_URL = "https://auth.runabove.io/v2.0/tokens";

	/**
	 * Instantiates a new run above builder.
	 *
	 * @param config the config
	 */
	public RunAboveBuilder(RunAboveConfig config) {
		this.config = config;
	}

	/**
	 * generic runabove creation manager function.
	 *
	 * @param consumerKey the consumer key
	 * @return the ${e.g(1).rsfl()}
	 */
	public RunAboveManager createManager(String consumerKey) {

		RestAdapter restAdapterSigned = new RestAdapter.Builder()
				.setEndpoint(RUNABOVE_API_URL)
				.setErrorHandler(config.getExceptionHandler())
				.setClient(
						new SigningClient(new UrlConnectionClient(), config.getApplicationKey(), config.getApplicationSecret(), consumerKey, config
								.getExceptionHandler())).build();

		// and now all our request are signed and the service can be requested
		RunAboveManager serviceRunAbove = restAdapterSigned.create(RunAboveManager.class);
		return serviceRunAbove;
	}

	/**
	 * generic runabove creation manager function that accepts a custom client implementation.
	 *
	 * @param client the client
	 * @return the signature
	 */
	public RunAboveManager createManager(Client client) {
		RestAdapter restAdapterSigned = new RestAdapter.Builder().setEndpoint(RUNABOVE_API_URL).setErrorHandler(config.getExceptionHandler()).setClient(client)
				.build();

		// and now all our request are signed and the service can be requested
		RunAboveManager serviceRunAbove = restAdapterSigned.create(RunAboveManager.class);
		return serviceRunAbove;
	}

	/**
	 * generic internal rest adapter method builder.
	 *
	 * @param client the client
	 * @return the rest adapter
	 */
	private RestAdapter getRestAdapter(Client client) {
		return new RestAdapter.Builder().setEndpoint(RUNABOVE_API_URL).setErrorHandler(config.getExceptionHandler()).setClient(client).build();

	}

	/**
	 * generic internal signed client builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the signed client
	 */
	private SigningClient getSignedClient(String consumerKey) {
		return new SigningClient(new UrlConnectionClient(), config.getApplicationKey(), config.getApplicationSecret(), consumerKey,
				config.getExceptionHandler());
	}

	/**
	 * account manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the account manager
	 */
	public AccountManager createAccountManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(AccountManager.class);
	}

	/**
	 * account manager builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the account manager
	 */
	public AccountManager createAccountManager(Client client) {
		return getRestAdapter(client).create(AccountManager.class);
	}

	/**
	 * container manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the container manager
	 */
	public ContainerManager createContainerManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(ContainerManager.class);
	}

	/**
	 * container manager builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the container manager
	 */
	public ContainerManager createContainerManager(Client client) {
		return getRestAdapter(client).create(ContainerManager.class);
	}

	/**
	 * flavor manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the flavor manager
	 */
	public FlavorManager createFlavorManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(FlavorManager.class);
	}

	/**
	 * flavor manager builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the flavor manager
	 */
	public FlavorManager createFlavorManager(Client client) {
		return getRestAdapter(client).create(FlavorManager.class);
	}

	/**
	 * image manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the image manager
	 */
	public ImageManager createImageManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(ImageManager.class);
	}

	/**
	 * image manager builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the image manager
	 */
	public ImageManager createImageManager(Client client) {
		return getRestAdapter(client).create(ImageManager.class);
	}

	/**
	 * instance manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the instance manager
	 */
	public InstanceManager createInstanceManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(InstanceManager.class);
	}

	/**
	 * instance manager builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the instance manager
	 */
	public InstanceManager createInstanceManager(Client client) {
		return getRestAdapter(client).create(InstanceManager.class);
	}

	/**
	 * region manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the region manager
	 */
	public RegionManager createRegionManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(RegionManager.class);
	}

	/**
	 * region manager builder builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the region manager
	 */
	public RegionManager createRegionManager(Client client) {
		return getRestAdapter(client).create(RegionManager.class);
	}

	/**
	 * sshkey manager builder.
	 *
	 * @param consumerKey the consumer key
	 * @return the SSH key manager
	 */
	public SSHKeyManager createSSHKeyManager(String consumerKey) {
		return getRestAdapter(getSignedClient(consumerKey)).create(SSHKeyManager.class);
	}

	/**
	 * sshkey manager builder with a custom provided client.
	 *
	 * @param client the client
	 * @return the SSH key manager
	 */
	public SSHKeyManager createSSHKeyManager(Client client) {
		return getRestAdapter(client).create(SSHKeyManager.class);
	}

	/**
	 * auth manager builder.
	 *
	 * @return the auth manager
	 */
	public AuthManager createAuthManager() {
		return createAuthManager(new CredentialClient(new UrlConnectionClient(), config.getApplicationKey(), config.getExceptionHandler()));
	}

	/**
	 * auth manager builder that allows the use of a specific implementation client.
	 *
	 * @param authClient the auth client
	 * @return the auth manager
	 */
	public AuthManager createAuthManager(Client authClient) {
		RestAdapter restAdapterCredential = new RestAdapter.Builder().setEndpoint(RUNABOVE_AUTH_URL).setErrorHandler(config.getExceptionHandler())
				.setClient(authClient).build();

		AuthManager serviceCredentials = restAdapterCredential.create(AuthManager.class);

		return serviceCredentials;
	}

	/**
	 * swift manager (rely on joss component structure).
	 *
	 * @return the account
	 */
	public Account createSwiftManager() {

		AccountConfig jossConfig = new AccountConfig();
		jossConfig.setAuthenticationMethod(AuthenticationMethod.KEYSTONE);
		jossConfig.setUsername(config.getLogin());
		jossConfig.setPassword(config.getPassword());
		jossConfig.setAuthUrl(RUNABOVE_KEYSTONE_URL);
		jossConfig.setTenantName(config.getTenantName());
		jossConfig.setTenantId(config.getTenantId());
		jossConfig.setMock(config.isMocked());
		return new AccountFactory(jossConfig).createAccount();
	}

}
