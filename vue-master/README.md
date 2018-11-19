# 这是我的第一个vue项目

## 艾玛呀，历经3天，终于完成了，可真的累呀，离秃顶不远了，哈哈哈~，接下来写下我这个项目的具体过程，

## 制作首页App组件
1. 完成 Header 区域，使用的是 Mint-UI 中的Header组件
2. 制作底部的 Tabbar 区域，使用的是 MUI 的 Tabbar.html
3. 要在 中间区域放置一个 router-view 来展示路由匹配到的组件

## 改造 tabbar 为 router-link

将4个tabbar 设置成路由

## 设置路由高亮

在route.js中覆盖默认高亮的累，默认的类是router -link-active

## 点击 tabbar 中的路由链接，展示对应的路由组件

配置 路由 规则，使其展示出对应的路由组件

## 制作首页轮播图布局

手写轮播图是不存在的，有现成的为什么要手写，利用了mint-UI中的swipe 组件

## 加载首页轮播图数据
1. 获取数据， 如何获取呢， 使用 vue-resource
2. 使用 vue-resource 的 this.$http.get 获取数据
3. 获取到的数据，要保存到 data 身上
4. 使用 v-for 循环渲染 每个 item 项

## 改造 九宫格 区域的样式

mint-ui有九宫格，我的项目是三个？？？那删掉三个完事了

## 改造 新闻资讯 路由链接

## 新闻资讯 页面 制作
1. 绘制界面， 使用 MUI 中的 media-list.html
2. 使用 vue-resource 获取数据
3. 渲染真实数据

## 实现 新闻资讯列表 点击跳转到新闻详情
1. 把列表中的每一项改造为 router-link,同时，在跳转的时候应该提供唯一的Id标识符
2. 创建新闻详情的组件页面  NewsInfo.vue
3. 在 路由模块中，将 新闻详情的 路由地址 和 组件页面对应起来

## 实现 新闻详情 的 页面布局 和数据渲染

## 单独封装一个 comment.vue 评论子组件
1. 先创建一个 单独的 comment.vue 组件模板
2. 在需要使用 comment 组件的 页面中，先手动 导入 comment 组件
 + `import comment from './comment.vue'`
3. 在父组件中，使用 `components` 属性，将刚才导入 comment 组件，注册为自己的 子组件
4. 将注册子组件时候的，注册名称，以 标签形式，在页面中 引用即可

## 获取所有的评论数据显示到页面中
1. getComments

## 实现点击加载更多评论的功能
1. 为加载更多按钮，绑定点击事件，在事件中，请求 下一页数据
2. 点击加载更多，让 pageIndex++ , 然后重新调用 this.getComments() 方法重新获取最新一页的数据
3. 为了防止 新数据 覆盖老数据的情况，我们在 点击加载更多的时候，每当获取到新数据，应该让 老数据 调用 数组的 concat 方法，拼接上新数组

## 发表评论
1. 把文本框做双向数据绑定
2. 为发表按钮绑定一个事件
3. 校验评论内容是否为空，如果为空，则Toast提示用户 评论内容不能为空
4. 然后将发表的评论组成一个对象，用户名，评论内容，评论时间等
5. 最后将这个对象unshift 到 评论内容的最前面，
## 改造图片分析 按钮为 路由的链接并显示对应的组件页面

## 绘制 图片列表 组件页面结构并美化样式
  1. 制作 顶部的滑动条
  2. 制作 底部的图片列表
### 制作图片列表区域
1. 图片列表需要使用懒加载技术，我们可以使用 Mint-UI 提供的现成的 组件 `lazy-load`
2. 根据`lazy-load`的使用文档，尝试使用
3. 渲染图片列表数据

### 实现了 图片列表的 懒加载改造和 样式美化

## 实现了 点击图片 跳转到 图片详情页面
1. 在改造 li 成 router-link 的时候，需要使用 tag 属性指定要渲染为 哪种元素

## 实现 详情页面的布局和美化，同时获取数据渲染页面

## 绘制 商品列表 页面基本结构并美化

## 渲染商品列表页面

1. 利用vue-resource 获取到数据

2. 通过v-for 渲染页面


## 改造商品列表页面为路由

改造路由的同时需要把ID 给传递过去，

## 实现加载更多商品列表功能

功能几乎和加载更多新闻列表一样

## 点击商品列表进入到商品详情

## 渲染商品详情页面

1. 获取传过来的ID，通过this.$route.params 拿到id值

   注意：this.$route.params是获取     /   的值

   ​	     this.$route.query是 获取     ？  的值



   2.拿到id后，请求数据渲染页面

## 将numbox（购买数量的增减）进行封装

## 引入封装后的numbox子路由

1. 导入numbox路由
2. 在components中注册numbox
3. 在页面中直接通过标签引入

## 安装vuex

```js
npm i vuex -S
```

```js
import Vuex from 'vuex'
Vue.use('vuex')
```

```js
var store = new Vuex.store({
    state:{},//存放的数据  类似于data
    mutations:{},//存放的方法， 类似methods
    getters:{}//对数据进行处理，类似filters
})
```





## 实现加入购物车的功能

1. 因为涉及的多组件中公用的数据，为此安装了vuex
2. 在vuex中定义了car数组，该数组保存了所有的购物车中产品的信息
3. 把数据传给vuex中的addToCar,让vuex代替将值保存到car数组中
4. 在保存数据之前，要判断一下购物车数组中是否存在商品，通过id判断，如果存在了，那么不需要把商品保存在数组中了，只需要增加数量即可，如果不存在，那么就把数据直接push到购物车数组car中。
5. push到数组之后，还有一个功能，需要把car数组中的值保存到本地，不然在次刷新的时候，购物车里就没有值了，通过localStoreage.setItem("car",JSON.Stringfgy(state.car))
6. 在一开时car 中的值通过JSON.parse(localStorage.getItem("car" || "[]"))
7. 如果本地没有数据，那么car的值就为空数组

## 渲染购物车列表信息

1. 因为数据都存放在vuex中的购物车数组中
2. 渲染页面只需要渲染购物车中数组信息即可
3. 通过$store.state.car 就可以了

## 实现购物车商品删除功能

1. 在vuex中新增一个remove的方法
2. 在购物车路由中用this.$store.commit()将id传给remove，让vuex代替我们删除car中的商品
3. 同时也是要让删除后的商品保存到本地

## 实现购物车商品数量的增减功能

1. 在numbox组件中添加change事件，如果数量框发生了改变，就把值传给vuex
2. 同样的，也在vuex中定义一个方法，
3. 要让修改后的商品保存到本地

## 实现购物车商品修改状态框功能

1. 在我商品详情页面添加到购物车的时候，就默认给设置了一个selected的值，就一开始默认就是选中的
2. 然后改变给状态绑定双向绑定
3. 最后也要将修改后的值保存到本地中

## 实现商品的总件数和总价

只需要给vuex添加一个方法，将所有状态选中的商品价格给 算数来就好了。



#### 总结一遍，让我对我的这个项目又有了深刻的认识，呜哈哈，真棒！