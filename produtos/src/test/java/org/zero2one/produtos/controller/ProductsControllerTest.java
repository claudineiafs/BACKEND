package org.zero2one.produtos.controller;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zero2one.produtos.model.Product;
import org.zero2one.produtos.repository.ProductRepository;

import java.util.Optional;
import java.util.regex.Matcher;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerTest {

    @InjectMocks
    private ProductsController controller;

    @Mock
    private ProductRepository repository;

    @Test
    public void deleteTest() {
        String expectedValue = "50";
        controller.delete(expectedValue);
        Mockito.verify(repository).deleteById(expectedValue);
    }

    @Test
    public void create() {
        Product product = new Product();
        controller.create(product);
        Mockito.verify(repository).save(product);
    }

    @Test
    public void getByDescription(){
        String description = "Descrição";
        controller.get(description);
        Mockito.verify(repository).findAllByDescription(description);
    }

    public void getAll (){
        String description = null;
        controller.get(description);
        Mockito.verify(repository).findAll();
    }

    @Test
    public void getById() {
        String id = "55";

        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity responseEntity = controller.getById(id);

        Mockito.verify(repository).findById(id);

        Assert.assertThat(responseEntity.getStatusCode(), Matchers.equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void getByIdOk() {
        String id = "55";

        Product product = new Product();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(product));

        ResponseEntity responseEntity = controller.getById(id);

        Mockito.verify(repository).findById(id);

        Assert.assertThat(responseEntity.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
    }
}
