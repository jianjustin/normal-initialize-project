import Vue from 'vue';
import axios from 'axios';

/**
 * axios - Promise based HTTP client for the browser and node.js
 *
 * [docs] - http://www.axios-js.com/docs/
 *
 * axios.request(config)
 * axios.get(url[, config])
 * axios.delete(url[, config])
 * axios.head(url[, config])
 * axios.options(url[, config])
 * axios.post(url[, data[, config]])
 * axios.put(url[, data[, config]])
 * axios.patch(url[, data[, config]])
 *
 */

axios.defaults.headers = {
	"accept":"application/json;charset=UTF-8",
	"Content-Type":"application/json"
};
Vue.prototype.$axios = axios;

export default axios;
