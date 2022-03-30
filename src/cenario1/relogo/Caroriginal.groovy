package cenario1.relogo


import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import java.lang.Math
import cenario1.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

@Plural("Cars")
class Car extends ReLogoTurtle {
	def int dist, dist7
	def int xo, xo7
	def double xcoord, xcoord7
	def double ycoord, ycoord7
	
	def boolean flag = false, flag7= false
	def double color = blue()
	def int tickcount = 0
	
	def boolean ajuste= false, ajuste2=false
	
	def step() {
		tickcount+=1
		def int myid= getWho()
		label = myid
		def int distCarEnemy = car(11).distance(enemies())
		
		if(distCarEnemy>=10) {   //movimento geral pré ataque
			fd(0.15)
		}
		
		
		//carros da frente
		if(distCarEnemy<10 && car(8).distance(enemies())>=5) {
			ask(car(8)){
				face(patchAtHeadingAndDistance(80, 10)) //angulo começa no eixo Y em direção horária
				fd(0.05)
			}
		}
		if(distCarEnemy<10 && car(9).distance(enemies())>=5) {
			ask(car(9)){
				face(patchAtHeadingAndDistance(100, 10))
				fd(0.05)
			}
		}
		if(distCarEnemy<10 && car(10).distance(enemies())>=5) {
			ask(car(10)){
				face(patchAtHeadingAndDistance(85, 10))
				fd(0.05)
			}
		}
		if(distCarEnemy<10 && car(11).distance(enemies())>=5) {
			ask(car(11)){
				face(patchAtHeadingAndDistance(95, 10))
				fd(0.05)
			}
		}
		//carros da frente
		
		//carros de tras
		if(car(3).distance(enemies())>=5 && distCarEnemy<10) { //movimento pelotao 1(o que vai por baixo)
			ask(car(0)){
				face(car(3))
				fd(0.2) //aproximação à 20m/s do pelotao de tras
			}
			ask(car(1)){
				face(car(3))
				fd(0.2)
			}
			ask(car(2)){
				face(car(3))
				fd(0.2)
			}
			
			ask(car(3)){
				if(flag==false) {
					dist = distance(enemies())
					xo = getXcor()
				}
				flag=true
				xcoord = getXcor()+0.2 //velocidade é o 0.2
				ycoord = 0.02*Math.pow(xcoord-(dist/2+xo),2)-0.02*Math.pow(dist/2, 2)+50  //p mudar o angulo tem q mudar oq multiplica o Math.pow
				
				
				setxy(xcoord, ycoord)
				
				
			}
		}
		
		if(car(0).distance(enemies())>=5 && distCarEnemy<10 && car(3).distance(enemies())<5) { //aproximação pós parabola
			ask(car(0)){
				face(patchAtHeadingAndDistance(96, 10))
				fd(0.12)
			}
		}
		if(car(0).distance(enemies())<5 && ajuste2==false) { 
			ajuste2=true
			ask(car(0)){
				fd(0.12)
			}
		}
		/*if(car(0).distance(enemies())<6) {
			ask(car(0)){
				facexy(enemy(12).getPxcor()+1, enemy(12).getPycor()+4)
				fd(0.1)
			}
		}*/
		
		if(car(1).distance(enemies())>=5 && distCarEnemy<10 && car(3).distance(enemies())<5) {
			ask(car(1)){
				face(patchAtHeadingAndDistance(98, 10))
				fd(0.12)
			}
		}
		if(car(2).distance(enemies())>=5 && distCarEnemy<10 && car(3).distance(enemies())<5) {
				ask(car(2)){
					face(patchAtHeadingAndDistance(92, 10))
					fd(0.11)
				}
		}
		//carros de tras
		
		
		
		//carros do meio
			if(car(7).distance(enemies())>=5 && distCarEnemy<10) {  //movimento pelotão 2(o que vai por cima) em parabola
			ask(car(4)){
				face(car(7))
				fd(0.11)
			}
			ask(car(5)){
				face(car(7))
				fd(0.11)
			}
			ask(car(6)){
				face(car(7))
				fd(0.11)
			}
			
			ask(car(7)){
				if(flag7==false) {
					dist7 = distance(enemies())
					xo7 = getXcor()
				}
				flag7=true
				xcoord7 = getXcor()+0.11 //velocidade é o 0.11
				ycoord7 = -0.04*Math.pow(xcoord7-(dist7/2+xo7),2)+0.04*Math.pow(dist7/2, 2)+50  //p mudar o angulo tem q mudar oq multiplica o Math.pow
				setxy(xcoord7, ycoord7)
				System.out.printf("x: %f, y: %f, distancia: %f\n",xcoord7, ycoord7, distance(enemies()))
			}
			}
			
			
			if(car(4).distance(enemies())>=5 && distCarEnemy<10 && car(7).distance(enemies())<5) { //aproximação pós parabola
				ask(car(4)){
					face(patchAtHeadingAndDistance(83, 10))
					fd(0.11)
				}
			}
			
			if(car(4).distance(enemies())<5 && ajuste==false) {
				ajuste=true
				ask(car(4)){
					fd(0.12)
				}
			}
			if(car(5).distance(enemies())>=5 && distCarEnemy<10 && car(7).distance(enemies())<5) {
				ask(car(5)){
					face(patchAtHeadingAndDistance(82, 10))
					fd(0.11)
				}
			}
			if(car(6).distance(enemies())>=5 && distCarEnemy<10 && car(7).distance(enemies())<5) {
					ask(car(6)){
						face(patchAtHeadingAndDistance(87, 10))
						fd(0.11)
					}
			}
			//carros do meio
					
			try {
				FileWriter myWriter = new FileWriter("/home/therocyn/mininet-wifi/examples/s2c2redes/Vinicius/test2_reading_File/data/coordenadas.txt", true);
				myWriter.write((int)tickcount+","+getWho()+","+getPxcor()+","+getPycor()+"\n");
				myWriter.close();
			  } catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			  }
			
			
			
			
			
			
			
			
			
			
	}
	
}
