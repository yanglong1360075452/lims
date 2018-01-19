import fetch from '@/utils/fetch';

export default{
    /*获取任务列表*/
    getList(data){
        return fetch({
            url: '/task',
            method: 'get',
            params: data
        });
    },
    getById(data){
        return fetch({
            url: '/task/'+data,
            method: 'get'
        });
    },
    /*任务调度*/
    dispatch(data){
        return fetch({
            url: '/task/'+data.projectId,
            method: 'post',
            data: data.tasks
        });
    }
}

