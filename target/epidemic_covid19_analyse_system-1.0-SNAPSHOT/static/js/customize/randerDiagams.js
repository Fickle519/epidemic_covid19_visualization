function randerData(xticks,dataMapping) {
    // Y轴数据的设定
    var seriesData = [{
        value:dataMapping[xticks[0]][dataMapping[xticks[0]].length-1].totalNum
    }, {
        value:dataMapping[xticks[1]][dataMapping[xticks[1]].length-1].totalNum
    }, {
        value:dataMapping[xticks[2]][dataMapping[xticks[2]].length-1].totalNum
    }, {
        value:dataMapping[xticks[3]][dataMapping[xticks[3]].length-1].totalNum
    }, {
        value:dataMapping[xticks[4]][dataMapping[xticks[4]].length-1].totalNum
    }, {
        value:dataMapping[xticks[5]][dataMapping[xticks[5]].length-1].totalNum
    }, {
        value:dataMapping[xticks[6]][dataMapping[xticks[6]].length-1].totalNum
    }, {
        value:dataMapping[xticks[7]][dataMapping[xticks[7]].length-1].totalNum
    }, {
        value:dataMapping[xticks[8]][dataMapping[xticks[8]].length-1].totalNum
    }, {
        value:dataMapping[xticks[9]][dataMapping[xticks[9]].length-1].totalNum
    }];
    // 绘图调用的方法
    drawBar('bar', xticks, seriesData);

}