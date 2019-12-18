# Top Tweeters (Java Version)

## Authors
Varun Peesapati

## Objective of Project
The main objective of this project was to read and parse a valid CSV file and if the file is valid, print the top 10 (depending on the number of entries) people that have been mentioned the most. The names of the people are based off of whatever is under the **name** column present in the CSV file. A simple analogy of this would be that of tweeters and their tweets.

## Description of Project

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