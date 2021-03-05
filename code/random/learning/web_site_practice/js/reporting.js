$(document).ready(function(){
	$( window ).load(function() {
		var reportYear = $( "div.get-year" ).text()

		$.post("../functions/graph.php",{ reportYear:reportYear},
		function(data){
			var coasc = 0;
			var cobus = 0;
			var ceoas = 0;
			var coedu = 0;
			var coeng = 0;
			var cofor = 0;
			var colar = 0;
			var copha = 0;
			var cophh = 0;
			var cosci = 0;
			var covme = 0;
			var gssho = 0;
			var uestu = 0; 
			var json = JSON.parse(data);
			
			if ("coasc" in json) {
				coasc = coasc + json.coasc;
			}
		
			if ("cobus" in json) {
				cobus = cobus + json.cobus;
			}
		
			if ("ceoas" in json) {
				ceoas = ceoas + json.ceoas;
			}
			
			if ("coedu" in json) {
				coedu = coedu + json.coedu;
			}
		
			if ("coeng" in json) {
				coeng = coeng + json.coeng;
			}
	
			if ("cofor" in json) {
				cofor = cofor + json.cofor;
			}

			if ("colar" in json) {
				colar = colar + json.colar;
			}
			
			if ("copha" in json) {
				copha = copha + json.copha;
			}
			
			if ("coeng" in json) {
				coeng = coeng + json.coeng;
			}
	
			if ("cophh" in json) {
				cophh= cophh + json.cophh;
			}
			
			if ("cosci" in json) {
				cosci = cosci + json.cosci;
			}
			
			if ("covme" in json) {
				covme = covme + json.covme;
			}
			
			if ("cophh" in json) {
				cophh= cophh + json.cophh;
			}
						
			if ("gssho" in json) {
				gssho = gssho + json.gssho;
			}
			
			if ("uestu" in json) {
				uestu = uestu + json.uestu;
			} 

			//console.log(json);
			drawChart(coasc, cobus, ceoas, coedu, coeng, cofor, colar, copha, cophh, cosci, covme, gssho, uestu);
	
		});
	});
});

google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback();

function drawChart($coasc, $cobus, $ceoas, $coedu, $coeng, $cofor, $cofor, $colar, $copha, $cophh, $cosci, $covme, $gssho, $uestu) {  //$cofor, $colar, $copha, $cophh, $cosci, $covme, $gssho, $uestu) {

	var data = google.visualization.arrayToDataTable([
		['College', 'Liasions'],
		['College of Agricultural Science ', $coasc],
		['College of Business',  $cobus], 
		['CEOAS', $ceoas],
		['College of Education', $coedu],
		['College of Engineering', $coeng],
		['College of Forestry', $cofor],
		['College of Liberal Arts', $colar],
		['College of Pharmacy ', $copha],
		['College of Public Health', $cophh],
		['College of Science', $cosci],
		['College of Vet Medicine', $covme]
		//['Graduate School', $gssho],
		//['University Exploratory Studies ',   $uestu]
	]);

  var options = {
    title: 'Total Campus Liasions ',
	legend: 'none',
  //  hAxis: {title: 'College', titleTextStyle: {color: 'red'}}
  };

  var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));

  chart.draw(data, options);

}
