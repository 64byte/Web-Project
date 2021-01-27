package com.story.backend.address.repository;

import com.story.backend.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByAddressId(UUID addressId);
    void deleteByAddressId(UUID addressId);
}
