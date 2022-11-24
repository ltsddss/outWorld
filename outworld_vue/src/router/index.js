import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../views/login'
import index from '../views/index'
import test from "../views/test";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
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
