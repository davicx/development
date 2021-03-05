<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert Blog Entry</title>
	<link href="style/admin.css" rel="stylesheet" type="text/css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="my_script.js" type="text/javascript"></script>
</head>

<body>
<h1>Insert New Post</h1>
<?php if (isset($error)) {
  echo "<p>Error: $error</p>";
} ?>

<!--<form id = "myForm" action="userInfo.php" method="post">-->
<form id = "myForm" action="userInfo.php" method="post">
	Title: <input type ="text" name = "title" /><br />
	Article: <input type ="text" name = "article" /><br />
	<button id="submit" name = "submit"> Save </button>
	
	<p>CLICK</p>
</form>

<button onclick="myFunction()">Try it</button>

<h2>This is a heading</h2>
<p>This is a paragraph.</p>
<p id="test">This is another paragraph.</p>
<button>Click me</button>

<span id="result"></span>


</body>
</html>
























<!-- -->
<!--
<form name = "form1" id="form1" method="post" action="" onsubmit="return validate()"> 
  <p>
    <label for="title">url:</label>
    <input name="title" type="text" class="widebox" id="title">
  </p>
  
  <p>
    <label for="article">caption:</label>
    <textarea name="article" cols="60" rows="8" class="widebox" id="article"></textarea></input><div id="errfn">   </div>
  </p>
  <p>

 <input type="submit" name="insert" value="Insert New Entry" id="insert"> 
</p>

</form>
-->