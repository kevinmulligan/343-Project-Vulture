function storeValues(){
  localStorage['username'] = document.getElementById('username').value;
  localStorage['password'] = document.getElementById('password').value;
  window.location.href = '/index.html';
  return true;
}
