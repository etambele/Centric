package com.example.Centric.Service;

import com.example.Centric.Model.Entity.Product;
import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Converter converter;

    @InjectMocks
    private ProductService productService;

    private final ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Z"));

    @Test
    public void addProducts(){
        ProductDTO productDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id(null)
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(null)
                .build();
        ProductDTO savedProductDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(dateTime)
                .build();
        Product product = new Product();
        product.setName("shirt");
        product.setBrand("brand");
        product.setCategory("category");
        product.setId("1111");
        product.setDescription("description");
        product.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product.setCreatedAt(dateTime);


        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(converter.convertProductDTOToProduct(productDTO)).thenReturn(product);
        Mockito.when(converter.convertProductToProductDTO(product)).thenReturn(savedProductDTO);
        ProductDTO savedProduct = productService.addProduct(productDTO);
        assertThat(savedProduct.getId()).isEqualTo(product.getId());
    }

    @Test(expected = RuntimeException.class)
    public void addProductsWithException(){
        ProductDTO productDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id(null)
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(null)
                .build();
        ProductDTO savedProductDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(dateTime)
                .build();
        Product product = new Product();
        product.setName("shirt");
        product.setBrand("brand");
        product.setCategory("category");
        product.setId("1111");
        product.setDescription("description");
        product.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product.setCreatedAt(dateTime);


        Mockito.when(productRepository.save(product)).thenThrow(new RuntimeException());
        Mockito.when(converter.convertProductDTOToProduct(productDTO)).thenReturn(product);
        Mockito.when(converter.convertProductToProductDTO(product)).thenReturn(savedProductDTO);
        productService.addProduct(productDTO);
    }

    @Test
    public void getProductCategory(){
        ProductDTO savedProductDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(dateTime)
                .build();
        Product product = new Product();
        product.setName("shirt");
        product.setBrand("brand");
        product.setCategory("category");
        product.setId("1111");
        product.setDescription("description");
        product.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product.setCreatedAt(dateTime);
        Product product2 = new Product();
        product2.setName("shirt2");
        product2.setBrand("brand2");
        product2.setCategory("category2");
        product2.setId("1111");
        product2.setDescription("description2");
        product2.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product2.setCreatedAt(dateTime);
        Product product3 = new Product();
        product3.setName("shirt3");
        product3.setBrand("brand3");
        product3.setCategory("category");
        product3.setId("1111");
        product3.setDescription("description3");
        product3.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product3.setCreatedAt(dateTime);
        List<Product> productslist = new ArrayList<>(Arrays.asList(product, product3));
        String category = "category";


        Mockito.when(productRepository.getProductsByCategory(category)).thenReturn(productslist);
        Mockito.when(converter.convertProductToProductDTO(product)).thenReturn(savedProductDTO);
        List<ProductDTO> savedProductList = productService.getProductByCategory(category, null, null);
        assertThat(savedProductList.size()).isEqualTo(2);
    }

    @Test
    public void getProductCategoryWithPageSize(){
        ProductDTO savedProductDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(dateTime)
                .build();
        Product product = new Product();
        product.setName("shirt");
        product.setBrand("brand");
        product.setCategory("category");
        product.setId("1111");
        product.setDescription("description");
        product.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product.setCreatedAt(dateTime);
        Product product2 = new Product();
        product2.setName("shirt2");
        product2.setBrand("brand2");
        product2.setCategory("category2");
        product2.setId("1111");
        product2.setDescription("description2");
        product2.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product2.setCreatedAt(dateTime);
        Product product3 = new Product();
        product3.setName("shirt3");
        product3.setBrand("brand3");
        product3.setCategory("category");
        product3.setId("1111");
        product3.setDescription("description3");
        product3.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product3.setCreatedAt(dateTime);
        List<Product> productslist = new ArrayList<>(Arrays.asList(product, product2, product3));
        String category = "category";


        Mockito.when(productRepository.getProductsByCategory(category)).thenReturn(productslist);
        Mockito.when(converter.convertProductToProductDTO(product)).thenReturn(savedProductDTO);
        List<ProductDTO> savedProductList = productService.getProductByCategory(category, 2, 1);
        assertThat(savedProductList.size()).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void getProductCategoryWithException(){
        ProductDTO savedProductDTO = new ProductDTO.Builder()
                .name("name")
                .brand("brand")
                .category("category")
                .id("1111")
                .description("description")
                .tags(new ArrayList<>(Arrays.asList("tag1","tag2")))
                .createdAt(dateTime)
                .build();
        Product product = new Product();
        product.setName("shirt");
        product.setBrand("brand");
        product.setCategory("category");
        product.setId("1111");
        product.setDescription("description");
        product.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product.setCreatedAt(dateTime);
        Product product2 = new Product();
        product2.setName("shirt2");
        product2.setBrand("brand2");
        product2.setCategory("category2");
        product2.setId("1111");
        product2.setDescription("description2");
        product2.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product2.setCreatedAt(dateTime);
        Product product3 = new Product();
        product3.setName("shirt3");
        product3.setBrand("brand3");
        product3.setCategory("category");
        product3.setId("1111");
        product3.setDescription("description3");
        product3.setTags(new ArrayList<>(Arrays.asList("tag1","tag2")));
        product3.setCreatedAt(dateTime);
        String category = "category";


        Mockito.when(productRepository.getProductsByCategory(category)).thenThrow(new RuntimeException());
        Mockito.when(converter.convertProductToProductDTO(product)).thenReturn(savedProductDTO);
        productService.getProductByCategory(category, 2, 1);
    }
}
