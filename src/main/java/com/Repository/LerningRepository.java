package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.LerningProject;

@Repository
public interface LerningRepository extends JpaRepository<LerningProject,Long> {

}
