//window.onload = function () {
window.addEventListener("load", function () {

    var btnPrint = document.getElementById("btn-Print");

    btnPrint.onclick = function () {
        var x, y;

        x = prompt("x 값을 입력하세요", 0);
        y = prompt("y 값을 입력하세요", 0);

        x = parseInt(x);
        y = parseInt(y);

        //alert(x + y);
        btnPrint.value = x + y;
        //span1.innerText = x + y;
    };
})