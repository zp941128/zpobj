// 入口文件
import Vue from 'vue'
// 1.1 导入路由的包
import VueRouter from 'vue-router'
// 1.2 安装路由
Vue.use(VueRouter)

import Vuex from 'vuex'
Vue.use(Vuex)

//将本地购物车数据取出
var car = JSON.parse(localStorage.getItem('car') || '[]')
var store = new Vuex.Store({
  state:{
    car:car
  },
  mutations:{
    addToCar(state,goodsinfo){
      

      var flag = false ;
      //点击加入购物车，把商品信息，保存到store中的car上
      state.car.some(item=>{
        if (item.id == goodsinfo.id){
          item.count += parseInt(goodsinfo.count)
          flag = true ;
          console.log(state.car)
          return true ;
        }
      })

      if(!flag){
        state.car.push(goodsinfo)
        console.log(state.car)
      }
      //每次更新car中的数据后将数据保存到本地
      localStorage.setItem("car",JSON.stringify(state.car))


    },
    uppdateGoodsInfo(state,goodsinfo){
      state.car.some(item=>{
        if(item.id == goodsinfo.id){
          item.count = parseInt(goodsinfo.count)
          return true;
        }
      })
      //每次修改完最新的数据后，要把最新的数据保存到localstorage中去
      localStorage.setItem("car",JSON.stringify(state.car))
    },
    removeFormCar(state,id){
      //删除购物车中的数据
      state.car.some((item,i)=>{
        if(item.id == id){
          state.car.splice(i,1)
          return true 
        }
      })

      localStorage.setItem("car",JSON.stringify(state.car))
    },
    updataGoodsSelected(state,info){

      //
        state.car.some(item=>{
          if(item.id==info.id){
            item.selected = info.selected
          }
        })
        localStorage.setItem("car",JSON.stringify(state.car))

        
    }
  },
  getters:{
    getAllCount(state){
      var c = 0;
      state.car.forEach(item =>{
        c+=item.count
      })
      return c;
    },
    getGoodsSelected(state){
      var o ={}
      state.car.forEach(item => {
          o[item.id] = item.selected;
      });
      return o;
    },
    getGoodsCountAndAmount(state){
      var o ={
        count:0,
        amount :0

      }


      state.car.forEach(item=>{
        if(item.selected){
          o.count+=item.count;
          o.amount += item.price * item.count 
        }

        
      })


      return o;
    }
  }
})



// 导入格式化时间的插件
import moment from 'moment'
// 定义全局的过滤器
Vue.filter('dateFormat', function (dataStr, pattern = "YYYY-MM-DD HH:mm:ss") {
  return moment(dataStr).format(pattern)
})

// 2.1 导入 vue-resource
import VueResource from 'vue-resource'
// 2.2 安装 vue-resource
Vue.use(VueResource)
// 设置请求的根路径
Vue.http.options.root = 'http://localhost:3000/src/lib';


// 导入 MUI 的样式
import './lib/mui/css/mui.min.css'
// 导入扩展图标样式
import './lib/mui/css/icons-extra.css'





import MintUI from 'mint-ui'
Vue.use(MintUI)
import 'mint-ui/lib/style.css'


// 1.3 导入自己的 router.js 路由模块
import router from './router.js'


// 导入 App 根组件
import app from './App.vue'

var vm = new Vue({
  el: '#app',
  render: c => c(app),
  router, // 1.4 挂载路由对象到 VM 实例上,
  store
})