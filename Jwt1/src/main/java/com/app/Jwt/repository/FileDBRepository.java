package com.app.Jwt.repository;

import com.app.Jwt.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
