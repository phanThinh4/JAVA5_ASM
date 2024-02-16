package edu.com.java5_asm.reposiroties;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.com.java5_asm.model.Product;
import edu.com.java5_asm.model.Report;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT o FROM Product o WHERE o.category.id = ?1")
    List<Product> findByCategoryID(String id);

    @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT new Report(o.category, sum(o.price), count(o)) "
            + " FROM Product o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();
}
