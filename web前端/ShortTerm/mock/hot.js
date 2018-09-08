const Mock = require('mockjs');
const Random = Mock.Random;

module.exports = {
  'Get /hotsList'(req, res) {
    let hotData = [];
    for (let i = 0; i < 3; i++) {
      let newHot = {
        id: Random.string('number', 4),
        count: Random.string('number', 3),
        title: Random.word(5, 10),
        shortContent:Random.sentence(2),
        content:Random.paragraph(2)
      }
      hotData.push(newHot);
    }
    res.json({
      data:hotData
    })
  }
}
