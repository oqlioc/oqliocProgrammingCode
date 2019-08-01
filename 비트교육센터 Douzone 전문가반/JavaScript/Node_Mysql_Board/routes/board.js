var express = require('express');
var router = express.Router();

//   MySQL 로드
var pool = require('./connection_pool');

router.get('/', function (req, res, next) {  // /board2로 들어오면 /board2/list로 보내준다
    res.redirect('/board/list');  // list로 넘겨준다
});

router.get('/board/list', function (req, res, next) {
    pool.getConnection(function (err, connection) {
        var sql = "SELECT BRDNO, BRDTITLE, BRDWRITER, DATE_FORMAT(BRDDATE,'%Y-%m-%d') BRDDATE FROM TBL_BOARD";
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);
            console.log("rows : " + JSON.stringify(rows));  // json 형식으로 콘솔출력
            
            res.render('board/list', { rows: rows ? rows : {} });
            connection.release();
        });
    });
});

router.get('/board/form', function (req, res, next) {
    pool.getConnection(function (err, connection) {
        var sql = "SELECT BRDNO, BRDTITLE, BRDWRITER, DATE_FORMAT(BRDDATE,'%Y-%m-%d') BRDDATE FROM TBL_BOARD";
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);
            console.log("rows : " + JSON.stringify(rows));  // json 형식으로 콘솔출력
            
            res.render('board/list', { rows: rows ? rows : {} });
            connection.release();
        });
    });
});



module.exports = router;
