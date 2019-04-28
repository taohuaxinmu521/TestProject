/**
 * Created by tanwen on 2018/11/18.
 */

app.service('itemcatService',function ($http) {
    this.findAll = function () {
        return $http.get('/type/list');
    };
    this.findPage = function (page,size) {
        return $http.get('/type/findPage?page='+page+'&size='+size);
    };
    this.findOne = function (id) {
        return $http.post('/type/findOne?id='+id);
    };
    this.delete = function (selectIds) {
        return $http.get('/type/delete?ids='+selectIds);
    };
    this.search = function (page,size,parentId) {
        return $http.post('/type/search?page='+page+'&size='+size+'&parentId='+parentId);
    };
    this.add = function (entity) {
        return $http.post('/type/add',entity);
    };
    this.update = function (entity) {
        return $http.post('/type/update',entity);
    };
    this.selectOptionList = function () {
        return $http.get('/type/optionList');
    };
});
