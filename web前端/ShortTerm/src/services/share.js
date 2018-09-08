import request from '../utils/request';
//const Ip_Set='http://192.168.2.35'
//const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function queryShare() {
  return request(`${Ip_Set}:8080/knowledgebase/user/list_Share?id=2`, {
    method: 'get',
    headers: {
      'Content-Type': 'application/json; charset=utf-8'
    },
  })
}
export async function deleteShare(id) {
  return request(`${Ip_Set}:8080/knowledgebase/user/knowledge_isshare?id=${id}`, {
    method: 'delete',
  })
}
