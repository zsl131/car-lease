package com.ztw.service;

import com.ztw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/2.
 */
public interface StudentService extends JpaRepository<Student, Integer> {

    public Student findByIdentity(String identity);

    public Student findByNameAndIdentity(String name, String identity);

    @Query("FROM Student ORDER BY identity ASC")
    public List<Student> findAllDatas();
}
