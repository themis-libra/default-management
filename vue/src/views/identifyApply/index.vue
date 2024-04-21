<template>
    <el-card class="card">
        <!-- 对潜在的违约客户进行人工认定申请，页面内容：客户名称、最新外部等级（无、高、中、低）、违约原因、违约严重性（高、中、低）、备注信息。 -->
        <header slot="header" style="margin: 10px 0;">
            <span style="font-size: 18px;">违约认定申请</span>
        </header>
        <el-form label-width="120px" :model="form" ref="form" :rules="rules" style="padding: 10px 10px 20px 10px">
            <el-form-item label="申请客户名称" prop="Dcname">
                <el-input v-model="form.Dcname" placeholder="请输入申请客户名称"></el-input>
            </el-form-item>

            <el-form-item label="违约客户名称" prop="Dname">
                <el-input v-model="form.Dname" placeholder="请输入违约客户名称"></el-input>
            </el-form-item>

            <el-form-item label="最新外部等级" prop="Dlevel">
                 <el-select class="selector" v-model="form.Dlevel" placeholder="请输入最新外部等级" >
                    <el-option v-for="item in levelList" :key="item.id" :label="item.content" :value="item.content">{{item.content}}</el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="违约原因" prop="Dano">
                <el-select class="selector" v-model="form.Dano" placeholder="请选择违约原因">
                    <el-option v-for="reason in reasonList" :key="reason.dno" :label="reason.dcontent"
                        :value="reason.dcontent">{{reason.dcontent}}</el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="违约严重性" prop="Rgoavity">
                <el-select class="selector" v-model="form.Rgoavity" placeholder="请选择违约严重性">
                    <el-option v-for="item in rogavityList" :key="item.id" :label="item.content" :value="item.content">{{item.content}}</el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="备注信息" prop="Danote">
                <el-input v-model="form.Danote" placeholder="请输入备注信息"></el-input>
            </el-form-item>

            <el-button type="primary" @click="handleSubmit" class="btn-submit">
                提交
            </el-button>
        </el-form>
    </el-card>
</template>

<script>
import { ApiGet, ApiPost } from '@/utils/request'

export default {
    data() {
        return {
            form: {
                Dcname: '',
                Dname: '',
                Dano: '',
                Dlevel: '',
                Rgoavity: '',
                Danote: '',
                Datime: ''
            },
            reasonList: '',
            levelList:[
                {id:'0',content:'无'},
                {id:'1',content:'低'},
                {id:'2',content:'中'},
                {id:'3',content:'高'},
            ],
            rogavityList:[
                {id:'0',content:'低'},
                {id:'1',content:'中'},
                {id:'2',content:'高'},
            ],
            rules: {
                Dcname: [
                    {
                        required: true,
                        message: "请输入申请客户名称",
                        trigger: "blur"
                    },
                    {
                        min: 1,
                        max: 10,
                        message: "申请客户名称长度在1~10位",
                        trigger: "blur"
                    }
                ],
                Dname: [
                    {
                        required: true,
                        message: "请输入违约客户名称",
                        trigger: "blur"
                    },
                    {
                        min: 1,
                        max: 10,
                        message: "违约客户名称长度在1~10位",
                        trigger: "blur"
                    }
                ],
                Danote: [
                    {
                        message: "备注",
                        trigger: "blur"
                    },
                    {
                        min: 1,
                        max: 100,
                        message: "备注字符长度在1~100位",
                        trigger: "blur"
                    }
                ],
            },
            identity:true
        }
    },
    methods: {
        testName: function () {
            const regex = /^[\u4e00-\u9fa5a-zA-Z]+$/ ; // 中文或英文的正则表达式
            if(!regex.test(this.Dcname) || !regex.test(this.Dname)){
                this.identity = false
            }
        },
        async handleSubmit() {
            if(!this.identity){
                alert('申请客户名称或违约客户名称格式不正确，格式应为中文或英文')
                return;
            }
            if(this.form.Dlevel == '' || this.form.Dlevel == null){
                alert('请选择最新外部等级')
                return 
            }
            if(this.form.Dano == '' || this.form.Dano == null){
                alert('请选择违约原因')
                return 
            }
            if(this.form.Rgoavity == '' || this.form.Rgoavity == null){
                alert('请选择违约严重性')
                return 
            }
            const resp = await ApiPost('/Apply/save', this.form)
            if (resp.data.code == '0') {
                this.$message.success('提交成功')
            } else {
                this.$message.error('提交失败')
            }
        },
    },

    async created() {
        const resp = await ApiGet('/Reason/search')
        if (resp.data.code != 0) {
            this.$alert("查询失败", "提示", {
                confirmButtonText: "确定"
            })
        } else {
            this.reasonList = resp.data.data;
        }
    },
}
</script>

<style scoped>
header {
    display: flex;
}

.card {
    width: 600px;
}

.btn-submit {
    width: 200px;
}

.selector {
    width: 100%;
}

.el-card.card.is-always-shadow {
    margin: auto;
}

span {
    margin: auto;
}

.card[data-v-704ed79b] {
    width: 1400px;
}

form.el-form {
    width: 80%;
    margin: auto;
}

.el-form-item {
    margin-bottom: 30px;
    margin-top: 10px;
}
</style>
