import React from 'react';
import {connect} from 'dva';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import SortList from '../../components/SortComponent/SortList';
import ContentBreadcrumb from '../../components/ContentComponent/ContentBreadcrumb'
import ContentMain from '../../components/ContentComponent/ContentMain'

class HomePage extends React.Component {
  render() {
    return (
      <Layout>
        <NavComponent/>
        <SortList/>
        <Layout>
          <ContentBreadcrumb/>
          <ContentMain/>
        </Layout>
        <div style={{margin: '24px 16px', padding: 24, background: '#fff', minHeight: 580}}>
          {this.props.children}
        </div>

      </Layout>
    );
  }
}

export default connect()(HomePage);
