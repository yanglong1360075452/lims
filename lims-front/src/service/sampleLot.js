import axios from 'axios';

export default{
  getByProjectId(data){
    return axios.get('/sampleLot/'+data);
  },
  create(data){
    return axios.post('/sampleLot/',data);
  },
  update(data){
    return axios.put('/sampleLot/',data);
  },
  getBarList(data){
    return axios.get('/sampleLot/bar/'+data);
  }
}
