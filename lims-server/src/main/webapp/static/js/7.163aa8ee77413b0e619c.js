webpackJsonp([7],{307:function(t,e,a){function l(t){a(380)}var s=a(4)(a(370),a(385),l,"data-v-5f7f9860",null);t.exports=s.exports},338:function(t,e,a){t.exports={default:a(340),__esModule:!0}},339:function(t,e,a){"use strict";e.__esModule=!0;var l=a(338),s=function(t){return t&&t.__esModule?t:{default:t}}(l);e.default=function(t,e,a){return e in t?(0,s.default)(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}},340:function(t,e,a){a(341);var l=a(9).Object;t.exports=function(t,e,a){return l.defineProperty(t,e,a)}},341:function(t,e,a){var l=a(26);l(l.S+l.F*!a(10),"Object",{defineProperty:a(11).f})},370:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l=a(339),s=a.n(l),r=a(18),o=a.n(r);e.default={components:{IconSvg:o.a},data:function(){var t;return{activeName2:"first",rules:{id:[{required:!0,message:"请输入项目编号",trigger:"blur"}],name:[{required:!0,message:"请输入项目名称",trigger:"blur"},{min:3,max:5,message:"长度在 3 到 5 个字符",trigger:"blur"}]},taskEnableList:new Array(8),form:(t={id:"",name:"",cnid:"",cnname:"",scnid:"",scnname:"",cid:"",ccmpname:"",type:"1",prior:"",plandate:"",brief:"",memo:"",region:"",date1:"",date2:"",delivery:!1},s()(t,"type","1"),s()(t,"resource",""),s()(t,"desc",""),s()(t,"detectionCheckList",[]),s()(t,"amount",0),s()(t,"others",""),s()(t,"work",{c1:{check:!1,content:"",method:""},c2:{check:!1,content:"",method:""}}),t)}},methods:{submitForm:function(){var t=this;this.$refs.form.validate(function(e){if(!e)return console.log("error submit!!"),t.$alert("信息填写错误"),!1;alert("submit!")})},handleClick:function(t,e){console.log(t,e)},changeTaskStatus:function(t){this.$set(this.taskEnableList,t,!this.taskEnableList[t])}}}},375:function(t,e,a){e=t.exports=a(301)(!0),e.push([t.i,'.task-line-wrapper[data-v-5f7f9860]{position:absolute;left:0;top:30px;bottom:50px;margin-left:-10px;box-sizing:border-box;width:16.66%;text-align:center}.task-line-wrapper .task-line[data-v-5f7f9860]{display:inline-block;width:2px;height:100%;background-color:#d3dce6}.task-item-wrapper[data-v-5f7f9860]{margin:15px 0}.task-item-wrapper.disable input[data-v-5f7f9860],.task-item-wrapper.disable select[data-v-5f7f9860]{pointer-events:none}.task-item-wrapper.disable .task-icon[data-v-5f7f9860]{fill:#becbff!important}.task-item-wrapper.disable .task-text[data-v-5f7f9860]{color:#becbff!important}.task-item-wrapper .task-icon-wrapper[data-v-5f7f9860]{text-align:center;position:relative;z-index:10;background-color:#fff;padding:10px}.task-item-wrapper .task-icon-wrapper .task-icon[data-v-5f7f9860]{width:48px;height:40px;fill:#5c7dfe}.task-item-wrapper .task-icon-wrapper .task-text[data-v-5f7f9860]{color:#5c7dfe;font-size:14px}.task-item-wrapper .task-item-content[data-v-5f7f9860]{background-color:#f7f8fc;border-radius:10px;padding-top:22px;position:relative}.task-item-wrapper .task-item-content[data-v-5f7f9860]:after{color:#fff;content:"";position:absolute;width:0;height:0;border:8px solid;border-right-color:#f7f8fc;top:30px;left:-15px;z-index:100}',"",{version:3,sources:["D:/idea_workspace/lims/lims-client/src/views/page/tabs/projectDetailTab.vue"],names:[],mappings:"AACA,oCACE,kBAAmB,AACnB,OAAQ,AACR,SAAU,AACV,YAAa,AACb,kBAAmB,AACnB,sBAAuB,AACvB,aAAc,AACd,iBAAmB,CACpB,AACD,+CACI,qBAAsB,AACtB,UAAW,AACX,YAAa,AACb,wBAA0B,CAC7B,AACD,oCACE,aAAe,CAChB,AACD,qGACI,mBAAqB,CACxB,AACD,uDACI,sBAAyB,CAC5B,AACD,uDACI,uBAA0B,CAC7B,AACD,uDACI,kBAAmB,AACnB,kBAAmB,AACnB,WAAY,AACZ,sBAAuB,AACvB,YAAc,CACjB,AACD,kEACM,WAAY,AACZ,YAAa,AACb,YAAc,CACnB,AACD,kEACM,cAAe,AACf,cAAgB,CACrB,AACD,uDACI,yBAA0B,AAC1B,mBAAoB,AACpB,iBAAkB,AAClB,iBAAmB,CACtB,AACD,6DACM,WAAa,AACb,WAAY,AACZ,kBAAmB,AACnB,QAAS,AACT,SAAU,AACV,iBAAkB,AAClB,2BAA4B,AAC5B,SAAU,AACV,WAAY,AACZ,WAAa,CAClB",file:"projectDetailTab.vue",sourcesContent:["\n.task-line-wrapper[data-v-5f7f9860] {\n  position: absolute;\n  left: 0;\n  top: 30px;\n  bottom: 50px;\n  margin-left: -10px;\n  box-sizing: border-box;\n  width: 16.66%;\n  text-align: center;\n}\n.task-line-wrapper .task-line[data-v-5f7f9860] {\n    display: inline-block;\n    width: 2px;\n    height: 100%;\n    background-color: #d3dce6;\n}\n.task-item-wrapper[data-v-5f7f9860] {\n  margin: 15px 0;\n}\n.task-item-wrapper.disable input[data-v-5f7f9860], .task-item-wrapper.disable select[data-v-5f7f9860] {\n    pointer-events: none;\n}\n.task-item-wrapper.disable .task-icon[data-v-5f7f9860] {\n    fill: #BECBFF !important;\n}\n.task-item-wrapper.disable .task-text[data-v-5f7f9860] {\n    color: #BECBFF !important;\n}\n.task-item-wrapper .task-icon-wrapper[data-v-5f7f9860] {\n    text-align: center;\n    position: relative;\n    z-index: 10;\n    background-color: #fff;\n    padding: 10px;\n}\n.task-item-wrapper .task-icon-wrapper .task-icon[data-v-5f7f9860] {\n      width: 48px;\n      height: 40px;\n      fill: #5c7dfe;\n}\n.task-item-wrapper .task-icon-wrapper .task-text[data-v-5f7f9860] {\n      color: #5c7dfe;\n      font-size: 14px;\n}\n.task-item-wrapper .task-item-content[data-v-5f7f9860] {\n    background-color: #f7f8fc;\n    border-radius: 10px;\n    padding-top: 22px;\n    position: relative;\n}\n.task-item-wrapper .task-item-content[data-v-5f7f9860]:after {\n      color: white;\n      content: '';\n      position: absolute;\n      width: 0;\n      height: 0;\n      border: 8px solid;\n      border-right-color: #f7f8fc;\n      top: 30px;\n      left: -15px;\n      z-index: 100;\n}\n"],sourceRoot:""}])},380:function(t,e,a){var l=a(375);"string"==typeof l&&(l=[[t.i,l,""]]),l.locals&&(t.exports=l.locals);a(302)("a226516e",l,!0)},385:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-form",{ref:"form",attrs:{"label-position":"right",rules:t.rules,model:t.form,"label-width":"100px"}},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"项目编号",prop:"id"}},[a("el-input",{model:{value:t.form.id,callback:function(e){t.form.id=e},expression:"form.id"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10,offset:1}},[a("el-form-item",{attrs:{label:"项目名称",prop:"name"}},[a("el-input",{model:{value:t.form.name,callback:function(e){t.form.name=e},expression:"form.name"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:3}},[a("el-button",{on:{click:function(e){t.$router.push({name:"sample1",query:{type:1}})}}},[t._v("导入合同")])],1)],1),t._v(" "),a("hr"),t._v(" "),a("div",{staticClass:"form-group-title"},[t._v("合同摘要")]),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"合同编号"}},[a("el-input",{model:{value:t.form.cnid,callback:function(e){t.form.cnid=e},expression:"form.cnid"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:13,offset:1}},[a("el-form-item",{attrs:{label:"合同名称"}},[a("el-input",{model:{value:t.form.cnname,callback:function(e){t.form.cnname=e},expression:"form.cnname"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"子合同编号"}},[a("el-input",{model:{value:t.form.scnid,callback:function(e){t.form.scnid=e},expression:"form.scnid"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:13,offset:1}},[a("el-form-item",{attrs:{label:"子合同名称"}},[a("el-input",{model:{value:t.form.scnname,callback:function(e){t.form.scnname=e},expression:"form.scnname"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"商机编号"}},[a("el-input",{model:{value:t.form.cnid,callback:function(e){t.form.cnid=e},expression:"form.cnid"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:13,offset:1}},[a("el-form-item",{attrs:{label:"临时合同"}},[a("el-input",{model:{value:t.form.cnname,callback:function(e){t.form.cnname=e},expression:"form.cnname"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"客户代表"}},[a("el-input",{model:{value:t.form.cnid,callback:function(e){t.form.cnid=e},expression:"form.cnid"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:13,offset:1}},[a("el-form-item",{attrs:{label:"合同备注"}},[a("el-input",{model:{value:t.form.cnname,callback:function(e){t.form.cnname=e},expression:"form.cnname"}})],1)],1)],1),t._v(" "),a("hr"),t._v(" "),a("div",{staticClass:"form-group-title"},[t._v("项目摘要")]),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户编号"}},[a("el-input",{model:{value:t.form.cid,callback:function(e){t.form.cid=e},expression:"form.cid"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:16}},[a("el-form-item",{attrs:{label:"客户单位"}},[a("el-input",{model:{value:t.form.ccmpname,callback:function(e){t.form.ccmpname=e},expression:"form.ccmpname"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户姓名"}},[a("el-input",{model:{value:t.form.cid,callback:function(e){t.form.cid=e},expression:"form.cid"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户电话"}},[a("el-input",{model:{value:t.form.ccmpname,callback:function(e){t.form.ccmpname=e},expression:"form.ccmpname"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"Email"}},[a("el-input",{model:{value:t.form.ccmpname,callback:function(e){t.form.ccmpname=e},expression:"form.ccmpname"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"项目类型"}},[a("el-radio",{staticClass:"radio",attrs:{label:"1",value:"1"},model:{value:t.form.type,callback:function(e){t.form.type=e},expression:"form.type"}},[t._v("收费")]),t._v(" "),a("el-radio",{staticClass:"radio",attrs:{label:"2",value:"2"},model:{value:t.form.type,callback:function(e){t.form.type=e},expression:"form.type"}},[t._v("免费")])],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"优先级别"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"计划完成时间"}},[a("el-date-picker",{attrs:{align:"right",type:"date",placeholder:"选择日期"},model:{value:t.form.plandate,callback:function(e){t.form.plandate=e},expression:"form.plandate"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"概要备注"}},[a("el-input",{model:{value:t.form.brief,callback:function(e){t.form.brief=e},expression:"form.brief"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"特殊要求"}},[a("el-input",{attrs:{type:"textarea",rows:4,placeholder:"请输入内容"},model:{value:t.form.memo,callback:function(e){t.form.memo=e},expression:"form.memo"}})],1)],1)],1),t._v(" "),a("hr"),t._v(" "),a("div",{staticClass:"form-group-title"},[t._v("工作任务")]),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("div",{staticClass:"task-line-wrapper"},[a("div",{staticClass:"task-line"})]),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[0]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(0)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"ybtq-sel"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("样本提取")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"提取内容"}},[a("el-select",{attrs:{disabled:t.taskEnableList[0],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"提取方法"}},[a("el-select",{attrs:{disabled:t.taskEnableList[0],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[1]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(1)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"ybjc-sel"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("样本检测")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-form-item",{attrs:{label:"检测方法"}},[a("el-checkbox-group",{model:{value:t.form.detectionCheckList,callback:function(e){t.form.detectionCheckList=e},expression:"form.detectionCheckList"}},[a("el-checkbox",{attrs:{disabled:t.taskEnableList[1],label:"电泳"}}),t._v(" "),a("el-checkbox",{attrs:{disabled:t.taskEnableList[1],label:"Nano Drop"}}),t._v(" "),a("el-checkbox",{attrs:{disabled:t.taskEnableList[1],label:"Qubit"}}),t._v(" "),a("el-checkbox",{attrs:{disabled:t.taskEnableList[1],label:"AB2100"}})],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[2]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(2)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"wkgj-sel"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("文库构建")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"测序平台"}},[a("el-select",{attrs:{disabled:t.taskEnableList[2],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"测试盒"}},[a("el-select",{attrs:{disabled:t.taskEnableList[2],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[3]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(3)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"wkjc-sel"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("文库检测")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"测序平台"}},[a("el-select",{attrs:{disabled:t.taskEnableList[3],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"测试策略"}},[a("el-select",{attrs:{disabled:t.taskEnableList[3],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[4]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(4)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"wkdl-sel"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("文库定量")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"测序平台"}},[a("el-select",{attrs:{disabled:t.taskEnableList[4],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"测试策略"}},[a("el-select",{attrs:{disabled:t.taskEnableList[4],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"数据量"}},[a("el-input",{attrs:{disabled:t.taskEnableList[4]},model:{value:t.form.amount,callback:function(e){t.form.amount=e},expression:"form.amount"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"单位"}},[a("el-select",{attrs:{disabled:t.taskEnableList[4],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[5]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(5)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"cxjg-nor"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("测试结果QC")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"待定内容"}},[a("el-select",{attrs:{disabled:t.taskEnableList[5],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"待定内容"}},[a("el-select",{attrs:{disabled:t.taskEnableList[5],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[6]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(6)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"sxfx-nor"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("生信分析")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"待定内容"}},[a("el-select",{attrs:{disabled:t.taskEnableList[6],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"待定内容"}},[a("el-select",{attrs:{disabled:t.taskEnableList[6],placeholder:"请选择"},model:{value:t.form.prior,callback:function(e){t.form.prior=e},expression:"form.prior"}},[a("el-option",{attrs:{value:3}}),t._v(" "),a("el-option",{attrs:{value:2}}),t._v(" "),a("el-option",{attrs:{value:1}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticClass:"task-item-wrapper",class:{disable:t.taskEnableList[7]},attrs:{gutter:20}},[a("el-col",{staticClass:"task-icon-wrapper",attrs:{span:4},nativeOn:{click:function(e){t.changeTaskStatus(7)}}},[a("icon-svg",{staticClass:"task-icon",attrs:{"icon-class":"other-nor"}}),t._v(" "),a("div",{staticClass:"task-text"},[t._v("其他")])],1),t._v(" "),a("el-col",{staticClass:"task-item-content",attrs:{span:20}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"其他"}},[a("el-input",{attrs:{disabled:t.taskEnableList[7],placeholder:"请输入内容"},model:{value:t.form.others,callback:function(e){t.form.others=e},expression:"form.others"}})],1)],1)],1)],1)],1),t._v(" "),a("hr"),t._v(" "),a("el-row",[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.submitForm()}}},[t._v("保存")])],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=7.163aa8ee77413b0e619c.js.map