# hoverflydemo

## Introduction ##
The purpose of this repo is to show how to use hoverfly ( hoverfly.io ) in a java microservice architecture

## Setup ##

### Hoverfly setup ###
download hoverfly executable from website ad unzip in a folder

	dir C:\frank\hoverflydemo\hoverfly>
	
	11-09-20  19:27        14.314.496 hoverctl.exe
	11-09-20  19:27        16.615.424 hoverfly.exe
	11-09-20  19:27            11.345 LICENSE.txt
	11-09-20  19:27                26 VERSION.txt


Make sure hoverfly is in your path

	C:\frank\hoverflydemo\hoverfly>set PATH
	Path=C:\frank\hoverflydemo\hoverfly

### Microservice setup ###

Using swagger editor online (https://editor.swagger.io/) we created a small microservice structure with two methods:

- sum ( addition of two integers )
- upper ( convert a string to upper case )

The swagger.json file is part of java vertx microservice code


Note: The microservice functionality itself is not important, we just need one to illustrate the demo

The source code of the microservice has been generated by swagger editor online ( generate server / java vert.x option )

The following changes have been done to the generated code:

- add implementation of sumApi interfacce
- add implementation of upperApi interface
- modify sumApiVerticle to include delivery options in "Message.Reply" call
- modify upperApiVerticle to include delivery options in "Message.Reply" call
- update pom.xml file to use some newer versions of dependencies

### Client setup ###

Using swagger editor online (https://editor.swagger.io/) we created a small microservice CLIENT with the two methods unit tests functions

The following changes have been done to the generated code:

- add implementation of ClassRule in SumApiTest
- add implementation of ClassRule in UpperApiTest
- update pom.xml file to add ( com.squareup.okhttp3 3.8.0 & com.squareup.okio 2.8.0 ) or use some newer versions of dependencies

### Execution ###

server execution:

	java -jar swagger-java-vertx-server-1.0.0-SNAPSHOT-fat.jar

Client execution:

	mvn test

At first execution the client will contact the server and hoverfly will capture the traffic
As of second and next executions server is not reached anymore, hoverfly is simulating the server