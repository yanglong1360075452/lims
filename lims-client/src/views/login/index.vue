<template>
    <div class="login-container">
        <div class="logo1"></div>
        <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left"
                 label-width="0px"
                 class="card-box login-form">
            <!--<h3 class="title">系统登录</h3>-->
            <el-form-item prop="email">
        <span class="svg-container">
                  <icon-svg icon-class="jiedianyoujian"></icon-svg>
                </span>
                <el-input name="email" type="text" v-model="loginForm.username" autoComplete="on"
                          placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="password">
        <span class="svg-container">
                  <icon-svg icon-class="mima"></icon-svg>
                </span>
                <el-input name="password" type="password" @keyup.enter.native="handleLogin" v-model="loginForm.password"
                          autoComplete="on"
                          placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="width:100%;height:50px" :loading="loading"
                           @click.native.prevent="handleLogin">
                    登录
                </el-button>
            </el-form-item>
            <span>{{version}}</span>
        </el-form>
    </div>
</template>

<script>
    import {isWscnEmail} from '@/utils/validate';

    export default {
        name: 'login',
        data() {
            const validateEmail = (rule, value, callback) => {
//          if (!isWscnEmail(value)) {
//            callback(new Error('请输入正确的合法邮箱'));
//          } else {
                callback();
//          }
            };
            const validatePass = (rule, value, callback) => {
//          if (value.length < 6) {
//            callback(new Error('密码不能小于6位'));
//          } else {
                callback();
//          }
            };
            return {
                version: this.Version.version,
                loginForm: {
                    username: 'admin',
                    password: 'admin'
                },
                loginRules: {
//            email: [
//                { required: true, trigger: 'blur', validator: validateEmail }
//            ],
                    password: [
                        {required: true, trigger: 'blur', validator: validatePass}
                    ]
                },
                loading: false
            }
        },
        methods: {
            handleLogin() {
                this.$refs.loginForm.validate(valid => {
                    if (valid) {
                        this.loading = true;
                        this.$store.dispatch('Login', this.loginForm).then((response) => {
                            if(response.code == 0){
                                this.loading = false;
                                this.$router.push({path: '/'});
                            }else {
                                this.loading = false;
                                this.$message({type: 'error', message: response.data});
                            }
                        }).catch(() => {
                            this.loading = false;
                        });
                    } else {
                        return false;
                    }
                });
            }
        }
    }
</script>

<style rel="stylesheet/scss" lang="scss">
    @import "src/styles/mixin.scss";

    .tips {
        font-size: 14px;
        color: #fff;
        margin-bottom: 5px;
    }

    .logo1 {
        width: 410px;
        height: 90px;
        margin: 246px auto auto 436px;
        background-size: 98% 98%;
        background-image: url("../../assets/image/logo.png");
        background-repeat: no-repeat;
    }

    .login-container {
        background-image: url("../../assets/image/login.jpg");
        background-repeat: no-repeat;
        position: relative;
        height: 100%;
        -moz-background-size: 100% 100%;
        background-size: 100% 100%;
        @include relative;
        height: 100vh;
        //background-color: #2d3a4b;
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
            -webkit-text-fill-color: #fff !important;

        }
        input {
            background: transparent;
            border: 0px;
            -webkit-appearance: none;
            border-radius: 0px;
            padding: 12px 5px 12px 15px;
            color: #1F1A28;
            height: 47px;
        }
        .el-input {
            display: inline-block;
            height: 47px;
            width: 85%;
        }
        .svg-container {
            padding: 6px 5px 6px 15px;
            color: #889aa4;
        }
        .title {
            font-size: 26px;
            font-weight: 400;
            color: #eeeeee;
            margin: 0px auto 40px auto;
            text-align: center;
            font-weight: bold;
        }
        .login-form {
            width: 385px;
            height: 350px;
            padding-top: 10%;
            background-image: url("../../assets/image/content.png");
            background-repeat: no-repeat;
            /*position: absolute;*/
            left: 0;
            right: 0;
            //width: 400px;
            padding: 100px 13px 13px 14px;
            margin: -110px auto auto 1040px;
        }
        .el-form-item {
            border: 1px solid rgba(255, 255, 255, 0.1);
            background: rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            color: #454545;
        }
        .forget-pwd {
            color: #fff;
        }
    }
</style>
