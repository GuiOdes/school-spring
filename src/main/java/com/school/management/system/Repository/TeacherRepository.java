package com.school.management.system.Repository;

import com.school.management.system.model.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
    List<Teacher> findAll(Pageable pageable);
}
