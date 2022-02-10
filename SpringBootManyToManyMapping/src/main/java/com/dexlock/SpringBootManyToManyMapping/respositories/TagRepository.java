package com.dexlock.SpringBootManyToManyMapping.respositories;

import com.dexlock.SpringBootManyToManyMapping.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
}
