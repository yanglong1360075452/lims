<template>
  <div class="container-wrap" ref="abcde"
       style="width:76.5%;height:90%;margin-left:3.5%;margin-bottom:5%; margin-right:10%">
    <div class="container-box">
      <div class="">

      </div>
      <div class="container-content" style="width:100%">
        <el-button type="primary" @click="add"
                   style="background-color:#41B4C6;float:right;margin-bottom:2%;margin-right:2%">+新建
        </el-button>
        <el-table :data="users" border stripe tooltip-effect="dark" style="width: 100%">
          <el-table-column prop="id" label="用户ID" width="100" align="center"></el-table-column>
          <el-table-column prop="username" label="用户名" width="150" align="center"></el-table-column>
          <el-table-column prop="nickname" label="用户昵称" width="100" align="center"></el-table-column>
          <el-table-column prop="department" label="部门" width="100" align="center"></el-table-column>
          <el-table-column prop="position" label="职位" width="100" align="center"></el-table-column>
          <el-table-column prop="roles" label="角色列表" width="250" align="center">
            <template scope="scope">
              <ul>
                <li v-for="item in scope.row.roles" style="display: inline">
                  {{ item.name }}
                </li>
              </ul>
            </template>
          </el-table-column>
          <el-table-column prop="note" label="用户说明" width="200" show-overflow-tooltip align="center"></el-table-column>

          <el-table-column prop="status" label="状态" width="100" aligsn="center">
            <template scope="scope">
              <li style="text-align: center;list-style: none">{{scope.row.status ? '激活' : '禁用'}}</li>
              <!--<li style="text-align: center;list-style: none" v-if="scope.row.status=='0'">激活</li>-->
              <!--<li style="text-align: center;list-style: none" v-else>-->
              <!--<el-button type="text" @click="disables(scope.row)">禁用</el-button>-->
              <!--</li>-->
            </template>
          </el-table-column>

          <el-table-column label="操作" align="center" width="100">
            <template scope="scope">
              <el-button @click="updateStatus(scope.row)" type="text" size="small"
                         :disabled="scope.row.id==1?true:false">{{scope.row.status ? '禁用' : '激活'}}
              </el-button>
              <el-button @click="open(scope.row)" type="text" size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>


      </div>
      <!--新增界面-->
      <el-dialog title="用户" :visible.sync="dialogFormVisible" @close="cancels()">
        <el-form :model="user" :rules="validForm" label-width="80px" ref="addForm">
          <el-form-item label="用户名" v-if="user.id != null">
            <el-input v-model="user.username" placeholder="用户名" :disabled="true" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="用户名" v-else>
            <el-input v-model="user.username" prop="username" placeholder="用户名" :disabled="false"
                      style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="密码" v-if="user.id == null">
            <el-input v-model="user.password" placeholder="密码" :disabled="false" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="用户昵称">
            <el-input v-model="user.nickname" placeholder="用户昵称" :disabled="false" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="user.phone" placeholder="手机号" :disabled="false" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="用户说明">
            <el-input v-model="user.note" placeholder="用户说明" :disabled="false" style="width: 400px"></el-input>
          </el-form-item>
          <el-form-item label="部门">
            <el-input v-model="user.department" placeholder="部门" :disabled="false" style="width: 400px"></el-input>
          </el-form-item>
          <el-form-item label="职位">
            <el-input v-model="user.position" placeholder="职位" :disabled="false" style="width: 400px"></el-input>
          </el-form-item>
          <el-form-item label="角色列表">

            <el-checkbox-group v-model="checkedroles">
              <el-checkbox v-for="role in roles" :label="role.id" :disabled="user.id == 1 && role.id==1?true:false"
                           :key="role">{{role.name}}
              </el-checkbox>
            </el-checkbox-group>
            <!--<el-checkbox-group v-model="checkedroles" v-else>-->
            <!--<el-checkbox v-for="role in roles" :label="role.id"  :key="role">{{role.name}}</el-checkbox>-->
            <!--</el-checkbox-group>-->


          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="resetPassword = true"
                     style="float:left;border-bottom:2px solid cornflowerblue;" v-if="user.id!=null">重置用户密码?
          </el-button>
          <el-button @click="cancels">取 消</el-button>
          <el-button type="primary" @click="operateUser()">确 定</el-button>
        </div>
      </el-dialog>


      <el-col :span="12">
        <div class="grid-content bg-purple-dark" align="right">
          <el-dialog :visible.sync="resetPassword" size="tiny" title="重置密码" ref="resetForm">
            <el-form :model="reset" :rules="resetRule" ref="reset">
              <el-form-item label="新密码" prop="pass">
                <el-input type="password" v-model="reset.pass" auto-complete="off" placeholder="请输入密码"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" v-model="reset.checkPass" auto-complete="off"
                          placeholder="请再次输入密码"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="submitForm1('reset')">提交</el-button>
              <el-button @click="resetPassword=false">取消</el-button>
            </div>
          </el-dialog>
        </div>
      </el-col>
    </div>
    <div class="page-wrap">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="totalCount">
      </el-pagination>
    </div>
  </div>
</template>
<script>
  import UserService from '../../service/user';
  import RoleService from '../../service/role';
  import types from '../../store/mutation-types';
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default {
    components: {ElButton},
    name: 'list',
    data() {
      var validateUserName = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入用户名'));
        } else {
          callback();
        }
      };


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
        dialogFormVisible: false,
        resetPassword: false,
        reset: {
          pass: '',
          checkPass: ''
        },
        validForm: {
          username: [
            {validator: validateUserName, trigger: 'blur'}
          ]
        },
        resetRule: {
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ]
        },
        whatfuck: "",
        currentPage: 1,
        totalPage: 0,
        pageSize: 10,
        totalCount: 0,
        users: [],
        roles: [],
        checkedroles: [],
        user: {
          username: null,
          password: null,
          phone: null,
          nickname: null,
          note: null,
          status: null,
          department: null,
          position: null,
          roles: null
        },
      }
    },
    created () {
      this.fetchData();
    },
    watch: {
      '$route': 'fetchData'
    },

    methods: {
      cancels(){
        this.dialogFormVisible = false;
        this.user = {
          roles: [],
          username: null,
          password: null,
          phone: null,
          nickname: null,
          department: null,
          position: null,
          note: null,
        };
        this.checkedroles = [];
      },
      //将禁用的用户再次激活
//      disables(user){
//        this.$confirm('是否将用户名为'+ user.username +'的用户激活?', '提示', {
//          confirmButtonText: '确定',
//          cancelButtonText: '取消',
//          type: 'warning'
//        }).then(() => {
//          Util.userAjax.updateUser(user,(result) => {
//            this.fetchData();
//            if(result.code==0){
//              this.fetchData();
//              this.$message({type: 'success', message: '激活成功'});
//            }else{
//              this.$message({type: 'success', message: '激活失败'});
//            }
//          });
//        }).catch(() => {
//          this.$message({type: 'info', message: '已取消激活'});
//        });
//      },
      open(user){
        this.dialogFormVisible = true;
        this.getAppRoles();
        if (user != null) {
          this.user = user;
          for (var i = 0; i < user.roles.length; i++) {
            this.checkedroles.push(user.roles[i].id);
          }
        }
      },
      add(){
        this.dialogFormVisible = true;
        this.getAppRoles();
      },
      handleCurrentChange (val) {
        this.currentPage = val;
        this.fetchData();
      },
      submitForm1(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var user = {
              id: this.user.id,
              password: this.reset.pass
            };
            let that = this;
            UserService.resetPassword(user).then(function (response) {
              if (response.code == 0) {
                that.$message({type: 'success', message: "密码修改成功"});
                that.resetPassword = false;
              } else {
                that.$message({type: 'error', message: response.reason});
              }
            });
          } else {
            this.$message({type: 'success', message: "密码修改失败"});
            return false;
          }
        });
      },
      getAppRoles(){
        let that = this;
        RoleService.getList({
          page: 1,
          length: 1000,
        }).then(function (response) {
          if (response.code == 0) {
            that.roles = response.data.rows;
          }
        });
      },


      operateUser(){
        this.$refs.addForm.validate((valid) => {
          if (valid) {
            this.user.roles = this.checkedroles;
            let that = this;
            if (that.user.id != undefined) {
              UserService.update(that.user).then(function (response) {
                if (response.code == 0) {
                  that.$message({type: 'success', message: "编辑角色成功"});
                  that.cancels();
                  that.fetchData();
                }
                else that.$message({type: 'error', message: response.reason});
                that.fetchData();
              });
            } else {
              if ("" != that.user.username && null != that.user.username) {
                UserService.getByName(that.user.username).then(function (response) {
                  if (response.code == 0) {
                      if(response.data != undefined && response.data.username != undefined){
                        that.$message({type: 'error', message: "创建用户失败!用户名已存在"});
                      }else {
                        UserService.create(that.user).then(function (response) {
                          if (response.code == 0) {
                            that.$message({type: 'success', message: "创建用户成功"});
                            that.cancels();
                            that.fetchData();
                          }
                          else that.$message({type: 'error', message: "创建用户失败"});
                          that.cancels();
                          that.fetchData();
                        });
                      }
                  }
                });
              } else {
                that.$message({type: 'error', message: "创建用户失败!请输入用户名"});
              }
            }
          } else {
            this.$message({type: 'error', message: "创建用户失败"});
            this.cancels();
            return false;
          }
        });


      },
      /**根据用户名查询用户是否存在*/
      getUserByName(username){
          let that = this;
        UserService.getByName(username).then(function (response) {
          if (response.code == 0 && response.data.username != null) {
            that.whatfuck = "1";
          } else {
            console.log("没有数据");
            that.bole = "";
          }
        });
      },

      /**更改用户状态*/
      updateStatus ({id, username}) {
        this.$confirm('是否更新用户名为' + username + '的用户?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            let that = this;
          UserService.updateStatus(id).then(function (response) {
            that.fetchData();
            if (response.code == 0) {
              that.fetchData();
              that.$message({type: 'success', message: '更新成功'});
            } else {
              that.$message({type: 'success', message: '更新失败'});
            }
          });
        }).catch(() => {
          this.$message({type: 'info', message: '已取消更新'});
        });
      },
      /**获取用户列表数据*/
      fetchData () {
        setTimeout(() => {
            let that = this;
          UserService.getList({
            page: that.currentPage,
            length: that.pageSize
          }).then(function (response) {
            if (response.code == 0) {
              that.users = response.data.rows;
              that.totalPage = response.totalPage;
              that.totalCount = response.data.totalCount;
            }
            else that.$message({type: 'error', message: response.reason});
          });
        }, 300);
      }
    }
  }
</script>
<style lang="scss">
  @import "../../assets/scss/define";

  .container-content {
    @extend %pa;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 70px 20px;
    overflow-x: hidden;
    overflow-y: auto;
  }

  .search-box {
    @extend %pa;
    top: 20px;
    right: 40px;
    z-index: 1;
    width: 360px;
  }

  .container-box {
    @extend %h100;
  }

  .page-wrap {
    @extend %pa;
    @extend %tac;
    background-color: #fff;
    z-index: 1;
    left: 0;
    right: 0;
    padding: 10px 0 20px;
    bottom: 0;
  }
</style>
