let express = require('express');
var path = require('path');
var app = express();
var http = require('http');
var router = express.Router();



app.set('views', path.join(__dirname, 'views'));  // path.join(path1, path2…) 받아서 하나의 경로로 만들어줌
app.set('view engine', 'ejs');

app.use(express.json());  // express의 body parser (JSON 변환)
// extended 는 중첩된 객체표현을 허용할지 말지를 정하는 것이다. 객체 안에 객체를 파싱할 수 있게하려면 true
// 내부적으로 true 를 하면 qs 모듈을 사용하고, false 면 query-string 모듈을 사용
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));  // public폴더의 절대경로를 잡아줌

var indexRouter = require('./routes/index');
var boardRouter = require('./routes/board');

// app.use('/', indexRouter);
app.use('/', boardRouter);

app.listen(3000, function(){
	console.log('connected');		
});