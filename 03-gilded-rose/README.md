# Gilded Rose Kata

L'objectif de ce Kata est de travailler le TDD sur du code existant.

Le code marche bien (en production depuis plusieurs années), mais on ne comprend pas forcement comment...

La consigne : (https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.md).

Il faut réaliser la consigne en suivant le cycle TDD (Red-Green-Refactor).

Peut-être on peut commencer par écrire des tests pour comprendre le code existant.

## Nous avons une aide supplémentaire !

En suivant les instructions ci-dessous, nous pouvons tourner un test qui valide le comportement général de l'application,
et ainsi vérifier que on n'a pas cassé le code de production.

Rémarque : ceci n'est pas toujours le cas dans la vrai vie...

Source: [GildedRose by Emily Bache](https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/main)

# Install and run approval test with TextTest

## Run the TextTest Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).


## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. The first uses Gradle wrapped in a python script. Uncomment these lines to use it:

    executable:${TEXTTEST_HOME}/Java/texttest_rig.py
    interpreter:python

The other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr). Uncomment these lines to use it instead:

    executable:com.gildedrose.TexttestFixture
    interpreter:java
