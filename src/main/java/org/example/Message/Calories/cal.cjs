const fetch = require("node-fetch");
const net = require('node:net');
//************** retrieving data from java **************//


//let client = new net.createConnection(8080, "localhost");

//server.listen(8080, "localhost");
//client.setEncoding('utf8');


//************** sending data back to java **************//
let query;
// server gets its port automatically
// server //

const server = net.createServer((socket) => {
    socket.on('data', (data) => {
        query = data;
    });
}).on('error', (err) => {
    console.error(err);
});

server.listen(8081, "localhost");
console.log("listening")

// client //

var config = {
    host: 'localhost',
    port: 4040
};

var client = new net.Socket();

//client.setTimeout(5000)

client.connect({
    host: config.host,
    port: config.port
}, function () {
    client.write(
        getData().then(data =>
            console.log(data.foods[0].foodNutrients[3].value)).toString()
    );
});

//query = "cheddar cheese"
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

//getData().then(data =>
//   console.log(data.foods[0].foodNutrients[3].value))