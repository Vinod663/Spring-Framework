package org.example.back_end.repository;

import org.example.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {//<entity name,primary key type>
      //repository---->DAO Layer eka wenuwata
    // Additional query methods can be defined here if needed
    /*@Query(value = "SELECT j FROM Job j WHERE j.title = ?1",nativeQuery = true);*//*-------> Custom queries*/
    /*@Modifying*///Use this annotation to indicate that the query is modifying the database (e.g., insert, update, delete).
    @Transactional
    @Modifying
    @Query(value = "UPDATE Job SET status='Deactivate' WHERE id =?1",nativeQuery = true)
    void updateJobStatus(String id);


    List<Job> findJobByJobTitleContainingIgnoreCase(String keyword);
}
