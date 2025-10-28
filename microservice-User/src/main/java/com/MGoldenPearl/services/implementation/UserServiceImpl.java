package com.MGoldenPearl.services.implementation;

import com.MGoldenPearl.repositories.IUserRepository;
import com.MGoldenPearl.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
