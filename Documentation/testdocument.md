# Test Document

This program has been tested by automated unit- and intergation-tests with JUnit and manually performed systemlevel tests.

## Unit and Integration testing

### Softwarelogic

The core of the automated tests are testing softwarelogic package [yatzy.domain](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain). Classes testing this package are:

- [YatzyServiceTest](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/test/java/yatzy/domain/YatzyServiceTest.java)

- [UserServiceTest](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/test/java/yatzy/domain/UserServiceTest.java)

- [StatisticsServiceTest](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/test/java/yatzy/domain/StatisticsServiceTest.java)

- [ScoreSheetServiceTest](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/test/java/yatzy/domain/ScoreSheetServiceTest.java)

They simulate an usual Yatzy game.

### DAO-classes

Both DAO-classes have been tested by creating a test.db and inserting and testing data there.
Class testing DAO is:

- [FileUserDaoTest](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/test/java/yatzy/dao/FileUserDaoTest.java)

[FileStatisticsService](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/FileStatisticsDao.java) has been tested through StatisticsServiceTest.

### Test coverage

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/testResults.png)


Without testing the UI, 73% of the instructions have been tested and 60% of the branches.

**The amount of test coverage is low because of certain print functions in code. By covering these functions the test coverage would raise up to 90% but it doesn't make much sense to test these functions. If grafical interface was to be implemented to the game, printing functions would change a little making their testing much more reasonable. Right now they are just void functions.**

## System testing

This has been performed manually.

### Installation and configuration

Program has been installed and it has been tested on LINUX and WINDOWS operating systems.

### Functionalities

All the functionalities listed by [Instructions](Documentation/instructions.md) and [Requirement declaration](Documentation/requirementdeclaration.md) have been tested. All user inputs are being validated by program.

