import React from "react";
//import { Component } from 'react';
import { Modal, Form, Input, Select } from 'antd';

const FormItem = Form.Item;
//const Option = Select.Option;

class KnowledgeEditModal extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      visible: false,
    };
  }

  showModelHandler = (e) => {
    if (e) e.stopPropagation();
    this.setState({
      visible: true,
    });
  };

  hideModelHandler = () => {
    this.setState({
      visible: false,
    });
  };
  okHandler = () => {
    console.log(this.props)
    const { onOk } = this.props;
    this.props.form.validateFields((err, values) => {
      if (!err) {
        onOk(values);
        this.hideModelHandler();
      }
    });
  };
  // modifyHandler = () => {
  //   const { onOk } = this.props;
  //   console.log(this.props)
  //   this.props.form.validateFields((err, values) => {
  //     if (!err) {
  //       console.log('1231321',values)
  //      //调用问题
  //       onOk(values)
  //       this.hideModelHandler();
  //     }
  //   });
  // };

  render() {
    const { children } = this.props;
    const { getFieldDecorator } = this.props.form;
    const { id,catename,title,knowledgecontent} = this.props.record;
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 14 },
    };

    return (
      <span>
        <span onClick={this.showModelHandler}>
          { children }
        </span>
        <Modal
          title={this.props.record.id ? '编辑' : '新建'}
          visible={this.state.visible}
          // onOk={this.modifyHandler}
          onOk={this.okHandler}
          onCancel={this.hideModelHandler}
        >
          <Form onSubmit={this.okHandler}>
            <FormItem
              {...formItemLayout}
              label="id"
            >
              {
                getFieldDecorator('id', {
                  initialValue: id,
                })(<Input disabled='true'/>)
              }
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="标题"
            >
              {
                getFieldDecorator('title', {
                  initialValue: title,
                })(<Input />)
              }
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="内容"
            >
              {
                getFieldDecorator('knowledgecontent', {
                  initialValue: knowledgecontent,
                })(<Input />)
              }
              </FormItem>
              <FormItem
                {...formItemLayout}
                label="所属分类"
              >
              {
                getFieldDecorator('catename', {
                  initialValue: catename,
                })(<Input />)
              }
            </FormItem>
          </Form>
        </Modal>
      </span>
    );
  }
}

export default Form.create()(KnowledgeEditModal);
