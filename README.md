# Deli POS System

## Description of the Project
The DELI-cious Point of Sale (POS) system is a Java console program that helps a deli shop 
take and manage customer orders. Employees can build orders by adding sandwiches, drinks, 
and chips through simple menu options. Sandwiches can be customized by choosing the bread, 
size, toppings, sauces, and whether they should be toasted. The program also includes 
signature sandwiches, which are pre-made options that customers can still change if they want.

After an order is finished, the program creates a receipt with all the order details and 
saves it as a text file with the date and time. The project uses basic object-oriented 
programming ideas, such as using classes inheritance and polymorphism, to organize sandwiches, toppings, 
and other parts of the order.

## Diagram
[Diagram](diagram.PNG)

## User Stories
- As an employee, I want to see all items already added so I can check the order at any time.
- As an employee, I want to add a sandwich, chips and drinks to the order so the customer can customize what they want.
- As a customer, I want to customize my own sandwich with different bread type, bread size and toppings to my liking.
- As an employee, I want to see the total cost of the whole order.
- As an employee, I want the order to be saved as a receipt file when it’s finished.

## Setup
Instructions on how to set up and run the project using IntelliJ IDEA.

### Prerequisites
- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK (version 17 or above) is installed and properly configured in IntelliJ.

### Running the Application in IntelliJ
Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'YourMainClassName.main()'' to start the application.

## Technologies Used
- Java 17
- Object-Oriented Programming (OOP)
- Classes, inheritance, polymorphism, abstract classes
- File I/O (java.io)
- BufferedWriter, FileWriter, File, directory management
- java.util.Scanner for console input
- java.time / java.text for timestamps on receipts
- Collections Framework
- (ArrayList, List) for managing toppings and order items

## Demo
[Demo Video](https://drive.google.com/file/d/1I9pxaA00KvjnkLhUqlgIpew6YHYvxvGJ/view?usp=sharing)

## Future Work
- Add tax calculation and discount/promo features
- Implement a graphical user interface
- Add real-time order queue for kitchen display
- 
## Resources
- [Java Language Documentation](https://docs.oracle.com/javase/8/docs/api/)
- Class notes

## Thanks
- Thank you to Raymond Maroun for continuous support and guidance.

