/**
 * Created by tanwen on 2018/11/12.
 */

app.controller('specificationController',function ($scope,$http,$controller,SpecificationService) {

    //继承
    $controller('baseController',{$scope:$scope});


    //分页查询
    $scope.searchEntity = {};
    $scope.search = function (page,size) {
        SpecificationService.search(page,size,$scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    };
    
    //增加规格行
    //$scope.entity = {optionList:[]};
    $scope.addTableRow = function () {
        $scope.entity.optionList.push({});
    };

    //删除规格行
    $scope.deleteTableRow = function (index) {
        $scope.entity.optionList.splice(index,1);
    };

    $scope.save = function () {
        var object = null;
        if ($scope.entity.tbSpecification.id != null){
            object = SpecificationService.update($scope.entity);
        }else {
            object = SpecificationService.add($scope.entity);
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
        SpecificationService.findOne(id).success(function (response) {
            $scope.entity = response;
        })
    };


    $scope.delete = function () {
        SpecificationService.delete($scope.selectIds).success(function (response) {
            if (response.success) {
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    };
});
