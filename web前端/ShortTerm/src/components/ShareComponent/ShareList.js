import React from 'react'
import {connect} from 'dva';
import {Layout, Popconfirm,Table, message} from 'antd';

// const ShareList = ({ dataSource,dispatch }) => {

class ShareList extends React.Component {

  render() {
    const deleteShare = (record) => {
      const {dispatch} = this.props;
      const id2 = record.id
      console.log(id2)
      dispatch({
        type: 'shares/deleteShare',
        payload: id2,
      });
      message.success('删除成功');
    }
    const columns = [
      {title: "分享知识点Id", dataIndex: "id", key: "id"},
      {title: "分享知识点标题", dataIndex: "title", key: "title"},
      {title: "所属分类", dataIndex: "catename", key: "catename"},
      {
        title: "处理操作",
        dataIndex: "",
        key: "z",
        render: (record) => (
          <span>
          {/*<a onClick={() => deleteShare(record)} href="javascript:;">取消分享</a>*/}
          <Popconfirm title="确认取消分享?" onConfirm={deleteShare.bind(null,record)}>
            <a href="">取消分享</a>
          </Popconfirm>
          </span>
        )
      }
    ];

    var shareData = this.props.shares.list;
    console.log(shareData)
    return (
      <Layout style={{width: 1000}}>
        <Table
          bordered={true}
          rowKey={record => record.id}
          columns={columns}
          expandedRowRender={record => <p style={{margin: 0}}>{record.knowledgecontent}</p>}
          dataSource={shareData}
        />
      </Layout>
    );
  }
}

// 建立数据关联关系
function mapStateToProps(state) {
  return {shares: state.shares};
}

// 建立数据关联关系
export default connect(mapStateToProps)(ShareList);
