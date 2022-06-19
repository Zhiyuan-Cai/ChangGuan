<template>
    <div class="add-person">
        <div class="title">
            <el-breadcrumb separator="/">
                <!-- <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item> -->
                <el-breadcrumb-item :to="{ path: '/person' }">人员管理</el-breadcrumb-item>
                <!-- <el-breadcrumb-item><a href="/"></a></el-breadcrumb-item> -->
                <el-breadcrumb-item>添加管理员</el-breadcrumb-item>
                <!-- <el-breadcrumb-item>活动详情</el-breadcrumb-item> -->
            </el-breadcrumb>
        </div>
        <div class="myform">
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


                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data() {
      return {
        personForm: {
          name: '',
          jobNum: '',
          sex: '',
          telephone: '',
          department: '',
          post: ''
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
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
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
.add-person {
    margin: 20px;
}

.title {
    padding: 10px;
    background: #fff;
    border: 1px solid #eee;
    margin-bottom: 20px;
}

.myform {
    background: #fff;
    padding: 10px;
    padding-right: 30px;
}

.line {
    text-align: center;
}
</style>