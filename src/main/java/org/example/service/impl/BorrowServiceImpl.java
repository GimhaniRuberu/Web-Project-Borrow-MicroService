package org.example.service.impl;

import org.example.dto.Borrow;
import org.example.entity.BorrowEntity;
import org.example.repository.BorrowRepository;
import org.example.service.BorrowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowRepository repository;

    ModelMapper mapper;
    @Bean
    public void setup(){
        this.mapper=new ModelMapper();
    }
    @Override
    public void addBook(Borrow book) {
        BorrowEntity entity=mapper.map(book, BorrowEntity.class);
        repository.save(entity);
    }

    public List<BorrowEntity> getBook() {
       return (List<BorrowEntity>) repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Borrow getBookById(Long id) {
        Optional<BorrowEntity> byId = repository.findById(id);
        return mapper.map(byId, Borrow.class) ;
    }


}
