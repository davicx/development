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



/*
function initialize() {
  var myLatlng = new google.maps.LatLng(44.590408,-123.272171);
  var mapOptions = {
    zoom: 14,
    center: myLatlng
  };

  var map = new google.maps.Map(
      document.getElementById('map-canvas'),
      mapOptions);

  var bikeLayer = new google.maps.BicyclingLayer();
  bikeLayer.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);
*/
/*
function initialize() {
  var myLatlng = new google.maps.LatLng(44.590408,-123.272171);
  var mapOptions = {
    zoom: 13,
    center: myLatlng
  }

  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

  var transitLayer = new google.maps.TransitLayer();
  transitLayer.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);

*/
/*
// This example creates circles on the map, representing
// populations in North America.

// First, create an object containing LatLng and population for each city.
var citymap = {};
citymap['chicago'] = {
  center: new google.maps.LatLng(41.878113, -87.629798),
  population: 2714856
};
citymap['newyork'] = {
  center: new google.maps.LatLng(40.714352, -74.005973),
  population: 8405837
};
citymap['losangeles'] = {
  center: new google.maps.LatLng(34.052234, -118.243684),
  population: 3857799
};
citymap['vancouver'] = {
  center: new google.maps.LatLng(49.25, -123.1),
  population: 603502
};

var cityCircle;

function initialize() {
  // Create the map.
  var mapOptions = {
    zoom: 4,
    center: new google.maps.LatLng(37.09024, -95.712891),
    mapTypeId: google.maps.MapTypeId.TERRAIN
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  // Construct the circle for each value in citymap.
  // Note: We scale the area of the circle based on the population.
  for (var city in citymap) {
    var populationOptions = {
      strokeColor: '#FF0000',
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: '#FF0000',
      fillOpacity: 0.35,
      map: map,
      center: citymap[city].center,
      radius: Math.sqrt(citymap[city].population) * 100
    };
    // Add the circle for this city to the map.
    cityCircle = new google.maps.Circle(populationOptions);
  }
}

google.maps.event.addDomListener(window, 'load', initialize);
*/

/*THIS IS WHAT I WILL USE */
// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.
/*
function initialize() {
  var myLatlng = new google.maps.LatLng(-25.363882,131.044922);
  var mapOptions = {
    zoom: 4,
    center: myLatlng
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

  var contentString = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
      '<div id="bodyContent">'+
      '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
      'sandstone rock formation in the southern part of the '+
      'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
      'south west of the nearest large town, Alice Springs; 450&#160;km '+
      '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
      'features of the Uluru - Kata Tjuta National Park. Uluru is '+
      'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
      'Aboriginal people of the area. It has many springs, waterholes, '+
      'rock caves and ancient paintings. Uluru is listed as a World '+
      'Heritage Site.</p>'+
      '<p>Attribution: Uluru, <a href="http://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
      'http://en.wikipedia.org/w/index.php?title=Uluru</a> '+
      '(last visited June 22, 2009).</p>'+
      '</div>'+
      '</div>';

  var infowindow = new google.maps.InfoWindow({
      content: contentString
  });

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: 'Uluru (Ayers Rock)'
  });
  google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);
  });
}

google.maps.event.addDomListener(window, 'load', initialize);
*/


//**//
/*
// This example adds a marker to indicate the position
// of Bondi Beach in Sydney, Australia
function initialize() {
  var mapOptions = {
    zoom: 4,
    center: new google.maps.LatLng(-33, 151)
  }
  var map = new google.maps.Map(document.getElementById('map-canvas'),
                                mapOptions);

  var image = 'images/beachflag.png';
  var myLatLng = new google.maps.LatLng(-33.890542, 151.274856);
  var beachMarker = new google.maps.Marker({
      position: myLatLng,
      map: map,
      icon: image
  });
}

google.maps.event.addDomListener(window, 'load', initialize);
*/
/*function initialize() {

var mapOptions = {
	center: new google.maps.LatLng(-34.397, 150.644),
	zoom: 8
};

var map = new google.maps.Map(document.getElementById("map-canvas"),
	mapOptions);
}
	
google.maps.event.addDomListener(window, 'load', initialize);*/
// The following example creates a marker in Stockholm, Sweden
// using a DROP animation. Clicking on the marker will toggle
// the animation between a BOUNCE animation and no animation.
/*
var stockholm = new google.maps.LatLng(59.32522, 18.07002);
var parliament = new google.maps.LatLng(59.327383, 18.06747);
var marker;
var map;

function initialize() {
  var mapOptions = {
    zoom: 13,
    center: stockholm
  };

  map = new google.maps.Map(document.getElementById('map-canvas'),
          mapOptions);

  marker = new google.maps.Marker({
    map:map,
    draggable:true,
    animation: google.maps.Animation.DROP,
    position: parliament
  });
  google.maps.event.addListener(marker, 'click', toggleBounce);
}

function toggleBounce() {

  if (marker.getAnimation() != null) {
    marker.setAnimation(null);
  } else {
    marker.setAnimation(google.maps.Animation.BOUNCE);
  }
}

google.maps.event.addDomListener(window, 'load', initialize);

*/