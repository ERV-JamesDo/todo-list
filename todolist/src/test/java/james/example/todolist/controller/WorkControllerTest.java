package james.example.todolist.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import james.example.todolist.enums.STATUS;
import james.example.todolist.model.Work;
import james.example.todolist.repository.WorkRepository;

public class WorkControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @MockBean
    private WorkRepository mockRepository;

    @Test
    public void testGetAllToDoList() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .get("/api/list")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Work[] works = super.mapFromJson(content, Work[].class);
        assertTrue(works.length > 0);

        MvcResult mvcResult02 = mvc.perform(MockMvcRequestBuilders
                .get("/api/list?pageNo=0&pageSize=1&sortBy=workName")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status02 = mvcResult02.getResponse().getStatus();
        assertEquals(200, status02);
        String content02 = mvcResult02.getResponse().getContentAsString();
        Work[] works02 = super.mapFromJson(content02, Work[].class);
        assertTrue(works02.length == 1);
    }

    // @Test
    public void testCreateWork() throws Exception {
        Work work = new Work("Add unit test", Date.valueOf(LocalDate.now()));
        String inputJson = super.mapToJson(work);
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post("/api/works")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    // @Test
    public void testGetWorkById() throws Exception {
        Work work = new Work("Add unit test", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()), STATUS.COMPLETE);

        // Mockito.doReturn(Optional.of(work)).when(mockRepository.findById(10L));

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .get("/api/works/2")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    // @Test
    public void testUpdateWork() throws Exception {
        Work work = new Work("Add unit test", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()), STATUS.DOING);

        String inputJson = super.mapToJson(work);
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.put("api/works/2")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    // @Test
    public void testDeleteWork() throws Exception {
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.delete("api/works/2"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
}
