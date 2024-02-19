package com.devsuperior.movieflix.servicies;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.entities.enums.UserRole;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.servicies.exceptions.ForbiddenException;
import com.devsuperior.movieflix.servicies.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    // =>  Method to return logged user
    @Transactional(readOnly = true)
    public User authenticated(){
        try{
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.findByEmail(username);
        }
        catch(Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    // =>  Verify if user is member
    public void isMember(){
        User user = authenticated();
        if(!user.getRole().equals(UserRole.MEMBER)){
            throw new ForbiddenException("Access denied");
        }
    }

}
