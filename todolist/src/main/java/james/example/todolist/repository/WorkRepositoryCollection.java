package james.example.todolist.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import james.example.todolist.model.Work;

/**
 * 
 * @author james-do
 *
 */

@Repository
public interface WorkRepositoryCollection
        extends PagingAndSortingRepository<Work, Long> {

}
