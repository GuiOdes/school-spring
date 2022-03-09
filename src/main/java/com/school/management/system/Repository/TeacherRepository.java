package com.school.management.system.Repository;

import com.school.management.system.model.Teacher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    List<Teacher> findAll(Pageable pageable);
}
