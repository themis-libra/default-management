<template>
    <div class="wrapper">
        <el-card class="card">
            <VChart :option="option" class="chart" />
        </el-card>
        <br />
        <el-card class="card">
            <div id="line-chart"></div>
        </el-card>
        <hr />

        <el-card class="card">
            <VChart :option="option1" class="chart" />
        </el-card>
        <br />
        <el-card class="card">
            <div id="line-chart-1"></div>
        </el-card>
    </div>
</template>

<script>
import { PieChart, ScatterChart } from 'echarts/charts'
import { CanvasRenderer } from 'echarts/renderers'
import { use } from 'echarts/core'
import * as echarts from 'echarts'

import {
    TitleComponent,
    TooltipComponent,
    LegendComponent,
} from 'echarts/components'

import VChart from 'vue-echarts'

use([
    CanvasRenderer,
    PieChart,
    TitleComponent,
    TooltipComponent,
    LegendComponent,
    ScatterChart,
])

export default {
    components: {
        VChart,
    },
    data() {
        return {
            option: {
                title: {
                    text: '行业违约统计',
                    left: 'center',
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)',
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['教育', '房地产', '金融', '保险', '影视'],
                },
                series: [
                    {
                        name: '违约行业统计',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            { value: 4, name: '教育' },
                            { value: 5, name: '房地产' },
                            { value: 3, name: '金融' },
                            { value: 3, name: '保险' },
                            { value: 4, name: '影视' },
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)',
                            },
                        },
                    },
                ],
            },

            option1: {
                title: {
                    text: '区域违约统计',
                    left: 'center',
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)',
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['浙江', '北京', '上海', '广东', '湖南'],
                },
                series: [
                    {
                        name: '区域违约统计',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            { value: 4, name: '浙江' },
                            { value: 3, name: '北京' },
                            { value: 2, name: '上海' },
                            { value: 6, name: '广东' },
                            { value: 4, name: '湖南' },
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)',
                            },
                        },
                    },
                ],
            },
        }
    },
    methods: {},

    mounted() {
        const lineChart = echarts.init(document.getElementById('line-chart'))
        const option = {
            title: {
                text: '行业违约主体增长趋势',
            },
            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['教育', '房地产', '金融', '保险', '影视'],
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true,
            },
            toolbox: {
                feature: {
                    saveAsImage: {},
                },
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['2017', '2018', '2019', '2020', '2021', '2022', '2023'],
            },
            yAxis: {
                type: 'value',
            },
            series: [
                {
                    name: '教育',
                    type: 'line',
                    stack: 'Total',
                    data: [0, 2, 1, 1, 0, 2, 1],
                },
                {
                    name: '房地产',
                    type: 'line',
                    stack: 'Total',
                    data: [2, 2, 1, 0, 0, 0, 0],
                },
                {
                    name: '金融',
                    type: 'line',
                    stack: 'Total',
                    data: [0, 0, 1, 2, 0, 1, 2],
                },
                {
                    name: '保险',
                    type: 'line',
                    stack: 'Total',
                    data: [1, 1, 0, 0, 2, 0, 1],
                },
                {
                    name: '影视',
                    type: 'line',
                    stack: 'Total',
                    data: [1, 0, 0, 1, 0, 2, 0],
                },
            ],
        }

        lineChart.setOption(option)

        const lineChart1 = echarts.init(document.getElementById('line-chart-1'))
        const option1 = {
            title: {
                text: '区域违约主体增长趋势',
            },
            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['教育', '房地产', '金融', '保险', '影视'],
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true,
            },
            toolbox: {
                feature: {
                    saveAsImage: {},
                },
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['2017', '2018', '2019', '2020', '2021', '2022', '2023'],
            },
            yAxis: {
                type: 'value',
            },
            series: [
                {
                    name: '浙江',
                    type: 'line',
                    stack: 'Total',
                    data: [2, 0, 0, 0, 1, 2, 2],
                },
                {
                    name: '北京',
                    type: 'line',
                    stack: 'Total',
                    data: [0, 0, 0, 0, 1, 0, 2],
                },
                {
                    name: '上海',
                    type: 'line',
                    stack: 'Total',
                    data: [0, 0, 0, 0, 2, 1, 1],
                },
                {
                    name: '广东',
                    type: 'line',
                    stack: 'Total',
                    data: [2, 1, 2, 2, 0, 0, 0],
                },
                {
                    name: '湖南',
                    type: 'line',
                    stack: 'Total',
                    data: [1, 0, 0, 2, 0, 0, 3],
                },
            ],
        }

        lineChart1.setOption(option1)
    },

    created() {},
}
</script>

<style scoped>
header {
    display: flex;
}

.card {
    width: 100%;
}

.chart {
    height: 400px;
}
#line-chart,
#line-chart-1 {
    height: 500px;
    width: 100%;
}

.wrapper {
    width: 100%;
}
</style>
