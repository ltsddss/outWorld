<template>
  <div>
    <div>
      <div>
        <el-input
          placeholder="请输入内容"
          v-model="queryParms.question"
          style="width: 200px"
          clearable>
        </el-input>
        <el-button type="primary" @click="getRoom">搜索</el-button>
        <el-button type="primary">学习区</el-button>
        <el-button type="primary">游戏区</el-button>
      </div>
      <el-container>
        <el-container>
          <el-main>
            <div v-show="player" style="width: 100%">
            <span>
              <video-player
                style="width: 100%;height: 50%"
                class="video-player vjs-custom-skin"
                ref="videoPlayer"
                :playsinline="true"
                :options="playerOptions"
              ></video-player>

            </span>
              <!--      TODO：弹幕实时交流（如何实现netty向前端主动推送消息？如何进行监听）-->
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>直播弹幕交流</span>
                </div>
                <div v-for="o in 4" :key="o" class="text item">
                  {{ '列表内容 ' + o }}
                </div>
              </el-card>
            </div>


            <el-form>
              <el-form-item label="">
                <el-select v-model="playerOptions.aspectRatio" placeholder="请选择">
                  <el-option label="4:3" value="4:3"></el-option>
                  <el-option label="16:9" value="16:9"></el-option>
                  <el-option label="3:2" value="3:2"></el-option>
                </el-select>
              </el-form-item>
            </el-form>
          </el-main>

          <el-footer>这里是底部</el-footer>
        </el-container>
        <el-aside width="400px" style="height: 485px">
          <div v-for="o in 6" :key="o">
            <img src="../../assets/logo.png" style="height: 76px;width: 100%">
          </div>
        </el-aside>
      </el-container>
    </div>
  </div>
</template>
<script>

export default {
  name: 'BusImg',
  data() {
    return {
      // 视频播放
      playerOptions: {
        playbackRates: [0.7, 1.0, 1.5, 2.0], // 播放速度
        autoplay: false, // 如果true,浏览器准备好时开始回放。
        muted: false, // 默认情况下将会消除任何音频。
        loop: false, // 导致视频一结束就重新开始。
        preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        language: 'zh-CN',
        aspectRatio: '16:7', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        techOrder: ['flash', 'html5'], // 兼容顺序
        flash: {
          hls: {withCredentials: false}
          // swf: 'static/video-js.swf' // 引入静态文件swf
        },
        html5: {hls: {withCredentials: false}},
        sources: [{ // 流配置，数组形式，会根据兼容顺序自动切换
          type: 'rtmp/hls',
          src: 'rtmp://192.168.10.100/lives/livestream'
        }],
        poster: '', // 你的封面地址
        width: document.documentElement.clientWidth,
        notSupportedMessage: '此视频暂无法播放，请稍后再试', // 允许覆盖Video.js无法播放媒体源时显示的默认信息。
        controlBar: {
          timeDivider: true,
          durationDisplay: true,
          remainingTimeDisplay: false,
          fullscreenToggle: true // 全屏按钮
        }
      },
      queryParms: {
        pageNumber: undefined,
        question: undefined
      },
      player: true,
    }
  },
  methods: {
    getRoom() {
      //  模糊查询直播间(向elasticsearch中请求数据)
      this.axios({
        url: '/api/outworld_elasticsearch/elasticsearch/getElasticsearchBorast',
        method: "get",
        data: this.queryParms
      }).then(response => {
        console.log(response)
        this.player = false
      })
    }
  }
}
</script>
<style>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  width: 30%;
}
</style>
