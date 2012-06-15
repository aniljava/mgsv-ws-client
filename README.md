mgsv-ws-server
==============

Demo client application for mGSV Web Services. Small files can be uploaded to remote mGSV server using this program.

### Overview
Program looks for the existence of config.properties in the current folder. If file exists, it is used to extract the address of Web Service URL, if it does not
localhost is assumed.

### Installation
#### Binary
Download prebuilt jar from : <https://github.com/downloads/aniljava/mgsv-ws-clientdemo/clientdemo-1.0-RC2-jar-with-dependencies.jar>
Execute the jar with arguments and configuration (See Configuration/Arguments Section Below)

#### Source

Depends on JDK1.6+ and Maven installed.

	git clone https://github.com/aniljava/mgsv-ws-clientdemo.git
	cd mgsv-ws-clientdemo
	mvn package
	cp target/clientdemo-1.0-RC2-jar-with-dependencies.jar ./
	java -jar clientdemo-1.0-RC1-jar-with-dependencies.jar [ARGUMENTS]


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