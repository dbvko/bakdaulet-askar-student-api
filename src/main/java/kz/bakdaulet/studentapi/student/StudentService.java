package kz.bakdaulet.studentapi.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found: " + id));
    }

    public Student create(Student student) {
        if (repository.existsByEmail(student.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Email already exists");
        }
        return repository.save(student);
    }

    public Student update(Long id, Student updatedStudent) {
        Student existing = findById(id);

        if (!existing.getEmail().equals(updatedStudent.getEmail())
                && repository.existsByEmail(updatedStudent.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Email already exists");
        }

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setAge(updatedStudent.getAge());

        return repository.save(existing);
    }

    public void delete(Long id) {
        Student student = findById(id);
        repository.delete(student);
    }
}
