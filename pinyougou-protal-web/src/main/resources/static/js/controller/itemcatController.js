/**
 * Created by tanwen on 2018/11/18.
 */

//controller
app.controller('itemcatController',function ($scope,$http,$controller,itemcatService) {

    //继承
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll = function () {
        itemcatService.findAll().success(function (response) {
            $scope.list = response;
        })
    };

    //获取后台数据
    $scope.findPage = function (page,size) {
        itemcatService.findPage(page,size).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    };

    //新增
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null){
            object = itemcatService.update($scope.entity);
        }else {
            object = itemcatService.add($scope.entity);
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
        itemcatService.findOne(id).success(function (response) {
            $scope.entity = response;
        })
    };

    $scope.delete = function () {
        itemcatService.delete($scope.selectIds).success(function (response) {
            if (response.success) {
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    };

    //分页查询
    $scope.parentId = 0;
    $scope.searchEntity = {};
    $scope.search = function (page,size) {
        itemcatService.search(page,size,$scope.parentId).success(function (response) {
            $scope.list = response.rows;
            $scope.painationconf.totalItems = response.total;
        })
    };

    $scope.updateParentId = function (id) {
        $scope.parentId = id;
        $scope.reloadList();
    };
    
    //设置等级
    $scope.grade = 1;
    $scope.setGrade = function (value) {
        $scope.grade = value;
    };
    
    $scope.selectList = function (P_Entity) {
        
        if ($scope.grade == 1){
            $scope.entity_1 = null;
            $scope.entity_2 = null;
        }
        if ($scope.grade == 2){
            $scope.entity_1 = P_Entity;
            $scope.entity_2 = null;
        }
        if ($scope.grade == 3){
            $scope.entity_2 = P_Entity;
        }

        $scope.updateParentId(P_Entity.id);
    };
    
    
});
