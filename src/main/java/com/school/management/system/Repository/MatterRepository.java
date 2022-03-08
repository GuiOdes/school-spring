package com.school.management.system.Repository;

import com.school.management.system.model.Matter;
import org.springframework.data.repository.CrudRepository;

public interface MatterRepository extends CrudRepository<Matter, Long> {
}
