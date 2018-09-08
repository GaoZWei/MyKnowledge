import request from '../utils/request';
import convert from "../utils/convert";
//import qs from 'qs';
const Test_API = 'https://jsonplaceholder.typicode.com';
//const Ip_Set='http://192.168.2.35'
//const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function query() {
  // console.log( request(`/api/users`));不好使
  return request(`${Ip_Set}:8080/knowledgebase/user/user_cate_list?id=2`, {
    method: 'get',
    headers: {
      'Content-Type': 'application/json; charset=utf-8'
    },
  })
}
export async function deleteById(id){
  return request(`${Ip_Set}:8080/knowledgebase/user/user_cate_del?id=${id}`,{
    method: 'get',
    headers: {
      "Content-type": "application/json; charset=UTF-8"
    }
  })
}
export async function UpdateById(values){
  console.log(convert(values))
  return request(`${Ip_Set}:8080/knowledgebase/user/user_cate_edit`,{
    method: 'post',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
    },
    body:convert(values)
  })
}
