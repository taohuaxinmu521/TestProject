/**
 * Created by tanwen on 2018/11/12.
 */

app.controller('baseController',function ($scope) {
    //分页控件
    $scope.painationconf = {
        currentPage:1,
        totalItems:10,
        itemsPerPage:10,
        perPageOption:[10,20,30,40,50],
        onChange:function () {
            $scope.reloadList();
        }
    };

    $scope.reloadList = function () {
        $scope.search($scope.painationconf.currentPage,$scope.painationconf.itemsPerPage);
    };

    //获取选中的id
    $scope.selectIds = [];
    $scope.updateSelection = function ($event,id) {
        if ($event.target.checked){
            $scope.selectIds.push(id);
        }else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    };

    $scope.JsonToString = function (jsonString,key) {
        var json = JSON.parse(jsonString);
        var value = "";
        for (var i=0;i<json.length;i++){
            if (i > 0){
                value += ',';
            }
            value += json[i][key];
        }
        return value;
    }
});
