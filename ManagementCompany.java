
public class ManagementCompany {

	private final int MAX_PROPERTY =5;
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	
	private double mgmFeePer;
	private String  name;
	private Property[] properties;
	private String taxID;
	private Plot plot;
	
	
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Property[] getProperties() {
		return properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}

	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}

	public int addProperty(Property property) {
	    if (property == null) {
	      return -2;
	    }
	   
	    if (!plot.encompasses(property.getPlot())) {
	        return -3;
	    }
	  
	    for (int i = 0;i < properties.length;i++) {
	      if (properties[i] != null) {
	        if (properties[i].getPlot().overlaps(property.getPlot())) {
	          return -4;
	        }
	      } else {
	        properties[i]=property;
	        return i;
	      } 
	    }
	      return -1;
	  }
	
	public int addProperty(String name,String city,double rent,String owner)
	{
		 return addProperty(new Property(name, city, rent, owner));
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	  }
	
	
	// adds all the rents together 
	public double totalRent() {
	    double rentTotal = 0;
	    
	    for (int i=0;i<properties.length;i++) {
	      
	    	if (properties[i]==null) {
	        break;
	      }
	      rentTotal += properties[i].getRentAmount();
	    }
	    return rentTotal;
	  }
	
	// looks through the array and give the location of the property with the most rent
	  private int maxPropertyRentIndex() {
		    int propertyIndex = 0;
		    double maxAmount = 0;
		    for (int i = 0;i<properties.length;i++) {
		      if (properties[i]==null) {
		        break;
		      }
		      if (properties[i].getRentAmount() > maxAmount) {
		        maxAmount = properties[i].getRentAmount();
		        propertyIndex = i;
		      }
		    }
		    return propertyIndex;
		  }
	  
	  public double maxRentProp() {
		    double max =0;
		    String maxRentprop = "";
		    Property prop1 = properties[0];
		    for (Property prop : properties) {
		    	if (prop !=null) {
		    		if (prop.getRentAmount() > max) {
		    			max = prop.getRentAmount();
		    			prop1 = prop;


		    		}
		    	}
		    }
		    maxRentprop +=prop1.toString();    
		    return  max;
		  }
	// constructors 
	
	public ManagementCompany() {
		name = "";
		taxID = "";
		properties = new Property[MAX_PROPERTY];
		mgmFeePer = 0;
		plot = new Plot();
	}
	
	
	public ManagementCompany(String name,String taxID,double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID,double mgmFee,int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x,y,width,depth);
		this.properties = new Property[MAX_PROPERTY];
		
	}
	 @Override
	  public String toString() {

	    String propertyList = "";
	    for (int i = 0; i < MAX_PROPERTY; i++) {
	      if (properties[i]==null) {
	        break;
	      } 
	      propertyList += properties[i] + "\n"; 
	    }
	    return "List of the properties for " + name + ", taxID: " + taxID+ "\n"
	        + propertyList +  "\n"
	        + "total management Fee: " + (totalRent() * (mgmFeePer / 100));
	  }

}
