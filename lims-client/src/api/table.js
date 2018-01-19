import fetch from '@/utils/fetch';

export function getList(params) {
  return fetch({
    url: '/table/list',
    method: 'get',
    params
  });
}
export function getTableList(params) {
  return fetch({
    url: '/table/list1',
    method: 'get',
    params
  });
}


