package com.imooc.mall.serviceImpl;


import com.imooc.mall.consts.MallConsts;
import com.imooc.mall.dao.CategoryMapper;
import com.imooc.mall.pojo.Category;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * http請求最耗時
 * created by Leo徐忠春
 * created Time 2020/1/6-3:48
 * email 1437665365@qq.com
 */
@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> selectAllByStatus() {
        List<CategoryVo> categoryVoList= new ArrayList<>();
        List<Category> categories = categoryMapper.selectAll();
        //查出ParentId=0的数据
        for (Category category : categories) {
            if(category.getParentId().equals(MallConsts.ROOT_PARENT_ID)){
                CategoryVo categoryVo = new CategoryVo();
                //把category的内容复制给categoryVo
                BeanUtils.copyProperties(category,categoryVo);
                categoryVoList.add(categoryVo);
            }
        }
        //查詢子目錄
        findSubCategoryVo(categoryVoList,categories);
        return ResponseVo.success(categoryVoList);
    }

    private void findSubCategoryVo(List<CategoryVo> categoryVoList,
                                   List<Category> categories) {
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryList=new ArrayList<>();
            for (Category category : categories) {
                //如果查到內容繼續,設置subCategoryList,往下查
                if(categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subCategoryVo=categoryVo(category);
                    subCategoryList.add(subCategoryVo);
                }
                //根據SortOrder進行降序排序
                subCategoryList.sort(Comparator.comparing
                        (CategoryVo::getSortOrder));
                categoryVo.setSubCategories(subCategoryList);
                //遞歸查第三級子目錄
                findSubCategoryVo(subCategoryList,categories);
            }
        }
    }

    private CategoryVo categoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
