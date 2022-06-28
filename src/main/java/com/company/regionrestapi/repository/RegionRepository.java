package com.company.regionrestapi.repository;

import com.company.regionrestapi.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends MongoRepository<Region,String> {
    List<Region> findAllByName(String name);

    Optional<Region> findByName(String name);
}
