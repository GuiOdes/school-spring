package com.school.management.system.Repository;

import com.school.management.system.Model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll(Pageable pageable);

    boolean existsByEmail(String email);
}



