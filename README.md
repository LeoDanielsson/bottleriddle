#Bottle Riddle Solver#

Application that will solve the following riddle

>A classic puzzle starts with two unmarked bottles that can hold 3 liters and 5 liters respectively, and a bathtub with unlimited water.

>You are allowed to either fill a bottle, empty a bottle or pour one bottle into the other until either the source bottle is empty or the target bottle is full.

>How can 1 liter be measured?

>How can 4 liters be measured?

## Running ##
###Running using maven###
* Requires JDK 8 to be installed and JAVA_HOME environment variable to be set
* Requires Maven to be installed and added to PATH environment variable

Navigate to repository root and run the following on command line:
```
mvn verify exec:java
```
The solution to the riddle will be printed in the console.

###Running using IDE###
* Requires JDK 8 to be installed and an IDE that can handle Java 8.

Import the code into your favourite IDE and run Main.java