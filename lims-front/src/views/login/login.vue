<template>
  <!--登录页-->
  <div class="login-wrap">
  <div class="login-logo"></div>
    <div class="login-content">
      <!--<h1 class="login-title">用户登录</h1>-->
      <div class="login-back">
      <el-form :model="loginForm" :rules="loginRules" ref="loginForm">
        <el-form-item prop="username" style="width: 93%;margin-left:3%">
          <el-input type="text" placeholder="请输入帐号" v-model="loginForm.username" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="password" style="width: 93%;margin-left:3%">
          <el-input type="password" placeholder="请输入密码" v-model="loginForm.password" auto-complete="off"
                    @keyup.enter.native="submitForm('loginForm')"></el-input>
        </el-form-item>
        <el-form-item prop="captcha" label="验证码" v-show="captchaSrc == ''?false:true">
          <el-input type="text" placeholder="请输入验证码" v-model="loginForm.captcha" auto-complete="off"></el-input>
          <img :src="captchaSrc" />
          <a @click="getCaptcha()">换一张</a>
        </el-form-item>
        <el-form-item class="input-button" style="width: 93%;margin-left:3%">
          <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
        </el-form-item>
        <span>{{version}}</span>
      </el-form>
      </div>
    </div>
  </div>
  <!--/登录页-->
</template>
<script>
  import LoginService from '../../service/login';
  import Util from '../../assets/lib/util';
  export default {
    name: 'login',
    data() {

      var validateUserName = (rule, value, callback) => {
        if (value === '')
          return callback(new Error('请输入帐号'));
        callback();
      };
      var validateUserPassword = (rule, value, callback) => {
        if (value === '')
          return callback(new Error('请输入密码'));
        callback();
      };
      return {
        version: this.Version.version,
        loginForm: {
          username: '',
          password: '',
          captcha: ''
        },
        loginRules: {
          username: [
            {validator: validateUserName, trigger: 'blur'}
          ],
          password: [
            {validator: validateUserPassword, trigger: 'blur'}
          ]
        },
        captchaSrc:""
      };
    },
    methods: {
      getCaptcha(){
        var random = Math.random()*1000;
        var base_url;
        if (window.location.href.indexOf('localhost') != -1) {
          base_url = 'http://localhost:8080/lims-server/api';
        } else {
          base_url = 'api';
        }
        this.captchaSrc = base_url+"/auth/captcha?"+random;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
              let that = this;
            LoginService.login(this.loginForm).then(function (response) {
              if (response.code == 0) {
                Util.dataToSessionStorageOperate.save('user', that.loginForm);
                that.$router.push("/empty");
              } else {
                if (response.code == 8) {
                  that.getCaptcha();
                }else if(response.code == 9){
                  that.getCaptcha();
                  that.$message({
                    showClose: true,
                    message: response.data,
                    type: 'error'
                  });
                } else {
                  that.$message({
                    showClose: true,
                    message: response.data,
                    type: 'error'
                  });
                }
              }
            });
            return true;
          } else {
            return false;
          }
        });
      }
    }
  }
</script>
<style lang="scss">
  @import "../../assets/scss/define";
  #app,html,body{
    @extend %oh;
    @extend %h100;
  }
  .login-wrap{
    @extend %db;
    @extend %h100;
    background-image: url("../../static/images/login.jpg");
    filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')";
    -moz-background-size:100% 100%;
    background-size:100% 100%;
    position:relative;
  }
  .login-back{
      width: 385px;
      height:220px;
      padding-top:20%;
      background-image: url("../../static/images/content.png");
  }
  .login-content{
    @extend %pa;
    @extend %l50;
    margin-top: 300px;
    margin-left: 100px;
    background-position: right 20%;
  }
  .login-logo{
  background-repeat:no-repeat;
  height:110px;
   width: 430px;
   position:absolute;
   left:25%;
   top:30%;
        background-image: url("../../static/images/logo.png");
  }
  .login-title{
    @extend %cfff;
    @extend %f16;
    @extend %tac;
    line-height: 40px;
  }
  .input-wrap{
  padding: 20px 36px;
  border-radius: 10px;
  }
  .input-box,.input-button{
  margin: 16px 0;
  }
  .input-button{
    button{
      @extend %w100;
      @extend %db;
      height:50px;
      margin-top:10%;
    }
  }
</style>
