const raw = require('../../WEB-INF/json/raw.json');
const list = require('jsonfile');

const names = raw.SurveyFoods.map(food => food.description)

names.forEach(element => list.writeFile('tempList.json', element))
// list.writeFile('list.json', names)

// function write(el) {
//     list.writeFile('list.json', el)
// }