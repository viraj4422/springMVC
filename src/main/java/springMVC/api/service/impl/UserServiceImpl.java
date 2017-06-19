package springMVC.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springMVC.api.entity.User;
import springMVC.api.exception.BadRequestException;
import springMVC.api.exception.NotFoundException;
import springMVC.api.repository.UserRepository;
import springMVC.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String userId) {
		User user = repository.findOne(userId);
		if (user == null) {
			throw new NotFoundException("User with id " + userId + " not found..");
		}
		return user;
	}

	@Override
	public User create(User user) {
		User usr = repository.findByEmail(user.getEmail());

		if (usr != null) {
			throw new BadRequestException("User with email-id " + user.getEmail() + " already exist..");
		}

		return repository.create(user);
	}

	@Override
	public void delete(String userId) {
		User usr = findOne(userId);
		if (usr == null) {
			throw new NotFoundException("User with id " + userId + " not found");

		}
		repository.delete(usr);
	}

	@Override
	public User update(String userId, User user) {
		User usr = repository.findOne(userId);
		if (usr == null) {
			throw new NotFoundException("User with id " + userId + " not found..");
		}
		return repository.update(usr);
	}

}
