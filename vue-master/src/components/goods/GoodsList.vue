<template>
    <div class="goods-list">
      <router-link class="goods-item" v-for="(item,index) in goodsList" :key="index" :to="'/home/GoodsInfo/'+item.id" >
      <img :src="item.img">
      <h1 class="title">{{item.title}}</h1>
      <div class="info">
        <p class="price">
          <span class="now">￥{{item.now}}</span>
          <span class="old">￥{{item.old}}</span>
        </p>
        <p class="sell">
          <span>热卖中</span>
          <span>剩{{item.total}}件</span>
        </p>
      </div>
      </router-link>
      <mt-button type="danger" size="large" @click="getmore">加载更多</mt-button>

    
    </div>
</template>
<script>
export default {
  data() {
    return {
      goodsList: []
    };
  },
  created() {
    this.getGoodsList();
  },
  methods: {
    getGoodsList() {
      this.$http.get("./data/goodsList.json").then(result => {
        this.goodsList = this.goodsList.concat(result.body);
      });
    },
    getmore(){
        this.getGoodsList();
    }
  }
};
</script>
<style lang="less" scoped>
.goods-list {
  display: flex;
  flex-wrap: wrap;
  padding: 7px;
  justify-content: space-between;

  .goods-item {
    width: 49%;
    border: 1px solid #ccc;
    box-shadow: 0 0 8px #ccc;
    margin: 4px 0;
    padding: 2px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    min-height: 293px;
    img {
      width: 100%;
    }
    .title {
      font-size: 14px;
    }

    .info {
      background-color: #eee;
      p {
        margin: 0;
        padding: 5px;
      }
      .price {
        .now {
          color: red;
          font-weight: bold;
          font-size: 16px;
        }
        .old {
          text-decoration: line-through;
          font-size: 12px;
          margin-left: 10px;
        }
      }
      .sell {
        display: flex;
        justify-content: space-between;
        font-size: 13px;
      }
    }
  }
}
</style>
