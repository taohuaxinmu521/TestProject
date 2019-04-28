/**
 * Created by tanwen on 2018/11/13.
 */

app.controller('templateController',function ($scope,$http,$controller,templateService,brandService,SpecificationService) {

    //继承
    $controller('baseController',{$scope:$scope});


    //分页查询
    $scope.searchEntity = {};
    $scope.search = function (page,size) {
        templateService.search(page,size,$scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    };

    $scope.specList = {data:[]};
    $scope.findSpecList = function () {
        SpecificationService.selectSpecList().success(function (response) {
            $scope.specList = {data:response};
        })
    };

    $scope.brandList = {data:[]};
    $scope.selectOptionList = function () {
        brandService.selectOptionList().success(function (response) {
            $scope.brandList = {data:response};
        })
    };

    //查询实体
    $scope.findOne = function (id) {
        templateService.findOne(id).success(function (response) {
            $scope.entity = response;
            $scope.entity.specIds = JSON.parse($scope.entity.specIds);
            $scope.entity.brandIds = JSON.parse($scope.entity.brandIds);
            $scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);
        })
    };

    //增加模板属性行
    $scope.addTemplateRow = function () {
        $scope.entity.customAttributeItems.push({});
    };

    //删除模板属性行
    $scope.deleteTemplateRow = function (index) {
        $scope.entity.customAttributeItems.splice(index,1);
    };

    //保存的方法
    $scope.save = function () {
        var object = null;
        $scope.entity.specIds = JSON.stringify($scope.entity.specIds);
        $scope.entity.brandIds = JSON.stringify($scope.entity.brandIds);
        $scope.entity.customAttributeItems = JSON.stringify($scope.entity.customAttributeItems);
        if ($scope.entity.id != null){
            object = templateService.update($scope.entity);
        }else {
            object = templateService.add($scope.entity);
        }
        object.success(function (response) {
            if (response.success) {
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    };


    $scope.delete = function () {
        templateService.delete($scope.selectIds).success(function (response) {
            if (response.success) {
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    };
});

