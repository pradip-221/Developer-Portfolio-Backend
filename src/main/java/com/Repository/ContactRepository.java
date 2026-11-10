package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

}
