// 실습1

var one = 1;
var two = 2;

var one_str = "1";
var two_str = "2";

document.write(one+two+"\n");
document.write(one_str+two_str);






//실습2

/*지시사항에 따라 작성해주세요.*/

/* 1. add 함수 생성 */
function add(a,b){
    return a+b;
}


/* 2. 함수 호출한 결과 웹 화면에 출력 */

document.write(add(2,2))
document.write("Hello Elice")




//실습3
// 지시사항에 따라 코드를 작성합니다.
function addStringLength(inputA, inputB) {
  var lengthOfA = inputA.length
  var lengthOfB = inputB.length

  return lengthOfA + lengthOfB
};






// abc, de 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = "abc";
var inputB = "de";

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA, inputB], func: addStringLength }




//실습4
// 지시사항에 따라 코드를 작성합니다.
function repeatString(inputA, inputB) {
  return inputA.repeat(inputB)
};




// abc, 2 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = "abc";
var inputB = 2;

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA, inputB], func: repeatString }



//실습5
// 지시사항에 따라 코드를 작성합니다.

function removeBlank(inputA){
    return inputA.replace(/ /g, ''); // 모든 공백을 빈 문자열로 대체
}







// hello world 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = "hello world";

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: removeBlank }




//실습6
// 지시사항에 따라 코드를 작성합니다.
function sortStringArray(inputA){
    return inputA.sort();
}



// "c", "b", "d" 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = ["c", "b", "d"];

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: sortStringArray }


//실습7

// 지시사항에 따라 코드를 작성합니다.
// 지시사항에 따라 코드를 작성합니다.
function reverseStringArray(inputA) {
  return inputA.sort().reverse()
};







// "c", "b", "d" 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = ["c", "b", "d"];

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: reverseStringArray }




//실습8

// 지시사항에 따라 코드를 작성합니다.
function addMiddleNumbers(arrayA){
    return arrayA[1] + arrayA[4] + arrayA[6];
}







// 1, 2, 3, 4, 5, 6, 7 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = [1, 2, 3, 4, 5, 6, 7];

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: addMiddleNumbers }






//실습9
// 지시사항에 따라 코드를 작성합니다.

// 지시사항에 따라 코드를 작성합니다.
function makeTotalPrice(inputA) {
  var total1 = inputA.quantity1*inputA.price1
  var total2 = inputA.quantity2*inputA.price2
    return total1 + total2
};






// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = {
  quantity1: 4,
  price1: 500,
  quantity2: 2,
  price2: 300
};

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: makeTotalPrice }







//실습10


// 지시사항에 따라 코드를 작성합니다.
function makeIntroducingText(inputA) {
  return "안녕하세요, 저의 이름은 " +
    inputA.lastName + inputA.firstName +
    "이고, 나이는 " + inputA.age.toString() +
    "살입니다."
};


// 아래 문자열과 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = {
  firstName: "태환",
  lastName: "박",
  age: 32
};

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: makeIntroducingText }







//실습11
// 지시사항을 참고하여 코드를 작성하세요.
var a = 10;
var b = 10;

document.write(a == b);
document.write(a === b);

b = "10";

document.write(a == b);
document.write(a === b);






//실습12
/*지시사항을 따라 작성해주세요*/
var sum = 0;

for (var i = 1; i <= 200; i++) {
  for (var j = 2; j <= i; j++) {
    if (i % j == 0) {
      break;
    }
  }
  if (j == i) {
    sum += j;
  }
}

document.write("1이상 200이하의 소수의 합 = " + sum);






//실습13
// 지시사항에 따라 코드를 작성합니다.
function getOnlyEvenNumber(inputA) {
  var evenNumbers = []
  for (let n of inputA ) {
    if (n % 2 === 0) {
      evenNumbers.push(n)
    }
  }
  return evenNumbers
};





// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = [1, 2, 3, 4, 5, 6, 7]

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: getOnlyEvenNumber }







//실습14
// 지시사항에 따라 코드를 작성합니다.
function getOnlyOddNumber(inputA) {
  var oddNumbers = []
  for (let n of inputA ) {
    if (n % 2 === 1) {
      oddNumbers.push(n)
    }
  }
  return oddNumbers
};





// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = [1, 2, 3, 4, 5, 6, 7]

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: getOnlyOddNumber }







//실습15
function getDigits(inputA) {
  var digits = []; // 빈 배열 생성
  var inputAString = inputA.toString(); // 숫자를 문자열로 변환
  for (let s of inputAString) { // 문자열의 각 자리수에 대해 반복
    digits.push(parseInt(s)); // 각 자리수를 숫자로 변환하여 배열에 추가
  }
  return digits; // 결과 배열 반환
}






// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = 1100

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: getDigits }







//실습16
// 지시사항에 따라 코드를 작성합니다.
function makeNumberFromDigits(inputA) {
  var tempStr = ""
  for (let n of inputA ) {
    tempStr += n.toString()
  }
  return parseInt(tempStr)
};







// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = [1, 1, 0, 0]

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: makeNumberFromDigits }







//실습17
// 지시사항에 따라 코드를 작성합니다.
function verifyEmail(inputA) {
  if (!inputA.includes("@")) {
      return false
    }
  if (!inputA.includes(".")) {
      return false
    }
  if (inputA.length < 5) {
      return false
    }
  return true
};




// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA =  "abc@com"

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: verifyEmail }







//실습18
// 지시사항에 따라 코드를 작성합니다.
function getOnlyAdults(inputA) {
  var result = []
  for (let person of inputA) {
    if (person.age >= 20) {
      result.push(person.name)
    }
  }
  return result
};




// 아래 문자열과 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = [{
  name: "박태환",
  age: 35
},
{
  name: "유재석",
  age: 49
},
{
  name: "김강훈",
  age: 12
},
{
  name: "이지원",
  age: 15
}]

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: getOnlyAdults }







//실습19
// 지시사항에 따라 코드를 작성합니다.
function getOnlyChilds(inputA) {
  var result = []
  for (let person of inputA) {
    if (person.age < 20) {
      result.push(person.name)
    }
  }
  return result
};





// 아래 문자열과 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = [{
  name: "박태환",
  age: 35
},
{
  name: "유재석",
  age: 49
},
{
  name: "김강훈",
  age: 12
},
{
  name: "이지원",
  age: 15
}]

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA], func: getOnlyChilds }







//실습20
// 지시사항에 따라 코드를 작성합니다.
function isRightTriangle(a, b, c) {
  return a**2 === b**2 + c**2
};







// 아래 숫자 부분을 자유롭게 바꾸어 가며 실행해 보세요.
// 물론 현재 그대로 두어도 무방합니다. 제출 시의 채점과는 무관합니다.
var inputA = 5
var inputB = 3
var inputC = 4

// 실행 혹은 제출을 위한 코드입니다. 지우거나 수정하지 말아주세요.
module.exports = { inputs: [inputA, inputB, inputC], func: isRightTriangle }







//실습21
var imgs = document.getElementsByTagName("img");

// HTML <div> 요소를 선택하도록 코드를 작성하세요
var selectedTagName = document.getElementsByTagName("div");

// 아이디가 “gtomato"인 요소를 선택하도록 코드를 작성하세요
var selectedId = document.getElementById("gtomato");

// 클래스가 "vegetable"인 모든 요소를 선택하도록 코드를 작성하세요
var selectedClassNameS = document.getElementsByClassName("vegetable");

// name 속성값이 "tomato"인 모든 요소를 선택하도록 코드를 작성하세요
var selectedNameS = document.getElementsByName("tomato");

// 선택된 요소들을 출력합니다. 출력 순서를 변경하면 오답 처리가 됩니다.
document.write(imgs + "<br>");
document.write(imgs[0] + "<br>");
document.write(selectedTagName + "<br>");
document.write(selectedId + "<br>");
document.write(selectedClassNameS + "<br>");
document.write(selectedNameS[0] + "<br>");

document.write(selectedTagName[1].textContent + "<br>");
document.write(selectedId.textContent + "<br>");







//실습22
// alert("Hello world!");

// HTML <div> 요소를 선택하도록 코드를 작성하세요
var selectedTagName = document.getElementsByTagName("div");

// 아이디가 “banana"인 요소를 선택하도록 코드를 작성하세요
var selectedId = document.getElementById("banana");

// 클래스가 "vegetable"인 모든 요소를 선택하도록 코드를 작성하세요
var selectedClassNameS = document.getElementsByClassName("vegetable");

// name 속성값이 "red"인 모든 요소를 선택하도록 코드를 작성하세요
var selectedNameS = document.getElementsByName("red");


// 선택된 요소들을 출력합니다.
document.write(selectedTagName);
document.write(selectedId);
document.write(selectedClassNameS);
document.write(selectedNameS);

/*
document.write(selectedTagName[0].textContent);
document.write(selectedId.textContent);
document.write(selectedClassNameS[0].textContent);
document.write(selectedNameS[0].textContent);
*/






//실습23
// 아이디가 “apple"인 요소를 선택하도록 코드를 작성하세요
var selectedId = document.getElementById("apple");

// 선택한 요소의 색깔을 red로 바꿉니다.
selectedId.style.color = "red";

// 아이디가 “banana"인 요소를 선택하도록 코드를 작성하세요
var selectedId = document.getElementById("banana");

// 선택한 요소의 색깔을 yellow로 바꿉니다.
selectedId.style.color = "yellow";






//실습24
// 밑의 주석을 해제하지 말고 먼저 실행해서 초기 상태를 확인하세요

// 초기 상태를 확인한 다음엔 주석을 해제해주세요


// 아이디가 “apple"인 요소를 선택하도록 코드를 작성하세요
var selectedId = document.getElementById('apple');

//선택한 요소의 내용을 "strawberry"로 바꿉니다.
selectedId.innerHTML = 'strawberry';

// 아이디가 “onion"인 요소를 선택하도록 코드를 작성하세요
var selectedId = document.getElementById('onion');

//선택한 요소의 내용을 "garlic" 바꿉니다.
selectedId.innerHTML = 'garlic';






//실습25
function highlightWords() {
  const txt = document.getElementById("targetp").innerText;
  let output = "";
  let words = txt.split(" ");
  let size = 8;
  let replacementword = "";
  for (let i = 0; i < words.length; i++) {
    let word = words[i];
    if (word.length >= 8) {
      replacementword = "<span class='lightext'>" + word + "</span>";
    } else {
      replacementword = word;
    }
    output = output + " " + replacementword + " ";
  }

  return output;
}

document.getElementById("targetp").innerHTML = highlightWords();

// 3. 볼드체인 텍스트를 모두 파란색으로 변경하세요.
function highlight() {
  var els = document.getElementsByTagName("strong");
  for (var i = 0; i < els.length; i++) {
    els[i].style.color = "blue";
  }
}

// 4. 볼드체인 텍스트를 모두 검은색으로 변경하세요.
function returnNormal() {
  var els = document.getElementsByTagName("strong");
  for (var i = 0; i < els.length; i++) {
    els[i].style.color = "black";
  }
}







//실습26
var myUl = document.querySelector("ul");
var myLi, myText, i;

//1. for loop을 사용해서 index.html의 <ul></ul> 내에 li 태그 문장 20개를 createTextNode()와 appendChild()를 사용해서 추가합니다.
for (i = 0; i <= 20; i = i + 1) {
  myLi = document.createElement("li");
  myUl.appendChild(myLi);
  myText = document.createTextNode(i + "번째 문장");
  myLi.appendChild(myText);
}






//실습27
function myFunction() {
  var para = document.createElement('p');
  para.innerHTML = '이것이 추가될 문장입니다.';
  document.getElementById('myDiv').appendChild(para);
}






//실습28
// 1.‘Home’이라고 적힌 <li> 태그를 생성하세요.
let li = document.createElement("li");
li.textContent = "Home";

// 2.insertBefore()를 사용해서 menu의 <li> 태그 앞에 'Home'을 삽입하세요.
let menu = document.getElementById("menu");

menu.insertBefore(li, menu.firstElementChild);

// 3. insertBefore()를 사용해서 calendar의 첫 번째 child로 예약 알람 문구를 삽입하세요.
let calendar = document.getElementById("calendar");

let div = document.createElement("div");
div.innerHTML = "<strong>안녕하세요!</strong> 예약하신 날짜입니다.";
calendar.insertBefore(div, calendar.firstElementChild);

// 4. removeChild()를사용해서 'Contact'라고 적힌 <li> 태그를 삭제하세요.
menu.removeChild(menu.lastElementChild);






