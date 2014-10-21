

Detailed examples
-----------------

This page shows how to make very common api call in java to the RunAbove API.  


#### Authentication

Authentication is a two phase process. In the first phase (in the code below), you get the consummer key and a validation url.
In the second phase, you go to this validation url and validate the consummer key.

```java

// create a runabove auth api
AuthManager runAboveAuth = new RunAboveBuilder(getConfig()).createAuthManager();
assertNotNull(runAboveAuth);

// everything is merged into a credential params so retrofit can autoconvert it into json (see jake wharton SO answer about it)
Credential creds = runAboveAuth.credential(new DefaultCredentialParams());

// we can get the consumer key
assertNotNull(creds);
assertNotNull(creds.getConsumerKey());
```


#### Account details

This small code show you how to retrieve your accounts informations with the Account Manager.


```java

// get my account
Account account = runAboveAccountManager.me();
assertNotNull(account);
assertNotNull(account.getEmail());
assertEquals(account.getEmail(), login);
log.info("Account getEmail=" + account.getEmail());
log.info("Account getAccountIdentifier=" + account.getAccountIdentifier());
log.info("Account getName=" + account.getName());
log.info("Account getFirstname=" + account.getFirstname());
log.info("Account getCellNumber=" + account.getCellNumber());
log.info("Account getAddress=" + account.getAddress());
log.info("Account getPostalCode=" + account.getPostalCode());
log.info("Account getCity=" + account.getCity());
log.info("Account getArea=" + account.getArea());
log.info("Account getCountry=" + account.getCountry());

```

#### Projects

A project is a way of organizing your RunAbove instances and storages. You can get all your projects like this : 

```java
String[] projects = runAboveApi.project();
for (int i = 0; i < projects.length; i++) {
	log.info("PROJECTS  " + projects[i]);
}
```


#### Token

A Token is a security concept that grants usage and access to information, execution and configuration of all RunAbove products.
Here's how to retrieve a token: 


```java

// request a token for openstack swift from the api (this can also directly asked to keystone)
Token toekn = runAboveManager.token();
List<Catalog> catalogues = toekn.getToken().getCatalog();
log.info("XAUTH TOEKN = " + toekn.getX_Auth_Token());
for (Catalog catalog : catalogues) {
	if ("object-store".equals(catalog.getType())) {
		for (Endpoint ep : catalog.getEndpoints()) {
			log.info("Store id " + ep.getId());
			log.info("Store interface " + ep.getInterface());
			log.info("Store region " + ep.getRegion());
			log.info("Store url " + ep.getUrl());
		}
	}
}
```

#### Images

Images allow the creation of instance based on a model or template of instance. To get the list of images, just do : 


```java

// get all available images
Image[] imgs = runAboveManager.getImages();
for (Image image : imgs) {
	log.info("image id " + image.getId());
	log.info("image name " + image.getName());
	log.info("image region " + image.getRegion());

}
```

#### Instances

A typical instance retrieving process :  

```java

String[] regions = runAboveManager.getRegions();
String firstRegion = regions[0];

// get instance quota
InstanceQuota instanceQuota = runAboveManager.getInstanceQuota(firstRegion);
log.info("InstanceQuota getCores " + instanceQuota.getCores());
log.info("InstanceQuota getInstances " + instanceQuota.getInstances());
log.info("InstanceQuota getKeypairs " + instanceQuota.getKeypairs());
log.info("InstanceQuota getRam " + instanceQuota.getRam());
log.info("InstanceQuota getSecurityGroups " + instanceQuota.getSecurityGroups());

// get all available instances
Instance[] instances = runAboveApi.getInstances();
for (Instance instance : instances) {
	log.info("instance getCreated " + instance.getCreated());
	log.info("instance getFlavorId " + instance.getFlavorId());
	log.info("instance getImageId " + instance.getImageId());
	log.info("instance getInstanceId " + instance.getInstanceId());
	log.info("instance getIp " + instance.getIp());
	log.info("instance getName " + instance.getName());
	log.info("instance getRegion " + instance.getRegion());
	log.info("instance getStatus " + instance.getStatus());

	Instance instanceDetail = runAboveManager.getInstance(instance.getInstanceId());
	log.info("instanceDetail getInstanceId " + instanceDetail.getInstanceId());

	InstanceVNC instanceVNC = runAboveManager.getInstanceVNC(instance.getInstanceId());
	log.info("instanceVNC getType " + instanceVNC.getType());
	log.info("instanceVNC getUrl " + instanceVNC.getUrl());
}
```

#### Regions

Regions is the location where instance can be created. 

```java

// get all available regions
String[] regions = runAboveApi.getRegions();
for (String string : regions) {
	log.info("Regions " + string);
}
```


#### Balance and Usage

Balance and usage are part of the billing system. The code below details how to retrieve billing information for each project/region :

```java

// get all available billing info
BillingProjectUse[] uses = runAboveApi.getUsage(true, "2014-04-19",null,"2014-04-19");
for (BillingProjectUse billingProjectUse : uses) {

	log.info("BillingProjectUse project id " + billingProjectUse.getProjectId());
	log.info("BillingProjectUse region " + billingProjectUse.getRegion());
	for (BillingProjectDetails details : billingProjectUse.getDetails()) {
		log.info("Details getBandwidthInstance " + details.getBandwidthInstance());
		log.info("Details " + details.getBandwidthStorage());
		log.info("Details " + details.getBandwidthStorageDetails());
		log.info("Details " + details.getFrom());
		log.info("Details " + details.getInstance());
		log.info("Details " + details.getStorage());
		log.info("Details " + details.getStorageDetails());
		log.info("Details " + details.getTo());

		for (BillingBandwidthInstanceDetails bwdetail : details.getBandwidthInstanceDetails()) {
			log.info("Detaisl BW Id " + bwdetail.getId());
			log.info("Detaisl BW Quantity " + bwdetail.getQuantity());
		}
	}
}

Balance balance = runAboveApi.getBalance();
log.info("balance " + balance.getCreditLeft());
for (CurrentUsage usage : balance.getCurrentUsages()) {
	log.info("balance usage " + usage.getProjectId());
	log.info("balance usage " + usage.getCurrentTotal());
}
```


#### SSH Keys

SSH Key pair retrieval : 

```java

SSHKeyPair[] sshKeyPair = runAboveApi.getSSHKeyPairs();
for (SSHKeyPair ssh : sshKeyPair) {
	log.info("SSHKeyPair getFingerPrint " + ssh.getFingerPrint());
	log.info("SSHKeyPair getName " + ssh.getName());
	log.info("SSHKeyPair getPublicKey " + ssh.getPublicKey());
	log.info("SSHKeyPair getRegion " + ssh.getRegion());
}
```

#### Storage

Retrieving a list of container and listing all the objects it contains :
 
```java

// get all available storage container for the current account
StorageContainer[] containers = runAboveApi.getStoreContainers();
for (StorageContainer storageContainer : containers) {

	log.info("StorageContainer getContainerName " + storageContainer.getName());
	log.info("StorageContainer getRegion " + storageContainer.getRegion());
	log.info("StorageContainer getStored " + storageContainer.getStored());
	log.info("StorageContainer getPublic " + storageContainer.getPublic());
	log.info("StorageContainer getRegion " + storageContainer.getRegion());
	log.info("StorageContainer getTotalFiles " + storageContainer.getTotalObjects());

	StorageContainer detail = runAboveApi.getStoreContainer(storageContainer.getName(), 10, storageContainer.getRegion(), null);
	if (detail.getObjects() != null)
		for (StorageContainerObject file : detail.getObjects()) {
			log.info("StorageContainerFile getContentType " + file.getContentType());
			log.info("StorageContainerFile getLastModified " + file.getLastModified());
			log.info("StorageContainerFile getName " + file.getName());
			log.info("StorageContainerFile getSize " + file.getSize());
		}
}
```

#### Creating a container :

Create a container just requires 3 lines of code : 

```java

StorageContainerCreate storageContainer = new StorageContainerCreate();
storageContainer.setContainerName("dummy");
storageContainer.setContainerRegion("BHS-1");
StorageContainerDetail containerDetail = runAboveApi.createStorageContainer(storageContainer);
log.info("containerDetail " + containerDetail.getName());
```

#### Flavors

A flavor is an instance type for a determined region. Runabove offers many type of instances per region. Here's how to programmaticaly retrive flavors :

```java

// get all available flavors
Flavor[] falvors = runAboveApi.getFlavor();
for (Flavor flavor : falvors) {
	log.info("Flavor getDisk " + flavor.getDisk());
	log.info("Flavor getId " + flavor.getId());
	log.info("Flavor getName " + flavor.getName());
	log.info("Flavor getRam " + flavor.getRam());
	log.info("Flavor getRegion " + flavor.getRegion());
	log.info("Flavor getVcpus " + flavor.getVcpus());
}
```



License
-------

The SDK code is released under a MIT style license, which means that it should 
be easy to integrate it to your application.  
Check the [LICENSE](LICENSE) file for more information.

