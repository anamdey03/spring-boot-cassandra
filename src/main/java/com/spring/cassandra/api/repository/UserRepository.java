package com.spring.cassandra.api.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.spring.cassandra.api.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {

	@AllowFiltering
	public List<User> findByAgeGreaterThan(int age);

}
