const image = document.getElementsByClassName("zoom-img")[0];

function zoomIn(tag) {
  image.style.transform = "scale(2)";
  image.style.transition = "all 3s";
}

function zoomOut() {
  image.style.transform = "scale(1)";
  image.style.transition = "all 0.5s";
}

image.addEventListener("mouseenter", zoomIn);
image.addEventListener("mouseleave", zoomOut);