<template>
  <div>
    <el-menu :default-active="this.$route.path" class="el-menu-vertical-demo" text-color="#fff"
      background-color="#112f50" active-text-color="#409EFF" router :collapse="isCollapse">
      <el-menu-item>
        <span slot="title">场馆后台管理系统</span>
      </el-menu-item>
      <!-- <el-menu-item index="/">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item> -->
      <el-menu-item index="/person" v-if='userinfo.role == 0'>
        <i class="el-icon-document"></i>
        <span slot="title">人员管理</span>
      </el-menu-item>
      <el-menu-item index="/grid">
        <i class="el-icon-setting"></i>
        <span slot="title">网格管理</span>
      </el-menu-item>
      <el-menu-item index="/control">
        <i class="el-icon-setting"></i>
        <span slot="title">控制室管理</span>
      </el-menu-item>
      <el-menu-item index="/scene">
        <i class="el-icon-setting"></i>
        <span slot="title">场景管理</span>
      </el-menu-item>
      <!-- <el-menu-item index="/device">
        <i class="el-icon-setting"></i>
        <span slot="title">设备管理</span>
      </el-menu-item> -->
      <el-submenu index="/device">
        <template slot="title">
          <i class="el-icon-setting"></i>

          <!-- <i class="el-icon-location"></i> -->
          <span>设备</span>
        </template>
        <el-menu-item index="/device/category">
          <i class="el-icon-setting"></i>
          <span slot="title">设备类别</span>
        </el-menu-item>
        <el-menu-item index="/device/device-manage">
          <i class="el-icon-setting"></i>
          <span slot="title">设备管理</span>
        </el-menu-item>

      </el-submenu>
      <!-- <el-menu-item-group>
        <i class="el-icon-setting"></i>
        <template slot="title">设备</template>
        <el-menu-item index="device/category">设备类别</el-menu-item>
        <el-menu-item index="device/device-manage">设备管理</el-menu-item>
      </el-menu-item-group> -->
      <el-menu-item index="/content">
        <i class="el-icon-setting"></i>
        <span slot="title">内容管理</span>
      </el-menu-item>

      <!-- <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>导航一</span>
        </template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项1</el-menu-item>
        </el-submenu>
      </el-submenu> -->
    </el-menu>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  props: ["isCollapse"],
  computed: {
    ...mapState('loginModule', ['userinfo'])
  },
  data() {
    return {
      // isCollapse:false
    }
  }
}
</script>

<style lang='less' scoped>
.el-menu {
  border-right: 0;

  .is-active {
    background: #1e78bf !important;
    color: #fff !important;
  }
}

// .el-menu-vertical-demo{
//   background: #112f50;
// }
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

// /deep/ .el-submenu{
//   .el-menu{
//     background: rgb(14, 35, 61);
//   }
// }
// /deep/ .el-menu-item:hover,.el-submenu:hover{
//     background: #0d2641;
// }
</style>