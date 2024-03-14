package edu.com.java5_asm.reposiroties;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.com.java5_asm.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String>{
    Account findByUsernameAndPassword(String username, String password);
    Account findByUsername(String username);
    @Query("SELECT a FROM Account a WHERE a.username LIKE %?1%")
    Page<Account> findByKeywords(String keywords, Pageable pageable);
}
