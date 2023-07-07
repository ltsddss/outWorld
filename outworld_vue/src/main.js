// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueAxios from 'vue-axios'
import VueVideoPlayer from 'vue-video-player'
import 'video.js/dist/video-js.css'
import 'videojs-flash'
import { vueBaberrage } from 'vue-baberrage'
Vue.use(vueBaberrage)
Vue.use(VueVideoPlayer)
Vue.config.productionTip = false
Vue.prototype.$axios=axios;
Vue.use(VueAxios,axios);
/* eslint-disable no-new */

Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
