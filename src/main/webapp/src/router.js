import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const TemplateTablePage    = (resolve) => require(['./pages/TemplateTablePage.vue'],resolve);

const routes = [
  { name: 'templateTablePage', path: '/templateTablePage', component: TemplateTablePage }
];

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes
})
