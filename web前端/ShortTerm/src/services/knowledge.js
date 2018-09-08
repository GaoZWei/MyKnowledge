import request from '../utils/request';
import convert from '../utils/convert'
//const Ip_Set='http://192.168.2.35'
//const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function queryKnowledge() {
  return request(`${Ip_Set}:8080/knowledgebase/user/user_knowledge_list?id=2`, {
    method: 'get',
  })
}
export async function deleteKnowledge(id) {
  return request(`${Ip_Set}:8080/knowledgebase/user/user_knowledge_del?id=${id}`, {
    method: 'delete',
  })
}
export async function modifyKnowledge(values) {
  // console.log(values)
  console.log(convert(values))
  return request(`${Ip_Set}:8080/knowledgebase/user/user_knowledge_editSubmit`, {
    method: 'post',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
    },
    body:convert(values)
  })
}
export async function addKnowledge(values) {
  //console.log(convert(values))
  return request(`${Ip_Set}:8080/knowledgebase/user/user_knowledge_addSubmit`, {
    method: 'post',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
    },
    body:convert(values)
  })
}
export async function shareKnowledge(id) {
  return request(`${Ip_Set}:8080/knowledgebase/user/knowledge_onshare?id=${id}`, {
    method: 'get',
  })
}


