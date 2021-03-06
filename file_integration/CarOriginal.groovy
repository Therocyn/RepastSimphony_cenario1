package cenario1.relogo


import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import repast.simphony.util.SimUtilities;

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
	
	SimUtilities ponto = new SimUtilities();
	
	def int dist, dist7
	static int distCarEnemy = 15
	def int xo, xo7
	def double xcoord, xcoord7
	def double ycoord, ycoord7
	
	def boolean flag = false, flag7= false
	def double color = blue()
	def int tickcount = 0
	
	def boolean ajuste2=false
	def step() {
		tickcount+=1
		def int myid= getWho()
		//label = myid
		//labelColor = black()
		distCarEnemy = car(11).distance(enemies())
		
		if(UserObserver.list.get(13)[1]=="0") {   //movimento geral pré ataque
			fd(0.5)
			
			//System.out.println(UserObserver.list.get(12)[1])
			
		}
		
		//carros da frente
		if(UserObserver.list.get(13)[1]=="1") {
			ask(car(8)){
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(296, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(296, 5)[0])
					fd(0.06)
				}
				ask(car(9)){
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(245, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(245, 5)[0])
					fd(0.06)
				}
				ask(car(10)){
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(279, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(279, 5)[0])
					fd(0.06)
				}
				ask(car(11)){
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(262, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(262, 5)[0])
					fd(0.06)
				}
		}
		//carros da frente
		
		//carros de tras
		if(car(3).distance(enemies())>=6 && distCarEnemy<10) { //movimento pelotao 1(o que vai por baixo)
			ask(car(0)){
				face(car(3))
				fd(0.3) //aproximação à 20m/s do pelotao de tras
			}
			ask(car(1)){
				face(car(3))
				fd(0.3)
			}
			ask(car(2)){
				face(car(3))
				fd(0.3)
			}
			
			ask(car(3)){
				if(flag==false) {
					dist = distance(enemies())
					xo = getXcor()
				}
				flag=true
				xcoord = getXcor()+0.3 //velocidade é o 0.3
				ycoord = 0.02*Math.pow(xcoord-(dist/2+xo),2)-0.02*Math.pow(dist/2, 2)+50  //p mudar o angulo tem q mudar oq multiplica o Math.pow
				
				
				setxy(xcoord, ycoord)
				
				
			}
		}
		
		if(distCarEnemy<10 && car(3).distance(enemies())<6) { //aproximação pós parabola
				ask(car(0)){														//176
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(201, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(201, 5)[0])
					fd(0.2)
				}
				ask(car(1)){														//194
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(212, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(212, 5)[0])
					fd(0.2)
					//System.out.printf("distanciaX: %f\ndistanciaY:%f\n",ponto.getPointFromHeadingAndDistance(6, 4)[0], ponto.getPointFromHeadingAndDistance(6, 4)[1])
				}
				ask(car(2)){														//211
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(224, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(224, 5)[0])
					fd(0.2)
				}
				ask(car(3)){														//228
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(234, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(234, 5)[0])
					fd(0.2)
				}
						
			}
		//carros de tras
		
		
		
		//carros do meio
			if(car(7).distance(enemies())>=6 && distCarEnemy<10) {  //movimento pelotão 2(o que vai por cima) em parabola
			ask(car(4)){
				face(car(7))
				fd(0.17)
			}
			ask(car(5)){
				face(car(7))
				fd(0.17)
			}
			ask(car(6)){
				face(car(7))
				fd(0.17)
			}
			
			ask(car(7)){
				if(flag7==false) {
					dist7 = distance(enemies())
					xo7 = getXcor()
				}
				flag7=true
				xcoord7 = getXcor()+0.19 //velocidade é o 0.11
				ycoord7 = -0.03*Math.pow(xcoord7-(dist7/2+xo7),2)+0.03*Math.pow(dist7/2, 2)+50  //p mudar o angulo tem q mudar oq multiplica o Math.pow
				setxy(xcoord7, ycoord7)
				//System.out.printf("x: %f, y: %f, distancia: %f\n",xcoord7, ycoord7, distance(enemies()))
			}
			}
			
			
			if(distCarEnemy<10 && car(7).distance(enemies())<6) { //aproximação pós parabola
				ask(car(4)){														//4
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(340, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(340, 5)[0])
					fd(0.2)
				}
				ask(car(5)){														//347
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(329, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(329, 5)[0])
					fd(0.2)
					//System.out.printf("distanciaX: %f\ndistanciaY:%f\n",ponto.getPointFromHeadingAndDistance(6, 4)[0], ponto.getPointFromHeadingAndDistance(6, 4)[1])
				}
				ask(car(6)){														//330
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(317, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(317, 5)[0])
					fd(0.2)
				}
				ask(car(7)){														//313
					facexy(enemy(12).getXcor()+ponto.getPointFromHeadingAndDistance(307, 5)[1], enemy(12).getYcor()+ponto.getPointFromHeadingAndDistance(307, 5)[0])
					fd(0.2)
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
