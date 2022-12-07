import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/index'
import test from "../views/test";
import login_new from "../views/login_new";
import login from "../views/login";
import mine from "../views/mine";

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
    path: '/mine',
    name: 'name',
    component: mine
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
