import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.FileCopyUtils;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.RelationOrganization;
import com.smbc.lad.dto.pipeline.USRegulatory;
import com.smbc.lad.dto.pipeline.USRegulatoryList;
//import com.smbc.lad.vo.BorrowerRating;
//import com.smbc.lad.vo.RatingFinancial;

public class JsonGenerate {

	public String getFileUploadJSON() {
		List<FileData> fileDataList = new ArrayList<FileData>();
		
		String fileUpload = "QmFzZTY0";
		FileData file1 = new FileData();
		file1.setPipelineId(1);
		file1.setFileName("FileName1");
		file1.setFileType("FileType1");
		file1.setFileExtension("FileExt1");
		file1.setFileBase64Data(fileUpload);
		//file1.setFileBase64Data(Base64.));
		
		FileData file2 = new FileData();
		file2.setPipelineId(2);
		file2.setFileName("FileName2");
		file2.setFileType("FileType2");
		file2.setFileExtension("FileExt2");
		file2.setFileBase64Data(fileUpload);
		
		fileDataList.add(file1);
		fileDataList.add(file2);
		
		RelationOrganization rel = new RelationOrganization();
		rel.setOrganizationSummary("org sum");
		rel.setRelationSummary("relsum");
		rel.setFileData(fileDataList);
		int[] filestoDelete = {1,2};
		rel.setFilesToDeleteIds(filestoDelete);
		
		USRegulatoryList ulList = new USRegulatoryList();
		USRegulatory ulr = new USRegulatory();
		ulr.setPipelineId(1);
		List<USRegulatory> alList = new ArrayList<USRegulatory>();
		alList.add(ulr);
		ulList.setUsRegulatoryList(alList);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(ulList);
		
		return jsonString;
	}
	
	public static void main(String args[]) {
		String[] uploadedFileNames = {"Filename1.txt","Test.pdf","mydoc.docx"};
		Gson gson = new Gson();
	    String jsonString = null;
	    
	    //BorrowerRating borrowerRating = new BorrowerRating();
		
		/*RatingFinancial rf = new RatingFinancial("12507","","G1a","G1b","Y","N","AAA","Positive","A1","Negative","1000",
										"SM","01/01/2020","SS","Y","02/02/2020","N","SNCRF","Y","N","Y","N","Y",
										"03/03/2020","N","Y","04/04/202","Y","Parent Notes");
		
		borrowerRating.setPrimaryBorrower(rf);
		
		List<RatingFinancial> rfList = new ArrayList<RatingFinancial>();
		rfList.add(rf);
		rfList.add(rf);
		
		borrowerRating.setSecondaryBorrower(rfList);
*/
	    String filePath="C:\\Projects\\LoanDigitization\\TutorialsPoint JavaScript.pdf";
	    
	    try {
	    	byte[] bytes = java.nio.file.Files.readAllBytes(Paths.get(filePath));
	    	String baseString = Base64.getEncoder().encodeToString(bytes);
	    	
	        jsonString = gson.toJson(uploadedFileNames);
	        JsonGenerate jg = new JsonGenerate();
	        System.out.println(jg.getFileUploadJSON());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
