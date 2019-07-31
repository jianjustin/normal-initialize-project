import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

//import CommonList from '../components/common/CommonList.vue'
const CommonList    = (resolve) => require(['./pages/template.vue'],resolve);
const routes = [
  { name: 'template', path: '/', component: CommonList }
];

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes
})
