

<!DOCTYPE html>
<html>
  <head>
    <title>Panoramio Widget API</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=panoramio"></script>
    <script src="https://ssl.panoramio.com/wapi/wapi.js?v=1"></script>
    <script>
function initialize() {
  // The photoDiv defines the DIV within the info window for
  // displaying the Panoramio photo within its PhotoWidget.
  var photoDiv =  document.createElement('div');

  // The PhotoWidget width and height are expressed as number values,
  // not string values.
  var photoWidgetOptions = {
    width: 640,
    height: 500
  };

  // We construct a PhotoWidget here with a blank (null) request as we
  // don't yet have a photo to populate it.
  var photoWidget = new panoramio.PhotoWidget(photoDiv, null,
      photoWidgetOptions);

  var monoLake = new google.maps.LatLng(37.973432, -119.093170);
  var mapOptions = {
    zoom: 11,
    center: monoLake
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var infoWindow = new google.maps.InfoWindow();
  var panoramioLayer = new google.maps.panoramio.PanoramioLayer({
    suppressInfoWindows: true
  });

  panoramioLayer.setMap(map);

  google.maps.event.addListener(panoramioLayer, 'click', function(e) {
    var photoRequestOptions = {
      ids: [{
        'photoId': e.featureDetails.photoId,
        'userId': e.featureDetails.userId
      }]
    };
    photoWidget.setRequest(photoRequestOptions);
    photoWidget.setPosition(0);
    infoWindow.setPosition(e.latLng);
    infoWindow.open(map);
    infoWindow.setContent(photoDiv);
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body>
    <div id="map-canvas"></div>
  </body>
</html>

