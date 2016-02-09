package crowd.model.reader;

import java.io.File;
import crowd.model.interfaces.ContentFilter;
import crowd.model.interfaces.ContentReader;

/**
 * <p>Represents a basic file reader, that processes an input folder, and generates a list of files
 * to be sent to a content filter.
 * 
 * @see com.csabee.content_classifier.ContentFilter
 * 
 * @author SaCsaba
 * @since 0.0.1
 * @version 0.0.1
 * 
 * */
public class BasicFileReader implements ContentReader {

	private ContentFilter contentFilter;
	
	/**
	 * Basic constructor.
	 * */
	public BasicFileReader(){
	}
	
	/**
	 * <p>Reads an array of files from a given sourcefolder. 
	 * <p>Applies a filter on the files, and returns the filtered array.
	 * 
	 * @see com.csabee.content_classifier.reader.ContentFilter
	 * 
	 * @author SaCsaba
	 * @since 0.0.1
	 * @version 0.0.1
	 * 
	 * @param	source		The source folder of files. 
	 * @param	filter		A filter to be applied on the input files.
	 * 
	 * @return	A list of <code>Object</code> objects.
	 * 
	 * */
	public Object[] readContent( String path ){
		
		if( path == null ){
			return null;
		}
		
		File f = new File(path);
		Object[] files = f.listFiles();
		
		files = contentFilter.filter(files);
		
		return files;
	}
	
	public ContentFilter getContentFilter(){
		return contentFilter;
	}
	
	public void setContentFilter(ContentFilter filter){
		contentFilter = filter;
	}
}
