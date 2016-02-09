package crowd.model.filter;

import java.io.File;
import java.util.ArrayList;

import crowd.model.interfaces.ContentFilter;

/**
 * <p>Basic implementation of a ContentFilter.
 * 
 * @author SaCsaba
 * @version 0.0.1
 * @since 0.0.1
 * */
public class BasicFileNameFilter implements ContentFilter {

	public static String allFiles = ".*";
	
	private String fileNameMask;
	private String[] filters;
	
	public BasicFileNameFilter(){
		
	}
	
	public BasicFileNameFilter(String filter){
		fileNameMask = filter;
		filters = filter.split(",");
	}
	
	/**
	 * Feltételezzük, hogy minden object egy file
	 * */
	@Override
	public Object[] filter(Object[] input) {
		if(allFiles.equals(fileNameMask)){
			return input;
		}
		
		ArrayList<Object> filteredList = new ArrayList<>();
		
		for(Object currFile : input){
			boolean usable = false;
			
			for(String currFilter : filters){
				if(((File)currFile).getName().endsWith(currFilter)){
					usable = true;
				}
			}
			
			if(usable){
				filteredList.add(currFile);
			}
			
		}			
		
		return filteredList.toArray();
	}

	public void setFileNameMask(String mask){
		fileNameMask = mask;
		filters = mask.split(",");
	}
	
	
}
