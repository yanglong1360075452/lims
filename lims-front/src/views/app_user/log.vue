<template>
  <div class="container-wrap">
    <div class="container-box">
      <div class="">

      </div>
      <div class="container-content">
        <div>
          <span class="demonstration">操作时间</span>
          <el-date-picker
            v-model="selectTime"
            type="daterange"
            align="right"
            placeholder="选择日期范围"
            :picker-options="pickerOptions">
          </el-date-picker>
          &nbsp;&nbsp;&nbsp;
          <span class="label">操作类型</span>
          <el-select v-model="operateType" placeholder="请选择" @change="fetchData()">
            <el-option
              v-for="item in type"
              :key="item.code"
              :label="item.name"
              :value="item.code"
            >
            </el-option>
          </el-select>
          &nbsp;&nbsp;&nbsp;
          <span class="label">操作者</span>
          <el-select v-model="operator" placeholder="请选择" @change="fetchData()">
            <el-option
              v-for="item in users"
              :key="item.id"
              :label="item.nickname"
              :value="item.id"
            >
            </el-option>
          </el-select>
          <el-button @click="download()">导出</el-button>
        </div>
        <br>
        <el-table :data="logs" border stripe tooltip-effect="dark" ref="table">
          <el-table-column prop="operateTime" label="操作时间" align="center" width="200">
            <template scope="scope">
              {{scope.row.operateTime | date}}
            </template>
          </el-table-column>
          <el-table-column prop="ip" label="IP" align="center" width="150"></el-table-column>
          <el-table-column prop="operatorUser.nickname" label="操作者" align="center" width="150"></el-table-column>
          <el-table-column prop="operateTypeDesc" label="操作类型" align="center" width="100"></el-table-column>
          <el-table-column prop="operateDesc" label="操作" show-overflow-tooltip align="center"
                           width="150"></el-table-column>
          <el-table-column prop="description" label="请求参数" show-overflow-tooltip align="center"></el-table-column>

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
  import Util from '../../assets/lib/util';
  import LogService from '../../service/log';
  import UserService from '../../service/user';
  import types from '../../store/mutation-types';
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";

  export default {

    components: {ElButton},
    data() {
      return {
        operator: null,
        users: null,
        type: null,
        operateTimeStart: null,
        operateTimeEnd: null,
        operateType: null,
        currentPage: 1,
        totalPage: 0,
        pageSize: 10,
        totalCount: 0,
        key_word: '',
        logs: [],
        pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
        selectTime: ''
      }
    },
    created() {
      this.fetchData();
      this.getType();
      this.getUsers();
    },
    watch: {
      '$route': 'fetchData',
      'selectTime': 'fetchData',
      'operator': 'fetchData'
    },
    methods: {
      download(){
        let columns = this.$refs.table.$children.filter(t => t.prop != null);
        const fields = columns.map(t => t.prop);
        const fieldNames = columns.map(t => t.label);
        Util.download(this.logs, fields, fieldNames, '列表');
      },

      /**获取日志操作类型**/
      getType() {
        let that = this;
        LogService.getType({}).then(function (response) {
          if (response.code == 0) {
            that.type = response.data;
          }
        });
      },
      getUsers() {
          let that = this;
        UserService.getSimpleList({}).then(function (response) {
          if (response.code == 0) {
            that.users = response.data;
          }
        });
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        this.fetchData();
      },
      /**获取日志列表数据*/
      fetchData() {
        if (this.selectTime != undefined) {
          var start = this.selectTime[0];
          var end = this.selectTime[1];
          if (start != undefined) {
            this.operateTimeStart = new Date(start).getTime();
          }
          if (end != undefined) {
            this.operateTimeEnd = new Date(end).getTime() + 1000 * 60 * 60 * 24;
          }
        }
        setTimeout(() => {
            let that = this;
          LogService.getList({
            page: that.currentPage,
            length: that.pageSize,
            operateTimeStart: that.operateTimeStart,
            operateTimeEnd: that.operateTimeEnd,
            operateType: that.operateType,
            operator: that.operator
          }).then(function (response) {
            if (response.code == 0) {
              that.logs = response.data.rows;
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
