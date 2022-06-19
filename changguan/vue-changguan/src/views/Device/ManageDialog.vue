<template>
    <div>
        <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="closeForm" width="70%">
            <div>
                <el-form :model="deviceForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="所属场景" prop="scene">
                        <el-select v-model="deviceForm.scene" placeholder="请选择所属场景">
                            <el-option v-for="item in sceneOptions" :key="item.sceneNum"
                                :label="item.sceneName + '(' + item.controlName + ',' + item.gridName + ')'"
                                :value="item.sceneNum + '#' + item.sceneName + '#' + item.controlNum + '#' + item.controlName + '#' + item.gridNum + '#' + item.gridName">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="设备编号" prop="deviceNum">
                        <el-input v-model="deviceForm.deviceNum"></el-input>
                    </el-form-item>
                    <el-form-item label="设备名称" prop="deviceName">
                        <el-input v-model="deviceForm.deviceName"></el-input>
                    </el-form-item>
                    <el-form-item label="设备IP" prop="deviceIP">
                        <el-input v-model="deviceForm.deviceIP"></el-input>
                    </el-form-item>
                    <el-form-item label="设备类别" prop="category">
                        <el-select v-model="deviceForm.category" placeholder="请选择设备类别">
                            <el-option v-for="item in categoryOptions" :key="item.name" :label="item.name"
                                :value="item.name">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="deviceForm.remark"></el-input>
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
        sceneOptions: {
            type: Array,
            default: function () {
                return []
            }
        },
        categoryOptions: {
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
            deviceForm: {
                id: 0,
                deviceName: '',
                deviceNum: '',
                deviceIP: '',
                category: '',
                scene: '',
                remark: '',
                description: '',
            },

            rules: {
                scene: [
                    { required: true, message: '请选择所属场景', trigger: 'change' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                deviceName: [
                    { required: true, message: '请输入设备名称', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                deviceNum: [
                    { required: true, message: '请输入设备编号', trigger: 'blur' }
                ],
                deviceIP: [
                    { required: true, message: '请输入设备IP', trigger: 'blur' }
                ],
                category: [
                    { required: true, message: '请选择设备类别', trigger: 'change' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
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

            this.deviceForm = val;
            // this.controlForm.grid = val.gridNum + '#' + val.gridName;
            this.$set(this.deviceForm, "scene", val.sceneNum + '#' + val.sceneName + '#' + val.controlNum + '#' + val.controlName + '#' + val.gridNum + '#' + val.gridName);

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
                    let { id, deviceName, deviceNum, scene, deviceIP, category, remark, description } = this.deviceForm;
                    let temp = scene.split('#');
                    console.log(temp);
                    let sceneNum = temp[0];
                    let sceneName = temp[1];
                    let controlNum = temp[2];
                    let controlName = temp[3];
                    let gridNum = temp[4];
                    let gridName = temp[5];
                    if (this.title == "添加设备") {
                        this.$api.addDevice({
                            deviceName, deviceNum, deviceIP, category,
                            sceneNum, sceneName,
                            controlName, controlNum, gridNum, gridName, remark, description
                        })
                            .then(res => {
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '添加设备成功',
                                        type: 'success'
                                    });
                                    this.closeForm();
                                } else {
                                    this.$message.error('错了哦，这是一条错误消息');
                                }
                            })
                    } else {
                        this.$api.updateDevice({
                            id, deviceName, deviceNum, deviceIP, category, sceneNum, sceneName, controlName, controlNum, gridNum, gridName, remark, description
                        })
                            .then(res => {
                                console.log('编辑设备', res.data);
                                if (res.data.data == true) {
                                    this.$parent.http(1);
                                    this.$message({
                                        message: '编辑设备成功',
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
            this.deviceForm = {
                id: 0,
                deviceName: '',
                deviceNum: '',
                deviceIP: '',
                category: '',
                scene: '',
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