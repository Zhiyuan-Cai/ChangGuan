<template>
  <div class="grid">
    <div class="header">
      <el-input v-model="gridNum" style="width:500px;margin:10px" placeholder="请输入网格编号"></el-input>
      <el-input v-model="name" style="width:500px;margin:10px" placeholder="请输入网格名称"></el-input>
      <el-button type="primary" style="margin:10px" @click="searchGrid">查询</el-button>
      <!-- <el-button type="primary" style="margin:10px">
      <router-link to="/add-person" style="color:#fff">添加</router-link>
      </el-button> -->
      <el-button type="primary" style="margin:10px" @click="addGrid">添加
        <!-- <router-link to="/add-person" style="color:#fff">添加</router-link> -->
      </el-button>

    </div>
    <div class="wrapper">
      <el-table :data="tableData" border style="width: 100%">
        <!-- <el-table-column type="selection" width="55"> </el-table-column> -->
        <el-table-column type="index" :index="index" label="序号" width="180"></el-table-column>
        <el-table-column prop="id" label="序号" width="180" v-if="false"></el-table-column>
        <el-table-column prop="gridNum" label="网格编号" width="180"></el-table-column>
        <el-table-column prop="name" label="网格名称" width="180"></el-table-column>
        <el-table-column prop="remark" label="备注" width="560" show-overflow-tooltip></el-table-column>
        <el-table-column label="操作">
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
    <GridDialog ref="dialog" :title="title" :rowData="rowData" />
  </div>
</template>

<script>

import MyPagination from '../../components/MyPagination.vue';
import GridDialog from './GridDialog.vue';
export default {
  components: {
    MyPagination,
    GridDialog,
  },
  data() {
    return {
      input: '',
      tableData: [],
      total: 100,
      pageSize: 1,
      type: 1,
      name: '',
      gridNum: '',
      currentPage: 1,
      page: 1,
      dialogVisible: false,
      title: '',
      rowData: {},
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
      this.title = "编辑网格";
      this.rowData = { ...row };
    },
    handleDelete(index, row) {
      this.$confirm('此操作将永久删除该网格, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$api.deleteGrid({
          name: row.name,
          gridNum: row.gridNum,
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
        .getGridList({
          page: page
        })
        .then((res) => {

          if (res.data.code == 200) {
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
    searchGrid() {

      this.currentPage = 1;
      this.httpSearch(1);

    },
    httpSearch(page) {
      this.$api.getSearchGrid({
        name: this.name,
        gridNum: this.gridNum,
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
    addGrid() {
      // this.dialogVisible = true;
      this.$refs.dialog.dialogVisible = true;
      this.title = "添加网格";

      // changeDialog() {
      //   this.dialogVisible = false;
      // },
    },

  },

  created() {
    this.http(1);
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