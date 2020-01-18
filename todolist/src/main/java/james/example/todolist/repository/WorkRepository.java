package james.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import james.example.todolist.model.Work;

/**
 * 
 * @author james-do
 *
 */

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

}
