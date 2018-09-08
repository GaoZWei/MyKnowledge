import React from 'react'
import {Breadcrumb,Layout} from 'antd'
const {Header}=Layout;
const ContentBreadcrumb=()=>(

  <Header style={{background: '#fff', padding: 0}}>
    <Breadcrumb separator="/" style={{marginTop: 20}}>
      <Breadcrumb.Item>主页</Breadcrumb.Item>
      <Breadcrumb.Item href="">知识点</Breadcrumb.Item>
      <Breadcrumb.Item href="">Java</Breadcrumb.Item>
      {/*<Breadcrumb.Item>An Application</Breadcrumb.Item>*/}
    </Breadcrumb></Header>
);
export default ContentBreadcrumb;
