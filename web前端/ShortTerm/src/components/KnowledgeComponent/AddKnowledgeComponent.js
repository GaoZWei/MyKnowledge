import React from 'react';
import {connect} from 'dva'
import {Form, Input, Layout, Modal, Button, Select, Row, Col} from 'antd';

const Option = Select.Option;
const {TextArea} = Input;
const FormItem = Form.Item;

class AddKnowledgeComponent extends React.Component {

  render() {
    //取到分类的数据
    //console.log(this.props.sorts.sortList)
    const handleSelectChange = (value) => {
      console.log(`selected ${value}`);
    }
    const {getFieldDecorator} = this.props.form;
    const handleSubmit = (e) => {
      const {dispatch} = this.props;
      e.preventDefault();
      this.props.form.validateFields((err, inputData) => {
        console.log('Received values of form: ', inputData);
        if (!err) {
          dispatch({
            type: 'knowledges/addKnowledge',
            payload: inputData,
          });
        }
      });
    }
    //动态显示分类的选项
    // const openSelect = () => {
    //   console.log(131231)
    // }

    //onDropdownVisibleChange={openSelect()}
    return (
      <Layout>
        <Form onSubmit={handleSubmit}>
          <div>
            <h1> 添加知识点 </h1>
          </div>
          <hr/>
          <FormItem
            label="Select"
            hasFeedback
            label="选择分类："
            labelCol={{span: 6}}
            wrapperCol={{span: 14}}>
            {getFieldDecorator('catename', {
              rules: [
                {required: true, message: '请选择分类'},
              ],
            })(
              <Select placeholder="请选择分类" >
                <Option value="java">java</Option>
                <Option value="数学">数学</Option>
                <Option value="语文">语文</Option>
                <Option value="英语">英语</Option>
                <Option value="高数">高数</Option>
                {/*renderItem={item => (*/}
                {/*<Option value={item.id}>{item.id}</Option>*/}
                {/*)}*/}
              </Select>
            )}
          </FormItem>
          <FormItem
            label="Select"
            hasFeedback
            label="请选择标签："
            labelCol={{span: 6}}
            wrapperCol={{span: 14}}>
            {getFieldDecorator('tagname', {
              rules: [
                {required: true, message: '请选择标签'},
              ],
            })(
              <Select placeholder="请选择标签">
                <Option value="Java">Java</Option>
                <Option value="ssm框架">ssm框架</Option>
                <Option value="java大神分享">java大神分享</Option>
                {/*renderItem={item => (*/}
                {/*<Option value={item.id}>{item.id}</Option>*/}
                {/*)}*/}
              </Select>
            )}
          </FormItem>

          {/*<FormItem*/}
            {/*label="选择标签(多选)"*/}
            {/*labelCol={{span: 6}}*/}
            {/*wrapperCol={{span: 14}}>*/}
            {/*{getFieldDecorator('tags', {*/}
              {/*rules: [*/}
                {/*{required: true, message: 'Please select your favourite colors!', type: 'array'},*/}
              {/*],*/}
            {/*})(*/}
              {/*<Select mode="multiple" placeholder="请选择标签">*/}
                {/*<Option value="标签1">标签1</Option>*/}
                {/*<Option value="标签2">标签2</Option>*/}
                {/*<Option value="标签3">标签3</Option>*/}
              {/*</Select>*/}
            {/*)}*/}
          {/*</FormItem>*/}

          <FormItem
            id="control-input"
            label="标题："
            labelCol={{span: 6}}
            wrapperCol={{span: 14}}>
            {getFieldDecorator('title', {
              rules: [{required: true, message: 'Please input your Password!'}],
            })(
              <Input id="control-input" placeholder="请输入标题"/>
            )}
          </FormItem>

          <FormItem
            id="control-textarea"
            label="知识点："
            labelCol={{span: 6}}
            wrapperCol={{span: 14}}>
            {getFieldDecorator('knowledgecontent', {
              rules: [{required: true, message: '请填写内容!'}],
            })(
              <TextArea placeholder={'Bill is a cat.\n' +
              '      Bill is a cat.   Bill is a cat.  Bill is a cat.\n' +
              '      Bill is a cat.'} rows={16}>
              </TextArea>
            )}
          </FormItem>
          <Row style={{marginTop: 24}}>
            <Col span="16" offset="8">
              <Button type="primary" htmlType="submit">保存</Button>&nbsp;
              <Button type="primary" htmlType="submit">保存并上传</Button>&nbsp;
              <Button type="primary" htmlType="reset">取消</Button>
            </Col>
          </Row>

        </Form>
      </Layout>
    );
  }
}

const AddKnowledge = Form.create(
//   {
//   mapPropsToFields(props) {
//   return {
//     sort: Form.createFormField({
//       ...props.id,
//       value: props.id,
//     }),
//   };
// }
// }
)(AddKnowledgeComponent);

//console.log(AddKnowledgeComponent)
function mapStateToProps(state) {
  return {...state}
}

export default connect(mapStateToProps)(AddKnowledge);
