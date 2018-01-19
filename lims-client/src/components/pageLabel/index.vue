<template>
    <div class="label-wrapper">
        <div class="icon">
            <icon-svg :icon-class="icon"></icon-svg>
        </div>

        <div class="content">
            <div class="title">{{title}}</div>
            <div class="subTitle">{{subTitle}}</div>
        </div>
    </div>
</template>

<script>
    import IconSvg from "components/Icon-svg/index";

    export default {
        name: 'index',
        components:{IconSvg},
        props: {
            title:{
                type:String,
                require:true
            },
            subTitle:{
                type:String
            },
            icon:{
                type:String,
                require:true,
                default:""
            }
        }

    }
</script>

<style lang="scss" scoped>
    @import '~styles/variable.scss';

    .label-wrapper{
        display: flex;
        align-items: center;
        .icon{
            width: 44px;
            height: 44px;
            line-height: 44px;
            border-radius: 4px;
            background-color: $color-theme;
            text-align: center;
            vertical-align: middle;
            position: relative;

            &:after{
                content: "";
                position: absolute;
                left: 7px;
                top:7px;
                width: 44px;
                height: 44px;
                opacity: 0.3;
                border-radius: 4px;
                background-color: $color-theme;
                -webkit-filter: blur(5.6px);
                filter: blur(5.6px);
                background-color: #5c7dfe;
            }
            svg{
                width: 18px;
                height: 18px;
            }
        }
        .content{
            >div{
                padding: 4px 22px;
            }
            .title{
                font-size: 18px;
                font-weight: 500;
            }
            .subTitle{
                font-size: 14px;
                font-weight: 500;
                color: $color-text-l;
            }
        }
    }
</style>