<?php
require_once('../includes/connection.inc.php');
$conn = dbConnect('write');
// initialize flags
$OK = false;
$deleted = false;
// initialize statement
$stmt = $conn->stmt_init();
// get details of selected record
if (isset($_GET['article_id']) && !$_POST) {
  // prepare SQL query
  $sql = 'SELECT article_id, title, created FROM comments WHERE article_id = ?';
  if ($stmt->prepare($sql)) {
    // bind the query parameters
    $stmt->bind_param('i', $_GET['article_id']);
	// bind the result to variables
	$stmt->bind_result($article_id, $title, $created);
	// execute the query, and fetch the result
	$stmt->execute();
	$stmt->fetch();
  }
}
// if confirm deletion button has been clicked, delete record
if (isset($_POST['delete'])) {
  $sql = 'DELETE FROM comments WHERE article_id = ?';
  if ($stmt->prepare($sql)) {
    $stmt->bind_param('i', $_POST['article_id']);
	$stmt->execute();
	// if there's an error affected_rows is -1
	if ($stmt->affected_rows > 0) {
	  $deleted = true;
	} else {
      $error = 'There was a problem deleting the record. '; 
	}
  }
}
// redirect the page if deletion is successful, 
// cancel button clicked, or $_GET['article_id'] not defined
if ($deleted || isset($_POST['cancel_delete']) || !isset($_GET['article_id']))  {
  header('Location: http://localhost/ShareShare/comments/comment_list.php');
  exit;
  }
  
// if any SQL query fails, display error message
if (isset($stmt) && !$OK && !$deleted) {
 // $error .= $stmt->error;
  //echo "ERROR";
} 
?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Delete Comment</title>
<link href="style/admin.css" rel="stylesheet" type="text/css">
</head>

<body>
<h1>Delete Comment </h1>
<?php 

if (isset($error)  && !empty($error)) {
  echo "<p class='warning'>Error: $error</p>";
}

if($article_id == 0) { ?>
<p class="warning">Invalid request: record does not exist.</p>
<?php } else { ?>
<p class="warning">Please confirm that you want to delete the following item. This action cannot be undone.</p>
<p><?php echo $created . ': ' . htmlentities($title, ENT_COMPAT, 'utf-8'); ?></p>
<?php } ?>
<form id="form1" method="post" action="">
    <p>
	<?php if(isset($article_id) && $article_id > 0) { ?>
        <input type="submit" name="delete" value="Confirm Deletion">
	<?php } ?>
		<input name="cancel_delete" type="submit" id="cancel_delete" value="Cancel">
	<?php if(isset($article_id) && $article_id > 0) { ?>
		<input name="article_id" type="hidden" value="<?php echo $article_id; ?>">
	<?php } ?>
    </p>
</form>
</body>
</html>
