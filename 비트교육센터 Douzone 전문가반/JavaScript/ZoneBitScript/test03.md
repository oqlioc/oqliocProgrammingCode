### JavaScript 기본 함수형태 3가지

[JavaScript 기본 함수형태 3가지](#javascript-기본-함수형태-3가지)  
[Ex1](#ex1)  
[Ex2](#ex2)  
[Ex3](#ex3)  
[Ex4](#ex4)  
[Ex5](#ex5)  
[예제](#예제)  
[예제 강사님의 코드](#예제-강사님의-코드)  
[생성자 함수](#생성자-함수)

#### Ex1
```JavaScript
// Ex1)
function f4(f = () => { console.log('f4번 없다'); }) {
}
function f5() {
    console.log('f5번 없다');
}
function f6() {
    console.log('f6번 없다');
    return 100;
}
f4(f5);  // f5함수자체를 넘기는것
console.log(1,'-----');
f4(f5());  // f5함수의 리턴 값을 넘기는것
console.log(2,'-----');
f4(f6());  // 

console.log('-----');

function f7() {
    return{
        a: 1,
        b: 2,
    }
}
function f8() {
    return f7;
}
function f9() {
    return f7();
}

console.log(f8());  // 함수가 리턴된다.
console.log(f9());  // 함수의 결과 값이 리턴된다.
```

#### Ex2
```JavaScript
// Ex2)
let obj = {
    a: 10,
    b: 20,
}
console.log(obj);

obj.a = 30;
console.log(obj);

obj.c = 30;  // 객체의 동적 속성 추가
console.log(obj);

delete(obj.b);  // 객체의 동적 속성 삭제
console.log(obj);

console.log('-----');

const obj1 = {
    a: 1,
    b: 2,
    c: 3,
}

// obj1 = {

// }

// obj1.a = 10;
// console.log(obj1);

// obj1.a = 20;
console.log(obj1);

// Object.freeze(obj1);  // 갱신 불가 (a, b, c) 모두 불가

console.log('-----');

Object.defineProperty(obj1, 'a', {writable:false});  // obj1.a만 수정 불가

obj1.a = 30;
console.log(obj1);
```

#### Ex3
```JavaScript
// Ex3)
obj0 = { na: '호랑이', ag: 10, se: 200, }
obj1 = { na: '코끼리', ag: 20, se: 300, }
obj2 = { na: '얼룩말', ag: 30, se: 400, }
obj3 = { na: '고라니', ag: 40, se: 500, }
obj4 = { na: '청솔모', ag: 50, se: 600, }

const ar = [];
ar.push(obj0);
ar.push(obj1);
ar.push(obj2);
ar.push(obj3);
ar.push(obj4);
console.log(ar);

console.log('-----');

let getsum = function () {
    return this.ag + this.se;
}

for (let i = 0; i < ar.length; i++) {  // 외부에서 함수를 만들어서 배열에 동적으로 넣는다.
    ar[i].ge = getsum;
    ar[i].sum = ar[i].ge();
}
console.log(ar);

console.log('-----');

obj = {
    a: 10, 
    f1: function () {
        console.log(this.a, 'f1 func call');
    },
    f2: function () {
        this.f1();
    }
}
obj.f2();
```

#### Ex4
```JavaScript
// Ex4)
obj = {
    a: 10,
    b: 20,
    f1: () => {

    },
    f2: () => {

    },
}

function func(a, b) {
    return {
        a: a,
        b: b,
        f1: () => {
            return this.a + this.b;
        },
        f2: function () {
            function sum () {
                return this.a - this.b;
            }
            return sum.call();
        }
    }
}

const ar = []

ar.push(func(20, 10));
ar.push(func(30, 10));
ar.push(func(40, 10));
ar.push(func(50, 10));

console.log(ar);
ar[0].f2

var numbers = {
    numberA: 5,
    numberB: 10,
    sum: function () {
        function calculate() {
            return this.numberA + this.numberB;
        }
        // 문맥을 수정하기 위해 .call() 메소드를 적용
        return calculate.call(this);
    }
};
numbers.sum(); // => 15  
```

#### Ex5
```JavaScript
// Ex5)
let ar = []
ar.push(-3);
ar.push(-4);
ar.push(1);
ar.push(2);

console.log(ar.length);
console.log(ar);

console.log('기본모양-----');

ar.sort();  // 기본적인 오름차순 정렬
console.log(ar);
console.log('오름차순-----');

ar.sort((a, b) => {  // 함수를 재정의해서 내림 차순 정렬
    return b-a;
});
console.log(ar);
console.log('내림차순-----');

ar.sort((a, b) => {  // 함수를 재정의해서 내림 차순 정렬
    let x = Math.abs(a);
    let y = Math.abs(b);
    return x-y;
});
console.log(ar);
console.log('절대값-----');

console.log('-----');

let arr = []
arr.push({m: '김', a: 10,})
arr.push({m: '박', a: 5,})
arr.push({m: '이', a: 15,})

arr.sort((obj1, obj2) => {
    return obj1.a - obj2.a;
});
console.log(arr);

arr.sort((obj1, obj2) => {
    return obj1.m - obj2.m;
});
console.log(arr);
```

#### 예제
```JavaScript
// 예제)
console.log('-----내가 짠 코드-----');
function an(n, k, e, m) {
    return {
        name: n,
        kor: k,
        eng: e,
        mat: m,
        s: function() { return this.kor + this.eng + this.mat },
        output: function() { console.log(this.name, this.kor, this.eng, this.mat, this.s())},
    }
}

let ar = []
ar.push(an('dog', 10, 20, 30))
ar.push(an('cat', 40, 50, 60))
ar.push(an('tur', 70, 80, 90))

ar.sort((obj1, obj2) => {
    return  obj2.s() - obj1.s();
});

for (let i = 0; i < ar.length; i++) {
    ar[i].output()
}
```

#### 예제 강사님의 코드
```JavaScript
console.log('-----강사님이 짠 코드-----');
// 강사님이 짠 코드
function makeObj(n, k, e) {
    return {
        n: n,
        k: k,
        e: e,
        s: function() { return this.k + this.e },
        output: function() { console.log(this.n, this.k, this.e, this.s())},
    }
}

const arr = []
arr.push(makeObj('강아지', 4, 3))
arr.push(makeObj('고양이', 5, 6))
arr.push(makeObj('거북이', 1, 2))

for (let i = 0; i < arr.length; i++) {
    arr[i].output()
}

console.log('-----------------');


arr.sort(function (o1, o2) { 
    return o1.s() - o2.s()
})

for (let i = 0; i < arr.length; i++) {
    arr[i].output()
}
```

#### 생성자 함수
```JavaScript
console.log('-----생성자함수-----');
function ff(n, k, e) {  // 생성자함수
    this.n = n;
    this.k = k;
    this.e = e;
    this.s = function () {
        return this.k + this.e;
    },
    this.output = function () {
        console.log(this.n, this.k, this.e, this.s())
    }
}
// 사용법
// const obj8 = new ff('고양이', 30, 20);
// console.log(obj8);  // 함수객체

const arrr = []
arrr.push(new ff('고양이', 30, 20));
arrr.push(new ff('호랑이', 40, 30));
arrr.push(new ff('강아지', 50, 40));

arrr.sort((o1, o2) => {
    return o1.s() - o2.s();
});

for (let i = 0; i < arrr.length; i++) {
    arrr[i].output();
}

```
