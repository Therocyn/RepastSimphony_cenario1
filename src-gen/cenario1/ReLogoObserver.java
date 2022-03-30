package cenario1;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createCars(int number, Closure closure) {
		AgentSet<cenario1.relogo.Car> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Car");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Car){
				result.add((cenario1.relogo.Car)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createCars(int number) {
		return createCars(number,null);
	}

	/**
	 * Makes a number of uniformly fanned cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createOrderedCars(int number, Closure closure) {
		AgentSet<cenario1.relogo.Car> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Car");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Car){
				result.add((cenario1.relogo.Car)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createOrderedCars(int number) {
		return createOrderedCars(number,null);
	}

	/**
	 * Queries if object is a car.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a car
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public boolean isCarQ(Object o){
		return (o instanceof cenario1.relogo.Car);
	}

	/**
	 * Returns an agentset containing all cars.
	 * 
	 * @return agentset of all cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> cars(){
		AgentSet<cenario1.relogo.Car> a = new AgentSet<cenario1.relogo.Car>();
		for (Object e : this.getContext().getObjects(cenario1.relogo.Car.class)) {
			if (e instanceof cenario1.relogo.Car){
				a.add((cenario1.relogo.Car)e);
			}
		}
		return a;
	}

	/**
	 * Returns the car with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public cenario1.relogo.Car car(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof cenario1.relogo.Car)
			return (cenario1.relogo.Car) turtle;
		return null;
	}

	/**
	 * Returns an agentset of cars on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of cars on patch p
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsOn(Patch p){
		AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"car")){
			if (t instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of cars on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of cars on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsOn(Turtle t){
		AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"car")){
			if (tt instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of cars on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of cars on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cenario1.relogo.Car>();
		}

		Set<cenario1.relogo.Car> total = new HashSet<cenario1.relogo.Car>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(carsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(carsOn(p));
				}
			}
		}
		return new AgentSet<cenario1.relogo.Car>(total);
	}

	/**
	 * Makes a number of randomly oriented cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createCars(int number, Closure closure) {
		AgentSet<cenario1.relogo.Car> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Car");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Car){
				result.add((cenario1.relogo.Car)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createCars(int number) {
		return createCars(number,null);
	}

	/**
	 * Makes a number of uniformly fanned cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createOrderedCars(int number, Closure closure) {
		AgentSet<cenario1.relogo.Car> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Car");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Car){
				result.add((cenario1.relogo.Car)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> createOrderedCars(int number) {
		return createOrderedCars(number,null);
	}

	/**
	 * Queries if object is a car.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a car
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public boolean isCarQ(Object o){
		return (o instanceof cenario1.relogo.Car);
	}

	/**
	 * Returns an agentset containing all cars.
	 * 
	 * @return agentset of all cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> cars(){
		AgentSet<cenario1.relogo.Car> a = new AgentSet<cenario1.relogo.Car>();
		for (Object e : this.getContext().getObjects(cenario1.relogo.Car.class)) {
			if (e instanceof cenario1.relogo.Car){
				a.add((cenario1.relogo.Car)e);
			}
		}
		return a;
	}

	/**
	 * Returns the car with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public cenario1.relogo.Car car(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof cenario1.relogo.Car)
			return (cenario1.relogo.Car) turtle;
		return null;
	}

	/**
	 * Returns an agentset of cars on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of cars on patch p
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsOn(Patch p){
		AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"car")){
			if (t instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of cars on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of cars on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsOn(Turtle t){
		AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"car")){
			if (tt instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of cars on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of cars on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cenario1.relogo.Car>();
		}

		Set<cenario1.relogo.Car> total = new HashSet<cenario1.relogo.Car>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(carsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(carsOn(p));
				}
			}
		}
		return new AgentSet<cenario1.relogo.Car>(total);
	}

	/**
	 * Makes a number of randomly oriented enemies and then executes a set of commands on the
	 * created enemies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> createEnemies(int number, Closure closure) {
		AgentSet<cenario1.relogo.Enemy> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Enemy");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Enemy){
				result.add((cenario1.relogo.Enemy)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented enemies and then executes a set of commands on the
	 * created enemies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> createEnemies(int number) {
		return createEnemies(number,null);
	}

	/**
	 * Makes a number of uniformly fanned enemies and then executes a set of commands on the
	 * created enemies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> createOrderedEnemies(int number, Closure closure) {
		AgentSet<cenario1.relogo.Enemy> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Enemy");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Enemy){
				result.add((cenario1.relogo.Enemy)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned enemies and then executes a set of commands on the
	 * created enemies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> createOrderedEnemies(int number) {
		return createOrderedEnemies(number,null);
	}

	/**
	 * Queries if object is a enemy.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a enemy
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public boolean isEnemyQ(Object o){
		return (o instanceof cenario1.relogo.Enemy);
	}

	/**
	 * Returns an agentset containing all enemies.
	 * 
	 * @return agentset of all enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> enemies(){
		AgentSet<cenario1.relogo.Enemy> a = new AgentSet<cenario1.relogo.Enemy>();
		for (Object e : this.getContext().getObjects(cenario1.relogo.Enemy.class)) {
			if (e instanceof cenario1.relogo.Enemy){
				a.add((cenario1.relogo.Enemy)e);
			}
		}
		return a;
	}

	/**
	 * Returns the enemy with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public cenario1.relogo.Enemy enemy(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof cenario1.relogo.Enemy)
			return (cenario1.relogo.Enemy) turtle;
		return null;
	}

	/**
	 * Returns an agentset of enemies on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of enemies on patch p
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> enemiesOn(Patch p){
		AgentSet<cenario1.relogo.Enemy> result = new AgentSet<cenario1.relogo.Enemy>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"enemy")){
			if (t instanceof cenario1.relogo.Enemy)
			result.add((cenario1.relogo.Enemy)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of enemies on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of enemies on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> enemiesOn(Turtle t){
		AgentSet<cenario1.relogo.Enemy> result = new AgentSet<cenario1.relogo.Enemy>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"enemy")){
			if (tt instanceof cenario1.relogo.Enemy)
			result.add((cenario1.relogo.Enemy)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of enemies on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of enemies on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> enemiesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cenario1.relogo.Enemy>();
		}

		Set<cenario1.relogo.Enemy> total = new HashSet<cenario1.relogo.Enemy>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(enemiesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(enemiesOn(p));
				}
			}
		}
		return new AgentSet<cenario1.relogo.Enemy>(total);
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.UserTurtle){
				result.add((cenario1.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.UserTurtle){
				result.add((cenario1.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof cenario1.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> userTurtles(){
		AgentSet<cenario1.relogo.UserTurtle> a = new AgentSet<cenario1.relogo.UserTurtle>();
		for (Object e : this.getContext().getObjects(cenario1.relogo.UserTurtle.class)) {
			if (e instanceof cenario1.relogo.UserTurtle){
				a.add((cenario1.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public cenario1.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof cenario1.relogo.UserTurtle)
			return (cenario1.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<cenario1.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
			if (t instanceof cenario1.relogo.UserTurtle)
			result.add((cenario1.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<cenario1.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
			if (tt instanceof cenario1.relogo.UserTurtle)
			result.add((cenario1.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cenario1.relogo.UserTurtle>();
		}

		Set<cenario1.relogo.UserTurtle> total = new HashSet<cenario1.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<cenario1.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof cenario1.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserLink")
	public AgentSet<cenario1.relogo.UserLink> userLinks(){
		AgentSet<cenario1.relogo.UserLink> a = new AgentSet<cenario1.relogo.UserLink>();
		for (Object e : this.getContext().getObjects(cenario1.relogo.UserLink.class)) {
			if (e instanceof cenario1.relogo.UserLink){
				a.add((cenario1.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserLink")
	public cenario1.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (cenario1.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserLink")
	public cenario1.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}


}