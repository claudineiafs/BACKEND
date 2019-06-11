package org.zero2one.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zero2one.produtos.model.Task;

import java.util.Collection;


@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Collection<Task> findAllByDescription(String description);
}
