package james.example.todolist.service;

import org.junit.Test;
import org.mockito.Mockito;

import james.example.todolist.repository.WorkRepositoryCollection;

public class WorkServiceTest {

    @Test
    public void testGetAllToDoList() {
        WorkRepositoryCollection workRepositoryCollection = Mockito
                .spy(WorkRepositoryCollection.class);

    }
}
