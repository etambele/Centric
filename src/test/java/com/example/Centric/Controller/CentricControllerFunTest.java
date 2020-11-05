package com.example.Centric.Controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CentricControllerFunTest {

    private MockMvc mockMvc;

    @Autowired
    private CentricController centricController;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(centricController).build();
    }

    String content = "{\n" +
            "\"name\":\"Green Shirt\",\n" +
            "\"description\":\"Red hugo boss shirt\",\n" +
            "\"brand\":\"Hugo Boss\",\n" +
            "\"tags\":[\n" +
            "\"red\",\n" +
            "\"shirt\",\n" +
            "\"slim fit\"\n" +
            "],\n" +
            "\"category\":\"apparel\"\n" +
            "}";


    @Test
    public void addProduct() throws Exception{
        mockMvc.perform(post("/v1/products/add_product")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name", Matchers.is("Green Shirt")));

    }

    @Test
    public void getProductByCategory() throws Exception{
        mockMvc.perform(get("/v1/products/category?category=category"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}

