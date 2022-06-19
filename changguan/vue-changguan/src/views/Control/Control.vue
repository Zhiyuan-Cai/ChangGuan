<template>
  <div class="grid">
    <div class="header">
      <el-input v-model="controlNum" style="width:500px;margin:10px" placeholder="请输入控制室编号"></el-input>
      <el-input v-model="controlName" style="width:500px;margin:10px" placeholder="请输入控制室名称"></el-input>
      <el-button type="primary" style="margin:10px" @click="searchControl">查询</el-button>
      <!-- <el-button type="primary" style="margin:10px">
      <router-link to="/add-person" style="color:#fff">添加</router-link>
      </el-button> -->
      <el-button type="primary" style="margin:10px" @click="addControl">添加
        <!-- <router-link to="/add-person" style="color:#fff">添加</router-link> -->
      </el-button>

    </div>
    <div class="wrapper">
      <el-table :data="tableData" border style="width: 100%">
        <!-- <el-table-column type="selection" width="55"> </el-table-column> -->
        <el-table-column type="index" :index="index" label="序号" width="180"></el-table-column>
        <el-table-column prop="id" label="序号" width="180" v-if="false"></el-table-column>
        <el-table-column prop="controlNum" label="控制室编号" width="180"></el-table-column>
        <el-table-column prop="controlName" label="控制室名称" width="180"></el-table-column>
        <el-table-column prop="gridName" label="所属网格" width="180"></el-table-column>
        <el-table-column prop="remark" label="备注" width="360" show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="180">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
        <!-- <el-table-column prop="name" label="权限类别" width="180">
        </el-table-column> -->
        <!-- <el-table-column prop="address" label="地址">
        </el-table-column> -->
      </el-table>
    </div>
    <MyPagination :total="total" :pageSize="pageSize" @changePage="changePage" :currentPage="currentPage">
    </MyPagination>
    <!-- <PersonDialog :dialogVisible="dialogVisible" @changeDialog="changeDialog" /> -->
    <ControlDialog ref="dialog" :title="title" :rowData="rowData" :gridOptions="gridOptions" />
  </div>
</template>

<script>

import MyPagination from '../../components/MyPagination.vue';
import ControlDialog from './ControlDialog.vue';
export default {
  components: {
    MyPagination,
    ControlDialog,
  },
  data() {
    return {
      input: '',
      tableData: [],
      total: 100,
      pageSize: 1,
      type: 1,
      controlName: '',
      controlNum: '',
      gridNum: '',
      gridName: '',
      currentPage: 1,
      page: 1,
      dialogVisible: false,
      title: '',
      rowData: {},
      gridOptions: [],
    }
  },
  methods: {
    index(index) {
      return index + 1 + (this.currentPage - 1) * this.pageSize
    },
    changePage(num) {
      this.currentPage = num;
      if (this.type == 1) {
        this.http(num);

      } else {
        this.httpSearch(num);
      }
    },
    handleEdit(index, row) {
      this.$refs.dialog.dialogVisible = true;
      this.title = "编辑控制室";
      this.rowData = { ...row };
    },
    handleDelete(index, row) {
      this.$confirm('此操作将永久删除该控制室, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$api.deleteControl({
          controlName: row.controlName,
          controlNum: row.controlNum,
        })
          .then(res => {
            console.log("delete", res.data);
            if (res.data.data == true) {
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              this.changePage(1);
            }
          })
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    http(page) {
      this.$api
        .getControlList({
          page: page
        })
        .then((res) => {

          if (res.data.code == 200) {
            console.log("control", res.data.data);
            this.tableData = res.data.data; //数据列表
            this.total = res.data.count;
            this.pageSize = 10;
            // console.log(this.tableData[2].id);
          } else {
            this.tableData = [];
            this.total = 1;
            this.pageSize = 1;

          }


        });
    },
    searchControl() {

      this.currentPage = 1;
      this.httpSearch(1);

    },
    httpSearch(page) {
      this.$api.getSearchControl({
        controlName: this.controlName,
        controlNum: this.controlNum,
        page: page
      }).then(res => {
        console.log(res.data)

        if (res.data.code == 200) {
          this.tableData = res.data.data;
          this.total = res.data.count;
          this.pageSize = 10;
          this.type = 2;
        } else {
          this.tableData = [];
          this.total = 1;
          this.pageSize = 1;
          this.type = 1;
        }
      })
    },
    addControl() {
      // this.dialogVisible = true;
      this.$refs.dialog.dialogVisible = true;
      this.title = "添加控制室";

      // changeDialog() {
      //   this.dialogVisible = false;
      // },
    },

  },

  created() {
    this.http(1);
    this.$api.getGridOptions({

    }).then(res => {
      this.gridOptions = res.data.data;
      // console.log(this.gridOptions);
    })
  },

}
</script>

<style lang="less" scoped>
.grid {
  margin: 20px;
}

.header {
  display: flex;

  button {
    margin-left: 20px;
  }
}

.wrapper {
  margin: 20px 0;
}
</style>