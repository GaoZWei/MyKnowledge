const Mock = require('mockjs');
const Random = Mock.Random;

module.exports = {
  'GET /sharesList'(req, res) {
    let sortData = [];
    for (let i = 0; i < 3; i++) {
      let newSort = {
        id: Random.string('number', 5),
        title: Random.cname(),
        content:Random.paragraph(1),
        date:Random.date(),
      }
      sortData.push(newSort);
    }
    res.json({
      //success: true,
      data: sortData
    })
  }
}


