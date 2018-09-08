import React from 'react';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import AddKnowledgeComponent from '../../components/KnowledgeComponent/AddKnowledgeComponent'
class AddKnowledge extends React.Component {

  render(){
    return(
      <Layout>
        <NavComponent/>

        <Layout style={{marginLeft:220,marginRight:350,width:700}}>
          <AddKnowledgeComponent/>
        </Layout>
      </Layout>
    );
  }
}

export default AddKnowledge;
