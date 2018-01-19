import fetch from '@/utils/fetch';

export default{
    getWorkflowList(data){
        return fetch({
            url: '/cfg/workflow',
            method: 'get',
            params: data
        });
    },
    getById(data){
        return fetch({
            url: '/cfg/workflow/'+data,
            method: 'get'
        });
    },
    getSimpleList(){
        return fetch({
            url: '/cfg/workflow/simple',
            method: 'get'
        });
    },
}

