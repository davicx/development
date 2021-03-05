<?php
require_once('../includes/connection.inc.php');
// create database connection
$conn = dbConnect('read');
$sql = 'SELECT * FROM comments ORDER BY created DESC';
$result = $conn->query($sql) or die(mysqli_error());

?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Manage Blog Entries</title>
<link href="style/admin.css" rel="stylesheet" type="text/css">
</head>

<body>
<h1>Manage Blog Entries</h1>
<p><a href="comment_insert.php">Insert new entry</a></p>
	
	
<table>
  <tr>
    <th scope="col">Created</th>
    <th scope="col">Title</th>
    <th scope="col">Comment</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
  </tr>
  

  <?php while($row = $result->fetch_assoc()) { ?>
  
  <?php //print_r ($row); ?>
  
  
  <tr>
    <td><?php echo $row['created']; ?></td>
    <td><?php echo $row['title']; ?></td>
	<td><?php echo $row['comment']; ?></td>
		
    <td><a href="comment_update.php?article_id=<?php echo $row['comment_id']; ?>">EDIT</a></td>
    <td><a href="comment_delete.php?article_id=<?php echo $row['comment_id']; ?>">DELETE</a></td>
  </tr>

  <?php } ?>
  
</body>
</html>