<!DOCTYPE html>
<html lang="en-gb" dir="ltr">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>

        <link id="data-uikit-theme" rel="stylesheet" href="css/uikit.docs.min.css">


        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>

    </head>

    <body>
	<br />	<br />	<br />	<br />	<br />	<br />	<br />	<br />



                                <div class="uk-button-dropdown" data-uk-dropdown>
                                    <button class="uk-button">Hover me <i class="uk-icon-caret-down"></i></button>
                                    <div class="uk-dropdown">
										<p> test </p>
                                    </div>
                                </div>

                                <div class="uk-button-dropdown" data-uk-dropdown="{mode:'click'}">
                                    <button class="uk-button">Click me </button>
                                    <div class="uk-dropdown">
                                        <ul class="uk-nav uk-nav-dropdown">
                                            <li><a href="#">Item</a></li>
                                            <li><a href="#">Another item</a></li>
                                            <li class="uk-nav-header">Header</li>
                                            <li><a href="#">Item</a></li>
                                            <li><a href="#">Another item</a></li>
                                            <li class="uk-nav-divider"></li>
                                            <li><a href="#">Separated item</a></li>
                                        </ul>
                                    </div>
                                </div>

    </body>
</html>
