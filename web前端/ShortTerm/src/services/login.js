import request from '../utils/request';
//const Ip_Set='http://192.168.2.35'
//const Ip_Set='http://192.168.43.95'
const Ip_Set='http://localhost'
export async function doLogin(params) {
   console.log(params)
   var a=JSON.stringify(params);
   console.log(a)
  return request( `${Ip_Set}:8080/knowledgebase/userLogin?account=${params.account}&password=${params.password}`,{
    method: 'POST',
    body: JSON.stringify(params)
  });
}

// export async function doLogout() {
//   return request( `/logout`,{
//     method: 'POST'
//   });
// }
