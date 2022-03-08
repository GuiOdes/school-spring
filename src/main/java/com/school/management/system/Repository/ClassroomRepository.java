package com.school.management.system.Repository;

import com.school.management.system.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
}
