/**
 * Created by tanwen on 2018/12/2.
 */

app.service('contentService',function ($http) {
    
    this.findCategoryId = function (categoryId) {
        return $http.get('/content/findByCategoryId?categoryId='+categoryId);
    };
    
    
});
