// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import '../theme/index.css'
import NProgress from 'nprogress'
import 'normalize.css/normalize.css'
// import 'assets/iconfont/iconfont'
import IconSvg from 'components/Icon-svg/index.vue'
import Version from './const/Version.vue'
import filters from './filter/index.js'
import directives from './directive/index.js'
import Global from './const/Global.vue'

// 引入svg
function importAll (r) {
    r.keys().forEach(r);
}
importAll(require.context("./assets/svg", true, /\.svg$/));

Vue.config.productionTip = false
Vue.prototype.Version = Version;
Vue.prototype.GLOBAL = Global;
Vue.use(ElementUI);
Vue.component('icon-svg', IconSvg)

const whiteList = ['/login'];
router.beforeEach((to, from, next) => {
    NProgress.start();
    if (store.getters.id) {
        if (to.path === '/login') {
            next();
        } else {
            if (store.getters.roles.length === 0) {
                store.dispatch('GetInfo').then(res => {
                    const roles = res.data.permissions;
                    store.dispatch('GenerateRoutes', { roles }).then(() => {
                        router.addRoutes(store.getters.addRouters);
                        next({ ...to });
                    })
                })
            } else {
                next();
            }
        }
    } else {
        if (whiteList.indexOf(to.path) !== -1) {
            next()
        } else {
            next('/login');
            NProgress.done();
        }
    }
});

router.afterEach(() => {
    NProgress.done();
});

for(let directive in directives){
    Vue.directive(directive,directives[directive]);
}

for(let filter in filters){
    Vue.filter(filter,filters[filter]);
}

new Vue({
    el: '#app',
    router,
    store,
    template: '<App/>',
    components: { App }
})

