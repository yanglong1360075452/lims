import fetch from '@/utils/fetch';
// export function getRoleList(data) {
//     return fetch({
//         url: '/role',params:data,
//         method: 'get'
//     });
// }
export default{
    getRoleList(data){
        return fetch({
            url: '/role',
            params:data,
            method: 'get'
        });
    },

    create(data){
        return fetch({
            url: '/role',data,
            method: 'post'
        });
    },

    getByName(data){
        return fetch({
            url: '/role/'+data,
            method: 'get'
        });
    },
    update(data){
        return fetch({
            url: '/role',data,
            method: 'put'
        });
    },

    deleteRole(data){
        return fetch({
            url: '/role/'+data,
            method: 'delete'
        });
    },


}


