<template>
    <div>
        <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="closeForm" width="70%">
            <div>
                <el-form :model="personForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="姓名" prop="name">
                        <el-input v-model="personForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="工号" prop="jobNum">
                        <el-input v-model="personForm.jobNum"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="sex">
                        <el-select v-model="personForm.sex" placeholder="请选择性别">
                            <el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="手机号" prop="telephone">
                        <el-input v-model="personForm.telephone"></el-input>
                    </el-form-item>
                    <el-form-item label="部门" prop="department">
                        <el-input v-model="personForm.department"></el-input>
                    </el-form-item>
                    <el-form-item label="职务" prop="post">
                        <el-input v-model="personForm.post"></el-input>
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
            personForm: {
                id: 0,
                name: '',
                jobNum: '',
                sex: '',
                telephone: '',
                department: '',
                post: '',

            },
            rules: {
                name: [
                    { required: true, message: '请输入姓名', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                sex: [
                    { required: true, message: '请选择性别', trigger: 'change' }
                ],
                jobNum: [
                    { required: true, message: '请输入工号', trigger: 'blur' }
                ],
                telephone: [
                    { required: true, message: '请输入手机号', trigger: 'blur' }
                ],
                department: [
                    { required: true, message: '请输入部门', trigger: 'blur' }
                ],
                post: [
                    { required: true, message: '请输入职务', trigger: 'blur' }
                ],
            },
        }
    },
    watch: {
        rowData(val) {

            this.personForm = val;

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
                    let { id, name, jobNum, sex, telephone, department, post } = this.personForm;
                    if (this.title == "添加管理员") {
                        this.$api.addPerson({
                            name, jobNum, sex, telephone, department, post
                        })
                            .then(res => {
                                console.log('添加管理員', res.data);
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '添加管理员成功',
                                        type: 'success'
                                    });
                                    this.closeForm();
                                } else {
                                    this.$message.error('错了哦，这是一条错误消息');
                                }
                            })
                    } else {
                        console.log(this.personForm);
                        this.$api.updatePerson({
                            id, name, jobNum, sex, telephone, department, post
                        })
                            .then(res => {
                                console.log('编辑管理員', res.data);
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '编辑管理员成功',
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
            this.personForm = {
                id: 0,
                name: '',
                jobNum: '',
                sex: '',
                telephone: '',
                department: '',
                post: '',
            }
            // this.$refs.myEditor.editor.txt.clear();
            // this.$refs.ruleForm.resetFields();

        }
    }
}
</script>

<style>
</style>