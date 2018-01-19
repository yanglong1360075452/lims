import axios from 'axios';

export default{
  getList(data){
    return axios.get('/project',{params:data});
  },
  get(data){
    return axios.get('/project/'+data);
  },
  create(data){
    return axios.post('/project',data);
  },
  update(data){
    return axios.put('/project',data);
  }
}
