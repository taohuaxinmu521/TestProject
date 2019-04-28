/**
 * Created by tanwen on 2018/11/12.
 */

app.service('SpecificationService',function ($http) {
    this.findAll = function () {
        return $http.get('/specification/list');
    };
    this.findPage = function (page,size) {
        return $http.get('/specification/findPage?page='+page+'&size='+size);
    };
    this.findOne = function (id) {
        return $http.post('/specification/findOne?id='+id);
    };
    this.delete = function (selectIds) {
        return $http.get('/specification/delete?ids='+selectIds);
    };
    this.search = function (page,size,searchEntity) {
        return $http.post('/specification/search?page='+page+'&size='+size,searchEntity);
    };
    this.add = function (entity) {
        return $http.post('/specification/add',entity);
    };
    this.update = function (entity) {
        return $http.post('/specification/update',entity);
    };
    this.selectSpecList = function () {
        return $http.get('/specification/optionList');
    };
});
