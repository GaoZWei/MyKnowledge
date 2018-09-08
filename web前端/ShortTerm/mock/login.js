const Mock = require('mockjs');
module.exports = {
  'POST /login'(req, res) {
    const {username, password} = req.body;
    if (username == 'gao' && password == '123') {
      res.json({
        success: true,
        msg: '登录成功',
        userInfo: {
          username: 'gao'
        }
      });
    } else {
      res.json({
        success: false,
        msg: '登录失败'
      });
    }
  },
  'POST /logout'(req, res) {
    res.json({
      success: true
    })
  },
}
