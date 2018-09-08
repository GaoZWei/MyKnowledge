import request from '../utils/request';
//const Ip_Set='http://192.168.2.35'
//const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function queryHot() {
  return request(`${Ip_Set}:8080/knowledgebase/views/knowledge_list_hot`,{
    method:'get',
    headers:{
      'Content-Type': 'application/json; charset=utf-8'
    }
  })
}

