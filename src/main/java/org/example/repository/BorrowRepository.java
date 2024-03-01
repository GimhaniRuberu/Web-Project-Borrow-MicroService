package org.example.repository;

import org.example.entity.BorrowEntity;
import org.springframework.data.repository.CrudRepository;

public interface BorrowRepository extends CrudRepository<BorrowEntity,Long> {
}
