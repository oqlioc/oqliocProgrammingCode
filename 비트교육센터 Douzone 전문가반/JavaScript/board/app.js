var createError = require('http-errors');  // http의 에러 오류
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');  // request 객체에 cookies 속성을 부여
var logger = require('morgan');  // 로그 파일

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var board1Router = require('./routes/board1');
var board2Router = require('./routes/board2');  //

var app = express();

app.set('views', path.join(__dirname, 'views'));  // path.join(path1, path2…) 받아서 하나의 경로로 만들어줌
app.set('view engine', 'ejs');  // view 엔진에 ejs 적용

app.use(logger('dev'));  // dev형식으로 로그파일 생성
app.use(express.json());  // express의 body parser (JSON 변환)
// extended 는 중첩된 객체표현을 허용할지 말지를 정하는 것이다. 객체 안에 객체를 파싱할 수 있게하려면 true
// 내부적으로 true 를 하면 qs 모듈을 사용하고, false 면 query-string 모듈을 사용
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));  // public폴더의 절대경로를 잡아줌

app.use('/', indexRouter);  // 제일 처음 접속하면 indexRouter로 이동
app.use('/users', usersRouter);  // /users로 접속하면 usersRouter로 이동
app.use('/board1', board1Router);  // /board1로 접속하면 board1Router로 이동
app.use('/board2', board2Router);  // /board2로 접속하면 board2Router로 이동

app.use(function (req, res, next) {  // 404에러를 감지하면 error handler로 보낸다
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
