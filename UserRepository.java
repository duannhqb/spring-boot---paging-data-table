package com.prographer.pagination.repository;

import com.prographer.pagination.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);
}
