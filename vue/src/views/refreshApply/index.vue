<template>
    <el-card class="card">
        <!--对于之前认定为违约的客户，现在由于一些原因，可以进行重生。
            查询列表展示字段：违约客户、审核状态、认定违约原因、严重程度、认定人 、认定申请时间、认定审核时间、最新外部等级信息。
            违约重生界面展示：违约客户、 认定违约原因、严重程度、认定人 、认定申请时间、最新外部等级、选择重生原因。-->
        <header slot="header" style="margin-left: 8px;">
            <span>重生认定申请</span>
        </header>
        <el-table :data="tableData">
            <el-table-column 
                label="ID" 
                width="80" 
                style="margin-left: 10px;" 
                prop="id">
            </el-table-column>
            <el-table-column 
                label="违约客户" 
                width="150" 
                prop="Dname">
            </el-table-column>
            <el-table-column 
                label="违约审核状态" 
                width="150" 
                prop="Dcstatus">
            </el-table-column>
            <el-table-column 
                label="认定违约原因" 
                width="300" 
                prop="Dano">
            </el-table-column>
            <el-table-column  
                label="严重程度" 
                width="150" 
                prop="Rgoavity">
            </el-table-column>
            <el-table-column 
                label="认定人" 
                width="150" 
                prop="Dauditor">
            </el-table-column>
            <el-table-column label="重生原因" width="300" prop="Rreson">
                <template slot-scope="scope">
                    <el-select v-model="scope.row.reason" placeholder="请选择">
                        <el-option v-for="reason in reasonList" :key="reason.dno" :label="reason.rcontent"
                        :value="reason.rcontent">{{reason.rcontent}}</el-option>
                    </el-select>
                </template>
            </el-table-column>
            <el-table-column 
                label="认定申请时间" 
                width="150"
                prop="Datime" >
            </el-table-column>
            <el-table-column  
                label="认定审核时间" 
                width="150"
                prop="Dctime">
            </el-table-column>
            <el-table-column  
                label="最新外部等级" 
                width="150"
                prop="Dlevel">
            </el-table-column>

            <el-table-column label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="handleSubmit(scope.row)" :disabled="total < 1" type="primary">重生申请</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination style="margin-top: 20px;float: right" background layout="prev, pager, next" :page-size="pageSize"
            :total="total" :current-page.sync="currentPage" @current-change="page">
        </el-pagination>
    </el-card>
</template>

<script>
import { ApiGet, ApiPost, baseURL } from '@/utils/request'

export default {
    data() {
        return {
            form: {
                target_name: '',
                risk_reason: '',
                external_level: '',
                risk_level: '',
                remark: '',
                appendix: '',
            },
            reasonList: '',
            tableData: '',
            dialogVisible: false,
            refreshTarget: {
                Target: {
                    Name: '',
                },
                RiskReason: {
                    Reason: '',
                },
                Checker: {
                    Nickname: '',
                },
            },
            refreshForm: {
                target_name: null,
                refresh_reason: null,
            },
            pageSize: '5',
            total: '',
            currentPage: '',
            reasonValue:''
        }
    },
    methods: {
        refresh(target) {
            this.refreshTarget = target
            this.refreshForm.target_name = target.Target.Name
            this.dialogVisible = true
        },

        async handleSubmit(row) {
            const resp = await ApiPost('/Apply/saveRenew/'+row.id+'/'+row.reason)
            if (resp.data.code == '0') {
                this.$message.success('提交成功')
                const resp = await ApiGet('/Apply/list/1/'+this.pageSize)
                this.tableData = resp.data.data.data;
                this.total = resp.data.data.total
            } else {
                this.$message.error('提交失败')
            }
        },

        async page(currentPage){
            const resp = await ApiGet('Apply/listTrue/'+currentPage+'/'+this.pageSize)
            this.tableData = resp.data.data.data;
            this.total = resp.data.data.total
        }
    },

    async created() {
        const resp = await ApiGet('/Apply/listTrue/1/'+this.pageSize)
        this.tableData = resp.data.data.data;
        this.total = resp.data.data.total

        const resp2 = await ApiGet('/renewReason/search')
        if (resp2.data.code != 0) {
            this.$alert("查询失败", "提示", {
                confirmButtonText: "确定"
            })
        } else {
            this.reasonList = resp2.data.data;
        }

        this.user = JSON.parse(localStorage.getItem('role'));
        console.log(this.user.cname)

    },
}
</script>

<style scoped>
header {
    display: flex;
}

.card {
    width: 100%;
}

.btn-submit {
    width: 200px;
}

.selector {
    width: 100%;
}
</style>
