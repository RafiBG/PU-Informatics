package fmi.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import fmi.models.AbstractCar;
import fmi.models.Catalogue;

public class DBOperations {
	
	public static ArrayList<String> readRowsFromFile(String path){
		
		ArrayList<String> rows = new ArrayList();
		
		try(BufferedReader br = Files.newBufferedReader(Paths.get(path))){
			
			rows = (ArrayList<String>) br.lines().collect(Collectors.toList());
			
		} catch (IOException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}	
		
		return rows;  		
	}//end readRowsFromFile()
	
	public static void writeCarsToFile(String path, ArrayList<AbstractCar> list) {
		
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))){
			
			for(AbstractCar car : list) {
				
				bw.write(car.toString());
				bw.newLine();
				
			}
			
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// end writeCarsToFile()

}// end class
