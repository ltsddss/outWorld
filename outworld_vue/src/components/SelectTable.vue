
<template>
  <div class="main-item">
    <el-row>
      <div class="block">
        <el-carousel trigger="click"
                     height="450px"
                     :autoplay='false'
                     v-show="updateItem.isShow"
                     :loop="false">
          <el-carousel-item v-for="idx in Math.ceil(updateItem.updateCards.length/(oneLine*2))"
                            :key="idx">
            <el-row class="card-row">
              <el-col :span="24/oneLine"
                      v-for="i in oneLine"
                      :key="i"
                      class="card-col">
                <card v-if="(idx-1)*oneLine*2+i-1<updateItem.updateCards.length"
                      :card="updateItem.updateCards[(idx-1)*oneLine*2+i-1]"></card>
              </el-col>
            </el-row>
            <el-row class="card-row">
              <el-col :span="24/oneLine"
                      v-for="i in oneLine"
                      :key="i"
                      class="card-col">
                <card v-if="(idx-1)*oneLine*2+i-1+oneLine<updateItem.updateCards.length"
                      :card="updateItem.updateCards[(idx-1)*oneLine*2+i-1+oneLine]"></card>
              </el-col>
            </el-row>
          </el-carousel-item>
        </el-carousel>

      </div>
    </el-row>
  </div>
</template>
<script>
import Card from './Card.vue'
export default {
  name: 'SelectTable',
  props: ['updateItem'],
  components: {
    Card
  },
  watch:{
    'updateItem':{
      handler(newVal,oldVal){
        console.log(newVal)
        this.updateItem=newVal
      }
    }
  },
  data: function () {
    return {
      oneLine: 4,// 一行多沙card
    }
  },
  methods: {
  }
}
</script>
<style scoped>
.title {
  margin-bottom: 20px;
  float: left;
}
.title-row {
  display: flex;
  align-items: center;
}
.date {
  font-size: 16px;
  margin-right: 36px;
  cursor: pointer;
}
.date-selected {
  font-size: 16px;
  margin-right: 36px;
  color: #32aaff;
  cursor: pointer;
}
.card-row {
  height: 50%;
}
.card-col {
  display: flex;
  justify-content: end;
}
</style>
