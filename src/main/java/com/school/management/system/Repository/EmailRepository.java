package com.school.management.system.Repository;

import com.school.management.system.model.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Long> {
}
