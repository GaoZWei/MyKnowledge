import React from 'react';
import {Layout, Avatar, List} from 'antd';
const {Header}=Layout;

// let list_item = [];

// const queryItem = (e,item) =>{
// list_item = item;
// alert("123");
// console.log("111111111111111111111111",item);
// console.log("2222222",list_item);
// }

const SortList=({dataSource},dispatch)=> {

let list_item = [];
// const queryItem = (e,item) => {
// list_item = item;
// dispatch({
// type: `sorts/queryByid`,
// payload: {list_item}//需要传递的数据
// })},


const queryItem = (e,item) =>{
list_item = item;
alert("123");
console.log("111111111111111111111111",item);
console.log("2222222",list_item);
}

// const col = [{
// title: '',
// key: 'id',
// dataIndex: 'id',
// width: 80,
// render: (text, row, index) => {
// }
// },{
// title: '',
// key: 'title',
// dataIndex: 'title',
// width: 80,
// render: (text, row, index) => {
// }
//}]
return (
<Layout style={{marginLeft: 200, width: 1200}}>
<Header style={{background: '#aaa', padding: 0, width: 380, textAlign: 'center'}}>所有分类</Header>
<List
itemLayout="horizontal"
dataSource={dataSource}
renderItem={item => (
<List.Item>
<List.Item.Meta
avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"/>}
title={item.title}
description={`id为+${item.id}`}
onClick={(e) => { queryItem(e, item)}}
/>
</List.Item>
)}
/>
{/* <Sider style={{background:'yellow'}} width={450} collapsible={true} collapsible={true} defaultCollapsed={true} reverseArrow={true} collapsedWidth={13}>lclassNamebar</Sider>
<Table columns={col} dataSource={list_item} pagination={false} showHeader={false}/>>
<Sider>right sidebar</Sider> */}
</Layout>
);
};
export default SortList;

