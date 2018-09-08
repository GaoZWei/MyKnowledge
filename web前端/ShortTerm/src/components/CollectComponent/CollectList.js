import React from 'react'
import {Layout, Popconfirm, Modal, Table, Divider, message} from 'antd';

function check(record) {
  Modal.info({
    title: `${record.title}`,
    content: (
      <div dangerouslySetInnerHTML={{
        __html: `${record.knowledgecontent}`
      }}/>
    ),
  });
}

class CollectList extends React.Component {
  render() {
    //console.log(window.location.href);
    const columns = [{
      title: '收藏知识点Id',
      dataIndex: 'id',
      key: 'id',
      render: text => <a href="javascript:;">{text}</a>,
    }, {
      title: '收藏知识点标题',
      dataIndex: 'title',
      key: 'title',
    },
      {
        title: '标签',
        dataIndex: 'tagname',
        key: 'tagname',
      },
      {
        title: '收藏数',
        dataIndex: 'count',
        key: 'count',
      },
      // {
      //   title: '标签',
      //   key: 'tags',
      //   dataIndex: 'tags',
      //   render: tags => (
      //     <span>
      //   {tags.map(tag => <Tag color="blue" key={tag}>{tag}</Tag>)}
      // </span>
      //   ),
      // },
      {
        title: '操作',
        key: 'action',
        render: (text, record) => (
          <span>
         <a onClick={() => check(record)} href="javascript:;">查看</a>
       <Divider type="vertical"/>
            {/*<a  onClick={() => deleteCollect(record)} href="javascript:;">取消收藏</a>*/}
            <Popconfirm title="确认取消收藏?" onConfirm={deleteCollect.bind(null, record)}>
            <a href="">取消收藏</a>
          </Popconfirm>
    </span>
        ),
      }];
    const {dispatch} = this.props;
    //删除收藏
    const deleteCollect = (record) => {
      console.log(record.id);
      dispatch({
        type: 'collects/deleteCollect',
        payload: record.id,
      });
      message.success('删除成功');
    }
    let collectData = this.props.collects.collectList;
    console.log(collectData)
    return (
      <Layout style={{width: 1000}}>
        <Table columns={columns}
               rowKey={record => record.id}
               expandedRowRender={record => <p style={{margin: 0}}>{record.knowledgecontent}</p>}
               pagination={true}
               dataSource={collectData}/>
      </Layout>
    );
  }
}

export default CollectList;

