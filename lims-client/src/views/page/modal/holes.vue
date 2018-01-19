<template>
	<div class="img-wrap" >
	    <div class="circle-wrap" :holes="data">
	    <div v-for="hole in data.holeList" class="circle" :class="{'unuse':hole.state === 1,'use':hole.state === 2,'forbidden':hole.state === 3,'add':hole.state === 4}"></div>
	    </div>
	</div>
</template>
<script>
	export default {
		props: {
			data: {
				type: Object
			}
		}
	}
</script>
<style lang="scss" scoped>
	.img-wrap {
        width: 253px;
        height: 253px;
        margin: 0 auto;
        background: url(~assets/image/pic_xpsy.png);
        background-size: contain;
        padding-top: 58px;
        .circle-wrap {
            width: 140px;
            height: 140px;
            margin: 0 auto;
            padding: 7px 10px;
            .circle {
                display: inline-block;
                width: 24px;
                height: 24px;
                margin: 2px 3px;
                border-radius: 50%;
                background-color: #5c7dfe;
            }
            .use {
                background-color: #5c7dfe;
            }
            .unuse {
                background-color: #fff;
            }
            .forbidden {
                background-color: #d3dce6;
            }
            .add {
                background-color: #f00;
            }
        }
    }
</style>	