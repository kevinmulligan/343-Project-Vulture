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

var documentLoaded = function(urlParams){
  var product = null;
  if ((urlParams === undefined) || (urlParams['id'] === undefined) || (urlParams['id'] === null)) {
    //TODO no information, should go back to main page
    // placeholder product
    product = {
      name:'cat',
      imageURL:'http://lorempixel.com/100/100/cats/',
      description:'For sale. Is extremely dangerious. Useful as guard animal.',
      price:39.99,
      rating:5
    };
  } else {
    // product found
    //TODO calls to database with id of item to get attributes
    product = {};
  }
  document.getElementById('image').setAttribute('src',product.imageURL);
  document.getElementById('name').appendChild(document.createTextNode(product.name));
  document.getElementById('rating').appendChild(
    document.createTextNode(new Array( Number(product.rating) + 1 ).join('★') + " " + product.rating + "/5")
  );
  document.getElementById('description').appendChild(document.createTextNode(product.description));
  document.getElementById('buy').appendChild(document.createTextNode(product.price));
}
