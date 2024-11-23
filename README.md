# WESTERN GOVERNORS UNIVERSITY 
## D288 – BACK-END PROGRAMMING


DCN2 — DCN2 Task 1: Back-End Application Programming

A.   Create a new Java project using Spring Initializr, with each of the following dependencies:

•    Spring Data JPA (spring-boot starter-data-jpa)

•    Rest Repositories (spring-boot-starter-data-rest)

•    MySQL Driver (mysql-connector-java)

•    Lombok


1. CreatedSpring Initializr file and added to the project.
2. Added LabFiles to application.properties


Note: Since the application properties will be empty, you will need to copy over the supplied application properties.

B.   Create your subgroup and project by logging into GitLab using the web link provided and do the following:

•    connect your new Java project

•    commit with a message and push when you complete each of the tasks listed below (parts B to F, etc.)


3. Created GitLab subgroup and connected to my project.


Note: Any submissions that do not have a commit after each task will not be evaluated.

Note: You may commit and push whenever you want to back up your changes, even if a task is not complete.

•    Submit a copy of the git repository URL and a copy of the repository branch history retrieved from your repository, which must include the commit messages and dates.

Note: Wait until you have completed all the following prompts before you create your copy of the repository branch history.


C.   Construct four new packages, one for each of the following: controllers, entities, dao, and services. The packages will need to be used for a checkout form and vacations packages list.

Note: The packages should be on the same level of the hierarchy.

Note: Construct a package named config and copy the RestDataConfig.java provided in the laboratory environment to the package. Modify it so that the package and imports have the correct package and import addresses. Copy the application.properties file that is provided in the laboratory environment into your application properties resource file.


5. Created package named config and copied RestDataConfig.java into it.
6. Created four new packages: controllers, entities, dao, and services.


D.   Write code for the entities package that includes entity classes and the enum designed to match the UML diagram.


7. Created entity file Carts.java and added lines 1-32
8. Created entity files Customer.java, StatusType.Java, and Division.java. Added lines 1-34 to Customer.java
9. Created entity file Country.java
10. Added lines 1-24 to Division.java
11. Added lines 1-26 to Country.java
12. Changed file name Carts.java to Cart.java
13. Created entity file CartItem.java.
14. Imported java class "Set"
15. Created entity files Vacation.java and Excursion.java. Added lines 1-29 to CartItem.java
16. Added lines 1-32 to Excursion.java
17. Added lines 1-33 to Vacation.java
18. Added getters, setters, enums for all entity files.
19. StatusType.java, changed class to enum, added Line 4
20. Cart.java, added line 38 - enumerated, added lines 54 and 55
21. Added timestamp functionality and mapping to entity files


E.   Write code for the dao package that includes repository interfaces for the entities that extend JpaRepository, and add cross-origin support.


22. Created dao>files: CartItemRepository.java, CartRepository.java, CountryRepository.java, Customer Repository.java, DivisionRepository.java, ExcursionRepository.java, and VacationRepository.java.
23. Extended JpaRepository for all dao files
24. Added cross-origin support for all dao files


F.   Write code for the services package that includes each of the following:
•    a purchase data class with a customer cart and a set of cart items
•    a purchase response data class that contains an order tracking number
•    a checkout service interface
•    a checkout service implementation class


25. Created classes in services package: Purchase.java, PurchaseResponse.java, Checkout.java, CheckoutServiceImpl.java


G.   Write code to include validation to enforce the inputs needed by the Angular front-end.


H.   Write code for the controllers package that includes a REST controller checkout controller class with a post mapping to place orders.

Note: You do not need to duplicate REST functionality for each repository by creating methods in Java.


I.   Add five sample customers to the application programmatically.

Note: Make sure the customer information is not overwritten each time you run the application.


J.   Run your integrated application by adding a customer order for a vacation with two excursions using the unmodified Angular front-end. Provide screenshots for the following:

•    that your application does not generate a network error when adding the data

•    your database tables using MySQL Workbench to show the data was successfully added

Note: The screenshot should include the front-end view and the inspection console in the browser.


K.   Demonstrate professional communication in the content and presentation of your submission.
