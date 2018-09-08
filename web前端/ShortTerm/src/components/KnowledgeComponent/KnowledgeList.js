import React from 'react';
import {Layout, Avatar, List} from 'antd';

const {Header} = Layout;
const data = [
  {
    title: 'Java 知识点1',
  },
  {
    title: 'Java 知识点1',
  },
  {
    title: 'Java 知识点1',
  },
  {
    title: 'Java 知识点1',
  },
  {
    title: 'Java 知识点1',
  },
  {
    title: 'Android 知识点',
  },
  {
    title: 'Web知识点',
  },
  {
    title: 'javascript知识点',
  },
];
const KnowledgeList = () => (
  <Layout style={{marginLeft: 200, width: 1200}}>
    <Header style={{background: '#e4fbc9', padding: 0, width: 380, textAlign: 'center'}}>我的知识点</Header>
    <List
      itemLayout="horizontal"
      dataSource={data}
      renderItem={item => (
        <List.Item>
          <List.Item.Meta
            avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"/>}
            title={<a href="https://ant.design">{item.title}</a>}
            description="不同知识点，后来需要从数据库动态加载"
          />
        </List.Item>
      )}
    />

  </Layout>
);
export default KnowledgeList;
