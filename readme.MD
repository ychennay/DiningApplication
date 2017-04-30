##Getting Started with Java Spring

You'll need to do the following things to get up and running:
###Java JDK and IDE
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

###Maven

[Maven](https://maven.apache.org/download.cgi) is pretty awesome. It operates using a **Project Object Model.xml** file in your
 project's base directory. The **pom.xml** file contains all of your dependencies. Maven will automatically download and cache
 these dependencies into a folder on your local system called **.m2**. For example, in our project, we will have these dependencies (not listing)
 all of them:
 
 ```xml
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
```

Maven will go and download ```jstl```, ```spring-beans```, ```spring-web``` and any other dependencies you state into the local
folder. 

You need add ```M2``` AND ```MAVEN_HOME```. Here is a [good tutorial](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) I followed to get Maven running.
