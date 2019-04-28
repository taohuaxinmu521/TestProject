/**
 * Created by tanwen on 2018/11/17.
 */


//controller
app.controller('sellerController',function ($scope,$http,$controller,sellerService) {

    //继承
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll = function () {
        sellerService.findAll().success(function (response) {
            $scope.list = response;
        })
    };

    //获取后台数据
    $scope.findPage = function (page,size) {
        sellerService.findPage(page,size).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    };

    //新增
    $scope.save = function () {
        var object = null;
        object = sellerService.add($scope.entity);
        object.success(function (response) {
            if (response.success){
                window.location="/seller/home";
            }
        })
    };

    //查询实体
    $scope.findOne = function (id) {
        sellerService.findOne(id).success(function (response) {
            $scope.entity = response;
        })
    };

    $scope.delete = function () {
        sellerService.delete($scope.selectIds).success(function (response) {
            if (response.success) {
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    };

    //分页查询
    $scope.searchEntity = {};
    $scope.search = function (page,size) {
        sellerService.search(page,size,$scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    }

});
