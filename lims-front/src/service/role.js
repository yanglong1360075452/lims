import axios from 'axios';

export default{
  getList(data){
    return axios.get('/role',{params:data});
  },
  delete(data){
    return axios.delete('/role/'+data);
  },
  update(data){
    return axios.put('/role',data);
  },
  create(data){
    return axios.post('/role',data);
  }
}

