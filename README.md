# trading-application

Setup


This trading module uses to process one of the signals (a simple integer). Each signal specification is given by business 
in every release it is expected that up to 50 new signals will be added per month (600 after year one, 1200 after year two etc).

Clone repository.

 git clone https://github.com/neeti12/trading-application.git
Command-line Instructions
Prerequisites:
Install the latest version of Java and Maven.
Set the environment variable
post man 

# Compile and run
mvn compile install

Eclipse Instructions
Prerequisites:

Install Eclipse, the Maven plugin, and optionally the GitHub plugin.
Set up Eclipse Preferences

Window > Preferences... (or on Mac, Eclipse > Preferences...)

Select Maven

check on "Download Artifact Sources"
check on "Download Artifact JavaDoc"


Create a new Project.
Choose the Location of the project to be the location of trading application
add Maven Dependencies.
Click on Run > Run configurations


Right-click on project
Run As > Java Application

# testing

1 use = the url in postman http://localhost:port number/algo/1