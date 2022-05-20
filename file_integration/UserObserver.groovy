package cenario1.relogo

import com.opencsv.CSVReader;

import au.com.bytecode.opencsv.CSVWriter

import java.io.FileReader

import java.lang.Runnable

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.FileWriter;
import java.io.IOException;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import cenario1.ReLogoObserver;

class UserObserver extends ReLogoObserver implements Runnable{
	static List<String[]> list = new ArrayList<>();
	
	
		@Setup
	def setup(){
		
		UserObserver obj = new UserObserver();
		Thread thread = new Thread(obj);
		thread.start();
		
		
		clearAll()
		setDefaultShape(Car, "tankblue")
		createCars(12){
			
			car(0).setxy(9, 50)
			car(0).face(car(2))
			car(1).setxy(10, 50) 
			car(1).face(car(2))
			car(2).setxy(11, 50) //comandante
			car(2).face(car(3))
			car(3).setxy(12, 50)
			car(3).face(car(5))

			car(4).setxy(22, 50) 
			car(4).face(car(5))
			car(5).setxy(23, 50) //comandante
			car(5).face(car(6))
			car(6).setxy(24, 50)
			car(6).face(car(8))
			car(7).setxy(25, 50) 
			car(7).face(car(8))
			
			car(8).setxy(35, 50)
			car(8).face(car(9))
			car(9).setxy(36, 50)
			car(9).face(car(10))
			car(10).setxy(37, 50)
			car(10).face(car(11))
			car(11).setxy(38, 50)
			car(11).facexy(39, 50)
			
			car(0).setShape("tankblue")
			car(1).setShape("tankblue")
			car(2).setShape("tankblue")
			car(3).setShape("tankblue")
			
			car(4).setShape("tankyellow")
			car(5).setShape("tankyellow")
			car(6).setShape("tankyellow")
			car(7).setShape("tankyellow")
			
			car(8).setShape("tankpurple")
			car(9).setShape("tankpurple")
			car(10).setShape("tankpurple")
			car(11).setShape("tankpurple")
			
		}
		setDefaultShape(Enemy, "tankred")
		createEnemies(1){
			enemy(12).setxy(80, 50)
		}
		
		try {
			FileWriter myWriter = new FileWriter("/home/therocyn/mininet-wifi/examples/s2c2redes/Vinicius/test2_reading_File/data/coordenadas.txt");
			myWriter.write("tick,id,x,y\n");
			myWriter.close();
		  } catch (IOException e) {
			System.out.println("An error occurred.write");
			e.printStackTrace();
		  }
	
	}
	
	def void run(){
		boolean flagwrite = false
		while(true) {
		FileReader myreader = new FileReader("/home/therocyn/mininet-wifi/examples/s2c2redes/Vinicius/test2_reading_File/data/ataque.csv");
		CSVReader csvReader = new CSVReader(myreader);
		list = csvReader.readAll();
		myreader.close();
		csvReader.close();
		
		if(Car.distCarEnemy<=10 && flagwrite == false) {
			list.get(13)[1] = "1";
			FileWriter distwriter = new FileWriter("/home/therocyn/mininet-wifi/examples/s2c2redes/Vinicius/test2_reading_File/data/ataque.csv");
			CSVWriter csvWriter = new CSVWriter(distwriter);
			csvWriter.writeAll(list);
			
			distwriter.close();
			csvWriter.close();
			flagwrite=true
		}
		}
		//System.out.println(Car.distCarEnemy)
	}

	
	@Go
	def go(){
		ask(cars()){
			step()
		}
			
		ask(enemies()){
			step()
		}
		//sleep(2000) //milliseconds
	}
}
	
	

