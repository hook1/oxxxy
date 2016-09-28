package com.versus.oxxxy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.versus.oxxxy.model.User;
import com.versus.oxxxy.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}

	@Override
	@Transactional
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = UserNotFound.class)
	public User delete(int id) throws UserNotFound {
		User deletedShop = userRepository.findOne(id);

		if (deletedShop == null)
			throw new UserNotFound();

		userRepository.delete(deletedShop);
		return deletedShop;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = UserNotFound.class)
	public User update(User user) throws UserNotFound {
		User updatedUser = userRepository.findOne(user.getId());

		if (updatedUser == null)
			throw new UserNotFound();

		updatedUser.setNick_name(user.getNick_name());
		updatedUser.setFirst_name(user.getFirst_name());
		updatedUser.setLast_name(user.getLast_name());
		updatedUser.setE_mail(user.getE_mail());
		updatedUser.setPassword(user.getPassword());
		return updatedUser;
	}

}