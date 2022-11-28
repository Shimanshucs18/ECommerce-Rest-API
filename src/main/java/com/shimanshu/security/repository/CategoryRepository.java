package com.shimanshu.security.repository;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT * FROM category a WHERE a.name = ?1", nativeQuery = true)
    Category findByCategoryName(String categoryName);

    @Query(value = "SELECT * FROM category a WHERE a.parent_category_id = ?1", nativeQuery = true)
    List<com.shimanshu.security.entity.Category> findChildCategories(Long id);

    @Query(value = "SELECT * FROM category a WHERE a.parent_category_id IS NULL", nativeQuery = true)
    List<Category> findCategoryByNull();


}
