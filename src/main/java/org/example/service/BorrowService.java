package org.example.service;

import org.example.dto.Borrow;
import org.example.entity.BorrowEntity;

import java.util.List;

public interface BorrowService {

    void addBook(Borrow book);

    List<BorrowEntity> getBook();

    boolean deleteBook(Long id);


    Borrow getBookById(Long id);
}
