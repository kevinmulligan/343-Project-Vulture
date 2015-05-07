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
      var priceMath = (product.cost/Number(amazonProduct.price.slice(1))).toFixed(2);

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
      amazonElement.appendChild(document.createTextNode("\" ... but why do that when you could GET \"" + product.name.toUpperCase() + "\" FOR THE SAME PRICE?!"));
    }
  };
}

document.addEventListener("DOMContentLoaded", function(event) {
  var urlParams = parseURLParams(window.location.href);
  documentLoaded(urlParams); // load the id of the object into the
  loadUser();
});

var loadProduct = function(urlParams){
  var id = urlParams.id[0];
  var xhr = new XMLHttpRequest();
  xhr.open("GET", server + "/product/"+id, true);
  xhr.send();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4 || xhr.readyState == 200){
      product = JSON.parse(xhr.responseText);
      productToPage(product);
    }
  }
}

function productToPage(product) {
  document.getElementById('image').setAttribute('src',product.imagePath);
  document.getElementById('name').appendChild(document.createTextNode(product.name));
  document.getElementById('rating').appendChild(
    document.createTextNode(new Array( Number(product.rating) + 1 ).join('★') + " " + product.rating + "/5")
  );
  document.getElementById('description').appendChild(document.createTextNode(product.desc));
  document.getElementById('buy').appendChild(document.createTextNode(product.cost));
  loadRandomAmazonProduct(product);
}

var documentLoaded = function(urlParams){
  loadProduct(urlParams);
}


var loadUser = function(){
  if (localStorage['username']) {
    document.getElementById('account-buttons').style.display = 'none';
    document.getElementById('logged-in').style.display = '';
    document.getElementById('user').innerHTML = localStorage['username'];
  } else {
    document.getElementById('account-buttons').style.display = '';
    document.getElementById('logged-in').style.display = 'none';
  }
}
