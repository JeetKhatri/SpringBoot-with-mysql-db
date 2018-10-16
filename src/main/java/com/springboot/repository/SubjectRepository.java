package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Subject;

/***
 * 
 * @author Jeet Khatri
 * @date 15-Oct-2018
 * @link https://github.com/JeetKhatri/SpringBoot-with-mysql-db.git
 *
 */

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}

