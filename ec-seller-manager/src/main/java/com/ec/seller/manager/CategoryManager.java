package com.ec.seller.manager;

import java.util.List;

import com.ec.seller.domain.Category;
import com.ec.seller.domain.query.CategoryQuery;

public interface CategoryManager {
	public List<Category> selectByCondition(CategoryQuery categoryQuery);
	
	public Category selectByCategoryId(Integer categoryId);

	public List<Category> selectByLikeCondition(CategoryQuery categoryQuery);

	public Integer insert(Category category);

	public void deleteCategory1(Integer categoryId);

	public void deleteCategory2ByPar(Integer parentCategoryId);

	public void modify(Category category);

}
