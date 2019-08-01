// Ex1)
// console.log('호랑이' + 100);  // 문자열 + 문자열
// console.log('호랑이', 100);  // 문자열 + 숫자

// console.log(1,"안녕");
// console.log(2,"하세");
// console.log(3,"요");

// console.log('--------------------------------------------------------------');

// Ex2)
// var a = 10;  // 자동으로 숫자 타입으로 선언됨  2018년 8월부터 사용안함
// let b = 20;
// const c = 30;  // 값을 변경 시킬수 없다 (상수화)

// a = 40;
// b = 50;
// // c = 70;  const라서 에러

// console.log(a, b, c);

// console.log('--------------------------------------------------------------');

// Ex3)
// let a = 10;
// console.log(a, typeof(a));  // 변수의 타입을 알아보는 typeof(a)

// a = '호랑이'  // js는 동일한 이름으로 재생성 가능???
// console.log(a, typeof(a));

// console.log('--------------------------------------------------------------');

//Ex4)
// let a = 10;
// console.log(a, typeof(a));

// console.log(typeof('호랑이'));

// console.log(typeof(true));

// console.log('--------------------------------------------------------------');

//Ex5)
// let a;
// console.log(a, typeof(a));

// let b = new Date();
// console.log(b);
// console.log(b, typeof(b));

// let c = [];  // 배열문법
// console.log(c, typeof(c));  // 배열을 object형식으로 해석

// let d = {};
// console.log(d, typeof(d));  // object형식으로 해석

// let ap = {
//     a: 10,
//     b: "호랑이",
//     c: true,  // 습관적으로 , 을 추가
//     d: {  // 객체안에 객체가 있다.
//         e: 20,
//     },
//     f: function () {
//         console.log(30);
//     },
// };

// console.log(ap.a, typeof(ap.a));
// console.log(ap.b, typeof(ap.b));
// console.log(ap.c, typeof(ap.c));
// console.log(ap.d.e, typeof(ap.d.e));
// ap.f();
// console.log(ap.f, typeof(ap.f));

// console.log('--------------------------------------------------------------');

// Ex6)
// let a = 10;
// console.log(a, typeof(a));  // 숫자

// let b = String(a);
// console.log(b, typeof(b));  // 숫자에서 문자열

// let c = Number(b);
// console.log(c, typeof(c));  // 문자열에서 숫자

// console.log('--------------------------------------------------------------');

// Ex7)
// let n = new Date();

// var weekday=new Array(7);
// weekday[0]="일";
// weekday[1]="월";
// weekday[2]="화";
// weekday[3]="수";
// weekday[4]="목";
// weekday[5]="금";
// weekday[6]="토";

// console.log(n.getFullYear() + '년');
// console.log(n.getMonth() + '월');
// console.log(n.getDate() + '일');
// console.log(n.getHours() + '시');
// console.log(n.getMinutes() + '분');
// console.log(n.getSeconds() + '초');
// console.log(weekday[n.getDay()] + '요일');  // n.getDay() 0 ~ 6으로 반환

// console.log('--------------------------------------------------------------');

// Ex8)
// let obj = {
//     a: 10,
//     b: '호랑이',
//     c: true
// }
// console.log(obj.a);
// console.log(obj['b']);  // 두가지 방법 모두 사용한다.

// console.log('---------------------');


// for (let item in obj) {  // forin 문장으로 돌린다.
//     console.log(item, obj[item]);
// }

// console.log('--------------------------------------------------------------');

// Ex9)
// let ar = [10, '호랑이', true, {}];

// for (let i = 0; i < ar.length; i++) {  // for
//     console.log(ar[i]);
// }

// for (let item in ar) {  // forin
//     console.log(ar[item]);
// }

// ar.forEach((v, k) => {  // forEach
//     console.log(v, k);
// });
// ar.forEach((v) => {
//     console.log(v);
// });

// console.log('--------------------------------------------------------------');

// Ex10)
// let a = 10;
// let b = '10';

// console.log(a == b);  // '값' 비교
// console.log(a === b);  // '값', '타입' 비교
// console.log(3 > 2 ? '코끼리':'호랑이');

// console.log('--------------------------------------------------------------');

// Ex11)
let num = 5;
let a = '';

for (let i = -2; i <= 2; i++) {
    for (let j = -2; j <= 2; j++) {
        let b = i;
        let c = j;

        b < 0 ? b = b * - 1 : b;
        c < 0 ? c = c * - 1 : c;

        b + c < 3 ? a += "*" : a += " ";
    }
    a += "\n"
}
console.log(a);
