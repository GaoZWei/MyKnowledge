import React from 'react'
import {Modal, Button, Layout, Table, Divider, Tag} from 'antd';
import NavLeft from '../../components/NavComponent/NavLeft'

class KnowledgeModal extends React.Component {
  state = {
    loading: false,
    visible: false,
  }
  handleOk = () => {
    this.setState({loading: true});
    setTimeout(() => {
      this.setState({loading: false, visible: false});
    }, 3000);
  }

  handleCancel = () => {
    this.setState({visible: false});
  }

  render() {
    //想根据id显示吗,舍弃
    // const showModal = (record) => {
    //    console.log(21321)
    //    const {dispatch} = this.props;
    //    const id2 = record.id
    //    console.log(id2)
    //    dispatch({
    //      type:'knowledges/queryKnowledgeById',
    //      payload:id2
    //    });
    //    this.setState({
    //      visible: true,
    //    });
    //  }
    function info(value) {
      Modal.info({
        title: `${value.title}`,
        content: (
          <div dangerouslySetInnerHTML={{
            __html: `${value.content}`
          }}/>
        ),
        onOk() {},
      });
    }
    const columns = [{
      title: '知识点Id',
      dataIndex: 'id',
      key: 'name',
      render: text => <a href="javascript:;">{text}</a>,
    }, {
      title: '知识点标题',
      dataIndex: 'title',
      key: 'age',
    },
      {
        title: '所属分类',
        dataIndex: 'sort_id',
        key: 'sort',
      }, {
        title: '创建时间',
        dataIndex: 'date',
        key: 'address',
      }, {
        title: '标签',
        key: 'tags',
        dataIndex: 'tags',
        render: tags => (
          <span>
      {tags.map(tag => <Tag color="blue" key={tag}>{tag}</Tag>)}
    </span>
        ),
      }, {
        title: '操作',
        key: 'action',
        render: (text, record) => (
          <span>
      {/*<a onClick={() => showModal(record)}*/}
            {/*href="javascript:;">查看</a>*/}
            <a onClick={() => info(record)}>查看</a>
      <Divider type="vertical"/>
     <NavLeft target="/addknowledge" linkText={ <a href="javascript:;">添加</a>}/>
      <Divider type="vertical"/>
      <a href="javascript:;">删除</a>
      <Divider type="vertical"/>
      <a href="javascript:;">修改</a>
    </span>
        ),
      }];

    //取数据源
    var knowledgeData = this.props.knowledges.knowledgeList;
    return (
      <Layout style={{width: 1000}}>
        <Table columns={columns} rowKey={record => record.id} dataSource={knowledgeData}/>
      </Layout>
    );
  }
}
//const {visible, loading} = this.state;
//<Modal visible={visible}
//                title="Title"
//                onOk={this.handleOk}
//                onCancel={this.handleCancel}
//                footer={[
//                  <Button key="back" onClick={this.handleCancel}>Return</Button>,
//                  <Button key="submit" type="primary" loading={loading} onClick={this.handleOk}>
//                    Submit
//                  </Button>,
//                ]}>
//           <p>Some contents...</p>
//           <p>Some contents...</p>
//           <p>Some contents...</p>
//           <p>Some contents...</p>
//           <p>Some contents...</p>
//         </Modal>
export default KnowledgeModal;

