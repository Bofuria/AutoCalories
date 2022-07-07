const fetch = require("node-fetch");
const net = require('node:net');
// const receive = require('./receive.cjs')
//************** retrieving data from java **************//


//let client = new net.createConnection(8080, "localhost");

//server.listen(8080, "localhost");
//client.setEncoding('utf8');

//************** sending data back to  **************//

// server gets its port automatically
// server //

// const server = net.createServer((socket) => {
//     socket.on('data', (data) => {
//         query = data;
//     });
// }).on('error', (err) => {
//     console.error(err);
// });
//
// server.listen(8081, "localhost");
// console.log("listening")

// client //

//console.log("receive.cjs query = " + receive.query)
//query = "cheddar cheese"
let query;

let params = {
    api_key: '3wHHCaKsjWzJjm5tgmicgXB6qq592joghgbMcvyO',
    query: query,
    dataType: ["Survey (FNDDS)"],
    pagesize: 1,
}

const api_url =
    `https://api.nal.usda.gov/fdc/v1/foods/search?api_key=${encodeURIComponent(params.api_key)}&query=${encodeURIComponent(params.query)}&dataType=${encodeURIComponent(params.dataType)}&pageSize=${encodeURIComponent(params.pagesize)}`

function getData() {
    return fetch(api_url)
        .then(response => response.json())
}

const server = net.createServer((socket) => {
    socket.on('data', (data) => {
        query = data;
        console.log("data received")
        server.close();
    });
}).on('error', (err) => {
    console.error(err);
})

server.listen(2020, "localhost");
console.log("server listening: " + server.listening)

// getData().then(data =>
//              console.log(data.foods[0].foodNutrients[3].value)).toString()

// java server <--- js client

var config = {
    host: 'localhost',
    port: 4040
};



var client = new net.Socket();

client.connect(config.port, config.host, () => {
}).on("connect", () => {
    client.write(
        getData().then(data =>
            console.log(data.foods[0].foodNutrients[3].value)).toString()
    );
});



// client.connect( config.port, config.host, function () {
//     client.write(
//         getData().then(data =>
//             console.log(data.foods[0].foodNutrients[3].value)).toString()
//     );
// });

///////////////////////////////////////////////////////////////////////////////
// {
//     host: config.host,
//         port: config.port
// }
//client.setTimeout(5000)


// client.on("ready",function () {
// })

// client.on("ready", function () {
//     client.write(
//         getData().then(data =>
//             console.log(data.foods[0].foodNutrients[3].value)).toString()
//     );
// })



//getData().then(data =>
//   console.log(data.foods[0].foodNutrients[3].value))