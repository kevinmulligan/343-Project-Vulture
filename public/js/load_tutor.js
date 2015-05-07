var server = "http://private-2dd96-vulture.apiary-mock.com";

function parseURLParams(url) {
  // parse URL
  var queryStart = url.indexOf("?") + 1,
    queryEnd   = url.indexOf("#") + 1 || url.length + 1,
    query = url.slice(queryStart, queryEnd - 1),
    pairs = query.replace(/\+/g, " ").split("&"),
    parms = {}, i, n, v, nv;

  if (query === url || query === "") {
    return;
  }

  for (i = 0; i < pairs.length; i++) {
    nv = pairs[i].split("=");
    n = decodeURIComponent(nv[0]);
    v = decodeURIComponent(nv[1]);

    if (!parms.hasOwnProperty(n)) {
      parms[n] = [];
    }

    parms[n].push(nv.length === 2 ? v : null);
  }
  return parms;
}

document.addEventListener("DOMContentLoaded", function(event) {
  var urlParams = parseURLParams(window.location.href);
  documentLoaded(urlParams); // load the id of the object into the
});

var loadTutor = function(urlParams){
  var id = urlParams.id[0];
  var xhr = new XMLHttpRequest();
  xhr.open("GET", server + "/tutor/"+id, true);
  xhr.send();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4 || xhr.readyState == 200){
      tutor = JSON.parse(xhr.responseText);
      tutorToPage(tutor);
    }
  }
}

var loadSchedule = function(urlParams){
  var id = urlParams.id[0];
  var xhr = new XMLHttpRequest();
  xhr.open("GET", server + "/tutor/schedule/" + id, true);
  xhr.send();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4 || xhr.readyState == 200){
      schedule = JSON.parse(xhr.responseText);
      tutorScheduleToPage(schedule);
    }
  }
}

function tutorToPage(tutor) {
  document.getElementById('image').setAttribute('src',tutor.imagePath);
  document.getElementById('name').appendChild(document.createTextNode(tutor.firstName));
  document.getElementById('rating').appendChild(
    document.createTextNode(new Array( Number(tutor.rating) + 1 ).join('★') + " " + tutor.rating + "/5")
  );
  document.getElementById('description').appendChild(document.createTextNode(tutor.desc));
  document.getElementById('request').appendChild(document.createTextNode(tutor.costPerHour));
}


function tutorScheduleToPage(tutorSchedule) {
  var scheduleTable = document.getElementById('schedule');
  // make the whole schedule unavalible
  console.log(scheduleTable.rows.length)
  for (var row = 1; row < scheduleTable.rows.length; row++){
    for (var column = 1; column < scheduleTable.rows[row].cells.length; column++){
      scheduleTable.rows[row].cells[column].classList.add('blocked-hour');
    }
  }

  // now open up slots
  for (var open = 0; open < tutorSchedule.open.length; open++){
    var openSlot = tutorSchedule.open[open];
    for (var day = openSlot.days[0]; day < openSlot.days.length; day++){
      for (var hour = openSlot.hour; hour < (openSlot.length + openSlot.hour); hour++){
        scheduleTable.rows[hour+1].cells[day+1].classList.remove('blocked-hour');
        scheduleTable.rows[hour+1].cells[day+1].classList.add('open-hour');
      }
    }
  }
}

var mouse = 0;
var add = false;

function dateSelect(e){
  if ((mouse > 0) && (e.target.tagName != 'TH') && !(e.target.classList.contains('blocked-hour'))) {
    if (add){
      e.target.classList.remove('open-hour');
      e.target.classList.add('request-hour');
    } else {
      e.target.classList.remove('request-hour');
      e.target.classList.add('open-hour');
    }
  }
}

function mouseDown(e, value){
  if(e.preventDefault) e.preventDefault();
  mouse = value;
  add = e.target.classList.contains('open-hour');
  console.log(add);
  dateSelect(e);
  updateRequestButton();
}

function updateRequestButton(){
  if (document.getElementsByClassName('request-hour').length < 1){
    document.getElementById('request').classList.add('disable');
  } else {
    document.getElementById('request').classList.remove('disable');
  }
}

var documentLoaded = function(urlParams){
  loadTutor(urlParams);
  loadSchedule(urlParams);
}
