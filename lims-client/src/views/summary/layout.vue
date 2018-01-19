<template>
  <div class='page-container page-component'>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-18">
      <section class="content">
        <h2 id="layout-bu-ju">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#layout-bu-ju" aria-hidden="true" class="header-anchor"></a> Layout 布局</h2>
        <p>通过基础的 24 分栏，迅速简便地创建布局。</p>
        <h3 id="ji-chu-bu-ju">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#ji-chu-bu-ju" aria-hidden="true" class="header-anchor"></a> 基础布局</h3>
        <p>使用单一分栏创建基础的栅格布局。</p>
        <div class="demo-block demo-box demo-zh-CN demo-layout">
          <div class="source">
            <div class="el-row">
              <div class="el-col el-col-24">
                <div class="grid-content bg-purple-dark"></div>
              </div>
            </div>
            <div class="el-row">
              <div class="el-col el-col-12">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-12">
                <div class="grid-content bg-purple-light"></div>
              </div>
            </div>
            <div class="el-row">
              <div class="el-col el-col-8">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-8">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-8">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="el-row">
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
            </div>
            <div class="el-row">
              <div class="el-col el-col-4">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-4">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-4">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-4">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-4">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-4">
                <div class="grid-content bg-purple-light"></div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 1207px;">
            <div class="description">
              <p>通过 row 和 col 组件，并通过 col 组件的
                <code>span</code> 属性我们就可以自由地组合布局。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-row</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"24"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-dark"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"12"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"12"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"8"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"8"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"8"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="undefined">
    .el-row {
      margin-bottom: 20px;
      &amp;:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 36px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="fen-lan-jian-ge">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#fen-lan-jian-ge" aria-hidden="true" class="header-anchor"></a> 分栏间隔</h3>
        <p>分栏之间存在间隔。</p>
        <div class="demo-block demo-box demo-zh-CN demo-layout">
          <div class="source">
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 787px;">
            <div class="description">
              <p>Row 组件 提供
                <code>gutter</code> 属性来指定每一栏之间的间隔，默认间隔为 0。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="undefined">
    .el-row {
      margin-bottom: 20px;
      &amp;:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 36px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="hun-he-bu-ju">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#hun-he-bu-ju" aria-hidden="true" class="header-anchor"></a> 混合布局</h3>
        <p>通过基础的 1/24 分栏任意扩展组合形成较为复杂的混合布局。</p>
        <div class="demo-block demo-box demo-zh-CN demo-layout">
          <div class="source">
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-16" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-8" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-8" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-8" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-4" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-4" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-4" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-16" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-4" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 976px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"16"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"8"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"8"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"8"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"16"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"4"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="undefined">
    .el-row {
      margin-bottom: 20px;
      &amp;:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 36px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="fen-lan-pian-yi">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#fen-lan-pian-yi" aria-hidden="true" class="header-anchor"></a> 分栏偏移</h3>
        <p>支持偏移指定的栏数。</p>
        <div class="demo-block demo-box demo-zh-CN demo-layout">
          <div class="source">
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6 el-col-offset-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-6 el-col-offset-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6 el-col-offset-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
              <div class="el-col el-col-12 el-col-offset-6" style="padding-left: 10px; padding-right: 10px;">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 892px;">
            <div class="description">
              <p>通过制定 col 组件的
                <code>offset</code> 属性可以指定分栏偏移的栏数。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:offset</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:offset</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:offset</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"20"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"12"</span> <span class="hljs-attr">:offset</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="undefined">
    .el-row {
      margin-bottom: 20px;
      &amp;:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 36px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="dui-qi-fang-shi">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#dui-qi-fang-shi" aria-hidden="true" class="header-anchor"></a> 对齐方式</h3>
        <p>通过
          <code>flex</code> 布局来对分栏进行灵活的对齐。</p>
        <div class="demo-block demo-box demo-zh-CN demo-layout">
          <div class="source">
            <div class="row-bg el-row el-row--flex">
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="row-bg el-row is-justify-center el-row--flex">
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="row-bg el-row is-justify-end el-row--flex">
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="row-bg el-row is-justify-space-between el-row--flex">
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
            <div class="row-bg el-row is-justify-space-around el-row--flex">
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-6">
                <div class="grid-content bg-purple"></div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 1186px;">
            <div class="description">
              <p>将
                <code>type</code> 属性赋值为 'flex'，可以启用 flex 布局，并可通过
                <code>justify</code> 属性来指定 start, center, end, space-between, space-around 其中的值来定义子元素的排版方式。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"flex"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"row-bg"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"flex"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"row-bg"</span> <span class="hljs-attr">justify</span>=<span class="hljs-string">"center"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"flex"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"row-bg"</span> <span class="hljs-attr">justify</span>=<span class="hljs-string">"end"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"flex"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"row-bg"</span> <span class="hljs-attr">justify</span>=<span class="hljs-string">"space-between"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"flex"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"row-bg"</span> <span class="hljs-attr">justify</span>=<span class="hljs-string">"space-around"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:span</span>=<span class="hljs-string">"6"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="undefined">
    .el-row {
      margin-bottom: 20px;
      &amp;:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 36px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="xiang-ying-shi-bu-ju">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#xiang-ying-shi-bu-ju" aria-hidden="true" class="header-anchor"></a> 响应式布局</h3>
        <p>参照了 Bootstrap 的 响应式设计，预设了四个响应尺寸：
          <code>xs</code>、
          <code>sm</code>、
          <code>md</code>和
          <code>lg</code>。</p>
        <div class="demo-block demo-box demo-zh-CN demo-layout">
          <div class="source">
            <div class="el-row" style="margin-left: -5px; margin-right: -5px;">
              <div class="el-col el-col-24 el-col-xs-8 el-col-sm-6 el-col-md-4 el-col-lg-3" style="padding-left: 5px; padding-right: 5px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-24 el-col-xs-4 el-col-sm-6 el-col-md-8 el-col-lg-9" style="padding-left: 5px; padding-right: 5px;">
                <div class="grid-content bg-purple-light"></div>
              </div>
              <div class="el-col el-col-24 el-col-xs-4 el-col-sm-6 el-col-md-8 el-col-lg-9" style="padding-left: 5px; padding-right: 5px;">
                <div class="grid-content bg-purple"></div>
              </div>
              <div class="el-col el-col-24 el-col-xs-8 el-col-sm-6 el-col-md-4 el-col-lg-3" style="padding-left: 5px; padding-right: 5px;">
                <div class="grid-content bg-purple-light"></div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 577px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-row</span> <span class="hljs-attr">:gutter</span>=<span class="hljs-string">"10"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:xs</span>=<span class="hljs-string">"8"</span> <span class="hljs-attr">:sm</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:md</span>=<span class="hljs-string">"4"</span> <span class="hljs-attr">:lg</span>=<span class="hljs-string">"3"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:xs</span>=<span class="hljs-string">"4"</span> <span class="hljs-attr">:sm</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:md</span>=<span class="hljs-string">"8"</span> <span class="hljs-attr">:lg</span>=<span class="hljs-string">"9"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:xs</span>=<span class="hljs-string">"4"</span> <span class="hljs-attr">:sm</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:md</span>=<span class="hljs-string">"8"</span> <span class="hljs-attr">:lg</span>=<span class="hljs-string">"9"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-col</span> <span class="hljs-attr">:xs</span>=<span class="hljs-string">"8"</span> <span class="hljs-attr">:sm</span>=<span class="hljs-string">"6"</span> <span class="hljs-attr">:md</span>=<span class="hljs-string">"4"</span> <span class="hljs-attr">:lg</span>=<span class="hljs-string">"3"</span>&gt;</span><span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"grid-content bg-purple-light"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">el-col</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-row</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="css">
    <span class="hljs-selector-class">.el-col</span> {
      <span class="hljs-attribute">border-radius</span>: <span class="hljs-number">4px</span>;
    }
    <span class="hljs-selector-class">.bg-purple-dark</span> {
      <span class="hljs-attribute">background</span>: <span class="hljs-number">#99a9bf</span>;
    }
    <span class="hljs-selector-class">.bg-purple</span> {
      <span class="hljs-attribute">background</span>: <span class="hljs-number">#d3dce6</span>;
    }
    <span class="hljs-selector-class">.bg-purple-light</span> {
      <span class="hljs-attribute">background</span>: <span class="hljs-number">#e5e9f2</span>;
    }
    <span class="hljs-selector-class">.grid-content</span> {
      <span class="hljs-attribute">border-radius</span>: <span class="hljs-number">4px</span>;
      <span class="hljs-attribute">min-height</span>: <span class="hljs-number">36px</span>;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="row-attributes">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#row-attributes" aria-hidden="true" class="header-anchor"></a> Row Attributes</h3>
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
              <td>gutter</td>
              <td>栅格间隔</td>
              <td>number</td>
              <td>—</td>
              <td>0</td>
            </tr>
            <tr>
              <td>type</td>
              <td>布局模式，可选 flex，现代浏览器下有效</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>justify</td>
              <td>flex 布局下的水平排列方式</td>
              <td>string</td>
              <td>start/end/center/space-around/space-between</td>
              <td>start</td>
            </tr>
            <tr>
              <td>align</td>
              <td>flex 布局下的垂直排列方式</td>
              <td>string</td>
              <td>top/middle/bottom</td>
              <td>top</td>
            </tr>
            <tr>
              <td>tag</td>
              <td>自定义元素标签</td>
              <td>string</td>
              <td>*</td>
              <td>div</td>
            </tr>
          </tbody>
        </table>
        <h3 id="col-attributes">
          <a href="http://element.eleme.io/#/zh-CN/component/layout#col-attributes" aria-hidden="true" class="header-anchor"></a> Col Attributes</h3>
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
              <td>span</td>
              <td>栅格占据的列数</td>
              <td>number</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>offset</td>
              <td>栅格左侧的间隔格数</td>
              <td>number</td>
              <td>—</td>
              <td>0</td>
            </tr>
            <tr>
              <td>push</td>
              <td>栅格向右移动格数</td>
              <td>number</td>
              <td>—</td>
              <td>0</td>
            </tr>
            <tr>
              <td>pull</td>
              <td>栅格向左移动格数</td>
              <td>number</td>
              <td>—</td>
              <td>0</td>
            </tr>
            <tr>
              <td>xs</td>
              <td>
                <code>&lt;768px</code> 响应式栅格数或者栅格属性对象</td>
              <td>number/object (例如： {span: 4, offset: 4})</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>sm</td>
              <td>
                <code>≥768px</code> 响应式栅格数或者栅格属性对象</td>
              <td>number/object (例如： {span: 4, offset: 4})</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>md</td>
              <td>
                <code>≥992</code> 响应式栅格数或者栅格属性对象</td>
              <td>number/object (例如： {span: 4, offset: 4})</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>lg</td>
              <td>
                <code>≥1200</code> 响应式栅格数或者栅格属性对象</td>
              <td>number/object (例如： {span: 4, offset: 4})</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>tag</td>
              <td>自定义元素标签</td>
              <td>string</td>
              <td>*</td>
              <td>div</td>
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
    }
  }
};
</script>


