/**
 * Created by tanwen on 2018/11/12.
 */

app.service('brandService',function ($http) {
    this.findAll = function () {
        return $http.get('/brand/list');
    };
    this.findPage = function (page,size) {
        return $http.get('/brand/findPage?page='+page+'&size='+size);
    };
    this.findOne = function (id) {
        return $http.post('/brand/findOne?id='+id);
    };
    this.delete = function (selectIds) {
        return $http.get('/brand/delete?ids='+selectIds);
    };
    this.search = function (page,size,searchEntity) {
        return $http.post('/brand/search?page='+page+'&size='+size,searchEntity);
    };
    this.add = function (entity) {
        return $http.post('/brand/add',entity);
    };
    this.update = function (entity) {
        return $http.post('/brand/update',entity);
    };
    this.selectOptionList = function () {
        return $http.get('/brand/optionList');
    };
});