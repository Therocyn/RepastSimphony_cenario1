package cenario1;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoPatch extends BasePatch{

	/**
	 * Sprouts (makes) a number of new cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> sproutCars(int number, Closure closure) {
		AgentSet<cenario1.relogo.Car> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Car");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Car){
				result.add((cenario1.relogo.Car)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> sproutCars(int number) {
		return sproutCars(number,null);
	}

	/**
	 * Returns an agentset of cars from the patch of the caller.
	 * 
	 * @return agentset of cars from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"car")){
			if (t instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of cars on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of cars at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"car")){
			if (t instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cenario1.relogo.Car>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"car")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"car")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(cenario1.relogo.Car.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cenario1.relogo.Car)
			return (cenario1.relogo.Car) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> sproutCars(int number, Closure closure) {
		AgentSet<cenario1.relogo.Car> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Car");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Car){
				result.add((cenario1.relogo.Car)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new cars and then executes a set of commands on the
	 * created cars.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created cars
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> sproutCars(int number) {
		return sproutCars(number,null);
	}

	/**
	 * Returns an agentset of cars from the patch of the caller.
	 * 
	 * @return agentset of cars from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"car")){
			if (t instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of cars on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of cars at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Car")
	public AgentSet<cenario1.relogo.Car> carsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<cenario1.relogo.Car> result = new AgentSet<cenario1.relogo.Car>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"car")){
			if (t instanceof cenario1.relogo.Car)
			result.add((cenario1.relogo.Car)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cenario1.relogo.Car>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"car")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"car")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(cenario1.relogo.Car.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cenario1.relogo.Car)
			return (cenario1.relogo.Car) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new enemies and then executes a set of commands on the
	 * created enemies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> sproutEnemies(int number, Closure closure) {
		AgentSet<cenario1.relogo.Enemy> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Enemy");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.Enemy){
				result.add((cenario1.relogo.Enemy)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new enemies and then executes a set of commands on the
	 * created enemies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created enemies
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> sproutEnemies(int number) {
		return sproutEnemies(number,null);
	}

	/**
	 * Returns an agentset of enemies from the patch of the caller.
	 * 
	 * @return agentset of enemies from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> enemiesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cenario1.relogo.Enemy> result = new AgentSet<cenario1.relogo.Enemy>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"enemy")){
			if (t instanceof cenario1.relogo.Enemy)
			result.add((cenario1.relogo.Enemy)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of enemies on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of enemies at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.Enemy")
	public AgentSet<cenario1.relogo.Enemy> enemiesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<cenario1.relogo.Enemy> result = new AgentSet<cenario1.relogo.Enemy>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"enemy")){
			if (t instanceof cenario1.relogo.Enemy)
			result.add((cenario1.relogo.Enemy)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cenario1.relogo.Enemy>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"enemy")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"enemy")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(cenario1.relogo.Enemy.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cenario1.relogo.Enemy)
			return (cenario1.relogo.Enemy) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> sproutUserTurtles(int number, Closure closure) {
		AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof cenario1.relogo.UserTurtle){
				result.add((cenario1.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> sproutUserTurtles(int number) {
		return sproutUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<cenario1.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof cenario1.relogo.UserTurtle)
			result.add((cenario1.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cenario1.relogo.UserTurtle")
	public AgentSet<cenario1.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<cenario1.relogo.UserTurtle> result = new AgentSet<cenario1.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof cenario1.relogo.UserTurtle)
			result.add((cenario1.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cenario1.relogo.UserTurtle>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(cenario1.relogo.UserTurtle.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cenario1.relogo.UserTurtle)
			return (cenario1.relogo.UserTurtle) turtle;
		return null;
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
		for (Object e : this.getMyObserver().getContext().getObjects(cenario1.relogo.UserLink.class)) {
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
		return (cenario1.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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