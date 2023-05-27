package com.adaskalov.parts.domain.repository;

import com.adaskalov.parts.domain.models.Part;
import com.adaskalov.parts.domain.models.PartNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, PartNumber> {
}
