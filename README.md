Note: This is one of my first complex projects ever done so the structure and the code readability might feel a bit hard to understand.

# Gladiators
A sophisticated single-player graphic game featuring a dynamic turn-based combat system, built with Java and JavaFX. Experience strategic battles with diverse gladiator classes, unique abilities, and multiple game modes.


## Technologies Used
Java: Core programming language

JavaFX: GUI framework for rich user interface

Maven: Dependency management and build automation

PostgreSQL: Database for local data storage
 
OOP Principles: Advanced object-oriented design patterns such as singleton for the database

## Features
Advanced OOP Architecture: Utilizes interfaces, abstract classes, and polymorphism to create diverse gladiator templates with unique strengths and abilities

Complex Combat System: Turn-based battles incorporating gladiator abilities, equipped items, and detailed stat calculations

Three Game Modes:
- Simple Fight.
- Tournament.
- Exploration.
  
Special Powers System: Abilities like Freeze Touch and Berserker that enhance strategic gameplay

Item Management: Equipment system affecting the gladiator's stats

Data Persistence: PostgreSQL integration for saving player progress, gladiators, and items
  
## Gameplay
Creating Gladiators
- Choose from various gladiator templates with unique attributes
- Customize abilities and equipment
- Manage stats and special powers
  
Combat System:
- Turn-based battles
- Ability-based attacks with calculated damage
- Item and stat influences on combat outcomes
- Special power activation during battles
  
Game Modes
- Simple Fight: 1v1 fights where the losers doesn't get killed. The limit is 3 fights beetween tournaments
- Tournament: 1v1 8 men tournament where the losers get killed.
- Exploration: A series of 1v1 where your gladiator will fight random wild animals, each animal having a different succes rate to kill your gladiator.
    
## Prerequisites
Before running this application, ensure you have the following installed:

Java JDK 11 or higher

Maven 3.6 or higher

PostgreSQL 12 or higher

JavaFX SDK (compatible with your JDK version)

## Installation & Setup
Clone the repository
- git clone https://github.com/MicuRazvan/Gladiators.git
- cd Gladiators

Set up PostgreSQL database

-Create a new PostgreSQL database named Gladiatori

Build the project
- mvn clean compile
- Run the application
- mvn javafx:run

## Database Configuration
The application requires a local PostgreSQL database. The default configuration can be changed in Database.java but as default it expects:

- Database name: Gladiatori
- Username: postgres
- Password: g
