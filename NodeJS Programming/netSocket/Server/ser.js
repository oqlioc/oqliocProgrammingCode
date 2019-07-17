net = require('net');
// 사용자 클라이언트 배열
var clients = [];

var server = net.createServer(function (socket) {

    socket.name = socket.remoteAddress + ":" + socket.remotePort

    clients.push(socket);

    socket.write("안녕하세요 " + socket.name + "\n");
    broadcast(socket.name + " 대화에 참여 하셨습니다.\n", socket);

    socket.on('data', function (data) {
        broadcast(socket.name + "> " + data, socket);
    });

    socket.on('end', function () {
        clients.splice(clients.indexOf(socket), 1);
        broadcast(socket.name + " 님이 퇴장하셨습니다.\n");
    });

    socket.on('error', function () {
        console.log(socket.name + '님의 socket 에러 입니다.');

    });

    function broadcast(message, sender) {
        clients.forEach(function (client) {

            if (client === sender) return;
            client.write(message);
        });

        process.stdout.write(message)
    };

});

server.listen(5000, function () {
    console.log('Server listening: ');

    server.on('close', function () {
        console.log('서버가 종료되었습니다.');
    });

    server.on('error', function (err) {
        console.log('서버 오류 입니다.');
    });
});

console.log("5000번 포트 : 서버가 작동 중 입니다.\n");