import fetch from '@/utils/fetch';

export default{
    /*开始任务执行*/
    start(data){
        return fetch({
            url: '/task/execution/start/'+data,
            method: 'post',
            data:null
        });
    },
    /*任务完成*/
    finish(data){
        return fetch({
            url: '/task/execution/finish/'+data,
            method: 'post',
            data:null
        });
    },
    /*任务暂停*/
    pause(data){
        return fetch({
            url: '/task/execution/pause/'+data,
            method: 'post',
            data:null
        });
    },
    /*任务继续*/
    goon(data){
        return fetch({
            url: '/task/execution/goon/'+data,
            method: 'post',
            data:null
        });
    },
    /*任务终止*/
    termination(data){
        return fetch({
            url: '/task/execution/termination/'+data,
            method: 'post',
            data:null
        });
    },
}

