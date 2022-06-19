<template>
    <div>
        <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="closeForm" width="70%">
            <div>
                <el-form :model="controlForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="所属网格" prop="grid">
                        <el-select v-model="controlForm.grid" placeholder="请选择所属网格">
                            <el-option v-for="item in gridOptions" :key="item.gridNum + '#' + item.name"
                                :label="item.name" :value="item.gridNum + '#' + item.name">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="控制室编号" prop="controlNum">
                        <el-input v-model="controlForm.controlNum"></el-input>
                    </el-form-item>
                    <el-form-item label="控制室名称" prop="controlName">
                        <el-input v-model="controlForm.controlName"></el-input>
                    </el-form-item>
                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="controlForm.remark"></el-input>
                    </el-form-item>


                    <!-- <el-form-item>
                        <el-button type="primary" @click="submitForm()">确定</el-button>
                        <el-button @click="resetForm()">重置</el-button>
                    </el-form-item> -->
                </el-form>
            </div>

            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
                <el-button @click="closeForm">取 消</el-button>
                <!-- <el-button type="primary" @click="dialogVisible = false">确 定</el-button> -->
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
    // props: ["dialogVisible"],
    props: {
        title: {
            type: String,
            default: ''
        },
        rowData: {
            type: Object,
            default: function () {
                return {}
            }
        },
        gridOptions: {
            type: Array,
            default: function () {
                return []
            }
        },
    },
    // mounted() {
    //     this.personForm = this.rowData;
    // },
    data() {
        return {
            dialogVisible: false,
            // gridOptions: [],
            controlForm: {
                id: 0,
                controlName: '',
                controlNum: '',
                grid: '',
                remark: '',
                description: '',
            },

            rules: {
                grid: [
                    { required: true, message: '请选择所属网格', trigger: 'change' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                controlName: [
                    { required: true, message: '请输入控制室名称', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                controlNum: [
                    { required: true, message: '请输入控制室编号', trigger: 'blur' }
                ],
                remrak: [
                    { required: false, message: '请输入备注', trigger: 'blur' }
                ],
            },
        }
    },
    watch: {
        rowData(val) {
            console.log("rowData", val);

            this.controlForm = val;
            // this.controlForm.grid = val.gridNum + '#' + val.gridName;
            this.$set(this.controlForm, "grid", val.gridNum + '#' + val.gridName)

            this.$nextTick(() => {
                // this.$refs.myEditor.editor.txt.html(val.descs);
            })
        }
    },
    methods: {
        // close() {
        //     this.$emit("changeDialog")
        // },
        submitForm() {
            this.$refs.ruleForm.validate((valid) => {
                if (valid) {
                    // alert('submit!');
                    let { id, controlName, controlNum, grid, remark, description } = this.controlForm;
                    let temp = grid.split('#');
                    let gridNum = temp[0];
                    let gridName = temp[1];
                    if (this.title == "添加控制室") {
                        this.$api.addControl({
                            controlName, controlNum, gridNum, gridName, remark, description
                        })
                            .then(res => {
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '添加控制室成功',
                                        type: 'success'
                                    });
                                    this.closeForm();
                                } else {
                                    this.$message.error('错了哦，这是一条错误消息');
                                }
                            })
                    } else {
                        this.$api.updateControl({
                            id, controlName, controlNum, gridNum, gridName, remark, description
                        })
                            .then(res => {
                                console.log('编辑控制室', res.data);
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '编辑控制室成功',
                                        type: 'success'
                                    });
                                    this.closeForm();
                                } else {
                                    this.$message.error('错了哦，这是一条错误消息');
                                }
                            })
                    }

                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm() {
            // this.$refs.ruleForm.resetFields();
            // this.$refs.ruleForm.resetFields();
            // this.$refs.myEditor.editor.txt.clear();
        },
        closeForm() {
            // this.$refs.ruleForm.resetFields();
            this.dialogVisible = false;
            this.controlForm = {
                id: 0,
                controlName: '',
                controlNum: '',
                grid: '',
                remark: '',
                description: '',
            }
            // this.$refs.myEditor.editor.txt.clear();
            // this.$refs.ruleForm.resetFields();

        }
    },
    created() {
        // this.$api.getGridOptions()
        //     .then((res) => {
        //         this.gridOptions = res.data.data;
        //     })
        // console.log(res.data.data);

        // this.$api.getGridOptions({

        // }).then(response => {
        //     console.log(response.data);
        //     this.gridOptions = res.data.data;

        // })
    }
}
</script>

<style lang='less' scoped>
.line {
    text-align: center;
}
</style>