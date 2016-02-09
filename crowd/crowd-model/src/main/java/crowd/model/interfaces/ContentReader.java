package crowd.model.interfaces;

/**
 * <p>This interface represents a basic content reader. A content reader defines how the 
 * application reads input files to be read. 
 * <p>The source of input files can be a file folder, a content manager, and so on.
 * 
 * @author SaCsaba
 * @version 0.0.1
 * @since 0.0.1
 *  
 * */
public interface ContentReader {

	/**
	 * <p>Reads an array of files from a given source. 
	 * <p>Applies a filter on the files, and returns the filtered array.
	 * 
	 * @see com.csabee.content_classifier.reader.ContentFilter
	 * 
	 * @author SaCsaba
	 * @since 0.0.1
	 * @version 0.0.1
	 * 
	 * @param	source		The source of the files, it can be a filepath, or a content manager. 
	 * @param	filter		A filter to be applied on the input files-
	 * 
	 * @return	A list of <code>File</code> objects.
	 * 
	 * */
	
	public Object[] readContent( String source );
	
	public ContentFilter getContentFilter();
	
}
