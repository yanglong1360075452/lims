import fetch from '@/utils/fetch';

export default{
    getById(data){
        return fetch({
            url: '/task/sub/'+data,
            method: 'get'
        });
    },
    getSampleListById(data){
        return fetch({
            url: '/task/sub/sample/'+data.id,
            method: 'get',
            params:data
        });
    },
    start(data){
        return fetch({
            url: '/task/sub/execution/start',
            method: 'post',
            data:data
        });
    },
    end(data){
        return fetch({
            url: '/task/sub/execution/end',
            method: 'post',
            data:data
        });
    },
}

