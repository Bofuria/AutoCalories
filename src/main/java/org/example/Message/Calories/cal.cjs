const fetch = require("node-fetch");

//************** retrieving data from java **************//

let javaPort = 8080;
let javaServer = require('net').createServer();
let WebSocketServer = require('ws').Server
    , wss = new WebSocketServer({port: 90});

var fileData;

javaServer.on('connection', function (javaSocket) {
    var clientAddress = javaSocket.address().address + ':' + javaSocket.address().port;
    console.log('Java ' + clientAddress + ' connected');

    var firstDataListenner = function (data) {
        fileData = data;
        console.log('Received namespace from java End: ' + data);
        //javaServer.send(data);
        //javaSocket.removeListener('data', firstDataListenner);
    }

    javaSocket.on('data', firstDataListenner);

    javaSocket.on('close', function() {
        console.log('Java ' + clientAddress + ' disconnected');
    });
});
javaServer.listen(javaPort);

//************** sending data back to java **************//
let query = fileData;
//query = "cheddar cheese"
const params = {
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

getData().then(data =>
   console.log(data.foods[0].foodNutrients[3].value))