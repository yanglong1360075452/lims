webpackJsonp([16],{337:function(e,t,o){function i(e){o(447)}var n=o(4)(o(415),o(479),i,null,null);e.exports=n.exports},415:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=o(416);t.default={name:"inline_edit-table_demo",data:function(){return{list:null,listLoading:!0,listQuery:{page:1,limit:10},currentPage:1}},created:function(){this.getList()},filters:{statusFilter:function(e){return{published:"success",draft:"gray",deleted:"danger"}[e]}},methods:{getList:function(){var e=this;this.listLoading=!0,o.i(i.a)(this.listQuery).then(function(t){e.list=t.map(function(e){return e.edit=!1,e}),e.listLoading=!1})},handleSizeChange:function(e){console.log("每页 "+e+" 条")},handleCurrentChange:function(e){this.currentPage=e,console.log("当前页: "+e)},handleCreate:function(){this.list.splice(0,0,{name:"",status:"draft",productionTime:"",receiptTime:"",pageviews:"",sampleConcentration:"",concentration:"",originalVolumn:"",residualVolume:"",storageBin:"",edit:!0})},handleFilter:function(){getList()},handelDelete:function(e){console.log(e)},handleExport:function(){}}}},416:function(e,t,o){"use strict";function i(e){return o.i(n.a)({url:"/table/list1",method:"get",params:e})}t.a=i;var n=o(37)},431:function(e,t,o){t=e.exports=o(301)(!0),t.push([e.i,".filter-container{padding-bottom:10px}.el-pagination{text-align:right;padding:10px 0}.el-pagination__total{float:left}.el-date-editor .el-input__inner,.el-select .el-input__inner{height:30px}.upload-demo{float:left}.upload-demo .el-button{border-radius:0;border-left:1px solid hsla(0,0%,100%,.5)}","",{version:3,sources:["D:/idea_workspace/lims/lims-client/src/views/table/inlineedit.vue"],names:[],mappings:"AACA,kBACE,mBAAqB,CACtB,AACD,eACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,sBACE,UAAY,CACb,AACD,6DACE,WAAa,CACd,AACD,aACE,UAAY,CACb,AACD,wBACI,gBAAmB,AACnB,wCAAgD,CACnD",file:"inlineedit.vue",sourcesContent:["\n.filter-container {\n  padding-bottom: 10px;\n}\n.el-pagination {\n  text-align: right;\n  padding: 10px 0;\n}\n.el-pagination__total {\n  float: left;\n}\n.el-select .el-input__inner, .el-date-editor .el-input__inner {\n  height: 30px;\n}\n.upload-demo {\n  float: left;\n}\n.upload-demo .el-button {\n    border-radius: 0px;\n    border-left: 1px solid rgba(255, 255, 255, 0.5);\n}\n"],sourceRoot:""}])},447:function(e,t,o){var i=o(431);"string"==typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);o(302)("2d6d8a37",i,!0)},479:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"page-container page-component"},[e._m(0),e._v(" "),o("p",[e._v("用于展示多条结构类似的数据，可对数据行内自定义操作。")]),e._v(" "),o("div",{staticClass:"filter-container"},[e._v("\n    编号/名称\n    "),o("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"标题"},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13))return null;e.handleFilter(t)}},model:{value:e.listQuery.title,callback:function(t){e.listQuery.title=t},expression:"listQuery.title"}}),e._v(" "),o("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",attrs:{type:"primary",icon:"search"},on:{click:e.handleFilter}},[e._v("查询")]),e._v(" "),o("el-button-group",{staticStyle:{float:"right"}},[o("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"edit"},on:{click:e.handleCreate}},[e._v("新建样板")]),e._v(" "),o("el-upload",{staticClass:"upload-demo",attrs:{action:"//jsonplaceholder.typicode.com/posts/","on-preview":e.handlePreview,"on-remove":e.handleRemove,"file-list":e.fileList}},[o("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"document"}},[e._v("导入清单")])],1),e._v(" "),o("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"document"},on:{click:e.handleExport}},[e._v("下载模板")])],1)],1),e._v(" "),o("el-table",{directives:[{name:"loading",rawName:"v-loading.body",value:e.listLoading,expression:"listLoading",modifiers:{body:!0}}],attrs:{data:e.list,"element-loading-text":"拼命加载中",border:"",fit:"","highlight-current-row":""}},[o("el-table-column",{attrs:{align:"center",label:"ID",width:"60px"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.id))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"150px",align:"center",label:"样本名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-input",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],attrs:{size:"small"},model:{value:t.row.name,callback:function(e){t.row.name=e},expression:"scope.row.name"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.name))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"100px",align:"center",label:"送样浓度"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-input",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],attrs:{size:"small"},model:{value:t.row.sampleConcentration,callback:function(e){t.row.sampleConcentration=e},expression:"scope.row.sampleConcentration"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.sampleConcentration))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"100px",label:"实际浓度"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-input",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],attrs:{size:"small"},model:{value:t.row.concentration,callback:function(e){t.row.concentration=e},expression:"scope.row.concentration"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.concentration))])]}}])}),e._v(" "),o("el-table-column",{attrs:{label:"原始体积",width:"100px"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-input",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],attrs:{size:"small"},model:{value:t.row.originalVolumn,callback:function(e){t.row.originalVolumn=e},expression:"scope.row.originalVolumn"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.originalVolumn))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"100px",label:"剩余体积"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-input",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],attrs:{size:"small"},model:{value:t.row.residualVolume,callback:function(e){t.row.residualVolume=e},expression:"scope.row.residualVolume"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.residualVolume))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"180px",label:"生产时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-date-picker",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"生产时间",format:"yyyy-MM-dd"},model:{value:t.row.productionTime,callback:function(e){t.row.productionTime=e},expression:"scope.row.productionTime"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.productionTime))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"180px",label:"接收时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-date-picker",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"接收时间",format:"yyyy-MM-dd"},model:{value:t.row.receiptTime,callback:function(e){t.row.receiptTime=e},expression:"scope.row.receiptTime"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.receiptTime))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"80px",label:"库位"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-input",{directives:[{name:"show",rawName:"v-show",value:t.row.edit,expression:"scope.row.edit"}],attrs:{size:"small"},model:{value:t.row.storageBin,callback:function(e){t.row.storageBin=e},expression:"scope.row.storageBin"}}),e._v(" "),o("span",{directives:[{name:"show",rawName:"v-show",value:!t.row.edit,expression:"!scope.row.edit"}]},[e._v(e._s(t.row.storageBin))])]}}])}),e._v(" "),o("el-table-column",{attrs:{width:"150px",label:"生产状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.edit?e._e():o("div",[o("el-tag",{attrs:{"close-transition":!0,type:t.row.status}},[e._v(e._s(t.row.status))])],1),e._v(" "),t.row.edit?o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"生产状态"},model:{value:t.row.status,callback:function(e){t.row.status=e},expression:"scope.row.status"}},[o("el-option",{attrs:{label:"draft",value:"draft"}}),e._v(" "),o("el-option",{attrs:{label:"published",value:"published"}})],1):e._e()]}}])}),e._v(" "),o("el-table-column",{attrs:{align:"center",label:"操作",width:"180px",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.edit?e._e():o("el-button",{attrs:{type:"primary",size:"small",icon:"edit"},on:{click:function(e){t.row.edit=!0}}},[e._v("修改")]),e._v(" "),t.row.edit?o("el-button",{attrs:{type:"success",size:"small",icon:"edit"},on:{click:function(e){t.row.edit=!1}}},[e._v("完成")]):e._e(),e._v(" "),o("el-button",{attrs:{type:"danger",size:"small",icon:"edit"},on:{click:function(o){e.handelDelete(t)}}},[e._v("删除")])]}}])})],1),e._v(" "),o("div",{staticClass:"block"},[o("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,20,30,40],"page-size":10,layout:"total, sizes, prev, pager, next, jumper",total:400},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)},staticRenderFns:[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("h2",{attrs:{id:"table-biao-ge"}},[o("a",{staticClass:"header-anchor",attrs:{href:"http://element.eleme.io/#/zh-CN/component/table#table-biao-ge","aria-hidden":"true"}}),e._v(" 表格行内编辑")])}]}}});
//# sourceMappingURL=16.b660ed6b931ccf2518fd.js.map