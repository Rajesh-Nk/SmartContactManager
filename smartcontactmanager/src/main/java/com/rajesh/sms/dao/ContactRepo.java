package com.rajesh.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.sms.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
