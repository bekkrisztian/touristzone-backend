package ro.touristzone.service;

import org.springframework.stereotype.Service;

import ro.touristzone.exception.UserExistsException;
import ro.touristzone.model.User;

@Service
public interface UserService {

	// user registration
	public void registration(User user) throws UserExistsException;
}
