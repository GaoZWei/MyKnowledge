import React from "react";
import { Table, Layout } from "antd";
import {connect} from 'dva';
const SortTable = ({ dataSource,dispatch }) => {
  const columns = [
    { title: "用户ID", dataIndex: "userId", key: "userId" },
    { title: "分类ID", dataIndex: "id", key: "id" },
    { title: "分类名", dataIndex: "title", key: "title" },
    {
      title: "修改处理",
      dataIndex: "",
      key: "x",
      render: () =><a  href="javascript:;">Update</a>
    },
    {
      title: "删除处理",
      dataIndex: "",
      key: "z",
      render: (record) =><a onClick={() => deleteSort(record,dispatch)} href="javascript:;">Delete</a>
    }
  ];
  const deleteSort = (record,dispatch) => {
    // const sortData = {
    //   id: record.id,
    // }
    const id2=record.id
    console.log(id2)
    dispatch({
       type: 'sorts/deleteSort',
       payload: {id2}
    });
  }
  return (
    <Layout style={{ marginLeft: 250,marginTop: 20, width: 1000 }}>
      <Table
        bordered={true}
        rowKey={record => record.id}
        columns={columns}
        expandedRowRender={record => <p style={{ margin: 0 }}>{record.body}</p>}
        dataSource={dataSource}
      />
    </Layout>
  );
};

function mapStateToProps({ sorts }) {
  return {sorts};
}

// 建立数据关联关系
export default connect(mapStateToProps)(SortTable);
