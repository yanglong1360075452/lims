<template>
    <div>
        <div class="indexContainer">
            <div class="editorContainer">
                <markdown
                        :mdValuesP="msg.mdValue"
                        :fullPageStatusP="false"
                        :editStatusP="false"
                        :previewStatusP="true"
                        :navStatusP="false"
                        :icoStatusP="false"
                        @childevent="childEventHandler"
                        v-if="modalShow"
                ></markdown>
            </div>
        </div>
        <div v-html="msg.htmlValue" v-if="!modalShow" class="sopClass"></div>
    </div>
</template>

<script>
    import markdown from 'components/markdown/markdown.vue'
    import SDSSop from '../../../../static/extract-sop/SDSSop.md'
    import CTABStandardSop from '../../../../static/extract-sop/CTABStandardSop.md'
    import SodiumSop from '../../../../static/extract-sop/SodiumSop.md'
    import BloodGenomeSop from '../../../../static/extract-sop/BloodGenomeSop.md'
    import BloodRbcSop from '../../../../static/extract-sop/BloodRbcSop.md'
    import InsectSop from '../../../../static/extract-sop/InsectSop.md'
    import TeaSop from '../../../../static/extract-sop/TeaSop.md'
    import STESop from '../../../../static/extract-sop/STESop.md'
    import MushroomSop from '../../../../static/extract-sop/MushroomSop.md'
    import CHIPSop from '../../../../static/extract-sop/CHIPSop.md'
    import TrizolSop from '../../../../static/extract-sop/TrizolSop.md'
    import PolyphenolsSop from '../../../../static/extract-sop/PolyphenolsSop.md'
    import CTABSop from '../../../../static/extract-sop/CTABSop.md'
    import OfficinalSop from '../../../../static/extract-sop/OfficinalSop.md'
    import PlanteasySop from '../../../../static/extract-sop/PlanteasySop.md'
    import EASYspinSop from '../../../../static/extract-sop/EASYspinSop.md'
    import MirVanaSop from '../../../../static/extract-sop/MirVanaSop.md'
    import StrawberrySop from '../../../../static/extract-sop/StrawberrySop.md'
    import GuSCNTwoSop from '../../../../static/extract-sop/GuSCNTwoSop.md'
    import GuSCNStandardSop from '../../../../static/extract-sop/GuSCNStandardSop.md'
    import EventBus from '@/assets/eventBus';
    import Extract from '@/api/extract';
    import Vue from 'vue'

    export default {
        mounted() {
            let self = this;
            EventBus.$on("extractMethod", function (msg) {
                self.msg.mdValue = self.sopJson[msg];
                /*
                 以v-if加延迟的方式重新渲染sop
                 */
                self.modalShow = false;
                setTimeout(() => {
                    self.modalShow = true;
                }, 0);
            });
        },
        data() {
            return {
                msg: {
                    mdValue: null,
                    htmlValue: null
                },
                modalShow: true,
                sopJson: {
                    "SDSSop": SDSSop,
                    "CTABStandardSop": CTABStandardSop,
                    "SodiumSop": SodiumSop,
                    "BloodGenomeSop": BloodGenomeSop,
                    "BloodRbcSop": BloodRbcSop,
                    "InsectSop": InsectSop,
                    "TeaSop": TeaSop,
                    "STESop": STESop,
                    "MushroomSop": MushroomSop,
                    "CHIPSop": CHIPSop,
                    "TrizolSop": TrizolSop,
                    "PolyphenolsSop": PolyphenolsSop,
                    "CTABSop": CTABSop,
                    "OfficinalSop": OfficinalSop,
                    "PlanteasySop": PlanteasySop,
                    "EASYspinSop": EASYspinSop,
                    "MirVanaSop": MirVanaSop,
                    "StrawberrySop": StrawberrySop,
                    "GuSCNTwoSop": GuSCNTwoSop,
                    "GuSCNStandardSop": GuSCNStandardSop,
                }
            }
        },
        components: {
            markdown
        },
        methods: {
            childEventHandler: function (res) {
                if (res) {
                    if (res.indexOf("file:") != -1) {
                        this.modalShow = false;
                        this.msg.htmlValue = res.replace(/file:\/\//g, 'static/extract-sop');
                    }
                }
            }
        }
    }
</script>

<style lang="scss" scoped>
    .show {
        position: absolute;
        left: 0;
        top: 0;
    }

    .indexContainer {
        width: 100%;
        height: 100%;
        background: #ddd;
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
    }

    .editorContainer {
        width: 100%;
        height: 100%;
    }

    .sopClass {
        height: 700px;
        overflow: auto;
    }
</style>