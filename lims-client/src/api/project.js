import fetch from '@/utils/fetch';

export default{
    /*创建项目*/
    create(data){
        return fetch({
            url: '/project',
            method: 'post',
            data: data
        });
    },
    /*获取项目列表*/
    getList(data){
        return fetch({
            url: '/project',
            method: 'get',
            params: data
        });
    },
    /*根据ID获取项目详情*/
    getById(data){
        return fetch({
            url: '/project/' + data,
            method: 'get',
        });
    },
    /*更新项目信息*/
    update(data){
        return fetch({
            url: '/project',
            method: 'put',
            data: data
        });
    },
    /*批量交付生产*/
    delivery(data){
        return fetch({
            url:'/project/delivery',
            method:'post',
            data:data
        });
    },
    /*根据项目ID获取样本数*/
    getSampleCount(data){
        return fetch({
            url: '/project/' + data+'/sampleCount',
            method: 'get',
        });
    },
    /*取消项目*/
    cancel(data){
        return fetch({
            url:'/project/cancel/'+data,
            method:'post'
        });
    },
    /*恢复项目*/
    recover(data){
        return fetch({
            url:'/project/recover/'+data,
            method:'post'
        });
    },
    /*取消生产*/
    cancelProduce(data){
        return fetch({
            url:'/project/cancelProduce/'+data,
            method:'post'
        });
    },
}

