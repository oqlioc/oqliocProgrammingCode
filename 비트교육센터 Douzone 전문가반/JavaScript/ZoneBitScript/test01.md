# vsCode 기본
## vsCode는 절대로 단축키 변경 하지마시오.

[vsCode 기본](#vscode-기본)  
[vsCode는 절대로 단축키 변경 하지마시오.](#vscode는-절대로-단축키-변경-하지마시오)  
[JavaScript 기본 설정](#javascript-기본-설정)  
[JavaScript 기본 문법](#javascript-기본-문법)  
[Ex1](#ex1)  
[Ex2](#ex2)  
[Ex3](#ex3)  
[Ex4](#ex4)  
[Ex5](#ex5)  
[Ex6](#ex6)  
[Ex7](#ex7)  
[Ex8](#ex8)  
[Ex9](#ex9)  
[Ex10](#ex10)  
[Ex11](#ex11)

## JavaScript 기본 설정
1. vsCode 필수 플러그인
- 문법체크 : ESLint
- Guides_들여쓰기체크
- Reactjs code snippets_자동완성
- Relative Path_경로작성
2. vsCode 단축키
- 실행 : Ctrl F5
- 블럭복사 : Alt + Shift + 방향키
- Ctrl 클릭앤드래그
- 같은창두개 : Ctrl + \
- 블럭주석 : Alt + Shift + A
- 블럭이동 : Alt + 방향키

## JavaScript 기본 문법

#### Ex1
```JavaScript
// Ex1)
console.log('호랑이' + 100);  // 문자열 + 문자열
console.log('호랑이', 100);  // 문자열 + 숫자

console.log(1,"안녕");
console.log(2,"하세");
console.log(3,"요");
```

#### Ex2
```JavaScript
// Ex2)
var a = 10;  // 자동으로 숫자 타입으로 선언됨  2018년 8월부터 사용안함
let b = 20;
const c = 30;  // 값을 변경 시킬수 없다 (상수화)

a = 40;
b = 50;
// c = 70;  const라서 에러

console.log(a, b, c);
```

#### Ex3
```JavaScript
// Ex3)
let a = 10;
console.log(a, typeof(a));  // 변수의 타입을 알아보는 typeof(a)

a = '호랑이'  // js는 동일한 이름으로 재생성 가능???
console.log(a, typeof(a));
```

#### Ex4
```JavaScript
//Ex4)
let a = 10;
console.log(a, typeof(a));

console.log(typeof('호랑이'));

console.log(typeof(true));
```

#### Ex5
```JavaScript
//Ex5)
let a;
console.log(a, typeof(a));

let b = new Date();
console.log(b);
console.log(b, typeof(b));

let c = [];  // 배열문법
console.log(c, typeof(c));  // 배열을 object형식으로 해석

let d = {};
console.log(d, typeof(d));  // object형식으로 해석

let ap = {
    a: 10,
    b: "호랑이",
    c: true,  // 습관적으로 , 을 추가
    d: {  // 객체안에 객체가 있다.
        e: 20,
    },
    f: function () {
        console.log(30);
    }
};

console.log(ap.a);
console.log(ap.b);
console.log(ap.c);
console.log(ap.d.e);
ap.f();
```

#### Ex6
```JavaScript
// Ex6)
let a = 10;
console.log(a, typeof(a));  // 숫자

let b = String(a);
console.log(b, typeof(b));  // 숫자에서 문자열

let c = Number(b);
console.log(c, typeof(c));  // 문자열에서 숫자
```

#### Ex7
```JavaScript
// Ex7)
let n = new Date();

var weekday=new Array(7);
weekday[0]="일";
weekday[1]="월";
weekday[2]="화";
weekday[3]="수";
weekday[4]="목";
weekday[5]="금";
weekday[6]="토";

console.log(n.getFullYear() + '년');
console.log(n.getMonth() + '월');
console.log(n.getDate() + '일');
console.log(n.getHours() + '시');
console.log(n.getMinutes() + '분');
console.log(n.getSeconds() + '초');
console.log(weekday[n.getDay()] + '요일');  // n.getDay() 0 ~ 6으로 반환
```

#### Ex8
```JavaScript
// Ex8)
let obj = {
    a: 10,
    b: '호랑이',
    c: true
}
console.log(obj.a);
console.log(obj['b']);  // 두가지 방법 모두 사용한다.

console.log('---------------------');


for (let item in obj) {  // forin 문장으로 돌린다.
    console.log(item, obj[item]);
}
```

#### Ex9
```JavaScript
// Ex9)
let ar = [10, '호랑이', true, {}];

for (let i = 0; i < ar.length; i++) {  // for
    console.log(ar[i]);
}

for (let item in ar) {  // forin
    console.log(ar[item]);
}

ar.forEach((v, k) => {  // forEach
    console.log(v, k);
});
ar.forEach((v) => {
    console.log(v);
});
```

#### Ex10
```JavaScript
// Ex10)
let a = 10;
let b = '10';

console.log(a == b);  // 값만 비교
console.log(a === b);  // 값이랑 타입 비교
console.log(3 > 2 ? '코끼리':'호랑이');
```

#### Ex11
```JavaScript
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
```