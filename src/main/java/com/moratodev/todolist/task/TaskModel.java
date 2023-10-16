package com.moratodev.todolist.task;

import lombok.Data;
import java.util.UUID;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "titulo", length = 50)
    private String title;

    @Column(name = "descricao")
    private String description;

    @Column(name = "inicio_da_tarefa")
    private LocalDateTime startAt;

    @Column(name = "fim_da_tarefa")
    private LocalDateTime endAt;

    @Column(name = "prioridade")
    private String priority;

    @Column(name = "id_usuario")
    private UUID userId;

    @CreationTimestamp
    @Column(name = "data_de_criacao")
    private LocalDateTime createdAt;

    
}
