onMyClick : 함수
onClick : 뒤에는 원래 함수가 와야한다

index.js의 store에 등록하여서 app.js에 들어오면
reducer가 제일 먼저 call된다
reducer가 setState의 역활을 한다.

수정할때
Reducer reducer(state = { num: 10, age: 100 } 초기값 추가 후
Action 으로가서 함수를 넣는다
Reducer switch문의 case를 추가한다.

store는 1개
Reducer 1개 이상
Action 1개 이상
State 1개 이상