/**
 * 
 */
package training.cdlibrary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author A&M
 * 
 */
public class Pw2TestCase {

	private static EntityManager em;

	private static EntityTransaction etx;

	private static EntityManagerFactory emf;
	

	/**
	 * This method run exactly once before all the test
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void oneTimeSetup() throws Exception {
		emf = Persistence
				.createEntityManagerFactory("CDLibrary");
	}

	/**
	 * This method run after all the test has run.
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void oneTimetearDown() throws Exception {
		emf.close();
	}

	/**
	 * This method run before each test in this class
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		etx = em.getTransaction();
		etx.begin();
	}

	/**
	 * This method run after each test in this class
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		etx.commit();
		em.close();
	}

	/**
	 * Test to create an Album entity
	 * 
	 */
	
	
	
	@Test
	public void testCreateAlbum() {
		Album theAlbum = new Album(125,"many moons",2015,"NewAge");
		em.persist(theAlbum);
		System.out.println("persited album is"+theAlbum);
	}
	
	@Test
	public void testUpdateAlbum() {
		Album albumToUpdate=em.find(Album.class, (long)125);
		albumToUpdate.setName("20MillionMoons");
		em.merge(albumToUpdate);
		System.out.println("updated album is"+albumToUpdate);
	}
	
	@Test
	public void testRemoveAlbum() {
		Album albumToDelete=em.find(Album.class, (long)125);
		System.out.println(albumToDelete);
		em.remove(albumToDelete);
		System.out.println("album now in unmanaged state");
	}
	
	// TODO create a test to update the album. After launch check the database.

	// TODO create a test to remove the album. After launch check the database.

}
