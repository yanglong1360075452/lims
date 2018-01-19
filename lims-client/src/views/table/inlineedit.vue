<template>
  <div class="page-container page-component">
    <h2 id="table-biao-ge">
            <a href="http://element.eleme.io/#/zh-CN/component/table#table-biao-ge" aria-hidden="true" class="header-anchor"></a> 表格行内编辑</h2>
          <p>用于展示多条结构类似的数据，可对数据行内自定义操作。</p>
  
          
    <div class="filter-container">
      编号/名称
      <el-input @keyup.enter.native="handleFilter" style="width: 200px;" class="filter-item" placeholder="标题" v-model="listQuery.title">
      </el-input>
      <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleFilter">查询</el-button>
      <el-button-group style='float:right'>
        <el-button class="filter-item" style="margin-left: 10px;" @click="handleCreate" type="primary" icon="edit">新建样板</el-button>
        <el-upload
          action="//jsonplaceholder.typicode.com/posts/"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :file-list="fileList"
          class='upload-demo'>
          <el-button class="filter-item" type="primary" icon="document" >导入清单</el-button>
        </el-upload>
        
        <el-button class="filter-item" type="primary" icon="document" @click="handleExport">下载模板</el-button>
      </el-button-group>
      
    </div>
     <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit highlight-current-row>
      
      <el-table-column align="center" label="ID" width="60px">
        <template scope="scope">
          <span>{{scope.row.id}}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="样本名称">
        <template scope="scope">
          <el-input v-show="scope.row.edit" size="small" v-model="scope.row.name"></el-input>
          <span v-show="!scope.row.edit">{{scope.row.name}}</span>
        </template>
      </el-table-column>

      <el-table-column width="100px" align="center" label="送样浓度">
        <template scope="scope">
          <el-input v-show="scope.row.edit" size="small" v-model="scope.row.sampleConcentration"></el-input>
          <span v-show="!scope.row.edit">{{scope.row.sampleConcentration}}</span>
        </template>
      </el-table-column>

      <el-table-column width="100px" label="实际浓度">
        <template scope="scope">
          <el-input v-show="scope.row.edit" size="small" v-model="scope.row.concentration"></el-input>
          <span  v-show="!scope.row.edit" >{{scope.row.concentration}}</span>
        </template>
      </el-table-column>

      <el-table-column  label="原始体积" width="100px">
        <template scope="scope">
          <el-input v-show="scope.row.edit" size="small" v-model="scope.row.originalVolumn"></el-input>
          <span v-show="!scope.row.edit">{{scope.row.originalVolumn}}</span>
        </template>
      </el-table-column>

      <el-table-column width="100px" label="剩余体积">
        <template scope="scope">
          <el-input v-show="scope.row.edit" size="small" v-model="scope.row.residualVolume"></el-input>
          <span v-show="!scope.row.edit">{{scope.row.residualVolume}}</span>
        </template>
      </el-table-column>

      <el-table-column width="180px" label="生产时间">
        <template scope="scope">
          <el-date-picker v-show="scope.row.edit" type="date" placeholder="生产时间" format='yyyy-MM-dd' style='width:100%' v-model="scope.row.productionTime"></el-date-picker>
          <span v-show="!scope.row.edit">{{scope.row.productionTime}}</span>
        </template>
      </el-table-column>
      <el-table-column width="180px" label="接收时间">
        <template scope="scope">
          <el-date-picker v-show="scope.row.edit" type="date" placeholder="接收时间" format='yyyy-MM-dd'   style='width:100%'  v-model="scope.row.receiptTime"></el-date-picker>
          <span v-show="!scope.row.edit">{{scope.row.receiptTime}}</span>
        </template>
      </el-table-column>
      <el-table-column width="80px" label="库位">
        <template scope="scope">
          <el-input v-show="scope.row.edit" size="small" v-model="scope.row.storageBin"></el-input>
          <span v-show="!scope.row.edit">{{scope.row.storageBin}}</span>
        </template>
      </el-table-column>
       <el-table-column width="150px" label="生产状态">
        <template scope="scope">
          <div v-if="!scope.row.edit">
            <el-tag :close-transition='true'  :type="scope.row.status">{{scope.row.status}}</el-tag>
          </div>
          <el-select v-if="scope.row.edit" v-model="scope.row.status" style='width:100%' placeholder="生产状态">
            <el-option label="draft" value="draft"></el-option>
            <el-option label="published" value="published"></el-option>
          </el-select>
          
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作" width="180px" fixed="right">
        <template scope="scope">
          <el-button v-if='!scope.row.edit' type="primary" @click='scope.row.edit=true' size="small" icon="edit">修改</el-button>
          <el-button v-if='scope.row.edit' type="success" @click='scope.row.edit=false' size="small" icon="edit">完成</el-button>
          <el-button  type="danger"  size="small" icon="edit" @click='handelDelete(scope)'>删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="10"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import { getTableList } from '@/api/table';
  export default {
    name: 'inline_edit-table_demo',
    data() {
      return {
        list: null,
        listLoading: true,
        listQuery: {
          page: 1,
          limit: 10
        },
        currentPage: 1
      }
    },
    created() {
      this.getList();
    },
    filters: {
      statusFilter(status) {
        const statusMap = {
          published: 'success',
          draft: 'gray',
          deleted: 'danger'
        };
        return statusMap[status]
      }
    },
    methods: {
      getList() {
        this.listLoading = true;
        getTableList(this.listQuery).then(response => {
          this.list = response.map(v => {
            v.edit = false;
            return v
          });
          this.listLoading = false;
        })
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        console.log(`当前页: ${val}`);
      },
      handleCreate() {
        this.list.splice(0, 0, {
          name: '',
          status: 'draft',
          productionTime: '',
          receiptTime: '',
          pageviews: '',
          sampleConcentration: '',
          concentration: '',
          originalVolumn: '',
          residualVolume: '',
          storageBin: '',
          edit: true
        })
      },
      handleFilter() {
        getList();
      },
      handelDelete(item) {
        console.log(item)
        // for (let i = 0; i < this.list.length; i++) {
        //   if (item.id === this.list[i].id) {
        //     this.list.splice(i, 1);
        //     break;
        //   }
        // }
      },
      handleExport() {
        // require.ensure([], () => {
        //   const { export_json_to_excel } = require('../../vendor/Export2Excel');
        //   const tHeader = ['时间', '地区', '类型', '标题', '重要性'];
        //   const filterVal = ['timestamp', 'province', 'type', 'title', 'importance'];
        //   const data = this.formatJson(filterVal, this.list);
        //   export_json_to_excel(tHeader, data, 'table数据');
        // })
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss" >
.filter-container{
  padding-bottom: 10px;
}
.el-pagination{
  text-align:right;
  padding:10px 0;
}
.el-pagination__total{
    float:left;
}
.el-select,.el-date-editor{
  .el-input__inner{
    height:30px;
  }
}
.upload-demo{
  float:left;
  .el-button{
    border-radius:0px;
    border-left:1px solid rgba(255,255,255,.5);
  }
}
</style>