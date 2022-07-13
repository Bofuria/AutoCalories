// java client ---> js server

const net = require("node:net");
const fetch = require("node-fetch");

let params = {
    api_key: '3wHHCaKsjWzJjm5tgmicgXB6qq592joghgbMcvyO',
    query: "",
    dataType: ["Survey (FNDDS)"],
    pagesize: 1,
}

let api_url;

function getData() {
    return fetch(api_url)
        .then(response => response.json())
}

const server = net.createServer((socket) => {
    socket.setEncoding("utf8")

    socket.on('data', (data) => {
        params.query = data.toString().trim().slice(2)
        //console.log("params.query: " + params.query)
        api_url =
            `https://api.nal.usda.gov/fdc/v1/foods/search?api_key=${encodeURIComponent(params.api_key)}&query=${encodeURIComponent(params.query)}&dataType=${encodeURIComponent(params.dataType)}&pageSize=${encodeURIComponent(params.pagesize)}`
        //console.log("api_url: " + api_url)
        const client = net.createConnection(4040, "localhost");
        client.on('connect', () => {
            getData().then(data => {
                if(data.foods[0] === undefined) {
                    client.write("error");
                    client.destroy();
                }
                client.write(data.foods[0].foodNutrients[3].value.toString());
            })
        })
        server.close();
    });
}).on('error', (err) => {
    console.error(err);
});
server.listen(2020, "localhost");
//console.log("speed: " + process.uptime());

