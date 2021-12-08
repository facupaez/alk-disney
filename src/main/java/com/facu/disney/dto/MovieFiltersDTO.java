package com.facu.disney.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFiltersDTO {

    private String title;
    private Set<Long> genre;
    private String order;

    public MovieFiltersDTO(String title, Set<Long> genre, String order) {
        this.title = title;
        this.genre = genre;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
