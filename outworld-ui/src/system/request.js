// 网关模块入口
const BASE_URL = 'http://localhost:8080/api/'

/**
 * 设置统一请求方法模块
 * @param url 路径
 * @param mothods 方法
 * @param data 数据
 */
export function request (url, mothods, data) {
  this.$axios({
    url: BASE_URL + url,
    method: mothods,
    data: data
  }).then(r => {
    // 返回结果
    return r
  })
}
