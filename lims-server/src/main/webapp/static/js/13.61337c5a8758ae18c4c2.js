webpackJsonp([13],{

/***/ 321:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(434)
}
var Component = __webpack_require__(4)(
  /* script */
  __webpack_require__(400),
  /* template */
  __webpack_require__(457),
  /* styles */
  injectStyle,
  /* scopeId */
  "data-v-0f8f86e0",
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

/***/ 348:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__utils_fetch__ = __webpack_require__(37);


/* harmony default export */ __webpack_exports__["a"] = ({
    /*创建项目*/
    create: function create(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/project',
            method: 'post',
            data: data
        });
    },

    /*获取项目列表*/
    getList: function getList(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/project',
            method: 'get',
            params: data
        });
    },

    /*根据ID获取项目详情*/
    getById: function getById(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/project/' + data,
            method: 'get'
        });
    },

    /*更新项目信息*/
    update: function update(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/project',
            method: 'put',
            data: data
        });
    },

    /*批量交付生产*/
    delivery: function delivery(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/project/delivery',
            method: 'post',
            data: data
        });
    },

    /*根据项目ID获取样本数*/
    getSampleCount: function getSampleCount(data) {
        return __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__utils_fetch__["a" /* default */])({
            url: '/project/' + data + '/sampleCount',
            method: 'get'
        });
    }
});

/***/ }),

/***/ 400:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_element_ui_packages_col_src_col__ = __webpack_require__(342);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__api_project__ = __webpack_require__(348);
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
        this.filter.projectStatus = Number(path.substr(path.lastIndexOf("/") + 1));
        if (path.indexOf("delivery") != -1) {
            this.delivery = true;
        } else if (path.indexOf("dispatch") != -1) {
            this.dispatch = true;
        }
        this.getData();
    },
    data: function data() {
        return {
            dispatch: false, //任务调度
            delivery: false, //交付生产
            filter: {
                projectNo: null,
                projectStatus: null,
                projectName: null,
                createTime: null,
                productStatus: null,
                page: 1,
                length: 10
            },
            checkAll: false,
            tableDataList: [],
            tableChecked: [],
            totalPage: 0,
            totalCount: 0,
            productStatusList: this.GLOBAL.productStatusList,
            projectStatusList: this.GLOBAL.projectStatusList
        };
    },

    methods: {
        deliveryConfirm: function deliveryConfirm() {
            var _this = this;

            if (this.tableChecked.length == 0) {
                this.$message({ type: 'info', message: '请选择交付的项目' });
            } else {
                __WEBPACK_IMPORTED_MODULE_1__api_project__["a" /* default */].delivery(this.tableChecked).then(function (response) {
                    if (response.code == 0) {
                        _this.$message({ type: 'success', message: '项目已交付生产' });
                        _this.getData();
                    }
                });
            }
        },
        viewDetail: function viewDetail(project) {
            this.$store.commit("setProjectNo", project.no);
            this.$store.commit("setProjectId", project.id);
            if (this.dispatch) {
                this.$router.push({ name: 'projectDetail', query: { title: 'task', projectId: project.id } });
            } else {
                this.$router.push({ name: 'projectDetail', query: { title: 'project', projectId: project.id } });
            }
        },
        getData: function getData() {
            var _this2 = this;

            var createTime = this.filter.createTime;
            if (createTime != null && createTime != undefined) {
                createTime.getTime();
                this.filter.createTime = new Date(createTime).getTime();
            }
            __WEBPACK_IMPORTED_MODULE_1__api_project__["a" /* default */].getList(this.filter).then(function (response) {
                if (response.code == 0) {
                    _this2.tableDataList = response.data.rows;
                    _this2.totalPage = response.totalPage;
                    _this2.totalCount = response.data.totalCount;
                    _this2.filter.projectStatus = _this2.filter.projectStatus;
                }
            });
        },
        handleFilter: function handleFilter() {
            this.getData();
        },

        // 全选、单选
        changeState: function changeState() {
            var _this3 = this;

            var checked = this.checkAll;
            this.tableDataList.forEach(function (item) {
                _this3.$set(item, "checked", checked);
                if (checked) {
                    if (_this3.tableChecked.indexOf(item.id) == -1) {
                        _this3.tableChecked.push(item.id);
                    }
                } else {
                    _this3.tableChecked.pop(item.id);
                }
            });
        },
        singleSelect: function singleSelect(item) {
            if (item.checked) {
                this.tableChecked.push(item.id);
            } else {
                this.tableChecked.pop(item.id);
            }
            var selectData = this.tableDataList.filter(function (item) {
                return item.checked == true;
            });
            // 全选与否
            selectData.length == this.tableDataList.length ? this.checkAll = true : this.checkAll = false;
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

/***/ 418:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(301)(true);
// imports


// module
exports.push([module.i, ".el-form-item span[data-v-0f8f86e0]{width:180px;display:inline-block;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.seachpre[data-v-0f8f86e0]{width:74px}.filter-div[data-v-0f8f86e0]{margin:1% auto}.table-button[data-v-0f8f86e0]{width:100px;height:36px;margin-left:20px;margin-right:20px!important;border:1px solid #5c7dfe;border-radius:4px!important}.filter-date[data-v-0f8f86e0],.filter-input[data-v-0f8f86e0],.filter-select[data-v-0f8f86e0]{width:10%;margin-right:1%}.filter-label[data-v-0f8f86e0]{font-size:10pt}.buttonWrapper[data-v-0f8f86e0]{font-size:12px;float:right}.buttonWrapper .cancle[data-v-0f8f86e0],.buttonWrapper .confirm[data-v-0f8f86e0]{width:76px;padding:7px 15px}.buttonWrapper .confirm[data-v-0f8f86e0]{color:#5c7dfe;border:1px solid #5c7dfe}.buttonWrapper .cancle[data-v-0f8f86e0]{color:#f55f80;border:1px solid #f55f80}.tableEditWrapper[data-v-0f8f86e0]{float:right}.tableEditWrapper .edit[data-v-0f8f86e0]{width:102px;padding:8px 15px;font-size:13px;color:#5c7dfe;border:1px solid #5c7dfe}.tableEditWrapper .cancle[data-v-0f8f86e0]{width:102px;padding:8px 15px;font-size:13px;color:#f55f80;border:1px solid #f55f80}.el-pagination[data-v-0f8f86e0]{text-align:right;padding:10px 0;float:right}.el-pagination__total[data-v-0f8f86e0]{float:left}.leftReset[data-v-0f8f86e0]{padding-right:20px!important}.rightTitle[data-v-0f8f86e0]{height:50px;padding:18px 0 18px 10px;line-height:50px;box-sizing:border-box;background-color:#eff2f7}.rightTitle .form-group-title[data-v-0f8f86e0]{margin:0}.table[data-v-0f8f86e0]{color:#2f3445;font-size:13px;border:1px solid #e0e6ed}.table .thead[data-v-0f8f86e0]{background-color:#e5e9f2}.table .thead th[data-v-0f8f86e0]{width:130px;height:44px;text-align:center;border-right:1px solid #e0e6ed}.table .tbody tr[data-v-0f8f86e0]{height:46px;width:130px;text-align:center;border-top:1px solid #e0e6ed}.table .tbody tr td[data-v-0f8f86e0]{border-right:1px solid #e0e6ed}.table .tbody tr .modifyTrData[data-v-0f8f86e0]{color:#5c7dfe}", "", {"version":3,"sources":["D:/idea_workspace/lims/lims-client/src/views/page/project/list.vue"],"names":[],"mappings":"AACA,oCACE,YAAa,AACb,qBAAsB,AACtB,mBAAoB,AACpB,gBAAiB,AACjB,sBAAwB,CACzB,AACD,2BACE,UAAY,CACb,AACD,6BACE,cAAgB,CACjB,AACD,+BACE,YAAa,AACb,YAAa,AACb,iBAAkB,AAClB,4BAA8B,AAC9B,yBAA0B,AAC1B,2BAA8B,CAC/B,AASD,6FACE,UAAW,AACX,eAAiB,CAClB,AACD,+BACE,cAAgB,CACjB,AACD,gCACE,eAAgB,AAChB,WAAa,CACd,AACD,iFAEI,WAAY,AACZ,gBAAkB,CACrB,AACD,yCACI,cAAe,AACf,wBAA0B,CAC7B,AACD,wCACI,cAAe,AACf,wBAA0B,CAC7B,AACD,mCACE,WAAa,CACd,AACD,yCACI,YAAa,AACb,iBAAkB,AAClB,eAAgB,AAChB,cAAe,AACf,wBAA0B,CAC7B,AACD,2CACI,YAAa,AACb,iBAAkB,AAClB,eAAgB,AAChB,cAAe,AACf,wBAA0B,CAC7B,AACD,gCACE,iBAAkB,AAClB,eAAgB,AAChB,WAAa,CACd,AACD,uCACE,UAAY,CACb,AACD,4BACE,4BAA+B,CAChC,AACD,6BACE,YAAa,AACb,yBAA0B,AAC1B,iBAAkB,AAClB,sBAAuB,AACvB,wBAA0B,CAC3B,AACD,+CACI,QAAU,CACb,AACD,wBACE,cAAe,AACf,eAAgB,AAChB,wBAA0B,CAC3B,AACD,+BACI,wBAA0B,CAC7B,AACD,kCACM,YAAa,AACb,YAAa,AACb,kBAAmB,AACnB,8BAAgC,CACrC,AACD,kCACI,YAAa,AACb,YAAa,AACb,kBAAmB,AACnB,4BAA8B,CACjC,AACD,qCACM,8BAAgC,CACrC,AACD,gDACM,aAAe,CACpB","file":"list.vue","sourcesContent":["\n.el-form-item span[data-v-0f8f86e0] {\n  width: 180px;\n  display: inline-block;\n  white-space: nowrap;\n  overflow: hidden;\n  text-overflow: ellipsis;\n}\n.seachpre[data-v-0f8f86e0] {\n  width: 74px;\n}\n.filter-div[data-v-0f8f86e0] {\n  margin: 1% auto;\n}\n.table-button[data-v-0f8f86e0] {\n  width: 100px;\n  height: 36px;\n  margin-left: 20px;\n  margin-right: 20px !important;\n  border: 1px solid #5c7dfe;\n  border-radius: 4px !important;\n}\n.filter-date[data-v-0f8f86e0] {\n  width: 10%;\n  margin-right: 1%;\n}\n.filter-input[data-v-0f8f86e0] {\n  width: 10%;\n  margin-right: 1%;\n}\n.filter-select[data-v-0f8f86e0] {\n  width: 10%;\n  margin-right: 1%;\n}\n.filter-label[data-v-0f8f86e0] {\n  font-size: 10pt;\n}\n.buttonWrapper[data-v-0f8f86e0] {\n  font-size: 12px;\n  float: right;\n}\n.buttonWrapper .confirm[data-v-0f8f86e0],\n  .buttonWrapper .cancle[data-v-0f8f86e0] {\n    width: 76px;\n    padding: 7px 15px;\n}\n.buttonWrapper .confirm[data-v-0f8f86e0] {\n    color: #5c7dfe;\n    border: 1px solid #5c7dfe;\n}\n.buttonWrapper .cancle[data-v-0f8f86e0] {\n    color: #f55f80;\n    border: 1px solid #f55f80;\n}\n.tableEditWrapper[data-v-0f8f86e0] {\n  float: right;\n}\n.tableEditWrapper .edit[data-v-0f8f86e0] {\n    width: 102px;\n    padding: 8px 15px;\n    font-size: 13px;\n    color: #5c7dfe;\n    border: 1px solid #5c7dfe;\n}\n.tableEditWrapper .cancle[data-v-0f8f86e0] {\n    width: 102px;\n    padding: 8px 15px;\n    font-size: 13px;\n    color: #f55f80;\n    border: 1px solid #f55f80;\n}\n.el-pagination[data-v-0f8f86e0] {\n  text-align: right;\n  padding: 10px 0;\n  float: right;\n}\n.el-pagination__total[data-v-0f8f86e0] {\n  float: left;\n}\n.leftReset[data-v-0f8f86e0] {\n  padding-right: 20px !important;\n}\n.rightTitle[data-v-0f8f86e0] {\n  height: 50px;\n  padding: 18px 0 18px 10px;\n  line-height: 50px;\n  box-sizing: border-box;\n  background-color: #eff2f7;\n}\n.rightTitle .form-group-title[data-v-0f8f86e0] {\n    margin: 0;\n}\n.table[data-v-0f8f86e0] {\n  color: #2f3445;\n  font-size: 13px;\n  border: 1px solid #e0e6ed;\n}\n.table .thead[data-v-0f8f86e0] {\n    background-color: #e5e9f2;\n}\n.table .thead th[data-v-0f8f86e0] {\n      width: 130px;\n      height: 44px;\n      text-align: center;\n      border-right: 1px solid #e0e6ed;\n}\n.table .tbody tr[data-v-0f8f86e0] {\n    height: 46px;\n    width: 130px;\n    text-align: center;\n    border-top: 1px solid #e0e6ed;\n}\n.table .tbody tr td[data-v-0f8f86e0] {\n      border-right: 1px solid #e0e6ed;\n}\n.table .tbody tr .modifyTrData[data-v-0f8f86e0] {\n      color: #5c7dfe;\n}\n"],"sourceRoot":""}]);

// exports


/***/ }),

/***/ 434:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(418);
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
// add the styles to the DOM
var update = __webpack_require__(302)("8ee5373c", content, true);

/***/ }),

/***/ 457:
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
  }, [_vm._v("项目列表")])]), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 14,
      "offset": 2
    }
  }, [_c('el-button-group', {
    staticStyle: {
      "float": "right"
    }
  }, [(_vm.delivery) ? _c('el-button', {
    staticClass: "table-button",
    attrs: {
      "type": "primary",
      "icon": "edit"
    },
    on: {
      "click": _vm.deliveryConfirm
    }
  }, [_vm._v("批量交付")]) : _vm._e(), _vm._v(" "), _c('router-link', {
    attrs: {
      "to": {
        name: 'projectDetail'
      }
    }
  }, [_c('el-button', {
    staticClass: "table-button",
    attrs: {
      "type": "primary",
      "icon": "document"
    }
  }, [_vm._v("新建项目")])], 1)], 1)], 1)], 1), _vm._v(" "), _c('el-row', {
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
  }, [_vm._v("创建时间")]), _vm._v(" "), _c('el-date-picker', {
    staticClass: "filter-date",
    attrs: {
      "type": "date",
      "placeholder": "选择日期"
    },
    model: {
      value: (_vm.filter.createTime),
      callback: function($$v) {
        _vm.filter.createTime = $$v
      },
      expression: "filter.createTime"
    }
  }), _vm._v(" "), _c('span', {
    staticClass: "filter-label"
  }, [_vm._v("生产状态")]), _vm._v(" "), _c('el-select', {
    staticClass: "filter-select",
    attrs: {
      "placeholder": "请选择"
    },
    model: {
      value: (_vm.filter.productStatus),
      callback: function($$v) {
        _vm.filter.productStatus = $$v
      },
      expression: "filter.productStatus"
    }
  }, _vm._l((_vm.productStatusList), function(item) {
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
  }, [_c('tr', [(_vm.delivery) ? _c('th', [_c('el-checkbox', {
    on: {
      "change": function($event) {
        _vm.changeState()
      }
    },
    model: {
      value: (_vm.checkAll),
      callback: function($$v) {
        _vm.checkAll = $$v
      },
      expression: "checkAll"
    }
  })], 1) : _vm._e(), _vm._v(" "), _c('th', [_vm._v("项目编号")]), _vm._v(" "), _c('th', [_vm._v("项目名称")]), _vm._v(" "), _c('th', [_vm._v("项目状态")]), _vm._v(" "), _c('th', [_vm._v("项目类型")]), _vm._v(" "), _c('th', [_vm._v("样本种类")]), _vm._v(" "), _c('th', [_vm._v("生产状态")]), _vm._v(" "), _c('th', [_vm._v("创建时间")]), _vm._v(" "), _c('th', [_vm._v("计划完成时间")]), _vm._v(" "), _c('th', [_vm._v("实际完成时间")]), _vm._v(" "), _c('th', [_vm._v("样品总数")]), _vm._v(" "), _c('th', [_vm._v("操作")])])]), _vm._v(" "), _c('tbody', {
    staticClass: "tbody"
  }, _vm._l((_vm.tableDataList), function(list, $index) {
    return _c('tr', [(_vm.delivery) ? _c('td', [_c('el-checkbox', {
      on: {
        "change": function($event) {
          _vm.singleSelect(list)
        }
      },
      model: {
        value: (list.checked),
        callback: function($$v) {
          list.checked = $$v
        },
        expression: "list.checked"
      }
    })], 1) : _vm._e(), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.no))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.name))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.projectStatusDesc))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.projectTypeDesc))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.sampleCategoryDesc))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.productStatusDesc))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.createTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.planCompleteTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(_vm._f("formatDate")(list.actualCompleteTime)))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(list.sampleCount))]), _vm._v(" "), _c('td', {
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
//# sourceMappingURL=13.61337c5a8758ae18c4c2.js.map