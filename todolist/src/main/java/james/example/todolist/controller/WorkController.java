package james.example.todolist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import james.example.todolist.exception.ResourceNotFoundException;
import james.example.todolist.model.Work;
import james.example.todolist.repository.WorkRepository;
import james.example.todolist.service.WorkService;
import lombok.AllArgsConstructor;

/**
 * 
 * @author james-do
 *
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WorkController {

    @Autowired
    WorkRepository workRepository;

    @Autowired
    WorkService service;

    @GetMapping("/list")
    public List<Work> getAllToDoList(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "workId") String sortBy) {
        return service.getAllToDoList(pageNo, pageSize, sortBy);
    }

    @PostMapping("/works")
    public Work createWork(@Valid @RequestBody Work work) {
        return workRepository.save(work);
    }

    @GetMapping("/works/{id}")
    public Work getWorkById(@PathVariable(value = "id") Long workId) {
        return workRepository.findById(workId)
                .orElseThrow(() -> new ResourceNotFoundException("works",
                        "workId", workId));
    }

    @PutMapping("/works/{id}")
    public Work updateWork(@PathVariable(value = "id") Long workId,
            @Valid @RequestBody Work workDetails) {

        Work work = workRepository.findById(workId)
                .orElseThrow(() -> new ResourceNotFoundException("works",
                        "workId", workId));

        work.setWorkName(workDetails.getWorkName());
        work.setStatus(workDetails.getStatus());

        Work updatedNote = workRepository.save(work);
        return updatedNote;
    }

    @DeleteMapping("/works/{id}")
    public ResponseEntity<?> deleteWork(@PathVariable(value = "id") Long workId) {
        Work note = workRepository.findById(workId)
                .orElseThrow(() -> new ResourceNotFoundException("works",
                        "workId", workId));

        workRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
