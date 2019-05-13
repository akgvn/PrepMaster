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

There will be a MySQL server to manage data for all users. The Android app will download the necessary data each time it runs.

## Access control and security

Each user will have an username and a password, this data will be stored in the database in encrypted form. 

The users will only be able to access their questions for each day and answer them. Later the app will send question data to the server using their own username & password data.

After checking the authenticity of username & password, server will do necessary calculations on the data sent from the app and store the changes in the database for each user.

No other admin intervention will be needed after deployment.

## Global software control

The app and the server will communicate with a REST API and the JSON data sent through this API.

Each change will be time stamped by the app and and the server will check the correctness of time data. If there are no problems, change will be applied.

## Boundary conditions

### Start-up and shutdown

PrepMaster app can be started and shut down easily. It will store the data to send the database in plain text until it is safely sent.

When the PrepMaster server is started, it will start doing the Supermemo calculations for the most frequent users.

When the PrepMaster server is shut down, it will make sure any data sent from the app is processed and stop accepting any more.

### Error behaviour

- A network failure in connection between a Android app and the server are interrupted.
- A server failure in which the server is unexpectedly terminated.

Network failure should not be fatal since the important data to be sent from an app is stored until it is confirmed sent to the database.

Server failure can be fatal, frequent backups will be made to make sure a damage by server failure is minimal.

# Subsystem services

PrepMaster server will have a REST API to communicate with the app. It is written in PHP.

PrepMaster app will be written in Java for Android.