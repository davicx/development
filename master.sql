#MY QUERIES 


SELECT City, State FROM Station;

#Find Even ID
SELECT city FROM station WHERE id % 2 = 0;

#distinct city
SELECT DISTINCT city FROM station;


#difference between the total number of CITY entries in the table and the number of distinct CITY entries in the table.
SELECT (COUNT(city)- COUNT(distinct city)) from station; 

#Query the two cities in STATION with the shortest and longest CITY names, as well as their respective lengths (i.e.: number of characters in the name). 
If there is more than one smallest or largest city, choose the one that comes first when ordered alphabetically.
SELECT CITY,LENGTH(CITY)
FROM STATION
WHERE LENGTH(CITY) IN (
  SELECT MAX(LENGTH(CITY))
  FROM STATION
  UNION
  SELECT MIN(LENGTH(CITY))
  FROM STATION
)
ORDER BY LENGTH(CITY) DESC,CITY ASC LIMIT 2;

#Variables
SELECT @start := 1, @finish := 10;

SELECT * FROM places WHERE place BETWEEN @start AND @finish;

#Procedures
CREATE PROCEDURE SelectAllCustomers
AS
SELECT * FROM Customers
GO;
Execute the stored procedure above as follows:

EXEC SelectAllCustomers;

#Weather Observation Station 5

SELECT city, length(city) from station
order by length(city),city asc
limit 1;
SELECT city, length(city) from station
order by length(city) desc
limit 1;


#ALL COMMANDS 
SELECT DISTINCT Country FROM Customers;

SELECT COUNT(DISTINCT Country) FROM Customers;

#lists the number of different (distinct) customer countries:
SELECT COUNT(DISTINCT Country) FROM Customers;

#Where 
SELECT * FROM Customers WHERE Country='Mexico';
SELECT * FROM Customers WHERE CustomerID=1;

<>	Not equal. Note: In some versions of SQL this operator may be written as !=	
BETWEEN	Between a certain range	
LIKE	Search for a pattern	
IN	To specify multiple possible values for a column

AND OR NOT 

SELECT * FROM Customers ORDER BY Country;

INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('Cardinal', 'Tom Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');

UPDATE Customers SET ContactName = 'Ally Schmidt', City= 'Frankfurt' WHERE CustomerID = 1;

DELETE FROM Customers WHERE CustomerName='Name';

SELECT TOP 3 * FROM Customers;

SELECT * FROM Customers LIMIT 3;

SELECT MIN(Price) AS SmallestPrice FROM Products;
SELECT MAX(Price) AS LargestPrice FROM Products;
SELECT COUNT(ProductID) FROM Products;
SELECT AVG(Price) FROM Products;
SELECT SUM(Price) FROM Products;

SELECT * FROM Customers WHERE CustomerName LIKE 'a%';
SELECT * FROM Customers WHERE City LIKE 'ber%';

SELECT * FROM Customers WHERE Country IN ('Germany', 'France', 'UK'); (or NOT IN)
SELECT * FROM Products WHERE Price BETWEEN 10 AND 20;

(INNER) JOIN: Returns records that have matching values in both tables
LEFT (OUTER) JOIN: Returns all records from the left table, and the matched records from the right table
RIGHT (OUTER) JOIN: Returns all records from the right table, and the matched records from the left table
FULL (OUTER) JOIN: Returns all records when there is a match in either left or right table

SELECT Orders.OrderID, Customers.CustomerName FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

SELECT Customers.CustomerName, Orders.OrderID FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID ORDER BY Customers.CustomerName;

SELECT Customers.CustomerName, Orders.OrderID FROM Customers
FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID
ORDER BY Customers.CustomerName;


