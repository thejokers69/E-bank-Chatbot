package org.mundiapolis.ebankchatbot.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T>{
    private List<T> content;
    private int totalPages;
    private Long totalElements;
}
