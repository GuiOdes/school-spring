package com.school.management.system.Repository;

import com.school.management.system.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}



