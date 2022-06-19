<template>
    <div>
        <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="closeForm" width="70%">
            <div>
                <el-form :model="gridForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="网格编号" prop="gridNum">
                        <el-input v-model="gridForm.gridNum"></el-input>
                    </el-form-item>
                    <el-form-item label="网格名称" prop="name">
                        <el-input v-model="gridForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="gridForm.remark"></el-input>
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
        }
    },
    // mounted() {
    //     this.personForm = this.rowData;
    // },
    data() {
        return {
            dialogVisible: false,
            gridForm: {
                id: 0,
                name: '',
                gridNum: '',
                remark: '',
                description: '',
            },
            rules: {
                name: [
                    { required: true, message: '请输入网格名称', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                gridNum: [
                    { required: true, message: '请输入网格编号', trigger: 'blur' }
                ],
                remrak: [
                    { required: false, message: '请输入备注', trigger: 'blur' }
                ],
            },
        }
    },
    watch: {
        rowData(val) {

            this.gridForm = val;

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
                    let { id, name, gridNum, remark, description } = this.gridForm;
                    if (this.title == "添加网格") {
                        this.$api.addGrid({
                            name, gridNum, remark, description
                        })
                            .then(res => {
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '添加网格成功',
                                        type: 'success'
                                    });
                                    this.closeForm();
                                } else {
                                    this.$message.error('错了哦，这是一条错误消息');
                                }
                            })
                    } else {
                        console.log(this.gridForm);
                        this.$api.updateGrid({
                            id, name, gridNum, remark, description
                        })
                            .then(res => {
                                console.log('编辑网格', res.data);
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '编辑网格成功',
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
            this.gridForm = {
                id: 0,
                name: '',
                gridNum: '',
                remark: '',
                description: '',
            }
            // this.$refs.myEditor.editor.txt.clear();
            // this.$refs.ruleForm.resetFields();

        }
    }
}
</script>

<style>
</style>