# VanHackaton Seven Snake Challenge

## Challenge details

https://docs.google.com/document/d/1pgc1EiJFOAxaEwfFI0PyUkbUSPAckYKgIZ4N407oj94/edit

### Implementation details

To solve this challenge, I built all snakes possibilities with 7 adjacent positions and iterate over the matrix to calculate sum of integers with parallelism, stores the reference of snake in a thread safe dictionary, when a snake with same size is found, then verify in dictionary snakes with same sum if these snakes don't share cells print the match. 
If don't find any match, then print FAIL.


## Technologies

Java 8 with maven for dependency management and build management.


## Running app

### Requirements:

 * JRE 1.8 or higher

### Running

The compiled jar file is available at build folder.

To run this program, run the following command:

```
java -jar ./build/sevensnake.jar /path/to/csvfile.csv
```


## Building app

### Requirements:

 * Maven version 3 or higher
 * JDK 1.8 or higher

### Building

Run command on root path

```
mvn clean install
```





