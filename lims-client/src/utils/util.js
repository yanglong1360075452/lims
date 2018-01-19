/**
 * Created by Administrator on 2017/4/18.
 */
/**实用工具*/
const util = function (win) {
    /**
     * 定义一系列变量
     * */
    var util = {};

    /**格式化时间*/
    util.dateFormat = function (fmt) {
        var time = new Date();
        var o = {
            "M+": time.getMonth() + 1,                 //月份
            "d+": time.getDate(),                    //日
            "h+": time.getHours(),                   //小时
            "m+": time.getMinutes(),                 //分
            "s+": time.getSeconds(),                 //秒
            "q+": Math.floor((time.getMonth() + 3) / 3), //季度
            "S": time.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            }
        }
        return fmt;
    };

    util.msToDate = function (val) {
        if (val > 0) {
            var date = new Date(val);
            var Y = date.getFullYear(),
                m = date.getMonth() + 1,
                d = date.getDate(),
                H = date.getHours(),
                i = date.getMinutes(),
                s = date.getSeconds();
            if (m < 10) {
                m = '0' + m;
            }
            if (d < 10) {
                d = '0' + d;
            }
            if (H < 10) {
                H = '0' + H;
            }
            if (i < 10) {
                i = '0' + i;
            }
            if (s < 10) {
                s = '0' + s;
            }
            var t = Y + '-' + m + '-' + d + '  ' + H + ':' + i + ':' + s;
            return t;
        } else {
            return;
        }
    };

    util.dateToMs = function (date) {
        if (date != null) {
            return new Date(date).getTime();
        } else {
            return;
        }
    }

    /**临时数据存储到sessionStorage中*/
    util.dataToSessionStorageOperate = {
        /**存储*/
        save (data_name, data_value) {
            if (data_name && data_value)
                sessionStorage.setItem(data_name, JSON.stringify(data_value));
        },
        /**取出*/
        achieve (data_name) {
            if (!data_name) return;
            var data_value = sessionStorage.getItem(data_name);
            data_value && ( data_value = JSON.parse(data_value) );
            return data_value;
        },
        /**删除*/
        remove (data_name) {
            if (data_name)
                sessionStorage.removeItem(data_name);
        },
        /**清空*/
        clear () {
            sessionStorage.clear();
        }
    };
    //时间转换
    util.dateUtil = {
        checkDate(strInputDate) {
            if(strInputDate == null || strInputDate == undefined){
                return false;
            }
            // 定义一个月份天数常量数组
            var DA = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

            // 统一日期格式
            var strDate = strInputDate.replace(/-/g, "/");

            //判断日期是否是预期的格式
            if (strDate.indexOf("/") == -1) {
                return false;
            }

            // 分解出年月日
            var arrD = strDate.split("/");
            if (arrD.length != 3) return false;
            var y = parseInt(arrD[0], 10);
            var m = parseInt(arrD[1], 10);
            var d = parseInt(arrD[2], 10);

            //判断年月日是否是数字
            if (isNaN(y) || isNaN(m) || isNaN(d)) return false;

            // 判断月份是否在1-12之间
            if (m > 12 || m < 1) return false;
            //判断是否是闰年
            if (new Date(y, 1, 29).getDate() == 29) DA[2] = 29;

            //判断输入的日是否超过了当月月份的总天数。
            if (d > DA[m]) return false;

            //各种条件都验证了，则应该是一个合法的日期了。
            // 如果要对日期进行一次格式化，则可以在这里进行处理了，下面格式化成数据库识别的日期格式 yyyy-MM-dd
            // str = y + "-" + (m<10?"0":"") + m + "-" + (d<10?"0":"") + d;
            var str = y + "-" + (m < 10 ? "0" : "") + m + "-" + (d < 10 ? "0" : "") + d;
            return true;
        },
        dateFormatNewDate(val){
            if (val != null && val != undefined) {
                var date = new Date(val);
                var Y = date.getFullYear(),
                    m = date.getMonth() + 1,
                    d = date.getDate(),
                    H = date.getHours(),
                    i = date.getMinutes(),
                    s = date.getSeconds();
                if (m < 10) {
                    m = '0' + m;
                }
                if (d < 10) {
                    d = '0' + d;
                }
                if (H < 10) {
                    H = '0' + H;
                }
                if (i < 10) {
                    i = '0' + i;
                }
                if (s < 10) {
                    s = '0' + s;
                }
                var t = Y + '-' + m + '-' + d + '  ' + H + ':' + i + ':' + s;
                return t;
            }
        }
    }

    /**跳转页面*/
    util.jumpPage = function (jumpUrl) {
        if (typeof jumpUrl == 'undefined') win.location.href = win.location.origin + '/#/abnormal';
        else if (jumpUrl.indexOf('http') == -1)
            win.location.href = win.location.origin + '/#/' + jumpUrl;
        else
            win.location.href = jumpUrl;
    };
    return util;
}(window);
export default util;
