package crowd.processes;

import java.io.File;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SimpleFileLister implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
//		String var = (String) execution.getVariable("input");
//		var = var.toUpperCase();
//		execution.setVariable("input", var);
		
		String var = (String) execution.getVariable("folder");
				
		File folder = new File(var);
		
		if(!folder.exists()){
			execution.setVariable("error", "folder doesn't exist: " + var);
		}else{
			String[] files = folder.list();
			
			for( String f : files ){
				System.out.println(f);
			}
		}
			
	}

}
