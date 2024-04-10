package org.example.practicaspring.services;

import org.example.practicaspring.Models.StudentModel;
import org.example.practicaspring.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //obtener todos los estudiantes registrados
    public ArrayList<StudentModel> getAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    //guardar un estudiante

    public StudentModel saveStudent(StudentModel student){
        //TODO validate if code is not repetided
        if((studentRepository.findStudentByCode(student.getCode()).isEmpty())){
            return this.studentRepository.save(student);
        }else{
            //retornar un error repetido
            StudentModel studentError=new StudentModel();
            studentError.setId(-1L);
            return studentError;
        }

    }


    public Optional<StudentModel> findStudentById(Long id){
        return studentRepository.findById(id);
    }

    //buscar por codigo
    public Optional<StudentModel> findStudentByCode(String code){
        return studentRepository.findStudentByCode(code);
    }

    //buscar por nombre
    public ArrayList<StudentModel> findStudentByName(String name){
        return studentRepository.findStudentByName(name);
    }

    public String deleteStudent(Long id){
        Optional<StudentModel> respuesta = studentRepository.findById(id);

        if(respuesta.isPresent()){
            studentRepository.deleteById(id);
            return "Estudiante eliminado";//en ingles
        }else{
            return "NO se encontro un estudiante con ese id";
        }
    }

    //editar por id
    public StudentModel editById(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }
}
