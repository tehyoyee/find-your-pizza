package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Servey;
import com.pizzaTest.demo.repository.servey.MemoryServeyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryServeyRepositoryTest {
    MemoryServeyRepository repository = new MemoryServeyRepository();

    @AfterEach
    public void afterEach(){
        repository.clearServey();
    }


    @Test
    void save(){
        Servey serveyA = new Servey("1", "9시 출근", "11시 출근");
        Servey serveyB = new Servey("2", "밥 못 먹기", "잠 못 자기");

        repository.save(serveyA);
        repository.save(serveyB);

        assertThat(serveyA).isNotSameAs(serveyB);
    }

    @Test
    void findById(){
        Servey servey1 = new Servey("1", "9시 출근", "11시 출근");
        Servey servey2 = new Servey("2", "밥 못 먹기", "잠 못 자기");

        repository.save(servey1);
        repository.save(servey2);

        Servey findResult = repository.findById(servey2.getQuestionId());
        assertThat(findResult).isEqualTo(servey2);
    }
}