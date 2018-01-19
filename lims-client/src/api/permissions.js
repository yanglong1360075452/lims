import fetch from '@/utils/fetch';

export default{
    getPermissionsList(data){
        return fetch({
            url: '/permission',
            params:data,
            method: 'get'
        });
    },

    getList(data){
        return fetch({
            url: '/permission',
            params:data,
            method: 'get'
        });
    },
}

