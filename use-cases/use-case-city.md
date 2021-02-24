# USE CASE: 2, Produce cities reports

## CHARACTERISTIC INFORMATION

### Goal in Context

As a WHO HR advisor, I want to produce the following reports:

1. All the cities in the world organised by largest population to smallest.
2. All the cities in a continent organised by largest population to smallest.
3. All the cities in a region organised by largest population to smallest.
4. All the cities in a country organised by largest population to smallest.
5. All the cities in a district organised by largest population to smallest.
6. The top N populated cities in the world where N is provided by the user.
7. The top N populated cities in a continent where N is provided by the user.
8. The top N populated cities in a region where N is provided by the user.
9. The top N populated cities in a country where N is provided by the user.
10. The top N populated cities in a district where N is provided by the user.
11. All the capital cities in the world organised by largest population to smallest.
12. All the capital cities in a continent organised by largest population to smallest.
13. All the capital cities in a region organised by largest to smallest.

in order to help the WHO monitor population sizes in the specified cities.

### Scope

Java program.

### Level

Primary task

### Preconditions

Database with informations about the cities.

### Success End Condition

An ordered list of all the cities in the world given the specification of the request.

### Failed End Condition

An empty or unordered list or an error message.

### Primary Actor

WHO HR Advisor.

### Trigger

Request for information.

## MAIN SUCCESS SCENARIO

1. Request information.
2. The database retrieves the informations.
3. The program orders the list of informations depending on the specification of the request.
4. Display the list of informations.

## EXTENSIONS

2. No information given, database is not working:
      1. Reconnect to database.
3. The specification is not correct:
      1. Redefine the specification of the request.
## SUB-VARIATIONS

1. No sub-variations.

## SCHEDULE

**DUE DATE**: Release 1.0
