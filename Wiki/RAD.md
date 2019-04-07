# Introduction
## Purpose of the system
PrepMaster aims to facilitate a English preparatory school students' learning.
## Scope of the system
PrepMaster will work on Android devices and mainly help students with retention of the English words in their memory.
## Objectives and success criteria of the project
PrepMaster shall include the (Çankaya University's) English preparatory school's target vocabulary and questions that may help students recall these words. Questions' asking shall be timed according to the SuperMemo 2 spacing formula.
## Definitions, acronyms, and abbreviations
None so far.
## References
SuperMemo 2:https://www.supermemo.com/en/archives1990-2015/english/ol/sm2
## Overview
# Current system
Currently, there is no digital system that helps the students learn the target vocabulary.
# Proposed system
## Overview
PrepMaster will help Preparatory School students learn and remember English words more efficiently by enabling students to study English in short bursts on their smart phone, everyday. 

Students will use PrepMaster everyday to go over the English words they learned in school that week, and if there is need, to study earlier weeks' words.

PrepMaster will use SuperMemo algorithm to make sure students retain their knowledge of words.

## Functional requirements
- PrepMaster shall display a variety of questions to make sure the user learnt the word in question.
- PrepMaster shall time the gap between the asking of questions to satisfy spaced repetition requirements.


## Non functional requirements
### Usability
- PrepMaster shall have a simple UI.

### Reliability
- PrepMaster shall download all the necessary data before a study session so that the studying does not get interrupted.
- PrepMaster shall backup all the user data to its server so that the users never lose progress.

### Performance
- PrepMaster shall send as small data as possible to server (an server to PrepMaster) to make sure it is performant.

### Supportability
- It shall be easy to add features such as new question types to the PrepMaster app.

### Implementation
- PrepMaster app shall work on devices with Android OS.
- PrepMaster server shall run on servers with PHP 7+ & MySQL 5+ support.

### Interface
- No constraints here, since PrepMaster & server will only contact each other and no other outside technology.

### Packaging
- PrepMaster  shall be available to users through Google Play Store and/or the F-Droid store.
- It may also be packaged as APK and delivered through the Releases page of Github.

### Legal
- No legal requirements known at this time.

## System models
### Scenarios
#### Practicing English Words
1. User launches the app and logs in.
2. User picks the option for practicing.
3. User decides what kind of practice that they want to do and starts practicing.
4. App requests and downloads latest study data from the server.
5. App shows the question.
6. User answers the question (multiple-choice, filling the blanks etc.).
7. App checks correctness of the answer.
8. Correctness info gets logged to the database.
9. Reminding algorithm calculates when to remind the user for studying a particular word.

### Use case model
![UML Use Case Diagram](uml.png "UML Use Case Diagram")

### Object model
![UML Class Diagram](UMLClassDforAndroid.svg "PrepMaster Class Diagram for Android Frontend")
![Object Model for Questions](abstractobjectmodel.png "Object Model for Questions")

### Dynamic model
![Sequence Diagram](Sequence.png "Sequence Diagram")

### User interface—navigational paths and screen mock-ups
![UI Sketches](ui.png "PrepMaster UI")

# Glossary
Not needed.