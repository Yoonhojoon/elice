let inputs = document.getElementsByTagName("input");
let loginButton = document.getElementsByTagName("button")[0];

let id = inputs[0];
let pw = inputs[1];

/*1. 버튼 활성화시키기*/
function activateBtn() {
  if (id.value) {
    loginButton.classList.remove("deactivatedColor");
    loginButton.classList.add("activatedColor");
  }
  if (!pw.value) {
    loginButton.classList.remove("activatedColor");
    loginButton.classList.add("deactivatedColor");
  }
}

pw.addEventListener("keyup", activateBtn);

/*2. 로그인 성공 여부 나타내기*/
function login() {
  if (id.value === "elice" && pw.value === "1234") {
    alert("로그인 성공");
  } else {
    alert("로그인 실패");
  }
}

loginButton.addEventListener("click", login);