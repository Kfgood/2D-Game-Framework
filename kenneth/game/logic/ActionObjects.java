package kenneth.game.logic;

import kenneth.game.logic.entity.Entity;

/**Anything that has a tick event<br>
 * Will be useful when telling the difference between different objects in the world map*/ 
public interface ActionObjects {
	
	public void update();

	public void collision(Entity e);
	
}
