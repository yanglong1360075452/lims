<template>
    <div class="app-wrapper" :class="{hideSidebar:!sidebar.opened,hideBadge:sidebar.opened}">
        <header-bar></header-bar>
        <div class="sidebar-wrapper" @mouseover="mouseover()"
             @mouseout="mouseout()" :class="{'slider-hover':ifHover}">
            <sidebar class="sidebar-container"></sidebar>
        </div>
        <div class="main-container">
            <app-main></app-main>
        </div>
    </div>
</template>

<script>
    import {Navbar, Sidebar, AppMain, HeaderBar} from '@/views/layout';

    export default {
        name: 'layout',
        components: {
            Navbar,
            Sidebar,
            AppMain,
            HeaderBar
        },
        watch:{
          'sidebar.opened':function (value) {
              if(this.ifHover && !value){
                  this.ifHover=false
              }
          }
        },
        data(){
            return {
                ifHover: false
            }
        },
        methods: {
            mouseover(){
                this.ifHover = true;
            },
            mouseout(){
                if(!this.sidebar.opened)
                    this.ifHover = false;
            }
        },
        computed: {
            sidebar() {
                return this.$store.state.app.sidebar;
            }
        }
    }
</script>

<style rel="stylesheet/scss" lang="scss">
    @import "~styles/mixin.scss";
    @import "~styles/variable.scss";

    .app-wrapper {
        @include clearfix;
        position: relative;
        height: 100%;
        width: 100%;
        background-color: $color-text-lll;

        .el-submenu .el-menu {
            transition: .5s;
            overflow: hidden;
        }


        .sidebar-wrapper.slider-hover {
            &:hover {
                transform: translate(0, 0) !important;
                .sidebar-container {
                    transform: translate(0, 0) !important;
                    .hamburger-left-container {
                        text-align: center !important;

                    }
                    .el-submenu{
                        .el-menu {
                            display: block;
                            /*height: 300px;*/
                        }
                        .badge-small{
                            display: none;
                        }
                    }
                }
            }
        }

        &.hideBadge{
            .badge-small{
                display: none !important;
            }
        }

        &.hideSidebar {
            .sidebar-wrapper {
                transform: translate(-192px, 0);
                .sidebar-container {
                    transform: translate(192px, 0);
                    .el-submenu .el-menu {
                        /*height: 0;*/
                        display: none;
                        .badge-small{
                            display: block;
                        }
                    }
                }

            }
            .main-container {
                margin-left: 50px;
            }
        }
        .sidebar-wrapper {
            width: 240px;
            position: fixed;
            top: 70px;
            bottom: 0;
            left: 0;
            z-index: 20;
            overflow: hidden;
            transition: all .28s ease-out;
            box-shadow: 0 6px 10px 0 rgba(214, 221, 229, 1);

        }
        .sidebar-container {
            transition: all .28s ease-out;
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            overflow-y: auto;
        }
        .main-container {
            min-height: 100%;
            transition: all .28s ease-out;
            margin-left: 240px;
            margin-top: 70px;
            /*<!--background-color: $color-text-lll;-->*/
        }
    }


</style>
