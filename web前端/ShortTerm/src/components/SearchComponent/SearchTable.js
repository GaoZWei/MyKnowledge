import React from 'react'
import {Layout, Table} from 'antd';

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
    dataIndex: 'catename',
    key: 'catename',
  }, {
    title: '标签',
    dataIndex: 'tagname',
    key: 'tagname',
  },
  // {
  //   title: '标签',
  //   key: 'tags',
  //   dataIndex: 'tags',
  //   render: tags => (
  //     <span>
  //     {tags.map(tag => <Tag color="blue" key={tag}>{tag}</Tag>)}
  //   </span>
  //   ),
  // },
  // {
  //   title: '操作',
  //   key: 'action',
  //   render: (text, record) => (
  //     <span>
  //     <a href="javascript:;">查看</a>
  //     <Divider type="vertical"/>
  //     <a href="javascript:;">添加</a>
  //     <Divider type="vertical"/>
  //     <a href="javascript:;">删除</a>
  //     <Divider type="vertical"/>
  //     <a href="javascript:;">修改</a>
  //   </span>
  //   ),
  // }
  ];


class SearchTable extends React.Component {
  render() {
    var searchData = this.props.searchs.searchList;
    return (
      <Layout style={{width: 1000}}>
        <Table columns={columns} rowKey={record => record.id} dataSource={searchData}/>
      </Layout>
    );
  }
}

export default SearchTable;

