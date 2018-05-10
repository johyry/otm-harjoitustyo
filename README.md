# Yatzy

This is a software created for playing Yatzy. Yatzy is a turn-based dice game which can be played alone or with friends. The objective of the game is to score points by rolling five dice to make certain combinations. More info on [Wikipedia](https://en.wikipedia.org/wiki/Yahtzee)

<h2> Documentation </h2>

[Instructions](Documentation/instructions.md)

[Requirement declaration](Documentation/requirementdeclaration.md)

[Hours worked](Documentation/hours_worked.md)

[Architecture](Documentation/architecture.md)

<h2> Releases </h2>

[Release 1, week 5](https://github.com/johyry/otm-harjoitustyo/releases/tag/week5)</br>
[Release 2, week 6](https://github.com/johyry/otm-harjoitustyo/releases/tag/week6)

<h2> Command line features </h2>

<h3> Testing </h3>

Perform tests:

```
mvn test
```

Test results:

```
mvn jacoco:report
```

You can have look at the report at target/site/jacoco/index.html

<h3> Generating jar-file </h3>

Command:

```
mvn package
```

Will generate a runnable jar-file into the directory target


<h3> Checkstyle </h3>

Command 

```
mvn jxr:jxr checkstyle:checkstyle
```

will run the checkups determined by [checkstyle.xml](Yatzy/checkstyle.xml)


