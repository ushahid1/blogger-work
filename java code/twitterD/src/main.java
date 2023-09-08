import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class main {

	/**
	 * @param args
	 * @return 
	 * @throws Exception 
	 */
	
	public static void testCountHashTags(){
		String tweet = "#hello kia #bat#hay #uar kia ho #raha ha";
        List<String> hashtags = getHashtags(tweet);
//	count1++;
  // wordFile = new Scanner(dataArray[1]);
        System.out.println(hashtags.size() + "\n");
	}
	
	public static void testNumberOfWords(){
		String tweet = "#hello kia #bat#hay #uar kia ho #raha ha";
        int countOfWords = countWord(tweet);
//	count1++;
  // wordFile = new Scanner(dataArray[1]);
        System.out.println(countOfWords + "\n");
	}
	public static void testHashTagsPerWordsRatio(){
		String tweet = "#hello kia #bat #hay #uar kia ho #raha ha";
		float ratio = hashtagsPerWord(tweet);
		 System.out.println(ratio + "\n");
	}
	public static void testExtractorClass(){
		Extractor ex = new Extractor();
		
		String tweet = "Will #Feriha give #Emir a second chance?To know,watch #Feriha tonight at 7 PM To know more: http://bit.ly/FERIHA  ";
		//int numberOfHashTags = (ex.ex).size();
		List<String> hashtags = ex.extractURLs(tweet);
		
		for (String temp : hashtags) {
			System.out.println(temp + "\n");
		}
 
		
		
	}
	
	public static void replyTest(){
		String tweet = "@hello you are ok";
		boolean test = isReplyMessage(tweet);
		System.out.println(test);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		readFiles();
		//testNumberOfWords();
		//testHashTagsPerWordsRatio();
		//testExtractorClass();
		//replyTest();
	}
	
	public static int countWord(String word) {
		if (word == null) {
			return 0;
			} 
		String input = word.trim(); 
		int count = input.isEmpty() ? 0 : input.split("\\s+").length; return count;
		
	}
	
	public static float hashtagsPerWord(String tweet){
		
		
//		List<String> hashtags = getHashtags(tweet);
//        
//        int countOfWords = countWord(tweet);
////	count1++;
//  // wordFile = new Scanner(dataArray[1]);
//        //System.out.println(hashtags.size() + "\n");
//		float ratio = (float)hashtags.size()/(float)countOfWords;
//		
//		return ratio;
		Extractor ex = new Extractor();
		List<String> hashtags = ex.extractHashtags(tweet);
		 int countOfWords = countWord(tweet);
		 float ratio = (float)hashtags.size()/(float)countOfWords;
		return ratio;
		
	}
public static float urlsPerWord(String tweet){
		
		
//		List<String> hashtags = getHashtags(tweet);
//        
//        int countOfWords = countWord(tweet);
////	count1++;
//  // wordFile = new Scanner(dataArray[1]);
//        //System.out.println(hashtags.size() + "\n");
//		float ratio = (float)hashtags.size()/(float)countOfWords;
//		
//		return ratio;
		Extractor ex = new Extractor();
		List<String> urls = ex.extractURLs(tweet);
		 int countOfWords = countWord(tweet);
		 float ratio = (float)urls.size()/(float)countOfWords;
		return ratio;
		
	}
	
	public static int urlsInaTweet(String tweet){
		int numberOfUrls =0;
		Extractor ex = new Extractor();
		List<String> urls = ex.extractURLs(tweet);
		numberOfUrls = urls.size();
		return numberOfUrls;
	}
	public static int hashtagsInaTweet(String tweet){
		int numberOfHashtags =0;
		Extractor ex = new Extractor();
		List<String> urls = ex.extractHashtags(tweet);
		numberOfHashtags = urls.size();
		return numberOfHashtags;
	}
	public static int usersMentionedInaTweet(String tweet){
		int numberOfUsers =0;
		Extractor ex = new Extractor();
		List<String> urls = ex.extractMentionedScreennames(tweet);
		numberOfUsers = urls.size();
		return numberOfUsers;
	}
	public static boolean isReplyMessage(String tweet){
		boolean isReply= false;
		Extractor ex = new Extractor();
		String replyScreenName = ex.extractReplyScreenname(tweet);
		if (replyScreenName == null || replyScreenName.trim().equals("")){
			isReply=false;
			}
		else{
			isReply =true;
		}
		return isReply;
	}
	
	public static List<String> getHashtags(String tweet) {
        String[] words = tweet.split(" ");
        List<String> hashtags = new ArrayList<String>();
        for (String word : words) {
            if (word.startsWith("#")) {
                hashtags.add(word);
            }
        }
        return hashtags;
    }
	
	public static void readFiles()  throws Exception{
		// TODO Auto-generated method stub
		//Integer count1=0;
		//long startTime = System.currentTimeMillis();
		//for(int abc=0; abc<1000;abc++){
		File folder = new File("ProfileData/");
		File[] listOfFiles = folder.listFiles();
		
		
		float ratioOfHashtagsPerWords; 
		float averageRatioOfHashtagsPerWords;
		float sumRatioOfHashtagsPerWords;
		float sumUrlsPerWords;
		float averageUrlsperWords;
		float urlsperwords;
		float sumNumWords;
		float avgNumWords;
		float sumUrlsTweet;
		float avgUrlsTweet;
		float sumHashtagsTweet;
		float avgHashtagsTweet;
		int countUrls;
		float urlsFraction;
		String screenName="";
		 //TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );
		 //Scanner wordFile;
	      String word;     // A word read from the file
	      Integer count;   // The number of occurrences of the word
		
	      FileWriter saveFile = new FileWriter("maindata5.csv");
	      
	      saveFile.write("user,screenName,avgRatioOfHashtagsPerWords,avgUrlsPerWords,avgNumWords,avgUrlsPerTweet,avgHashtagsPerTweet,fractionOfUrls");
	      saveFile.write("\n");
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println(listOfFiles[i].getName());
		        //--------------Read the file
		        BufferedReader CSVFile = 
				        new BufferedReader(new FileReader("ProfileData/"+listOfFiles[i].getName()));
		        //frequencyData = new TreeMap<String, Integer>( );
		        // read the line from CSVFile
		        
		        saveFile.write(listOfFiles[i].getName());
		        
		        
		        count=0;
		        countUrls=0;
		        averageRatioOfHashtagsPerWords=0;
		        sumRatioOfHashtagsPerWords=0;
		        sumUrlsPerWords=0;
		        averageUrlsperWords=0;
		        sumNumWords=0;
		        avgNumWords=0;
		        sumUrlsTweet=0;
		        avgUrlsTweet=0;
		        sumHashtagsTweet=0;
		        avgHashtagsTweet=0;
		        urlsFraction=0;
		        screenName ="";
		        String dataRow = CSVFile.readLine(); // Read first line.
		        dataRow = CSVFile.readLine();// read the second line, first line is just headings
		        // Read all the 2nd column in all the lines
		        while (dataRow != null){
		        // separate the line based on ','
		        	String[] dataArray = dataRow.split(",");
		        	if(dataArray.length ==17){
		        	//System.out.println(dataArray[1] + "\n");
		        	
		        	try
		            {
		        			count++;
	        			String tweet = dataArray[1];
	        			if (screenName.equals(""))
		        	      screenName = dataArray[11];  
		        	        ratioOfHashtagsPerWords = hashtagsPerWord(tweet);
		        	        sumRatioOfHashtagsPerWords= sumRatioOfHashtagsPerWords + ratioOfHashtagsPerWords; 
//		        			 
		        	    urlsperwords =urlsPerWord(tweet);
		        	    sumUrlsPerWords = sumUrlsPerWords + urlsperwords;
		        		
		        		sumNumWords =sumNumWords + countWord(tweet);
		        			
		        		sumUrlsTweet=sumUrlsTweet + urlsInaTweet(tweet);	
		        		
		        		sumHashtagsTweet=sumHashtagsTweet + hashtagsInaTweet(tweet);
		        		
		        		if(urlsInaTweet(tweet)>0){
		        			countUrls++;
		        		}
		        		
		        		
		            }
		            catch (Exception e)
		            {
		      	 System.err.println(e);
		      	 return;
		            }
		        	
		        	
		        	} 
		        	 // read the next line
		        	 dataRow = CSVFile.readLine();
		        	 
		        	 
		        }
		        
		        if (count >0){
		        averageRatioOfHashtagsPerWords = sumRatioOfHashtagsPerWords/count;
		        averageUrlsperWords=sumUrlsPerWords/count;
		        avgNumWords =sumNumWords/count;
		        avgUrlsTweet =sumUrlsTweet/count;
		        avgHashtagsTweet = sumHashtagsTweet/count;
		        urlsFraction= (float)countUrls/count;
		        }
		        
		        saveFile.write("," + screenName + ","+averageRatioOfHashtagsPerWords + "," + averageUrlsperWords + "," + avgNumWords + "," + avgUrlsTweet + "," + avgHashtagsTweet + "," + urlsFraction+"," + countUrls+ "," + count);
		        saveFile.write("\n");
		        //System.out.println(averageRatioOfHashtagsPerWords + "\n");
//		        printAllCounts(frequencyData,listOfFiles[i].getName());
		        
		        
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		   // }
		}
		
		    saveFile.close();
		  //  	System.out.println(count1);
		   // printAllCounts(frequencyData);
		    	//long stopTime = System.currentTimeMillis();
		    	//long elapsedTime = stopTime - startTime;
		    	//System.out.println(elapsedTime);
		   
	}
}
