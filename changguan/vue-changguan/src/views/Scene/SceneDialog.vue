<template>
    <div>
        <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="closeForm" width="70%">
            <div>
                <el-form :model="sceneForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="所属控制室" prop="control">
                        <el-select v-model="sceneForm.control" placeholder="请选择所属控制室">
                            <el-option v-for="item in controlOptions" :key="item.controlNum"
                                :label="item.controlName + '(' + item.gridName + ')'"
                                :value="item.controlNum + '#' + item.controlName + '#' + item.gridNum + '#' + item.gridName">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="场景编号" prop="sceneNum">
                        <el-input v-model="sceneForm.sceneNum"></el-input>
                    </el-form-item>
                    <el-form-item label="场景名称" prop="sceneName">
                        <el-input v-model="sceneForm.sceneName"></el-input>
                    </el-form-item>
                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="sceneForm.remark"></el-input>
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
        controlOptions: {
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
            sceneForm: {
                id: 0,
                sceneName: '',
                sceneNum: '',
                control: '',
                remark: '',
                description: '',
            },

            rules: {
                control: [
                    { required: true, message: '请选择所属控制室', trigger: 'change' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                sceneName: [
                    { required: true, message: '请输入场景名称', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                sceneNum: [
                    { required: true, message: '请输入场景编号', trigger: 'blur' }
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

            this.sceneForm = val;
            // this.controlForm.grid = val.gridNum + '#' + val.gridName;
            this.$set(this.sceneForm, "control", val.controlNum + '#' + val.controlName + '#' + val.gridNum + '#' + val.gridName);

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
                    let { id, sceneName, sceneNum, control, remark, description } = this.sceneForm;
                    let temp = control.split('#');
                    let controlNum = temp[0];
                    let controlName = temp[1];
                    let gridNum = temp[2];
                    let gridName = temp[3];
                    if (this.title == "添加场景") {
                        this.$api.addScene({
                            sceneNum, sceneName,
                            controlName, controlNum, gridNum, gridName, remark, description
                        })
                            .then(res => {
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '添加场景成功',
                                        type: 'success'
                                    });
                                    this.closeForm();
                                } else {
                                    this.$message.error('错了哦，这是一条错误消息');
                                }
                            })
                    } else {
                        this.$api.updateScene({
                            id, sceneNum, sceneName, controlName, controlNum, gridNum, gridName, remark, description
                        })
                            .then(res => {
                                console.log('编辑场景', res.data);
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '编辑场景成功',
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
            this.sceneForm = {
                id: 0,
                sceneName: '',
                sceneNum: '',
                control: '',
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