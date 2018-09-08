import React from "react";
import {Table, Layout, Popconfirm,message} from "antd";
import {connect} from 'dva';
import SortEditModal from '../../components/SortComponent/SortEditModal'

class SortTableNew extends React.Component {

  render() {
    const {dispatch} = this.props;
    const deleteSort = (record) => {
      dispatch({
        type: 'sorts/deleteSort',
        payload: record.id
      });
      message.success('删除成功');
    }
    // const updateSort = (record) => {
    //   console.log(record)
    //   dispatch({
    //     type: 'sorts/updateSort',
    //     payload: record
    //   })
    //   message.success('修改成功');
    // }
    function editHandler(id, values) {
      console.log(values)
      dispatch({
        type: 'sorts/updateSort',
        payload: { id, values },
      });
      message.success('修改成功');
    }
    const columns = [
        // {title: "用户ID", dataIndex: "userId", key: "userId"},
        {title: "分类ID", dataIndex: "id", key: "id"},
        {title: "分类名", dataIndex: "catename", key: "catename"},
        {
          title: "修改处理",
          dataIndex: "",
          key: "x",
          render: (record) => (
              <SortEditModal record={record}  onOk={editHandler.bind(null, record.id)}>
              <a href="javascript:;">修改分类</a>
            </SortEditModal>
          )
        },
        {
          title: "删除处理",
          dataIndex: "",
          key: "z",
          render: (record) => (
            <Popconfirm title="确认删除此分类?" onConfirm={deleteSort.bind(null, record)}>
              <a href="">删除分类</a>
            </Popconfirm>
          )
        },
      ]
    ;
    var sortData = this.props.sorts.sortList;
    //console.log(sortData)
    return (
      <Layout style={{width: 1000}}>
        <Table
          bordered={true}
          rowKey={record => record.id}
          columns={columns}
          // expandedRowRender={record => <p style={{margin: 0}}>{record.body}</p>}
          dataSource={sortData}
        />
      </Layout>
    );
  }

}

function mapStateToProps(state) {
  return {sorts: state.sorts};
}

// 建立数据关联关系
export default connect(mapStateToProps)(SortTableNew);
