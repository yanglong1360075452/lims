import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store/index.js';
import axios from './config/axios';
import ElementUI from 'element-ui';
import 'element-ui/lib/element-#3c6ab6/index.css';
import VueQuillEditor from 'vue-quill-editor';
import Global from './const/Global.vue'
import Version from './const/Version.vue'

Vue.use(VueQuillEditor);
Vue.prototype.GLOBAL = Global;
Vue.prototype.Version = Version;
Vue.config.productionTip = false;
Vue.prototype.axios = axios;
Vue.use(ElementUI);

Vue.filter('date',function (val){
  if(val != null && val != undefined){
    var date = new Date(val);
    var Y = date.getFullYear(),
      m = date.getMonth() + 1,
      d = date.getDate(),
      H = date.getHours(),
      i = date.getMinutes(),
      s = date.getSeconds();
    if (m < 10) {
      m = '0' + m;
    }
    if (d < 10) {
      d = '0' + d;
    }
    if (H < 10) {
      H = '0' + H;
    }
    if (i < 10) {
      i = '0' + i;
    }
    if (s < 10) {
      s = '0' + s;
    }
    var t = Y + '-' + m + '-' + d + '  ' + H + ':'+i+':'+s;
    return t;
  }
});

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: {App}
});
