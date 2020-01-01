# Top Tweeters (Java Version)

## Authors
Varun Peesapati

## Objective of Project
The main objective of this project was to read and parse a valid CSV file and if the file is valid, print the top 10 (depending on the number of entries) people that have been mentioned the most. The names of the people are based off of whatever is under the **name** column present in the CSV file. A simple analogy of this would be that of tweeters and their tweets.

## Description of Project
The program can be roughly divided into three different classes - namely `Tweeter.java`, `Parser.java`, and `Driver.java`. `Tweeter.java` is a class that contains information about each tweeter - more specifically their names and the number of times their tweets are present in the file. `Parser.java` is a class that parses the file and checks if the file passed as a command-line argument is a valid CSV file. `Driver.java` is a class that connects all of these classes and contains functions that are essential for solving the problem at hand, which in this case was to print the top 10 tweeters in a **valid CSV** file.

## Organization of Project
```
$ tree .
.
├── Driver.java
├── Makefile
├── Parser.java
├── README.md
├── SortByNumTweets.java
└── Tweeter.java
```

## Usage
Compilation and execution:
```
$ make
javac *.java
$ java Driver <fileName>
```
**Note**: The program needs a filename to be passed as a command line argument to execute without any issues.

Cleaning files at the end of execution:
```
$ make clean
rm -rf *.class
```