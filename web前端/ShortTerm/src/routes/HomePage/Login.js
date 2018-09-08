import {connect} from 'dva';
import loginStyle from './login.css';
import {Form, Layout,Icon, Input, Button, Checkbox, Modal} from 'antd';

const FormItem = Form.Item;

function Login({dispatch, form}) {
  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFields((err, userData) => {
      if (!err) {
        console.log('Received values of form: ', userData);
        new Promise((resolve, reject) => {
          dispatch({
            type: 'userLogin/doLogin',
            payload: {
              userData,
              resolve,
              reject
            }
          });
        }).then(null, (data) => {
          Modal.error({
            title: '错误提示',
            content: <p style={{fontSize: 14}}>用户名 或 密码 错误！</p>
          });
        });
      }
    });
  }

  const {getFieldDecorator} = form;
  //console.log(form)

  return (
    <Layout>

      <Form onSubmit={handleSubmit} className={loginStyle.login_form}>
        <h1 style={{marginTop:10,marginLeft:70}}>我的知识库</h1>
        <FormItem>
          {getFieldDecorator('account', {
            rules: [{required: true, message: 'Please input your username!'}],
          })(
            <Input prefix={<Icon type="user" style={{color: 'rgba(0,0,0,.25)'}}/>} placeholder="Username"/>
          )}
        </FormItem>
        <FormItem>
          {getFieldDecorator('password', {
            rules: [{required: true, message: 'Please input your Password!'}],
          })(
            <Input prefix={<Icon type="lock" style={{color: 'rgba(0,0,0,.25)'}}/>} type="password"
                   placeholder="Password"/>
          )}
        </FormItem>
        <FormItem>
          {getFieldDecorator('remember', {
            valuePropName: 'checked',
            initialValue: true,
          })(
            <Checkbox>Remember me</Checkbox>
          )}
          <a className={loginStyle.login_form_forgot} href="">Forgot password</a>
          <Button type="primary" htmlType="submit" className={loginStyle.login_form_button}>
            Log in
          </Button>
          Or <a href="">register now!</a>
        </FormItem>
      </Form>
    </Layout>
  );
}

const LoginForm = Form.create()(Login);

function mapStateToProps(state) {
  return state;
}

export default connect(mapStateToProps)(LoginForm);
