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

function loadRandomAmazonProduct(product){
  var amazonElement = document.getElementById("amazon");
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "http://ptsrepairs.com/amazon/samples/getProduct.php", true);
  xhr.send();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4 || xhr.readyState == 200){
      // get the product and put it on the page
      var amazonProduct = JSON.parse(xhr.responseText);
      // price math
      var priceMath = (Number(amazonProduct.price.slice(1))/product.price).toFixed(2);

      // add content to page
      var img = document.createElement('img');
      img.setAttribute('class','amazon_img');
      img.setAttribute('src',amazonProduct.image);
      var name = document.createTextNode(amazonProduct.title);
      var price = document.createElement('span');
      price.appendChild(document.createTextNode(amazonProduct.price));
      price.setAttribute('class','amazonPrice');
      var link = document.createElement('a');
      link.setAttribute('href',amazonProduct.link);
      link.setAttribute('id','amazon_link');
      link.appendChild(name);
      amazonElement.appendChild(img);
      amazonElement.appendChild(document.createTextNode("You could get " + priceMath + " copies of \""));
      amazonElement.appendChild(link);
      amazonElement.appendChild(document.createTextNode("\" ... but why do that when you could GET " + product.name.toUpperCase() + " NOW!"));
    }
  };
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
  loadRandomAmazonProduct(product);
}
