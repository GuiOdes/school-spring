package com.school.management.system.Repository;

import com.school.management.system.Model.Matter;
import org.springframework.data.repository.CrudRepository;

public interface MatterRepository extends CrudRepository<Matter, Long> {
}
