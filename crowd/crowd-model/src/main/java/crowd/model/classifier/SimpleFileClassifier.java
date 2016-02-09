package crowd.model.classifier;

import java.io.File;

import crowd.model.interfaces.ContentClassifier;

public class SimpleFileClassifier implements ContentClassifier{

	public enum FileType{
		
		PDF(1), XLSX(2), DOCX(3), TEXT(4), JPG(5), PNG(6), ZIP(7), OTHER(8); 
		
		private int val;
		
		private FileType(int v){
			val = v;
		}
		public int value(){
			return val;
		}
	}
	
	public SimpleFileClassifier(){
		
	}

	@Override
	public int classify(Object content) {

		File f = (File) content;
		
		String name = f.getName().toLowerCase();
		
		if(name.endsWith("PDF")){
			return FileType.PDF.value();
		}else if(name.endsWith("XLSX")){
			return FileType.XLSX.value();
		}else if(name.endsWith("DOCX")){
			return FileType.DOCX.value();
		}else if(name.endsWith("TXT")){
			return FileType.TEXT.value();
		}else if(name.endsWith("JPG")){
			return FileType.JPG.value();
		}else if(name.endsWith("PNG")){
			return FileType.PNG.value();
		}else if(name.endsWith("ZIP")){
			return FileType.ZIP.value();
		}else{
			return FileType.OTHER.value();
		}
	}
	
}
