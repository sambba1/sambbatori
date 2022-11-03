package com.samulitori.tori.domain;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends CrudRepository<Listing, Long> {
    Optional<Listing> findById(Long listing_id);
}
