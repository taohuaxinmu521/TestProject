/**
 * Created by tanwen on 2018/11/12.
 */

//controller
app.controller('brandController',function ($scope,$http,$controller,brandService) {

    //继承
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        })
    };

    //获取后台数据
    $scope.findPage = function (page,size) {
        brandService.findPage(page,size).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    };

    //新增
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null){
            object = brandService.update($scope.entity);
        }else {
            object = brandService.add($scope.entity);
        }
        object.success(function (response) {
            if (response.success) {
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    };

    //查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (response) {
            $scope.entity = response;
        })
    };

    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(function (response) {
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
        brandService.search(page,size,$scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    }

});