import axios from 'axios';

export default{
  get(data){
    return axios.get('/data',{params:data});
  }
}
