package james.example.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import james.example.todolist.model.Work;
import james.example.todolist.repository.WorkRepositoryCollection;

@Component
public class WorkService {

    @Autowired
    WorkRepositoryCollection workRepositoryCollection;

    /**
     * Get all ToDo list sorted by sortValue with paging
     * 
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @return List<Work>
     */
    public List<Work> getAllToDoList(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Work> pagedResult = workRepositoryCollection.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Work>();
        }
    }
}
