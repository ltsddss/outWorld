

<template>
  <el-container id="container">
    <!-- header -->
    <el-header style="height:auto">
      <nav-head :user="user"></nav-head>
    </el-header>
    <!-- main -->
    <el-main>
      <el-row class="classify-content common-content-row">
        <el-col>
          <div class="grid-content">
            <p></p>
          </div>
        </el-col>
        <el-col>
          <div class="grid-content common-content">
            <el-row v-for="idx in classifyTitle.length"
                    :key="idx"
                    class="classify-title">
              <span class="type-span">{{classifyTitle[idx-1].title}}</span>
              <span class="tag-span"
                    v-for="(item ,index) in classifyTitle[idx-1].items"
                    :key="index"><a @click="selectBorastPartition">{{item}}</a></span>
            </el-row>
            <div style="height:auto;overflow-y:hidden;">
              <ul>
                <li v-for="idx in Math.ceil(loaded/oneLine)"
                    :key="idx">
                  <el-row class="item-row">
                    <el-col :span="24/oneLine"
                            v-for="i in oneLine"
                            :key="i">
                      <card :card="classifyItems[(idx-1)*oneLine+i-1]"></card>
                    </el-col>
                  </el-row>
                </li>
                <p v-if="loading">加载中...</p>
                <p v-if="noMore">别再拉了，裤子要掉了(〒︿〒)</p>
              </ul>
            </div>
          </div>
        </el-col>
        <el-col>
          <div class="common-right-content">
            <back-top></back-top>
          </div>
        </el-col>
      </el-row>
    </el-main>
    <!-- footer -->
    <el-footer style="height:auto">
      <footer-bar></footer-bar>
    </el-footer>
  </el-container>
</template>
<script>
import NavHead from '../components/NavHead.vue'
import FooterBar from '../components/FooterBar.vue'
import Card from '../components/Card.vue'
import BackTop from '../components/BackTop.vue'
export default {
  name: 'Classify',
  components: {
    NavHead,
    FooterBar,
    Card,
    BackTop
  },
  data: function () {
    return {
      user: null,
      oneLine: 4,
      classifyTitle: [
        { title: '题材', items: ['学习','游戏'] },
      ],
      classifyItems: [
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' },
        { borast_title: '辉夜大小姐想让我告白 ~天才们的恋爱头脑战~', borast_img: require('../assets/img/card.png'), borastPartition: '学习' }
      ],
      loaded: 12,
      loading: false
    }
  },
  computed: {
    noMore () {
      return this.loaded >= 42
    },
    disabled () {
      return this.loading || this.noMore
    }
  },
  methods: {
    // 滚动条在Y轴上的滚动距离
    getScrollTop: function () {
      var scrollTop = 0
      var bodyScrollTop = 0
      var documentScrollTop = 0
      if (document.body) {
        bodyScrollTop = document.body.scrollTop
      }
      if (document.documentElement) {
        documentScrollTop = document.documentElement.scrollTop
      }
      scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop
      return scrollTop
    },
    // 文档的总高度
    getScrollHeight: function () {
      var scrollHeight = 0
      var bodyScrollHeight = 0
      var documentScrollHeight = 0
      if (document.body) {
        bodyScrollHeight = document.body.scrollHeight
      }
      if (document.documentElement) {
        documentScrollHeight = document.documentElement.scrollHeight
      }
      scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight
      return scrollHeight
    },
    // 浏览器视口的高度
    getWindowHeight: function () {
      var windowHeight = 0
      if (document.compatMode === 'CSS1Compat') {
        windowHeight = document.documentElement.clientHeight
      } else {
        windowHeight = document.body.clientHeight
      }
      return windowHeight
    },
    scroll: function () {
      window.onscroll = () => {
        let bottomOfWindow = this.getScrollTop() + this.getWindowHeight() === this.getScrollHeight()

        if (bottomOfWindow && !this.disabled) {
          this.loading = true
          setTimeout(() => {
            // 加载数据
            for (let i = 0; i < 4; i++) {
              this.classifyItems.push({ name: '抱歉，我要毁灭一下这个地球', img: require('../assets/img/card2.png'), type: '奇幻，校园，智斗' })
            }
            this.loaded += this.oneLine
            this.loading = false
          }, 1000)
        }
      }
    },
    selectBorastPartition: function (){
      console.log("点击了分区")
      this.$emit("selectChange",'string')
    }
  },
  mounted () {
    this.scroll()
  }
}
</script>
<style scoped>
@import "../assets/css/common.css";
.el-header {
  padding: 0;
  height: auto;
}
.el-main {
  padding-left: 0px;
  padding-right: 0px;
}
.classify-content {
  display: flex;
}
.grid-content {
  height: 100%;
}
.classify-title {
  display: flex;
  margin-bottom: 20px;
}
.type-span {
  margin-right: 14px;
  color: rgba(0, 0, 0, 0.34);
}
.tag-span {
  margin: 0 4px;
  padding: 0 10px;
  color: rgba(0, 0, 0, 0.87);
}
ul {
  padding: 0px;
}
.item-row {
  margin-bottom: 20px;
}
</style>
