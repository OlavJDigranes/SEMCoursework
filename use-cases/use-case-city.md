# USE CASE: 2, Produce cities reports

## CHARACTERISTIC INFORMATION

### Goal in Context

Produce an ordered report of the cities of the world

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

WHO Employee.

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
