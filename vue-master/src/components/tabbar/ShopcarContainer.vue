<template>
  <div>
    <div class="goods-list">
          <div class="mui-card" v-for="(item,i) in this.$store.state.car " :key="item.id">
              <div class="mui-card-content">
                <div class="mui-card-content-inner">
                    <mt-switch v-model="$store.getters.getGoodsSelected[item.id]"
                     @change="selectedChanged(item.id,$store.getters.getGoodsSelected[item.id])"></mt-switch>
                    <img src="http://localhost:3000/src/images/goodsBanner/goodimg1.jpg" alt="">
                    <div class="info">
                      <h1> {{item.title}}</h1>
                      <p>
                        <span class="price">￥{{item.price}}</span>
                        <numbox :count='item.count' :goodsId="item.id"></numbox>
                        <a href="#" @click="remove(item.id,i)">删除</a>
                      </p>

                    </div>
                </div>
              </div>
          </div>
        <div class="mui-card">
				<div class="mui-card-content">
					<div class="mui-card-content-inner jiesuan">
						<div class="left">
              <p>总计（不含运费）</p>
              <p>已勾选商品 <span class="red">{{ $store.getters.getGoodsCountAndAmount.count }}</span> 件， 总价 <span class="red">￥{{ $store.getters.getGoodsCountAndAmount.amount }}</span></p>
            </div>
             <mt-button type="danger">去结算</mt-button>
					</div>
				</div>
			  </div>




        </div>
  </div>
</template>

<script>
import numbox from '../subcomponents/shopCar_numbox.vue'

export default {
  data(){
    return{
     
    }
  },
  methods:{
    //提交id给vuex的删除方法
      remove(id,index){
        this.$store.commit("removeFormCar",id);
      },
      selectedChanged(id,val){
        this.$store.commit("updataGoodsSelected",{
          id,
          selected:val
        })
      }

  },
  components:{
    numbox
  }
}
</script>

<style lang="scss" scoped>
.goods-list {
    .mui-card-content-inner {
      display: flex;
      align-items: center;
    }
    img {
      width: 60px;
    }
    h1 {
      font-size: 13px;
    }
    .info {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      .price {
        color: red;
        font-weight: bold;
      }
    }
  }
  .jiesuan {
    display: flex;
    justify-content: space-between;
    align-items: center;
    .red {
      color: red;
      font-weight: bold;
      font-size: 16px;
    }
  }
</style>
