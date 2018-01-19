import fetch from '@/utils/fetch';

export function getInfo(id) {
    return fetch({
        url: '/user/info/'+id,
        method: 'get'
    });
}
 export default{
     getList(data){
         return fetch({
             url: '/user',params:data,
             method: 'get'
         });
    },
    getByName(data){
        return fetch({
            url: '/user/'+data,
            method: 'get'
        });
    },
    create(data){
        return fetch({
            url: '/user',data,
            method: 'post'
        });
    },
    update(data){
        return fetch({
            url: '/user',data,
            method: 'put'
        });
    },
    resetPassword(data){
        return fetch({
            url: '/user/reset',data,
            method: 'post'
        });
    },
    updateStatus(data){
        return fetch({
            url: '/user/'+data,
            method: 'put'
        });
     },
     getUserByNameP(data){
         return fetch({
             url: '/user/password/'+data,
             method: 'get'
         });
     },
     getSimpleList(){
         return fetch({
             url: '/user/simple',
             method: 'get'
         });
     }
}

