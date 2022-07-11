<template>
  <div>
    <div class="header">
      <i v-if='!isCollapse' @click="changeMenu" class="iconfont icon-right-indent" style="margin:20px"></i>
      <i v-else @click="changeMenu" class="iconfont icon-left-indent" style="margin:20px"></i>
      <div class=" header-right">
        <!-- <el-dropdown @command="clickLang">
          <span class="el-dropdown-link" style="color: #fff">
            多语言<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="zh">中文</el-dropdown-item>
            <el-dropdown-item command="en">English</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown> -->
        <div class="user">
          <span>
            欢迎：{{ userinfo.name }}
          </span>
          <i class="iconfont icon-tuichu" style="cursor:pointer" @click="loginout"></i>
          <span @click="loginout" style="cursor:pointer">退出登录</span>
        </div>
      </div>
    </div>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>

</template>

<script>
import { mapState } from 'vuex';
import { mapMutations } from 'vuex';

export default {
  props: ['isCollapse'],
  computed: {
    ...mapState('loginModule', ['userinfo'])
  },
  methods: {
    ...mapMutations('loginModule', ['clearUser']),
    changeMenu() {
      this.$emit('changeCollapse')
    },
    loginout() {
      this.clearUser();
      localStorage.removeItem('user');
      this.$router.push('/login');
    },
  }
}
</script>

<style lang='less' scoped>
.header {
  height: 50px;
  line-height: 50px;
  color: #fff;
  background: #1e78bf;

  .iconfont {
    font-size: 24px;
    // margin: 20px;
  }
}

.header-right {
  float: right;
  padding-right: 20px;
  display: flex;

  .user {
    margin-left: 20px;
    font-size: 15px;

    span {
      position: relative;
      top: -3px;
      margin-right: 10px;
    }
  }
}
</style>