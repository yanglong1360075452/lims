<template>
  <div class="container-wrap">
    <div class="container-box">
      <div class="container-content">
        <el-row>
          <el-col :span="12">
            <div class="grid-content bg-purple-dark">
              <el-tag style="font-size: large" color="#20A0FF">{{id==""?'新建用户':'编辑用户'}}</el-tag>
            </div>
          </el-col>
        </el-row>
        <div style="margin: 20px"></div>
        <el-row>
          <el-col :span="12" style="margin-left:20%">
            <div style="margin: 20px;"></div>
            <div class="grid-content">
              <el-form :inline="true" :model="user" class="demo-form-inline" label-width="100px">
                <el-form-item label="登录ID">
                  <el-input v-model="user.id" placeholder="登录ID" :disabled="true" style="width: 200px"></el-input>
                </el-form-item>
                <br>
                <el-form-item label="用户名">
                  <el-input v-model="user.username" placeholder="用户名" :disabled="true" style="width: 200px"></el-input>
                </el-form-item>
                <el-input v-model="user.password" placeholder="用户名" :disabled="true" style="display:none;width: 200px"></el-input>
                <br>
                <el-form-item label="用户昵称">
                  <el-input v-model="user.nickname" placeholder="用户昵称" :disabled="false" style="width: 200px"></el-input>
                </el-form-item>
                <br>
                <el-form-item label="手机号">
                  <el-input v-model="user.phone" placeholder="手机号" :disabled="false" style="width: 200px"></el-input>
                </el-form-item>
                <br>
                <el-form-item label="用户说明">
                  <el-input v-model="user.note"  placeholder="用户说明" :disabled="false" style="width: 400px"></el-input>
                </el-form-item>
                <br>
                <el-form-item label="状态" :span="12">
                  <el-radio-group v-model="user.status">
                  <el-radio class="radio" label="1">激活</el-radio>
                  <el-radio  label="2">禁用</el-radio>
                  </el-radio-group>
                </el-form-item>
                <br>
                <el-form-item label="角色列表:"></el-form-item>
                <div class="grid-content" style="height:200px;margin-top:-8%;margin-left:15%;width: 59%; border-width: 1px; border-style: solid; border-color: rgb(171, 173, 179);">
                  <!--<li v-for="user in roles" style="list-style-type:none"><div style="margin:10px;"></div><el-checkbox   :label="user.id" v-model="user.roles" style="border-bottom:1px dashed #E2E2E2;width:98%;padding-left:10px"></el-checkbox></li>-->
                </div>
              </el-form>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple-dark" align="right">
             <el-dialog  :visible.sync="resetPassword" size="tiny" title="重置密码">
                <el-form :model="reset" :rules="resetRule" ref="reset">
                  <el-form-item label="新密码" prop="pass">
                    <el-input type="password" v-model="reset.pass" auto-complete="off" placeholder="请输入密码"></el-input>
                  </el-form-item>
                  <el-form-item label="确认密码" prop="checkPass">
                    <el-input type="password" v-model="reset.checkPass" auto-complete="off" placeholder="请再次输入密码"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button type="primary" @click="submitForm1('reset')">提交</el-button>
                  <el-button @click="resetForm('reset')">取消</el-button>
                </div>
              </el-dialog>
            </div>
          </el-col>
        </el-row>
        <el-button type="text" @click="resetPassword = true" style="border-bottom:2px solid cornflowerblue;">重置用户密码?</el-button>

        <el-button  @click="submitForm('user')" type="primary" style="margin-top:2%;background-color: rgb(121, 168, 208);margin-left:40%">确定</el-button>
      </div>
    </div>
  </div>
</template>
<script>
  import UserService from '../../service/user';
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default {
    components: {ElButton},
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.reset.checkPass !== '') {
            this.$refs.reset.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.reset.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        resetPassword: false,
        readOnly: true,
        user: {},
        reset: {
          pass: '',
          checkPass: ''
        },
        resetRule: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        }
      }
    },
    created () {
      this.user.id = this.$route.params.id;
      this.readOnly = this.$route.params.readOnly;
      this.getUser(this.user.id);
    },

    methods: {
      getUser(id){
        let that = this;
        UserService.getList(id).then(function (response) {
          if(response.code == 0) {
            that.user = response.data;
          } else {
            that.$message({type: 'error', message: response.reason});
          }
        })
      },
      submitForm1(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var user = {
              id: this.user.id,
              password:this.reset.pass
            };
            let that = this;
            UserService.resetPassword(user).then(function (response) {
              if(response.code == 0) {
                that.$message({type: 'success', message: "操作成功"});
                that.resetPassword = false;
              } else {
                that.$message({type: 'error', message: response.reason});
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.$message({type: 'info', message: '已取消操作'});
        this.resetPassword = false;
      },
      submitForm() {
            var user = {
              id: this.user.id,
              username:this.user.username,
              password:this.user.password,
              nickname:this.user.nickname,
              phone:this.user.phone,
              status:this.user.status,
              note:this.user.note
            };
        if (user.id) {
            let that = this;
            UserService.update(user).then(function (response) {
              if(response.code == 0) {
                that.$message({type: 'success', message: "修改成功"});
                that.resetPassword = false;
              } else {
                that.$message({type: 'error', message: response.reason});
              }
            });
          }
      }
    }
  }
</script>
