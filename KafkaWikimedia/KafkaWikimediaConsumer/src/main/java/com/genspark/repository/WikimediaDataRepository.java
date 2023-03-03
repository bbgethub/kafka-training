package com.genspark.repository;

import com.genspark.model.WikimediaRecentChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaRecentChange, Long> {
}
