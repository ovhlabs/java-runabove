Java SDK for RunAbove API
=============


This is a Java SDK to use Instances and Object Storage on [RunAbove](https://www.runabove.com). The SDK uses the simple API provided by RunAbove.

Benefits : 
  - Auth made easy
  - Embedded api cryptography process
  - All POJO availables
  - All services exposed
  - Create Instances and Containers in one line
  - Play with Openstack Swift through the API or with JOSS Library

The Runabove API Console is available [here](https://manager.runabove.com/console).


Quickstart
----------

The easiest way to start with the SDK is to install clone it from github and package it :

    mvn clean install package

RunAbove SDK can then be included in your java programs. Some examples of
applications using the SDK are available in the `examples` directory.

Once build, add this dependency to your project :


 ```xml
<dependency>
	<groupId>com.runabove</groupId>
	<artifactId>api</artifactId>
	<version>1.0.0</version>
</dependency>
```



Authenticate to RunAbove API
----------------------------

Each **application** that uses RunAbove API needs to be authenticated. For that 
you have to register your application, it is very easy and can be done at this 
address: https://api.runabove.com/createApp

Then each **user** using your application will be securely authenticated with a 
consumer key. Thanks to this mecanism users don't need to give their plain text 
password to the application. The first time a user will use your application, 
he will be redirected to a web page where he can securely get his **consumer 
key**.


How to get a consumer key with the SDK?
---------------------------------------

To communicate with the API, each call made by your application must be signed 
and include the consumer key of the user. The signature process is 
automatically handled by the SDK. However if the user don't have a valid 
consumer key yet you can redirect him to RunAbove authentication page.



How to manage instances?
------------------------

Launching an instance is easy. First get the flavor, image and region where you 
want your instance to be created and call `create()`. To 
delete an instance just call the `instance.delete()` method:



```java

// initialize configuration
RunAboveConfig config = new RunAboveConfig()
		.setErrorHandlder(new SystemOutErrorHandler())
		.setApplicationKey(applicationKey)
		.setApplicationSecret(applicationSecret);

// request credentials
AuthManager runAboveAuth = new RunAboveBuilder(getConfig()).createAuthManager();
Credential creds = runAboveAuth.credential(new DefaultCredentialParams());

// snip snip 
// redirect user to authorization page at creds.getValidationUrl()
// snip snip

// create the manager object that handles all api calls
RunAboveManager runAbove = new RunAboveBuilder(getConfig()).createManager(creds.getConsumerKey());

// create an instance detail
InstanceDetail instanceDetail = new InstanceDetail();

// get a flavor
Flavor[] flavors = runAbove.getFlavor();
instanceDetail.setFlavor(flavors[0]);

// get a region
String[] regions = runAbove.getRegions();
instanceDetail.setRegion(regions[0]);

// get an image
Image[] imgs = runAbove.getImages();
instanceDetail.setImage(imgs[0]);

// create an instance
InstanceDetail resultInstance = runAbove.createInstance(instanceDetail);

// list all the instances
Instance[] listInstances =  runAbove.getInstances();
for (Instance instance : listInstances) {
	LOG.info("instance id " + instance.getInstanceId());
	LOG.info("instance name " + instance.getName());
}

// delete the instance we just created
runAbove.deleteInstance(resultInstance.getInstanceId());
```

How to use storage?
-------------------

```java
// initialize configuration
RunAboveConfig config = new RunAboveConfig()
		.setErrorHandlder(new SystemOutErrorHandler())
		.setApplicationKey(applicationKey)
		.setApplicationSecret(applicationSecret);

// request credentials
RunAboveAuthApi runAboveAuth = new RunAboveBuilder(config).createAuth();
Credential creds = runAboveAuth.credential(new DefaultCredentialParams());

// snip snip 
// redirect user to authorization page at creds.getValidationUrl()
// snip snip

// create the manager object that handles all api calls
RunAboveManager runAbove = new RunAboveBuilder(getConfig()).createManager(creds.getConsumerKey());

// storage container creation settings
StorageContainerCreate storageContainer = new StorageContainerCreate();
storageContainer.setContainerName("Container Name");
storageContainer.setContainerRegion("BHS-1");
StorageContainerDetail containerDetail = runAboveApi.createStorageContainer(storageContainer);

// get all available files in all storage containers
StorageContainer[] containers = runAboveApi.getStoreContainers();
for (StorageContainer storageContainer : containers) {

	LOG.info("StorageContainer getContainerName " + storageContainer.getName());
	LOG.info("StorageContainer getTotalFiles " + storageContainer.getTotalObjects());

	StorageContainer detail = runAboveApi.getStoreContainer(storageContainer.getName(), 10, storageContainer.getRegion(), null);
	if (detail.getObjects() != null)
		for (StorageContainerObject file : detail.getObjects()) {
			LOG.info("StorageContainerFile getContentType " + file.getContentType());
			LOG.info("StorageContainerFile getLastModified " + file.getLastModified());
			LOG.info("StorageContainerFile getName " + file.getName());
			LOG.info("StorageContainerFile getSize " + file.getSize());
		}
}
```

How to build the documentation?
-------------------------------

Documentation can be generated with the maven command:

    mvn site

Also more documentation about the managers can be found in the knowledge base on the Runabove website.



How to run tests?
-----------------

The tests are all mocked with proper responses from the runabove api. Just type : 

	mvn clean test




License
-------

The SDK code is released under a MIT style license, which means that it should 
be easy to integrate it to your application.  
Check the [LICENSE](LICENSE) file for more information.



