/*
Anjalee Patel, Josie Jitzel Alvarez, Florence Yang, Alex Qiu, Can Toraman, Nishant Sinha
*/

var modal = document.getElementById('product-modal');
var modalContent = document.getElementById('modal-content');
var allImages = document.getElementsByTagName("img");
for (var i = 0; i < allImages.length; ++i)
	allImages[i].addEventListener("click", function() {
		openModal(this);
	});
function openModal(sourceObj) {
	
	var productCard = modalContent.children[0];
	console.log(productCard.children);
	// add image
	productCard.children[0].src = sourceObj.src;
	// add details
	productCard.children[2].textContent = "brand name here";
	productCard.children[3].textContent = "color here";
	productCard.children[4].textContent = "description here........................................................................................";
	productCard.children[5].textContent = "price here";
	productCard.children[6].textContent = "quantity here";
	productCard.children[7].textContent = "interest here";
	productCard.children[8].textContent = "seller here";
	

	
	modal.style.display = "block";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal || event.target == modalContent) {
    modal.style.display = "none";
  }
} 
	
// Get the modal
/* var modal = document.getElementById("product-modal");
var modalContent = document.getElementById("modal-content");

// Get the button that opens the modal
var btn = document.getElementById("map-btn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal || event.target == modalContent) {
    modal.style.display = "none";
  }
} */