package pl.cbl.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.cbl.entity.User;
import pl.cbl.repo.UserRepository;

public class UserConverter implements Converter<String, User> {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User convert(String str) {

		User user = userRepo.findOne(Long.parseLong(str));

		return user;
	}

}
