import React from 'react';
import {Link} from 'dva/router';
import { link } from './nav.css';

const NavLeft = ({target, linkText})=>(
  <Link to={target} className={link}>{linkText}</Link>
);

export default NavLeft;
