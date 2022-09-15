package com.sp.studentinfo.repository;

import com.sp.studentinfo.entity.StudentTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTableEntityRepository extends JpaRepository<StudentTableEntity, Integer> {
}
