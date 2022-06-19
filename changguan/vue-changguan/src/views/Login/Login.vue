<template>
    <div class="wrapper">
        <div class="login-box">
            <!-- <div class="logo">
                <img src="../../assets/logo.png" height="120px" alt="">
            </div> -->
            <div>{{ info }}</div>
            <h3 class="title">登录界面</h3>
            <el-form :model="loginForm" status-icon :rules="rules" ref="ruleForm" label-width="60px"
                class="demo-ruleForm">
                <el-form-item label="工号" prop="username">
                    <el-input type="text" v-model="loginForm.username" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
// import { use } from 'vue/types/umd';

// import { json } from 'body-parser';
import jwt from 'jwt-decode'
import { mapMutations } from 'vuex';

export default {
    data() {
        var validateUser = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入工号'));
            } else {
                callback();
            }
        };
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                callback();
            }
        };
        return {
            info: '',
            loginForm: {
                username: '',
                password: '',
            },
            rules: {
                username: [
                    { validator: validateUser, trigger: 'blur' }
                ],
                password: [
                    { validator: validatePass, trigger: 'blur' }
                ],
            }
        };
    },
    methods: {
        ...mapMutations('loginModule', ['setUser']),
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    // alert('submit!');
                    console.log('校验通过', this.loginForm);
                    let { username, password } = this.loginForm;
                    this.$api.getLogin({
                        username,
                        password
                    })
                        .then(res => {
                            console.log(res.data);
                            if (res.data.data != "") {
                                this.info = '';
                                console.log(jwt(res.data.data));
                                let obj = {
                                    jobNum: jwt(res.data.data).jobNum,
                                    name: jwt(res.data.data).name,
                                    role: jwt(res.data.data).role,
                                    token: res.data.data
                                }
                                this.setUser(obj);
                                localStorage.setItem('user', JSON.stringify(obj));
                                this.$router.push('/');
                            } else {
                                // this.info = "账号或密码错误";
                                this.$message.error("账号或密码错误");
                            }
                        })
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>

<style lang='less' scoped>
.wrapper {
    position: fixed;
    left: 0;
    top: 0;
    bottom: 0;
    right: 0;
    background: #104468;
}

.login-box {
    width: 400px;
    height: 260px;
    padding: 20px;
    margin: 0 auto;
    margin-top: 180px;
    border-radius: 10px;

    border: 1px solid #eee;
    background: #fff;
    position: relative;
}

.logo {
    position: absolute;
    width: 120px;
    height: 120px;
    background: #f7f7f7;
    border-radius: 50%;
    overflow: hidden;
    top: -80px;
    left: 50%;
    margin-left: -60px;
    padding: 8px;

    img {
        border-radius: 50%;
        background: #fff;
    }
}

.demo-ruleForm {
    margin-top: 10px;
}

.title {
    margin-bottom: 30px;
    text-align: center;
    color: #666;
}
</style>