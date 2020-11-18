package com.springmvc.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
