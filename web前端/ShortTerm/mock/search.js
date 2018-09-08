const Mock = require('mockjs');
const Random = Mock.Random;
module.exports = {
  'GET /searchList'(req, res) {
    let searchData = [];
    for (let i = 0; i < 20; i++) {
      let newSearchData = {
        id: Random.string('number', 2),
        title: Random.cname(),
        sort_id:Random.string('number', 1),
        content:Random.paragraph(1),
        tags:[Random.word(2),Random.word(3)],
        date:Random.date(),
      }
      searchData.push(newSearchData);
    }
    res.json({
      data: searchData
    })
  }
}


