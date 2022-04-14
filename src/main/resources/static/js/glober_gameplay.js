'use strict';

var map;
var markers = [];
var guess_coordinates = [];
var true_location = [];
var accumulated_distance_score = 0;
var current_name = '';
var distance_from_guess = [];
var check_count = 0;
var maxDistanceInUs = 2892;
var max_score = 14460;

// This is a world city set that is used for testing
const world_city_set =[5304391, 3599699, 1857910, 4853608, 323786];

// This is the array of the top 320 cities in the US created from "city codes" from Open Weather API
const us_cities = [5128581,5368361,4887398,4699066,5308655,4560349,4726206,5391811,4684904,5392171,4671654,4160021,
    4691930,4509177,4259418,4460243,5391959,5809844,5419384,5815135,4644585,4544349,5521001,4930956,5746545,5506956,
    4990729,4641239,4299276,4347778,5263058,5454711,5318313,5350964,5389519,4393217,5304391,4180439,5074472,5417598,
    4487042,5367929,4791259,4164138,5004223,5037649,4553440,5325738,4281730,4671240,5412347,4174757,4335045,5150529,
    5856195,5323810,4297983,5399020,4683416,5505411,5387890,5101798,5045360,5392900,4508722,5359777,4167147,5206379,
    4407066,4469146,5099836,5879400,5072006,4719457,4464374,5110629,5289282,5336899,5174035,4074277,5295903,5511077,
    4920423,5509403,4171563,5525584,4700168,4705349,5750162,4752186,5295985,4693003,5313457,4776222,5586437,5350734,
    5811696,5393049,4315588,4781708,4158476,5391710,5812944,5373900,4068590,4853828,5145215,5134086,5374732,4466033,
    5349755,4509177,4956184,4171260,4119403,4180531,5380184,4049979,4362716,4692559,5516233,5780993,4994358,5358705,
    4276873,5254404,4174715,4694482,4710178,4149962,5231851,5308480,5224151,5814616,4634946,5145476,4341513,4076598,
    4676740,4776024,4155966,4612862,5317058,5412347,5393287,5725846,5346111,5379439,4459467,5385955,5378771,5364940,
    5351515,4168139,5577147,5380698,4409896,4613868,5391295,5355933,5102466,4744091,4207400,5339631,4393217,5427946,
    4409896,5400075,4431410,4703223,5357527,4644312,4717782,5786882,5384170,5346827,4898015,4574324,4710826,4903279,
    4907959,5282804,5140405,4221552,5388881,5403022,5351247,5316428,4709796,5441492,5406567,4276614,4156404,5784607,
    5379513,4685907,5014051,4717782,4739526,4850751,4509884,5097598,4762894,4575352,5799625,4843564,5800420,5406222,
    4164601,4151909,5011148,4839366,4679195,5526337,4543762,5546441,4180386,5402405,4682464,5338122,5347335,4167499,
    4722625,4724129,4931972,5600685,4177887,4257227,4151316,5640350,5784549,4781708,5443910,5089178,4942618,4499379,
    5324200,4672989,5780026,4589387,4890864,5334223,5527554,4845193,4525353,4705692,5343858,5729485,4471025,4531405,
    4998830,4161438,4169014,5339840,5435464,4706057,4164167,5475352,4734825,5375911,5405878,5793933,5401395,4990510,
    5393180,5407933,5345743,5577592,5512862,5416541,5574991,4221333,5359488,5097529,4658948,5254962,5331835,5808189,
    5731371,5345529,4738214,4152820,5392423,4931429,5339111,5373492,5341430,4670300,5487811,5387288,5106529,4926563,
    5811729,5377995,5372205,5405228,4741752,4853423,4948247,5336269,4942807,4394870,4945121,5794245,4351871,4688275,
    5601933,4782167];

async function getData(url) {
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.log(error));
}

async function initialize() {
    check_count = 0;
    disableButton('check');
    disableButton('next');
    if(accumulated_distance_score == 0){
        document.getElementById("totaldistance").innerHTML = 'Total Score: 0 Points';
    }
    document.getElementById("location").innerHTML = ' ';
    document.getElementById("distance").innerHTML = ' ';


    var number = await Promise.all([getData(`https://api.openweathermap.org/data/2.5/weather?id=${randomLoc()
    }&APPID=2e35570eab59959f85e835dabdddc726`)]);
    true_location = [];
    true_location.push(number[0].coord.lat,number[0].coord.lon);
    current_name = (number[0].name + ", " + number[0].sys.country);


    var luther = {lat: 43.31613189259254, lng: -91.80256027484972};

    var map = new google.maps.Map(document.getElementById('map'), {
        center: luther,
        zoom: 1,
        streetViewControl: false,
        controlSize: 18,
        gestureHandling: 'greedy',
        draggableCursor: 'crosshair',
        draggingCursor: 'crosshair',
        clickableIcons: false,
        fullscreenControl: false,
    });

    google.maps.event.addListener(map, 'click', function(event) {
        placeMarker(event.latLng);
        if (check_count == 0){
            enableButton('check');
            check_count += 1;
        }
    });

    function placeMarker(location) {
        deleteMarkers();
        guess_coordinates = [];
        var marker = new google.maps.Marker({
            position: location,
            map: map,
        });
        markers.push(marker);
        guess_coordinates.push(marker.getPosition().lat(),marker.getPosition().lng());
    }


    var panorama = new google.maps.StreetViewPanorama(
        document.getElementById('pano'), {
            position: {lat: number[0].coord.lat, lng: number[0].coord.lon},
            pov: {
                heading: 34,
                pitch: 10
            },
            addressControl: false,
            showRoadLabels: false,
            clickableIcons: false,
            fullscreenControl: false,
            disableDefaultUI: true,
        });
    map.setStreetView(panorama);
    document.getElementById('placeholder1').style.display = 'none';
}

function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

function check(){
    enableButton('next');
    distance_from_guess = [];
    var guess_error = (distance(guess_coordinates[0],guess_coordinates[1],true_location[0], true_location[1],'K'));
    var parsed_score = maxDistanceInUs - parseFloat(guess_error);
    parsed_score = ((parsed_score/maxDistanceInUs) * 100);
    accumulated_distance_score += parsed_score;
    distance_from_guess = guess_error;
    var true_coords = {lat: true_location[0], lng: true_location[1]};
    var guess_coords = {lat: guess_coordinates[0], lng: guess_coordinates[1]};
    var result_map = new google.maps.Map(document.getElementById('result'), {
        zoom: 2,
        center: true_coords,
        gestureHandling: 'greedy',
        draggableCursor: 'crosshair',
        draggingCursor: 'crosshair',
        clickableIcons: false,
        fullscreenControl: false,
    });

    var true_marker = new google.maps.Marker({
        position: true_coords,
        map: result_map,
        title: 'True Location',
        icon: {
            url: "http://maps.google.com/mapfiles/ms/icons/green-dot.png"
        }
    });

    var infoWindow = new google.maps.InfoWindow({
        content: current_name
    })

    true_marker.addListener('click', function(){
        infoWindow.open(result_map, true_marker);
    });

    var guess_marker = new google.maps.Marker({
        position: guess_coords,
        map: result_map,
        title: 'Guessing Location',
        icon: {
            url: "http://maps.google.com/mapfiles/ms/icons/red-dot.png"
        }
    });

    var flightPlanCoordinates = [
        true_coords, guess_coords,

    ];

    var lineSymbol = {
        path: 'M 0,-1 0,1',
        strokeOpacity: 1,
        scale: 2
    };

    var flightPath = new google.maps.Polyline({
        path: flightPlanCoordinates,
        strokeOpacity: 0,
        icons: [{
            icon: lineSymbol,
            offset: '1',
            repeat: '15px'
        }],
    });

    flightPath.setMap(result_map);
    display_location();
    disableButton('check');
    document.getElementById("placeholder1").style.display = 'block';
}

// handles the calculation of player score based on distance from guessed location to target location
function distance(lat1, lon1, lat2, lon2, unit) {
    if ((lat1 == lat2) && (lon1 == lon2)) {
        return 0;
    }
    else {
        var radlat1 = Math.PI * lat1/180;
        var radlat2 = Math.PI * lat2/180;
        var theta = lon1-lon2;
        var radtheta = Math.PI * theta/180;
        var dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
        if (dist > 1) {
            dist = 1;
        }
        dist = Math.acos(dist);
        dist = dist * 180/Math.PI;
        dist = dist * 60 * 1.1515;
        if (unit=="K") { dist = dist * 1.609344 }
        if (unit=="N") { dist = dist * 0.8684 }
        return (dist / 1.609).toFixed(1);
    }
}

var index = -1;
function randomLoc(){

    // takes the starting city/location code array and pulls 5 codes at random to be played
    var return_locations = [];
    for (let i = 0; i < 5; i++) {
        return_locations[i] = us_cities[Math.floor(Math.random()*us_cities.length)];
    }

    index += 1
    if (index > return_locations.length -1){
        index = 0
        document.getElementById("totaldistance").innerHTML = 'Total Score: 0 Points';
        if(accumulated_distance_score === 14460)  {
            swal({
                title: "Thanks For Playing!",
                icon: "success",
                text: "You Had a Perfect Game: " + accumulated_distance_score.toFixed(1) + " Points!"
            });
        }
        swal({
            title: "Thanks For Playing!",
            icon: "success",
            text: "Total Score: " + accumulated_distance_score.toFixed(1) + "/500 Points!",
            button: {
                text: "New Game",
            },
        });
        accumulated_distance_score = 0;
        document.getElementById('round').innerHTML = "Round:  1/" + return_locations.length
        document.getElementById("next").innerHTML= "Next Location";
        return[return_locations[0]]

    }else if(index == return_locations.length -1){
        document.getElementById("next").innerHTML= "Finish Game";
        document.getElementById('round').innerHTML = "Round: " + (index + 1) + "/" + return_locations.length
        return[return_locations[index]]
    }else{
        document.getElementById("next").innerHTML= "Next Location";
        document.getElementById('round').innerHTML = "Round: " + (index + 1) + "/" + return_locations.length
        return[return_locations[index]]
    }
}

function display_location(){
    document.getElementById("location").innerHTML = "Correct Location: " + current_name;
    document.getElementById("distance").innerHTML = "Your Guess was " + distance_from_guess + " Miles away";
    document.getElementById("totaldistance").innerHTML = "Total Score: " + accumulated_distance_score.toFixed
    (1) + " Points";
}

function disableButton(id){
    document.getElementById(id).disabled = true;
}

function enableButton(id){
    document.getElementById(id).disabled = false;
}

function hideButton(x)
{
    x.style.display = 'none';
}

function clearMarkers() {
    setMapOnAll(null);
}

function showMarkers() {
    setMapOnAll(map);
}

function deleteMarkers() {
    clearMarkers();
    markers = [];
}