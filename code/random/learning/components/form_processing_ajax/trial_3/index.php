<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title> OSU Dashboard </title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src = "main.js"></script>
	</head>	
	
	<body>	


</head>
<body>

<p>If you click on the "Hide" button, I will disappear.</p>
<button id="hide">Hide</button>
<button id="show">Show</button>

         <div id="note_add_container">
                <form id="contactForm1" action="note_proces.php" method="post">
                    <input type="text" name="title" placeholder="title" />
                    <input type="text" name="summary" placeholder="summary" />
                    <input type="text" name="details" placeholder="details" />
                    <input type="submit" value="Submit">
                </form>
            </div>

   <script type="text/javascript">
    var frm = $('#contactForm1');
    frm.submit(function (ev) {
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function (data) {
                alert('ok');
            }
        });

        ev.preventDefault();
    });
</script>
		

    </body>
</html>
