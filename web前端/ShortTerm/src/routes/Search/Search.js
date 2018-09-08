import React from 'react';
import {connect} from 'dva';
import {Layout} from 'antd';
import {Input} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import SearchTable from '../../components/SearchComponent/SearchTable'
class Search extends React.Component {
  render() {
    const Search = Input.Search;
    const doSearch = (value) => {
      console.log(value)
      const {dispatch} = this.props;
      dispatch({
        type: 'searchs/queryShare',
        payload:value
      });
    }
    return (
      <Layout>
        <NavComponent/>
        <Layout>
          <Layout style={{marginLeft: 250, width: 1000}}>
            <Layout style={{marginLeft: 250,marginTop: 40, marginBottom: 40, width: 450}}>
              <Search
                placeholder="搜索知识点标题"
                onSearch={(value) => doSearch(value)}
                enterButton
                size='large'
              />
            </Layout>
              <SearchTable {...this.props}/>
          </Layout>
        </Layout>

      </Layout>
    );
  }
}

function mapStateToProps(state) {
  return {searchs:state.searchs}
}
export default connect(mapStateToProps)(Search);
