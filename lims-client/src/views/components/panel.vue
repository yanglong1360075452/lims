<template>
  <div class='page-container page-component'>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-18">
      <section data-v-112b3fac="" class="content">
        <h2 data-v-112b3fac="" id="card-qia-pian">
          <a data-v-112b3fac="" href="http://element.eleme.io/#/zh-CN/component/card#card-qia-pian" aria-hidden="true" class="header-anchor"></a> Card 卡片</h2>
        <p data-v-112b3fac="">将信息聚合在卡片容器中展示。</p>
        <h3 data-v-112b3fac="" id="ji-chu-yong-fa">
          <a data-v-112b3fac="" href="http://element.eleme.io/#/zh-CN/component/card#ji-chu-yong-fa" aria-hidden="true" class="header-anchor"></a> 基础用法</h3>
        <p data-v-112b3fac="">包含标题，内容和操作。</p>
        <div data-v-112b3fac="" class="demo-block demo-box demo-zh-CN demo-card">
          <div data-v-112b3fac="" class="source">
            <div data-v-112b3fac="" class="el-card box-card">
              <div class="el-card__header">
                <div data-v-112b3fac="" class="clearfix">
                  <span data-v-112b3fac="" style="line-height: 36px;">卡片名称</span>
                  <button data-v-112b3fac="" type="button" class="el-button el-button--primary" style="float: right;">
                    <!---->
                    <!---->
                    <span>操作按钮</span>
                  </button>
                </div>
              </div>
              <div class="el-card__body">
                <div data-v-112b3fac="" class="text item">
                  列表内容 1
                </div>
                <div data-v-112b3fac="" class="text item">
                  列表内容 2
                </div>
                <div data-v-112b3fac="" class="text item">
                  列表内容 3
                </div>
                <div data-v-112b3fac="" class="text item">
                  列表内容 4
                </div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 724px;">
            <div class="description">
              <p data-v-112b3fac="">Card 组件包括
                <code data-v-112b3fac="">header</code>和
                <code data-v-112b3fac="">body</code>部分，
                <code data-v-112b3fac="">header</code>部分需要有显式具名 slot 分发，同时也是可选的。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div data-v-112b3fac="" class="highlight">
              <pre data-v-112b3fac=""><code data-v-112b3fac="" class="hljs language-html"><span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-card</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"box-card"</span>&gt;</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">div</span> <span data-v-112b3fac="" class="hljs-attr">slot</span>=<span data-v-112b3fac="" class="hljs-string">"header"</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"clearfix"</span>&gt;</span>
      <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">span</span> <span data-v-112b3fac="" class="hljs-attr">style</span>=<span data-v-112b3fac="" class="hljs-string">"line-height: 36px;"</span>&gt;</span>卡片名称<span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">span</span>&gt;</span>
      <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-button</span> <span data-v-112b3fac="" class="hljs-attr">style</span>=<span data-v-112b3fac="" class="hljs-string">"float: right;"</span> <span data-v-112b3fac="" class="hljs-attr">type</span>=<span data-v-112b3fac="" class="hljs-string">"primary"</span>&gt;</span>操作按钮<span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-button</span>&gt;</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">div</span>&gt;</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">div</span> <span data-v-112b3fac="" class="hljs-attr">v-for</span>=<span data-v-112b3fac="" class="hljs-string">"o in 4"</span> <span data-v-112b3fac="" class="hljs-attr">:key</span>=<span data-v-112b3fac="" class="hljs-string">"o"</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"text item"</span>&gt;</span>
      <span data-v-112b3fac="">{{</span>'列表内容 ' + o <span data-v-112b3fac="">}}</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">div</span>&gt;</span>
  <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-card</span>&gt;</span>
  
  <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">style</span>&gt;</span><span data-v-112b3fac="" class="css">
    <span data-v-112b3fac="" class="hljs-selector-class">.text</span> {
      <span data-v-112b3fac="" class="hljs-attribute">font-size</span>: <span data-v-112b3fac="" class="hljs-number">14px</span>;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.item</span> {
      <span data-v-112b3fac="" class="hljs-attribute">padding</span>: <span data-v-112b3fac="" class="hljs-number">18px</span> <span data-v-112b3fac="" class="hljs-number">0</span>;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.clearfix</span><span data-v-112b3fac="" class="hljs-selector-pseudo">:before</span>,
    <span data-v-112b3fac="" class="hljs-selector-class">.clearfix</span><span data-v-112b3fac="" class="hljs-selector-pseudo">:after</span> {
        <span data-v-112b3fac="" class="hljs-attribute">display</span>: table;
        <span data-v-112b3fac="" class="hljs-attribute">content</span>: <span data-v-112b3fac="" class="hljs-string">""</span>;
    }
    <span data-v-112b3fac="" class="hljs-selector-class">.clearfix</span><span data-v-112b3fac="" class="hljs-selector-pseudo">:after</span> {
        <span data-v-112b3fac="" class="hljs-attribute">clear</span>: both
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.box-card</span> {
      <span data-v-112b3fac="" class="hljs-attribute">width</span>: <span data-v-112b3fac="" class="hljs-number">480px</span>;
    }
  </span><span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 data-v-112b3fac="" id="jian-dan-qia-pian">
          <a data-v-112b3fac="" href="http://element.eleme.io/#/zh-CN/component/card#jian-dan-qia-pian" aria-hidden="true" class="header-anchor"></a> 简单卡片</h3>
        <p data-v-112b3fac="">卡片可以只有内容区域。</p>
        <div data-v-112b3fac="" class="demo-block demo-box demo-zh-CN demo-card">
          <div data-v-112b3fac="" class="source">
            <div data-v-112b3fac="" class="el-card box-card">
              <!---->
              <div class="el-card__body">
                <div data-v-112b3fac="" class="text item">
                  列表内容 1
                </div>
                <div data-v-112b3fac="" class="text item">
                  列表内容 2
                </div>
                <div data-v-112b3fac="" class="text item">
                  列表内容 3
                </div>
                <div data-v-112b3fac="" class="text item">
                  列表内容 4
                </div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 436px;">
            <div class="description">
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div data-v-112b3fac="" class="highlight">
              <pre data-v-112b3fac=""><code data-v-112b3fac="" class="hljs language-html"><span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-card</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"box-card"</span>&gt;</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">div</span> <span data-v-112b3fac="" class="hljs-attr">v-for</span>=<span data-v-112b3fac="" class="hljs-string">"o in 4"</span> <span data-v-112b3fac="" class="hljs-attr">:key</span>=<span data-v-112b3fac="" class="hljs-string">"o"</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"text item"</span>&gt;</span>
      <span data-v-112b3fac="">{{</span>'列表内容 ' + o <span data-v-112b3fac="">}}</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">div</span>&gt;</span>
  <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-card</span>&gt;</span>
  
  <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">style</span>&gt;</span><span data-v-112b3fac="" class="css">
    <span data-v-112b3fac="" class="hljs-selector-class">.text</span> {
      <span data-v-112b3fac="" class="hljs-attribute">font-size</span>: <span data-v-112b3fac="" class="hljs-number">14px</span>;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.item</span> {
      <span data-v-112b3fac="" class="hljs-attribute">padding</span>: <span data-v-112b3fac="" class="hljs-number">18px</span> <span data-v-112b3fac="" class="hljs-number">0</span>;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.box-card</span> {
      <span data-v-112b3fac="" class="hljs-attribute">width</span>: <span data-v-112b3fac="" class="hljs-number">480px</span>;
    }
  </span><span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">style</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 data-v-112b3fac="" id="dai-tu-pian">
          <a data-v-112b3fac="" href="http://element.eleme.io/#/zh-CN/component/card#dai-tu-pian" aria-hidden="true" class="header-anchor"></a> 带图片</h3>
        <p data-v-112b3fac="">可配置定义更丰富的内容展示。</p>
        <div data-v-112b3fac="" class="demo-block demo-box demo-zh-CN demo-card">
          <div data-v-112b3fac="" class="source">
            <div data-v-112b3fac="" class="el-row">
              <div data-v-112b3fac="" class="el-col el-col-8">
                <div data-v-112b3fac="" class="el-card">
                  <!---->
                  <div class="el-card__body" style="padding: 0px;">
                    <img data-v-112b3fac="" src="http://element.eleme.io/static/hamburger.50e4091.png" class="image">
                    <div data-v-112b3fac="" style="padding: 14px;">
                      <span data-v-112b3fac="">好吃的汉堡</span>
                      <div data-v-112b3fac="" class="bottom clearfix">
                        <time data-v-112b3fac="" class="time">2017-07-12 16:54</time>
                        <button data-v-112b3fac="" type="button" class="el-button button el-button--text">
                          <!---->
                          <!---->
                          <span>操作按钮</span>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div data-v-112b3fac="" class="el-col el-col-8 el-col-offset-2">
                <div data-v-112b3fac="" class="el-card">
                  <!---->
                  <div class="el-card__body" style="padding: 0px;">
                    <img data-v-112b3fac="" src="http://element.eleme.io/static/hamburger.50e4091.png" class="image">
                    <div data-v-112b3fac="" style="padding: 14px;">
                      <span data-v-112b3fac="">好吃的汉堡</span>
                      <div data-v-112b3fac="" class="bottom clearfix">
                        <time data-v-112b3fac="" class="time">2017-07-12 16:54</time>
                        <button data-v-112b3fac="" type="button" class="el-button button el-button--text">
                          <!---->
                          <!---->
                          <span>操作按钮</span>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="meta" style="height: 1228px;">
            <div class="description">
              <p data-v-112b3fac="">配置
                <code data-v-112b3fac="">body-style</code>属性来自定义
                <code data-v-112b3fac="">body</code>部分的
                <code data-v-112b3fac="">style</code>，我们还使用了布局组件。</p>
              <button type="button" class="el-button el-tooltip el-button--primary el-button--small">
                <!---->
                <!---->
                <span>在线运行</span>
              </button>
            </div>
            <div data-v-112b3fac="" class="highlight">
              <pre data-v-112b3fac=""><code data-v-112b3fac="" class="hljs language-html"><span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-row</span>&gt;</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-col</span> <span data-v-112b3fac="" class="hljs-attr">:span</span>=<span data-v-112b3fac="" class="hljs-string">"8"</span> <span data-v-112b3fac="" class="hljs-attr">v-for</span>=<span data-v-112b3fac="" class="hljs-string">"(o, index) in 2"</span> <span data-v-112b3fac="" class="hljs-attr">:key</span>=<span data-v-112b3fac="" class="hljs-string">"o"</span> <span data-v-112b3fac="" class="hljs-attr">:offset</span>=<span data-v-112b3fac="" class="hljs-string">"index &gt; 0 ? 2 : 0"</span>&gt;</span>
      <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-card</span> <span data-v-112b3fac="" class="hljs-attr">:body-style</span>=<span data-v-112b3fac="" class="hljs-string">"{ padding: '0px' }"</span>&gt;</span>
        <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">img</span> <span data-v-112b3fac="" class="hljs-attr">src</span>=<span data-v-112b3fac="" class="hljs-string">"~examples/assets/images/hamburger.png"</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"image"</span>&gt;</span>
        <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">div</span> <span data-v-112b3fac="" class="hljs-attr">style</span>=<span data-v-112b3fac="" class="hljs-string">"padding: 14px;"</span>&gt;</span>
          <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">span</span>&gt;</span>好吃的汉堡<span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">span</span>&gt;</span>
          <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">div</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"bottom clearfix"</span>&gt;</span>
            <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">time</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"time"</span>&gt;</span><span data-v-112b3fac="">{{</span> currentDate <span data-v-112b3fac="">}}</span><span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">time</span>&gt;</span>
            <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">el-button</span> <span data-v-112b3fac="" class="hljs-attr">type</span>=<span data-v-112b3fac="" class="hljs-string">"text"</span> <span data-v-112b3fac="" class="hljs-attr">class</span>=<span data-v-112b3fac="" class="hljs-string">"button"</span>&gt;</span>操作按钮<span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-button</span>&gt;</span>
          <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">div</span>&gt;</span>
        <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">div</span>&gt;</span>
      <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-card</span>&gt;</span>
    <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-col</span>&gt;</span>
  <span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">el-row</span>&gt;</span>
  
  <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">style</span>&gt;</span><span data-v-112b3fac="" class="css">
    <span data-v-112b3fac="" class="hljs-selector-class">.time</span> {
      <span data-v-112b3fac="" class="hljs-attribute">font-size</span>: <span data-v-112b3fac="" class="hljs-number">13px</span>;
      <span data-v-112b3fac="" class="hljs-attribute">color</span>: <span data-v-112b3fac="" class="hljs-number">#999</span>;
    }
    
    <span data-v-112b3fac="" class="hljs-selector-class">.bottom</span> {
      <span data-v-112b3fac="" class="hljs-attribute">margin-top</span>: <span data-v-112b3fac="" class="hljs-number">13px</span>;
      <span data-v-112b3fac="" class="hljs-attribute">line-height</span>: <span data-v-112b3fac="" class="hljs-number">12px</span>;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.button</span> {
      <span data-v-112b3fac="" class="hljs-attribute">padding</span>: <span data-v-112b3fac="" class="hljs-number">0</span>;
      <span data-v-112b3fac="" class="hljs-attribute">float</span>: right;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.image</span> {
      <span data-v-112b3fac="" class="hljs-attribute">width</span>: <span data-v-112b3fac="" class="hljs-number">100%</span>;
      <span data-v-112b3fac="" class="hljs-attribute">display</span>: block;
    }
  
    <span data-v-112b3fac="" class="hljs-selector-class">.clearfix</span><span data-v-112b3fac="" class="hljs-selector-pseudo">:before</span>,
    <span data-v-112b3fac="" class="hljs-selector-class">.clearfix</span><span data-v-112b3fac="" class="hljs-selector-pseudo">:after</span> {
        <span data-v-112b3fac="" class="hljs-attribute">display</span>: table;
        <span data-v-112b3fac="" class="hljs-attribute">content</span>: <span data-v-112b3fac="" class="hljs-string">""</span>;
    }
    
    <span data-v-112b3fac="" class="hljs-selector-class">.clearfix</span><span data-v-112b3fac="" class="hljs-selector-pseudo">:after</span> {
        <span data-v-112b3fac="" class="hljs-attribute">clear</span>: both
    }
  </span><span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">style</span>&gt;</span>
  
  <span data-v-112b3fac="" class="hljs-tag">&lt;<span data-v-112b3fac="" class="hljs-name">script</span>&gt;</span><span data-v-112b3fac="" class="javascript">
  <span data-v-112b3fac="" class="hljs-keyword">export</span> <span data-v-112b3fac="" class="hljs-keyword">default</span> {
    data() {
      <span data-v-112b3fac="" class="hljs-keyword">return</span> {
        <span data-v-112b3fac="" class="hljs-attr">currentDate</span>: <span data-v-112b3fac="" class="hljs-keyword">new</span> <span data-v-112b3fac="" class="hljs-built_in">Date</span>()
      };
    }
  }
  </span><span data-v-112b3fac="" class="hljs-tag">&lt;/<span data-v-112b3fac="" class="hljs-name">script</span>&gt;</span>
  </code></pre>
            </div>
          </div>
          <div class="demo-block-control" v-meta >
            <i class="el-icon-caret-top"></i>
            <span style="display: none;" class="">隐藏代码</span>
          </div>
        </div>
        <h3 data-v-112b3fac="" id="attributes">
          <a data-v-112b3fac="" href="http://element.eleme.io/#/zh-CN/component/card#attributes" aria-hidden="true" class="header-anchor"></a> Attributes</h3>
        <table data-v-112b3fac="" class="table">
          <thead data-v-112b3fac="">
            <tr data-v-112b3fac="">
              <th data-v-112b3fac="">参数</th>
              <th data-v-112b3fac="">说明</th>
              <th data-v-112b3fac="">类型</th>
              <th data-v-112b3fac="">可选值</th>
              <th data-v-112b3fac="">默认值</th>
            </tr>
          </thead>
          <tbody data-v-112b3fac="">
            <tr data-v-112b3fac="">
              <td data-v-112b3fac="">header</td>
              <td data-v-112b3fac="">设置 header，也可以通过
                <code data-v-112b3fac="">slot#header</code> 传入 DOM</td>
              <td data-v-112b3fac="">string</td>
              <td data-v-112b3fac="">—</td>
              <td data-v-112b3fac="">—</td>
            </tr>
            <tr data-v-112b3fac="">
              <td data-v-112b3fac="">body-style</td>
              <td data-v-112b3fac="">设置 body 的样式</td>
              <td data-v-112b3fac="">object</td>
              <td data-v-112b3fac="">—</td>
              <td data-v-112b3fac="">{ padding: '20px' }</td>
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