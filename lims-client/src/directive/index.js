export default {
    noDataShow: {//列表没有数据显示暂无数据
        componentUpdated: function (el) {
            var tbody = el.children[1];
            var trs = tbody.children;
            if (trs == undefined || trs == null || trs.length == 0) {
                var length = el.children[0].children[0].children.length;
                var tr = document.createElement("tr");
                var td = document.createElement("td");
                td.setAttribute("id", "noData");
                td.setAttribute("align", "center");
                td.setAttribute("border", "0");
                td.style.fontSize = "15px";
                td.setAttribute("colspan", length);
                td.innerHTML = "暂无数据";
                tr.appendChild(td);
                tbody.appendChild(tr);
            } else{
                var td = document.getElementById('noData');
                if (td != null && trs.length != 1) {//除了暂无数据行还有别的数据行就删除暂无数据行
                    var parent = td.parentElement;
                    if (td != null) {
                        tbody.removeChild(parent);
                    }
                }
            }
        }
    },
    meta:{
        bind:function (el, binding, vnode, oldVnode) {
            el.onclick = function() {
                // debugger
                if(el.previousElementSibling.style.display === 'none'){
                    el.previousElementSibling.style.display = 'block'
                    el.children[0].className="el-icon-caret-top"
                }
                else{
                    el.previousElementSibling.style.display = 'none'
                    el.children[0].className="el-icon-caret-bottom"
                }

            }
        }
    }
}