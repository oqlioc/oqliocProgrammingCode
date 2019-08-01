// Ex1)
// F1();
// function F1() {  // Hoisting이 된다.
//     console.log('F1 call !');
// }


// const F2 = function () {  // const로 func 선언
//     console.log('F2 call !');
    
// };
// F2();

// const F3 = () => console.log("F3 call !");
// F3();

//-----------------------------------------------------

// Ex2)
// function f1() {  // 인수전달 없고 리턴값 없음
//     console.log('f1번 func');
// };
// f1();

// function f2(a, b) {  // 인수전달 있고 리턴값 없음
//     console.log('f2번 func', a, b);
//     console.log('f2번 func', typeof(a), typeof(b));
// };
// f2(10, '호랑이');

// function f3() {  // 인수전달 없고 리턴값 있음
//     console.log('f3번 func');
//     return 100;
// };
//   // 사용법
// let num = f3();
// console.log(num);

// console.log(f3());

// function f4(n, s) {
//     console.log('f4번 func');
//     return n + s;
// }
// console.log(f4(10, '호랑이'));
// console.log(f4(10, 20));

//-----------------------------------------------------

// Ex3)
// const f1 = () => console.log('f1 func call');
// f1();

// const f2 = (n, s) => console.log(n, s);
// f2(10, '호랑이');

// const f3 = () => {return 100};
// console.log(f3());

// const f4 = (n, s) => {return n + s};
// console.log(f4(10, '호랑이'));
// console.log(f4(10, 20));

//-----------------------------------------------------

// Ex4)
// const f1 = num => {
//     console.log('f1 func call', num);
// };
// f1(10);

// const f2 = () => 20;  // {} 과 return 이 생략됨
// console.log('f2 func call', f2());

// const f3 = num => 30;
// console.log('f3 func call', f3());

//-----------------------------------------------------

// Ex5)
// const f1 = () => {
//     let n = {  // 객체가 됨
//         a:10,
//         b:20,
//     }
//     return n;
// };

// const f2 = () => {
//     return {  // f1에서
//         a:10,
//         b:20,
//     };
// };

// const f3 = () => (  // f2에서
//     {
//         a:10,
//         b:20,
//     }
// );

// const f4 = () => {  // f3에서
//     retrun(
//         {
//             a: 10,
//             b: 20,
//         }
//     )
// };

// const f5 = () => (  // 객체가 리턴되는것
//     {
//         a: 10,
//         b: 20,
//     }
// );

// const f1 = () => {
//     console.log('f1 func call');
//     retrun(
//         {
//             a: 10,
//             b: 20,
//         }
//     )
// };
// f1();

//-----------------------------------------------------

// Ex6)
// const f1 = () => {
//     console.log('f1 func call');
//     const f2 = () => {
//         console.log('f2 func call');
//     };
//     return f2;
// };

// const f3 = f1();
// f3();  // 리턴을 받음
// console.log('-----------------');
// f1()();  // 함수 연속 호출

//-----------------------------------------------------

// Ex7)
// const f1 = () => {  // 함수를 만들고 그 함수를 리턴
//     const f2 = (n, s) => {
//         console.log(n, s);
//     };
//     return f2;
// };
// f1()(10, '호랑이');

// const f2 = (n1) => (  // 리턴에 함수 생성
//     (n2) => {
//         console.log(n1, n2);
//     }
// );
//f2(100)(200);

// const f3 = n1 => (
//     n2 => console.log(n1, n2)  // 리턴 되는것
// );
// f3(100)(200);

// const f4 = n1 => (
//     n2 => {
//         console.log(n1, n2);  // 리턴이 아님, 함수실행
//      }
// );
// f4(100)(200);
//----------
// const f1 = () => {
//     const f2 = () => {

//     }
// }
//----------
// const f1 = (n1) => {
//     const f2 = (n2) => {
        
//     }
// }
//----------
// const f1 = (n1) => {
//     return (n2) => {
        
//     }
// }
//----------
// const f1 = n1 => {
//     return n2 => {
        
//     }
// }
//----------
// const f1 = n1 => n2 => {
//     console.log(n1, n2);
// };
// f1(100)(200);

//-----------------------------------------------------

// Ex8)
// 함수간의 지역변수를 공유한다. Closure
// let f1 = function () {  // 지역변수 num의 생명을 늘려준다
//     let num = 10;
//     function f2() {
//         let s = '호랑이'
//         console.log(s);
//         console.log(num);  // f1의 지역 변수 num을 사용할수있다.
//     };
//     return f2;
// };
// f1()();

//-----------------------------------------------------

// Ex9)
// const f1 = function (f2) {  // 함수를 인자로 받는다.
//     f2();
// }

// const f3 = () => {
//     console.log('f3 func call');
// }

// const f4 = () => () => {  // f4를 콜하면 함수가 리턴됨
//     console.log('f4 func call');
// }

// f1(f3);

// console.log('---------------');

// f1(f4());

// console.log('---------------');

// f1(() => {  // 바로 함수를 만들어서 보낼수있다.
//     console.log('익명함수로 만들어서 보냄');
// })

// const f5 = () => {  // f4의 원형
//     return (() => {
//         console.log('f4 func call');
//     })
// }

// const f6 = n => {  // 객체를 리턴 시켜주는 함수다.
//     return (n, s) => {
//         return (
//             {
//             }
//         )
//     }
// }

// console.log('---------------');

// const f7 = n => {  // 객체를 리턴 시켜주는 함수다.
//     return (n, s) => {
//         return (
//             {
//                 a: 10,
//                 b: '호랑이',
//                 c: true,
//                 d: () => {

//                 },
//                 e: {},
//             }
//         )
//     }
// }
// const obj = f7(100)(200, '독수리');
// console.log(obj);

//-----------------------------------------------------

// Ex10)
// let f1 = function () {  // let 수정 가능
//     console.log('f1 func call');
// }
// f1 = () =>{

// }

// const f2 = function () {  // const 수정 불가
//     console.log('f2 func call');
// }
// // f2 = () =>{
    
// // }

//-----------------------------------------------------

// Ex11)
// function f1() {
//     console.log('f1 func call !');
// }
// f1();


// const f2 = function () {
//     console.log('f2 func call !');
    
// };
// f2();

// const f3 = () => console.log("f3 func call !");
// f3();

// const obj = {
//     f4:() => {

//     },
// }

// ES6부터 지원
// class Ap {
//     f1() {
//         console.log('f1 func call !');
//     };
// }
// let a = new Ap();  // class 객체 생성
// a.f1();

//-----------------------------------------------------

// Ex12)
// const f1 = function () {

//     console.log('f1 func call', arguments);

//     console.log('--------------------');

//     for (const item in arguments) {
//         console.log(arguments[item]);
//     }

//     console.log('--------------------');

//     for (let i = 0; i < arguments.length; i++) {
//         console.log(arguments[i]);
//     }
// }
// f1(10, 20);

//-----------------------------------------------------

// Ex13)
// const f1 = (f2) => {  // 콜백함수 
//     f2();
// }
// const f2 = () =>  {
//     console.log('안녕');
    
// }
// f1(f2)

//     console.log('--------------------');

// setTimeout(() => {  // (a, b) a 함수를 b밀리초만큼 뒤에 실행  // 비동기함수
//     console.log('setTimeout');
// }, 3000);
// console.log('출력');

//     console.log('--------------------');

// let obj = {
//     a: 10,
//     b: '호랑이',
// }
// with (obj) {  // obj 생략 가능
//     console.log(a, b);
// }

//     console.log('--------------------');

// let obj = {
//     name: '홍길동',
//     age: 100,
// }
// // let name = obj.name;
// // let age = obj.age;

// // ES6
// // 비구조화 할당  //  비구조화 할당  //  비구조화 할당

// const { name, age } = obj;
// console.log(name, age);

// console.log('--------------------');

// const f1 = (obj) => {
//     const { name, age } = obj;
//     console.log(name, age);
    
// };
// f1(obj);

// console.log('--------------------');

// const ar = [10, 20, 30];
// const [t1, t2, t3] = ar;
// console.log(t1, t2, t3);

//-----------------------------------------------------