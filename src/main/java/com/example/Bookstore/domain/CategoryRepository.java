package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName(String name);

//	List<Category> findByCategoryName(@Param("name") String name);

}
