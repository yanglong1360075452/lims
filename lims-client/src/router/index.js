import Vue from 'vue';
import Router from 'vue-router';
const _import = require('./_import_' + process.env.NODE_ENV);
import Global from '../const/Global.vue'
// in development env not use Lazy Loading,because Lazy Loading large page will cause webpack hot update too slow.so only in production use Lazy Loading

/* layout */
import Layout from '../views/layout/Layout';

/**login */
const Login = _import('login/index');

/**dashboard */
const dashboard = _import('dashboard/index');

/**error page */
const Err404 = _import('404');

/**project module*/
const ProjectDetail = _import('page/project/tabBar');
const ProjectList = _import('page/project/list');

/**sample module*/
const SampleLotList = _import('page/sample/sampleLotList');
const SampleList = _import('page/sample/sampleListTabBar');

/**task module*/
const TaskList = _import('page/task/list');

/**system module*/
const User = _import('page/system/user/index');
const Users = _import('page/system/user/users');
const Permissions = _import('page/system/user/permissions');
const Roles = _import('page/system/user/roles');
const Log = _import('page/system/log');

/**workflow module*/
const WorkflowList = _import('page/workflow/workflowList');
const WorkflowDetail = _import('page/workflow/workflowDetail');
const ActivList = _import('page/workflow/activList');
const ActivDetail = _import('page/workflow/activDetail');

/**execution module*/
const Execution = _import('page/execution/index');

const Sample1 = _import('page/sample1');
const detection = _import('page/detection');

const UnderContraction = _import('page/underContraction');
Vue.use(Router);
/**
 * icon : the icon show in the sidebar
 * hidden : if `hidden:true` will not show in the sidebar
 * redirect : if `redirect:noredirect` will not redirct in the levelbar
 * noDropdown : if `noDropdown:true` will not has submenu in the sidebar
 * meta : `{ role: ['admin'] }`  will control the page role
 **/
export const constantRouterMap = [
    {path: '/login',name:'login', component: Login, hidden: true},
    {path: '/404', component: Err404, hidden: true},
    {
        path: '/',
        component: Layout,
        redirect: '/dashboard',
        name: 'Home',
        hidden: true,
        children: [{path: 'dashboard', component: dashboard}]
    }
]

export default new Router({
    // mode: 'history', //后端支持可开
    scrollBehavior: () => ({y: 0}),
    routes: constantRouterMap
});

export const asyncRouterMap = [
    {
        path: '/project',
        component: Layout,
        redirect: 'noredirect',
        name: 'project',
        desc:'项目管理',
        icon: 'item-nor',
        iconBg: 'bg-blue',
        children: [
            {path: 'detail',component: ProjectDetail, name: 'projectDetail', icon: 'test',desc:'新建项目'},
            {path: 'list/'+Global.ProjectStatusEnum.NEW_PROJECT,component: ProjectList,name:'newProject', desc: '新项目', icon: 'zonghe',hidden:true},
            {path: 'list/'+Global.ProjectStatusEnum.NEW_PROJECT+','+Global.ProjectStatusEnum.SAMPLE_DELIVERY,
                component: ProjectList,name:'notDeliveryProject', desc: '未交付项目', icon: 'zonghe'},
            {path: 'list/'+Global.ProjectStatusEnum.DELIVERED+','+Global.ProjectStatusEnum.SCHEDULED+','+Global.ProjectStatusEnum.IN_THE_PRODUCTION,
                component: ProjectList, name: 'goingProject', desc:'进行中项目', icon: 'zonghe'},
            {path: 'list/'+Global.ProjectStatusEnum.COMPLETE, component: ProjectList, name: 'completeProject',desc:'已完成项目', icon: 'zonghe'},
            {path: 'list/delivery/'+Global.ProjectStatusEnum.SAMPLE_DELIVERY, component: ProjectList, name: 'deliveryProduct',desc:'交付生产', icon: 'test'}
        ]
    },
    {
        path: '/sample',
        component: Layout,
        redirect: 'noredirect',
        name:'sample',
        desc: '样本管理',
        icon: 'example',
        iconBg: 'bg-yellow',
        children: [
            {path: 'receive/list', component: SampleLotList, name:'sampleReceive',desc: '样本接收', icon: 'zonghe'},
            {path: 'all/list', component: SampleLotList,name:'sampleLotQuery', desc: '样本批次查询', icon: 'zonghe'},
            {path: 'list', component: SampleList,name:'sampleQuery', desc: '全局样本查询', icon: 'zonghe'},
        ]
    },
    {
        path: '/task',
        component: Layout,
        redirect: 'noredirect',
        name:'task',
        desc: '任务管理',
        icon: 'taskman',
        iconBg: 'bg-red',
        children: [
            {path: 'list/dispatch/'+Global.ProjectStatusEnum.DELIVERED, component: ProjectList, name:'taskDispatch',desc: '任务调度', icon: 'zonghe'},
            {path: 'list/'+Global.TaskStatusEnum.ALLOTTED, component: TaskList,name:'hadAllotTask', desc: '已调度任务', icon: 'zonghe'},
            {path: 'list/'+Global.TaskStatusEnum.UNDERWAY, component: TaskList,name:'goingTask', desc: '进行中任务', icon: 'zonghe'},
            {path: 'list/'+Global.TaskStatusEnum.COMPLETE, component: TaskList,name:'completeTask', desc: '已完成任务', icon: 'zonghe'},
            {path: 'nav', component: UnderContraction,name:'TaskList', desc: '人员工时', icon: 'zonghe'},
        ]
    },
    {
        path: '/execution',
        component: Layout,
        redirect: 'noredirect',
        name:'execution',
        desc: '任务执行',
        icon: 'taskman',
        iconBg: 'bg-red',
        children: [
            {path: 'list/my', component: TaskList,name:'myTask', desc: '我的任务', icon: 'zonghe'},
            {path: 'execute/:id', component: Execution,name:'execute', desc: '操作', icon: 'zonghe',hidden:true},
        ]
    },
    {
        path: '/workflow',
        component: Layout,
        redirect: 'noredirect',
        name:'workflow',
        desc: '工作流管理',
        icon: 'taskman',
        iconBg: 'bg-red',
        children: [
            {path: 'list', component: WorkflowList, name:'workflowList',desc: '工作流-列表', icon: 'zonghe'},
            {path: 'detail/:id', component: WorkflowDetail,name:'workflowDetail', desc: '工作流-配置详情', icon: 'zonghe',hidden:true},
            {path: 'activ/list', component: ActivList,name:'activList', desc: '工作流活动-列表', icon: 'zonghe'},
            {path: 'activ/detail/:id', component: ActivDetail,name:'activDetail', desc: '工作流活动-详情', icon: 'zonghe',hidden:true},
        ]
    },
    {
        path: '/system',
        component: Layout,
        redirect: 'noredirect',
        desc: '系统管理',
        name: 'system',
        icon: 'gaishu',
        iconBg: 'bg-green',
        children: [
            {path: 'log', component: Log,name:'log', desc: '操作日志', icon: 'zonghe'},
            {path:'userManagement',component: User, name:'userManagement',desc: '用户角色', icon: 'zonghe',
                children:[
                    {path: 'users', component: Users,name:'users', desc: '用户列表', icon: 'zonghe'},
                    {path: 'roles', component: Roles,name:'roles', desc: '角色列表', icon: 'zonghe'},
                    {path: 'permissions', component: Permissions,name:'permissions', desc: '权限列表', icon: 'zonghe'}
                ]
            },
            ]
    },
    {
        path: '/sample1',
        component: Layout,
        redirect: 'noredirect',
        desc: '典型页面',
        icon: 'dianxinganli',
        iconBg: 'bg-purple',
        children: [
            {
                path: 'sample1',name:'sample1', component: Sample1, desc: 'Sample',icon: 'zonghe',
            },
            {
                path: 'detection',name:'detection', component: detection, desc: 'Detection',icon: 'zonghe',
            }
        ]
    },
    // {path: '*', redirect: '/404', hidden: true}
];
