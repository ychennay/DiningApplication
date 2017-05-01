## Getting Started with Java Spring

The goal of this ```readme.MD``` is to spare you, the reader, of having to spend hours debugging and figuring simple things related to Java Spring.

You'll need to do the following things to get up and running:
### Java JDK and IDE
* Install [Java JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) on your system. Make sure that you install the JDK, not just the JRE. I've run into some
issues at my internship early on with Maven because I was using the JRE instead of the JDK.
* Set up your environment variables: if you are using **Windows**, do what this [StackOverflow](http://stackoverflow.com/questions/1672281/environment-variables-for-java-installation)
post says. If you are using Mac, it's pretty much the same thing. You can test by using

```
echo $JAVA_HOME
> [should return wherever your Java JDK is stored in your system]
echo $PATH
> [should contain a reference to $JAVA_HOME/bin]
```

* Install [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/mars2) 
/ [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) as an IDE. It doesn't really matter which one you pick,
 as long as it works. However, most of the tutorials I have seen on the internet appear to use Eclipse as the IDE of choice.

If you are using Eclipse, make sure to install the **JAVA EE IDE for Web Developers**, not another ide. Eclipse has many different
IDE offerings.

Also, make sure that you install the Java JDK before you install the IDE. In many cases, the IDE will not allow you to continue
the installation if it cannot detect a valid JDK on your system. 

### Maven

[Maven](https://maven.apache.org/download.cgi) is pretty awesome. It operates using a **Project Object Model.xml** file in your
 project's base directory. The **pom.xml** file contains all of your dependencies. Maven will automatically download and cache
 these dependencies into a folder on your local system called **.m2**. For example, in our project, we will have these dependencies (not listing)
 all of them:
 
 ```xml
  	<dependencies>
  	<dependency>
  		<groupId>jstl</groupId>
  		<artifactId>jstl</artifactId>
  		<version>1.2</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-beans</artifactId>
  		<version>4.3.7.RELEASE</version>
  	</dependency>
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-web</artifactId>
          <version>4.3.4.RELEASE</version>
      </dependency>
      </dependencies>
```

Maven will go and download ```jstl```, ```spring-beans```, ```spring-web``` and any other dependencies you state into the local
folder. There's a bunch of other dependencies we need that I haven't listed here.

**FYI**: if in the future you need a dependency but can't find it, you can usually google 
```spring data sql maven pom```, and the first link will be the Maven Central Repository. There, you'll be able to find the XML code
all ready for you to just copy and paste into your ```pom.xml```, and then Maven will automatically import those dependencies for your project.

You need add ```M2_HOME``` and ```MAVEN_HOME``` to your environment variables. Here is a [good tutorial](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) I followed to get Maven running.

## Install a local server for testing and deployment (Wildfly or Tomcat)

The primary two servers I tried are [Wildfly (formerly JBoss)](http://wildfly.org/downloads/) and 
[Tomcat](http://tomcat.apache.org/). I've generally found that Wildfly is more reliable and
less easy to break. However, I know that IntelliJ Community Edition does not support Wildfly (only in the Enterprise Edition).

Once you install Wildfly or Tomcat, you have to "add" them to the IDE. In IntelliJ, that means
```Run > Run > Edit Configurations``` and then pressing the green add button and selecting Wildfly (it'll be called JBoss) or Tomcat from the list.
It's similar for Eclipse: I believe it's called "adding a new server".

## Build the source code into an executable
In order to deploy the code into production for testing, the Wildfly or Tomcat server typically accepts a JAR or WAR file. These are basically
executeable and zipped files that have been zipped up. FYI, an ```exploded WAR``` just means a WAR file that has been
unzipped into all of its subdirectories. 

For IntelliJ, when you are adding your server, it will warn you that there are no "artifacts" to deployment. If you click the
```fix it``` link, it will allow you to select a WAR or exploded WAR to attach to the server when you build your project.

In Eclipse, it is similar (I use IntelliJ), but I believe that Eclipse will build and attach the WAR file automatically to the server once you add it.

FYI, you can also add the WAR files manually. Go to your Tomcat or Wildfly server's directory. For Tomcat, navigate to its
```webapps``` subdirectory. If you paste your WAR into this directory, it should deploy on a running Tomcat server. For Wildfly, search for a folder called ```standalone/deployments```.

## Deploy the WAR to the server
Usually takes about 5-6 seconds for the server to get started. You can watch all the log messages in your IDE's console. Just hope and pray nothing goes wrong.

## Test the endpoints
So far, I've made a few endpoints for ```/reviews``` and ```/restaurants```. When you first launch the server, you
may automatically also open your browser to ```http://localhost:8080/Dining-0.0.1-SNAPSHOT/```. Don't worry if you see

```Not found```

We haven't mapped any endpoints to ```\``` so there is no endpoint exposed here. If you try
```http://localhost:8080/Dining-0.0.1-SNAPSHOT/reviews```, however, you'll see a JSON object that has sample reviews:

```json
[{"id":1,"userName":"ychennay","reviewText":"This restaurant was terrific!"},
{"id":2,"userName":"david","reviewText":"This restaurant was okay!"},
{"id":3,"userName":"ben","reviewText":"This restaurant was mediocre!"},
{"id":4,"userName":"leon","reviewText":"This restaurant was awful!"},
{"id":5,"userName":"lawrence","reviewText":"This restaurant was confusing!"}]
```

If you type in ```http://localhost:8080/Dining-0.0.1-SNAPSHOT/reviews/1```, you should see the review with ID of 1:
```json
{"id":1,"userName":"ychennay","reviewText":"This restaurant was terrific!"}
```

Obviously this is not the most detailed walkthrough. I'll continue adding to this MD as I make more progress.