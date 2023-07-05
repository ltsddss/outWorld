import axios from "axios";

export function request(config) {
  const instance = axios.create({
    // 设置请求头
    baseURL: 'https://localhost:8080/api',
    // 设置请求时间
    timeout: 5000
  })

  // 请求拦截
  instance.interceptors.request.use(config => {
    // 如果有一些接口需要认证才可以访问，就在这统一设置
    // 例如登录的token

    //怎么依靠token做请求拦截？可移步
    // https://blog.csdn.net/weixin_61285710/article/details/122626785?spm=1001.2014.3001.5502

      // 直接放行
      return config;
  },error => {
    console.log(error)
  })

  // 响应拦截
  instance.interceptors.response.use(res => {
    return res;
  },error => {
    // 如果有需要授权才可以访问的接口，统一去login授权

    // 如果有错误，这里面去设置处理，显示错误信息

  })
  return instance(config);
}
