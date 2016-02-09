package crowd.model.interfaces;

/**
 * <p>A content filter represents a basic filter, that is applied to the input content mass. 
 *  
 * @author SaCsaba
 * @version 0.0.1
 * @since 0.0.1
 * */
public interface ContentFilter {

	public Object[] filter(Object[] input);
	
}
