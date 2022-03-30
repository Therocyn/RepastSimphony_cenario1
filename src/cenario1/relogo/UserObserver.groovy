package cenario1.relogo

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

class UserObserver extends ReLogoObserver{

	/**
	 * Add observer methods here. For example:

		@Setup
		def setup(){
			clearAll()
			createTurtles(10){
				forward(random(10))
			}
		}
		
	 *
	 * or
	 * 	
	
		@Go
		def go(){
			ask(turtles()){
				left(random(90))
				right(random(90))
				forward(random(10))
			}
		}

	 */
	@Setup
	def setup(){
		
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
			
			
		}
		setDefaultShape(Enemy, "tankred")
		//setDefaultShape(Enemy, "truck")
		createEnemies(1){
			enemy(12).setxy(80, 50)
		}
		
		try {
			FileWriter myWriter = new FileWriter("/home/therocyn/mininet-wifi/examples/s2c2redes/Vinicius/test2_reading_File/data/coordenadas.txt");
			myWriter.write("tick,id,x,y\n");
			myWriter.close();
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	
	
	}
	
	@Go
	def go(){
		
		ask(cars()){
			step()
		}
		
		ask(enemies()){
			step()
		}
		sleep(2000) //milliseconds
	}
}
	
	

