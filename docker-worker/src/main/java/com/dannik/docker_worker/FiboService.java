package com.dannik.docker_worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FiboService {

    FiboRepository fiboRepository;

    @Autowired
    FiboService(FiboRepository fiboRepository){
        this.fiboRepository = fiboRepository;
    }

    @Transactional
    public void incrementFibo(){
       Fibo current = fiboRepository.findFirstBy();
       long prev = current.getPrevious();

       current.setPrevious(current.getVal());
       current.setVal(prev + current.getVal());

       fiboRepository.save(current);

    }


}
