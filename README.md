# Anagrams

## Description

This application is completed as a backend development task.
The result is an simple Java CLI application which can check if two provided strings are anagrams.
If they are, they will be stored in the application memory and retrieved as a list
of anagrams for the provided string.

## Requirements

User should have Maven build tool and Java (JDK, minimum version 16) installed on the system. It may
be worth noting that the application was developed in Java 17 and tested using Apache Maven 3.6.1 on
MacOS. IDE used for development was IntelliJ IDEA.
Main focus of the application code is on code readability.

## Installation

To install the application and be able to use `anagrams.jar` from command line, user should
run command:

    $ mvn clean install

Command will run tests and build executable `anagrams.jar` in directory:

    target/anagrams-app

## Usage

User should position itself into `target/anagrams-app` directory and run command:

    $ java -jar anagrams.jar


### App Menu Options

When running the app, user will be presented with the following menu:

```
Select an option:
1. Check if two texts are anagrams
2. Get all anagrams for a given text
3. Exit
```
User needs to enter the number of the option to select it and then press Enter.

#### 1. Check if two texts are anagrams

This option will ask user to provide two strings and will check if they are anagrams.
After each string user needs to press Enter to confirm the input.

```
Enter the first text:
listen
Enter the second text:
silent
They are anagrams.
```

#### 2. Get all anagrams for a given text

This option will ask user to provide a string and will return all anagrams for it if this string
was provided in menu option 1.
Please note that if the user exists the app, all anagrams will be lost.

```
Enter the text to find its anagrams:
listen
Anagram app records for provided text: [silent]
```

#### 3. Exit

This option will exit the app.

### Running tests

As mentioned in Installation chapter, tests execute while installing the app. To run only tests user
can use the command:

    $ mvn test

This command will build source files and run tests.

#### Test output

```
❯ mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------< org.dida43:anagrams >-------------------------
[INFO] Building anagrams 1.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- resources:3.3.0:resources (default-resources) @ anagrams ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO]
[INFO] --- compiler:3.10.1:compile (default-compile) @ anagrams ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- resources:3.3.0:testResources (default-testResources) @ anagrams ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO]
[INFO] --- compiler:3.10.1:testCompile (default-testCompile) @ anagrams ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- surefire:3.0.0-M5:test (default-test) @ anagrams ---
[WARNING] Parameter 'localRepository' is deprecated core expression; Avoid use of ArtifactRepository type. If you need access to local repository, switch to '${repositorySystemSession}' expression and get LRM from it instead.
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.dida43.anagrams.ui.ConsoleInterfaceTest
Enter the text to find its anagrams:
Enter the text to find its anagrams:
Enter the text to find its anagrams:
Enter the first text:
Enter the first text:
Enter the first text:
Enter the second text:
Enter the second text:
Enter the second text:
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.259 s - in org.dida43.anagrams.ui.ConsoleInterfaceTest
[INFO] Running org.dida43.anagrams.MainAppSystemTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s - in org.dida43.anagrams.MainAppSystemTest
[INFO] Running org.dida43.anagrams.service.AnagramServiceTest
[INFO] Tests run: 60, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.103 s - in org.dida43.anagrams.service.AnagramServiceTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 77, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.675 s
[INFO] Finished at: 2023-10-25T23:52:07+02:00
[INFO] ------------------------------------------------------------------------


```