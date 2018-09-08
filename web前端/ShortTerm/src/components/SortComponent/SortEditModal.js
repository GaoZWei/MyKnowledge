import React from "react";
//import { Component } from 'react';
import { Modal, Form, Input, Select } from 'antd';

const FormItem = Form.Item;
//const Option = Select.Option;

class SortEditModal extends React.Component {

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

  // modifyHandler = () => {
  //   const { modify } = this.props;
  //   this.props.form.validateFields((err, values) => {
  //     if (!err) {
  //       console.log(values)
  //       modify(values);
  //       this.hideModelHandler();
  //     }
  //   });
  // };
  //测试
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
  render() {
    const { children } = this.props;
    const { getFieldDecorator } = this.props.form;
    const { id,catename} = this.props.record;
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
          <Form onSubmit={this.modifyHandler}>
            <FormItem
              {...formItemLayout}
              label="分类id"
            >
              {
                getFieldDecorator('id', {
                  initialValue: id,
                })(<Input disabled='true'/>)
              }
            </FormItem>
            <FormItem
                {...formItemLayout}
                label="分类名"
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

export default Form.create()(SortEditModal);
