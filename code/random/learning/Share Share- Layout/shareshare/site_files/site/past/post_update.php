<?php
require_once('../includes/connection.inc.php');
// initialize flags
$OK = false;
$done = false;
// create database connection
$conn = dbConnect('write');
// initialize statement
$stmt = $conn->stmt_init();
// get details of selected record

if (isset($_GET['post_id']) && !$_POST) {
  // prepare SQL query
  $sql = 'SELECT post_id, url, caption FROM posts WHERE post_id = ?';
  if ($stmt->prepare($sql)) {
	// bind the query parameter
	$stmt->bind_param('i', $_GET['post_id']);
	// bind the results to variables
	$stmt->bind_result($post_id, $url, $caption);
	// execute the query, and fetch the result
	$OK = $stmt->execute();
	$stmt->fetch();
  }
}

// if form has been submitted, update record
if (isset($_POST ['update'])) {
  // prepare update query
  $sql = 'UPDATE posts SET url = ?, caption = ?
		  WHERE post_id = ?';
  
  $item1 = "TEST";
  $item2 = "TEST2";
  
  if ($stmt->prepare($sql)) {
	$stmt->bind_param('ssi', $_POST['title'], $item1, $_POST['post_id']);
	//$stmt->bind_param('ssi', $item1, $item2, $_POST['post_id']);
	
	$done = $stmt->execute();
  }
}


// redirect if $_GET['article_id'] not defined
if ($done || !isset($_GET['post_id'])) {
  header('Location: http://localhost/ShareShare/site_files/posts/post_list.php');
  exit;
}
// store error message if query fails
if (isset($stmt) && !$OK && !$done) {
  $error = $stmt->error;
}

?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Update Post</title>
<link href="style/admin.css" rel="stylesheet" type="text/css">
</head>

<body>
<h1>Update Post</h1>
<p><a href="post_list.php">List all entries </a></p>
<?php 
if (isset($error)) {
  echo "<p class='warning'>Error: $error</p>";
}
if($post_id == 0) { ?>
<p class="warning">Invalid request: record does not exist.</p>
<?php } else { ?>
<form id="form1" method="post" action="">
  <p>
    <label for="title">url:</label>
    <input name="title" type="text" class="widebox" id="title" value="<?php echo htmlentities($url, ENT_COMPAT, 'utf-8'); ?>">
  </p>
  <p>
    <label for="post">caption:</label>
    <textarea name="article" cols="60" rows="8" class="widebox" id="article"><?php echo htmlentities($caption, ENT_COMPAT, 'utf-8'); ?></textarea>
  </p>
  <p>
    <input type="submit" name="update" value="Update Entry" id="update">
    <input name="post_id" type="hidden" value="<?php echo $post_id; ?>">
  </p>
</form>
<?php } ?>
</body>
</html>