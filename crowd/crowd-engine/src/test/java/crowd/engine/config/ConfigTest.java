package crowd.engine.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import crowd.model.interfaces.ContentReader;

public class ConfigTest {

	private ApplicationContext context;

	@Before
	public void init(){
		context = Config.instance().context();
	}
	
	@Test
	public void testConfig(){
		ContentReader reader = context.getBean("contentReader", ContentReader.class);
		
		assertNotNull(reader.getContentFilter());
	}
	
}
