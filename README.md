WEEK 1 — Introduction to Advanced Java
Topics

What is Java?

JDK installation & environment setup

Java program structure

Operators, data types

OOP recap: class, object, encapsulation, abstraction

✅ Project 1.1 — Java System Environment Scanner

Build a program that displays:

Java version

OS name

User directory

Available memory

Classpath

✅ Project 1.2 — Student Bio Profile (OOP Beginner Project)

Create a class Student containing:

name, regNo, email, year

constructor and getters
Program prints the student’s profile in formatted output.

WEEK 2 — Program Control, Objects & Classes, STL Concepts
Topics

Looping, selection, sequence

Constants

Constructors & initialization

Java Collections Introduction

✅ Project 2.1 — Smart Calculator with Menu

A menu-driven calculator implementing:

loops

switch statements

user-defined methods

✅ Project 2.2 — Class-Based Marksheet Generator

Use OOP + arrays to:

input 5 units

calculate total, average, grade

store results inside a class

WEEK 3 — Inheritance & Polymorphism
Topics

Single & multilevel inheritance

Overloading vs overriding

Interfaces & abstract classes

Polymorphic references

Inner classes

✅ Project 3.1 — Employee Payroll Inheritance System

Create base class Employee and subclasses:

FullTimeEmployee

ContractEmployee

PartTimeEmployee
Compute salary polymorphically.

✅ Project 3.2 — Shape Area Calculator (Polymorphic Program)

Abstract class Shape → Circle, Rectangle, Triangle
Each overrides area() method.

WEEK 4 — Exception Handling & Basic Multithreading
Topics

try–catch–finally

throw & custom exceptions

try-with-resources

Introduction to events

Starting threads

✅ Project 4.1 — Bank Transaction Exception System

Throw exceptions for:

insufficient funds

invalid PIN

negative amounts

✅ Project 4.2 — Multi-Threaded Counter Program

Run 3 threads counting numbers simultaneously.
Use Thread and Runnable.

WEEK 5 — CAT 1
WEEK 6 — Operator Overloading Concepts (Java Simulation)
Topics

What is operator overloading?

Java limitations

String concatenation

Using methods to simulate operators

✅ Project 6.1 — Custom Math Operator Simulator

Create a class MyNumber with methods:

add(), subtract(), multiply(), divide()
Simulate operator overloading the Java way.

✅ Project 6.2 — String Formatter Utility

Implement methods that mimic operator behavior for strings:

combine()

compare()

repeat()

concatNumbers()

WEEK 7 — Function Templates & Class Templates (Generics)
Topics

Generic classes

Generic methods

Bounded types

Wildcards: ? extends, ? super

Generic collections

✅ Project 7.1 — Generic Data Storage Box

Create class Box<T> with:

addItem()

getItem()

printType()

✅ Project 7.2 — Generic Sorting Algorithm

Implement a generic bubble sort or insertion sort method:

<T extends Comparable<T>>
void sort(T[] array)

WEEK 8 — Threads, Processes, Synchronization
Topics

Runnable interface

Thread lifecycle

Thread synchronization

Critical sections

Thread control: sleep(), join(), interrupt()

✅ Project 8.1 — Producer-Consumer Simulation

Use:

Two threads (Producer & Consumer)

Shared buffer

Synchronization (wait() & notify())

✅ Project 8.2 — Multi-threaded File Searcher

Scan a directory using threads:

each thread searches a specific file type (e.g., .txt, .pdf, .java)

WEEK 9 — Advanced File Handling
Topics

File creation & deletion

Sequential vs random access

Text & binary files

RandomAccessFile (seek/tell functions)

✅ Project 9.1 — Student Records File-Based Database

Features:

add

list

delete

search
Stored using RandomAccessFile.

✅ Project 9.2 — File Analyzer Tool

Reads a file and outputs:

number of lines

number of words

file size

last modified date

WEEK 10 — CAT 2
WEEK 11 — Remote Method Invocation (RMI) & Sockets
Topics

RMI architecture

RMI registry

Client-server communication

Socket programming

✅ Project 11.1 — RMI-Based Calculator

Implement:

add

subtract

multiply

divide
Client invokes remote methods.

✅ Project 11.2 — Socket-Based Chat Application (Basic)

Client ↔ Server communication using sockets.
Text messages exchanged in real time.

WEEK 12 — GUI Programming with Swing / Component-Based Development
Topics

Swing components (JFrame, JButton, JTextField)

Events & listeners

Layout managers

Formatting numbers & dates

✅ Project 12.1 — Swing Student Registration GUI

GUI with:

registration form

validation

table for displaying students

✅ Project 12.2 — Simple Calculator (GUI Edition)

Buttons for digits & operations
Use ActionListener for all events.

WEEK 13 — Databases, JDBC, AWT, Swing + GUI Database Projects
Topics

JDBC API

SQL queries in Java

ResultSet handling

Database CRUD operations

Swing database application

✅ Project 13.1 — Inventory Management System (GUI + MySQL)

Perform full CRUD:

add item

update item

view all items

delete item
All linked to a database.

✅ Project 13.2 — Login System with Database Validation

Using Swing GUI + JDBC:

Register user

Login

Store encrypted passwords

WEEK 14 — Revision & Final Exam
Revision Activities

Review all core topics

Practice exam-style questions

Optimize and complete final assignments

Final Practical Task (Optional Suggestion)

Build a complete Java desktop application combining:

Threads

File I/O

GUI (Swing/JavaFX)

Database connectivity (JDBC)

Exception handling

---

## Additional Java Project Ideas (Beginner → Advanced)

**BEGINNER-LEVEL PROJECTS**
Covers: Variables, loops, arrays, methods, conditionals, classes

1. Simple Calculator (CLI) — input/output, methods, switch statements
2. Student Grade Calculator — arrays, loops
3. Number Guessing Game — random numbers, loops, conditionals
4. Temperature Converter — methods, arithmetic
5. Bank Account Simulation — classes, objects, constructors

**INTERMEDIATE-LEVEL PROJECTS**
Covers: OOP, collections, file handling, exceptions

6. Library Management System (CLI) — OOP, ArrayList, file storage
7. Employee Payroll System — inheritance, polymorphism
8. Inventory Management System — ArrayList/HashMap
9. Quiz Application — objects, arrays, file reading
10. ATM Simulation System — OOP, encapsulation, loops

**ADVANCED-LEVEL PROJECTS**
Covers: multithreading, JDBC, networking, GUI (Swing/JavaFX), design patterns

11. Student Registration System (with Database) — JDBC + MySQL
12. Chat Application (Socket Programming) — networking, multithreading
13. Online Banking System — MVC architecture, JDBC, OOP
14. Hospital Management System — Swing GUI, database, CRUD
15. File Encryption/Decryption Tool — hashing, encryption algorithms
16. E-Commerce Console App — design patterns, collections
17. Task Management Desktop App (JavaFX) — GUI, data persistence
18. Multithreaded Web Crawler — threads, networking
19. Expense Tracker App — file I/O + GUI
20. REST API Backend with Spring Boot — enterprise Java