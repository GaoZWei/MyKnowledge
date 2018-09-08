import React from 'react';
import {Layout} from 'antd';
import NavComponent from '../../components/NavComponent/NavComponent'
import Lunbo from '../../components/OnlineComponent/Lunbo';
//import Hot from '../../components/HotComponent/HotKnowledge';
import OnlineKnowledge from '../../components/OnlineComponent/OnlineKnowledge'
class Online extends React.Component {

  render(){
    return(
      <Layout>
        <NavComponent/>
        <Layout style={{border:20,height:600}}>
          <Lunbo/>
          <Layout style={{marginLeft:200}}>
            <OnlineKnowledge/>
           {/*<Hot/>*/}
          </Layout>
        </Layout>


      </Layout>
    );
  }
}

export default Online;
