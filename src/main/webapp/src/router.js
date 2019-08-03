import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const Login = (resolve) => require(['./pages/Login.vue'],resolve);
const MemberAuthority    = (resolve) => require(['./pages/member/MemberAuthority.vue'],resolve);
const MemberResource    = (resolve) => require(['./pages/member/MemberResource.vue'],resolve);
const MemberRole    = (resolve) => require(['./pages/member/MemberRole.vue'],resolve);
const MemberUser    = (resolve) => require(['./pages/member/MemberUser.vue'],resolve);

const routes = [
  { name: 'memberAuthority', path: '/memberAuthority', component: MemberAuthority },
  { name: 'memberResource', path: '/memberResource', component: MemberResource },
  { name: 'memberRole', path: '/memberRole', component: MemberRole },
  { name: 'memberUser', path: '/memberUser', component: MemberUser },
  { name: 'login', path: '/login', component: Login }
];

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes
})
