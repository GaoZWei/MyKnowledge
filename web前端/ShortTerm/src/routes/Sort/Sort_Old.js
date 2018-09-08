import React from 'react';
import {connect} from 'dva';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
//import SortList from '../../components/SortComponent/SortList'
import SortTable from '../../components/SortComponent/SortTable'

function Sort ({sorts}){
  const {list}=sorts;
  const SortListProps = {
    dataSource: list,
  };
  return (
    <Layout>
      <NavComponent/>
      <Layout>
        {/* <SortList {...SortListProps}/> */}
        <SortTable {...SortListProps}/>/>
      </Layout>
    </Layout>
  )
    ;
}
// Sort.propTypes = {
//   sorts: PropTypes.Object,
// };

function mapStateToProps({ sorts }) {
  return {sorts};
}

// 建立数据关联关系
export default connect(mapStateToProps)(Sort);
