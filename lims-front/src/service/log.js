import axios from 'axios';

export default{
  getList(data){
    return axios.get('/log',{params:data});
  },
  getType(data){
    return axios.get('/log/type',{params:data});
  }
}
