<template>
  <div class='page-container page-component'>
    <div>
      <div class="el-col el-col-24 el-col-xs-24 el-col-sm-18">
        <section class="content">
          <h2 id="table-biao-ge">
            <a href="http://element.eleme.io/#/zh-CN/component/table#table-biao-ge" aria-hidden="true" class="header-anchor"></a> 表格批量处理</h2>
          <p>用于展示多条结构类似的数据，可对数据批量自定义操作。</p>
  
          
          <div class="demo-block demo-box demo-zh-CN demo-table">
            <div class="source">
              <el-table ref="multipleTable" :data="tableData3" border tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" v-if="isShowSelect">
                </el-table-column>
                <el-table-column label="日期" width="120">
                  <template scope="scope">{{ scope.row.date }}</template>
                </el-table-column>
                <el-table-column prop="name" label="姓名" width="120">
                </el-table-column>
                <el-table-column prop="address" label="地址" show-overflow-tooltip>
                </el-table-column>
              </el-table>
              <div style="margin-top: 20px">
                <el-button  v-if="!isShowSelect" type='info' @click="toggleShowSelection()">批量处理</el-button>
                <el-button  v-if="isShowSelect" @click="toggleSelection([tableData3[0],tableData3[1], tableData3[2], tableData3[3], tableData3[4], tableData3[5], tableData3[6], tableData3[7]])">全部选择</el-button>
                <el-button  v-if="isShowSelect" @click="toggleSelection()">取消选择</el-button>
                <el-button  v-if="isShowSelect"  type='success' @click="toggleSelection()">确定</el-button>
              </div>
            </div>
            <div class="meta" style="height: 1879px;">
              <div class="description">
                <p>实现多选非常简单: 手动添加一个
                  <code>el-table-column</code>，设
                  <code>type</code>属性为
                  <code>selection</code>即可；默认情况下若内容过多会折行显示，若需要单行显示可以使用
                  <code>show-overflow-tooltip</code>属性，它接受一个
                  <code>Boolean</code>，为
                  <code>true</code>时多余的内容会在 hover 时以 tooltip 的形式显示出来。</p>
                <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                  <!---->
                  <!---->
                  <span>在线运行</span>
                </button>
              </div>
              <div class="highlight">
                <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
        <span class="hljs-attr">ref</span>=<span class="hljs-string">"multipleTable"</span>
        <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData3"</span>
        <span class="hljs-attr">border</span>
        <span class="hljs-attr">tooltip-effect</span>=<span class="hljs-string">"dark"</span>
        <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>
        <span class="hljs-attr">@selection-change</span>=<span class="hljs-string">"handleSelectionChange"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">type</span>=<span class="hljs-string">"selection"</span>
          <span class="hljs-attr">width</span>=<span class="hljs-string">"55"</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
          <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span><span>{{</span> scope.row.date <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
          <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
          <span class="hljs-attr">show-overflow-tooltip</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">style</span>=<span class="hljs-string">"margin-top: 20px"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">@click</span>=<span class="hljs-string">"toggleSelection([tableData3[1], tableData3[2]])"</span>&gt;</span>切换第二、第三行的选中状态<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">@click</span>=<span class="hljs-string">"toggleSelection()"</span>&gt;</span>取消选择<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
    
    <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
      <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
        data() {
          <span class="hljs-keyword">return</span> {
            <span class="hljs-attr">tableData3</span>: [{
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-08'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-06'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-07'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }],
            <span class="hljs-attr">multipleSelection</span>: []
          }
        },
    
        <span class="hljs-attr">methods</span>: {
          toggleSelection(rows) {
            <span class="hljs-keyword">if</span> (rows) {
              rows.forEach(<span class="hljs-function"><span class="hljs-params">row</span> =&gt;</span> {
                <span class="hljs-keyword">this</span>.$refs.multipleTable.toggleRowSelection(row);
              });
            } <span class="hljs-keyword">else</span> {
              <span class="hljs-keyword">this</span>.$refs.multipleTable.clearSelection();
            }
          },
          handleSelectionChange(val) {
            <span class="hljs-keyword">this</span>.multipleSelection = val;
          }
        }
      }
    </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
    </code></pre>
              </div>
            </div>
            <div class="demo-block-control" v-meta >
              <i class="el-icon-caret-top"></i>
              <span style="display: none;">隐藏代码</span>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  data () {
    return {
      isShowSelect:false,
      tableData3: [{
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-08',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-06',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-07',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }],
      multipleSelection: []
    }
  },

  methods: {
    toggleShowSelection() {
      this.isShowSelect=!this.isShowSelect;
    },
    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
        this.isShowSelect=!this.isShowSelect;
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val;
    }
  }

}
</script>