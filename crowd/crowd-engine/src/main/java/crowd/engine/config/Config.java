package crowd.engine.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>The Config class is a singleton loader for the CROWD engine.
 * <p>The config is loaded with Spring beans.
 * <p>
 * <p>
 * <p>
 * <p>Maaan, I hate Spring. I wouldn't use it, if it wasn't for all the dependencies 
 * given by Activiti. 
 * 
 * @author SaCsaba
 * @version 1.0.0.0
 * @since 1.0.0.0
 * 
 * */
public final class Config {

	private static Config config;
	private ApplicationContext context;
	
	/**
	 * The private constructor for the Config class.
	 * 
	 * Takes no arguments, rather creates a new Spring DI container from givan xml file.
	 * 
	 * */
	private Config() {
		context = new ClassPathXmlApplicationContext(new String[] {"crowd.engine.config.xml"});
	}
	
	/**
	 * Return the singleton instance of the application config.
	 * 
	 * @return The Config instance.
	 * */
	public static Config instance(){
		if(config == null){
			config = new Config();
		}
		return config;	
	}
	
	/**
	 * Returns the ApplicationContext constructed by Spring for the Config singleton.
	 * 
	 * @return	The application context container.
	 * */
	public ApplicationContext context(){
		return context;
	}
}
