package kenneth.game.logic;

public class WorldTick extends Thread {

	public WorldTick() {
		
	}

	public WorldTick(Runnable target) {
		super(target);
	}

	public WorldTick(String name) {
		super(name);
	}

	public WorldTick(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public WorldTick(ThreadGroup group, String name) {
		super(group, name);
	}

	public WorldTick(Runnable target, String name) {
		super(target, name);
	}

	public WorldTick(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public WorldTick(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
	}

	@Override
	public void run() {
		super.run();
		
	}
	
	
	
}
