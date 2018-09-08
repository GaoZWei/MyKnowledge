const Mock = require('mockjs');
const Random = Mock.Random;
module.exports = {
  'GET /knowledgeList'(req, res) {
    let knowledgeData = [];
    for (let i = 0; i < 3; i++) {
      let newKnowledgeData = {
        id: Random.string('number', 5),
        title: Random.cname(),
        sort_id:Random.string('number', 5),
        content:Random.paragraph(1),
        tags:[Random.word(2),Random.word(3)],
        date:Random.date(),
      }
      knowledgeData.push(newKnowledgeData);
    }
    res.json({
      data: knowledgeData
    })
  }
}


