<template>
  <div class="container-wrap">
    <div class="container-box">
      <div class="">

      </div>
      <div class="container-content">
        <el-table :data="permissions" border stripe tooltip-effect="dark" style="width:86.5%;margin-left:4%;margin-bottom:5%;">
          <el-table-column prop="id" label="权限id"  align="center">

          </el-table-column>
          <el-table-column prop="name" label="权限名字" align="center"></el-table-column>
          <el-table-column prop="" label="权限描述"  show-overflow-tooltip align="center"></el-table-column>
          <el-table-column prop="code" label="权限代码"  align="center"></el-table-column>

        </el-table>
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
  </div>
</template>
<script>
  import PermissionService from '../../service/permission';
  import types from '../../store/mutation-types';
  export default {

    data() {
      return {
        currentPage: 2,
        totalPage: 0,
        pageSize: 18,
        totalCount: 0,
        key_word: '',
        permissions: []
      }
    },
    created () {
      this.permissionsData();
    },
    watch: {
      '$route': 'permissionsData'
    },
    methods: {
      /**获取权限列表数据*/
      permissionsData () {
        let that = this;
        setTimeout( () => {
          PermissionService.getList({
            page: that.currentPage-1,
            length: that.pageSize,
          }).then(function (response) {
              if(response.code == 0) {
                that.permissions = response.data.rows;
                that.totalPage = response.totalPage;
                that.totalCount = response.data.totalCount;
              }
              else that.$message({type: 'error', message: response.reason});
          });
        },300);
      }
    }
  }



</script>
<style lang="scss">
  @import "../../assets/scss/define";
  .container-content{
  @extend %pa;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 70px 20px;
    overflow-x: hidden;
    overflow-y: auto;
  }
  .search-box{
  @extend %pa;
    top: 20px;
    right: 40px;
    z-index: 1;
    width: 360px;
  }
  .container-box{
  @extend %h100;
  }
  .page-wrap{
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
