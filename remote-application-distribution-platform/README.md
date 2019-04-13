# Baseline Checker

The Baseline Checker is made to aid in diagnosing both simple and complex installation/configuration problems. Rather than following lengthy procedures to determine where the problem is, let this tool find it for you. The tool may need you to enter a few things before it begins, to do its verifications. A report will be generated when it is complete.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Java 8
NPM

### Installing

A step by step series of examples that tell you how to get a development env running

First, install dependencies and build the project with one command

```
gradlew build
```

To run, locate the jar in the build\libs folder

```
java -jar build\libs\java-baseline-checker-0.01.jar
```

The console will output test testResults as they run.

## Running the tests

Unit tests for the services and utilities

```
gradlew test
```

## Deployment

To run, locate the jar in the build\libs folder

```
java -jar build\libs\java-baseline-checker-0.01.jar
```

## Authors

* **Shannon Levinger** - *Project Manager*
* **Alex Finch** - *Technical Lead*
* **Jacob Young** - *Developer*
* **Joe Jackson** - *Developer*
* **Anvesh Gundlapalli** - *Developer*
* **Daniel Fitzpatrick** - *Developer*

See the list of [contributors](https://gitlab.services.solute.us/gccs-diagnotic-tool/java-baseline-checker/graphs/master) who participated in this project.
