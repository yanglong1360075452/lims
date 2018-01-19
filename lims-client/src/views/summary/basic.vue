<template>
  <div class='page-container page-component'>
    <div class="content">
      <div>
        <h2 id="color-">Color 色彩</h2>
        <p>Element 为了避免视觉传达差异，使用一套特定的调色板来规定颜色，为你所搭建的产品提供一致的外观视觉感受。</p>
        <h3 id="-">主色</h3>
        <p>Element 主要品牌颜色是鲜艳、友好的蓝色。</p>
        <div class="demo-color-row">
          <div class="demo-color-box bg-blue-light">Light Blue
            <div class="value">#58B7FF</div>
          </div>
          <div class="demo-color-box bg-blue">Blue
            <div class="value">#20A0FF</div>
          </div>
          <div class="demo-color-box bg-blue-dark">Dark Blue
            <div class="value">#1D8CE0</div>
          </div>
        </div>
  
        <h3 id="-">辅助色</h3>
        <p>除了主色外的场景色，需要在不同的场景中使用（例如危险色表示危险的操作）。</p>
        <div class="demo-color-row">
          <div class="demo-color-box bg-info">Blue
            <div class="value">#20A0FF</div>
          </div>
          <div class="demo-color-box bg-success">Success
            <div class="value">#13CE66</div>
          </div>
          <div class="demo-color-box bg-warning">Warning
            <div class="value">#F7BA2A</div>
          </div>
          <div class="demo-color-box bg-danger">Danger
            <div class="value">#FF4949</div>
          </div>
        </div>
  
        <h3 id="-">中性色</h3>
        <p>中性色用于文本、背景和边框颜色。通过运用不同的中性色，来表现层次结构。</p>
        <div class="demo-color-row">
          <div class="demo-color-box-group">
            <div class="demo-color-box bg-black">Black
              <div class="value">#1F2D3D</div>
            </div>
            <div class="demo-color-box bg-black-light">Light Black
              <div class="value">#324057</div>
            </div>
            <div class="demo-color-box bg-black-lighter">Extra Light Black
              <div class="value">#475669</div>
            </div>
          </div>
          <div class="demo-color-box-group">
            <div class="demo-color-box bg-silver">Silver
              <div class="value">#8492A6</div>
            </div>
            <div class="demo-color-box bg-silver-light">Light Silver
              <div class="value">#99A9BF</div>
            </div>
            <div class="demo-color-box bg-silver-lighter">Extra Light Silver
              <div class="value">#C0CCDA</div>
            </div>
          </div>
          <div class="demo-color-box-group">
            <div class="demo-color-box color-gray bg-gray">Gray
              <div class="value">#D3DCE6</div>
            </div>
            <div class="demo-color-box color-gray bg-gray-light">Light Gray
              <div class="value">#E5E9F2</div>
            </div>
            <div class="demo-color-box color-gray bg-gray-lighter">Extra Light Gray
              <div class="value">#EFF2F7</div>
            </div>
          </div>
          <div class="demo-color-box-group">
            <div class="demo-color-box color-gray bg-white-dark">Dark White
              <div class="value">#F9FAFC</div>
            </div>
            <div class="demo-color-box color-gray bg-white">White
              <div class="value">#FFFFFF</div>
            </div>
          </div>
        </div>
      </div>
      <div style="position: fixed; bottom: 50px; right: 30px; cursor: pointer; transition: opacity 0.2s linear 0s, visibility; opacity: 0; visibility: hidden;">
        <div class="page-component-up">
          <i class="el-icon-caret-top"></i>
        </div>
      </div>
      <div>
        <h2 id="typography-">Typography 字体</h2>
        <p>我们对字体进行统一规范，力求在各个操作系统下都有最佳展示效果。</p>
        <h3 id="-">中文字体</h3>
        <div class="demo-typo-box typo-PingFang">
          和畅惠风
          <div class="name">PingFang SC</div>
        </div>
        <div class="demo-typo-box typo-Hiragino">
          和畅惠风
          <div class="name">Hiragino Sans GB</div>
        </div>
        <div class="demo-typo-box typo-Microsoft">
          和畅惠风
          <div class="name">Microsoft YaHei</div>
        </div>
  
        <h3 id="-">英文／数字字体</h3>
        <div class="demo-typo-box typo-Helvetica-neue">
          RGag
          <div class="name">Helvetica Neue</div>
        </div>
        <div class="demo-typo-box typo-Helvetica">
          RGag
          <div class="name">Helvetica</div>
        </div>
        <div class="demo-typo-box typo-Arial">
          RGag
          <div class="name">Arial</div>
        </div>
  
        <h3 id="font-family-">Font-family 代码</h3>
        <pre class=" language-css"><code class=" language-css"><span class="token property">font-family</span><span class="token punctuation">:</span> <span class="token string">"Helvetica Neue"</span>,Helvetica,<span class="token string">"PingFang SC"</span>,<span class="token string">"Hiragino Sans GB"</span>,<span class="token string">"Microsoft YaHei"</span>,<span class="token string">"微软雅黑"</span>,Arial,sans-serif<span class="token punctuation">;</span>
  </code></pre>
        <h3 id="-">字体使用规范</h3>
        <table class="demo-typo-size">
          <tbody>
            <tr>
              <td class="h1">主标题</td>
              <td class="h1">用 Element 快速搭建页面</td>
              <td class="color-dark-light">20px Extra large</td>
            </tr>
            <tr>
              <td class="h2">标题</td>
              <td class="h2">用 Element 快速搭建页面</td>
              <td class="color-dark-light">18px large</td>
            </tr>
            <tr>
              <td class="h3">小标题</td>
              <td class="h3">用 Element 快速搭建页面</td>
              <td class="color-dark-light">16px Medium</td>
            </tr>
            <tr>
              <td class="text-regular">正文</td>
              <td class="text-regular">用 Element 快速搭建页面</td>
              <td class="color-dark-light">14px Small</td>
            </tr>
            <tr>
              <td class="text-small">正文（小）</td>
              <td class="text-small">用 Element 快速搭建页面</td>
              <td class="color-dark-light">13px Extra Small</td>
            </tr>
            <tr>
              <td class="text-smaller">辅助文字</td>
              <td class="text-smaller">用 Element 快速搭建页面</td>
              <td class="color-dark-light">12px Extra Extra Small</td>
            </tr>
          </tbody>
        </table>
      </div>
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
<style rel="stylesheet/scss" lang="scss" >
@charset "UTF-8";
* {
  margin: 0;
  padding: 0;
}

html,
body {
  height: 100%;
  -webkit-font-smoothing: antialiased;
}

body {
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "\5FAE\8F6F\96C5\9ED1", Arial, sans-serif;
  font-weight: 400;
}

.app .container {
  width: 1140px;
  padding: 0 30px;
  margin: 0 auto;
  box-sizing: border-box;
}

.app .header {
  height: 80px;
  background-color: #20a0ff;
  color: #fff;
  top: 0;
  left: 0;
  width: 100%;
  line-height: 80px;
  position: relative;
}

.app .header h1 {
  position: relative;
  margin: 0;
  float: left;
  font-size: 32px;
  font-weight: 400;
}

.app .header h1:after {
  position: absolute;
  top: -7px;
  right: -50px;
  content: 'React';
  font-size: 13px;
  font-weight: bold;
  text-transform: uppercase;
}

.app .header h1 a {
  color: #fff;
  text-decoration: none;
  display: block;
}

.app .header h1 img {
  vertical-align: sub;
  pointer-events: none;
}

.app .header .nav {
  float: right;
  height: 100%;
  line-height: 80px;
  background: transparent;
  padding: 0;
  margin: 0;
}

.app .header .nav-item {
  margin: 0;
  float: left;
  list-style: none;
  position: relative;
  cursor: pointer;
  margin-left: 20px;
}

.app .header .nav-item:last-child {
  cursor: default;
  margin-left: 34px;
}

.app .header .nav-item .nav-lang {
  cursor: pointer;
  display: inline-block;
  height: 100%;
  opacity: .8;
}

.app .header .nav-item .nav-lang.active {
  font-weight: 700;
  opacity: 1;
}

.app .header .nav-item a {
  text-decoration: none;
  color: #fff;
  display: block;
  padding: 0 20px;
  opacity: .8;
}

.app .header .nav-item a.active {
  font-weight: 700;
  opacity: 1;
}

.app .header .nav-item a.active:before {
  content: "";
  display: block;
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 4px;
  background: #99d2fc;
}

.app .main {
  padding-top: 60px;
  padding-bottom: 95px;
}

.app .footer {
  height: 120px;
  background-color: #324057;
  color: #a4aebd;
  width: 100%;
}

.app .footer .footer-main {
  font-size: 0;
  padding-top: 40px;
  display: inline-block;
}

.app .footer .footer-main .footer-main-title {
  line-height: 1;
  font-size: 22px;
  margin: 0;
}

.app .footer .footer-main .footer-main-link {
  display: inline-block;
  margin: 12px 18px 0 0;
  line-height: 1;
  font-size: 12px;
  color: #768193;
  text-decoration: none;
}

.app .footer .footer-social {
  float: right;
  line-height: 120px;
}

.app .footer .footer-social img {
  width: 32px;
  height: 32px;
  vertical-align: middle;
  opacity: 0.5;
  transition: .3s;
}

.app .footer .footer-social img:hover {
  opacity: 1;
  transform: scale(1.2);
}

.content {
  display: inline-block;
  vertical-align: top;
  // width: 75%;
}

.content h2 {
  font-size: 28px;
  color: #1f2d3d;
  margin: 0;
}

.content h3 {
  font-size: 22px;
  margin: 45px 0 15px;
}

.content h2,
.content h3,
.content h4,
.content h5 {
  font-weight: normal;
  color: #1f2f3d;
}

.content pre {
  background-color: transparent;
  overflow-x: auto;
  padding: 18px 24px;
  line-height: 1.8;
  font-size: 12px;
}

.content table.grid {
  border-collapse: collapse;
  width: 100%;
  background-color: #fff;
  color: #5e6d82;
  font-size: 14px;
  margin-bottom: 45px;
  line-height: 1.5em;
}

.content table.grid strong {
  font-weight: normal;
}

.content table.grid th {
  text-align: left;
  border-top: 1px solid #eaeefb;
  background-color: #EFF2F7;
  white-space: nowrap;
}

.content table.grid td,
.content table.grid th {
  border-bottom: 1px solid #eaeefb;
  padding: 10px;
  max-width: 250px;
}

.content table.grid th:first-child,
.content table.grid td:first-child {
  padding-left: 10px;
}

.side-nav {
  display: inline-block;
  vertical-align: top;
  width: 25%;
}

.side-nav li {
  list-style: none;
}

.side-nav ul {
  padding: 0;
  margin: 0;
  overflow: hidden;
}

.side-nav .nav-item a {
  font-size: 16px;
  color: #5e6d82;
  line-height: 40px;
  height: 40px;
  margin: 0;
  padding: 0;
  text-decoration: none;
  display: block;
  position: relative;
  transition: all .3s;
}

.side-nav .nav-item a.active {
  color: #20a0ff;
}

.side-nav .nav-item .nav-item a {
  display: block;
  height: 40px;
  line-height: 40px;
  font-size: 13px;
  padding-left: 24px;
}

.side-nav .nav-item .nav-item a:hover {
  color: #20a0ff;
}

.side-nav .nav-group__title {
  font-size: 12px;
  color: #99a9bf;
  padding-left: 8px;
  line-height: 26px;
  margin-top: 10px;
}

.demo-block {
  border: solid 1px #eaeefb;
  border-radius: 4px;
  transition: .2s;
}

.demo-block.hover {
  box-shadow: 0 0 8px 0 rgba(232, 237, 250, 0.6), 0 2px 4px 0 rgba(232, 237, 250, 0.5);
}

.demo-block code {
  font-family: Menlo, Monaco, Consolas, Courier, monospace;
}

.demo-block .source {
  position: relative;
  padding: 24px;
}

.demo-block .meta {
  position: relative;
  overflow: hidden;
  background-color: #f9fafc;
  border-top: solid 1px #eaeefb;
}

.demo-block .highlight {
  overflow: auto;
  border-right: 1px solid #eaeefb;
}

.demo-block .description {
  float: right;
  padding: 18px 24px;
  width: 270px;
  font-size: 14px;
  line-height: 1.8;
  color: #5e6d82;
  margin-left: -1px;
  word-break: break-word;
  box-sizing: border-box;
  border-left: 1px solid #eaeefb;
}

.demo-block .description p {
  margin: 0;
}

.demo-block .description code {
  color: #5e6d82;
  background-color: #e6effb;
  margin: 0 4px;
  transform: translateY(-2px);
  display: inline-block;
  padding: 1px 5px;
  font-size: 12px;
  border-radius: 3px;
}

.demo-block .demo-block-control {
  border-top: solid 1px #eaeefb;
  height: 36px;
  box-sizing: border-box;
  background-color: #fff;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  text-align: center;
  margin-top: -1px;
  color: #d3dce6;
  cursor: pointer;
  transition: .2s;
  position: relative;
}

.demo-block .demo-block-control i {
  font-size: 12px;
  line-height: 36px;
  margin-right: 5px;
}

.demo-block .demo-block-control span {
  display: inline-block;
  transform: translateX(40px);
  font-size: 14px;
  line-height: 36px;
  transition: .3s;
  opacity: 0;
}

.demo-block .demo-block-control:hover {
  color: #20a0ff;
  background-color: #f9fafc;
}

.demo-block .demo-block-control:hover span {
  opacity: 1;
  transform: translateX(0);
}

.content p {
  margin: 1em 0;
  font-size: 14px;
  color: #5e6d82;
}

.page-component-up {
  background-color: #58b7ff;
  width: 50px;
  height: 50px;
  border-radius: 25px;
  cursor: pointer;
  opacity: .4;
  transition: .3s;
}

.page-component-up i {
  color: #fff;
  display: block;
  line-height: 50px;
  text-align: center;
  font-size: 22px;
}

.page-component-up:hover {
  opacity: 1;
}

.el-select-dropdown {
  position: absolute !important;
}

.CodeMirror {
  font-family: 'source-code-pro', Menlo, 'Courier New', Consolas, monospace;
  font-size: 13px;
  line-height: 20px;
  color: #484848;
  padding: 15px 0;
  border-right: 1px solid #eaeefb;
  z-index: 0;
  height: auto;
  background: transparent;
}

.CodeMirror .CodeMirror-gutters {
  background: transparent;
  border-right: 0px;
  z-index: 0;
}

.CodeMirror .CodeMirror-selected {
  background: #E6EFFB;
}

.CodeMirror pre {
  padding: 0 25px;
}

.CodeMirror span.cm-keyword {
  color: #1990B8;
}

.CodeMirror span.cm-atom {
  color: #C92C2C;
}

.CodeMirror span.cm-number {
  color: #C92C2C;
}

.CodeMirror span.cm-variable {
  color: black;
}

.CodeMirror span.cm-variable-2 {
  color: #0000C0;
}

.CodeMirror span.cm-variable-3 {
  color: #0000C0;
}

.CodeMirror span.cm-property {
  color: black;
}

.CodeMirror span.cm-operator {
  color: black;
}

.CodeMirror span.cm-comment {
  color: #7D8B99;
}

.CodeMirror span.cm-string {
  color: #2F9C0A;
}

.CodeMirror span.cm-string-2 {
  color: #2F9C0A;
}

.CodeMirror span.cm-link {
  color: #C92C2C;
}

ul.language-list {
  color: #5e6d82;
  font-size: 14px;
  padding-left: 20px;
}

ul.language-list li {
  line-height: 1.8;
}

.demo-layout .el-row {
  margin-bottom: 20px;
}

.demo-layout .el-row:last-child {
  margin-bottom: 0;
}

.demo-layout .el-col {
  border-radius: 4px;
}

.demo-layout .bg-purple-dark {
  background: #99a9bf;
}

.demo-layout .bg-purple {
  background: #d3dce6;
}

.demo-layout .bg-purple-light {
  background: #e5e9f2;
}

.demo-layout .grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.demo-layout .row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.demo-color-row {
  display: flex;
  justify-content: space-between;
  margin: -6px;
}

.demo-color-box {
  flex: 1;
  border-radius: 4px;
  padding: 20px;
  height: 74px;
  box-sizing: border-box;
  color: #fff;
  font-size: 14px;
  margin-bottom: 5px;
  display: inline-block;
  margin: 6px;
}

.demo-color-box .value {
  font-size: 12px;
  opacity: 0.69;
  line-height: 24px;
}

.demo-color-box-group {
  display: flex;
  flex-direction: column;
  flex: 1;
  margin: 6px;
}

.demo-color-box-group .demo-color-box {
  border-radius: 0;
  margin: 0;
  flex: 0;
}

.demo-color-box-group .demo-color-box:first-child {
  border-radius: 4px 4px 0 0;
}

.demo-color-box-group .demo-color-box:last-child {
  border-radius: 0 0 4px 4px;
}

.demo-color-box-group:last-child .demo-color-box {
  border: 1px solid #e0e6ed;
}

.demo-color-box-group:last-child .demo-color-box:first-child {
  border-bottom: none;
}

.demo-color-box-group:last-child .demo-color-box:last-child {
  border-top: none;
}

.bg-blue-light {
  background-color: #58b7ff;
}

.bg-blue,
.bg-info {
  background-color: #20a0ff;
}

.bg-blue-dark {
  background-color: #1d8ce0;
}

.bg-success {
  background-color: #13CE66;
}

.bg-warning {
  background-color: #f7ba2a;
}

.bg-danger {
  background-color: #ff4949;
}

.bg-black {
  background-color: #1f2d3d;
}

.bg-black-light {
  background-color: #324057;
}

.bg-black-lighter {
  background-color: #475669;
}

.bg-silver {
  background-color: #8492a6;
}

.bg-silver-light {
  background-color: #99a9bf;
}

.bg-silver-lighter {
  background-color: #c0ccda;
}

.bg-gray {
  background-color: #d3dce6;
}

.bg-gray-light {
  background-color: #e5e9f2;
}

.bg-gray-lighter {
  background-color: #eff2f7;
}

.bg-white-dark {
  background-color: #f9fafc;
}

.color-gray {
  color: #5e6d82 !important;
}

.demo-typo-box {
  height: 200px;
  width: 200px;
  position: relative;
  border: 1px solid #eaeefb;
  font-size: 40px;
  color: #1f2d3d;
  text-align: center;
  line-height: 162px;
  padding-bottom: 36px;
  box-sizing: border-box;
  display: inline-block;
  margin-right: 17px;
  border-radius: 4px;
}

.demo-typo-box .name {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 35px;
  border-top: 1px solid #eaeefb;
  font-size: 14px;
  color: #8492a6;
  line-height: 35px;
  text-align: left;
  text-indent: 10px;
  font-family: 'Helvetica Neue';
}

.demo-typo-size .h1 {
  font-size: 20px;
}

.demo-typo-size .h2 {
  font-size: 18px;
}

.demo-typo-size .h3 {
  font-size: 16px;
}

.demo-typo-size .text-regular {
  font-size: 14px;
}

.demo-typo-size .text-small {
  font-size: 13px;
}

.demo-typo-size .text-smaller {
  font-size: 12px;
}

.demo-typo-size .color-dark-light {
  color: #99a9bf;
}

.typo-PingFang {
  font-family: 'PingFang SC';
}

.typo-Hiragino {
  font-family: 'Hiragino Sans GB';
}

.typo-Microsoft {
  font-family: 'Microsoft YaHei';
}


/* 英文 */

.typo-Helvetica-Neue {
  font-family: 'Helvetica Neue';
}

.typo-Helvetica {
  font-family: 'Helvetica';
}

.typo-Arial {
  font-family: 'Arial';
}

.demo-icon .source div>i {
  font-size: 24px;
  color: #8492a6;
  margin: 0 20px;
  font-size: 1.5em;
  vertical-align: middle;
}

.demo-icon .source div>button {
  margin: 0 20px;
}

.icon-list {
  overflow: hidden;
  list-style: none;
  padding: 0;
  border: solid 1px #eaeefb;
  border-radius: 4px;
}

.icon-list li {
  float: left;
  width: 16.66%;
  text-align: center;
  height: 120px;
  line-height: 120px;
  color: #666;
  font-size: 13px;
  transition: color .15s linear;
  border-right: 1px solid #eee;
  border-bottom: 1px solid #eee;
  margin-right: -1px;
  margin-bottom: -1px;
}

.icon-list li span {
  display: inline-block;
  line-height: normal;
  vertical-align: middle;
  font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', SimSun, sans-serif;
  color: #99a9bf;
}

.icon-list li i {
  display: block;
  font-size: 24px;
  margin-bottom: 15px;
  color: #8492a6;
}

.icon-list li:hover {
  color: #5cb6ff;
}

.demo-box.demo-button .el-row {
  margin-bottom: 10px;
}

.demo-box.demo-button .el-button+.el-button {
  margin-left: 10px;
}

.demo-box.demo-button .el-button-group {
  margin-bottom: 20px;
}

.demo-box.demo-button .el-button-group .el-button+.el-button {
  margin-left: 0;
}

.demo-box.demo-button .el-button-group+.el-button-group {
  margin-left: 10px;
}

.demo-box.demo-button .intro-block {
  padding: 0;
}

.demo-button .intro-block .block {
  padding: 30px 24px;
  overflow: hidden;
  border-bottom: solid 1px #EFF2F6;
}

.demo-button .intro-block .block:last-child {
  border-bottom: none;
}

.demo-button .intro-block .demonstration {
  font-size: 14px;
  color: #8492a6;
  line-height: 44px;
}

.demo-button .intro-block .wrapper {
  float: right;
  margin-right: 20px;
}

.demo-box.demo-radio .el-radio-group:nth-of-type(2) {
  display: block;
  margin: 15px 0;
}

.demo-box.demo-checkbox .checkbox {
  margin-right: 5px;
}

.demo-box.demo-checkbox .checkbox+.checkbox {
  margin-left: 10px;
}

.demo-input .el-select .el-input {
  width: 100px;
}

.demo-input .text {
  font-size: 14px;
  color: #8492a6;
}

.demo-input .el-input {
  width: 180px;
}

.demo-input .el-input+.el-input,
.demo-input .el-input+.el-textarea {
  margin-top: 15px;
}

.demo-input .el-textarea {
  width: 414px;
}

.demo-input .el-input-group {
  width: 100%;
}

.demo-input .el-input-group+.el-input-group {
  margin-top: 15px;
}

.demo-input .el-autocomplete {
  display: inline-block;
}

.demo-input .inline-input .el-input {
  display: inline-block;
  vertical-align: top;
  margin: 10px 5px;
}

.demo-input .inline-input .el-autocomplete {
  margin: 10px 0 0;
}

.demo-input .inline-input .el-autocomplete .el-input {
  margin: 0;
}

.demo-input .tac {
  text-align: center;
}

.demo-input .tac .el-autocomplete {
  text-align: left;
}

.demo-input .el-row.border-grid .el-col:not(:last-child) {
  border-right: 1px solid rgba(224, 230, 237, 0.5);
}

.demo-input .my-autocomplete li {
  line-height: normal;
  padding: 7px;
}

.demo-input .my-autocomplete li .name {
  text-overflow: ellipsis;
  overflow: hidden;
}

.demo-input .my-autocomplete li .addr {
  font-size: 12px;
  color: #b4b4b4;
}

.demo-box.demo-inputnumber .el-input-number+.el-input-number {
  margin-left: 10px;
}

.demo-select .el-select {
  display: inline-block;
  width: 240px;
}

.demo-cascader .el-cascader {
  width: 222px;
  text-align: left;
}

.demo-cascader-size .el-cascader {
  vertical-align: top;
  margin-right: 15px;
}

.demo-cascader .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px #EFF2F6;
  display: inline-block;
  width: 50%;
  box-sizing: border-box;
}

.demo-cascader .block:last-child {
  border-right: none;
}

.demo-cascader .demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

.demo-box.demo-switch .el-switch {
  margin: 20px 20px 20px 0;
}

.demo-box.demo-switch .el-tooltip {
  display: inline-block;
}

.demo-box.demo-switch .el-tooltip+.el-tooltip {
  margin-left: 15px;
}

.demo-box.demo-switch .box {
  width: 400px;
}

.demo-box.demo-switch .box .top {
  text-align: center;
}

.demo-box.demo-switch .box .left {
  float: left;
  width: 60px;
}

.demo-box.demo-switch .box .right {
  float: right;
  width: 60px;
}

.demo-box.demo-switch .box .bottom {
  clear: both;
  text-align: center;
}

.demo-box.demo-switch .box .item {
  margin: 4px;
}

.demo-box.demo-switch .box .left .el-tooltip__popper,
.demo-box.demo-switch .box .right .el-tooltip__popper {
  padding: 8px 10px;
}

.demo-box.demo-switch .box .el-tooltip {
  margin-left: 0;
}

.demo-box.demo-slider .source {
  padding: 0;
}

.demo-box.demo-slider .block {
  padding: 30px 24px;
  border-bottom: solid 1px #EFF2F6;
}

.demo-box.demo-slider .block:last-child {
  border-bottom: none;
}

.demo-box.demo-slider .demonstration {
  font-size: 14px;
  color: #8492a6;
  line-height: 44px;
}

.demo-box.demo-slider .demonstration+.el-slider {
  float: right;
  width: 70%;
  margin-right: 20px;
}

.demo-box .el-date-editor+.el-date-editor {
  margin-left: 10px;
}

.demo-datepicker .source {
  padding: 0;
  display: flex;
  width: 100%;
}

.demo-datepicker .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px #EFF2F6;
  flex: 1;
}

.demo-datepicker .block:last-child {
  border-right: none;
}

.demo-datepicker .demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

.demo-box {
  margin-bottom: 24px;
}

.demo-box .upload-demo {
  width: 360px;
}

.demo-box .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.demo-box .avatar-uploader .el-upload:hover {
  border-color: #20a0ff;
}

.demo-box .avatar-uploader .avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.demo-box .avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}

.demo-box.demo-rate .el-row {
  margin-bottom: 10px;
}

.demo-box.demo-rate .el-button+.el-rate {
  margin-left: 10px;
}

.demo-box.demo-rate .el-rate-group {
  margin-bottom: 20px;
}

.demo-box.demo-rate .el-rate-group .el-rate+.el-rate {
  margin-left: 0;
}

.demo-box.demo-rate .el-rate-group+.el-rate-group {
  margin-left: 10px;
}

.demo-box.demo-rate .intro-block {
  overflow: hidden;
  margin: -24px;
  padding: 0;
}

.demo-rate .intro-block .block {
  padding: 30px 0;
  text-align: center;
  border-right: 1px solid #eff2f6;
  float: left;
  width: 50%;
  box-sizing: border-box;
}

.demo-rate .intro-block .block:last-child {
  border-bottom: none;
}

.demo-rate .intro-block .demonstration {
  font-size: 14px;
  color: #8492a6;
  line-height: 44px;
}

.demo-rate .intro-block .wrapper {
  margin-right: 20px;
}

.demo-colorpicker .block {
  padding: 30px 0;
  text-align: center;
  border-right: 1px solid #eff2f6;
  width: 50%;
  display: inline-block;
  box-sizing: border-box;
}

.demo-colorpicker .block:after {
  clear: both;
}

.demo-colorpicker .block:last-child {
  border-right: none;
}

.demo-colorpicker .source:nth-child(1) {
  padding: 0;
}

.demo-colorpicker .demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

.demo-color-box {
  border-radius: 4px;
  padding: 20px;
  height: 74px;
  box-sizing: border-box;
  color: #fff;
  font-size: 14px;
}

.demo-color-box .value {
  font-size: 12px;
  opacity: .69;
  line-height: 24px;
}

.demo-color-box-group .demo-color-box {
  border-radius: 0;
}

.demo-color-box-group .demo-color-box:first-child {
  border-radius: 4px 4px 0 0;
}

.demo-color-box-group .demo-color-box:last-child {
  border-radius: 0 0 4px 4px;
}

.demo-form .el-select .el-input {
  width: 420px;
}

.demo-form .el-form {
  width: 500px;
}

.demo-form .el-form.en-US {
  width: 540px;
}

.demo-form .line {
  text-align: center;
}

.demo-form .el-checkbox-group {
  width: 320px;
  margin: 0;
  padding: 0;
  list-style: none;
}

.demo-form .el-checkbox-group:after,
.demo-form .el-checkbox-group:before {
  content: ' ';
  display: table;
}

.demo-form .el-checkbox-group:after {
  clear: both;
  visibility: hidden;
  font-size: 0;
  height: 0;
}

.demo-form .el-checkbox-group .el-checkbox {
  float: left;
  width: 160px;
  padding-right: 20px;
  margin: 0;
  padding: 0;
}

.demo-form .el-checkbox-group .el-checkbox+.el-checkbox {
  margin-left: 0;
}

.demo-form .demo-form-normal {
  width: 440px;
}

.demo-form .demo-form-inline .el-input {
  width: 150px;
}

.demo-form .demo-form-inline>* {
  margin-right: 10px;
}

.demo-form .demo-dynamic .el-input {
  display: inline-block;
  margin-right: 9px;
  width: 270px;
  vertical-align: top;
}

.demo-form .fr {
  float: right;
}

.demo-box.demo-table .el-table .info-row {
  background: #c9e5f5;
}

.demo-box.demo-table .el-table .positive-row {
  background: #e2f0e4;
}

.demo-box.demo-tag .el-tag {
  margin-right: 10px;
}

.demo-box.demo-tag .button-new-tag {
  height: 24px;
  line-height: 22px;
  padding-top: 0;
  padding-bottom: 0;
}

.demo-box.demo-tag .input-new-tag {
  width: 78px;
  vertical-align: bottom;
}

.demo-box.demo-tag .input-new-tag .el-input__inner {
  height: 24px;
}

.demo-box.demo-progress .el-progress--line {
  margin-bottom: 15px;
  width: 350px;
}

.demo-box.demo-progress .el-progress--circle {
  margin-right: 15px;
}

.demo-tree .leaf {
  width: 20px;
  background: #ddd;
}

.demo-tree .folder {
  width: 20px;
  background: #888;
}

.demo-tree .buttons {
  margin-top: 20px;
}

.demo-pagination .first {
  padding: 0;
}

.demo-pagination .first .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px #EFF2F6;
  display: inline-block;
  width: 50%;
  box-sizing: border-box;
}

.demo-pagination .first .block:last-child {
  border-right: none;
}

.demo-pagination .first .demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

.demo-pagination .last {
  padding: 0;
}

.demo-pagination .last .block {
  padding: 30px 24px;
  border-bottom: solid 1px #EFF2F6;
}

.demo-pagination .last .block:last-child {
  border-bottom: none;
}

.demo-pagination .last .demonstration {
  font-size: 14px;
  color: #8492a6;
  line-height: 44px;
}

.demo-pagination .last .demonstration+.el-pagination {
  float: right;
  width: 70%;
  margin: 5px 20px 0 0;
}

.demo-badge .el-badge {
  margin-right: 40px;
}

.demo-badge .el-dropdown {
  vertical-align: middle !important;
}

.demo-badge .share-button {
  width: 36px;
  padding: 10px;
}

.demo-badge .mark {
  margin-right: 0;
}

.demo-badge .clearfix {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  line-height: 1;
  padding: 7px;
}

.demo-box.demo-alert .el-alert {
  margin-bottom: 20px;
}

.demo-loading .el-loading-demo {
  border-radius: 4px;
  overflow: hidden;
}

.demo-loading .el-loading-mask {
  height: 100px;
}

.demo-box.demo-message .el-button+.el-button {
  margin-left: 10px;
}

.demo-box.demo-message .el-button+.el-button {
  margin-left: 10px;
}

.demo-box.demo-notification .el-button+.el-button {
  margin-left: 10px;
}

.demo-box.demo-menu .el-menu-demo {
  padding-left: 55px;
}

.demo-box.demo-menu .el-menu-vertical-demo {
  width: 200px;
  min-height: 400px;
}

.demo-box.demo-menu .line {
  height: 1px;
  background-color: #e0e6ed;
  margin: 35px -24px;
}

.demo-box.demo-menu h5 {
  font-size: 14px;
  color: #8492a6;
  margin-top: 10px;
  margin-bottom: 15px;
}

.demo-box.demo-menu .tac {
  text-align: center;
}

.demo-box.demo-menu .tac .el-menu-vertical-demo {
  display: inline-block;
  text-align: left;
}

.demo-box .el-dropdown {
  vertical-align: top;
}

.demo-box .el-dropdown+.el-dropdown {
  margin-left: 15px;
}

.demo-box .el-dropdown-link {
  cursor: pointer;
  color: #20a0ff;
}

.demo-box .el-icon-caret-bottom {
  font-size: 12px;
}

.block-col-2 {
  margin: -24px;
}

.block-col-2 .el-col {
  padding: 30px 0;
  text-align: center;
  border-right: 1px solid #eff2f6;
}

.block-col-2 .el-col:last-child {
  border-right: 0;
}

.demo-dropdown .demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

.demo-box.demo-dialog .dialog-footer button:first-child {
  margin-right: 10px;
}

.demo-box.demo-dialog .full-image {
  width: 100%;
}

.demo-box.demo-dialog .el-dialog__wrapper {
  margin: 0;
}

.demo-box.demo-dialog .el-select {
  width: 300px;
}

.demo-box.demo-dialog .el-input {
  width: 300px;
}

.demo-box.demo-dialog .el-button--text {
  margin-right: 15px;
}

.demo-tooltip .el-tooltip {
  display: inline-block;
}

.demo-tooltip .el-tooltip+.el-tooltip {
  margin-left: 15px;
}

.demo-tooltip .box {
  width: 400px;
}

.demo-tooltip .box .top {
  text-align: center;
}

.demo-tooltip .box .left {
  float: left;
  width: 60px;
}

.demo-tooltip .box .right {
  float: right;
  width: 60px;
}

.demo-tooltip .box .bottom {
  clear: both;
  text-align: center;
}

.demo-tooltip .box .item {
  margin: 4px;
}

.demo-tooltip .box .left .el-tooltip__popper,
.demo-tooltip .box .right .el-tooltip__popper {
  padding: 8px 10px;
}

.demo-tooltip .box .el-tooltip {
  margin-left: 0;
}

.demo-box.demo-popover .el-popover+.el-popover {
  margin-left: 10px;
}

.demo-box.demo-popover .el-input {
  width: 360px;
}

.demo-box.demo-popover .el-button {
  margin-left: 10px;
}

.demo-card .text {
  font-size: 14px;
}

.demo-card .item {
  padding: 18px 0;
}

.demo-card .box-card {
  width: 480px;
}

.demo-card .image {
  width: 100%;
  display: block;
}

.demo-card .bottom {
  margin-top: 13px;
  line-height: 12px;
}

.demo-card .time {
  font-size: 13px;
  color: #999;
}

.demo-card .clearfix:before,
.demo-card .clearfix:after {
  display: table;
  content: "";
}

.demo-card .button {
  padding: 0;
  float: right;
}

.demo-box.demo-carousel .source {
  overflow: hidden;
}

.demo-box.demo-carousel .block {
  padding: 30px;
  text-align: center;
  border-right: solid 1px #EFF2F6;
  float: left;
  width: 50%;
  box-sizing: border-box;
}

.demo-box.demo-carousel .block:last-child {
  border-right: none;
}

.demo-box.demo-carousel .demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

.demo-box.demo-carousel .el-carousel__container {
  text-align: center;
}

.demo-box.demo-carousel .el-carousel__item h3 {
  color: #fff;
  font-size: 18px;
  line-height: 300px;
  margin: 0;
}

.demo-box.demo-carousel .el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.demo-box.demo-carousel .el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.demo-box.demo-carousel .small h3 {
  font-size: 14px;
  line-height: 150px;
}

.demo-box.demo-carousel .medium h3 {
  font-size: 14px;
  line-height: 200px;
}

.demo-box.demo-carousel .demo-1 .el-carousel__item h3 {
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.demo-box.demo-carousel .demo-1 .el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.demo-box.demo-carousel .demo-1 .el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.demo-box.demo-carousel .demo-2 .el-carousel__item h3 {
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.demo-box.demo-carousel .demo-2 .el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.demo-box.demo-carousel .demo-2 .el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.demo-box.demo-carousel .demo-3 .el-carousel__item h3 {
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.demo-box.demo-carousel .demo-3 .el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.demo-box.demo-carousel .demo-3 .el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.demo-box.demo-carousel .demo-4 .el-carousel__item h3 {
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.demo-box.demo-carousel .demo-4 .el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.demo-box.demo-carousel .demo-4 .el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.demo-collapse .el-collapse-item__header .header-icon {
  margin-left: 5px;
}
</style></head>

</style>