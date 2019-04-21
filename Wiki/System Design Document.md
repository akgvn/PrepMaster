System Design Document

# Introduction
## Purpose of the system
PrepMaster aims to facilitate a English preparatory school students' learning.

## Design goals

- **Low resource usage:** PrepMaster should be able to work on low-end Android devices.
- **Easy to use:** Users should understand how to use the app easily.

## Definitions, acronyms, and abbreviations
None
## References
None
## Overview

# Current software architecture
Since the system is a greenfield project, we're starting from scratch.

# Proposed software architecture

## Overview

The system consists of a mobile app and a server.

Server will contain a database to store user data and execute important business logic such as the reminding algorithm on this data.

Android app will be the front-end software that which will show and ask questions to the user to enable their learning and solidify their knowledge. 

## Subsystem decomposition

- User interface is the android app. It will be used to register users and show them the questions they need to solve for each day. When a user answers all the questions for the day, app sends the data to the server.

- Server contains the main application logic. It stores the data sent from the app to database. Later uses the data in database to generate statistics for each user and calculate the optimal time range between asking of a question for each word to remember.

- MySQL database is the storage.

## Hardware/software mapping

- Android app will run on user devices.
- MySQL database and the PHP server will work on a server.

## Persistent data management

There is a MySQL server to manage data for all users. The Android app will download the necessary data each time it runs.

## Access control and security

The users will only be able to access their questions for each day and answer them. Later the app will send question data to the server.

The server will do necessary calculations on the data sent from the app.

No other admin intervention will be needed after deployment.

## Global software control

## Boundary conditions

# Subsystem services
