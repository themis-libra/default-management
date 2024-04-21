<template>
    <div class="flex justify-center items-center bg-blue-200 w-screen h-screen">
        <el-card class="w-[400px] mt-[50px] h-[300px] ">
            <div slot="header">
                <span class="title1">违约客户管理系统登录</span>
            </div>
            <div>
                <el-form label-width="80px" :model="form" :rules="rules" ref="form">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
                    </el-form-item>
                    <el-button class="w-[200px]" type="primary" @click="handleLogin">登录</el-button>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
import { ApiGet, ApiPost } from '@/utils/request'

export default {
    name: 'Login',
    data() {
        return {
            form: {
                username: 'admin',
                password: '123',
            },
            rules: {
                username: [
                    {
                        required: true,
                        message: "请输入用户名",
                        trigger: "blur"
                    },
                    {
                        min: 1,
                        max: 10,
                        message: "账号长度在1~10位",
                        trigger: "blur"
                    }
                ],
                password: [
                    {
                        required: true,
                        message: "请输入密码",
                        trigger: "blur"
                    },
                    {
                        min: 1,
                        max: 6,
                        message: "密码长度在1~6位",
                        trigger: "blur"
                    }
                ]
            }

        }
    },

    methods: {
        testUsername: function () {
            const regex = /^[\u4e00-\u9fa5a-zA-Z]+$/ ; // 中文或英文的正则表达式
            return regex.test(this.username);

        },
        testPassWord: function () {
            const regex = /^[a-zA-Z0-9]+$/ ; // 数字或英文的正则表达式
            return regex.test(this.password);

        },
        async handleLogin(target, approve) {
            if(!this.testUsername){
                alert('用户名必须为中文或英文')
                return;
            }

            if(!this.testPassWord){
                alert('密码必须为数字或英文')
                return;
            }     

            const resp = await ApiGet('http://localhost:8081/Customer/login', {
                username: this.form.username,
                password: this.form.password
            })
            if (resp.data.code == -1) {
                this.$alert("用户名不存在", "提示", {
                    confirmButtonText: "确定"
                })
            }
            if (resp.data.code == -2) {
                this.$alert("密码错误", "提示", {
                    confirmButtonText: "确定"
                })
            }
            if (resp.data.code == 0) {
                localStorage.setItem("role", JSON.stringify(resp.data.data))
                this.$router.replace({ path: "/main" })

            }
        },

    },
}
</script>

<style>
.el-card__body {
    padding: 30px 20px 20px 0px;
}

.el-button {
    margin-left: 20px;
}

.el-card__header {
    padding: 28px 20px;
}

.title1 {
    font-size: 20px;
}

.h-\[300px\] {
    height: 310px;
}

.el-button--primary {
    background-color: #66b1ff;
}

.el-button--primary:hover {
    background-color: rgb(145, 190, 245);
}
</style>
