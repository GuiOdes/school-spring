package com.school.management.system.Repository;

import com.school.management.system.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
}
