var isBig = false;

function move() {
    var box = document.getElementById("move");
  // 코드를 완성시켜 주세요.
    if (isBig){
        // 작아지는 내용을 추가해주면 되겠져
        box.style.width = "300px";
        box.style.height = "300px";
        box.style.left = "600px";
        isBig = false;
    }else{
        box.style.width = "600px";
        box.style.height = "600px";
        box.style.left = "300px";
        isBig = true;
    }


};

var btn = document.getElementById("btn");

btn.addEventListener("click", move);