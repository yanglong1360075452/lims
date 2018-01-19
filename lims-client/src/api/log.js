import fetch from '@/utils/fetch';

export default{
    getList(data){
        return fetch({
            url: '/log',
            params: data,
            method: 'get'
        })
    },
    getType(data){
        return fetch({
            url: '/log/type',
            params: data,
            method: 'get'
        });
    }
}

