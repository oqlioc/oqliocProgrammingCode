// class : .~
// id : #~
// Tag : tag

// Ex3-이벤트 버블링 멈추기
window.addEventListener("load", function(){

    var section = document.querySelector("#section3");
    
    var imgList = section.querySelector(".img-list"); 
    var addButton = section.querySelector(".add-button");
    var currentImg = section.querySelector(".current-img");
    
    imgList.onclick = function(e){
        if (e.target.nodeName != "IMG") return;
 
        currentImg.src = e.target.src;
     };

    addButton.onclick = function(e){
        e.stopPropagation();
        
        var img = document.createElement("img");
        img.src = "images/img1.jpg";
        currentImg.insertAdjacentElement("afterend", img);
    };

});

//Ex2-이벤트 버블링을 이용해 사용자 이벤트 처리하기:event Bubbling
window.addEventListener("load", function(){

    var section = document.querySelector("#section2");

    var imgList = section.querySelector(".img-list"); 
    var currentImg = section.querySelector(".current-img");
    
    imgList.onclick = function(e){
       if (e.target.nodeName != "IMG") return;

       currentImg.src = e.target.src;
    };

    // for (let i = 0; i < imgs.length; i++) {
    //     imgs[i].onclick = function (event) {
    //         currentImg.src = event.target.src;
    //     };
    // }
}); 

//연습문제 1-선택된 레코드 삭제하기:event target
window.addEventListener("load", function () {
    var section = document.querySelector("#section1-1");
    var delBtn = section.querySelectorAll(".del-button");

    for (var i = 0; i < delBtn.length; i++) {
        delBtn[i].onclick = function (event) {
            //var tr = event.target;
            var confirm = window.confirm("삭제 하시겠습니까?");
            if (confirm === true) {
                alert("삭제가 되었습니다.");
                var tr = event.target.parentElement.parentElement;
                tr.remove();
                //tr.parentElement.parentElement.remove();
            } else {
                alert("삭제가 취소 되었습니다.");
            }
        };
    }

});



//Ex1-선택된 이미지 보여주기:event target
window.addEventListener("load", function () {

    var section = document.querySelector("#section1");

    var imgs = section.querySelectorAll(".img");
    var currentImg = section.querySelector(".current-img");

    for (let i = 0; i < imgs.length; i++) {
        imgs[i].onclick = function (event) {
            currentImg.src = event.target.src;
        };
    }

    // imgs[0].onclick = function(event){
    //     currentImg.src = event.target.src;
    // };

    // imgs[1].onclick = function(event){
    //     currentImg.src = event.target.src;
    // };

}); 