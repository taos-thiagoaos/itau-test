package br.com.thiagoaos.testitau.service;

import br.com.thiagoaos.testitau.model.User;
import br.com.thiagoaos.testitau.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findTopFiveFollowers() {
        return this.repository.findTop5ByOrderByFollowersDesc();
    }
}
