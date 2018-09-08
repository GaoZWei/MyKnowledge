import React from 'react';
import {Layout,Breadcrumb,Button,Input} from 'antd';
const {Content} =Layout;
const {TextArea}=Input;
const KnowledgeContent=()=>(
  <Content style={{ margin: '0 16px' }}>
    <Breadcrumb style={{ margin: '16px 0' }}>
      <Breadcrumb.Item>知识点</Breadcrumb.Item>
      <Breadcrumb.Item>知识点1</Breadcrumb.Item>
    </Breadcrumb>
    <div style={{ padding: 24, background: '#fff', minHeight: 500 }}>
      Bill is a cat.<br/>
      Bill is a cat.   Bill is a cat.  Bill is a cat.<br/>
      Bill is a cat.<br/>
      <TextArea placeholder={'Bill is a cat.\n' +
      '      Bill is a cat.   Bill is a cat.  Bill is a cat.\n' +
      '      Bill is a cat.'} rows={16}>

      </TextArea>
      <div style={{textAlign:'center'}}>
        <Button type="dashed">保存</Button>
        <Button type="dashed">保存并分享</Button>
        <Button type="danger">删除知识点</Button>
      </div>
    </div>

  </Content>
);
export default KnowledgeContent;
