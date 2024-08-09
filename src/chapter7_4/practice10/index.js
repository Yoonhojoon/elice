// 지시사항을 참고하여 코드를 작성하세요.
var form = document.getElementById("form");
var input = document.getElementById("input");
var answer = document.getElementById("answer");

form.addEventListener("submit", function (e) {
  e.preventDefault();

  var val = input.value;

  if (val) {
    answer.textContent = val;

    form.reset();
  }
});