import {request} from "../utils/request";

export function login(data){
  return request({
    url: '/outworld_auth/auth/login',
    method: 'post',
    data: data
  })
}
