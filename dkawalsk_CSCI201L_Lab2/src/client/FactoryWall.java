package client;

import client.Constants;
import client.Factory;
import client.FactoryNode;
import client.FactoryObject;

public class FactoryWall extends FactoryObject {
	public static final long serialVersionUID = 1L;
	
	int width, height;
	
	public FactoryWall(int x, int y) {
		super(Constants.wallString, "Wall" + Constants.png, x, y);
	}
	
//	public void createNodes() {
//		mFNodes = new FactoryNode[width][height];
//		for (int y = 0; y < height; y++) {
//			for (int x = 0; x < width; x++) {
//				mFNodes[x][y] = new FactoryNode(x, y);
//				mFObjects.add(mFNodes[x][y]);
//			}
//		}
//	}
}
