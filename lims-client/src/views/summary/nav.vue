<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="6">
                <img class="nav-img" width="100%" src="~assets/image/nav.png" alt="">
            </el-col>
            <el-col :span="18">
                <div class="meta">
                    <div class="description">
                        <p>导航栏组件说明<br/><br/>
                            <code>$store.sidebar.opened</code>标识侧边栏状态<br/>
                            <code>$store.dispatch('ToggleSideBar')</code>控制侧边栏打开收起<br/>
                            <code>router/index</code>文件里的 <code>asyncRouterMap</code> 变量是生成侧边栏的源数据<br/>
                            <code>layout/Sidebar,SidebarItem</code>侧边栏代码<br/>
                        </p>

                    </div>
                    <div class="highlight">
                        <!--<div class="app-wrapper" :class="{hideSidebar:!sidebar.opened,hideBadge:sidebar.opened}">-->
                        <!--<header-bar></header-bar>-->
                        <!--<div class="sidebar-wrapper" @mouseover="mouseover()"-->
                        <!--@mouseout="mouseout()" :class="{'slider-hover':ifHover}">-->
                        <!--<sidebar class="sidebar-container"></sidebar>-->
                        <!--</div>-->
                        <!--<div class="main-container">-->
                        <!--<app-main></app-main>-->
                        <!--</div>-->
                        <!--</div>-->
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
      <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
          <span class="hljs-attr">plain</span>
          <span class="hljs-attr">@click</span>=<span class="hljs-string">"open"</span>&gt;</span>
          可自动关闭
        <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
          <span class="hljs-attr">plain</span>
          <span class="hljs-attr">@click</span>=<span class="hljs-string">"open2"</span>&gt;</span>
          不会自动关闭
      <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>

  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      <span class="hljs-attr">methods</span>: {
        open() {
          <span class="hljs-keyword">const</span> h = <span class="hljs-keyword">this</span>.$createElement;

          <span class="hljs-keyword">this</span>.$notify({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'标题名称'</span>,
            <span class="hljs-attr">message</span>: h(<span class="hljs-string">'i'</span>, { <span class="hljs-attr">style</span>: <span
                          class="hljs-string">'color: teal'</span>}, <span class="hljs-string">'这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案'</span>)
          });
        },

        open2() {
          <span class="hljs-keyword">this</span>.$notify({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'提示'</span>,
            <span class="hljs-attr">message</span>: <span class="hljs-string">'这是一条不会自动关闭的消息'</span>,
            <span class="hljs-attr">duration</span>: <span class="hljs-number">0</span>
          });
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
                    </div>
                </div>

            </el-col>
        </el-row>

    </div>
</template>

<script>

    export default {
        data() {
            return {}
        }
    };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
    .nav-img{
        margin: 20px;
    }
</style>