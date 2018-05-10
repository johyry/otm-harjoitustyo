# Instructions

Download the file JAR FILE LINK

## Configuration

There is no configuration needed. You just need to download and run the file.

## Running the game

Game can be run with the command

```
java -jar Yatzy-1.0-SNAPSHOT.jar
```

## Main menu

Software will open into main menu.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/mainMenu.png)

To play the game you first need to create an user and then log in.

## Creating user

When creating user you will first be asked the name and then username. Both are named in this case example.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/createUser.png)

## Logging in

Then you can log in. When logging in, you will only be asked the username of the user you want to log in.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/logIn.png)

## Multiple logged in users

You can log in multiple users at a time. Logged in users will be printed on top of main menu.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/multipleUsers.png)

## Playing the game

Then you can enter the game. To play the game you need to have atleast one logged in user.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/gameMenu.png)

On top you will see first printed who's turn is it. Then this player's scoresheet will be printed. And after the "Turn: 1 of example" you see five digits printed. Each of them represents one dice. 

After you have two options:

1. Throw again. It will ask you the dices you want to hold. Input needs to be in a form of: digit space digit space ... . So for example in this case: 3 4.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/throwAgain.png)

2. Insert score to scoresheet. Then you can insert the score. You will be asked the number of the cell in the scoresheet. In the scoresheet 0 represents a score which is yet to be set. If row prints "-" that means score is set for this row.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/insertScore.png)

Each turn consists of max of 3 throws. Then you must insert the score. After the game has finished, both scoresheets will be printed and winner declared.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/winnerPic.png)

## Statistics

From the main menu you can enter statistics menu.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/statisticsMenu.png)

There you can view:

1. General statistics:

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/generalStatistics.png)

Upper sheet prints the average scores of all games. The lower sheet total scores on all games.

2. User based statistics

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/userStatistics1.png)

It will first print all the users created. Then you must write the username of whose stats you want to view.

![alt text](https://raw.githubusercontent.com/johyry/otm-harjoitustyo/master/Documentation/pictures/userStatistics2.png)







