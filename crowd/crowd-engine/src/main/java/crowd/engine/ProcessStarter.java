package crowd.engine;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

public class ProcessStarter {
	public static void main(String[] args) {
		
		ProcessEngine processEngine = 
				ProcessEngineConfiguration
					.createStandaloneInMemProcessEngineConfiguration()
					.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
					.setJdbcUrl("jdbc:h2:mem:my-own-db;DB_CLOSE_DELAY=1000")
					.setAsyncExecutorEnabled(true)
					.setAsyncExecutorActivate(false)
					.buildProcessEngine();
		
//		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
//				.buildProcessEngine();

		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		// Deploy the process definition
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("simple.lister.bpmn").deploy();

		
		Map<String, Object> variables = new HashMap<>();
		variables.put("folder", "d:\\temp");
		// Start a process instance
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("myProcess", variables);
		
		
		while(true);
	}
}
