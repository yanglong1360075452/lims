<template>
  <div class='page-container page-component'>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-18">
      <section class="content">
        <h2 id="notification-tong-zhi">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#notification-tong-zhi" aria-hidden="true" class="header-anchor"></a> Notification 通知</h2>
        <p>悬浮出现在页面右上角，显示全局的通知提醒消息。</p>
        <h3 id="ji-ben-yong-fa">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#ji-ben-yong-fa" aria-hidden="true" class="header-anchor"></a> 基本用法</h3>
        <p>适用性广泛的通知栏</p>
        <div class="demo-block demo-box demo-zh-CN demo-notification">
          <div class="source">
             <el-button
    plain
    @click="open">
    可自动关闭
  </el-button>
  <el-button
    plain
    @click="open2">
    不会自动关闭
    </el-button>
          </div>
          <div class="meta" style="height: 787px;">
            <div class="description">
              <p>Notification 组件提供通知功能，Element 注册了
                <code>$notify</code>方法，接收一个
                <code>options</code>字面量参数，在最简单的情况下，你可以设置
                <code>title</code>字段和
                <code>message</code>字段，用于设置通知的标题和正文。默认情况下，经过一段时间后 Notification 组件会自动关闭，但是通过设置
                <code>duration</code>，可以控制关闭的时间间隔，特别的是，如果设置为
                <code>0</code>，则不会自动关闭。注意：
                <code>duration</code>接收一个
                <code>Number</code>，单位为毫秒，默认为
                <code>4500</code>。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
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
            <span class="hljs-attr">message</span>: h(<span class="hljs-string">'i'</span>, { <span class="hljs-attr">style</span>: <span class="hljs-string">'color: teal'</span>}, <span class="hljs-string">'这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案'</span>)
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
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="dai-you-qing-xiang-xing">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#dai-you-qing-xiang-xing" aria-hidden="true" class="header-anchor"></a> 带有倾向性</h3>
        <p>带有 icon，常用来显示「成功、警告、消息、错误」类的系统消息</p>
        <div class="demo-block demo-box demo-zh-CN demo-notification">
          <div class="source">
             <el-button
    plain
    @click="open3">
    成功
  </el-button>
  <el-button
    plain
    @click="open4">
    警告
  </el-button>
  <el-button
    plain
    @click="open5">
    消息
  </el-button>
  <el-button
    plain
    @click="open6">
    错误
  </el-button>
          </div>
          <div class="meta" style="height: 1255px;">
            <div class="description">
              <p>Element 为 Notification 组件准备了四种通知类型：
                <code>success</code>,
                <code>warning</code>,
                <code>info</code>,
                <code>error</code>。通过
                <code>type</code>字段来设置，除此以外的值将被忽略。同时，我们也为 Notification 的各种 type 注册了方法，可以在不传入
                <code>type</code>字段的情况下像
                <code>open5</code>和
                <code>open6</code>那样直接调用。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
      <span class="hljs-attr">plain</span>
      <span class="hljs-attr">@click</span>=<span class="hljs-string">"open3"</span>&gt;</span>
      成功
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
      <span class="hljs-attr">plain</span>
      <span class="hljs-attr">@click</span>=<span class="hljs-string">"open4"</span>&gt;</span>
      警告
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
      <span class="hljs-attr">plain</span>
      <span class="hljs-attr">@click</span>=<span class="hljs-string">"open5"</span>&gt;</span>
      消息
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
      <span class="hljs-attr">plain</span>
      <span class="hljs-attr">@click</span>=<span class="hljs-string">"open6"</span>&gt;</span>
      错误
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      <span class="hljs-attr">methods</span>: {
        open3() {
          <span class="hljs-keyword">this</span>.$notify({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'成功'</span>,
            <span class="hljs-attr">message</span>: <span class="hljs-string">'这是一条成功的提示消息'</span>,
            <span class="hljs-attr">type</span>: <span class="hljs-string">'success'</span>
          });
        },
  
        open4() {
          <span class="hljs-keyword">this</span>.$notify({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'警告'</span>,
            <span class="hljs-attr">message</span>: <span class="hljs-string">'这是一条警告的提示消息'</span>,
            <span class="hljs-attr">type</span>: <span class="hljs-string">'warning'</span>
          });
        },
  
        open5() {
          <span class="hljs-keyword">this</span>.$notify.info({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'消息'</span>,
            <span class="hljs-attr">message</span>: <span class="hljs-string">'这是一条消息的提示消息'</span>
          });
        },
  
        open6() {
          <span class="hljs-keyword">this</span>.$notify.error({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'错误'</span>,
            <span class="hljs-attr">message</span>: <span class="hljs-string">'这是一条错误的提示消息'</span>
          });
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
        <h3 id="dai-you-pian-yi">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#dai-you-pian-yi" aria-hidden="true" class="header-anchor"></a> 带有偏移</h3>
        <p>让 Notification 偏移一些位置</p>
        <div class="demo-block demo-box demo-zh-CN demo-notification">
          <div class="source">
             <el-button
    plain
    @click="open7">
    偏移的消息
  </el-button>
          </div>
          <div class="meta" style="height: 478px;">
            <div class="description">
              <p>Notification 提供设置偏移量的功能，通过设置
                <code>offset</code> 字段，可以使弹出的消息距屏幕顶部偏移一段距离。注意在同一时刻，所有的 Notification 实例应当具有一个相同的偏移量。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">template</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span>
      <span class="hljs-attr">plain</span>
      <span class="hljs-attr">@click</span>=<span class="hljs-string">"open7"</span>&gt;</span>
      偏移的消息
    <span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">template</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      <span class="hljs-attr">methods</span>: {
        open7() {
          <span class="hljs-keyword">this</span>.$notify.success({
            <span class="hljs-attr">title</span>: <span class="hljs-string">'成功'</span>,
            <span class="hljs-attr">message</span>: <span class="hljs-string">'这是一条成功的提示消息'</span>,
            <span class="hljs-attr">offset</span>: <span class="hljs-number">100</span>
          });
        }
      }
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="text-slide-enter-to">隐藏代码</span>
          </div>
        </div>
        <h3 id="quan-ju-fang-fa">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#quan-ju-fang-fa" aria-hidden="true" class="header-anchor"></a> 全局方法</h3>
        <p>Element 为
          <code>Vue.prototype</code> 添加了全局方法
          <code>$notify</code>。因此在 vue instance 中可以采用本页面中的方式调用 Notification。</p>
        <h3 id="dan-du-yin-yong">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#dan-du-yin-yong" aria-hidden="true" class="header-anchor"></a> 单独引用</h3>
        <p>单独引入 Notification：</p>
        <pre><code class="hljs language-javascript"><span class="hljs-keyword">import</span> { Notification } <span class="hljs-keyword">from</span> <span class="hljs-string">'element-ui'</span>;
  </code></pre>
        <p>此时调用方法为
          <code>Notification(options)</code>。我们也为每个 type 定义了各自的方法，如
          <code>Notification.success(options)</code>。</p>
        <h3 id="options">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#options" aria-hidden="true" class="header-anchor"></a> Options</h3>
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
              <td>title</td>
              <td>标题</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>message</td>
              <td>说明文字</td>
              <td>string/Vue.VNode</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>type</td>
              <td>主题样式，如果不在可选值内将被忽略</td>
              <td>string</td>
              <td>success/warning/info/error</td>
              <td>—</td>
            </tr>
            <tr>
              <td>iconClass</td>
              <td>自定义图标的类名。若设置了
                <code>type</code>，则
                <code>iconClass</code> 会被覆盖</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>customClass</td>
              <td>自定义类名</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>duration</td>
              <td>显示时间, 毫秒。设为 0 则不会自动关闭</td>
              <td>number</td>
              <td>—</td>
              <td>4500</td>
            </tr>
            <tr>
              <td>onClose</td>
              <td>关闭时的回调函数</td>
              <td>function</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>onClick</td>
              <td>点击 Notification 时的回调函数</td>
              <td>function</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>offset</td>
              <td>偏移的距离，在同一时刻，所有的 Notification 实例应当具有一个相同的偏移量</td>
              <td>number</td>
              <td>—</td>
              <td>0</td>
            </tr>
          </tbody>
        </table>
        <h3 id="fang-fa">
          <a href="http://element.eleme.io/#/zh-CN/component/notification#fang-fa" aria-hidden="true" class="header-anchor"></a> 方法</h3>
        <p>调用
          <code>Notification</code> 或
          <code>this.$notify</code> 会返回当前 Notification 的实例。如果需要手动关闭实例，可以调用它的
          <code>close</code> 方法。</p>
        <table class="table">
          <thead>
            <tr>
              <th>方法名</th>
              <th>说明</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>close</td>
              <td>关闭当前的 Notification</td>
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
  },
  methods: {
    open () {
      const h = this.$createElement;

      this.$notify({
        title: '标题名称',
        message: h('i', { style: 'color: teal' }, '这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案')
      });
    },

    open2 () {
      this.$notify({
        title: '提示',
        message: '这是一条不会自动关闭的消息',
        duration: 0
      });
    },
    open3 () {
      this.$notify({
        title: '成功',
        message: '这是一条成功的提示消息',
        type: 'success'
      });
    },

    open4 () {
      this.$notify({
        title: '警告',
        message: '这是一条警告的提示消息',
        type: 'warning'
      });
    },

    open5 () {
      this.$notify.info({
        title: '消息',
        message: '这是一条消息的提示消息'
      });
    },

    open6 () {
      this.$notify.error({
        title: '错误',
        message: '这是一条错误的提示消息'
      });
    },
    open7 () {
      this.$notify.success({
        title: '成功',
        message: '这是一条成功的提示消息',
        offset: 100
      });
    }
  }
};
</script>