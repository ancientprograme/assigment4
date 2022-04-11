
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;


	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String toString() {
		return ("Upper left (" + x + "," + y + "), width:" + width + ", depth:" + depth );
	}
// Constructors
	// defaul no arg construtcot 
	public Plot() {
		this(0,0,1,1);
	}
	
	public Plot(Plot p) {
		this(p.getX(),p.getY(),p.getWidth(),p.getDepth());
	}
	
	public Plot(int x,int y, int width,int depth) {
		
		this.x = x;
		this.y = y;
		this.depth =depth;
		this.width = width;
	}

	public boolean overlaps(Plot plot) {
		int bottomLeft1X = x;
		int bottomLeft1Y = y;

		int topRight1X = x + width;
		int topRight1Y = y + depth;

		// Second rectangle 2 points
		int bottomLeft2X = plot.getX();
		int bottomLeft2Y = plot.getY();

		int topRight2X = plot.getX() + plot.getWidth();
		int topRight2Y = plot.getY() + plot.getDepth();

		
		if(bottomLeft1X < topRight2X) 
			if(topRight1X > bottomLeft2X)
				if(bottomLeft1Y < topRight2Y) 
					if(topRight1Y > bottomLeft2Y)
						return true;

		// Return false if it's not overlapping
		return false;
	}
	public boolean encompasses(Plot plot) {
		if ((plot.getX() >= x) && (plot.getY() >= y) 
				&& ((plot.getX() + plot.getWidth()) <= (x + width))
				&& ((plot.getY() +  plot.getDepth()) <= (y + depth))
				)
					return true;

			return false;
	}
	
	
	
	
	

}
