import axios from 'axios';

export default{
  getList(data){
    return axios.get('/sample',{params:data});
  },
  delete(data){
    return axios.delete('/sample/',data);
  },
  create(data){
    return axios.post('/sample/',data);
  },
  update(data){
    return axios.put('/sample/',data);
  }
}



