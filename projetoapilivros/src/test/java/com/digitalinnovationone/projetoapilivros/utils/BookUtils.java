package com.digitalinnovationone.projetoapilivros.utils;

import com.digitalinnovationone.projetoapilivros.dto.request.BookDTO;
import com.digitalinnovationone.projetoapilivros.entity.Book;

public class BookUtils {
    
    private static final String NAME = "Ponto Pálido Azul";

    private static final String TYPE_BOOK = "Astronomia";

    private static final Long ID = 1l;

    private static final Integer NUMBER_PAGES= 236;

    public static BookDTO createFakeDTO(){

        return BookDTO.builder()
        .id(ID)
        .name(NAME)
        .typeBook(TYPE_BOOK)
        .numberPages(NUMBER_PAGES)
        .build();
    }

    public static Book createFakeEntity(){

        return Book.builder()
        .id(ID)
        .name(NAME)
        .typeBook(TYPE_BOOK)
        .numberPages(NUMBER_PAGES)
        .build();
    }

}
