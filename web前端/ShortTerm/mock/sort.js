const Mock = require('mockjs');
const Random = Mock.Random;
// let db=Mock.mock({
//   'data|3-6':[{
//     id:'@id',
//     name:'@name',
//     'age|18-32':1
//   }]
// });
//
// module.exports={
//   [`GET /sorts`](req,res){
//
//     res.status(200).json(db);
//   },
//
//   [`POST /api/users`](req,res){
//
//     let user=req.body;
//     console.log(req);
//     user.id=Mock.mock('@id');
//     db.data.push(user);
//
//     res.status(200).json(user);
//   }
// }

module.exports = {
  'GET /sortsList'(req, res) {
    let sortData = [];
    for (let i = 0; i < 20; i++) {
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


