import React from 'react';
import {connect} from 'dva';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import HotPage from '../../components/HotComponent/HotKnowledge'


class Hot extends React.Component {

  render() {
    //console.log(this.props.hots)
    return (
      <Layout>
        <NavComponent/>
        <Layout style={{marginLeft:230,marginRight:20,width:700}}>
          <h1> 热门知识点</h1>
          <HotPage {...this.props}/>
        </Layout>
      </Layout>
    );
  }
}
function mapStateToProps(state) {
  return{hots:state.hots}
}
export default connect(mapStateToProps)(Hot);
