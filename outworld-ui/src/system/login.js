import {request} from "@/system/request";

export function login(data) {
  return request("outworld-auth/auth/login", "get", data)
}
