<template>
    <div>
        <div class="mui-numbox" data-numbox-min='1' data-numbox-max='9'>
            <button class="mui-btn mui-btn-numbox-minus" type="button">-</button>
            <input id="test" class="mui-input-numbox" type="number" :value="count" @change="changNum" ref="numbox"/>
            <button class="mui-btn mui-btn-numbox-plus" type="button">+</button>
		</div>
    </div>
</template>
<script>
    import mui from "../../lib/mui/js/mui.min.js";
    export default {
        mounted() {
            // 初始化数字选择框组件
            mui(".mui-numbox").numbox();
        },
        methods:{
            changNum(){
                //每次数量被修改时，需要将值同步给我们的购物车
                this.$store.commit("uppdateGoodsInfo",{
                    id:this.goodsId,
                    count:this.$refs.numbox.value
                })                
            }
        },
        props:["count" ,"goodsId"]

};
</script>
<style lang="less" scoped>
</style>
