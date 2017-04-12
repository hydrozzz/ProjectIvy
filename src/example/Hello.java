package example;

import org.apache.commons.lang.WordUtils;
import java.util.List;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Hello {
    public static void main(String[] args) {
        String  message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
        							+ " : " + WordUtils.capitalizeFully(message));

        int monmax = 0;
        int tmp = 0;

        try {
        	CSVReader reader = new CSVReader (new FileReader ("data.csv"));

        	try {
        		List<String []> myEntries = reader.readAll();
        		monmax = Integer.parseInt(myEntries.get(0)[0]);
                for(String[] entries : myEntries) {
    		    	
    		    	for (String i : entries) {
        		    	System.out.println(i);
        		    	tmp = Integer.parseInt(i);
        		    	if(tmp > monmax) {
        		    		monmax = tmp;
    		    		}
        		    }
        		}
        	}
        	catch(IOException e) {
        		System.out.println("Problème lecture nombres");
        	}
        }
       	catch(FileNotFoundException e) {
       		System.out.println(e.getMessage());
       	}

       	System.out.println("Maximum = " + monmax);

    }
}
        