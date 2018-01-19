<template>
    <div class="slider-bar">
        <div class="hamburger-left-container" :style="{'text-align':sidebar.opened?'center':'left'}">
            <hamburger class="hamburger-container" :toggleClick="toggleSideBar" :isActive="sidebar.opened"></hamburger>
        </div>
        <el-menu mode="vertical" unique-opened @open="handleOpen" :default-active="$route.path">
            <sidebar-item :routes='permission_routers' :active-key="activeKey"></sidebar-item>
        </el-menu>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex';
    import SidebarItem from './SidebarItem';
    import Hamburger from 'components/Hamburger';
    import IconSvg from "components/Icon-svg/index";

    export default {
        components: {
            IconSvg,
            SidebarItem, Hamburger
        },
        computed: {
            ...mapGetters([
                'permission_routers',
                'sidebar'
            ])
        },
        data(){
            return {
                textAlign: "left",
                activeKey: '/'+this.$route.path.split('/')[1]
            }
        },
        methods: {
            handleOpen(key, keyPath){
                this.activeKey = key;
                console.log(key, keyPath);
            },
            toggleSideBar() {
                this.$store.dispatch('ToggleSideBar')
            }
        }
    }
</script>

<style rel="stylesheet/scss" lang="scss">
    @import '~styles/variable.scss';

    .slider-bar{
        .el-menu {
            // min-height: 100%;
            background-color: #ffffff;
        }

        .el-submenu.is-active .el-submenu__title{
            border-bottom: 1px solid #eee !important;
        }

        .el-menu-item, .el-submenu__title{
            height: 50px;
            line-height: 50px;
            padding-left: 20px !important;
            color: $color-text-l;


        }

        .el-submenu{
            .el-menu-item{
                height: 40px;
                line-height: 40px;
                background-color: $color-text-lll;
                padding-left: 20px !important;
                &:hover,&.is-active{
                    background-color: $color-theme-ll;
                    color: $color-theme !important;
                }
            }
            .el-submenu{
                .el-menu-item {
                    padding-left: 40px !important;

                }

            }
        }


        .hamburger-left-container {
            height: 50px;
            text-align: left;
            line-height: 50px;
            padding: 0 15px;
            background-color: $color-text-ll;
            color: #fff;
        }
    }


</style>
