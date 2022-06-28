package com.company.regionrestapi.repository.exception;

public class RegionAlreadyExistsException extends RuntimeException{

    public RegionAlreadyExistsException(String msg){
        super(msg);
    }
}
