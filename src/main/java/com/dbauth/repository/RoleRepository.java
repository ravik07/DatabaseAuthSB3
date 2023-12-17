package com.dbauth.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbauth.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	
	Set<Role> findByRoleNameIn(Set<String> roles);

}
