var favoritesIcon = document.getElementsByClassName("favorites-icon");

function handleClick() {
  for (var i = 0; i < favoritesIcon.length; i++) {
    if(favoritesIcon[i] != this) {
      favoritesIcon[i].classList.remove('on');
    }
  }

  this.classList.toggle('on');
}

for (var i = 0; i < favoritesIcon.length; i++) {
  favoritesIcon[i].addEventListener("click", handleClick);
}