// java client ---> js server

const net = require("node:net");

let query;

const server = net.createServer((socket) => {
    socket.on('data', (data) => {
        query = data;
        console.log("data received")
        server.close();
    });
}).on('error', (err) => {
    console.error(err);
});
server.listen(2020, "localhost");
// server.listen was here
console.log("listening started");
