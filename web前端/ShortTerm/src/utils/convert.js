export default  function convert(obj){
  var datas=[];
  for(var key in obj){
    datas.push(key+'='+obj[key]);
  }
  return datas.join("&")
}
