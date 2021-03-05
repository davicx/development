#1 Use Sample data and find the highest affinity score for each user

#2
SELECT region, AVG(age) FROM users GROUP BY region;

#3
SELECT users.firstname, users.lastname AS total_views FROM users 
INNER JOIN internal_profile_views 
ON users.id = internal_profile_views.viewed_user_id
GROUP BY users.firstname, users.lastname ORDER BY COUNT(viewed_user_id) DESC
LIMIT 5;

#4
SELECT users.region FROM users 
INNER JOIN internal_profile_views 
ON users.id = internal_profile_views.viewed_user_id
GROUP BY users.region ORDER BY COUNT(users.region) 
LIMIT 1;

#5









/*
SELECT column, COUNT(column) AS value_occurrence
    FROM     my_table
    GROUP BY column
    ORDER BY value_occurrence DESC
    LIMIT    1;
	
	
	SELECT TBL.object_id, TBL.name, SUM(PART.rows) AS rows
FROM sys.tables TBL
INNER JOIN sys.partitions PART ON TBL.object_id = PART.object_id
INNER JOIN sys.indexes IDX ON PART.object_id = IDX.object_id
AND PART.index_id = IDX.index_id
WHERE TBL.name = @TableName
AND IDX.index_id < 2
GROUP BY TBL.object_id, TBL.name;


 

SELECT users.firstname
FROM users
INNER JOIN internal_profile_views ON users.id = internal_profile_views.id;
SELECT * FROM users LIMIT 100;

//WORKS
SELECT viewed_user_id, COUNT(viewed_user_id) AS value_occurrence 
    FROM internal_profile_views
    GROUP BY viewed_user_id
    ORDER BY value_occurrence DESC
    LIMIT 5;



//WORKS
SELECT users.id, users.firstname, user_profile_urls.user_id, user_profile_urls.profile_url
FROM users INNER JOIN user_profile_urls
ON users.id = user_profile_urls.user_id LIMIT 10;

SELECT users.id, COUNT(viewed_user_id) AS value_occurrence 
FROM users INNER JOIN internal_profile_views 
ON internal_profile_views.viewed_user_id = users.id
GROUP BY viewed_user_id
ORDER BY value_occurrence DESC
LIMIT 5;



SELECT
    internal_profile_views.viewed_user_id, users.firstname, COUNT(*)
FROM internal_profile_views
INNER JOIN users ON users.id = internal_profile_views.viewed_user_id
GROUP BY internal_profile_views.viewed_user_id LIMIT 5;




SELECT
    e.department_id,
    department_name,
    COUNT(*)
FROM
    employees e
INNER JOIN departments d ON d.department_id = e.department_id
GROUP BY
    e.department_id;

SELECT users.firstname, users.lastname AS total_views FROM users 
INNER JOIN internal_profile_views 
ON users.id = internal_profile_views.viewed_user_id
GROUP BY users.firstname, users.lastname ORDER BY COUNT(viewed_user_id) DESC
LIMIT 5;


*/















/*
Enter your query below.
Please append a semicolon ";" at the end of the query

SELECT users.firstname
FROM users
INNER JOIN internal_profile_views ON users.id = internal_profile_views.id;
SELECT * FROM users LIMIT 100;

//WORKS
SELECT viewed_user_id, COUNT(viewed_user_id) AS value_occurrence 
    FROM internal_profile_views
    GROUP BY viewed_user_id
    ORDER BY value_occurrence DESC
    LIMIT 5;



//WORKS
SELECT users.id, users.firstname, user_profile_urls.user_id, user_profile_urls.profile_url
FROM users INNER JOIN user_profile_urls
ON users.id = user_profile_urls.user_id LIMIT 10;

SELECT users.id, COUNT(viewed_user_id) AS value_occurrence 
FROM users INNER JOIN internal_profile_views 
ON internal_profile_views.viewed_user_id = users.id
GROUP BY viewed_user_id
ORDER BY value_occurrence DESC
LIMIT 5;

*/
