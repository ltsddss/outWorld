import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '@/views/login'
import index from '@/views/index'

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
  }
]

const router = new VueRouter({
  routes
})

export default router
