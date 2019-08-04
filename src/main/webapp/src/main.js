import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import permissions from './plugins/permissions'
import axios from 'axios'
import VueAxios from 'vue-axios'
import 'material-design-icons-iconfont/dist/material-design-icons.css'


Vue.config.productionTip = process.env.NODE_ENV === 'production'
Vue.prototype.$permissions = permissions // 权限方法
Vue.use(VueAxios, axios)

// router permission config
router.beforeEach((to, from, next) => {
  var token = store.state.token;
  if ('/login' == to.path || '/404' == to.path) return next();
  if(null == token)return next('/login');
  if ('/' == to.path) return next('/memberAuthority');
  return next();
})

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
