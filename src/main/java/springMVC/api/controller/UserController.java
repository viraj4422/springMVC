package springMVC.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springMVC.api.entity.User;
import springMVC.api.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{userId}")
	public User findOne(@PathVariable("userId") String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{userId}")
	public void delete(@PathVariable("userId") String userId) {
		service.delete(userId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{userId}")
	public User update(@PathVariable("userId") String userId, @RequestBody User user) {
		return service.update(userId, user);
	}
}
