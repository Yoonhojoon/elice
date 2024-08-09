/*지시사항을 따라 작성해주세요*/
var tag = document.getElementById("btn");

function changeButtonOnclick() {
  /*지시사항 1번*/
  tag.classList.add("changeColor");
  /*지시사항 2번*/
  tag.innerText = "버튼 클릭 성공!";
}

/*지시사항 3번*/
tag.addEventListener("click", changeButtonOnclick);