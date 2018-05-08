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



![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/class_packageDiagram.png)

## How software saves the information

Classes [yatzy.dao.FileUserDao](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/FileUserDao.java) and [yatzy.dao.FileStatisticsDao](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/dao/FileStatisticsDao.java) take care of saving the information into databases. 

Classes are built following the [Data Acces Object](https://en.wikipedia.org/wiki/Data_access_object)-model. Classes have been isolated behind the interfaces yatzy.dao.UserDao and yatzy.dao.StatisticsDao, so the software logic is not using the classes directly.

### Files

Software saves users and statistics into a separate file. File name is determined in [yatzy.domain.YatzyService's constructor](https://github.com/johyry/otm-harjoitustyo/blob/master/Yatzy/src/main/java/yatzy/domain/YatzyService.java) and it is called usersAndStatistics.db.

Software uses sqlite for database handling.



## Main functionalities

### Creating a new user

### Logging in

### One turn in game

### Viewing statistics




## Weaknesses left on the software






