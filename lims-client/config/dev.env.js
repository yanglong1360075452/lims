var merge = require('webpack-merge')
var prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // BASE_API: '"http://localhost:8083/lims-server/api"',
  //   BASE_API: '"https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin"',
    //BASE_API: '"http://oa.wizinno.com/lims-server/api"',
   BASE_API: '"http://localhost:8080/lims-server/api"',

})
