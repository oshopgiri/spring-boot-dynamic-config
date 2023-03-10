package demo.asd.dynamic_config.main_application.repository;

import demo.asd.dynamic_config.main_application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
