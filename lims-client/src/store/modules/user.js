import {login, logout} from '@/api/login';
import {getInfo} from '@/api/user';
import Cookies from 'js-cookie';

const user = {
    state: {
        id: Cookies.get('User-ID'),
        name: '',
        roles: []
    },

    mutations: {
        SET_ID: (state, id) => {
            state.id = id;
        },
        SET_NAME: (state, name) => {
            state.name = name;
        },
        SET_ROLES: (state, roles) => {
            state.roles = roles;
        }
    },

    actions: {
        // 登录
        Login({commit}, userInfo) {
            return new Promise((resolve, reject) => {
                login(userInfo).then(response => {
                    const data = response.data;
                    Cookies.set('User-ID', data.id);
                    commit('SET_ID', data.id);
                    resolve(response);
                }).catch(error => {
                    reject(error);
                });
            });
        },

        // 获取用户信息
        GetInfo({commit, state}) {
            return new Promise((resolve, reject) => {
                getInfo(state.id).then(response => {
                    const data = response.data;
                    commit('SET_ID', data.id);
                    commit('SET_ROLES', data.permissions);
                    commit('SET_NAME', data.nickname);
                    resolve(response);
                }).catch(error => {
                    reject(error);
                });
            });
        },

        // 登出
        LogOut({commit}) {
            return new Promise((resolve, reject) => {
                logout().then(() => {
                    commit('SET_ROLES', []);
                    Cookies.remove('User-ID');
                    resolve();
                }).catch(error => {
                    reject(error);
                });
            });
        }
    }
};

export default user;
