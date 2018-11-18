<template>
  <div class="cmt-container">
    <h3>发表评论</h3>
    <hr>
    <textarea placeholder="请输入要BB的内容（做多吐槽120字）" maxlength="120" v-model="msg"></textarea>

    <mt-button type="primary" size="large" @click='postComment' >发表评论</mt-button>

    <div class="cmt-list">
      <div class="cmt-item" v-for="(item, i) in comments" :key="item.add_time">
        <div class="cmt-title">
          第{{ i+1 }}楼&nbsp;&nbsp;用户：{{ item.user_name }}&nbsp;&nbsp;发表时间：{{ item.add_time | dateFormat }}
        </div>
        <div class="cmt-body">
          {{ item.content === 'undefined' ? '此用户很懒，嘛都没说': item.content }}
        </div>
      </div>

    </div>

    <mt-button type="danger" size="large" plain @click="getMore">加载更多</mt-button>
  </div>
</template>

<script>
import { Toast } from "mint-ui";
export default {
  data() {
    return {
      pageIndex: 1, // 默认展示第一页数据
      comments: [] ,// 所有的评论数据
      msg:''

    };
  },
  created() {
    this.getComments();
  },
  methods: {
    getComments() {
      // 获取评论
      this.$http
        .get("./data/comment.json").then(result => {
          
            // 每当获取新评论数据的时候，不要把老数据清空覆盖，而是应该以老数据，拼接上新数据
            this.comments = this.comments.concat(result.body);
        
        });
    },
    getMore() {
      // 加载更多
      this.pageIndex++;
      this.getComments();
    },

    postComment(){
        if(this.msg.trim().length === 0){
          return Toast("评论内容不能为空");
        }

        var com = {
          "user_name":"匿名用户",
          "time":Date.now(),
          "content":this.msg
        }

        this.comments.unshift(com);
    }
  },
  props: ["id"]
};
</script>

<style lang="less" scoped>
.cmt-container {
  h3 {
    font-size: 18px;
  }
  textarea {
    font-size: 14px;
    height: 85px;
    margin: 0;
  }

  .cmt-list {
    margin: 5px 0;
    .cmt-item {
      font-size: 13px;
      .cmt-title {
        line-height: 30px;
        background-color: #ccc;
      }
      .cmt-body {
        line-height: 35px;
        text-indent: 2em;
      }
    }
  }
}
</style>
