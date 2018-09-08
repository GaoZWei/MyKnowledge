import React from 'react';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import KnowledgeTable from  '../../components/KnowledgeComponent/KnowledgeTable'
//import KnowledgeModal from '../../components/KnowledgeComponent/KnowledgeModal'
import {connect} from "dva/index";
class Knowledge extends React.Component {

  render(){
    return(
      <Layout>
        <NavComponent/>
        <Layout style={{marginLeft: 250}}>
          <h1 style={{marginLeft: 20,marginTop:20}}>我的知识点</h1>
          {/*<KnowledgeModal {...this.props}/>*/}
          <KnowledgeTable {...this.props}/>
        </Layout>
      </Layout>
    );
  }
}

function mapStateToProps(state) {
  return {knowledges:state.knowledges}
}
export default connect(mapStateToProps)(Knowledge);
