mgsv-ws-client 1.0-RC3
==============

Client application for mGSV Web Service. This application act as a guide for the mGSV Web Service as well as a fully functional file upload tool. Application is implemented in Java, and requires JVM or JDK 1.6+ to run.


### Overview
Application makes use of default Web Service API that comes with standard JVM Distribution. Except for the JDK binary distribution does not require anything else to run. Client application connects to the mGSV Web Service to make
upload requests and upon successful upload prints the id of the upload. The id can be used later to browse the visualization.

The main purpose of this client tool is to allow biologists to upload several files and public dataset at once to mGSV server. The sources and documentation within can also be studied to implement similar clients that uses mGSV
Web Service.

### Technical Overview
Application is divided into two parts.
1. Implementation
2. Helper codes generated from the Web Service WSDL.

Implementation code makes use of the generated code that provides all networking and interfacing with the remote web service. The program flow is :

1. If config.properties is provided, load it to replace the remote mGSV Server's address.
2. If argument starts with http, call uploadURL or else call uploadData with the content of the file given in argument

The main class is **src/main/edu/unt/mgsv/uploader/UploadFile.java**. The code is documented with low level details.


### Installation

#### Binary
Requirements
1. JVM or JDK 1.6+

Download prebuilt jar from : <https://github.com/downloads/aniljava/mgsv-ws-client/ws-client-1.0-RC3-jar-with-dependencies.jar>
Execute the jar with arguments and configuration (See Configuration/Arguments Section Below)

Example
	java -jar ws-client-1.0-RC3-jar-with-dependencies.jar synteny.txt annotation.txt sample@sample.com
	java -jar ws-client-1.0-RC3-jar-with-dependencies.jar http://cas-bioinfo.cas.unt.edu/mgsv/sample_synteny.txt http://cas-bioinfo.cas.unt.edu/mgsv/sample_annotation.txt sample@sample.com

#### Building from Source
Requirements
1. JDK 1.5+ <http://java.sun.com>
2. Maven 3.0+ <http://maven.apache.org/>

If [git](http://git-scm.com/) is present

	git clone https://github.com/aniljava/mgsv-ws-client.git
	cd mgsv-ws-client
	mvn package
	cp target/ws-client-1.0-RC3-jar-with-dependencies.jar ./
	java -jar ws-client-1.0-RC3-jar-with-dependencies.jar [ARGUMENTS]

From Source archive without git

	wget https://github.com/downloads/aniljava/mgsv-ws-client/mgsv-ws-client.tar.gz
	tar -xzf mgsv-ws-client.tar.gz
	cd mgsv-ws-client
	mvn package
	cp target/ws-client-1.0-RC3-jar-with-dependencies.jar ./
	java -jar ws-client-1.0-RC3-jar-with-dependencies.jar [ARGUMENTS]


### Configuration and Installation
#### Configuration
Program checks for config.properties in the local folder. Remote URL for webservice can be configured using config.properties. Below is the example of the content in config.properties. If not present localhost:8081 is assumed.

    remote=http\://127.0.0.1\:8081/MGSVService
    
#### Arguments
Program takes three arguments seperated by space. Except for first parameter other two are optional. If none is provided, a demo mode is activated that uses s.gz and a.gz for synteny and annotation file from current directory
if they exist. 

- synteny : synteny file, if starts with http:// url is assumed
- annotation : annotation file, if starts with http:// url is assumed
- email : email