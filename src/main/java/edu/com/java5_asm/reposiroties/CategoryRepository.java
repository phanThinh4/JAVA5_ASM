package edu.com.java5_asm.reposiroties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.java5_asm.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
    
}
