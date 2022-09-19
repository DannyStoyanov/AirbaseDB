# Airbase database

## Introduction

The program is a database management system for airbase, providing the following basic actions with aircraft records: "create", "show", "delete", "update" and "search". There is additional command "help" to show you full list with commands.

## Architecture

The main idea of the project is based on the architecture which is the command pattern - a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time.

![architecture image](/doc/diagram_1.jpeg)

## Requirements

JVM(Java Virtual Machine)

## Usage

The program is run via the command-line. There are several commands to operate with the database:

- create - create record with id, name, type and number of flights and save it to the database

        create <id> <name> <type> <flights>

- delete - delete record with the given id

        delete <id>

- update - update attribute of plane with the given id

        update <id> <attribute> <new_value>

- show - display list of records from offset to limit

        show <offset> <limit> 

- search - display whether record with the given id is in the database

        search <id>

- help - provide full list of the commands

        help

- exit - exit the program

        exit
