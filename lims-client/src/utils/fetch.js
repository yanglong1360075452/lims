import axios from 'axios';
import { Message } from 'element-ui';
import store from '../store';
import router from '../router/index'


// axios.defaults.timeout = 10000;
axios.defaults.withCredentials = true;

axios.defaults.baseURL = process.env.BASE_API;


// http request 拦截器
axios.interceptors.request.use(
    config => {
        if (config.url.indexOf("data") == -1) {
            store.commit('startLoading');
        }
        config.headers["Accept"] = "application/json";
        if (!config.url.endsWith('/login')) {
            config.headers["Content-Type"] = 'application/json';
        }
        return config;
    },
    err => {
        return Promise.reject(err);
    });

// http response 拦截器
axios.interceptors.response.use(response => {
        store.commit('stopLoading');
        return response.data;
    },
    error => {
        store.commit('stopLoading');
        if (error.response == undefined) {
            router.push({name:'login'});
        } else if (error.response) {
            if (error.response.status == 401) {
                router.push({name:'login'});
            }
        }
        return Promise.reject(error)
    });
export default axios;
