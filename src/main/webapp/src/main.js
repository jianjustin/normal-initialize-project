import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import 'material-design-icons-iconfont/dist/material-design-icons.css'


Vue.config.productionTip = false

Vue.use(vuetify);

// router permission config
router.beforeEach((to, from, next) => {
  var memberUser = store.state.memberUser;
  if (null == memberUser || '/404' == to.path) 
  	return next();
  var result = false;
  for (var i = 0; i < memberUser.permissions.length; i++) {
  	if(memberUser.permissions[i] == to.path)
  		result = true;
  }
  if (!result)
  	return next('/404');



  if('/' == to.path)
  	return next('/memberAuthority'); 
  return next();
})

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
