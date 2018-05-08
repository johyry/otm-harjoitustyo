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

### Files

## Weaknesses left on the software





### Class diagram

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/yatzyClassDiagram.png)
