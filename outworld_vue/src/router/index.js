import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/index'
import test from "../views/test";
import login_new from "../views/login_new";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login_new
  },
  {
    path: '/index',
    name: 'index',
    component: index
  },
  {
    path: '/test',
    name: 'name',
    component: test
  }
]

const router = new VueRouter({
  routes
})

export default router
