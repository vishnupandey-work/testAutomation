package sampleProject;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         //String S = br.readLine();
         String S = "xyz abc mnp \"asdf dfaa asdf\" asd \"fdas asdsdafF\"";
        System.out.println(S);
         String[] out_ = tokenize_string(S);
         for (int i_out_ = 0; i_out_ < out_.length; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }

         wr.close();
         //br.close();
    }
    static String[] tokenize_string(String S){
       // Write your code here
       String[] first =  S.split(" \"");
       StringBuilder temp = new StringBuilder();
       ArrayList<String> outputList = new ArrayList<String>();
       boolean flag = false;
       //String temp[] = new String[]();
       for(String elem:first) {
    	   //System.out.println(elem);
    	   if(elem.contains("\" ")){
    		   for(String value : elem.split("\"")) {
    			   if( value.startsWith(" ")){
    				   outputList.add(value);
    			   }
    			   else  temp.append(value);
    		   }
    		   outputList.add(temp.toString());
    	   }
    	   else for(String value : elem.split(" ")) {
    		   	outputList.add(value);
    	   }
       }
    for(String elem :outputList )	   {
    	System.out.println(elem);
    }
    
       String[] output = (String[]) outputList.toArray();
       return output;
    
    }
}