
public class Elevator extends Provided.AbstractElevator{
	public Elevator(Provided.AbstractElevatorController c) {
		super(c);
	}

	/**
	 * Constructs and starts a thread running this elevator
	 */
	@Override
	public void start(){
		// TODO Auto-generated method stub
		thread= new Thread(this);
		thread.start();

	}
	/**
	 * Starts the elevator moving in the direction of 'floor'.
	 * The Person that pressed the button and hailed the elevator is passed
	 * in as Person 'p' and should be saved in the passenger field. 
	 * 
	 * 
	 */

	@Override
	public void hail(int floor, Provided.Person p) throws Provided.OccupiedException {
		// TODO Auto-generated method stub
		try {
			control.lock.lock();
			if(this.isAvailable()) {
				passenger= p;
				targetFloor=floor;
				carrying=false;
			}
			else
				throw new Provided.OccupiedException("The Elevator is not Avalailable");
		}
		finally {
			control.lock.unlock();
		}
	}
	/**
	 * Checks if the elevator is available to be hailed when there are no passengers
	 */
	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		
		if (passenger==null) {
			return !carrying;
		}
		else
			return false;
	}

	/**
	 * Passenger boards the elevator and The elevator is now carrying someone.
	 * The elevators now starts moving to the passengers destination.
	 */
	@Override
	protected void pickUp() {
		// TODO Auto-generated method stub
		passenger.board(this);
		this.carrying=true;
		this.targetFloor=passenger.getDestination();
	}

	/**
	 * Checks to see if the elevator should open its doors and pick up 'passenger'.
	 * Happens only when there there are passengers and the the elevator is already at the target floor
	 * and when it is carrying someone.
	 * 
	 */
	@Override
	protected boolean shouldPickUp() {
		// TODO Auto-generated method stub
		
		return passenger!= null && this.targetFloor== this.getFloor() && !carrying;
	}

	/**
	 * Make sure to call the passenger's exit method and then offloads
	 * the passenger so there are no passengers and it is no longer carrying anyone.
	 * Also Signals that the the elevator has finished.
	 */
	@Override
	protected void offload() {
		control.lock.lock();
		try {
		passenger.exit();
		passenger= null;
		carrying=false;
		this.control.elevatorFinished.signalAll();
		}
		finally {
			control.lock.unlock();

		}

	}

	/**
	 * Returns true if the elevator can offload its passenger and should only happen
	 * when there are passengers in the elevator and when the current floor of the
	 * elevator is at the passenger's destination.
	 */
	@Override
	protected boolean shouldOffload() {
		if (this.passenger == null) {
			return false;
		}
		else if (this.getFloor()== passenger.getDestination()) {
			return (carrying);
		}
		return false;
	}



}