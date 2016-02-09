package crowd.engine;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class InMemEngineStarter {
	public static void main(String[] args) {
		ProcessEngine processEngine = 
			ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration()
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
				.setJdbcUrl("jdbc:h2:mem:my-own-db;DB_CLOSE_DELAY=1000")
				.setAsyncExecutorEnabled(true)
				.setAsyncExecutorActivate(false)
				.buildProcessEngine();
		
		while(true);
	}
}
