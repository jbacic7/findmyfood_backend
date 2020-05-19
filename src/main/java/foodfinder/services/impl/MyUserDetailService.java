package foodfinder.services.impl;

import foodfinder.dto.MyUserDetails;
import foodfinder.dto.User;
import foodfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional <User> user = userRepository.findByUserName(username);

        user.orElseThrow(()-> new UsernameNotFoundException(username +  "Not found"));

        return user.map(MyUserDetails::new).get();

    }
}
