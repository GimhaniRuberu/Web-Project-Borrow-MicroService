package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrow;
import org.example.entity.BorrowEntity;
import org.example.service.BorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
@CrossOrigin
public class BorrowController {
    //@Autowired
    final BorrowService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Borrow book){
    service.addBook(book);
}

    @GetMapping("/get")
    public Iterable<BorrowEntity> getBook(){
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
    public Borrow getBookBorrowId(@PathVariable Long id){
        return service.getBookById(id);
    }
}
