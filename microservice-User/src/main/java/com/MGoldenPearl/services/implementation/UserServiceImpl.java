package com.MGoldenPearl.services.implementation;

import com.MGoldenPearl.entities.UserEntity;
import com.MGoldenPearl.repositories.IUserRepository;
import com.MGoldenPearl.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public String getUsernameById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);

        if (user == null) throw new RuntimeException("User not found");

        return user.getName() +" "+user.getLasName();
    }
}
