// class : .~
// id : #~
// Tag : tag

//Ex8-노드 삽입과 바꾸기
window.addEventListener("load", function(){

    var section = document.querySelector("#section8");
    
    var noticeList =section.querySelector(".notice-list"); 
    var tbodyNode = noticeList.querySelector("tbody");
    var upButton = section.querySelector(".up-button");
    var downButton = section.querySelector(".down-button");

    var currentNode = tbodyNode.firstElementChild;//.children[0];

    downButton.onclick = function(){
       var nextNode = currentNode.nextElementSibling;

       if (nextNode == null) {
           alert("더 이상 이동 할 수 없습니다.");
           return;
       }

       //tbodyNode.insertBefore(nextNode, currentNode);
       currentNode.insertAdjacentElement("beforebegin", nextNode);
    };

    upButton.onclick = function(){
       var prevNode = currentNode.previousElementSibling;

       if (prevNode == null) {
           alert("더 이상 이동 할 수 없습니다.");
           return;
       }

       //tbodyNode.insertBefore(currentNode, prevNode);
       currentNode.insertAdjacentElement("afterend", prevNode);
    };

});

//Ex7 : 노드 복제와 템플릿 태그
window.addEventListener("load", function(){
    var notices = [
        {id:5, title:"퐈이야~~~", regDate:"2019-01-26", writerId:"newlec", hit:0},
        {id:6, title:"나 좀 복제해줘~", regDate:"2019-01-26", writerId:"newlec", hit:17}
    ];

    var section = document.querySelector("#section7");
    
    var noticeList =section.querySelector(".notice-list"); 
    var tbodyNode = noticeList.querySelector("tbody");

    var cloneButton = section.querySelector(".clone-button");
    var templateButton = section.querySelector(".template-button");

    cloneButton.onclick = function(){
        var trNode = noticeList.querySelector("tbody tr");
        var cloneNode = trNode.cloneNode(true);
        var tds = cloneNode.querySelectorAll("td");

        tds[0].textContent = notices[0].id;
        tds[1].innerHTML = '<a href="' + notices[0].id + '">' + notices[0].title + '"</a>';
        tds[2].textContent = notices[0].regDate;
        tds[3].textContent = notices[0].writerId;
        tds[4].textContent = notices[0].hit;

        tbodyNode.append(cloneNode);
    };

    templateButton.onclick = function(){
        var template = section.querySelector("template");
       
        for (let i = 0; i < notices.length; i++) {

        var cloneNode = document.importNode(template.content, true);
        var tds = cloneNode.querySelectorAll("td");

        tds[0].textContent = notices[i].id;
        //tds[1].innerHTML = '<a href="' + notices[0].id + '">' + notices[0].title + '"</a>';
        
        var aNode = tds[1].children[0];
        aNode.href = notices[i].id;
        aNode.textContent = notices[i].title;

        tds[2].textContent = notices[i].regDate;
        tds[3].textContent = notices[i].writerId;
        tds[4].textContent = notices[i].hit;

        tbodyNode.append(cloneNode);
        }
        
    };

});

// Ex6 : 노드 조작 : 메뉴 추가(createTextNode, Element)
window.addEventListener("load", function () {
    var section = document.querySelector("#section6");
    
    var titleInput = section.querySelector(".title-input");
    var menuListUl = section.querySelector(".menu-list");
    var addButton = section.querySelector(".add-button");
    var delButton = section.querySelector(".del-button");

    addButton.onclick = function(){
        var title = titleInput.value;

        var html = '<a href="">' + title + '</a>';
        var li = document.createElement("li");
        li.innerHTML = html;

        menuListUl.appendChild(li);
//---------------------------------------------------
        menuListUl.innerHTML += '<li><a href="">' + title + '</a></li>';
//---------------------------------------------------
        // var title = titleInput.value;
        // var txtNode = document.createTextNode(title);

        // var aNode = document.createElement("a");
        // aNode.href = "";
        // aNode.appendChild(txtNode);

        // var liNode = document.createElement("li");

        // liNode.appendChild(aNode);

        // menuListUl.appendChild(liNode);
//---------------------------------------------------
        // var title = titleInput.value;
        // var txtNode = document.createTextNode(title);

        // menuListDiv.appendChild(txtNode)
    };

    delButton.onclick = function(){
        //var txtNode = menuListDiv.childNodes[0];
//---------------------------------------------------
        var liNode = menuListUl.children[0];

        // menuListUl.removeChild(liNode);
//---------------------------------------------------
        liNode.remove();
    };
})

// Ex5 : 엘리먼트 노드의 속성 & css 속성 변경
window.addEventListener("load", function () {
    var section = document.querySelector("#section5");
    var imgSelect = section.querySelector(".img-select");
    var srcInput = section.querySelector(".src-input");
    var changeButton = section.querySelector(".change-button");
    var colorInput = section.querySelector(".color-input");
    var img = section.querySelector(".img");

    changeButton.onclick = function(){
        // img.src = "images/" + srcInput.value;
        img.src = "images/" + imgSelect.value;

        // img.style["border-color"] = colorInput.value;
        img.style.borderColor = colorInput.value;
        console.log(img.className);
    };
})

// Ex4 : ChildeNodes를 이용한 노드 선택
window.addEventListener("load", function () {
    var section4 = document.querySelector("#section4");
    var box = section4.querySelector(".box");

    var inputs1 = box.children[0];  // childNodes[0];
    var inputs2 = box.children[1];  //childNodes[1];

    inputs1.value = "Hello";
    inputs2.value = "Ok";
})

// Ex3 : Selectors API Level1
window.addEventListener("load", function () {
    var section3 = document.getElementById("section3");

    var txtX = section3.querySelector("input[name='x']");
    var txtY = section3.querySelector(".txt-y");
    var btnAdd = section3.querySelector(".btn-add");
    var txtSum = section3.querySelector(".txt-sum");

    btnAdd.onclick = function () {
        var x = parseInt(txtX.value);
        var y = parseInt(txtY.value);

        txtSum.value = x + y;
    };
})

// Ex2 : 엘리먼트 선택방법 개선하기
window.addEventListener("load", function () {
    var section2 = document.getElementById("section2");

    var txtX = section2.getElementsByClassName("txt-x")[0];
    var txtY = section2.getElementsByClassName("txt-y")[0];
    var btnAdd = section2.getElementsByClassName("btn-add")[0];
    var txtSum = section2.getElementsByClassName("txt-sum")[0];
 /*   
    var inputs = section2.getElementsByTagName("input");

    var txtX = inputs[0];
    var txtY = inputs[1];
    var btnAdd = inputs[2];
    var txtSum = inputs[3];
*/
    btnAdd.onclick = function () {
        var x = parseInt(txtX.value);
        var y = parseInt(txtY.value);

        txtSum.value = x + y;
    };
})

window.addEventListener("load", function () {

    var txtX = document.getElementById("txt-x");
    var txtY = document.getElementById("txt-y");
    var btnAdd = document.getElementById("btn-add");
    var txtSum = document.getElementById("txt-sum");

    btnAdd.onclick = function () {
        var x = parseInt(txtX.value);
        var y = parseInt(txtY.value);

        txtSum.value = x + y;
    };
})