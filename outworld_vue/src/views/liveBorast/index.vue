<template>
  <div>
    <el-container>
      <!-- header -->
      <el-header style="height:auto">
        <nav-head :user="user"></nav-head>
      </el-header>
      <el-main style="width: 1200px;margin: auto">
        <el-row :span="4">
          <el-col :span="2">
            <Video :video-info="videoInfo"></Video>

          </el-col>
          <el-col :span="2">
            <div>
              <vue-baberrage
                :barrageList="barrageList"
                :boxHeight="boxHeight"
                :box-width="boxWidth"
                :isShow="barrageIsShow"
                :lanesCount="lanesCount"
                :loop="barrageLoop"
                :messageHeight="messageHeight"
                :throttleGap="throttleGap">
              </vue-baberrage>
            </div>
          </el-col>
        </el-row>

      </el-main>
      <!-- footer -->
      <el-footer style="height:auto">
        <footer-bar></footer-bar>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import videojs from "video.js";
import Home from "../home";
import NavHead from '../../components/NavHead.vue'
import FooterBar from '../../components/FooterBar.vue'
import Video from "../../components/Video";
import {MESSAGE_TYPE} from "vue-baberrage";

export default {
  data: function () {
    return {
      user: null,
      carousels: null,
      videoInfo:{
        img:'../../static/imgs/notStartBorast.png',
        url:'http://192.168.10.100:8080/lives/livestream.m3u8',
        borastId:null
      },
      barrageList: [],
      barrageIsShow: true,    	//是否展示弹幕
      barrageLoop: true,     	//是否循环播放
      boxHeight: 170,         	//高度
      boxWidth: 600,         	//宽度
      messageHeight: 25,		//消息高度
      lanesCount: 4,			//泳道数量
      throttleGap: 5000,		//消息间隔
    }
  },
  components: {
    Video,
    Home,
    NavHead,
    FooterBar
  },
  mounted() {
    this.addToList();
  },
  methods: {
    addToList() {
      let list = [
        {id: 1,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第一条弹幕',time: 3},
        {id: 2,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第二条弹幕',time: 4},
        {id: 3,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第三条弹幕',time: 3},
        {id: 4,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第四条弹幕',time: 4},
        {id: 5,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第五条弹幕',time: 5},
        {id: 6,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第六条弹幕',time: 6},
        {id: 7,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第七条弹幕',time: 7},
        {id: 8,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第八条弹幕',time: 8},
        {id: 9,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第九条弹幕',time: 9},
        {id: 10,avatar: 'https://api.ddkjt.com/api/img_1.php',msg: '第十条弹幕',time: 10}
      ];
      list.forEach((v) => {
        this.barrageList.push({
          id: v.id,					//弹幕ID
          avatar: v.avatar,      		//头像
          msg: v.msg,             	//弹幕消息
          time: v.time,          		//屏幕展示时间
          type: MESSAGE_TYPE.NORMAL,	//类型
        });
      });
    }
  }
}
</script>

<style scoped>
/*弹幕区域高度*/
/deep/ .baberrage-stage {
  height: 170px;
}

/*弹幕消息框*/
/deep/ .baberrage-item .normal {
  padding: 5px 10px;
}

/*头像*/
/deep/ .baberrage-item .normal .baberrage-avatar {
  width: 25px;
  height: 25px;
  background-color: black;
}

/*文字*/
/deep/ .baberrage-item .normal .baberrage-msg {
  font-size: 14px;
  line-height: 25px;
}

</style>
