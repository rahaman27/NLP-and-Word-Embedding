package fileReading;
import java.io.*;
import java.util.*;


public class WordFrequency {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> inverseCount = new HashMap<String, Integer>();
		
		
		try {			  
			  System.out.print("Enter number of files/file from which you want to read : ");
			  int n = sc.nextInt();
			  sc.nextLine();
			
			  String files[] = new String[n] ;
			  
			  
			  for(int i=0;i<n;i++)
			  {
				  System.out.print("Enter "+(i+1)+"th fileName : ");
				  files[i] = sc.nextLine();
			  }
			  
			  
			  for(int i=0;i<n;i++)
			  {
				  File readFile = new File("C:\\Users\\KRISH\\eclipse-workspace\\Project_4th_year\\src\\fileReading\\" + files[i] + ".txt");
				  if(!readFile.exists())
				  {
					  System.out.println("Reading File Doesn't exit");
				  }
				  
				  Scanner fs = new Scanner(readFile);
				 
				  Map<String, Integer> wordCount = new HashMap<String, Integer>();
	              while (fs.hasNext()) {
	                String word = fs.next();
	                if(!wordCount.containsKey(word))
	                {
	                	wordCount.put(word, 1);
	                }
	              }
	              
	              for (Map.Entry<String,Integer> it : wordCount.entrySet()) {
	            	    String key = it.getKey();
		                if(inverseCount.containsKey(key))
		                {
		                	inverseCount.put(key, inverseCount.get(key)+1);
		                }
		                else{
		                	inverseCount.put(key, 1);
		                }
	              }         
	              
	              fs.close();				  
			  }
			  
			  File Output = new File("C:\\Users\\KRISH\\eclipse-workspace\\Project_4th_year\\src\\fileReading\\output.txt");
			  FileWriter fw = new FileWriter(Output);   
              for (Map.Entry<String,Integer> it : inverseCount.entrySet()) {
                  String key = it.getKey();
                  int value = (it.getValue());
                  System.out.println(key+ " : " + value);
                  fw.write(key+ " : " + value + "\n");
              }
			  fw.close();

		}
		catch(IOException i) {
			System.out.println(i);
		}
	}

}