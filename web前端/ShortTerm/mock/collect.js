const Mock = require('mockjs');
const Random = Mock.Random;
module.exports = {
  'GET /collectsList'(req, res) {
    let collectData = [];
    //let tags=[]
    for (let i = 0; i < 3; i++) {
      let newCollect = {
        id: Random.string('number', 5),
        title: Random.cname(),
        knowledgecontent:Random.paragraph(1),
        tags:[Random.word(2),Random.word(2)],
        date:Random.date(),
      }
      collectData.push(newCollect);
    }
    res.json({
      data: collectData
    })
  }
}


