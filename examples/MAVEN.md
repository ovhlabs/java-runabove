Bootstraping your project with maven
------------------------------------

Requirements:
* a working environnement with maven and a jdk 1.6+ and your favorite ide (Eclipse 4.3+ recommended, Maven 3+, Oracle JDK 1.6+)
* a good understanding of a the runabove authentication that can be found here : https://api.ovh.com/g934.first_step_with_api



Since the Runabove Java SDK is not yet in maven central (submission pending), we need to build it into our local repository : 
```
git clone https://github.com/runabove/java-runabove.git
```

Then build and install : 
```
mvn clean install
```

Now if everything is ok, you can start to use it directly. 
Let's start by creating a new maven project, we'll use the "quickstart" archetype for that.

```
mvn archetype:generate -DgroupId=com.mycompany -DartifactId=simpletest -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

We have a simple project with two java files. One name App for our simple test. One called AppTest for testing purposes.

To make it work with our sdk, let's add the sdk dependency to the pom.xml in this very project. 

```
<dependency>
	<groupId>com.runabove</groupId>
	<artifactId>api</artifactId>
	<version>1.0.0</version>
</dependency>
```

To ease the development you can import the project into eclipse: 
```
mvn eclipse:eclipse
```

Then Import > Existing project into workspace > Select where the pom is and voila.


Making an API Call
------------------



Now we can modify our script to make the two step authentication and make an api call:
- First generate a consumer key
- Validate the consumer key on the web interface
- Then use the validated consumer key to make api calls

In the following code, everything is done in one step. 
Replace the XXXXXX with your own application key and application secret.
Once launched, this small programm will display an validation url.
Copy / paste it in your browser, enter your login password and it shoud validate the consummer key.
After the delay, the code will display all available instance in your account.  


```java

package com.mycompany;

import com.runabove.api.AuthManager;
import com.runabove.api.RunAboveBuilder;
import com.runabove.api.RunAboveConfig;
import com.runabove.api.RunAboveManager;
import com.runabove.error.SystemOutErrorHandler;
import com.runabove.model.auth.Credential;
import com.runabove.model.auth.DefaultCredentialParams;
import com.runabove.model.instance.Instance;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	String applicationKey = "XXXXXXXXXXXXX";
        String applicationSecret = "XXXXXXXXXXXXXXXXXXXXXXXXX";

        // initialize configuration
        RunAboveConfig config = new RunAboveConfig()
                .setErrorHandlder(new SystemOutErrorHandler())
                .setApplicationKey(applicationKey)
                .setApplicationSecret(applicationSecret);

        // request credentials
        AuthManager runAboveAuth = new RunAboveBuilder(config).createAuthManager();
        Credential creds = runAboveAuth.credential(new DefaultCredentialParams());

        // first phase
        System.out.println("CK =" + creds.getConsumerKey());
        System.out.println("VALIDATION URL = " + creds.getValidationUrl());

        // validate the url from validation url you have 20s go go go !!!!
        Thread.sleep(20000);

        // now let's call the api
        // create the manager object that handles all api calls
        RunAboveManager runAbove = new RunAboveBuilder(config).createManager(creds.getConsumerKey());

        // list all the instances
        Instance[] listInstances =  runAbove.getInstances();
        for (Instance instance : listInstances) {
            System.out.println("INSTANCE ID = " + instance.getInstanceId());
            System.out.println("INSTANCE NAME =  " + instance.getName());
        }    }
}

```

Here's the result output of the code above : 

```
CK =gU6WZHh40OyUaTVGymUEDFZEZEFEZFZHELljOlC81ba0
VALIDATION URL = https://api.runabove.com/login/?credentialToken=I28Eii2XXDn0QDhS3i17eeFNy8IcrQCqJkBdywe9lbDUVytCT6d0X48zJUZDFEZFZEFZfD6bo3
INSTANCE ID = c28d6241-0084-4ca5-af27-eb82f2c06ZEFEZFEZf1c
INSTANCE NAME  = myveryowninstance
```


 
