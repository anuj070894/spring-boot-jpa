package com.anujbrandy.data_jpa.repositories;

import com.anujbrandy.data_jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age, @Param("authorId") int authorId);
    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :authorId")
    int updateAge(int age, int authorId);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAge(int age);

    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);
}
