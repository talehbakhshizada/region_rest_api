package com.company.regionrestapi.repository.exception;

public class RegionNotFoundException extends RuntimeException{
    public RegionNotFoundException(String msg){
        super(msg);
    }
}
