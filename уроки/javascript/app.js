var path = require('path');
var express = require('express');
var net = require('net');
var app = express();
var server = app.listen(3000);

app.use(express.static('static'));
var io = require('socket.io').listen(server);
console.log("server started on 3000 port");

io.on('connection', function(socket){
	socket.on('calculate', function(msg){
		var client = net.connect(1781, 'localhost');
		client.write(msg.speed + "," + msg.breakingSpeed + "," + msg.maxLoad);
		client.end();
	});
});

net.createServer(function (socket) {
	socket.on('data', function(data) {
		io.emit('calculate', data);
 	});
}).listen(3001);
