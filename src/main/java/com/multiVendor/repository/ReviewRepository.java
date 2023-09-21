package com.multiVendor.repository;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.multiVendor.entity.Reviews;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE business_reviews SET review = :review, rating = :rating, updated_date = :updatedAt WHERE id = :id", nativeQuery = true)
	void update(@Param("id") Integer id, @Param("rating") Integer rating, @Param("review") String review,
			@Param("updatedAt") LocalDateTime updatedAt);

}
