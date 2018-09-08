import React from 'react'
import {Modal, Popconfirm,Layout, Table, Divider, message} from 'antd';
import NavLeft from '../../components/NavComponent/NavLeft'
import KnowledgeEditModal from '../../components/KnowledgeComponent/KnowledgeEditModal'

class KnowledgeTable extends React.Component {
  render() {
    const {dispatch} = this.props;

    function check(value) {
      Modal.info({
        title: `${value.title}`,
        content: (
          <div dangerouslySetInnerHTML={{
            __html: `${value.knowledgecontent}`
          }}/>
        ),
      });
    }

    // function modifyKnowledge(values) {
    //   console.log(2312)
    //   //console.log(id)
    //   console.log(values)
    //   dispatch({
    //     type: 'knowledges/modifyKnowledgeById',
    //     payload: {values},
    //   });
    // }

    function deleteKnowledge(record) {
      dispatch({
        type: 'knowledges/deleteKnowledgeById',
        payload: record.id
      });
      message.success('删除知识点成功');
    }
    function shareKnowledge(record) {
      dispatch({
        type: 'knowledges/shareKnowledgeById',
        payload: record.id
      });
      message.success('分享知识点成功');
    }
    function editHandler(id, values) {
      console.log(values)
      dispatch({
        type: 'knowledges/modifyKnowledgeById',
        payload: { id, values },
      });
      message.success('修改成功');
    }
    const columns = [{
      title: '知识点Id',
      dataIndex: 'id',
      key: 'id',
      render: text => <a href="javascript:;">{text}</a>,
    }, {
      title: '知识点标题',
      dataIndex: 'title',
      key: 'title',
    },
      {
        title: '所属分类',
        dataIndex: 'catename',
        key: 'catename',
      },
      {
        title: '创建时间',
        dataIndex: 'time',
        key: '时间',
      },
      {
        title: '标签',
        key: 'tagname',
        dataIndex: 'tagname',
        //   render: tags => (
        //     <span>
        // {tags.map(tag => <Tag color="blue" key={tag}>{tag}</Tag>)}
        // </span>
        //    ),
      },
      {
        title: '操作',
        key: 'action',
        render: (text, record) => (
          <span>
      <a onClick={() => check(record)} href="javascript:;">查看</a>
      <Divider type="vertical"/>
      <NavLeft target="/addknowledge" linkText={<a href="/addknowledge">添加</a>}/>
      <Divider type="vertical"/>
            {/*<a onClick={() => deleteKnowledge(record)} href="javascript:;">删除</a>*/}
       <Popconfirm title="确认删除知识点?" onConfirm={deleteKnowledge.bind(null, record)}>
            <a href="">删除</a>
       </Popconfirm>
      <Divider type="vertical"/>
      <KnowledgeEditModal record={record}  onOk={editHandler.bind(null, record.id)}>
            <a href="javascript:;">修改</a>
          </KnowledgeEditModal>
             <Divider type="vertical"/>
        <Popconfirm title="确认分享知识点?" onConfirm={shareKnowledge.bind(null, record)}>
            <a href="">分享</a>
       </Popconfirm>
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

export default KnowledgeTable;

