import axios from 'axios';

export default{
  getSimpleList(data){
    return axios.get('/user/simple',{params:data});
  },
  getList(data){
    return axios.get('/user',{params:data})
  },
  getByName(data){
    return axios.get('/user/'+data);
  },
  //根据用户名称查询用户并判断用户密码是否匹配
  getUserByNameP(data){
    return axios.get('/user/password/'+data);
  },
  get(data){
    return axios.get('/user/'+data);
  },
  updateStatus(data){
    return axios.put('/user/'+data);
  },
  update(data){
    return axios.put('/user',data);
  },
  create(data){
    return axios.post('/user',data);
  },
  resetPassword(data){
    return axios.post('/user/reset',data);
  }
}
