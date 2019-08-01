//커넥션 풀 생성
var mysql = require('mysql');
var pool = mysql.createPool({
    connectionLimit: 5,
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'todoapp'
});

module.exports = pool;