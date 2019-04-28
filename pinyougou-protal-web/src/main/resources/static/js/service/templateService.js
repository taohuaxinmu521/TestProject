/**
 * Created by tanwen on 2018/11/13.
 */


app.service('templateService',function ($http) {
    this.findAll = function () {
        return $http.get('/template/list');
    };
    this.findPage = function (page,size) {
        return $http.get('/template/findPage?page='+page+'&size='+size);
    };
    this.findOne = function (id) {
        return $http.post('/template/findOne?id='+id);
    };
    this.delete = function (selectIds) {
        return $http.get('/template/delete?ids='+selectIds);
    };
    this.search = function (page,size,searchEntity) {
        return $http.post('/template/search?page='+page+'&size='+size,searchEntity);
    };
    this.add = function (entity) {
        return $http.post('/template/add',entity);
    };
    this.update = function (entity) {
        return $http.post('/template/update',entity);
    };
});