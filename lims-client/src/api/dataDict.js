import fetch from '@/utils/fetch';

export default{
    get(data){
        return fetch({
            url: '/data',
            method: 'get',
            params: data
        });
    },
    getList(data){
        return fetch({
            url: '/data/list',
            method: 'get',
            params: data
        });
    },
    getDictById(data){
        return fetch({
            url: '/data/'+data,
            method: 'get',
        });
    },
}

