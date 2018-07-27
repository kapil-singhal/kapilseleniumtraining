package trainingDemo;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DemoMarshalling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users user1 = new Users();
		user1.setUsername("mercury");
		user1.setPassword("mercury");
		user1.setType("Admin");
		
		Users user2 = new Users();
		user2.setUsername("mercury1");
		user2.setPassword("mercury1");
		user2.setType("normal user");
		
		Users user3 = new Users();
		user3.setUsername("kim");
		user3.setPassword("kim");
		user3.setType("normal user");
		
		ArrayList<Users> users = new ArrayList<Users>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		TestUsers testusers = new TestUsers();
		testusers.setUser(users);
		try {
			JAXBContext jaxb=JAXBContext.newInstance(TestUsers.class);
			Marshaller marsh=jaxb.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			marsh.marshal(testusers, new File("users.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
