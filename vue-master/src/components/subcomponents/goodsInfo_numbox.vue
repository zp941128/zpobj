<template>
    <div>
        <div class="mui-numbox" data-numbox-min='1' data-numbox-max='9'>
            <button class="mui-btn mui-btn-numbox-minus" type="button">-</button>
            <input id="test" class="mui-input-numbox" type="number" value="1" @change="changNum" ref="numbox"/>
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
                //向父组件传递值
                this.$emit("getCount",parseInt(this.$refs.numbox.value))
            }
        }

};
</script>
<style lang="less" scoped>
</style>
