# Yatzy


<h2> Documentation </h2>

[Requirement declaration](Documentation/requirementdeclaration.md)

[Hours worked](Documentation/hours_worked.md)

[Architecture](Documentation/architecture.md)

<h2> Releases </h2>

[Release 1, week 5](https://github.com/johyry/otm-harjoitustyo/releases/tag/week5)

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


