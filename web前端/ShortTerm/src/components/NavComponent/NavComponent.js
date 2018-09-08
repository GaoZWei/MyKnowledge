import React from 'react';
import {Layout, Menu, Icon, Avatar} from 'antd';
import NavLeft from './NavLeft'
import logo from '../../assets/logo.png'

const {Sider} = Layout;

export default class NavComponent extends React.Component {
//     state={
//       navkey:'',
//     }
//     onSelect=(e)=>{
// this.setState({
//   navkey:this.target.key
// })
// console.log(navkey)
//     }
  render() {
    //var keys = '2';
    // const pathName = hashHistory.getCurrentLocation().pathname;
    return (
      <Sider style={{overflow: 'auto', height: '100vh', position: 'fixed', left: 0}}>
        <img src={logo} alt={'logo'} style={{width: 50, height: 50, marginLeft: 62, marginTop: 20, marginBottom: 20}}/>
        <div className="logo"/>
        <Menu theme="dark" mode="inline" selectedKeys={window.location.href}
              defaultSelectedKeys={'http://localhost:8000/#/sort'}>
          <Menu.Item key="http://localhost:8000/#/sort">
            <NavLeft target="/sort" linkText={<span><Icon type="user"/>
            <span className="nav-text">知识点分类</span></span>}/>
          </Menu.Item>
          <Menu.Item key="http://localhost:8000/#/knowledge">
            <NavLeft target="/knowledge" linkText={<span>
          <Icon type="video-camera"/>
          <span className="nav-text">知识点</span>
            </span>}/>
          </Menu.Item>
          <Menu.Item key="http://localhost:8000/#/addknowledge">
            <NavLeft target="/addknowledge" linkText={<span>
          <Icon type="upload"/>
          <span className="nav-text">添加</span></span>}/>
          </Menu.Item>
          <Menu.Item key="http://localhost:8000/#/search">
            <NavLeft target="/search" linkText={
              <span>
              <Icon type="bar-chart"/>
              <span className="nav-text">搜索</span></span>}/>
          </Menu.Item>
          <Menu.Item key="http://localhost:8000/#/share">
            <NavLeft target="/share" linkText={<span>
          <Icon type="cloud-o"/>
          <span className="nav-text">我的分享</span></span>}/>
          </Menu.Item>

          <Menu.Item key="http://localhost:8000/#/online">
            <NavLeft target="/online" linkText={<span>
          <Icon type="appstore-o"/>
          <span className="nav-text">在线知识库</span></span>}/>
          </Menu.Item>
          <Menu.Item key="http://localhost:8000/#/hot">
            <NavLeft target="/hot" linkText={<span>
          <Icon type="team"/>
          <span className="nav-text">热门知识点</span></span>}/>
          </Menu.Item>
          <Menu.Item key="http://localhost:8000/#/collect">
            <NavLeft target="/collect" linkText={<span>
          <Icon type="shop"/>
          <span className="nav-text">我的收藏</span></span>}/>
          </Menu.Item>
        </Menu>
        <Avatar
          style={{color: '#f56a00', backgroundColor: '#fde3cf', marginLeft: 68, marginTop: 30}}>高</Avatar>
      </Sider>
    );
  }
}
