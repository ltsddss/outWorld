
// 空格验证，去除掉字符串的空格
export function validUsername(str){
  return str.trim();
}
//  生成随机6位数
export function createSixString(str){
  let chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
  /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
  let maxPos = chars.length;
  var code = '';
  for (let i = 0; i < 6; i++) {
    code += chars.charAt(Math.floor(Math.random() * maxPos));
  }
  return code
}
