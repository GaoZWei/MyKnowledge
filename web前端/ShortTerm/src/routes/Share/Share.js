import React from 'react'
import {connect} from 'dva';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import ShareList from '../../components/ShareComponent/ShareList'

// function Share ({shares}) {
//   const {list}=shares;
//   console.log(shares)
//   const ShareListProps= {
//     dataSource: list,
//   };
//     return (
//       <Layout>
//         <NavComponent/>
//         <ShareList {...ShareListProps}/>
//       </Layout>
//     );
//   }
class Share extends React.Component {
  render() {
    console.log(this.props.shares)
    return (
      <Layout>
        <NavComponent/>
        <Layout style={{marginLeft: 250}}>
          <h1 style={{marginLeft: 20, marginTop: 20}}>我的分享</h1>
          <ShareList {...this.props}/>
        </Layout>
      </Layout>
    );
  }
}

function mapStateToProps(state) {
  return {shares:state.shares};
}

// 建立数据关联关系
export default connect(mapStateToProps)(Share);
