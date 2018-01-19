/**
 * 禁用tab点击
 * @param disabled
 */
export function setTabDisabled(disabled) {
    var tabs = document.getElementsByClassName("el-tabs__nav");
    if (disabled) {
        tabs[0].setAttribute("class", "el-tabs__nav tabs-disabled");
    } else {
        tabs[0].setAttribute("class", "el-tabs__nav");
    }
}