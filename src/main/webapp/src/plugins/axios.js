import Vue from 'vue';
import axios from 'axios';

axios.defaults.headers.post["Content-type"] = "application/json"
Vue.prototype.$axios = axios;

export default axios;
