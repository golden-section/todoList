package org.gs.todoList.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "title", nullable = false)
    @Size(min = 3, max = 255)
    private String title;
    @Column(name = "content", length = 2000, nullable = false)
    private String content;
}