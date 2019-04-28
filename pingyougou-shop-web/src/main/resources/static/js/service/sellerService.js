/**
 * Created by tanwen on 2018/11/17.
 */

app.service('sellerService',function ($http) {
    this.findAll = function () {
        return $http.get('/seller/list');
    };
    this.findPage = function (page,size) {
        return $http.get('/seller/findPage?page='+page+'&size='+size);
    };
    this.findOne = function (id) {
        return $http.post('/seller/findOne?id='+id);
    };
    this.delete = function (selectIds) {
        return $http.get('/seller/delete?ids='+selectIds);
    };
    this.search = function (page,size,searchEntity) {
        return $http.post('/seller/search?page='+page+'&size='+size,searchEntity);
    };
    this.add = function (entity) {
        return $http.post('/seller/add',entity);
    };
    this.update = function (entity) {
        return $http.post('/seller/update',entity);
    };
    this.selectOptionList = function () {
        return $http.get('/seller/optionList');
    };
});