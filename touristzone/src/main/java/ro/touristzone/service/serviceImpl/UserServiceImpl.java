package ro.touristzone.service.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ro.touristzone.exception.UserExistsException;
import ro.touristzone.model.User;
import ro.touristzone.model.UserRole;
import ro.touristzone.repository.UserRepository;
import ro.touristzone.repository.UserRoleRepository;
import ro.touristzone.service.UserService;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
    UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRoleRepository userRoleRepo;

    // load user by username
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameAndIsConfirmedTrue(s);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getUserRoles());
    }

    // registration
    @Override
    public void registration(User user) throws UserExistsException {
        User oldUser = userRepo.findOneByUsername(user.getUsername());
        if(oldUser != null) {
            throw new UserExistsException();
        }

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRoleRepo.findById(1L).get());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setConfirmed(true);
        user.setUserRoles(userRoles);
        userRepo.save(user);
    }
}