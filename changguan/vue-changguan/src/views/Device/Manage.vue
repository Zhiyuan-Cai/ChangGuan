<template>
    <div class="grid">
        <div class="header">
            <el-input v-model="deviceNum" style="width:250px;margin:10px" placeholder="请输入设备编号"></el-input>
            <el-input v-model="deviceName" style="width:250px;margin:10px" placeholder="请输入设备名称"></el-input>
            <el-input v-model="deviceIP" style="width:250px;margin:10px" placeholder="请输入设备IP"></el-input>
            <!-- <el-input v-model="category" style="width:250px;margin:10px" placeholder="请输入设备类别"></el-input> -->
            <el-select v-model="category" style="width:250px;margin:10px" placeholder="请选择设备类别">
                <el-option v-for="item in categoryOptions" :key="item.name" :label="item.name" :value="item.name">
                </el-option>
            </el-select>
            <el-button type="primary" style="margin:10px" @click="searchDevice">查询</el-button>
            <!-- <el-button type="primary" style="margin:10px">
      <router-link to="/add-person" style="color:#fff">添加</router-link>
      </el-button> -->
            <el-button type="primary" style="margin:10px" @click="addDevice">添加
                <!-- <router-link to="/add-person" style="color:#fff">添加</router-link> -->
            </el-button>

        </div>
        <div class="wrapper">
            <el-table :data="tableData" border style="width: 100%">
                <!-- <el-table-column type="selection" width="55"> </el-table-column> -->
                <el-table-column type="index" :index="index" label="序号" width="80"></el-table-column>
                <el-table-column prop="id" label="序号" width="180" v-if="false"></el-table-column>
                <el-table-column prop="deviceNum" label="设备编号" width="180"></el-table-column>
                <el-table-column prop="deviceName" label="设备名称" width="180"></el-table-column>
                <el-table-column prop="deviceIP" label="设备IP" width="180"></el-table-column>
                <el-table-column prop="category" label="设备类别" width="180"></el-table-column>
                <el-table-column prop="sceneName" label="所属场景" width="180"></el-table-column>
                <el-table-column prop="controlName" label="所属控制室" width="180"></el-table-column>
                <el-table-column prop="gridName" label="所属网格" width="180"></el-table-column>
                <el-table-column prop="remark" label="备注" width="180" show-overflow-tooltip></el-table-column>
                <el-table-column label="操作" width="150">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除
                        </el-button>
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
        <ManageDialog ref="dialog" :title="title" :rowData="rowData" :sceneOptions="sceneOptions"
            :categoryOptions="categoryOptions" />
    </div>
</template>

<script>

import MyPagination from '../../components/MyPagination.vue';
import ManageDialog from './ManageDialog.vue';
export default {
    components: {
        MyPagination,
        ManageDialog,
    },
    data() {
        return {
            input: '',
            tableData: [],
            total: 100,
            pageSize: 1,
            type: 1,
            deviceNum: '',
            deviceName: '',
            deviceIP: '',
            category: '',
            sceneNum: '',
            sceneName: '',
            controlName: '',
            controlNum: '',
            gridNum: '',
            gridName: '',
            currentPage: 1,
            page: 1,
            dialogVisible: false,
            title: '',
            rowData: {},
            sceneOptions: [],
            categoryOptions: [],
            category: '',
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
            this.title = "编辑设备";
            this.rowData = { ...row };
        },
        handleDelete(index, row) {
            this.$confirm('此操作将永久删除该设备, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$api.deleteDevice({
                    deviceName: row.deviceName,
                    deviceNum: row.deviceNum,
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
                .getDeviceList({
                    page: page
                })
                .then((res) => {

                    if (res.data.code == 200) {
                        console.log("device", res.data.data);
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
        searchDevice() {

            this.currentPage = 1;
            this.httpSearch(1);

        },
        httpSearch(page) {
            this.$api.getSearchDevice({
                deviceName: this.deviceName,
                deviceNum: this.deviceNum,
                deviceIP: this.deviceIP,
                category: this.category,
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
        addDevice() {
            // this.dialogVisible = true;
            this.$refs.dialog.dialogVisible = true;
            this.title = "添加设备";

            // changeDialog() {
            //   this.dialogVisible = false;
            // },
        },

    },

    created() {
        this.http(1);
        this.$api.getSceneOptions({

        }).then(res => {
            this.sceneOptions = res.data.data;
            // console.log(this.gridOptions);
        });
        this.$api.getCategoryOptions({

        }).then(res => {
            this.categoryOptions = res.data.data;
            // console.log(this.gridOptions);
        });

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