package com.school.management.system.Repository;

import com.school.management.system.model.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
}
