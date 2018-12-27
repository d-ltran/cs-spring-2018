
public class Button extends Provided.AbstractButton{
	/** A contructor for the button class.
	 * @param floor the floor the button is on
	 * @param control the controller for this button
	 * 
	 */
	
	public Button(int floor, Provided.AbstractElevatorController control) {
		super(floor, control);
	}
	/**
	 * Called when the button is pressed. Make sure to notify the controller
	 * by calling request() <br><br>
	 * 
	 * The Person parameter is constructed and passed in by the provided code
	 * and is used to verify that your system works, so you must make sure not
	 * to loose the reference to it. It should be passed to the controller through
	 * the request method, and it should then be passed to the Elevator through the
	 * hail method. This way, the Elevators can call 'board' and 'exit' on the 
	 * provided Person objects, thereby passing the tests.
	 * 
	 * @param p, the person that pressed the button.
	 */

	@Override
	protected void press(Provided.Person p) {
		if(p!=null) {
			try {
				this.control.lock.lock();
				control.request(floor, p);
				this.control.buttonPressed.signalAll();	
			}
			finally {
				this.control.lock.unlock();
			}

		}
	}
}
