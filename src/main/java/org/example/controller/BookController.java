package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class BookController{
    //@Autowired
    final BookService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
    service.addBook(book);
}

    @GetMapping("/get")
    public Iterable<BookEntity> getBook(){
        return service.getBook();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBook(@PathVariable Long id){
        if (service.deleteBook(id)){
            return "Deleted";
        }else{
            return "Not Deleted";
        }
    }
//    public ResponceEntity<String> deleteBook(@PathVariable Long id) {
//        return service.deleteBook(id)?
//                ResponseEntity.ok("Deleted"):
//                ResponseEntity.notFound().build();
//    }

    @GetMapping("search/{id}")
    public Book getBookId(@PathVariable Long id){
        return service.getBookById(id);
    }
}
