package com.dannik.docker_worker;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.List;


public interface FiboRepository extends CrudRepository<Fibo, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Fibo findFirstBy();

}
