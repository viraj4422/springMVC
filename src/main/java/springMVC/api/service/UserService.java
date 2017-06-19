package springMVC.api.service;


import java.util.List;

import springMVC.api.entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User findOne(String userId);

	public User create(User user);

	public void delete(String userId);

	public User update(String userId, User user);

}
