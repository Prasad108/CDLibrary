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

import training.cdlibrary.Album;

/**
 * @author A&M
 * 
 */
public class Pw1TestCase {

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
		
		Album theAlbum = new Album(1,"Prasad",1994,"q");
		/*theAlbum.setId(1);
		theAlbum.setName("Prasad");
		theAlbum.setType("1");
		theAlbum.setYear(1994);*/
		em.persist(theAlbum);
	}
}
