package com.example.Centric.Controller;

import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Service.ProductService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CentricControllerTest {

    private MockMvc mockMvc;

    @Mock
    ProductService productService;

    @InjectMocks
    private CentricController centricController;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(centricController).build();
    }

    String content = "{\n" +
            "\"name\":\"green Shirt\",\n" +
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
        ProductDTO productDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(null)
                .build();
        when(productService.addProduct(any(ProductDTO.class))).thenReturn(productDTO);
        mockMvc.perform(post("/v1/products/add_product")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name", Matchers.is("name")));

    }

    @Test
    public void getProductByCategory() throws Exception{
        ProductDTO productDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(null)
                .build();
        ProductDTO productDTO2 = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(null)
                .build();
        when(productService.getProductByCategory("category", null, null))
                .thenReturn(new ArrayList<>(Arrays.asList(productDTO, productDTO2)));
        mockMvc.perform(get("/v1/products/category?category=category"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].name", Matchers.is("name")));

    }
}
