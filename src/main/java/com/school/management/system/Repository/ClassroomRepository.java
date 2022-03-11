package com.school.management.system.Repository;

import com.school.management.system.Model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
    boolean existsByName(String name);
}
