import fetch from '@/utils/fetch';

export default{
    getActivList(data){
        return fetch({
            url: '/cfg/activ',
            method: 'get',
            params: data
        });
    },
    getById(data){
        return fetch({
            url: '/cfg/activ/'+data,
            method: 'get'
        });
    }
}

