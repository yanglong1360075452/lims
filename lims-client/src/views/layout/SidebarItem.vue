<template>
    <div id="slider-item">
        <template v-for="item in routes">
            <el-submenu class="menu-item" :class="{active:item.path === activeKey }"
                        :index="item.path" v-if="!item.noDropdown&&!item.hidden">
                <template slot="title">
                    <div class="icon-bg" :class="[item.iconBg]"></div>
                    <icon-svg v-if='item.icon' :icon-class="item.icon"/>
                    <!--<icon-svg icon-class="lead"/>-->
                    {{item.desc}}
                    <!--<div v-show="item.path === '/sample'" class="badge">1</div>-->
                </template>
                <template v-for="child in item.children" v-if='!child.hidden'>
                    <sidebar-item class='menu-indent' v-if='child.children&&child.children.length>0'
                                  :routes='[child]'></sidebar-item>
                    <router-link v-else class="menu-indent" :to={name:child.name}>
                        <el-menu-item :index="item.path+'/'+child.path">
                            <icon-svg v-if="child.icon" :icon-class="child.icon"/>
                            {{child.desc}}
                        </el-menu-item>
                    </router-link>
                </template>
            </el-submenu>
        </template>
    </div>
</template>

<script>
    export default {
        name: 'SidebarItem',
        computed: {
            sidebar() {
                return this.$store.state.app.sidebar;
            }
        },
//        watch:{
//            "activeKey":function (value) {
//                console.warn(value)
//            }
//        },
        props: {
            activeKey:{
                type: String
            },
            routes: {
                type: Array
            }
        }
    }
</script>

<style rel="stylesheet/scss" lang="scss">
    @import "~styles/variable";

    #slider-item{


        .menu-indent {
            display: block;
            text-indent: 10px;
        }

        .menu-item {

            .el-submenu__title {
                padding-left: 20px !important;
                color: $color-text-l;
                &:hover{
                    background-color: #ffffff;
                    color: $color-text;
                }
                .badge{
                    width: 16px;
                    height: 16px;
                    position: absolute;
                    background-color: $color-red;
                    right: 50px;
                    top: 17px;
                    line-height: 16px;
                    text-align: center;
                    color: white;
                    border-radius: 50%;
                    font-size: 10px;
                }
                .badge-small{
                    width: 5px;
                    height: 5px;
                    position: absolute;
                    background-color: $color-red;
                    top: 17px;
                    left: 28px;
                    border-radius: 50%;
                }
            }

            .svg-icon {
                margin-right: 25px;
                position: relative;
                left: -2px;
                z-index: 1;
                fill:$color-theme ;

            }

            &:hover {
                .icon-bg {
                    width: 50px;
                }
                .svg-icon {
                    fill: #ffffff;
                }
            }

            &.active {
                .el-submenu__title {
                    color: $color-text;
                }
                .el-menu-item{
                    color: $color-text;
                }

                .icon-bg {
                    width: 50px;
                }
                .svg-icon {
                    fill: #ffffff;
                }
            }
            .svg-icon, .icon-bg {
                transition: all .5s;
            }
            .icon-bg{
                position: absolute;
                left: 0;
                width: 3px;
                height: 100%;
                z-index: 1;
            }


        }
    }

</style>

