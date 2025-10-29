package com.MGoldenPearl.services.interfaces;

public interface IUserService {

    boolean existsById(Long id);

    String getUsernameById(Long userId);
}
