import axios from 'axios';

export default{
  getList(data){
    return axios.get('/permission',{params:data});
  }
}
