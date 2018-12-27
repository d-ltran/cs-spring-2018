/**
	 * A class that extends the AbstractElevatorController class
	 * 
	 * Implements the run() method, and it waits for button presses 
	 * and available elevators, dispatching elevators (by calling AbstractElevator's
	 *  'hail' method) when possible. <br><br>
	 *  
	 *  Lock and Conditions are provided.
	 * 
	 *
	 */
public class ElevatorController extends Provided.AbstractElevatorController{
	/**
	 * The constructor for the Elevator Controller
	 *
	 */
	
	public ElevatorController() {
		super();

	}
	/**
	 * A helper method to see if there are available elevators and if there are it will return that 
	 * next available elevator otherwise it returns a null.
	 *
	 */
	private Provided.AbstractElevator nextAvailableElevator() {
		for (Provided.AbstractElevator e : this.elevators) {
			if (e.isAvailable()) {
				return e;
			}
		}
		return null;
	}
	
	/**Overrides the run() method and 
	 *Implements a while loop to see if there Provided has terminated. If it has not terminated than
	 *it will keep running on with this code.
	 */
	@Override
	public void run() {
		while (!Provided.TERMINATE) {
			running();
		}
	}
	/**
	 * Wait for pressed buttons and available elevators by calling 'await'
	 * on the two corresponding Condition objects. When possible, assigns an 
	 * Elevator to a waiting person by calling Elevator's 'hail' method. <br><br>
	 * It then hails the next available elevator to the next person in the queue and 
	 * to the next floor int the queue.
	 */
	public void running() {
		try {
			this.lock.lock();
			while (floorQueue.isEmpty()) {
				buttonPressed.await();
			}
			while(nextAvailableElevator()==null) {
				elevatorFinished.await();
			}
			try {
					int floornum= floorQueue.remove();
					Provided.Person p= personQueue.remove();
					nextAvailableElevator().hail(floornum, p);
			}
			catch (Provided.OccupiedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			this.lock.unlock();
		}
	}
}
