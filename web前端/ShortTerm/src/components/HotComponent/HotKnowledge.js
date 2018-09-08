import React from 'react'
import {Card, List,Button} from 'antd'
import AddKnowledge from "../../routes/Knowledge/AddKnowlege";

const gridStyle = {
  width: '100%',
  textAlign: 'center',
};

class HotKnowledge extends React.Component {

  render() {
    const {dispatch}=this.props;
    const addCollect = (record) => {
      console.log(record)
      record.disabled=true;
      record.showMessage='已收藏';
      dispatch({
        type:'hots/addCollect',
        payload:record,
      })
    }
    var HotItems=this.props.hots.hotItem.data;
    //console.log(HotItems)
    return (
      <List
        grid={{gutter: 20, xs: 1, sm: 2, md: 4, lg: 3, xl: 2, xxl: 3}}
      dataSource={HotItems}
      renderItem={item => (
        <List.Item>
          <Card title={item.title} style={gridStyle}>{item.knowledgecontent}<br/><br/>
            <span style={{color:'red',float:'left'}}>收藏数: {item.count}</span>
            <Button type="primary" htmlType="submit" disabled={item.disabled} style={{float:'right'}} onClick={() => addCollect(item)}>{item.showMessage||'点击收藏'}</Button>
          </Card>
        </List.Item>
      )}
    />);
  }

}

export default HotKnowledge;
