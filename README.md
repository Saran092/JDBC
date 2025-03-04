# JDBC

JDBC works in five main steps:

## Load the Driver :

- JDBC requires a driver to connect Java with a database.

## Establish a Connection :

- Use the Connection object to connect to the database.

## Create a Statement :

- Use Statement, PreparedStatement to execute queries.

## Execute Query :

- Run SQL queries (SELECT, INSERT, UPDATE, DELETE) and process the results.

## Close Connection :

- Always close the database connection to free resources

# General

If you have a "Select" Query you just need to createStatement() and executeQuery()

If you have any Upadte, Modify, Insert, Delete and Like Updating your table you need to prepareStatement() and executeUpdate()

You want to add jar file to connect SQL and Java 
