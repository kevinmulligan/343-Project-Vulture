document.addEventListener("DOMContentLoaded", function(event) {
  documentLoaded();
});

var dailyProduct = {
  name:'cat',
  imageURL:'http://lorempixel.com/100/100/cats/',
  description:'For sale. Is extremely dangerious. Useful as guard animal.',
  price:39.99,
  rating:5
};
var dailyTutor = {
  name:'Susan',
  imageURL:'http://lorempixel.com/100/100/people/',
  description:'I am a tutor. I can teach you to be dangerious. I\'ve seen things .... seen things no human was ment to see.',
  hourly_cost:12.99,
  rating:4
}

var makeProduct = function(product){
  var ele = document.createElement('div');
  ele.setAttribute('class','product');
  // add image
  var img = document.createElement('img');
  img.setAttribute('src',product.imageURL);
  ele.appendChild(img);
  // add description
  var des = document.createElement('span');
  des.setAttribute('class','description');
  var desText = document.createTextNode(product.description);
  des.appendChild(desText)
  ele.appendChild(des);
  // add rating
  var rating = document.createElement('span');
  var ratingText = document.createTextNode(new Array( Number(product.rating) + 1 ).join('★'));
  rating.appendChild(ratingText);
  ele.appendChild(rating);
  // add price
  var price = document.createElement('a');
  var priceText = document.createTextNode(product.price);
  price.setAttribute('class','price');
  price.appendChild(priceText);
  ele.appendChild(price);
  return ele;
}

var makeTutor = function(tutor){
  var ele = document.createElement('div');
  ele.setAttribute('class','tutor');
  // add image
  var img = document.createElement('img');
  img.setAttribute('src',tutor.imageURL);
  ele.appendChild(img);
  // add description
  var des = document.createElement('span');
  des.setAttribute('class','description');
  var desText = document.createTextNode(tutor.description);
  des.appendChild(desText)
  ele.appendChild(des);
  // add rating
  var rating = document.createElement('span');
  var ratingText = document.createTextNode(new Array( Number(tutor.rating) + 1 ).join('★'));
  rating.appendChild(ratingText);
  ele.appendChild(rating);
  // add price
  var price = document.createElement('a');
  var priceText = document.createTextNode(tutor.hourly_cost);
  price.setAttribute('class','price');
  price.appendChild(priceText);
  ele.appendChild(price);
  return ele;
}

var documentLoaded = function(){
  document.getElementById('daily-product').appendChild(makeProduct(dailyProduct));
  document.getElementById('daily-tutor').appendChild(makeTutor(dailyTutor));
}
