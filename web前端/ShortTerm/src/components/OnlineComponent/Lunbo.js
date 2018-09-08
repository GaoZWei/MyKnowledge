import React from 'react';
import { Carousel} from 'antd';
import styles from './online.css';
import lunbo1 from '../../assets/lunbo01.png'
const Lunbo = () => {
  //const lunbo2 = { test: { background: `url(${lunbo1}) no-repeat center` }};
  return (<Carousel autoplay className={styles.lunbo}>
    <div><img src={lunbo1} alt={'lunbo'} style={{width:800,height:200}}/></div>
    <div><img src={lunbo1} alt={'lunbo'} style={{width:800,height:200}}/></div>
    <div><img src={lunbo1} alt={'lunbo'}  style={{width:800,height:200}}/></div>
    <div><img src={lunbo1} alt={'lunbo'} style={{width:800,height:200}}/></div>
  </Carousel>)
};

export default Lunbo;
