import request from '../utils/request';
//const Ip_Set='http://192.168.2.35'
// const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function querySearch(title) {
  console.log(title)
  return request(`${Ip_Set}:8080/knowledgebase/views/select_knowledge_list?title=${title}`, {
    method: 'get',
    headers: {
      'Content-Type': 'application/json; charset=utf-8'
    },
  })
}
