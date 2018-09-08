import request from '../utils/request';
//const Ip_Set='http://192.168.2.35'
//const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function queryCollect() {
  //return request(`/collectsList`, {
    return request(`${Ip_Set}:8080/knowledgebase/user/list_Collection?id=2`, {
    method: 'get',
    // headers: {
    //   'Content-Type': 'application/json; charset=utf-8'
    // },
  })
}
export async function deleteCollect(id) {
  return request(`${Ip_Set}:8080/knowledgebase/user/delete_Collection?id=${id}`, {
    method: 'delete',
  })
}
export async function addCollect(id,userid,count) {
  return request(`${Ip_Set}:8080/knowledgebase/user/add_Collection?knowledgeid=${id}&userid=${userid}&count=${count}`, {
    method: 'post',
  })
}
