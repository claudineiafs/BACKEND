package org.zero2one.produtos.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.zero2one.produtos.repository.TaskRepository;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @InjectMocks
    private TaskController controller;

    @Mock
    private TaskRepository repository;

    @Test
    public void deleteTest(){
        String expectedValue = "50";
        controller.delete(expectedValue);
        Mockito.verify(repository).deleteById(expectedValue);
    }

}
