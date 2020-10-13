import com.santhosh.optum.UserServiceApplication;
import com.santhosh.optum.model.User;
import com.santhosh.optum.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class UsersRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Before
	public void before() {
		userRepository.deleteAll();
	}

	@Test
	public void saveUserTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		User user1 = userRepository.save(user);
		User response = userRepository.findById(user1.getUserid()).get();
		assertNotNull(response);
	}


	@Test
	public void saveMultipleUsersTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		userRepository.save(user);
		User user1 = new User();
		user1.setFirstName("Garrett");
		user1.setLastName("Miller");
		userRepository.save(user1);
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(u -> users.add(u));
		assertNotNull(users);
		assertEquals(users.size(),2);
	}
	
	
	@Test
	public void getUserTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		User user1 = userRepository.save(user);
		User response = userRepository.findById(user1.getUserid()).get();
		assertNotNull(response);
		assertEquals(user.getFirstName(), response.getFirstName());
		assertEquals(user.getLastName(), response.getLastName());
	}

	@Test
	public void getMultipleUsersTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		userRepository.save(user);
		User user1 = new User();
		user1.setFirstName("Garrett");
		user1.setLastName("Miller");
		userRepository.save(user1);
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(u -> users.add(u));
		assertEquals(users.size(),2);
		assertEquals(users.get(0).getFirstName(), user.getFirstName());
		assertEquals(users.get(0).getLastName(), user.getLastName());
		assertEquals(users.get(1).getFirstName(), user1.getFirstName());
		assertEquals(users.get(1).getLastName(), user1.getLastName());
	}


	@Test
	public void updateUserTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		userRepository.save(user);
		user.setFirstName("Miller");
		User user1 = userRepository.save(user);
		User response = userRepository.findById(user1.getUserid()).get();
		assertNotNull(response);
		assertEquals(response.getFirstName(), "Miller");
		assertEquals(response.getLastName(), user.getLastName());
	}

	@Test
	public void updateMultipleUsersTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		userRepository.save(user);
		user.setFirstName("Brandon");
		userRepository.save(user);
		User user1 = new User();
		user1.setFirstName("Garrett");
		user1.setLastName("Miller");
		userRepository.save(user1);
		user1.setFirstName("Rock");
		userRepository.save(user1);
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(u -> users.add(u));
		assertEquals(users.size(),2);
		assertEquals(users.get(0).getFirstName(), "Brandon");
		assertEquals(users.get(0).getLastName(), user.getLastName());
		assertEquals(users.get(1).getFirstName(), "Rock");
		assertEquals(users.get(1).getLastName(), user1.getLastName());
	}


	@Test
	public void deleteUserTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		User user1 = userRepository.save(user);
		User response = userRepository.findById(user1.getUserid()).get();
		assertNotNull(response);
		assertEquals(response.getFirstName(), "John");
		assertEquals(response.getLastName(), user.getLastName());
		userRepository.deleteById(user1.getUserid());
		assertFalse(userRepository.findById(user1.getUserid()).isPresent());
	}

	@Test
	public void deleteMultipleUsersTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		userRepository.save(user);
		User user1 = new User();
		user1.setFirstName("Garrett");
		user1.setLastName("Miller");
		userRepository.save(user1);
		userRepository.deleteAll();
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(u -> users.add(u));
		assertTrue(users.isEmpty());
	}
	
	
	
	
	
	
	
}
