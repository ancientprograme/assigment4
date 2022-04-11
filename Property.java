
public class Property {

	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot Plot;
	
	
	

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public Plot getPlot() {
		return Plot;
	}
	public void setP(Plot Plot) {
		this.Plot = Plot;
	}
	
	public String toString() {
		return("Property name: "+ this.propertyName 
				+"\nLocated in "+ this.city
				+"\nBeloging to: "+this .owner
				+ "\nRent Amount is: "+ this.rentAmount+"\n");
	}
	
	// Constructors
	public 	Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0.0;
		Plot = new Plot();
	}
	
	// copy constructor
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		Plot=p.Plot;
	}
	
	public Property(String propertyName,String city,double rentAmount,String owner) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		Plot= new Plot();
	}
	
	
	public Property(String propertyName,String city,double rentAmount,String owner,int x,int y, int width, int depth) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		Plot= new Plot(x,y,width,depth);
	}
	
	
	
}
