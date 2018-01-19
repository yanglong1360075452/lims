import Vue from 'vue';
import Router from 'vue-router';
import Index from '../views/index/index.vue';
import Login from '../views/login/login.vue';
import Users from '../views/app_user/users.vue';
import User from '../views/app_user/user.vue';
import Util from '../assets/lib/util';
import Permission from '../views/app_user/permission.vue';
import Roles from '../views/app_user/roles.vue';
import  Empty from '../views/app_user/empty.vue';
import ProjectDetail from'../views/project_manager/projectDetail.vue';
import Projects from'../views/project_manager/projects.vue';
import Project from'../views/project_manager';
import Sample from'../views/project_manager/sample.vue';
import Log from '../views/app_user/log.vue';


Vue.use(Router);

let router = new Router({
  routes: [
    /**首页*/
    {
      path: '/',
      name: 'index',
      component: Index,
      children: [
        /**用户列表页*/
        {
          path: 'empty',
          name: 'empty',
          component: Empty
        },
        /**用户列表页*/
        {
          path: 'users',
          name: 'users',
          component: Users
        },
        /** 用户详情页*/
        {
          path: 'users/:id',
          name: 'user',
          component: User
        },
        {
          path: 'permission',
          name: 'permission',
          component: Permission
        },
        {
          path: 'log',
          name: 'log',
          component: Log
        },
        {
          path: 'roles',
          name: 'roles',
          component: Roles
        },
        /**项目管理*/
        {
          path: 'project',
          name: 'project',
          component: Project,
          children: [
            /**项目详情页*/
            {
              path: 'detail',
              name: 'detail',
              component: ProjectDetail
            },

        /**项目列表页*/
        {
          path: '/projects',
          name: 'projects',
          component: Projects
        },
        /**原始样本*/
        {
          path: '/sample',
          name: 'sample',
          component: Sample
        },
          ]},
      ]
    },
    /**登录页*/
    {
      path: '/login',
      name: 'login',
      component: Login
    }


  ]
});

/**
 * 判断用户是否有登录，没有登录则跳转到登录页面
 * 如果用户已经登录，则回跳到登录的页的时候，要转到首页
 * */
router.beforeEach((to, from, next) => {
  var user = Util.dataToSessionStorageOperate.achieve('user');
  if (!user && to.path != '/login')
    next('/login');
    else {
    next();
  }
});
export default router
