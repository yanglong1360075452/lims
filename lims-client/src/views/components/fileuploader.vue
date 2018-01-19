<template>
  <div class='page-container page-component'>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-18">
      <section class="content">
        <h2 id="upload-shang-chuan">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#upload-shang-chuan" aria-hidden="true" class="header-anchor"></a> Upload 上传</h2>
        <p>通过点击或者拖拽上传文件</p>
        <h3 id="dian-ji-shang-chuan">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#dian-ji-shang-chuan" aria-hidden="true" class="header-anchor"></a> 点击上传</h3>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
           <el-upload
  class="upload-demo"
  action="https://jsonplaceholder.typicode.com/posts/"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList">
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload>
          </div>
          <div class="meta" style="height: 598px;">
            <div class="description">
              <p>通过 slot 你可以传入自定义的上传按钮类型和文字提示。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">class</span>=<span class="hljs-string">"upload-demo"</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">:on-preview</span>=<span class="hljs-string">"handlePreview"</span>
    <span class="hljs-attr">:on-remove</span>=<span class="hljs-string">"handleRemove"</span>
    <span class="hljs-attr">:file-list</span>=<span class="hljs-string">"fileList"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"primary"</span>&gt;</span>点击上传<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"tip"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-upload__tip"</span>&gt;</span>只能上传jpg/png文件，且不超过500kb<span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">fileList</span>: [{<span class="hljs-attr">name</span>: <span class="hljs-string">'food.jpeg'</span>, <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>}, {<span class="hljs-attr">name</span>: <span class="hljs-string">'food2.jpeg'</span>, <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>}]
        };
      },
      <span class="hljs-attr">methods</span>: {
        handleRemove(file, fileList) {
          <span class="hljs-built_in">console</span>.log(file, fileList);
        },
        handlePreview(file) {
          <span class="hljs-built_in">console</span>.log(file);
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
        <h3 id="yong-hu-tou-xiang-shang-chuan">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#yong-hu-tou-xiang-shang-chuan" aria-hidden="true" class="header-anchor"></a> 用户头像上传</h3>
        <p>使用
          <code>before-upload</code> 限制用户上传的图片格式和大小。</p>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
            <el-upload
  class="avatar-uploader"
  action="https://jsonplaceholder.typicode.com/posts/"
  :show-file-list="false"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeAvatarUpload">
  <img v-if="imageUrl" :src="imageUrl" class="avatar">
  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
</el-upload>
          </div>
          <div class="meta" style="height: 1339px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">class</span>=<span class="hljs-string">"avatar-uploader"</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">:show-file-list</span>=<span class="hljs-string">"false"</span>
    <span class="hljs-attr">:on-success</span>=<span class="hljs-string">"handleAvatarSuccess"</span>
    <span class="hljs-attr">:before-upload</span>=<span class="hljs-string">"beforeAvatarUpload"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">img</span> <span class="hljs-attr">v-if</span>=<span class="hljs-string">"imageUrl"</span> <span class="hljs-attr">:src</span>=<span class="hljs-string">"imageUrl"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"avatar"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">i</span> <span class="hljs-attr">v-else</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-icon-plus avatar-uploader-icon"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">i</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">style</span>&gt;</span><span class="css">
    <span class="hljs-selector-class">.avatar-uploader</span> <span class="hljs-selector-class">.el-upload</span> {
      <span class="hljs-attribute">border</span>: <span class="hljs-number">1px</span> dashed <span class="hljs-number">#d9d9d9</span>;
      <span class="hljs-attribute">border-radius</span>: <span class="hljs-number">6px</span>;
      <span class="hljs-attribute">cursor</span>: pointer;
      <span class="hljs-attribute">position</span>: relative;
      <span class="hljs-attribute">overflow</span>: hidden;
    }
    <span class="hljs-selector-class">.avatar-uploader</span> <span class="hljs-selector-class">.el-upload</span><span class="hljs-selector-pseudo">:hover</span> {
      <span class="hljs-attribute">border-color</span>: <span class="hljs-number">#20a0ff</span>;
    }
    <span class="hljs-selector-class">.avatar-uploader-icon</span> {
      <span class="hljs-attribute">font-size</span>: <span class="hljs-number">28px</span>;
      <span class="hljs-attribute">color</span>: <span class="hljs-number">#8c939d</span>;
      <span class="hljs-attribute">width</span>: <span class="hljs-number">178px</span>;
      <span class="hljs-attribute">height</span>: <span class="hljs-number">178px</span>;
      <span class="hljs-attribute">line-height</span>: <span class="hljs-number">178px</span>;
      <span class="hljs-attribute">text-align</span>: center;
    }
    <span class="hljs-selector-class">.avatar</span> {
      <span class="hljs-attribute">width</span>: <span class="hljs-number">178px</span>;
      <span class="hljs-attribute">height</span>: <span class="hljs-number">178px</span>;
      <span class="hljs-attribute">display</span>: block;
    }
  </span><span class="hljs-tag">&lt;/<span class="hljs-name">style</span>&gt;</span>
  
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">imageUrl</span>: <span class="hljs-string">''</span>
        };
      },
      <span class="hljs-attr">methods</span>: {
        handleAvatarSuccess(res, file) {
          <span class="hljs-keyword">this</span>.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
          <span class="hljs-keyword">const</span> isJPG = file.type === <span class="hljs-string">'image/jpeg'</span>;
          <span class="hljs-keyword">const</span> isLt2M = file.size / <span class="hljs-number">1024</span> / <span class="hljs-number">1024</span> &lt; <span class="hljs-number">2</span>;
  
          <span class="hljs-keyword">if</span> (!isJPG) {
            <span class="hljs-keyword">this</span>.$message.error(<span class="hljs-string">'上传头像图片只能是 JPG 格式!'</span>);
          }
          <span class="hljs-keyword">if</span> (!isLt2M) {
            <span class="hljs-keyword">this</span>.$message.error(<span class="hljs-string">'上传头像图片大小不能超过 2MB!'</span>);
          }
          <span class="hljs-keyword">return</span> isJPG &amp;&amp; isLt2M;
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
        <h3 id="zhao-pian-qiang">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#zhao-pian-qiang" aria-hidden="true" class="header-anchor"></a> 照片墙</h3>
        <p>使用
          <code>list-type</code> 属性来设置文件列表的样式。</p>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
           <el-upload
  action="https://jsonplaceholder.typicode.com/posts/"
  list-type="picture-card"
  :on-preview="handlePictureCardPreview"
  :on-remove="handleRemove">
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog v-model="dialogVisible" size="tiny">
  <img width="100%" :src="dialogImageUrl" alt="">
</el-dialog>
          </div>
          <div class="meta" style="height: 646px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">list-type</span>=<span class="hljs-string">"picture-card"</span>
    <span class="hljs-attr">:on-preview</span>=<span class="hljs-string">"handlePictureCardPreview"</span>
    <span class="hljs-attr">:on-remove</span>=<span class="hljs-string">"handleRemove"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">i</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-icon-plus"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">i</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">el-dialog</span> <span class="hljs-attr">v-model</span>=<span class="hljs-string">"dialogVisible"</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"tiny"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">img</span> <span class="hljs-attr">width</span>=<span class="hljs-string">"100%"</span> <span class="hljs-attr">:src</span>=<span class="hljs-string">"dialogImageUrl"</span> <span class="hljs-attr">alt</span>=<span class="hljs-string">""</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-dialog</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">dialogImageUrl</span>: <span class="hljs-string">''</span>,
          <span class="hljs-attr">dialogVisible</span>: <span class="hljs-literal">false</span>
        };
      },
      <span class="hljs-attr">methods</span>: {
        handleRemove(file, fileList) {
          <span class="hljs-built_in">console</span>.log(file, fileList);
        },
        handlePictureCardPreview(file) {
          <span class="hljs-keyword">this</span>.dialogImageUrl = file.url;
          <span class="hljs-keyword">this</span>.dialogVisible = <span class="hljs-literal">true</span>;
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
        <h3 id="tu-pian-lie-biao-suo-lue-tu">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#tu-pian-lie-biao-suo-lue-tu" aria-hidden="true" class="header-anchor"></a> 图片列表缩略图</h3>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
            <el-upload
  class="upload-demo"
  action="https://jsonplaceholder.typicode.com/posts/"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList2"
  list-type="picture">
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload>
          </div>
          <div class="meta" style="height: 619px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">class</span>=<span class="hljs-string">"upload-demo"</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">:on-preview</span>=<span class="hljs-string">"handlePreview"</span>
    <span class="hljs-attr">:on-remove</span>=<span class="hljs-string">"handleRemove"</span>
    <span class="hljs-attr">:file-list</span>=<span class="hljs-string">"fileList2"</span>
    <span class="hljs-attr">list-type</span>=<span class="hljs-string">"picture"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"primary"</span>&gt;</span>点击上传<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"tip"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-upload__tip"</span>&gt;</span>只能上传jpg/png文件，且不超过500kb<span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">fileList2</span>: [{<span class="hljs-attr">name</span>: <span class="hljs-string">'food.jpeg'</span>, <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>}, {<span class="hljs-attr">name</span>: <span class="hljs-string">'food2.jpeg'</span>, <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>}]
        };
      },
      <span class="hljs-attr">methods</span>: {
        handleRemove(file, fileList) {
          <span class="hljs-built_in">console</span>.log(file, fileList);
        },
        handlePreview(file) {
          <span class="hljs-built_in">console</span>.log(file);
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
        <h3 id="shang-chuan-wen-jian-lie-biao-kong-zhi">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#shang-chuan-wen-jian-lie-biao-kong-zhi" aria-hidden="true" class="header-anchor"></a> 上传文件列表控制</h3>
        <p>通过
          <code>on-change</code> 钩子函数来对列表进行控制</p>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
            <el-upload
  class="upload-demo"
  action="https://jsonplaceholder.typicode.com/posts/"
  :on-change="handleChange"
  :file-list="fileList3">
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload>
          </div>
          <div class="meta" style="height: 682px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">class</span>=<span class="hljs-string">"upload-demo"</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">:on-change</span>=<span class="hljs-string">"handleChange"</span>
    <span class="hljs-attr">:file-list</span>=<span class="hljs-string">"fileList3"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"primary"</span>&gt;</span>点击上传<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"tip"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-upload__tip"</span>&gt;</span>只能上传jpg/png文件，且不超过500kb<span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">fileList3</span>: [{
            <span class="hljs-attr">name</span>: <span class="hljs-string">'food.jpeg'</span>,
            <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>,
            <span class="hljs-attr">status</span>: <span class="hljs-string">'finished'</span>
          }, {
            <span class="hljs-attr">name</span>: <span class="hljs-string">'food2.jpeg'</span>,
            <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>,
            <span class="hljs-attr">status</span>: <span class="hljs-string">'finished'</span>
          }]
        };
      },
      <span class="hljs-attr">methods</span>: {
        handleChange(file, fileList) {
          <span class="hljs-keyword">this</span>.fileList3 = fileList.slice(<span class="hljs-number">-3</span>);
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
        <h3 id="tuo-zhuai-shang-chuan">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#tuo-zhuai-shang-chuan" aria-hidden="true" class="header-anchor"></a> 拖拽上传</h3>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
            <el-upload
  class="upload-demo"
  drag
  action="https://jsonplaceholder.typicode.com/posts/"
  multiple>
  <i class="el-icon-upload"></i>
  <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
  <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload>
          </div>
          <div class="meta" style="height: 241px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">class</span>=<span class="hljs-string">"upload-demo"</span>
    <span class="hljs-attr">drag</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">multiple</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">i</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-icon-upload"</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">i</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-upload__text"</span>&gt;</span>将文件拖到此处，或<span class="hljs-tag">&lt;<span class="hljs-name">em</span>&gt;</span>点击上传<span class="hljs-tag">&lt;/<span class="hljs-name">em</span>&gt;</span><span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-upload__tip"</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"tip"</span>&gt;</span>只能上传jpg/png文件，且不超过500kb<span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 id="shou-dong-shang-chuan">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#shou-dong-shang-chuan" aria-hidden="true" class="header-anchor"></a> 手动上传</h3>
        <div class="demo-block demo-box demo-zh-CN demo-upload">
          <div class="source">
            <el-upload
  class="upload-demo"
  ref="upload"
  action="https://jsonplaceholder.typicode.com/posts/"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList"
  :auto-upload="false">
  <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
  <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload>
          </div>
          <div class="meta" style="height: 724px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div class="highlight">
              <pre><code class="hljs language-html"><span class="hljs-tag">&lt;<span class="hljs-name">el-upload</span>
    <span class="hljs-attr">class</span>=<span class="hljs-string">"upload-demo"</span>
    <span class="hljs-attr">ref</span>=<span class="hljs-string">"upload"</span>
    <span class="hljs-attr">action</span>=<span class="hljs-string">"https://jsonplaceholder.typicode.com/posts/"</span>
    <span class="hljs-attr">:on-preview</span>=<span class="hljs-string">"handlePreview"</span>
    <span class="hljs-attr">:on-remove</span>=<span class="hljs-string">"handleRemove"</span>
    <span class="hljs-attr">:file-list</span>=<span class="hljs-string">"fileList"</span>
    <span class="hljs-attr">:auto-upload</span>=<span class="hljs-string">"false"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"trigger"</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"primary"</span>&gt;</span>选取文件<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">el-button</span> <span class="hljs-attr">style</span>=<span class="hljs-string">"margin-left: 10px;"</span> <span class="hljs-attr">size</span>=<span class="hljs-string">"small"</span> <span class="hljs-attr">type</span>=<span class="hljs-string">"success"</span> <span class="hljs-attr">@click</span>=<span class="hljs-string">"submitUpload"</span>&gt;</span>上传到服务器<span class="hljs-tag">&lt;/<span class="hljs-name">el-button</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">div</span> <span class="hljs-attr">slot</span>=<span class="hljs-string">"tip"</span> <span class="hljs-attr">class</span>=<span class="hljs-string">"el-upload__tip"</span>&gt;</span>只能上传jpg/png文件，且不超过500kb<span class="hljs-tag">&lt;/<span class="hljs-name">div</span>&gt;</span>
  <span class="hljs-tag">&lt;/<span class="hljs-name">el-upload</span>&gt;</span>
  <span class="hljs-tag">&lt;<span class="hljs-name">script</span>&gt;</span><span class="javascript">
    <span class="hljs-keyword">export</span> <span class="hljs-keyword">default</span> {
      data() {
        <span class="hljs-keyword">return</span> {
          <span class="hljs-attr">fileList</span>: [{<span class="hljs-attr">name</span>: <span class="hljs-string">'food.jpeg'</span>, <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>}, {<span class="hljs-attr">name</span>: <span class="hljs-string">'food2.jpeg'</span>, <span class="hljs-attr">url</span>: <span class="hljs-string">'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'</span>}]
        };
      },
      <span class="hljs-attr">methods</span>: {
        submitUpload() {
          <span class="hljs-keyword">this</span>.$refs.upload.submit();
        },
        handleRemove(file, fileList) {
          <span class="hljs-built_in">console</span>.log(file, fileList);
        },
        handlePreview(file) {
          <span class="hljs-built_in">console</span>.log(file);
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
        <h3 id="attribute">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#attribute" aria-hidden="true" class="header-anchor"></a> Attribute</h3>
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
              <td>action</td>
              <td>必选参数, 上传的地址</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>headers</td>
              <td>可选参数, 设置上传的请求头部</td>
              <td>object</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>multiple</td>
              <td>可选参数, 是否支持多选文件</td>
              <td>boolean</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>data</td>
              <td>可选参数, 上传时附带的额外参数</td>
              <td>object</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>name</td>
              <td>可选参数, 上传的文件字段名</td>
              <td>string</td>
              <td>—</td>
              <td>file</td>
            </tr>
            <tr>
              <td>with-credentials</td>
              <td>支持发送 cookie 凭证信息</td>
              <td>boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>show-file-list</td>
              <td>是否显示已上传文件列表</td>
              <td>boolean</td>
              <td>—</td>
              <td>true</td>
            </tr>
            <tr>
              <td>drag</td>
              <td>是否启用拖拽上传</td>
              <td>boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
            <tr>
              <td>accept</td>
              <td>可选参数, 接受上传的
                <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-accept">文件类型</a>（thumbnail-mode 模式下此参数无效）</td>
              <td>string</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>on-preview</td>
              <td>可选参数, 点击已上传的文件链接时的钩子, 可以通过 file.response 拿到服务端返回数据</td>
              <td>function(file)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>on-remove</td>
              <td>可选参数, 文件列表移除文件时的钩子</td>
              <td>function(file, fileList)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>on-success</td>
              <td>可选参数, 文件上传成功时的钩子</td>
              <td>function(response, file, fileList)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>on-error</td>
              <td>可选参数, 文件上传失败时的钩子</td>
              <td>function(err, file, fileList)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>on-progress</td>
              <td>可选参数, 文件上传时的钩子</td>
              <td>function(event, file, fileList)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>on-change</td>
              <td>可选参数, 文件状态改变时的钩子，添加文件、上传成功和上传失败时都会被调用</td>
              <td>function(file, fileList)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>before-upload</td>
              <td>可选参数, 上传文件之前的钩子，参数为上传的文件，若返回 false 或者返回 Promise 且被 reject，则停止上传。</td>
              <td>function(file)</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>list-type</td>
              <td>文件列表的类型</td>
              <td>string</td>
              <td>text/picture/picture-card</td>
              <td>text</td>
            </tr>
            <tr>
              <td>auto-upload</td>
              <td>是否在选取文件后立即进行上传</td>
              <td>boolean</td>
              <td>—</td>
              <td>true</td>
            </tr>
            <tr>
              <td>file-list</td>
              <td>上传的文件列表, 例如: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]</td>
              <td>array</td>
              <td>—</td>
              <td>[]</td>
            </tr>
            <tr>
              <td>http-request</td>
              <td>覆盖默认的上传行为，可以自定义上传的实现</td>
              <td>function</td>
              <td>—</td>
              <td>—</td>
            </tr>
            <tr>
              <td>disabled</td>
              <td>是否禁用</td>
              <td>boolean</td>
              <td>—</td>
              <td>false</td>
            </tr>
          </tbody>
        </table>
        <h3 id="methods">
          <a href="http://element.eleme.io/#/zh-CN/component/upload#methods" aria-hidden="true" class="header-anchor"></a> Methods</h3>
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
              <td>clearFiles</td>
              <td>清空已上传的文件列表（该方法不支持在 before-upload 中调用）</td>
              <td>—</td>
            </tr>
            <tr>
              <td>abort</td>
              <td>取消上传请求</td>
              <td>（ file: fileList 中的 file 对象 ）</td>
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

      fileList: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }, { name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }],
      imageUrl: '',
      fileList2: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }, { name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }],
      fileList3: [{
        name: 'food.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100',
        status: 'finished'
      }, {
        name: 'food2.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100',
        status: 'finished'
      }]
    }
  },
  methods: {
    submitUpload () {
      this.$refs.upload.submit();
    },
    handleChange (file, fileList) {
      this.fileList3 = fileList.slice(-3);
    },
    handleRemove (file, fileList) {
      console.log(file, fileList);
    },
    handlePreview (file) {
      console.log(file);
    },
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
  }
};
</script>
<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #20a0ff;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>