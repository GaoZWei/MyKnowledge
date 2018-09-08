import React from 'react';
import {Input} from 'antd';

const Search = Input.Search;
const SearchInput = () => (
  <Search
    placeholder="input search text"
    onSearch={value => console.log(value)}
    enterButton
  />
);
export default SearchInput;
