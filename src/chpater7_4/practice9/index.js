/*지시사항을 따라 작성해주세요*/

function scrollUp(e) {
  let target = document.getElementById(e);
  target.addEventListener("click", function () {
    window.scrollTo({ top: 0, left: 0, behavior: "smooth" });
  });
}

scrollUp("scroll-btn");