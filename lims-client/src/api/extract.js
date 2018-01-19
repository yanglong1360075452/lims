import fetch from '@/utils/fetch';

export default {
    getMethodList(data) {
        return fetch({
            url: '/extract/method/' + data.species + "/" + data.sampleType,
            method: 'get'
        });
    },
    getSop(data) {
        return fetch({
            url: '/extract/sop/' + data,
            method: 'get'
        });
    }
}

