# USE CASE: 1, Produce country reports

## CHARACTERISTIC INFORMATION

### Goal in Context

As a WHO Statistical advisor, I want to produce the following reports:

1. All the countries in the world organised by largest population to smallest.
2. All the countries in a continent organised by largest population to smallest.
3. All the countries in a region organised by largest population to smallest.
4. The top N populated countries in the world where N is provided by the user.
5. The top N populated countries in a continent where N is provided by the user.
6. The top N populated countries in a region where N is provided by the user.

in order to help the WHO monitor population size in the specified countries.

### Scope

WHO Statistics Department.

### Level

Primary task

### Preconditions

Database with informations about the countries.

### Success End Condition

An ordered list of all the countries in the world.

### Failed End Condition

An empty or unordered list or an error message.

### Primary Actor

WHO HR Advisor.

### Trigger

Request for information.

## MAIN SUCCESS SCENARIO

1. Request information.
2. The database retrieves the informations.
3. The program orders the list of informations.
4. Display the list of informations.

## EXTENSIONS

2. No information given, database is not working
      1. Reconnect to database

## SUB-VARIATIONS

1. No sub-variations.

## SCHEDULE

**DUE DATE**: Release 1.0
