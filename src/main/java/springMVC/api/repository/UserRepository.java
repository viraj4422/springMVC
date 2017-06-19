package springMVC.api.repository;

import java.util.List;

import springMVC.api.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String userId);

	public User create(User user);

	public void delete(User user);

	public User update(User user);

	public User findByEmail(String emailId);
}
