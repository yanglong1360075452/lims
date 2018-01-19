import fetch from '@/utils/fetch';

export default{
    getReceiveList(data){
        return fetch({
            url: '/sampleLot',
            method: 'get',
            params:data
        });
    },
    getByProjectId(data){
        return fetch({
            url: '/sampleLot/' + data.projectId,
            method: 'get',
            params:data
        });
    },
    create(data){
        return fetch({
            url: '/sampleLot',
            method: 'post',
            data: data
        });
    },
    update(data){
        return fetch({
            url: '/sampleLot',
            method: 'put',
            data: data
        });
    },
    getBarList(data){
        return fetch({
            url: '/sampleLot/bar/' + data,
            method: 'get'
        });
    },
}
