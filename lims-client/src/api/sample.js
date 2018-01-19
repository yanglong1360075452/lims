import fetch from '@/utils/fetch';

export default{
    receive(data){
        return fetch({
            url: '/sample/receive/'+data.sampleLotId,
            method: 'post',
            data:data.sampleIds
        });
    },
    reject(data){
        return fetch({
            url: '/sample/reject/'+data.sampleLotId,
            method: 'post',
            data:data.sampleIds
        })
    },
    create(data){
        return fetch({
            url: '/sample/',data,
            method: 'post'
        });
    },
    delete(data){
        return fetch({
            url: '/sample/'+data,
            method: 'delete'
        });
    },
    update(data){
        return fetch({
            url: '/sample',data,
            method: 'put'
        });
    },
    getList(data){
        return fetch({
            url: '/sample',
            params: data,
            method: 'get'
        });
    },
    batchOperate(data){
        return fetch({
            url: '/sample/operate',
            data:data,
            method: 'post'
        });
    }
}
