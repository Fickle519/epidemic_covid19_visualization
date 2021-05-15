/**
 * 画柱状图
 * @param container 容器
 * @param xData x轴数据
 * @param seriesData 图表数据
 */
function drawBar(container, xData, seriesData) {
    var myCharts = echarts.init(document.getElementById(container));
    myOption = {
        //提示框组件
        tooltip : {
            //鼠标悬浮到某柱子时触发的提示信息类型
            trigger : 'item',
            position : 'top',
            formatter : '{c}'
        },
        //图形位置
        grid : {
            left : '4%',
            right : '4%',
            bottom : '4%',
            top : 30,
            //图形位置包含坐标轴的刻度标签
            //如果图形位置调整好缺不包含坐标轴，坐标轴信息会显示不全
            containLabel : true
        },
        xAxis : [ {
            type : 'category',
            //x轴线样式
            axisLine : {
                show : true,
                lineStyle : {
                    color : 'rgba(255,255,255,0.2)',
                    //x轴想要设置为轴线隐藏，width设置为0
                    width : 1,
                    type : 'dashed'
                }
            },
            //x轴字体样式
            axisLabel : {
                show : true,
                fontSize : 12,
                color : 'grey',
                //x轴坐标全部显示
                interval : 0
            },
            data : xData
        } ],
        yAxis : [ {
            type : 'value',
            //y轴字体样式
            axisLabel : {
                show : true,
                color : 'grey',
                fontSize : 12
            },
            //y轴线样式
            axisLine : {
                show : false
            },
            //设置与x轴平行的线(分割线)不显示
            splitLine : {
                show : false,
                lineStyle : {
                    //如果显示，设置分割线的宽度，设置为0的话，即为分割线不显示
                    width : 1
                }
            },
            minInterval: 500
        } ],
        series : [ {
            type : 'bar',
            //柱子宽度
            barWidth : '20',
            //柱子间隔
            barGap : '20',
            itemStyle : {
                color : {
                    type : 'linear',
                    x : 0,
                    y : 0,
                    x2 : 0,
                    y2 : 1,
                    colorStops : [ {
                        offset : 0,
                        color : '#6ae6dd' // 0% 处的颜色
                    }, {
                        offset : 1,
                        color : '#3b8ce4' // 100% 处的颜色
                    } ]
                },
                barBorderRadius : [ 30, 30, 0, 0 ],
            },
            //柱状图悬浮或者跳动到某柱子时样式
            emphasis : {
                itemStyle : {
                    color : {
                        type : 'linear',
                        x : 0,
                        y : 0,
                        x2 : 0,
                        y2 : 1,
                        colorStops : [ {
                            offset : 0,
                            color : 'rgba(254,136,94,1)' // 0% 处的颜色
                        }, {
                            offset : 1,
                            color : 'rgba(251,46,73,1)' // 100% 处的颜色
                        } ]
                    }
                }
            },
            data : seriesData
        } ]
    };
    myCharts.setOption(myOption);

    var app = {};
    app.currentIndex = -1;
    var myTimer = setInterval(
        function() {
            var dataLen = myOption.series[0].data.length;
            if ((app.currentIndex < dataLen - 1)
                && myOption.series[0].data[app.currentIndex + 1].value == 0) {
                myCharts.dispatchAction({
                    type : 'downplay',
                    seriesIndex : 0,
                    dataIndex : app.currentIndex
                });
                app.currentIndex = (app.currentIndex + 1) % dataLen;
            } else {
                // 取消之前高亮的图形
                myCharts.dispatchAction({
                    type : 'downplay',
                    seriesIndex : 0,
                    dataIndex : app.currentIndex
                });
                app.currentIndex = (app.currentIndex + 1) % dataLen;
                // 高亮当前图形
                myCharts.dispatchAction({
                    type : 'highlight',
                    seriesIndex : 0,
                    dataIndex : app.currentIndex
                });
                // 显示 tooltip
                myCharts.dispatchAction({
                    type : 'showTip',
                    seriesIndex : 0,
                    dataIndex : app.currentIndex
                });
            }
        }, 3000);
}


