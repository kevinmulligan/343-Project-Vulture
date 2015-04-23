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

var loadProduct = function(urlParams){
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

function tutorToPage(tutor) {
  document.getElementById('image').setAttribute('src',tutor.imagePath);
  document.getElementById('name').appendChild(document.createTextNode(tutor.firstName));
  document.getElementById('rating').appendChild(
    document.createTextNode(new Array( Number(tutor.rating) + 1 ).join('★') + " " + tutor.rating + "/5")
  );
  document.getElementById('description').appendChild(document.createTextNode(tutor.desc));
  document.getElementById('schedule').appendChild(document.createTextNode(tutor.costPerHour));
}

var documentLoaded = function(urlParams){
  loadProduct(urlParams);
}
