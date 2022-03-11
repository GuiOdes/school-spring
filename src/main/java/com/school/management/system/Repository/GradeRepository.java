package com.school.management.system.Repository;

import com.school.management.system.Model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    boolean existsByName(String name);
}
