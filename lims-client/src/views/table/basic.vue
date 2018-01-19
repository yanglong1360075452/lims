<template>
  <div class='page-container page-component'>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-18">
      <section class="content">
        <h2 id="table-biao-ge">
          <a href="http://element.eleme.io/#/zh-CN/component/table#table-biao-ge" aria-hidden="true" class="header-anchor"></a> Table 表格</h2>
        <p>用于展示多条结构类似的数据，可对数据进行排序、筛选、对比或其他自定义操作。</p>
        <h3 id="ji-chu-biao-ge">
          <a href="http://element.eleme.io/#/zh-CN/component/table#ji-chu-biao-ge" aria-hidden="true" class="header-anchor"></a> 基础表格</h3>
        <p>基础的表格展示用法。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="date"
        label="日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
    </el-table>
          </div>
          <div class="meta" style="height: 1003px;">
            <div class="description">
              <p>当
                <code>el-table</code>元素中注入
                <code>data</code>对象数组后，在
                <code>el-table-column</code>中用
                <code>prop</code>属性来对应对象中的键名即可填入数据，用
                <code>label</code>属性来定义表格的列名。可以使用
                <code>width</code>属性来定义列宽。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html">  <span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
        <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
        <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
          <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
          <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
    <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
      <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
        data() {
          <span class="hljs-keyword">return</span> {
            <span class="hljs-attr">tableData</span>: [{
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1517 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1519 弄'</span>
            }, {
              <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
              <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
              <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1516 弄'</span>
            }]
          }
        }
      }
    </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="dai-ban-ma-wen-biao-ge">
          <a href="http://element.eleme.io/#/zh-CN/component/table#dai-ban-ma-wen-biao-ge" aria-hidden="true" class="header-anchor"></a> 带斑马纹表格</h3>
        <p>使用带斑马纹的表格，可以更容易区分出不同行的数据。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1024px;">
            <div class="description">
              <p>
                <code>stripe</code>属性可以创建带斑马纹的表格。它接受一个
                <code>Boolean</code>，默认为
                <code>false</code>，设置为
                <code>true</code>即为启用。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
      <span class="hljs-attr">stripe</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1517 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1519 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1516 弄'</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="dai-bian-kuang-biao-ge">
          <a href="http://element.eleme.io/#/zh-CN/component/table#dai-bian-kuang-biao-ge" aria-hidden="true" class="header-anchor"></a> 带边框表格</h3>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1024px;">
            <div class="description">
              <p>默认情况下，Table 组件是不具有竖直方向的边框的，如果需要，可以使用
                <code>border</code>属性，它接受一个
                <code>Boolean</code>，设置为
                <code>true</code>即可启用。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1517 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1519 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1516 弄'</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="dai-zhuang-tai-biao-ge">
          <a href="http://element.eleme.io/#/zh-CN/component/table#dai-zhuang-tai-biao-ge" aria-hidden="true" class="header-anchor"></a> 带状态表格</h3>
        <p>可将表格内容 highlight 显示，方便区分「成功、信息、警告、危险」等内容。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
             <el-table
    :data="tableData2"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1444px;">
            <div class="description">
              <p>可以通过指定 Table 组件的
                <code>row-class-name</code> 属性来为 Table 中的某一行添加 class，表明该行处于某种状态。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData2"</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>
      <span class="hljs-attr">:row-class-name</span>=<span class="hljs-string">"tableRowClassName"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="css">
    <span class="hljs-selector-class">.el-table</span> <span class="hljs-selector-class">.info-row</span> {
      <span class="hljs-attribute">background</span>: <span class="hljs-number">#c9e5f5</span>;
    }
  
    <span class="hljs-selector-class">.el-table</span> <span class="hljs-selector-class">.positive-row</span> {
      <span class="hljs-attribute">background</span>: <span class="hljs-number">#e2f0e4</span>;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      <span class="hljs-attr">methods</span>: {
        tableRowClassName(row, index) {
          <span class="hljs-keyword">if</span> (index === <span class="hljs-number">1</span>) {
            <span class="hljs-keyword">return</span> <span class="hljs-string">'info-row'</span>;
          } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (index === <span class="hljs-number">3</span>) {
            <span class="hljs-keyword">return</span> <span class="hljs-string">'positive-row'</span>;
          }
          <span class="hljs-keyword">return</span> <span class="hljs-string">''</span>;
        }
      },
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData2</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="gu-ding-biao-tou">
          <a href="http://element.eleme.io/#/zh-CN/component/table#gu-ding-biao-tou" aria-hidden="true" class="header-anchor"></a> 固定表头</h3>
        <p>纵向内容过多时，可选择固定表头。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
             <el-table
    :data="tableData3"
    height="250"
    border
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1297px;">
            <div class="description">
              <p>只要在
                <code>el-table</code>元素中定义了
                <code>height</code>属性，即可实现固定表头的表格，而不需要额外的代码。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData3"</span>
      <span class="hljs-attr">height</span>=<span class="hljs-string">"250"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
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
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="gu-ding-lie">
          <a href="http://element.eleme.io/#/zh-CN/component/table#gu-ding-lie" aria-hidden="true" class="header-anchor"></a> 固定列</h3>
        <p>横向内容过多时，可选择固定列。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
           <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="province"
      label="省份"
      width="120">
    </el-table-column>
    <el-table-column
      prop="city"
      label="市区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="300">
    </el-table-column>
    <el-table-column
      prop="zip"
      label="邮编"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template scope="scope">
        <el-button @click="handleClick" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1963px;">
            <div class="description">
              <p>固定列需要使用
                <code>fixed</code>属性，它接受 Boolean 值或者
                <code>left</code>
                <code>right</code>，表示左边固定还是右边固定。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">fixed</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"150"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"province"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"省份"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"city"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"市区"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"300"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"zip"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"邮编"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">fixed</span>=<span class="hljs-string">"right"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"操作"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"100"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">@click</span>=<span class="hljs-string">"handleClick"</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"text"</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span>&gt;</span>查看<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"text"</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span>&gt;</span>编辑<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      <span class="hljs-attr">methods</span>: {
        handleClick() {
          <span class="hljs-built_in">console</span>.log(<span class="hljs-number">1</span>);
        }
      },
  
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="gu-ding-lie-he-biao-tou">
          <a href="http://element.eleme.io/#/zh-CN/component/table#gu-ding-lie-he-biao-tou" aria-hidden="true" class="header-anchor"></a> 固定列和表头</h3>
        <p>横纵内容过多时，可选择固定列和表头。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData3"
    border
    style="width: 100%"
    height="250">
    <el-table-column
      fixed
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="province"
      label="省份"
      width="120">
    </el-table-column>
    <el-table-column
      prop="city"
      label="市区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="300">
    </el-table-column>
    <el-table-column
      prop="zip"
      label="邮编"
      width="120">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 2095px;">
            <div class="description">
              <p>固定列和表头可以同时使用，只需要将上述两个属性分别设置好即可。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData3"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>
      <span class="hljs-attr">height</span>=<span class="hljs-string">"250"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">fixed</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"150"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"province"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"省份"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"city"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"市区"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"300"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"zip"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"邮编"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData3</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-08'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-06'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-07'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="liu-ti-gao-du">
          <a href="http://element.eleme.io/#/zh-CN/component/table#liu-ti-gao-du" aria-hidden="true" class="header-anchor"></a> 流体高度</h3>
        <p>当数据量动态变化时，可以为 Table 设置一个最大高度。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData4"
    border
    style="width: 100%"
    max-height="250">
    <el-table-column
      fixed
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="province"
      label="省份"
      width="120">
    </el-table-column>
    <el-table-column
      prop="city"
      label="市区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="300">
    </el-table-column>
    <el-table-column
      prop="zip"
      label="邮编"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template scope="scope">
        <el-button
          @click.native.prevent="deleteRow(scope.$index, tableData4)"
          type="text"
          size="small">
          移除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 2488px;">
            <div class="description">
              <p>通过设置
                <code>max-height</code>属性为 Table 指定最大高度。此时若表格所需的高度大于最大高度，则会显示一个滚动条。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData4"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>
      <span class="hljs-attr">max-height</span>=<span class="hljs-string">"250"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">fixed</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"150"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"province"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"省份"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"city"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"市区"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"300"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"zip"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"邮编"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">fixed</span>=<span class="hljs-string">"right"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"操作"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
            <span class="hljs-attr">@click.native.prevent</span>=<span class="hljs-string">"deleteRow(scope.$index, tableData4)"</span>
            <span class="hljs-attr">type</span>=<span class="hljs-string">"text"</span>
            <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span>&gt;</span>
            移除
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      <span class="hljs-attr">methods</span>: {
        deleteRow(index, rows) {
          rows.splice(index, <span class="hljs-number">1</span>);
        }
      },
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData4</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-08'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-06'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-07'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="duo-ji-biao-tou">
          <a href="http://element.eleme.io/#/zh-CN/component/table#duo-ji-biao-tou" aria-hidden="true" class="header-anchor"></a> 多级表头</h3>
        <p>数据结构比较复杂的时候，可使用多级表头来展现数据的层次关系。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData3"
    border
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column label="配送信息">
      <el-table-column
        prop="name"
        label="姓名"
        width="120">
      </el-table-column>
      <el-table-column label="地址">
        <el-table-column
          prop="province"
          label="省份"
          width="120">
        </el-table-column>
        <el-table-column
          prop="city"
          label="市区"
          width="120">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址"
          width="300">
        </el-table-column>
        <el-table-column
          prop="zip"
          label="邮编"
          width="120">
        </el-table-column>
      </el-table-column>
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 2137px;">
            <div class="description">
              <p>只需要在 el-table-column 里面嵌套 el-table-column，就可以实现多级表头。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData3"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"150"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"配送信息"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
          <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
          <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
          <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
            <span class="hljs-attr">prop</span>=<span class="hljs-string">"province"</span>
            <span class="hljs-attr">label</span>=<span class="hljs-string">"省份"</span>
            <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
            <span class="hljs-attr">prop</span>=<span class="hljs-string">"city"</span>
            <span class="hljs-attr">label</span>=<span class="hljs-string">"市区"</span>
            <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
            <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
            <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
            <span class="hljs-attr">width</span>=<span class="hljs-string">"300"</span>&gt;</span>
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
            <span class="hljs-attr">prop</span>=<span class="hljs-string">"zip"</span>
            <span class="hljs-attr">label</span>=<span class="hljs-string">"邮编"</span>
            <span class="hljs-attr">width</span>=<span class="hljs-string">"120"</span>&gt;</span>
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData3</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-08'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-06'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-07'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">province</span>: <span class="hljs-string">'上海'</span>,
            <span class="hljs-attr">city</span>: <span class="hljs-string">'普陀区'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">zip</span>: <span class="hljs-number">200333</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="pai-xu">
          <a href="http://element.eleme.io/#/zh-CN/component/table#pai-xu" aria-hidden="true" class="header-anchor"></a> 排序</h3>
        <p>对表格进行排序，可快速查找或对比数据。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData"
    border
    style="width: 100%"
    :default-sort = "{prop: 'date', order: 'descending'}"
    >
    <el-table-column
      prop="date"
      label="日期"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      :formatter="formatter">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1234px;">
            <div class="description">
              <p>在列中设置
                <code>sortable</code>属性即可实现以该列为基准的排序，接受一个
                <code>Boolean</code>，默认为
                <code>false</code>。可以通过 Table 的
                <code>default-sort</code>属性设置默认的排序列和排序顺序。可以使用
                <code>sort-method</code>使用自定义的排序规则。如果需要后端排序，需将
                <code>sortable</code>设置为
                <code>custom</code>，同时在 Table 上监听
                <code>sort-change</code>事件，在事件回调中可以获取当前排序的字段名和排序顺序，从而向接口请求排序后的表格数据。在本例中，我们还使用了
                <code>formatter</code>属性，它用于格式化指定列的值，接受一个
                <code>Function</code>，会传入两个参数：
                <code>row</code>和
                <code>column</code>，可以根据自己的需求进行处理。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>
      <span class="hljs-attr">:default-sort</span> = <span class="hljs-string">"{prop: 'date', order: 'descending'}"</span>
      &gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">sortable</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">sortable</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
        <span class="hljs-attr">:formatter</span>=<span class="hljs-string">"formatter"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1517 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1519 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1516 弄'</span>
          }]
        }
      },
      <span class="hljs-attr">methods</span>: {
        formatter(row, column) {
          <span class="hljs-keyword">return</span> row.address;
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="shai-xuan">
          <a href="http://element.eleme.io/#/zh-CN/component/table#shai-xuan" aria-hidden="true" class="header-anchor"></a> 筛选</h3>
        <p>对表格进行筛选，可快速查找到自己想看的数据。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      :formatter="formatter">
    </el-table-column>
    <el-table-column
      prop="tag"
      label="标签"
      width="100"
      :filters="[{ text: '家', value: '家' }, { text: '公司', value: '公司' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template scope="scope">
        <el-tag
          :type="scope.row.tag === '家' ? 'primary' : 'success'"
          close-transition>{{scope.row.tag}}</el-tag>
      </template>
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1606px;">
            <div class="description">
              <p>在列中设置
                <code>filters</code>
                <code>filter-method</code>属性即可开启该列的筛选，filters 是一个数组，
                <code>filter-method</code>是一个方法，它用于决定某些数据是否显示，会传入两个参数：
                <code>value</code>和
                <code>row</code>。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"date"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">sortable</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"address"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"地址"</span>
        <span class="hljs-attr">:formatter</span>=<span class="hljs-string">"formatter"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"tag"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"标签"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"100"</span>
        <span class="hljs-attr">:filters</span>=<span class="hljs-string">"[{ text: '家', value: '家' }, { text: '公司', value: '公司' }]"</span>
        <span class="hljs-attr">:filter-method</span>=<span class="hljs-string">"filterTag"</span>
        <span class="hljs-attr">filter-placement</span>=<span class="hljs-string">"bottom-end"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-tag</span>
            <span class="hljs-attr">:type</span>=<span class="hljs-string">"scope.row.tag === '家' ? 'primary' : 'success'"</span>
            <span class="hljs-attr">close-transition</span>&gt;</span><span>{{</span>scope.row.tag<span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-tag</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>,
            <span class="hljs-attr">tag</span>: <span class="hljs-string">'家'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1517 弄'</span>,
            <span class="hljs-attr">tag</span>: <span class="hljs-string">'公司'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1519 弄'</span>,
            <span class="hljs-attr">tag</span>: <span class="hljs-string">'家'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1516 弄'</span>,
            <span class="hljs-attr">tag</span>: <span class="hljs-string">'公司'</span>
          }]
        }
      },
      <span class="hljs-attr">methods</span>: {
        formatter(row, column) {
          <span class="hljs-keyword">return</span> row.address;
        },
        filterTag(value, row) {
          <span class="hljs-keyword">return</span> row.tag === value;
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="zi-ding-yi-lie-mo-ban">
          <a href="http://element.eleme.io/#/zh-CN/component/table#zi-ding-yi-lie-mo-ban" aria-hidden="true" class="header-anchor"></a> 自定义列模板</h3>
        <p>自定义列的显示内容，可组合其他组件使用。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      label="日期"
      width="180">
      <template scope="scope">
        <el-icon name="time"></el-icon>
        <span style="margin-left: 10px">{{ scope.row.date }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="姓名"
      width="180">
      <template scope="scope">
        <el-popover trigger="hover" placement="top">
          <p>姓名: {{ scope.row.name }}</p>
          <p>住址: {{ scope.row.address }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag>{{ scope.row.name }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template scope="scope">
        <el-button
          size="small"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 1585px;">
            <div class="description">
              <p>通过
                <code>Scoped slot</code> 可以获取到 row, column, $index 和 store（table 内部的状态管理）的数据，用法参考 demo。(
                <code>1.1</code> 后支持通过
                <a href="https://vuejs.org/v2/guide/components.html#Scoped-Slots">Scoped slot</a> 自定义模板。之前的
                <code>inline-template</code> 同样适用，但不推荐。)</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"日期"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-icon</span> <span class="hljs-attr">name</span>=<span class="hljs-string">"time"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-icon</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">span</span> <span class="hljs-attr">style</span>=<span class="hljs-string">"margin-left: 10px"</span>&gt;</span><span>{{</span> scope.row.date <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-popover</span> <span class="hljs-attr">trigger</span>=<span class="hljs-string">"hover"</span> <span class="hljs-attr">placement</span>=<span class="hljs-string">"top"</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">p</span>&gt;</span>姓名: <span>{{</span> scope.row.name <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">p</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">p</span>&gt;</span>住址: <span>{{</span> scope.row.address <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">p</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"reference"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"name-wrapper"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">el-tag</span>&gt;</span><span>{{</span> scope.row.name <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-tag</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-popover</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"操作"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"scope"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
            <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span>
            <span class="hljs-attr">@click</span>=<span class="hljs-string">"handleEdit(scope.$index, scope.row)"</span>&gt;</span>编辑<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
            <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span>
            <span class="hljs-attr">type</span>=<span class="hljs-string">"danger"</span>
            <span class="hljs-attr">@click</span>=<span class="hljs-string">"handleDelete(scope.$index, scope.row)"</span>&gt;</span>删除<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData</span>: [{
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-02'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1518 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-04'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1517 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-01'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1519 弄'</span>
          }, {
            <span class="hljs-attr">date</span>: <span class="hljs-string">'2016-05-03'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区金沙江路 1516 弄'</span>
          }]
        }
      },
      <span class="hljs-attr">methods</span>: {
        handleEdit(index, row) {
          <span class="hljs-built_in">console</span>.log(index, row);
        },
        handleDelete(index, row) {
          <span class="hljs-built_in">console</span>.log(index, row);
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="zhan-kai-xing">
          <a href="http://element.eleme.io/#/zh-CN/component/table#zhan-kai-xing" aria-hidden="true" class="header-anchor"></a> 展开行</h3>
        <p>当行内容过多并且不想显示横向滚动条时，可以使用 Table 展开行功能。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData5"
    style="width: 100%">
    <el-table-column type="expand">
      <template scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="商品名称">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="所属店铺">
            <span>{{ props.row.shop }}</span>
          </el-form-item>
          <el-form-item label="商品 ID">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="店铺 ID">
            <span>{{ props.row.shopId }}</span>
          </el-form-item>
          <el-form-item label="商品分类">
            <span>{{ props.row.category }}</span>
          </el-form-item>
          <el-form-item label="店铺地址">
            <span>{{ props.row.address }}</span>
          </el-form-item>
          <el-form-item label="商品描述">
            <span>{{ props.row.desc }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="商品 ID"
      prop="id">
    </el-table-column>
    <el-table-column
      label="商品名称"
      prop="name">
    </el-table-column>
    <el-table-column
      label="描述"
      prop="desc">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 2194px;">
            <div class="description">
              <p>通过设置 type="expand" 和
                <code>Scoped slot</code> 可以开启展开行功能，
                <code>el-table-column</code> 的模板会被渲染成为展开行的内容，展开行可访问的属性与使用自定义列模板时的
                <code>Scoped slot</code> 相同。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData5"</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"expand"</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">template</span> <span class="hljs-attr">scope</span>=<span class="hljs-string">"props"</span>&gt;</span>
          <span class="hljs-tag">&lt;<span class="hljs-name">el-form</span> <span class="hljs-attr">label-position</span>=<span class="hljs-string">"left"</span> <span class="hljs-attr">inline</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"demo-table-expand"</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"商品名称"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.name <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"所属店铺"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.shop <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"商品 ID"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.id <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"店铺 ID"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.shopId <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"商品分类"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.category <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"店铺地址"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.address <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">el-form-item</span> <span class="hljs-attr">label</span>=<span class="hljs-string">"商品描述"</span>&gt;</span>
              <span class="hljs-tag">&lt;<span class="hljs-name">span</span>&gt;</span><span>{{</span> props.row.desc <span>}}</span><span class="hljs-tag">&lt;/<span class="hljs-name">span</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">el-form-item</span>&gt;</span>
          <span class="hljs-tag">&lt;/<span class="hljs-name">el-form</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"商品 ID"</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"id"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"商品名称"</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"描述"</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"desc"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="css">
    <span class="hljs-selector-class">.demo-table-expand</span> {
      <span class="hljs-attribute">font-size</span>: <span class="hljs-number">0</span>;
    }
    <span class="hljs-selector-class">.demo-table-expand</span> <span class="hljs-selector-tag">label</span> {
      <span class="hljs-attribute">width</span>: <span class="hljs-number">90px</span>;
      <span class="hljs-attribute">color</span>: <span class="hljs-number">#99a9bf</span>;
    }
    <span class="hljs-selector-class">.demo-table-expand</span> <span class="hljs-selector-class">.el-form-item</span> {
      <span class="hljs-attribute">margin-right</span>: <span class="hljs-number">0</span>;
      <span class="hljs-attribute">margin-bottom</span>: <span class="hljs-number">0</span>;
      <span class="hljs-attribute">width</span>: <span class="hljs-number">50%</span>;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData5</span>: [{
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987122'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'好滋好味鸡蛋仔'</span>,
            <span class="hljs-attr">category</span>: <span class="hljs-string">'江浙小吃、小吃零食'</span>,
            <span class="hljs-attr">desc</span>: <span class="hljs-string">'荷兰优质淡奶，奶香浓而不腻'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区真北路'</span>,
            <span class="hljs-attr">shop</span>: <span class="hljs-string">'王小虎夫妻店'</span>,
            <span class="hljs-attr">shopId</span>: <span class="hljs-string">'10333'</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987123'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'好滋好味鸡蛋仔'</span>,
            <span class="hljs-attr">category</span>: <span class="hljs-string">'江浙小吃、小吃零食'</span>,
            <span class="hljs-attr">desc</span>: <span class="hljs-string">'荷兰优质淡奶，奶香浓而不腻'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区真北路'</span>,
            <span class="hljs-attr">shop</span>: <span class="hljs-string">'王小虎夫妻店'</span>,
            <span class="hljs-attr">shopId</span>: <span class="hljs-string">'10333'</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987125'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'好滋好味鸡蛋仔'</span>,
            <span class="hljs-attr">category</span>: <span class="hljs-string">'江浙小吃、小吃零食'</span>,
            <span class="hljs-attr">desc</span>: <span class="hljs-string">'荷兰优质淡奶，奶香浓而不腻'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区真北路'</span>,
            <span class="hljs-attr">shop</span>: <span class="hljs-string">'王小虎夫妻店'</span>,
            <span class="hljs-attr">shopId</span>: <span class="hljs-string">'10333'</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987126'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'好滋好味鸡蛋仔'</span>,
            <span class="hljs-attr">category</span>: <span class="hljs-string">'江浙小吃、小吃零食'</span>,
            <span class="hljs-attr">desc</span>: <span class="hljs-string">'荷兰优质淡奶，奶香浓而不腻'</span>,
            <span class="hljs-attr">address</span>: <span class="hljs-string">'上海市普陀区真北路'</span>,
            <span class="hljs-attr">shop</span>: <span class="hljs-string">'王小虎夫妻店'</span>,
            <span class="hljs-attr">shopId</span>: <span class="hljs-string">'10333'</span>
          }]
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="biao-wei-he-ji-xing">
          <a href="http://element.eleme.io/#/zh-CN/component/table#biao-wei-he-ji-xing" aria-hidden="true" class="header-anchor"></a> 表尾合计行</h3>
        <p>若表格展示的是各类数字，可以在表尾显示各列的合计。</p>
        <div class="demo-block demo-box demo-zh-CN demo-table">
          <div class="source">
            <el-table
    :data="tableData6"
    border
    show-summary
    style="width: 100%">
    <el-table-column
      prop="id"
      label="ID"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名">
    </el-table-column>
    <el-table-column
      prop="amount1"
      sortable
      label="数值 1">
    </el-table-column>
    <el-table-column
      prop="amount2"
      sortable
      label="数值 2">
    </el-table-column>
    <el-table-column
      prop="amount3"
      sortable
      label="数值 3">
    </el-table-column>
  </el-table>
  
  <el-table
    :data="tableData6"
    border
    height="200"
    :summary-method="getSummaries"
    show-summary
    style="width: 100%; margin-top: 20px">
    <el-table-column
      prop="id"
      label="ID"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名">
    </el-table-column>
    <el-table-column
      prop="amount1"
      label="数值 1（元）">
    </el-table-column>
    <el-table-column
      prop="amount2"
      label="数值 2（元）">
    </el-table-column>
    <el-table-column
      prop="amount3"
      label="数值 3（元）">
    </el-table-column>
  </el-table>
          </div>
          <div class="meta" style="height: 2782px;">
            <div class="description">
              <p>将
                <code>show-summary</code>设置为
                <code>true</code>就会在表格尾部展示合计行。默认情况下，对于合计行，第一列不进行数据求合操作，而是显示「合计」二字（可通过
                <code>sum-text</code>配置），其余列会将本列所有数值进行求合操作，并显示出来。当然，你也可以定义自己的合计逻辑。使用
                <code>summary-method</code>并传入一个方法，返回一个数组，这个数组中的各项就会显示在合计行的各列中，具体可以参考本例中的第二个表格。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData6"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">show-summary</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"id"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"ID"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"amount1"</span>
        <span class="hljs-attr">sortable</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"数值 1"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"amount2"</span>
        <span class="hljs-attr">sortable</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"数值 2"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"amount3"</span>
        <span class="hljs-attr">sortable</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"数值 3"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
    
    <span class="hljs-tag">&lt;<span class="hljs-name">el-table</span>
      <span class="hljs-attr">:data</span>=<span class="hljs-string">"tableData6"</span>
      <span class="hljs-attr">border</span>
      <span class="hljs-attr">height</span>=<span class="hljs-string">"200"</span>
      <span class="hljs-attr">:summary-method</span>=<span class="hljs-string">"getSummaries"</span>
      <span class="hljs-attr">show-summary</span>
      <span class="hljs-attr">style</span>=<span class="hljs-string">"width: 100%; margin-top: 20px"</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"id"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"ID"</span>
        <span class="hljs-attr">width</span>=<span class="hljs-string">"180"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"name"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"姓名"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"amount1"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"数值 1（元）"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"amount2"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"数值 2（元）"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-table-column</span>
        <span class="hljs-attr">prop</span>=<span class="hljs-string">"amount3"</span>
        <span class="hljs-attr">label</span>=<span class="hljs-string">"数值 3（元）"</span>&gt;</span>
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-table-column</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-table</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">tableData6</span>: [{
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987122'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">amount1</span>: <span class="hljs-string">'234'</span>,
            <span class="hljs-attr">amount2</span>: <span class="hljs-string">'3.2'</span>,
            <span class="hljs-attr">amount3</span>: <span class="hljs-number">10</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987123'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">amount1</span>: <span class="hljs-string">'165'</span>,
            <span class="hljs-attr">amount2</span>: <span class="hljs-string">'4.43'</span>,
            <span class="hljs-attr">amount3</span>: <span class="hljs-number">12</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987124'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">amount1</span>: <span class="hljs-string">'324'</span>,
            <span class="hljs-attr">amount2</span>: <span class="hljs-string">'1.9'</span>,
            <span class="hljs-attr">amount3</span>: <span class="hljs-number">9</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987125'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">amount1</span>: <span class="hljs-string">'621'</span>,
            <span class="hljs-attr">amount2</span>: <span class="hljs-string">'2.2'</span>,
            <span class="hljs-attr">amount3</span>: <span class="hljs-number">17</span>
          }, {
            <span class="hljs-attr">id</span>: <span class="hljs-string">'12987126'</span>,
            <span class="hljs-attr">name</span>: <span class="hljs-string">'王小虎'</span>,
            <span class="hljs-attr">amount1</span>: <span class="hljs-string">'539'</span>,
            <span class="hljs-attr">amount2</span>: <span class="hljs-string">'4.1'</span>,
            <span class="hljs-attr">amount3</span>: <span class="hljs-number">15</span>
          }]
        };
      },
      <span class="hljs-attr">methods</span>: {
        getSummaries(param) {
          <span class="hljs-keyword">const</span> { columns, data } = param;
          <span class="hljs-keyword">const</span> sums = [];
          columns.forEach(<span class="hljs-function">(<span class="hljs-params">column, index</span>) =&gt;</span> {
            <span class="hljs-keyword">if</span> (index === <span class="hljs-number">0</span>) {
              sums[index] = <span class="hljs-string">'总价'</span>;
              <span class="hljs-keyword">return</span>;
            }
            <span class="hljs-keyword">const</span> values = data.map(<span class="hljs-function"><span class="hljs-params">item</span> =&gt;</span> <span class="hljs-built_in">Number</span>(item[column.property]));
            <span class="hljs-keyword">if</span> (!values.every(<span class="hljs-function"><span class="hljs-params">value</span> =&gt;</span> <span class="hljs-built_in">isNaN</span>(value))) {
              sums[index] = values.reduce(<span class="hljs-function">(<span class="hljs-params">prev, curr</span>) =&gt;</span> {
                <span class="hljs-keyword">const</span> value = <span class="hljs-built_in">Number</span>(curr);
                <span class="hljs-keyword">if</span> (!<span class="hljs-built_in">isNaN</span>(value)) {
                  <span class="hljs-keyword">return</span> prev + curr;
                } <span class="hljs-keyword">else</span> {
                  <span class="hljs-keyword">return</span> prev;
                }
              }, <span class="hljs-number">0</span>);
              sums[index] += <span class="hljs-string">' 元'</span>;
            } <span class="hljs-keyword">else</span> {
              sums[index] = <span class="hljs-string">'N/A'</span>;
            }
          });
  
          <span class="hljs-keyword">return</span> sums;
        }
      }
    };
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="table-attributes">
          <a href="http://element.eleme.io/#/zh-CN/component/table#table-attributes" aria-hidden="true" class="header-anchor"></a> Table Attributes</h3>
        <table class="table">
          <thead>
            <tr>
              <th>参数</th>
              <th>说明</th>
              <th>类型</th>
              <th>可选值</th>
              <th>默认值</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>data</td>
              <td>显示的数据</td>
              <td>array</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>height</td>
              <td>Table 的高度，默认为自动高度。如果 height 为 number 类型，单位 px；如果 height 为 string 类型，则 Table 的高度受控于外部样式。</td>
              <td>string/number</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>max-height</td>
              <td>Table 的最大高度</td>
              <td>string/number</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>stripe</td>
              <td>是否为斑马纹 table</td>
              <td>boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>border</td>
              <td>是否带有纵向边框</td>
              <td>boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>fit</td>
              <td>列的宽度是否自撑开</td>
              <td>boolean</td>
              <td>—</td>
              <td>true</td>
            </tr>
            <tr>
              <td>show-header</td>
              <td>是否显示表头</td>
              <td>boolean</td>
              <td>—</td>
              <td>true</td>
            </tr>
            <tr>
              <td>highlight-current-row</td>
              <td>是否要高亮当前行</td>
              <td>boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>current-row-key</td>
              <td>当前行的 key，只写属性</td>
              <td>String,Number</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>row-class-name</td>
              <td>行的 className 的回调方法，也可以使用字符串为所有行设置一个固定的 className。</td>
              <td>Function(row, index)/String</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>row-style</td>
              <td>行的 style 的回调方法，也可以使用一个固定的 Object 为所有行设置一样的 Style。</td>
              <td>Function(row, index)/Object</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>row-key</td>
              <td>行数据的 Key，用来优化 Table 的渲染；在使用 reserve-selection 功能的情况下，该属性是必填的</td>
              <td>Function(row)/String</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>empty-text</td>
              <td>空数据时显示的文本内容，也可以通过
                <code>slot="empty"</code> 设置</td>
              <td>String</td>
              <td>—</td>
              <td>暂无数据</td>
            </tr>
            <tr>
              <td>default-expand-all</td>
              <td>是否默认展开所有行，当 Table 中存在 type="expand" 的 Column 的时候有效</td>
              <td>Boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>expand-row-keys</td>
              <td>可以通过该属性设置 Table 目前的展开行，需要设置 row-key 属性才能使用，该属性为展开行的 keys 数组。</td>
              <td>Array</td>
              <td>—</td>
              <td></td>
            </tr>
            <tr>
              <td>default-sort</td>
              <td>默认的排序列的prop和顺序。它的
                <code>prop</code>属性指定默认的排序的列，
                <code>order</code>指定默认排序的顺序</td>
              <td>Object</td>
              <td>
                <code>order</code>: ascending, descending</td>
              <td>如果只指定了
                <code>prop</code>, 没有指定
                <code>order</code>, 则默认顺序是ascending</td>
            </tr>
            <tr>
              <td>tooltip-effect</td>
              <td>tooltip
                <code>effect</code> 属性</td>
              <td>String</td>
              <td>dark/light</td>
              <td></td>
            </tr>
            <tr>
              <td>show-summary</td>
              <td>是否在表尾显示合计行</td>
              <td>Boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>sum-text</td>
              <td>合计行第一列的文本</td>
              <td>String</td>
              <td>—</td>
              <td>合计</td>
            </tr>
            <tr>
              <td>summary-method</td>
              <td>自定义的合计计算方法</td>
              <td>Function({ columns, data })</td>
              <td>—</td>
              <td>—</td>
            </tr>
          </tbody>
        </table>
        <h3 id="table-events">
          <a href="http://element.eleme.io/#/zh-CN/component/table#table-events" aria-hidden="true" class="header-anchor"></a> Table Events</h3>
        <table class="table">
          <thead>
            <tr>
              <th>事件名</th>
              <th>说明</th>
              <th>参数</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>select</td>
              <td>当用户手动勾选数据行的 Checkbox 时触发的事件</td>
              <td>selection, row</td>
            </tr>
            <tr>
              <td>select-all</td>
              <td>当用户手动勾选全选 Checkbox 时触发的事件</td>
              <td>selection</td>
            </tr>
            <tr>
              <td>selection-change</td>
              <td>当选择项发生变化时会触发该事件</td>
              <td>selection</td>
            </tr>
            <tr>
              <td>cell-mouse-enter</td>
              <td>当单元格 hover 进入时会触发该事件</td>
              <td>row, column, cell, event</td>
            </tr>
            <tr>
              <td>cell-mouse-leave</td>
              <td>当单元格 hover 退出时会触发该事件</td>
              <td>row, column, cell, event</td>
            </tr>
            <tr>
              <td>cell-click</td>
              <td>当某个单元格被点击时会触发该事件</td>
              <td>row, column, cell, event</td>
            </tr>
            <tr>
              <td>cell-dblclick</td>
              <td>当某个单元格被双击击时会触发该事件</td>
              <td>row, column, cell, event</td>
            </tr>
            <tr>
              <td>row-click</td>
              <td>当某一行被点击时会触发该事件</td>
              <td>row, event, column</td>
            </tr>
            <tr>
              <td>row-contextmenu</td>
              <td>当某一行被鼠标右键点击时会触发该事件</td>
              <td>row, event</td>
            </tr>
            <tr>
              <td>row-dblclick</td>
              <td>当某一行被双击时会触发该事件</td>
              <td>row, event</td>
            </tr>
            <tr>
              <td>header-click</td>
              <td>当某一列的表头被点击时会触发该事件</td>
              <td>column, event</td>
            </tr>
            <tr>
              <td>sort-change</td>
              <td>当表格的排序条件发生变化的时候会触发该事件</td>
              <td>{ column, prop, order }</td>
            </tr>
            <tr>
              <td>filter-change</td>
              <td>当表格的筛选条件发生变化的时候会触发该事件，参数的值是一个对象，对象的 key 是 column 的 columnKey，对应的 value 为用户选择的筛选条件的数组。</td>
              <td>filters</td>
            </tr>
            <tr>
              <td>current-change</td>
              <td>当表格的当前行发生变化的时候会触发该事件，如果要高亮当前行，请打开表格的 highlight-current-row 属性</td>
              <td>currentRow, oldCurrentRow</td>
            </tr>
            <tr>
              <td>header-dragend</td>
              <td>当拖动表头改变了列的宽度的时候会触发该事件</td>
              <td>newWidth, oldWidth, column, event</td>
            </tr>
            <tr>
              <td>expand</td>
              <td>当用户对某一行展开或者关闭的上会触发该事件</td>
              <td>row, expanded</td>
            </tr>
          </tbody>
        </table>
        <h3 id="table-methods">
          <a href="http://element.eleme.io/#/zh-CN/component/table#table-methods" aria-hidden="true" class="header-anchor"></a> Table Methods</h3>
        <table class="table">
          <thead>
            <tr>
              <th>方法名</th>
              <th>说明</th>
              <th>参数</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>clearSelection</td>
              <td>用于多选表格，清空用户的选择，当使用 reserve-selection 功能的时候，可能会需要使用此方法</td>
              <td>selection</td>
            </tr>
            <tr>
              <td>toggleRowSelection</td>
              <td>用于多选表格，切换某一行的选中状态，如果使用了第二个参数，则是设置这一行选中与否（selected 为 true 则选中）</td>
              <td>row, selected</td>
            </tr>
            <tr>
              <td>setCurrentRow</td>
              <td>用于单选表格，设定某一行为选中行，如果调用时不加参数，则会取消目前高亮行的选中状态。</td>
              <td>row</td>
            </tr>
          </tbody>
        </table>
        <h3 id="table-slot">
          <a href="http://element.eleme.io/#/zh-CN/component/table#table-slot" aria-hidden="true" class="header-anchor"></a> Table Slot</h3>
        <table class="table">
          <thead>
            <tr>
              <th>name</th>
              <th>说明</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>append</td>
              <td>插入至表格最后一行之后的内容，仍然位于
                <code>&lt;tbody&gt;</code> 标签内。如果需要对表格的内容进行无限滚动操作，可能需要用到这个 slot。若表格有合计行，该 slot 会位于合计行之上。</td>
            </tr>
          </tbody>
        </table>
        <h3 id="table-column-attributes">
          <a href="http://element.eleme.io/#/zh-CN/component/table#table-column-attributes" aria-hidden="true" class="header-anchor"></a> Table-column Attributes</h3>
        <table class="table">
          <thead>
            <tr>
              <th>参数</th>
              <th>说明</th>
              <th>类型</th>
              <th>可选值</th>
              <th>默认值</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>type</td>
              <td>对应列的类型。如果设置了
                <code>selection</code> 则显示多选框；如果设置了
                <code>index</code> 则显示该行的索引（从 1 开始计算）；如果设置了 expand 则显示为一个可展开的按钮</td>
              <td>string</td>
              <td>selection/index/expand</td>
              <td>—</td>
            </tr>
            <tr>
              <td>column-key</td>
              <td>column 的 key，如果需要使用 filter-change 事件，则需要此属性标识是哪个 column 的筛选条件</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>label</td>
              <td>显示的标题</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>prop</td>
              <td>对应列内容的字段名，也可以使用 property 属性</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>width</td>
              <td>对应列的宽度</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>min-width</td>
              <td>对应列的最小宽度，与 width 的区别是 width 是固定的，min-width 会把剩余宽度按比例分配给设置了 min-width 的列</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>fixed</td>
              <td>列是否固定在左侧或者右侧，true 表示固定在左侧</td>
              <td>string, boolean</td>
              <td>true, left, right</td>
              <td>—</td>
            </tr>
            <tr>
              <td>render-header</td>
              <td>列标题 Label 区域渲染使用的 Function</td>
              <td>Function(h, { column, $index })</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>sortable</td>
              <td>对应列是否可以排序，如果设置为 'custom'，则代表用户希望远程排序，需要监听 Table 的 sort-change 事件</td>
              <td>boolean, string</td>
              <td>true, false, 'custom'</td>
              <td>false</td>
            </tr>
            <tr>
              <td>sort-method</td>
              <td>对数据进行排序的时候使用的方法，仅当 sortable 设置为 true 的时候有效，需返回一个布尔值</td>
              <td>Function(a, b)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>resizable</td>
              <td>对应列是否可以通过拖动改变宽度（需要在 el-table 上设置 border 属性为真）</td>
              <td>boolean</td>
              <td>—</td>
              <td>true</td>
            </tr>
            <tr>
              <td>formatter</td>
              <td>用来格式化内容</td>
              <td>Function(row, column)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>show-overflow-tooltip</td>
              <td>当内容过长被隐藏时显示 tooltip</td>
              <td>Boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>align</td>
              <td>对齐方式</td>
              <td>String</td>
              <td>left/center/right</td>
              <td>left</td>
            </tr>
            <tr>
              <td>header-align</td>
              <td>表头对齐方式，若不设置该项，则使用表格的对齐方式</td>
              <td>String</td>
              <td>left/center/right</td>
              <td>—</td>
            </tr>
            <tr>
              <td>class-name</td>
              <td>列的 className</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>label-class-name</td>
              <td>当前列标题的自定义类名</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>selectable</td>
              <td>仅对 type=selection 的列有效，类型为 Function，Function 的返回值用来决定这一行的 CheckBox 是否可以勾选</td>
              <td>Function(row, index)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>reserve-selection</td>
              <td>仅对 type=selection 的列有效，类型为 Boolean，为 true 则代表会保留之前数据的选项，需要配合 Table 的 clearSelection 方法使用。</td>
              <td>Boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>filters</td>
              <td>数据过滤的选项，数组格式，数组中的元素需要有 text 和 value 属性。</td>
              <td>Array[{ text, value }]</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>filter-placement</td>
              <td>过滤弹出框的定位</td>
              <td>String</td>
              <td>与 Tooltip 的
                <code>placement</code> 属性相同</td>
              <td>—</td>
            </tr>
            <tr>
              <td>filter-multiple</td>
              <td>数据过滤的选项是否多选</td>
              <td>Boolean</td>
              <td>—</td>
              <td>true</td>
            </tr>
            <tr>
              <td>filter-method</td>
              <td>数据过滤使用的方法，如果是多选的筛选项，对每一条数据会执行多次，任意一次返回 true 就会显示。</td>
              <td>Function(value, row)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>filtered-value</td>
              <td>选中的数据过滤项，如果需要自定义表头过滤的渲染方式，可能会需要此属性。</td>
              <td>Array</td>
              <td>—</td>
              <td>—</td>
            </tr>
          </tbody>
        </table>
      </section>
    </div>
  </div>
</template>

<script>

export default {
  data () {
    return {
     tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          tag: '家'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄',
          tag: '公司'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          tag: '家'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄',
          tag: '公司'
        }],
        tableData2: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
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
         tableData4: [{
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-08',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-06',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-07',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }],
         tableData5: [{
          id: '12987122',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987123',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987125',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987126',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }],
        tableData6: [{
          id: '12987122',
          name: '王小虎',
          amount1: '234',
          amount2: '3.2',
          amount3: 10
        }, {
          id: '12987123',
          name: '王小虎',
          amount1: '165',
          amount2: '4.43',
          amount3: 12
        }, {
          id: '12987124',
          name: '王小虎',
          amount1: '324',
          amount2: '1.9',
          amount3: 9
        }, {
          id: '12987125',
          name: '王小虎',
          amount1: '621',
          amount2: '2.2',
          amount3: 17
        }, {
          id: '12987126',
          name: '王小虎',
          amount1: '539',
          amount2: '4.1',
          amount3: 15
        }]
    }
  },
  methods: {
      tableRowClassName(row, index) {
        if (index === 1) {
          return 'info-row';
        } else if (index === 3) {
          return 'positive-row';
        }
        return '';
      },
      deleteRow(index, rows) {
        rows.splice(index, 1);
      },
       setCurrent(row) {
        this.$refs.singleTable.setCurrentRow(row);
      },
      handleCurrentChange(val) {
        this.currentRow = val;
      },
      formatter(row, column) {
        return row.address;
      },
       filterTag(value, row) {
        return row.tag === value;
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
       getSummaries(param) {
        const { columns, data } = param;
        const sums = [];
        columns.forEach((column, index) => {
          if (index === 0) {
            sums[index] = '总价';
            return;
          }
          const values = data.map(item => Number(item[column.property]));
          if (!values.every(value => isNaN(value))) {
            sums[index] = values.reduce((prev, curr) => {
              const value = Number(curr);
              if (!isNaN(value)) {
                return prev + curr;
              } else {
                return prev;
              }
            }, 0);
            sums[index] += ' 元';
          } else {
            sums[index] = 'N/A';
          }
        });

        return sums;
      }
    }
}
</script>
<style  rel="stylesheet/scss" lang="scss" >

  .el-table .info-row {
    background: #c9e5f5;
  }

  .el-table .positive-row {
    background: #e2f0e4;
  }
 .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>