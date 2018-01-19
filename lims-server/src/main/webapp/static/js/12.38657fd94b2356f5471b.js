webpackJsonp([12],{

/***/ 330:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(435)
}
var Component = __webpack_require__(4)(
  /* script */
  __webpack_require__(408),
  /* template */
  __webpack_require__(458),
  /* styles */
  injectStyle,
  /* scopeId */
  "data-v-2a15f1dc",
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 342:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony default export */ __webpack_exports__["a"] = ({
  name: 'ElCol',

  props: {
    span: {
      type: Number,
      default: 24
    },
    tag: {
      type: String,
      default: 'div'
    },
    offset: Number,
    pull: Number,
    push: Number,
    xs: [Number, Object],
    sm: [Number, Object],
    md: [Number, Object],
    lg: [Number, Object]
  },

  computed: {
    gutter() {
      let parent = this.$parent;
      while (parent && parent.$options.componentName !== 'ElRow') {
        parent = parent.$parent;
      }
      return parent ? parent.gutter : 0;
    }
  },
  render(h) {
    let classList = [];
    let style = {};

    if (this.gutter) {
      style.paddingLeft = this.gutter / 2 + 'px';
      style.paddingRight = style.paddingLeft;
    }

    ['span', 'offset', 'pull', 'push'].forEach(prop => {
      if (this[prop]) {
        classList.push(
          prop !== 'span'
          ? `el-col-${prop}-${this[prop]}`
          : `el-col-${this[prop]}`
        );
      }
    });

    ['xs', 'sm', 'md', 'lg'].forEach(size => {
      if (typeof this[size] === 'number') {
        classList.push(`el-col-${size}-${this[size]}`);
      } else if (typeof this[size] === 'object') {
        let props = this[size];
        Object.keys(props).forEach(prop => {
          classList.push(
            prop !== 'span'
            ? `el-col-${size}-${prop}-${props[prop]}`
            : `el-col-${size}-${props[prop]}`
          );
        });
      }
    });

    return h(this.tag, {
      class: ['el-col', classList],
      style
    }, this.$slots.default);
  }
});


/***/ }),

/***/ 362:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__utils_fetch__ = __webpack_require__(37);


/* harmony default export */ __webpack_exports__["a"] = ({
    /*获取任务列表*/
    getList: function getList(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/task',
            method: 'get',
            params: data
        });
    },

    /*任务调度*/
    dispatch: function dispatch(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/task/' + data.projectId,
            method: 'post',
            data: data.tasks
        });
    }
});

/***/ }),

/***/ 408:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_element_ui_packages_col_src_col__ = __webpack_require__(342);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__api_task__ = __webpack_require__(362);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//




/* harmony default export */ __webpack_exports__["default"] = ({
    components: {
        ElCol: __WEBPACK_IMPORTED_MODULE_0_element_ui_packages_col_src_col__["a" /* default */]
    },
    mounted: function mounted() {
        var path = this.$route.path;
        this.filter.taskStatus = Number(path.substr(path.lastIndexOf("/") + 1));
        if (!this.filter.taskStatus) {
            this.filter.taskStatus = null;
        }
        this.getData();
    },
    data: function data() {
        return {
            filter: {
                taskId: null,
                projectNo: null,
                projectStatus: null,
                taskStatus: null,
                projectName: null,
                page: 1,
                length: 10
            },
            tableDataList: [],
            totalPage: 0,
            totalCount: 0,
            projectStatusList: this.GLOBAL.projectStatusList,
            taskStatusList: this.GLOBAL.taskStatusList
        };
    },

    methods: {
        viewDetail: function viewDetail(task) {
            this.$store.commit("setProjectNo", task.project.no);
            this.$store.commit("setProjectId", task.project.id);
            this.$router.push({
                name: 'projectDetail',
                query: { title: 'task', projectId: task.project.id }
            });
        },
        getData: function getData() {
            var _this = this;

            __WEBPACK_IMPORTED_MODULE_1__api_task__["a" /* default */].getList(this.filter).then(function (response) {
                if (response.code == 0) {
                    _this.tableDataList = response.data.rows;
                    _this.totalPage = response.totalPage;
                    _this.totalCount = response.data.totalCount;
                }
            });
        },
        handleFilter: function handleFilter() {
            this.getData();
        },

        // 分页
        handleSizeChange: function handleSizeChange(val) {
            this.filter.length = val;
            this.getData();
        },
        handleCurrentChange: function handleCurrentChange(val) {
            this.filter.page = val;
            this.getData();
        }
    }
});

/***/ }),

/***/ 419:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(301)(true);
// imports


// module
exports.push([module.i, ".el-form-item span[data-v-2a15f1dc]{width:180px;display:inline-block;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.seachpre[data-v-2a15f1dc]{width:74px}.filter-div[data-v-2a15f1dc]{margin:1% auto}.table-button[data-v-2a15f1dc]{width:100px;height:36px;margin-left:20px;margin-right:20px!important;border:1px solid #5c7dfe;border-radius:4px!important}.filter-date[data-v-2a15f1dc],.filter-input[data-v-2a15f1dc],.filter-select[data-v-2a15f1dc]{width:10%;margin-right:1%}.filter-label[data-v-2a15f1dc]{font-size:10pt}.buttonWrapper[data-v-2a15f1dc]{font-size:12px;float:right}.buttonWrapper .cancle[data-v-2a15f1dc],.buttonWrapper .confirm[data-v-2a15f1dc]{width:76px;padding:7px 15px}.buttonWrapper .confirm[data-v-2a15f1dc]{color:#5c7dfe;border:1px solid #5c7dfe}.buttonWrapper .cancle[data-v-2a15f1dc]{color:#f55f80;border:1px solid #f55f80}.tableEditWrapper[data-v-2a15f1dc]{float:right}.tableEditWrapper .edit[data-v-2a15f1dc]{width:102px;padding:8px 15px;font-size:13px;color:#5c7dfe;border:1px solid #5c7dfe}.tableEditWrapper .cancle[data-v-2a15f1dc]{width:102px;padding:8px 15px;font-size:13px;color:#f55f80;border:1px solid #f55f80}.el-pagination[data-v-2a15f1dc]{text-align:right;padding:10px 0;float:right}.el-pagination__total[data-v-2a15f1dc]{float:left}.leftReset[data-v-2a15f1dc]{padding-right:20px!important}.rightTitle[data-v-2a15f1dc]{height:50px;padding:18px 0 18px 10px;line-height:50px;box-sizing:border-box;background-color:#eff2f7}.rightTitle .form-group-title[data-v-2a15f1dc]{margin:0}.table[data-v-2a15f1dc]{color:#2f3445;font-size:13px;border:1px solid #e0e6ed}.table .thead[data-v-2a15f1dc]{background-color:#e5e9f2}.table .thead th[data-v-2a15f1dc]{width:130px;height:44px;text-align:center;border-right:1px solid #e0e6ed}.table .tbody tr[data-v-2a15f1dc]{height:46px;width:130px;text-align:center;border-top:1px solid #e0e6ed}.table .tbody tr td[data-v-2a15f1dc]{border-right:1px solid #e0e6ed}.table .tbody tr .modifyTrData[data-v-2a15f1dc]{color:#5c7dfe}", "", {"version":3,"sources":["D:/idea_workspace/lims/lims-client/src/views/page/task/list.vue"],"names":[],"mappings":"AACA,oCACE,YAAa,AACb,qBAAsB,AACtB,mBAAoB,AACpB,gBAAiB,AACjB,sBAAwB,CACzB,AACD,2BACE,UAAY,CACb,AACD,6BACE,cAAgB,CACjB,AACD,+BACE,YAAa,AACb,YAAa,AACb,iBAAkB,AAClB,4BAA8B,AAC9B,yBAA0B,AAC1B,2BAA8B,CAC/B,AASD,6FACE,UAAW,AACX,eAAiB,CAClB,AACD,+BACE,cAAgB,CACjB,AACD,gCACE,eAAgB,AAChB,WAAa,CACd,AACD,iFAEI,WAAY,AACZ,gBAAkB,CACrB,AACD,yCACI,cAAe,AACf,wBAA0B,CAC7B,AACD,wCACI,cAAe,AACf,wBAA0B,CAC7B,AACD,mCACE,WAAa,CACd,AACD,yCACI,YAAa,AACb,iBAAkB,AAClB,eAAgB,AAChB,cAAe,AACf,wBAA0B,CAC7B,AACD,2CACI,YAAa,AACb,iBAAkB,AAClB,eAAgB,AAChB,cAAe,AACf,wBAA0B,CAC7B,AACD,gCACE,iBAAkB,AAClB,eAAgB,AAChB,WAAa,CACd,AACD,uCACE,UAAY,CACb,AACD,4BACE,4BAA+B,CAChC,AACD,6BACE,YAAa,AACb,yBAA0B,AAC1B,iBAAkB,AAClB,sBAAuB,AACvB,wBAA0B,CAC3B,AACD,+CACI,QAAU,CACb,AACD,wBACE,cAAe,AACf,eAAgB,AAChB,wBAA0B,CAC3B,AACD,+BACI,wBAA0B,CAC7B,AACD,kCACM,YAAa,AACb,YAAa,AACb,kBAAmB,AACnB,8BAAgC,CACrC,AACD,kCACI,YAAa,AACb,YAAa,AACb,kBAAmB,AACnB,4BAA8B,CACjC,AACD,qCACM,8BAAgC,CACrC,AACD,gDACM,aAAe,CACpB","file":"list.vue","sourcesContent":["\n.el-form-item span[data-v-2a15f1dc] {\n  width: 180px;\n  display: inline-block;\n  white-space: nowrap;\n  overflow: hidden;\n  text-overflow: ellipsis;\n}\n.seachpre[data-v-2a15f1dc] {\n  width: 74px;\n}\n.filter-div[data-v-2a15f1dc] {\n  margin: 1% auto;\n}\n.table-button[data-v-2a15f1dc] {\n  width: 100px;\n  height: 36px;\n  margin-left: 20px;\n  margin-right: 20px !important;\n  border: 1px solid #5c7dfe;\n  border-radius: 4px !important;\n}\n.filter-date[data-v-2a15f1dc] {\n  width: 10%;\n  margin-right: 1%;\n}\n.filter-input[data-v-2a15f1dc] {\n  width: 10%;\n  margin-right: 1%;\n}\n.filter-select[data-v-2a15f1dc] {\n  width: 10%;\n  margin-right: 1%;\n}\n.filter-label[data-v-2a15f1dc] {\n  font-size: 10pt;\n}\n.buttonWrapper[data-v-2a15f1dc] {\n  font-size: 12px;\n  float: right;\n}\n.buttonWrapper .confirm[data-v-2a15f1dc],\n  .buttonWrapper .cancle[data-v-2a15f1dc] {\n    width: 76px;\n    padding: 7px 15px;\n}\n.buttonWrapper .confirm[data-v-2a15f1dc] {\n    color: #5c7dfe;\n    border: 1px solid #5c7dfe;\n}\n.buttonWrapper .cancle[data-v-2a15f1dc] {\n    color: #f55f80;\n    border: 1px solid #f55f80;\n}\n.tableEditWrapper[data-v-2a15f1dc] {\n  float: right;\n}\n.tableEditWrapper .edit[data-v-2a15f1dc] {\n    width: 102px;\n    padding: 8px 15px;\n    font-size: 13px;\n    color: #5c7dfe;\n    border: 1px solid #5c7dfe;\n}\n.tableEditWrapper .cancle[data-v-2a15f1dc] {\n    width: 102px;\n    padding: 8px 15px;\n    font-size: 13px;\n    color: #f55f80;\n    border: 1px solid #f55f80;\n}\n.el-pagination[data-v-2a15f1dc] {\n  text-align: right;\n  padding: 10px 0;\n  float: right;\n}\n.el-pagination__total[data-v-2a15f1dc] {\n  float: left;\n}\n.leftReset[data-v-2a15f1dc] {\n  padding-right: 20px !important;\n}\n.rightTitle[data-v-2a15f1dc] {\n  height: 50px;\n  padding: 18px 0 18px 10px;\n  line-height: 50px;\n  box-sizing: border-box;\n  background-color: #eff2f7;\n}\n.rightTitle .form-group-title[data-v-2a15f1dc] {\n    margin: 0;\n}\n.table[data-v-2a15f1dc] {\n  color: #2f3445;\n  font-size: 13px;\n  border: 1px solid #e0e6ed;\n}\n.table .thead[data-v-2a15f1dc] {\n    background-color: #e5e9f2;\n}\n.table .thead th[data-v-2a15f1dc] {\n      width: 130px;\n      height: 44px;\n      text-align: center;\n      border-right: 1px solid #e0e6ed;\n}\n.table .tbody tr[data-v-2a15f1dc] {\n    height: 46px;\n    width: 130px;\n    text-align: center;\n    border-top: 1px solid #e0e6ed;\n}\n.table .tbody tr td[data-v-2a15f1dc] {\n      border-right: 1px solid #e0e6ed;\n}\n.table .tbody tr .modifyTrData[data-v-2a15f1dc] {\n      color: #5c7dfe;\n}\n"],"sourceRoot":""}]);

// exports


/***/ }),

/***/ 435:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(419);
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
// add the styles to the DOM
var update = __webpack_require__(302)("46c79292", content, true);

/***/ }),

/***/ 458:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('el-row', {
    attrs: {
      "gutter": 20
    }
  }, [_c('el-col', {
    staticClass: "leftReset",
    attrs: {
      "span": 24
    }
  }, [_c('el-form', {
    attrs: {
      "label-position": "right"
    }
  }, [_c('el-row', {
    attrs: {
      "type": "flex",
      "align": "middle"
    }
  }, [_c('el-col', {
    attrs: {
      "span": 4
    }
  }, [_c('div', {
    staticClass: "form-group-title"
  }, [_vm._v("任务列表")])])], 1), _vm._v(" "), _c('el-row', {
    attrs: {
      "type": "flex",
      "align": "middle"
    }
  }, [_c('el-col', {
    attrs: {
      "span": 24
    }
  }, [_c('div', {
    staticClass: "filter-container filter-div"
  }, [_c('span', {
    staticClass: "filter-label"
  }, [_vm._v("任务编号")]), _vm._v(" "), _c('el-input', {
    staticClass: "filter-input",
    attrs: {
      "placeholder": "任务编号"
    },
    model: {
      value: (_vm.filter.taskId),
      callback: function($$v) {
        _vm.filter.taskId = $$v
      },
      expression: "filter.taskId"
    }
  }), _vm._v(" "), _c('span', {
    staticClass: "filter-label"
  }, [_vm._v("任务状态")]), _vm._v(" "), _c('el-select', {
    staticClass: "filter-select",
    attrs: {
      "placeholder": "请选择"
    },
    model: {
      value: (_vm.filter.taskStatus),
      callback: function($$v) {
        _vm.filter.taskStatus = $$v
      },
      expression: "filter.taskStatus"
    }
  }, _vm._l((_vm.taskStatusList), function(item) {
    return _c('el-option', {
      key: item.value,
      attrs: {
        "label": item.label,
        "value": item.value
      }
    })
  })), _vm._v(" "), _c('span', {
    staticClass: "filter-label"
  }, [_vm._v("项目编号")]), _vm._v(" "), _c('el-input', {
    staticClass: "filter-input",
    attrs: {
      "placeholder": "项目编号"
    },
    model: {
      value: (_vm.filter.projectNo),
      callback: function($$v) {
        _vm.filter.projectNo = $$v
      },
      expression: "filter.projectNo"
    }
  }), _vm._v(" "), _c('span', {
    staticClass: "filter-label"
  }, [_vm._v("项目名称")]), _vm._v(" "), _c('el-input', {
    staticClass: "filter-input",
    attrs: {
      "placeholder": "项目名称"
    },
    model: {
      value: (_vm.filter.projectName),
      callback: function($$v) {
        _vm.filter.projectName = $$v
      },
      expression: "filter.projectName"
    }
  }), _vm._v(" "), _c('span', {
    staticClass: "filter-label"
  }, [_vm._v("项目状态")]), _vm._v(" "), _c('el-select', {
    staticClass: "filter-select",
    attrs: {
      "placeholder": "请选择"
    },
    model: {
      value: (_vm.filter.projectStatus),
      callback: function($$v) {
        _vm.filter.projectStatus = $$v
      },
      expression: "filter.projectStatus"
    }
  }, _vm._l((_vm.projectStatusList), function(item) {
    return _c('el-option', {
      key: item.value,
      attrs: {
        "label": item.label,
        "value": item.value
      }
    })
  })), _vm._v(" "), _c('el-button', {
    attrs: {
      "type": "primary",
      "icon": "search"
    },
    on: {
      "click": _vm.handleFilter
    }
  }, [_vm._v("查询")])], 1)])], 1), _vm._v(" "), _c('table', {
    staticClass: "table"
  }, [_c('thead', {
    staticClass: "thead"
  }, [_c('tr', [_c('th', [_vm._v("任务编号")]), _vm._v(" "), _c('th', [_vm._v("项目编号")]), _vm._v(" "), _c('th', [_vm._v("项目名称")]), _vm._v(" "), _c('th', [_vm._v("工作内容")]), _vm._v(" "), _c('th', [_vm._v("样品数量")]), _vm._v(" "), _c('th', [_vm._v("计划开始时间")]), _vm._v(" "), _c('th', [_vm._v("计划完成时间")]), _vm._v(" "), _c('th', [_vm._v("实际开始时间")]), _vm._v(" "), _c('th', [_vm._v("实际完成时间")]), _vm._v(" "), _c('th', [_vm._v("任务状态")]), _vm._v(" "), _c('th', [_vm._v("操作员")]), _vm._v(" "), _c('th', [_vm._v("操作")])])]), _vm._v(" "), _c('tbody', {
    staticClass: "tbody"
  }, _vm._l((_vm.tableDataList), function(list, $index) {
    return _c('tr', [_c('td', [_vm._v(_vm._s(list.id))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.project.no))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.project.name))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.job.typeDesc))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.sampleAmount))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.planStartTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.planCompleteTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.actualStartTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.actualCompleteTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.statusDesc))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.operator == null ? null : list.operator.nickname))]), _vm._v(" "), _c('td', {
      staticClass: "modifyTrData"
    }, [_c('el-button', {
      attrs: {
        "type": "primary",
        "size": "small"
      },
      on: {
        "click": function($event) {
          _vm.viewDetail(list)
        }
      }
    }, [_vm._v("查看")])], 1)])
  }))]), _vm._v(" "), _c('el-row', {
    staticStyle: {
      "margin-top": "20px"
    },
    attrs: {
      "type": "fix",
      "align": "middle"
    }
  }, [_c('el-col', {
    attrs: {
      "span": 16
    }
  }, [_c('el-pagination', {
    attrs: {
      "current-page": _vm.filter.currentPage,
      "page-sizes": [10, 20, 30, 40],
      "page-size": _vm.filter.pageSize,
      "layout": "total, sizes, prev, pager, next, jumper",
      "total": _vm.totalCount
    },
    on: {
      "size-change": _vm.handleSizeChange,
      "current-change": _vm.handleCurrentChange
    }
  })], 1)], 1)], 1)], 1)], 1)
},staticRenderFns: []}

/***/ })

});
//# sourceMappingURL=12.38657fd94b2356f5471b.js.map