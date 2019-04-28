/**
 * Created by tanwen on 2018/12/2.
 */

//controller
app.controller('contentController',function ($scope,$http,$controller,contentService) {

    //继承
    $controller('baseController',{$scope:$scope});

    //查询广告列表
    $scope.categoryList = [];
    $scope.findCategoryId = function (categoryId) {
        contentService.findCategoryId(categoryId).success(function (response) {
            $scope.categoryList[categoryId] = response;
        })
    };



});
