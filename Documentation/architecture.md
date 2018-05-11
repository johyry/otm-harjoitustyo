# Architecture of the program

## Structure

The structure of the program follows three-layer layerarchitecture, and the package structure of the code is following:

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/packageDiagram.png)

Package yatzy.ui contains text-based user-interface, yatzy.domain contains softwarelogic and yatzy.dao contains code for saving information into databases.

## Interface

Interface contains six different scenes:

- Main menu
- Game menu
- Log In
- Log out
- Create new user
- View statistics

Each of them is programmed as a separate method. Interface has been programmed into class yatzy.ui.YatzyUi.

Interface has been aimed to be completely separated from software logic. It is only calling methods from the main class of software logic yatzy.domain.YatzyService.




## Software logic

The main class in the software logic is [YatzyService](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/YatzyService.java). Other main classes are:

- [UserService](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/UserService.java) handles creating user and logging in through databases
- [ScoresheetService](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/ScoreSheetService.java) handles validating scores and saving ingame scores into scoresheet.
- [StatisticsService](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/StatisticsService.java) handles viewing and adding statistics into database.
- [User](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/User.java) is just an user class with name and username.
- [Scoresheet](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/Scoresheet.java) has all the scoresheet rows as variables.
- [Statistics](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/Statistics.java) is a class to help out printing and calculating statistics when viewing them.

Everything in the software happens through [YatzyService](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/YatzyService.java). For example when:

- creating an user YatzyService calls UserService which handles creating user with [UserDao](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/UserDao.java).

- saving or viewing statistics YatzyService calls StatisticsService to handle it with [StatisticsDao](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/StatisticsDao.java)

- saving ingame scores YatzyService calls ScoresheetService which handles it with Scoresheet class. ScoresheetService also takes care of all the scorevalidations when inserting scores ingame.


![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/class_packageDiagram.png)

## How software saves the information

Classes [yatzy.dao.FileUserDao](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/FileUserDao.java) and [yatzy.dao.FileStatisticsDao](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/FileStatisticsDao.java) take care of saving the information into databases. 

Classes are built following the [Data Acces Object](https://en.wikipedia.org/wiki/Data_access_object)-model. Classes have been isolated behind the interfaces yatzy.dao.UserDao and yatzy.dao.StatisticsDao, so the software logic is not using the classes directly.

### Files

Software saves users and statistics into a separate file. File name is determined in [yatzy.domain.YatzyService's constructor](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/YatzyService.java#L21) and it is called usersAndStatistics.db.

Software uses sqlite for database handling.



## Main functionalities

### Creating a new user

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/YatzyCreateUser.png)

### Logging in

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/YatzyLogIn.png)

### One turn in game

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/YatzyOneTurn.png)

### Viewing statistics

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/YatzyViewingUsersStatistics.png)




## Weaknesses left on the software

Scoresheet and statistics classes could have been implemented with HashMap objects resulting in easier use. Also software contains some longer methods that don't pass the checkstyle tests.






