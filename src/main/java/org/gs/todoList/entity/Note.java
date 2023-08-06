package org.gs.todoList.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Note {
    private long id;
    private String title;
    private String content;
}