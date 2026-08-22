package com.example.task_manager.repository;

import com.example.task_manager.domain.Task;
import com.example.task_manager.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // =========================================================================
    // 1. DERIVED QUERY METHOD (Derived Queries por Convenção de Nomes)
    // =========================================================================
    // O Spring Data JPA lê o nome do método "findByStatus" e cria o SELECT automaticamente.
    List<Task> findByStatus(TaskStatus status);

    // Exemplo com 2 campos e ordenação
    List<Task> findByStatusAndTitleContainingIgnoreCaseOrderByTitleAsc(TaskStatus status, String title);


    // =========================================================================
    // 2. JPQL (Java Persistence Query Language)
    // =========================================================================
    // Opera sobre o modelo de OBJETOS Java (Entidade 'Task' e atributos 'title'/'status'),
    // e NÃO sobre os nomes de tabelas e colunas SQL do banco.
    @Query("SELECT t FROM Task t WHERE t.status = :status AND LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Task> searchByStatusAndTitleJpql(@Param("status") TaskStatus status, @Param("keyword") String keyword);


    // =========================================================================
    // 3. NATIVE QUERY (SQL Nativo do Banco de Dados)
    // =========================================================================
    // Opera com SQL PURO do MySQL. Usa os nomes REAIS da tabela ('tasks') e das colunas ('status', 'title').
    // Exige a propriedade 'nativeQuery = true'.
    @Query(value = "SELECT * FROM tasks WHERE status = :statusStr AND title LIKE CONCAT('%', :keyword, '%')", nativeQuery = true)
    List<Task> searchByStatusAndTitleNative(@Param("statusStr") String statusStr, @Param("keyword") String keyword);
}