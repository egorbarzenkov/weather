package com.example.repos;

import com.example.domain.History;
import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepo extends CrudRepository<History, Long> {

    Iterable<History> findDistinctByUser(User user);
}
