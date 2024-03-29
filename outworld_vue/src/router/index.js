import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/index'
import testIndex from '../views/test/index'
import test from "../views/test";
import login from "../views/login";
import mine from "../views/mine";
import home from "../views/home";
import SelectResult from "../views/SelectResult";
import Classify from "../views/Classify";
import liveBorast from "../views/liveBorast";
import liveBorast1 from "../views/liveBorast1";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/select',
    name: 'select',
    component: SelectResult
  },
  {
    path: '/classify',
    name: 'classify',
    component: Classify
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/home',
    name: 'home',
    component: home
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
    component: testIndex
  },
  {
    path: '/liveBoast',
    name: 'name',
    component: liveBorast
  },{
    path: '/liveBoast1',
    name: 'name',
    component: liveBorast1
  },
]

const router = new VueRouter({
  routes
})

export default router
