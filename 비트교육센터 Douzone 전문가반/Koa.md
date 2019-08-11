# NodeJS Koa Framework

## Hello world 출력하기
```JavaScript
const Koa = require('koa');
const app = new Koa();
app.use((ctx) => {
    ctx.body = 'hello world';
});
app.listen(4000, () => {
    console.log('listen to port 4000', '서버 가동 중');
});
```

## 미들웨어 등록
```JavaScript
const Koa = require('koa');
const app = new Koa();
app.use(async (ctx, next) => {
    console.log(1);
    await next();
    console.log('bye');    
})
// app.use((ctx, next) => {  // 미들웨어 설정
//     console.log(1);
//     next().then(() => {  // next() 등록한 다음 미들웨어 실행  // 미들웨어들이 끝나면 .then() 실행된다
//         console.log('bye');
//     });
// })
app.use((ctx, next) => {
    console.log(2);
    next();
})
app.use((ctx) => {
    ctx.body = 'hello world';
});
app.listen(4000, () => {
    console.log('listen to port 4000', '서버 가동 중');
});
```

## nodemon 설치 및 설정
>npm install --dev nodemon --save  
>yarn add --dev nodemon  
>package.json 설정하기  
```JavaScript
{
  "name": "blog-backend",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "start": "node src",  // 시작 지점 설정
    "start:dev": "nodemon --watch src/ src/index.js",  // nodemon이 src디렉터리를 주시하면서 src/index.js을 실행하도록 설정
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "dependencies": {
    "koa": "^2.7.0",
    "nodemon": "^1.19.1"
  }
}
```  
>nodemon 실행하기  
>>yarn start : 그냥 한번 실행  
>>yarn start:dev : 코드가 변경될때마다 실행  
>> npm으로는 실행이 안됨...  
  
## POSTman 다운로드
>REST API 요청 테스팅을 할수 있는 도구  
>요청할 url을 입력하고 및에 json 객체를 입력하고 send를 누르면 요청이 온다.  

## koa-router 기본 설정 (라우터)  
>npm install koa-router --save  
```JavaScript
const Koa = require('koa');
const Router = require('koa-router');  // koa라우터 등록
const app = new Koa();
const router = new Router();
// 라우터 설정
router.get('/', (ctx) => {
    ctx.body = '홈';
})
router.get('/about', (ctx) => {
    ctx.body = '소개';
})
// app 인스턴스에 라우터 적용
app.use(router.routes()).use(router.allowedMethods());
app.listen(4000, () => {
    console.log('listen to port 4000', '서버 가동 중');
});
```  

## router 파라미터와 쿼리
```JavaScript
const Koa = require('koa');
const Router = require('koa-router');  // koa라우터 등록
const app = new Koa();
const router = new Router();
// 라우터 설정
router.get('/', (ctx) => {
    ctx.body = '홈';
});
router.get('/about/:name?', (ctx) => {
    const { name } = ctx.params;    
    // name의 존재 유무에 따라 다른 결과 출력
    console.log(111111111);
    console.log(name);
    ctx.body = name ? name + '의 소개' : '소개할 이름이 없습니다.';
});
router.get('/posts', (ctx) => {
    const { id } = ctx.query;
    // id의 존재 유무에 따라 다른 결과 출력
    ctx.body = id ? '포스트 #' + id : '포스트 아이디가 없습니다.';
});
// app 인스턴스에 라우터 적용
app.use(router.routes()).use(router.allowedMethods());
app.listen(4000, () => {
    console.log('listen to port 4000', '서버 가동 중');
});
```

## REST API
>웹브라우저에서 직접 데이터베이스에 접근하면 보안상 문제가 발생하기에  
>>REST API를 만들어야한다.  (  DB <==> REST API 서버 <==> 클라이언트  )  

src\api\posts\index.js
```JavaScript
const Router = require('koa-router');
const posts = new Router();
const printInfo = (ctx) => {
    ctx.body = {
        method: ctx.method,
        path: ctx.path,
        params: ctx.params,
    };
};
posts.get('/', printInfo);
posts.post('/', printInfo);
posts.get('/:id', printInfo);
posts.delete('/:id', printInfo);
posts.put('/:id', printInfo);
posts.patch('/:id', printInfo);
module.exports = posts;
```  
src\api\index.js
```JavaScript
const Router = require('koa-router');
const posts = require('./posts');
const api = new Router();
api.use('/posts', posts.routes());  // posts 라우트를 api 라우터에 연결
// 라우터를 내보낸다.
module.exports = api;
```
src\index.js
```JavaScript
const Koa = require('koa');
const Router = require('koa-router');  // koa라우터 등록

const api  = require('./api');

const app = new Koa();
const router = new Router();

// 라우터 설정
router.use('/api', api.routes());  // api 라우터 적용

// app 인스턴스에 라우터 적용
app.use(router.routes()).use(router.allowedMethods());

app.listen(4000, () => {
    console.log('listen to port 4000', '서버 가동 중');
});
```

## koa-bodyparser 적용 ( JSON 객체를 파싱해주는것 )
>npm install koa-bodyparser --save  
```JavaScript
const Koa = require('koa');
const Router = require('koa-router');
const bodyParser = require('koa-bodyparser');
const api  = require('./api');
const app = new Koa();
const router = new Router();
// 라우터 설정
router.use('/api', api.routes());  // api 라우터 적용
// 라우터 적용 전에 bodyParser 적용
app.use(bodyParser());
// app 인스턴스에 라우터 적용
app.use(router.routes()).use(router.allowedMethods());
app.listen(4000, () => {
    console.log('listen to port 4000', '서버 가동 중');
});
```

```JavaScript
```

```JavaScript
```

```JavaScript
```

```JavaScript
```

```JavaScript
```

```JavaScript
```