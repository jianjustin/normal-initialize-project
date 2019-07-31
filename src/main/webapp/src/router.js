import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const Template    = (resolve) => require(['./pages/template.vue'],resolve);
const routes = [
  { name: 'template', path: '/', component: Template }
];

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes
})
