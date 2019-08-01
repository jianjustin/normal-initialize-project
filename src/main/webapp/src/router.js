import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const Template    = (resolve) => require(['./pages/template.vue'],resolve);
const BottomNavigation    = (resolve) => require(['./components/BottomNavigation.vue'],resolve);
const TemplateTablePage    = (resolve) => require(['./pages/TemplateTablePage.vue'],resolve);

const routes = [
  { name: 'template', path: '/', component: Template },
  { name: 'bottomNavigation', path: '/bottomNavigation', component: BottomNavigation },
  { name: 'templateTablePage', path: '/templateTablePage', component: TemplateTablePage }
];

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes
})
