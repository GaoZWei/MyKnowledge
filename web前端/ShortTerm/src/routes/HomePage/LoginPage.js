import React from 'react';
import {Form, Input, Layout, Checkbox, Button, Select, Row, Col} from 'antd';

const Option = Select.Option;
const {TextArea} = Input;
const FormItem = Form.Item;

class LoginPage extends React.Component {

  render() {
    function handleSelectChange(value) {
      console.log(`selected ${value}`);
    }

    return (
      <Layout style={{backgroundColor:'#f2f0ff',height:800}}>
        <div>
          <h1 style={{marginLeft:600,marginTop:200}}>登录注册 </h1>
        </div>
        <Form>

          <FormItem
            id="control-input"
            label="用户名："
            style={{marginLeft:200,marginTop:20}}
            labelCol={{span: 6}}
            wrapperCol={{span: 8}}>
            <Input id="control-input" placeholder="在此输入用户名"/>

          </FormItem>

          <FormItem
            id="control-input"
            label="密码："
            style={{marginLeft:200,marginTop:20}}
            labelCol={{span: 6}}
            wrapperCol={{span: 8}}>
            <Input id="control-input" placeholder="在此输入密码"/>
          </FormItem>
          <Row style={{ marginLeft:250,marginTop:20}}>
            <Col span="16" offset="8">
              <Button type="primary" htmlType="submit">登录</Button>&nbsp;
              <Button type="primary" htmlType="submit">取消</Button>
            </Col>
          </Row>
        </Form>
      </Layout>
    );
  }
}

export default LoginPage;
