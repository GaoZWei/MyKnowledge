import React from 'react'
import {connect} from 'dva';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import CollectList from '../../components/CollectComponent/CollectList'

class Collect extends React.Component {
  render() {
    return (
      <Layout>
        <NavComponent/>
        <Layout style={{marginLeft: 250}}>
          <h1 style={{marginLeft: 20,marginTop:20}}>我的收藏</h1>
          <CollectList {...this.props}/>
        </Layout>
      </Layout>
    );
  }
}

function mapStateToProps(state) {
  return {collects:state.collects}
}
export default connect(mapStateToProps)(Collect);
