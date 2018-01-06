package com.dannik.docker_master;



import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FiboRepository extends CrudRepository<Fibo, Long> {


    Fibo findTop1ByOrderByIdDesc();


}
