import fetch from '@/utils/fetch';
import qs from 'qs';

export function login(data) {
  return fetch({
    url: '/login',
    method: 'post',
    data: qs.stringify(data)
  });
}

export function logout() {
  return fetch({
    url: '/logout',
    method: 'post'
  });
}



