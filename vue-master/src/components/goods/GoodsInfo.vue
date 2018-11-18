<template>
    <div class="goodsinfo-container ">
        <!-- 商品轮播 图 区域 -->
        <div class="mui-card">
            <div class="mui-card-content">
                <div class="mui-card-content-inner">
                    <!-- 轮播图 -->
                    <swipe :lunbotuList="bannerList"></swipe>
                </div>
            </div>
        </div>
        <!-- 商品展览区 -->
        <!-- 商品购买区域 -->
        <div class="mui-card">
            <div class="mui-card-header">{{ goodsinfo.title }}</div>
            <div class="mui-card-content">
              <div class="mui-card-content-inner">
                <p class="price">
                    市场价：<del>￥{{ goodsinfo.market_price }}</del>&nbsp;&nbsp;销售价：<span class="now_price">￥{{ goodsinfo.sell_price }}</span>
                </p>
                <p>购买数量：<numbox class="numbox" @getCount='getSelectCount'></numbox></p>
                <p>
                <mt-button type="primary" size="small" >立即购买</mt-button>
                <mt-button type="danger" size="small" @click="addToShopCar">加入购物车</mt-button>       
                </p>
              </div>
            </div>
        </div>
        <!-- 商品参数区域 -->
        <div class="mui-card">
          <div class="mui-card-header">商品参数</div>
          <div class="mui-card-content">
            <div class="mui-card-content-inner">
              <p>商品货号：{{ goodsinfo.goods_no }}</p>
              <p>库存情况：{{ goodsinfo.stock_quantity }}件</p>
              <p>上架时间：{{ goodsinfo.add_time | dateFormat }}</p>
            </div>
          </div>
          <div class="mui-card-footer">
            <mt-button type="primary" size="large" plain>图文介绍</mt-button>
            <mt-button type="danger" size="large" plain>商品评论</mt-button>
          </div>
        </div>
        
        
        <!--  -->
    </div>
</template>
<script>
import swipe from "../subcomponents/swipe.vue";
import numbox from "../subcomponents/goodsInfo_numbox.vue";
export default {
  data() {
    return {
      id: this.$route.params.id, 
      bannerList: [],
      goodsinfo: {},
      SelectCount:1
    };
  },
  created() {
    this.getBanner();
    this.getGoodsInfo();
  },
  methods: {
    getBanner() {
      //获取轮播图信息
      this.$http.get("./data/goodsBanner.json").then(result => {
        this.bannerList = result.body;
      });
    },
    getGoodsInfo() {
      // 获取商品的信息
      //./data/goodsInfo.json +  id 
      this.$http.get("./data/goodsInfo.json").then(result => {
        this.goodsinfo = result.body;
      });
    },
    getSelectCount(data){
      //接受子组件传来的数量值
        this.SelectCount=data;
        
    },
    addToShopCar(){
      //加入购物车
      console.log(this.id)
      var goodsinfo = {
        id:this.id,
        count:this.SelectCount,
        title:this.goodsinfo.title,
        price:this.goodsinfo.sell_price,
        selected:true

      }

      this.$store.commit("addToCar",goodsinfo)

    }
  },
  components: {
    swipe,
    numbox

  }
};
</script>
<style lang="less" scoped>

.goodsinfo-container {
  .numbox{
    display: inline-block;
  }
  background-color: #eee;
  overflow: hidden;

  .now_price {
    color: red;
    font-size: 16px;
    font-weight: bold;
  }

  .mui-card-footer {
    display: block;
    button {
      margin: 15px 0;
    }
  }

  .ball {
    width: 15px;
    height: 15px;
    border-radius: 50%;
    background-color: red;
    position: absolute;
    z-index: 99;
    top: 390px;
    left: 146px;
  }
}
</style>
