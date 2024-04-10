package org.example.practicaspring.repositories;

import org.example.practicaspring.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    public abstract Optional<StudentModel> findStudentByCode(String code);
    public abstract ArrayList<StudentModel> findStudentByName(String name);
    public abstract Optional<StudentModel> findStudentById(long id);
}
