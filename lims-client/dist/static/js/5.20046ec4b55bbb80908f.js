webpackJsonp([5],{

/***/ 319:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(449)
}
var Component = __webpack_require__(4)(
  /* script */
  __webpack_require__(398),
  /* template */
  __webpack_require__(484),
  /* styles */
  injectStyle,
  /* scopeId */
  "data-v-dcbfa20e",
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 338:
/***/ (function(module, exports, __webpack_require__) {

module.exports = { "default": __webpack_require__(340), __esModule: true };

/***/ }),

/***/ 339:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


exports.__esModule = true;

var _defineProperty = __webpack_require__(338);

var _defineProperty2 = _interopRequireDefault(_defineProperty);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = function (obj, key, value) {
  if (key in obj) {
    (0, _defineProperty2.default)(obj, key, {
      value: value,
      enumerable: true,
      configurable: true,
      writable: true
    });
  } else {
    obj[key] = value;
  }

  return obj;
};

/***/ }),

/***/ 340:
/***/ (function(module, exports, __webpack_require__) {

__webpack_require__(341);
var $Object = __webpack_require__(9).Object;
module.exports = function defineProperty(it, key, desc){
  return $Object.defineProperty(it, key, desc);
};

/***/ }),

/***/ 341:
/***/ (function(module, exports, __webpack_require__) {

var $export = __webpack_require__(26);
// 19.1.2.4 / 15.2.3.6 Object.defineProperty(O, P, Attributes)
$export($export.S + $export.F * !__webpack_require__(10), 'Object', {defineProperty: __webpack_require__(11).f});

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

/***/ 345:
/***/ (function(module, exports, __webpack_require__) {

module.exports = { "default": __webpack_require__(346), __esModule: true };

/***/ }),

/***/ 346:
/***/ (function(module, exports, __webpack_require__) {

var core  = __webpack_require__(9)
  , $JSON = core.JSON || (core.JSON = {stringify: JSON.stringify});
module.exports = function stringify(it){ // eslint-disable-line no-unused-vars
  return $JSON.stringify.apply($JSON, arguments);
};

/***/ }),

/***/ 359:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_components_Icon_svg_index__ = __webpack_require__(18);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_components_Icon_svg_index___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_components_Icon_svg_index__);
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
    name: 'index',
    components: { IconSvg: __WEBPACK_IMPORTED_MODULE_0_components_Icon_svg_index___default.a },
    props: {
        title: {
            type: String,
            require: true
        },
        subTitle: {
            type: String
        },
        icon: {
            type: String,
            require: true,
            default: ""
        }
    }

});

/***/ }),

/***/ 363:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(301)(true);
// imports


// module
exports.push([module.i, ".label-wrapper[data-v-3d13a862]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center}.label-wrapper .icon[data-v-3d13a862]{width:44px;height:44px;line-height:44px;border-radius:4px;background-color:#5c7dfe;text-align:center;vertical-align:middle;position:relative}.label-wrapper .icon[data-v-3d13a862]:after{content:\"\";position:absolute;left:7px;top:7px;width:44px;height:44px;opacity:.3;border-radius:4px;-webkit-filter:blur(5.6px);filter:blur(5.6px);background-color:#5c7dfe}.label-wrapper .icon svg[data-v-3d13a862]{width:18px;height:18px}.label-wrapper .content>div[data-v-3d13a862]{padding:4px 22px}.label-wrapper .content .title[data-v-3d13a862]{font-size:18px;font-weight:500}.label-wrapper .content .subTitle[data-v-3d13a862]{font-size:14px;font-weight:500;color:#a6acb0}", "", {"version":3,"sources":["D:/idea_workspace/lims/lims-client/src/components/pageLabel/index.vue"],"names":[],"mappings":"AACA,gCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,yBAA0B,AACtB,sBAAuB,AACnB,kBAAoB,CAC7B,AACD,sCACI,WAAY,AACZ,YAAa,AACb,iBAAkB,AAClB,kBAAmB,AACnB,yBAA0B,AAC1B,kBAAmB,AACnB,sBAAuB,AACvB,iBAAmB,CACtB,AACD,4CACM,WAAY,AACZ,kBAAmB,AACnB,SAAU,AACV,QAAS,AACT,WAAY,AACZ,YAAa,AACb,WAAa,AACb,kBAAmB,AAEnB,2BAA4B,AAC5B,mBAAoB,AACpB,wBAA0B,CAC/B,AACD,0CACM,WAAY,AACZ,WAAa,CAClB,AACD,6CACI,gBAAkB,CACrB,AACD,gDACI,eAAgB,AAChB,eAAiB,CACpB,AACD,mDACI,eAAgB,AAChB,gBAAiB,AACjB,aAAe,CAClB","file":"index.vue","sourcesContent":["\n.label-wrapper[data-v-3d13a862] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n}\n.label-wrapper .icon[data-v-3d13a862] {\n    width: 44px;\n    height: 44px;\n    line-height: 44px;\n    border-radius: 4px;\n    background-color: #5c7dfe;\n    text-align: center;\n    vertical-align: middle;\n    position: relative;\n}\n.label-wrapper .icon[data-v-3d13a862]:after {\n      content: \"\";\n      position: absolute;\n      left: 7px;\n      top: 7px;\n      width: 44px;\n      height: 44px;\n      opacity: 0.3;\n      border-radius: 4px;\n      background-color: #5c7dfe;\n      -webkit-filter: blur(5.6px);\n      filter: blur(5.6px);\n      background-color: #5c7dfe;\n}\n.label-wrapper .icon svg[data-v-3d13a862] {\n      width: 18px;\n      height: 18px;\n}\n.label-wrapper .content > div[data-v-3d13a862] {\n    padding: 4px 22px;\n}\n.label-wrapper .content .title[data-v-3d13a862] {\n    font-size: 18px;\n    font-weight: 500;\n}\n.label-wrapper .content .subTitle[data-v-3d13a862] {\n    font-size: 14px;\n    font-weight: 500;\n    color: #a6acb0;\n}\n"],"sourceRoot":""}]);

// exports


/***/ }),

/***/ 364:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(363);
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
// add the styles to the DOM
var update = __webpack_require__(302)("241f80cf", content, true);

/***/ }),

/***/ 365:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(364)
}
var Component = __webpack_require__(4)(
  /* script */
  __webpack_require__(359),
  /* template */
  __webpack_require__(366),
  /* styles */
  injectStyle,
  /* scopeId */
  "data-v-3d13a862",
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 366:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "label-wrapper"
  }, [_c('div', {
    staticClass: "icon"
  }, [_c('icon-svg', {
    attrs: {
      "icon-class": _vm.icon
    }
  })], 1), _vm._v(" "), _c('div', {
    staticClass: "content"
  }, [_c('div', {
    staticClass: "title"
  }, [_vm._v(_vm._s(_vm.title))]), _vm._v(" "), _c('div', {
    staticClass: "subTitle"
  }, [_vm._v(_vm._s(_vm.subTitle))])])])
},staticRenderFns: []}

/***/ }),

/***/ 398:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__ = __webpack_require__(345);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_defineProperty__ = __webpack_require__(339);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_defineProperty___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_defineProperty__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_components_pageLabel__ = __webpack_require__(365);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_components_pageLabel___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_components_pageLabel__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_element_ui_packages_col_src_col__ = __webpack_require__(342);


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
  name: 'index',
  components: {
    ElCol: __WEBPACK_IMPORTED_MODULE_3_element_ui_packages_col_src_col__["a" /* default */],
    PageLabel: __WEBPACK_IMPORTED_MODULE_2_components_pageLabel___default.a
  },
  beforeCreate: function beforeCreate() {
    this.temp = [];
    this.stepThirdTemp = [];
  },
  mounted: function mounted() {
    this.handleData(this.stepSecond.gridData); //弹框数据处理
  },
  data: function data() {
    return {
      temp: [],
      activeName1: "first",
      activeName2: "first",
      taskData: __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_defineProperty___default()({
        name: "07-mc-35-md",
        number: "BN-16-OD-78",
        type: "RNA样本检测",
        startTime: "2016-11-13"
      }, 'startTime', "2016-11-14"),
      active: 6,
      stepOne: {
        kit: '',
        produceTempl: ''
      },
      stepSecond: {
        isSelect: false,
        dialogTableVisible: false,
        gridData: [{
          queueNumber: '20170731',
          projectId: '111111',
          holeList: [{
            id: 1,
            state: 1, //1:未使用;2:已使用;3:禁用;4:新插入
            sample: {}
          }, {
            id: 2,
            state: 2,
            sample: {}
          }, {
            id: 3,
            state: 2,
            sample: {}
          }, {
            id: 4,
            state: 3,
            sample: {}
          }, {
            id: 5,
            state: 1,
            sample: {}
          }, {
            id: 6,
            state: 3,
            sample: {}
          }, {
            id: 7,
            state: 3,
            sample: {}
          }, {
            id: 8,
            state: 1,
            sample: {}
          }, {
            id: 9,
            state: 1,
            sample: {}
          }, {
            id: 10,
            state: 1,
            sample: {}
          }, {
            id: 11,
            state: 2,
            sample: {}
          }, {
            id: 12,
            state: 2,
            sample: {}
          }, {
            id: 13,
            state: 2,
            sample: {}
          }, {
            id: 14,
            state: 2,
            sample: {}
          }, {
            id: 15,
            state: 2,
            sample: {}
          }, {
            id: 16,
            state: 3,
            sample: {}
          }]
        }, {
          queueNumber: '20170801',
          projectId: '222222',
          holeList: [{
            id: 1,
            state: 1, //1:未使用;2:已使用;3:禁用;4:新插入
            sample: {}
          }, {
            id: 2,
            state: 2,
            sample: {}
          }, {
            id: 3,
            state: 2,
            sample: {}
          }, {
            id: 4,
            state: 1,
            sample: {}
          }, {
            id: 5,
            state: 3,
            sample: {}
          }, {
            id: 6,
            state: 2,
            sample: {}
          }, {
            id: 7,
            state: 3,
            sample: {}
          }, {
            id: 8,
            state: 1,
            sample: {}
          }, {
            id: 9,
            state: 1,
            sample: {}
          }, {
            id: 10,
            state: 1,
            sample: {}
          }, {
            id: 11,
            state: 3,
            sample: {}
          }, {
            id: 12,
            state: 2,
            sample: {}
          }, {
            id: 13,
            state: 2,
            sample: {}
          }, {
            id: 14,
            state: 2,
            sample: {}
          }, {
            id: 15,
            state: 3,
            sample: {}
          }, {
            id: 16,
            state: 2,
            sample: {}
          }]
        }, {
          queueNumber: '20170802',
          projectId: '333333',
          holeList: [{
            id: 1,
            state: 1, //1:未使用;2:已使用;3:禁用;4:新插入
            sample: {}
          }, {
            id: 2,
            state: 2,
            sample: {}
          }, {
            id: 3,
            state: 2,
            sample: {}
          }, {
            id: 4,
            state: 3,
            sample: {}
          }, {
            id: 5,
            state: 3,
            sample: {}
          }, {
            id: 6,
            state: 3,
            sample: {}
          }, {
            id: 7,
            state: 3,
            sample: {}
          }, {
            id: 8,
            state: 1,
            sample: {}
          }, {
            id: 9,
            state: 1,
            sample: {}
          }, {
            id: 10,
            state: 1,
            sample: {}
          }, {
            id: 11,
            state: 2,
            sample: {}
          }, {
            id: 12,
            state: 2,
            sample: {}
          }, {
            id: 13,
            state: 1,
            sample: {}
          }, {
            id: 14,
            state: 2,
            sample: {}
          }, {
            id: 15,
            state: 1,
            sample: {}
          }, {
            id: 16,
            state: 1,
            sample: {}
          }]
        }],
        multipleSelection: [], //弹框表格选中值
        totalHoles: 0, //已选中芯片未使用孔位总数
        tableCheckedVal: [], //表格选中值
        tableCheckHoles: 0,
        chipPicCon: '', //选中芯片序列号
        chipTrData: {}

      },
      stepThird: {
        tableDataList: [{
          id: '111',
          name: '甲状腺组织',
          diluentVolumn: '1.38',
          originalVolumn: '1.38',
          member: '张静',
          hole: '',
          queueNumber: ''
        }, {
          id: '112',
          name: '甲状腺组织',
          diluentVolumn: '1.38',
          originalVolumn: '1.38',
          member: '张静',
          hole: '',
          queueNumber: ''
        }, {
          id: '113',
          name: '甲状腺组织',
          diluentVolumn: '1.38',
          originalVolumn: '1.38',
          member: '张静',
          hole: '',
          queueNumber: ''
        }],
        resetUnuse: [],
        currentPage: 1
      }
    };
  },

  methods: {
    // 弹框数据处理
    handleData: function handleData(list) {
      // 数据插入属性
      for (var i = 0; i < list.length; i++) {
        list[i].unuse = list[i].holeList.filter(function (item) {
          return item.state == 1;
        }).length;
        list[i].use = list[i].holeList.filter(function (item) {
          return item.state == 2;
        }).length;
      }
      this.stepSecond.chipPicCon = list[0].queueNumber;
    },

    // 选择芯片孔位
    selectChips: function selectChips() {

      this.stepSecond.dialogTableVisible = true;
    },

    // 弹出框全选
    handleSelectionChange: function handleSelectionChange(val) {
      this.stepSecond.multipleSelection = val;
      var len = 0;
      val.forEach(function (item) {
        len += item.unuse;
      });
      this.stepSecond.totalHoles = len;
    },

    // 弹框确定按钮
    dialogConfirm: function dialogConfirm() {
      var len = 0;
      this.stepSecond.multipleSelection.forEach(function (item) {
        len += item.unuse;
      });
      this.stepSecond.tableCheckHoles = len;

      this.stepSecond.isSelect = true;
      this.stepSecond.dialogTableVisible = false;
      this.stepSecond.chipTrData = this.stepSecond.multipleSelection[0];
    },

    // 关闭弹窗
    handleClose: function handleClose() {
      this.stepSecond.multipleSelection = this.temp;
      this.stepSecond.dialogTableVisible = false;
    },

    // 芯片选择
    chipSelectionChange: function chipSelectionChange(val) {
      this.stepSecond.tableCheckedVal = val;
    },

    // 表格选中行
    tableRowClassName: function tableRowClassName(row, index) {
      if (row.queueNumber == this.stepSecond.chipPicCon) {
        return 'chipsTrStyle';
      }
      return '';
    },

    // 芯片图片切换
    chipsChange: function chipsChange(val) {
      this.stepSecond.chipPicCon = val.queueNumber; //图片底部标题
      this.stepSecond.chipTrData = val;
    },

    // 添加芯片
    addChips: function addChips() {
      this.temp = JSON.parse(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default()(this.stepSecond.multipleSelection));
      var len = 0;
      this.temp.forEach(function (item) {
        len += item.unuse;
      });
      this.stepSecond.totalHoles = len;

      this.stepSecond.dialogTableVisible = true;
    },

    // 删除芯片
    deleteChips: function deleteChips() {

      if (this.stepSecond.tableCheckedVal.length == 0) {
        this.$alert("请选择芯片");
        return;
      }
      for (var i = 0; i < this.stepSecond.multipleSelection.length; i++) {
        for (var j = 0; j < this.stepSecond.tableCheckedVal.length; j++) {
          if (this.stepSecond.multipleSelection[i].projectId == this.stepSecond.tableCheckedVal[j].projectId) {
            this.stepSecond.multipleSelection.splice(i, 1);
          }
        }
      }
      var len = 0;
      this.stepSecond.multipleSelection.forEach(function (item) {
        len += item.unuse;
      });
      this.stepSecond.tableCheckHoles = len;
    },

    // 芯片排位
    chipsSort: function chipsSort() {
      if (this.stepSecond.multipleSelection.length == 0) {
        this.$alert("请选择芯片孔位");
        return;
      }
      this.stepThirdTemp = JSON.parse(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default()(this.stepThird.tableDataList)); //复制数据

      for (var i = 0; i < this.stepSecond.multipleSelection.length; i++) {
        for (var j = 0, len = this.stepSecond.multipleSelection[i].holeList.length; j < len; j++) {
          if (this.stepSecond.multipleSelection[i].holeList[j].state == 1) {
            var obj = {};
            obj.queueNumber = this.stepSecond.multipleSelection[i].queueNumber;
            obj.hole = this.stepSecond.multipleSelection[i].holeList[j];
            this.stepThird.resetUnuse.push(obj);
          }
        }
      }

      for (var i = 0; i < this.stepThird.tableDataList.length; i++) {
        this.stepThird.tableDataList[i].holeId = this.stepThird.resetUnuse[i].hole.id;
        this.stepThird.tableDataList[i].queueNumber = this.stepThird.resetUnuse[i].queueNumber;
        this.stepThird.resetUnuse[i].hole.sample = this.stepThird.tableDataList[i];
        this.stepThird.resetUnuse[i].hole.state = 4;
      }
    },

    // 清除排位
    clearSort: function clearSort() {
      if (this.stepThird.tableDataList[0].queueNumber == '') {
        this.$alert("芯片未排位");
        return;
      }
      this.stepThird.tableDataList = this.stepThirdTemp;
    },

    // 分页
    handleSizeChange: function handleSizeChange(val) {},
    handleCurrentChange: function handleCurrentChange(val) {}
  }
});

/***/ }),

/***/ 433:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(301)(true);
// imports


// module
exports.push([module.i, ".el-step__head.is-text.is-success[data-v-dcbfa20e]{background-color:#aad070!important;border-color:#aad070}.selectWidth[data-v-dcbfa20e]{width:100%}.offSel[data-v-dcbfa20e]{padding-right:80px}.submitSoft[data-v-dcbfa20e]{float:right}.taskList[data-v-dcbfa20e]{color:#99a9bf;font-size:14px}.taskContent[data-v-dcbfa20e]{color:#2f3445;font-size:14px}.hr[data-v-dcbfa20e]{height:1px;margin:30px auto;background-color:#eee}.chipsButtonWrap[data-v-dcbfa20e]{float:right}.chipsButtonWrap .el-button[data-v-dcbfa20e]:focus,.chipsButtonWrap .el-button[data-v-dcbfa20e]:hover{color:none;border-color:none}.chipsButtonWrap .addChips[data-v-dcbfa20e]{color:#5c7dfe;border-color:#5c7dfe;background:none}.dialogTitle[data-v-dcbfa20e]{margin-top:-46px;font-size:16px;font-weight:700;color:#1f223d}.dialogTitle span[data-v-dcbfa20e]{font-size:12px;color:#8798b1}.selectText[data-v-dcbfa20e]{float:left}.selectText span[data-v-dcbfa20e]:first-child{color:#fc2f39}.selectText span[data-v-dcbfa20e]:last-child{color:#ef456d}.haveSelectTable[data-v-dcbfa20e]{margin-top:20px}.imageTitle[data-v-dcbfa20e],.remain[data-v-dcbfa20e]{height:19px;font-size:14px;text-align:center;color:#99a9bf}.remain[data-v-dcbfa20e]{float:right}.remain span[data-v-dcbfa20e]{color:#ef456d}.imgWrap[data-v-dcbfa20e]{width:253px;height:253px;margin:0 auto;background:url(" + __webpack_require__(456) + ");background-size:contain;padding-top:58px}.imgWrap .circleWrap[data-v-dcbfa20e]{width:140px;height:140px;margin:0 auto;padding:7px 10px}.imgWrap .circleWrap .circle[data-v-dcbfa20e]{display:inline-block;width:24px;height:24px;margin:2px 3px;border-radius:50%;background-color:#5c7dfe}.imgWrap .circleWrap .use[data-v-dcbfa20e]{background-color:#5c7dfe}.imgWrap .circleWrap .unuse[data-v-dcbfa20e]{background-color:#fff}.imgWrap .circleWrap .forbidden[data-v-dcbfa20e]{background-color:#d3dce6}.chipsTrStyle[data-v-dcbfa20e],.imgWrap .circleWrap .add[data-v-dcbfa20e]{background-color:red}.stepThree[data-v-dcbfa20e]{margin-bottom:10px}.printList[data-v-dcbfa20e]{color:#5c7dfe;border-color:#5c7dfe;background:none;float:right}.table[data-v-dcbfa20e]{color:#2f3445;font-size:13px;border:1px solid #e0e6ed}.table .thead[data-v-dcbfa20e]{background-color:#e5e9f2}.table .thead th[data-v-dcbfa20e]{width:130px;height:44px;text-align:center;border-right:1px solid #e0e6ed}.table .tbody tr[data-v-dcbfa20e]{height:46px;width:130px;text-align:center;border-top:1px solid #e0e6ed}.table .tbody tr td[data-v-dcbfa20e]{border-right:1px solid #e0e6ed}.table .tbody tr .modifyTrData[data-v-dcbfa20e]{color:#5c7dfe}.el-pagination[data-v-dcbfa20e]{text-align:right;padding:10px 0;float:right}.content[data-v-dcbfa20e],.rightTitle[data-v-dcbfa20e]{color:#2f3445;font-size:14px}.warn[data-v-dcbfa20e]{color:#f55f80}.footer[data-v-dcbfa20e]{padding-top:10px;padding-right:30px}.footer p[data-v-dcbfa20e]{width:104px;height:40px;line-height:40px;text-align:center;background-color:#fff;border-radius:4px;border:1px solid #c0ccda;float:right}.footer .next[data-v-dcbfa20e]{margin-left:20px}", "", {"version":3,"sources":["D:/idea_workspace/lims/lims-client/src/views/page/detection.vue"],"names":[],"mappings":"AACA,mDACE,mCAAqC,AACrC,oBAAsB,CACvB,AACD,8BACE,UAAY,CACb,AACD,yBACE,kBAAoB,CACrB,AACD,6BACE,WAAa,CACd,AACD,2BACE,cAAe,AACf,cAAgB,CACjB,AACD,8BACE,cAAe,AACf,cAAgB,CACjB,AACD,qBACE,WAAY,AACZ,iBAAkB,AAClB,qBAAuB,CACxB,AACD,kCACE,WAAa,CACd,AACD,sGAEI,WAAY,AACZ,iBAAmB,CACtB,AACD,4CACI,cAAe,AACf,qBAAsB,AACtB,eAAiB,CACpB,AACD,8BACE,iBAAkB,AAClB,eAAgB,AAChB,gBAAiB,AACjB,aAAe,CAChB,AACD,mCACI,eAAgB,AAChB,aAAe,CAClB,AACD,6BACE,UAAY,CACb,AACD,8CACI,aAAe,CAClB,AACD,6CACI,aAAe,CAClB,AACD,kCACE,eAAiB,CAClB,AAOD,sDALE,YAAa,AACb,eAAgB,AAChB,kBAAmB,AACnB,aAAe,CAQhB,AAND,yBAKE,WAAa,CACd,AACD,8BACI,aAAe,CAClB,AACD,0BACE,YAAa,AACb,aAAc,AACd,cAAe,AACf,yCAA4C,AAC5C,wBAAyB,AACzB,gBAAkB,CACnB,AACD,sCACI,YAAa,AACb,aAAc,AACd,cAAe,AACf,gBAAkB,CACrB,AACD,8CACM,qBAAsB,AACtB,WAAY,AACZ,YAAa,AACb,eAAgB,AAChB,kBAAmB,AACnB,wBAA0B,CAC/B,AACD,2CACM,wBAA0B,CAC/B,AACD,6CACM,qBAAuB,CAC5B,AACD,iDACM,wBAA0B,CAC/B,AAID,0EACE,oBAAuB,CACxB,AACD,4BACE,kBAAoB,CACrB,AACD,4BACE,cAAe,AACf,qBAAsB,AACtB,gBAAiB,AACjB,WAAa,CACd,AACD,wBACE,cAAe,AACf,eAAgB,AAChB,wBAA0B,CAC3B,AACD,+BACI,wBAA0B,CAC7B,AACD,kCACM,YAAa,AACb,YAAa,AACb,kBAAmB,AACnB,8BAAgC,CACrC,AACD,kCACI,YAAa,AACb,YAAa,AACb,kBAAmB,AACnB,4BAA8B,CACjC,AACD,qCACM,8BAAgC,CACrC,AACD,gDACM,aAAe,CACpB,AACD,gCACE,iBAAkB,AAClB,eAAgB,AAChB,WAAa,CACd,AACD,uDAEE,cAAe,AACf,cAAgB,CACjB,AACD,uBACE,aAAe,CAChB,AACD,yBACE,iBAAkB,AAClB,kBAAoB,CACrB,AACD,2BACI,YAAa,AACb,YAAa,AACb,iBAAkB,AAClB,kBAAmB,AACnB,sBAAuB,AACvB,kBAAmB,AACnB,yBAA0B,AAC1B,WAAa,CAChB,AACD,+BACI,gBAAkB,CACrB","file":"detection.vue","sourcesContent":["\n.el-step__head.is-text.is-success[data-v-dcbfa20e] {\n  background-color: #aad070 !important;\n  border-color: #aad070;\n}\n.selectWidth[data-v-dcbfa20e] {\n  width: 100%;\n}\n.offSel[data-v-dcbfa20e] {\n  padding-right: 80px;\n}\n.submitSoft[data-v-dcbfa20e] {\n  float: right;\n}\n.taskList[data-v-dcbfa20e] {\n  color: #99a9bf;\n  font-size: 14px;\n}\n.taskContent[data-v-dcbfa20e] {\n  color: #2f3445;\n  font-size: 14px;\n}\n.hr[data-v-dcbfa20e] {\n  height: 1px;\n  margin: 30px auto;\n  background-color: #eee;\n}\n.chipsButtonWrap[data-v-dcbfa20e] {\n  float: right;\n}\n.chipsButtonWrap .el-button[data-v-dcbfa20e]:hover,\n  .chipsButtonWrap .el-button[data-v-dcbfa20e]:focus {\n    color: none;\n    border-color: none;\n}\n.chipsButtonWrap .addChips[data-v-dcbfa20e] {\n    color: #5c7dfe;\n    border-color: #5c7dfe;\n    background: none;\n}\n.dialogTitle[data-v-dcbfa20e] {\n  margin-top: -46px;\n  font-size: 16px;\n  font-weight: 700;\n  color: #1f223d;\n}\n.dialogTitle span[data-v-dcbfa20e] {\n    font-size: 12px;\n    color: #8798b1;\n}\n.selectText[data-v-dcbfa20e] {\n  float: left;\n}\n.selectText span[data-v-dcbfa20e]:first-child {\n    color: #fc2f39;\n}\n.selectText span[data-v-dcbfa20e]:last-child {\n    color: #ef456d;\n}\n.haveSelectTable[data-v-dcbfa20e] {\n  margin-top: 20px;\n}\n.imageTitle[data-v-dcbfa20e] {\n  height: 19px;\n  font-size: 14px;\n  text-align: center;\n  color: #99a9bf;\n}\n.remain[data-v-dcbfa20e] {\n  height: 19px;\n  font-size: 14px;\n  text-align: center;\n  color: #99a9bf;\n  float: right;\n}\n.remain span[data-v-dcbfa20e] {\n    color: #ef456d;\n}\n.imgWrap[data-v-dcbfa20e] {\n  width: 253px;\n  height: 253px;\n  margin: 0 auto;\n  background: url(~assets/image/pic_xpsy.png);\n  background-size: contain;\n  padding-top: 58px;\n}\n.imgWrap .circleWrap[data-v-dcbfa20e] {\n    width: 140px;\n    height: 140px;\n    margin: 0 auto;\n    padding: 7px 10px;\n}\n.imgWrap .circleWrap .circle[data-v-dcbfa20e] {\n      display: inline-block;\n      width: 24px;\n      height: 24px;\n      margin: 2px 3px;\n      border-radius: 50%;\n      background-color: #5c7dfe;\n}\n.imgWrap .circleWrap .use[data-v-dcbfa20e] {\n      background-color: #5c7dfe;\n}\n.imgWrap .circleWrap .unuse[data-v-dcbfa20e] {\n      background-color: #fff;\n}\n.imgWrap .circleWrap .forbidden[data-v-dcbfa20e] {\n      background-color: #d3dce6;\n}\n.imgWrap .circleWrap .add[data-v-dcbfa20e] {\n      background-color: #f00;\n}\n.chipsTrStyle[data-v-dcbfa20e] {\n  background-color: #f00;\n}\n.stepThree[data-v-dcbfa20e] {\n  margin-bottom: 10px;\n}\n.printList[data-v-dcbfa20e] {\n  color: #5c7dfe;\n  border-color: #5c7dfe;\n  background: none;\n  float: right;\n}\n.table[data-v-dcbfa20e] {\n  color: #2f3445;\n  font-size: 13px;\n  border: 1px solid #e0e6ed;\n}\n.table .thead[data-v-dcbfa20e] {\n    background-color: #e5e9f2;\n}\n.table .thead th[data-v-dcbfa20e] {\n      width: 130px;\n      height: 44px;\n      text-align: center;\n      border-right: 1px solid #e0e6ed;\n}\n.table .tbody tr[data-v-dcbfa20e] {\n    height: 46px;\n    width: 130px;\n    text-align: center;\n    border-top: 1px solid #e0e6ed;\n}\n.table .tbody tr td[data-v-dcbfa20e] {\n      border-right: 1px solid #e0e6ed;\n}\n.table .tbody tr .modifyTrData[data-v-dcbfa20e] {\n      color: #5c7dfe;\n}\n.el-pagination[data-v-dcbfa20e] {\n  text-align: right;\n  padding: 10px 0;\n  float: right;\n}\n.rightTitle[data-v-dcbfa20e],\n.content[data-v-dcbfa20e] {\n  color: #2f3445;\n  font-size: 14px;\n}\n.warn[data-v-dcbfa20e] {\n  color: #f55f80;\n}\n.footer[data-v-dcbfa20e] {\n  padding-top: 10px;\n  padding-right: 30px;\n}\n.footer p[data-v-dcbfa20e] {\n    width: 104px;\n    height: 40px;\n    line-height: 40px;\n    text-align: center;\n    background-color: #fff;\n    border-radius: 4px;\n    border: solid 1px #c0ccda;\n    float: right;\n}\n.footer .next[data-v-dcbfa20e] {\n    margin-left: 20px;\n}\n"],"sourceRoot":""}]);

// exports


/***/ }),

/***/ 449:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(433);
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
// add the styles to the DOM
var update = __webpack_require__(302)("1c50a1ff", content, true);

/***/ }),

/***/ 456:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "static/img/pic_xpsy.2bc2e75.png";

/***/ }),

/***/ 484:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', [_c('page-label', {
    attrs: {
      "title": "检测执行",
      "sub-title": "RNA样本检测",
      "icon": "detection"
    }
  }), _vm._v(" "), _c('div', {
    staticClass: "group"
  }, [_c('el-row', {
    attrs: {
      "type": "flex",
      "justify": "space-between"
    }
  }, [_c('el-col', [_c('span', {
    staticClass: "taskList"
  }, [_vm._v("任务单名称：")]), _c('span', {
    staticClass: "taskContent"
  }, [_vm._v(_vm._s(_vm.taskData.name))])]), _vm._v(" "), _c('el-col', [_c('span', {
    staticClass: "taskList"
  }, [_vm._v("任务单编号：")]), _c('span', {
    staticClass: "taskContent"
  }, [_vm._v(_vm._s(_vm.taskData.number))])]), _vm._v(" "), _c('el-col', [_c('span', {
    staticClass: "taskList"
  }, [_vm._v("任务单类型：")]), _c('span', {
    staticClass: "taskContent"
  }, [_vm._v(_vm._s(_vm.taskData.type))])]), _vm._v(" "), _c('el-col', [_c('span', {
    staticClass: "taskList"
  }, [_vm._v("任务单开始时间：")]), _c('span', {
    staticClass: "taskContent"
  }, [_vm._v(_vm._s(_vm.taskData.startTime))])]), _vm._v(" "), _c('el-col', [_c('span', {
    staticClass: "taskList"
  }, [_vm._v("预计束时间：")]), _c('span', {
    staticClass: "taskContent"
  }, [_vm._v(_vm._s(_vm.taskData.name))])])], 1), _vm._v(" "), _c('p', {
    staticClass: "hr"
  }), _vm._v(" "), _c('el-steps', {
    attrs: {
      "active": _vm.active,
      "finish-status": "success"
    }
  }, [_c('el-step', {
    attrs: {
      "title": "开始"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "出库"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 3"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 4"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 5"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 6"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 7"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 8"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 9"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 10"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "步骤 11"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "Anglient"
    }
  }), _vm._v(" "), _c('el-step', {
    attrs: {
      "title": "样品质量"
    }
  })], 1)], 1), _vm._v(" "), _c('div', [_c('el-row', {
    attrs: {
      "gutter": 20
    }
  }, [_c('el-col', {
    attrs: {
      "span": 16
    }
  }, [_c('el-tabs', {
    attrs: {
      "type": "card"
    },
    model: {
      value: (_vm.activeName1),
      callback: function($$v) {
        _vm.activeName1 = $$v
      },
      expression: "activeName1"
    }
  }, [_c('el-tab-pane', {
    attrs: {
      "label": "实验操作",
      "name": "first"
    }
  }, [_c('div', {
    staticClass: "form-group-title"
  }, [_vm._v("步骤一")]), _vm._v(" "), _c('el-form', {
    ref: "stepOne",
    attrs: {
      "model": _vm.stepOne,
      "label-position": "right",
      "label-width": "120px"
    }
  }, [_c('el-row', [_c('el-col', [_c('el-form-item', {
    attrs: {
      "label": "试剂盒"
    }
  }, [_c('el-select', {
    staticClass: "selectWidth",
    attrs: {
      "placeholder": "请选择"
    },
    model: {
      value: (_vm.stepOne.kit),
      callback: function($$v) {
        _vm.stepOne.kit = $$v
      },
      expression: "stepOne.kit"
    }
  }, [_c('el-option', {
    attrs: {
      "label": "试剂盒",
      "value": "1"
    }
  })], 1)], 1)], 1)], 1), _vm._v(" "), _c('el-row', {
    attrs: {
      "gutter": 20
    }
  }, [_c('el-col', {
    attrs: {
      "span": 22
    }
  }, [_c('el-form-item', {
    attrs: {
      "label": "运行程序模板"
    }
  }, [_c('el-select', {
    staticClass: "selectWidth offSel",
    attrs: {
      "placeholder": "请选择"
    },
    model: {
      value: (_vm.stepOne.produceTempl),
      callback: function($$v) {
        _vm.stepOne.produceTempl = $$v
      },
      expression: "stepOne.produceTempl"
    }
  }, [_c('el-option', {
    attrs: {
      "label": "运行程序模板",
      "value": "1"
    }
  })], 1)], 1)], 1), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 2
    }
  }, [_c('el-button', {
    staticClass: "submitSoft",
    attrs: {
      "type": "primary"
    }
  }, [_vm._v("提交到2100软件")])], 1)], 1)], 1), _vm._v(" "), _c('p', {
    staticClass: "hr"
  }), _vm._v(" "), _c('el-row', {
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
  }, [_vm._v("步骤二")])]), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 20
    }
  }, [_c('el-button', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (!_vm.stepSecond.isSelect),
      expression: "!stepSecond.isSelect"
    }],
    attrs: {
      "type": "primary"
    },
    nativeOn: {
      "click": function($event) {
        _vm.selectChips()
      }
    }
  }, [_vm._v("选择芯片孔位")]), _vm._v(" "), _c('div', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (_vm.stepSecond.isSelect),
      expression: "stepSecond.isSelect"
    }],
    staticClass: "chipsButtonWrap"
  }, [_c('el-button', {
    staticClass: "deleteChips",
    on: {
      "click": function($event) {
        _vm.deleteChips()
      }
    }
  }, [_vm._v("删除芯片")]), _vm._v(" "), _c('el-button', {
    staticClass: "addChips",
    on: {
      "click": function($event) {
        _vm.addChips()
      }
    }
  }, [_vm._v("添加芯片")])], 1)], 1)], 1), _vm._v(" "), _c('el-dialog', {
    attrs: {
      "title": "芯片型号",
      "visible": _vm.stepSecond.dialogTableVisible,
      "before-close": _vm.handleClose
    },
    on: {
      "update:visible": function($event) {
        _vm.stepSecond.dialogTableVisible = $event
      }
    }
  }, [_c('el-table', {
    attrs: {
      "data": _vm.stepSecond.gridData,
      "border": "",
      "height": "440"
    },
    on: {
      "selection-change": _vm.handleSelectionChange
    }
  }, [_c('el-table-column', {
    attrs: {
      "type": "selection",
      "width": "55"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "queueNumber",
      "label": "芯片序列号",
      "width": "150"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "use",
      "label": "已使用孔位数",
      "width": "200"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "unuse",
      "label": "未使用孔位数"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "projectId",
      "label": "项目ID"
    }
  })], 1), _vm._v(" "), _c('div', {
    staticClass: "dialog-footer",
    slot: "footer"
  }, [_c('span', {
    staticClass: "selectText"
  }, [_vm._v("已选中"), _c('span', [_vm._v(_vm._s(_vm.stepSecond.multipleSelection.length))]), _vm._v("个芯片共有"), _c('span', [_vm._v(_vm._s(_vm.stepSecond.totalHoles))]), _vm._v("个孔位")]), _vm._v(" "), _c('el-button', {
    attrs: {
      "type": "primary"
    },
    nativeOn: {
      "click": function($event) {
        _vm.dialogConfirm()
      }
    }
  }, [_vm._v("确 定")])], 1)], 1), _vm._v(" "), _c('el-row', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (_vm.stepSecond.isSelect),
      expression: "stepSecond.isSelect"
    }],
    staticClass: "haveSelectTable",
    attrs: {
      "gutter": 20
    }
  }, [_c('el-col', {
    attrs: {
      "span": 10
    }
  }, [_c('div', {
    staticClass: "imgWrap"
  }, [_c('div', {
    staticClass: "circleWrap"
  }, _vm._l((_vm.stepSecond.chipTrData.holeList), function(hole) {
    return _c('div', {
      staticClass: "circle",
      class: {
        'unuse': hole.state === 1, 'use': hole.state === 2, 'forbidden': hole.state === 3, 'add': hole.state === 4
      }
    })
  }))]), _vm._v(" "), _c('p', {
    staticClass: "imageTitle"
  }, [_vm._v("芯片序列号: " + _vm._s(_vm.stepSecond.chipPicCon) + "示意图")])]), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 14
    }
  }, [_c('el-table', {
    attrs: {
      "data": _vm.stepSecond.multipleSelection,
      "row-class-name": _vm.tableRowClassName,
      "border": "",
      "height": "260"
    },
    on: {
      "selection-change": _vm.chipSelectionChange,
      "row-click": _vm.chipsChange
    }
  }, [_c('el-table-column', {
    attrs: {
      "type": "selection"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "queueNumber",
      "label": "芯片序列号"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "use",
      "label": "已使用孔位数"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "unuse",
      "label": "未使用孔位数"
    }
  })], 1), _vm._v(" "), _c('p', {
    staticClass: "remain"
  }, [_vm._v("剩余"), _c('span', [_vm._v(_vm._s(_vm.stepSecond.tableCheckHoles))]), _vm._v("芯片空位")])], 1)], 1), _vm._v(" "), _c('p', {
    staticClass: "hr"
  }), _vm._v(" "), _c('el-row', {
    staticClass: "stepThree",
    attrs: {
      "type": "flex",
      "align": "middle",
      "justify": "space-around"
    }
  }, [_c('el-col', {
    attrs: {
      "span": 18
    }
  }, [_c('div', {
    staticClass: "form-group-title"
  }, [_vm._v("步骤三")])]), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 6
    }
  }, [_c('el-button', {
    staticClass: "printList",
    attrs: {
      "type": "primary",
      "icon": "document"
    }
  }, [_vm._v("打印上样清单")])], 1)], 1), _vm._v(" "), _c('el-table', {
    attrs: {
      "data": _vm.stepThird.tableDataList,
      "border": ""
    },
    on: {
      "selection-change": _vm.chipSelectionChange
    }
  }, [_c('el-table-column', {
    attrs: {
      "property": "id",
      "label": "样本ID"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "name",
      "label": "样本名称"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "diluentVolumn",
      "label": "稀释液体积(计算)"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "originalVolumn",
      "label": "原液体积(计算)"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "member",
      "label": "样品负责"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "holeId",
      "label": "孔位"
    }
  }), _vm._v(" "), _c('el-table-column', {
    attrs: {
      "property": "queueNumber",
      "label": "芯片序列号"
    }
  })], 1), _vm._v(" "), _c('el-row', {
    staticStyle: {
      "margin-top": "20px"
    },
    attrs: {
      "type": "fix",
      "align": "middle"
    }
  }, [_c('el-col', {
    attrs: {
      "span": 8
    }
  }, [_c('el-button', {
    on: {
      "click": function($event) {
        _vm.chipsSort()
      }
    }
  }, [_vm._v("芯片排位")]), _vm._v(" "), _c('el-button', {
    on: {
      "click": function($event) {
        _vm.clearSort()
      }
    }
  }, [_vm._v("清除排位")])], 1), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 16
    }
  }, [_c('el-pagination', {
    attrs: {
      "current-page": _vm.stepThird.currentPage,
      "page-size": 100,
      "layout": "prev, pager, next, jumper",
      "total": 1000
    },
    on: {
      "size-change": _vm.handleSizeChange,
      "current-change": _vm.handleCurrentChange,
      "update:currentPage": function($event) {
        _vm.stepThird.currentPage = $event
      }
    }
  })], 1)], 1)], 1), _vm._v(" "), _c('el-tab-pane', {
    attrs: {
      "label": "RNA样品检测报告",
      "name": "second"
    }
  }, [_vm._v("\n                        RNA样品检测报告\n                    ")])], 1), _vm._v(" "), _c('div', {
    staticClass: "footer"
  }, [_c('p', {
    staticClass: "next"
  }, [_vm._v("下一步")]), _vm._v(" "), _c('p', {
    staticClass: "back"
  }, [_vm._v("上一步")])])], 1), _vm._v(" "), _c('el-col', {
    attrs: {
      "span": 8
    }
  }, [_c('el-tabs', {
    attrs: {
      "type": "card"
    },
    model: {
      value: (_vm.activeName2),
      callback: function($$v) {
        _vm.activeName2 = $$v
      },
      expression: "activeName2"
    }
  }, [_c('el-tab-pane', {
    attrs: {
      "label": "RNA样品检测SOP",
      "name": "first"
    }
  }, [_c('div', {
    staticClass: "rightTitle"
  }, [_vm._v("二、样品检测")]), _vm._v(" "), _c('p', {
    staticClass: "content warn"
  }, [_vm._v("注：1. 为避免操作过程中外源RNA酶会使样品降解，请在样品检测前佩戴好一次性口罩及手套，避免直接用手接触枪头，EP管等实验耗材，请检查实验台面及相应的实验用具是否干净，避免样品外来污染或样品之间的交叉污染！")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("2. RNA样品检测应全程使用DEPC水及无核酸酶枪头。")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("1.样品的Qubit定量")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("1)将RNA样品取出后于室温融化，当样品融化后轻弹EP管，使管内的样品混合均匀，在4℃离心机瞬离后立即将样品转移到冰上，避免样品长时间室温放置；")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("注：样品混匀后一定要及时瞬离，使样品落回管底瞬离转速小于5000rpm。")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("2)     样品信息确认无误后，取出与样品数量相当的新的1.5mL EP管，做好按照样品编号做好标记；")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("3)     根据样品信息单上的样品浓度，在新的1.5mL离心管中对样品进行稀释（DEPC H2O），终浓度100ng/μL左右，稀释后的体积大于5μL，若样品信息单未标明样品浓度，则对样品统一进行10倍稀释，将样品稀释液振荡混匀，瞬时离心10s后置于冰上备用；")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("4)     使用Qubit® RNA Assay Kit对样品稀释液进行浓度测定，具体实验步骤如下：")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("注：1. Qubit® RNA Assay Kit试剂存放于4℃，使用前应提前取出平衡至室温，Qubit® RNA HS Reagent应完全融解；")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("2.     Qubit® RNA HS Reagent在整个检测过程中应注意避光保存；")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("3.     新包装的0.5mL离心管在使用前，应用Qubit® RNA Assay Kit中的标准液恔准，并在离心管包装外注明“已标定”。")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("a)     取出新的0.5mL离心管，按照样品名称做好标记；")]), _vm._v(" "), _c('p', {
    staticClass: "content"
  }, [_vm._v("b)     工作液的配制（终体积200μL）：依次在离心管中加入198μL已平衡至室温的Qubit® RNA HS Buffer ，1μL Qubit® RNA HS Reagent（200倍稀释），避光放置于EP管架上；")])])], 1)], 1)], 1)], 1)], 1)
},staticRenderFns: []}

/***/ })

});
//# sourceMappingURL=5.20046ec4b55bbb80908f.js.map