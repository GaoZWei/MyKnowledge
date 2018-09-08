import React from 'react';
import {connect} from 'dva';
import {Layout} from 'antd';

import NavComponent from '../../components/NavComponent/NavComponent'
import SortTableNew from '../../components/SortComponent/SortTableNew'

class Sort extends React.Component {
  render() {
    //console.log(this.props.sorts)
    return (
      <Layout>
        <NavComponent/>
        <Layout style={{marginLeft: 250}}>
          <h1 style={{marginLeft: 20,marginTop:20}}>我的分类</h1>
          <SortTableNew {...this.props}/>
        </Layout>
      </Layout>
    );
  }

}

function mapStateToProps(state) {
  return {sorts: state.sorts}
}

export default connect(mapStateToProps)(Sort)
