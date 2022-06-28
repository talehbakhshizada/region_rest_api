package com.company.regionrestapi.service;

import com.company.regionrestapi.repository.exception.RegionAlreadyExistsException;
import com.company.regionrestapi.repository.exception.RegionNotFoundException;
import com.company.regionrestapi.model.Region;
import com.company.regionrestapi.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getAllRegions(String name) {

        if (name == null) {
            return regionRepository.findAll();
        } else {
            return regionRepository.findAllByName(name);
        }
    }

    public Region getRegionById(String id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("Region not found"));
    }

    public Region createRegion(Region region) {
        Optional<Region> regionByName = regionRepository.findByName(region.getName());
        if (regionByName.isPresent()) {
            throw new RegionAlreadyExistsException("Region already exists with name:" + region.getName());
        }
        return regionRepository.save(region);
    }

    public void updateRegion(String id, Region newRegion) {
        Region oldRegion = getRegionById(id);
        oldRegion.setName(newRegion.getName());
        regionRepository.save(oldRegion);
    }

    public void deleteRegion(String id) {
        regionRepository.deleteById(id);
    }
}
