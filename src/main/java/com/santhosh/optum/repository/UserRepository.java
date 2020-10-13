package com.santhosh.optum.repository;

import com.santhosh.optum.model.User;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository that generates CRUD API methods
 */
@Api(tags = "User Entity")
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
}
