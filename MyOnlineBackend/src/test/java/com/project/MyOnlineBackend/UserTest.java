package com.project.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MyOnlineBackend.Dao.UserDao;
import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.User;

public class UserTest {
	private static AnnotationConfigApplicationContext context;
	static User user;
	static Address address;
	static UserDao userDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.MyOnlineBackend");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testAddUser() 
	{
		user = new User();
		user.setFirstName("Utsab");
		user.setLastName("Pramanik");
		user.setEmail("up@gmail.com");
		user.setContactNumber("8765540894");
		user.setRole("USER");
		user.setPassword("up@123");

		assertEquals("Error", true, userDao.addUser(user));

		address = new Address();
		address.setAddressLineOne("51/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near SBI Bank");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		address.setUserId(user.getId());
		assertEquals("Error", true, userDao.addAddress(address));

	}

}
