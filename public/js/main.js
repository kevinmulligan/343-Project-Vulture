document.addEventListener("DOMContentLoaded", function(event) {
  documentLoaded();
});

var server = "http://private-2dd96-vulture.apiary-mock.com";

var makeProduct = function(product){
  // pass in a product object, it will create the element for it
  var ele = document.createElement('div');
  ele.setAttribute('class','product item');
  // add image
  var img = document.createElement('img');
  img.setAttribute('src',product.imagePath);
  ele.appendChild(img);
  // add name
  var name = document.createElement('span');
  name.setAttribute('class','name');
  var nameText = document.createTextNode(product.name);
  name.appendChild(nameText);
  ele.appendChild(name);
  // add description
  var des = document.createElement('span');
  des.setAttribute('class','description');
  var desText = document.createTextNode(product.desc);
  des.appendChild(desText)
  ele.appendChild(des);
  // add rating
  var rating = document.createElement('span');
  var ratingText = document.createTextNode(new Array( Number(product.rating) + 1 ).join('★') + " " + product.rating + "/5");
  rating.setAttribute('class','rating');
  rating.appendChild(ratingText);
  ele.appendChild(rating);
  // add price
  var price = document.createElement('a');
  price.setAttribute('href','product.html?id='+product.id);
  var priceText = document.createTextNode(product.cost);
  price.setAttribute('class','price');
  price.appendChild(priceText);
  ele.appendChild(price);
  return ele;
}

var makeTutor = function(tutor){
  // pass in a product object, it will create the element for it
  var ele = document.createElement('div');
  ele.setAttribute('class','tutor item');
  // add image
  var img = document.createElement('img');
  img.setAttribute('src',tutor.imagePath);
  ele.appendChild(img);
  // add name
  var name = document.createElement('span');
  name.setAttribute('class','name');
  var nameText = document.createTextNode(tutor.firstName);
  name.appendChild(nameText);
  ele.appendChild(name);
  // add description
  var des = document.createElement('span');
  des.setAttribute('class','description');
  var desText = document.createTextNode(tutor.desc);
  des.appendChild(desText)
  ele.appendChild(des);
  // add rating
  var rating = document.createElement('span');
  var ratingText = document.createTextNode(new Array( Number(tutor.rating) + 1 ).join('★') + " " + tutor.rating + "/5");
  rating.setAttribute('class','rating');
  rating.appendChild(ratingText);
  ele.appendChild(rating);
  // add price
  var price = document.createElement('a');
  price.setAttribute('href','tutor.html?id='+tutor.id);
  var priceText = document.createTextNode(tutor.costPerHour);
  price.setAttribute('class','hourly');
  price.appendChild(priceText);
  ele.appendChild(price);
  return ele;
}

var getContent = function(server){
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "http://private-2dd96-vulture.apiary-mock.com/home", true);
  xhr.send();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4 && xhr.status == 200){
      // for every product
      var items = JSON.parse(xhr.response);
      for (p in items.products) {
        items.products[p].id = p;
        document.getElementById('items').appendChild(makeProduct(items.products[p]));
      }
      for (t in items.tutors) {
        items.tutors[t].id = t;
        document.getElementById('items').appendChild(makeTutor(items.tutors[t]));
      }
    }
  };
}

var documentLoaded = function(){
  getContent(server);
}

var filterResults = function(search){
  var items = document.querySelectorAll('.item');
  for (var i = 0; i < items.length; i++) {
    if (items[i].innerText.toLowerCase().indexOf(search.toLowerCase()) == -1){
      console.log('hide');
      items[i].style.display = 'none';
    } else {
      console.log('show');
      items[i].style.display = '';
    }
  }
}
