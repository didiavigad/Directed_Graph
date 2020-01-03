package dataStructure;

import java.io.Serializable;

import utils.Point3D;

public class node implements node_data,Serializable{
	private int key;//מפתח שמציין את הקודקוד החדש
	private Point3D Location ;//מיקום אנקודה 
	private double Weight;//משקל הנקודה
	private String Info="";//הצגת כול הנתונים של הנקודה כלומר מיקום משקל 
	private int Tag;

	public node(int k,Point3D l,double w,int t) {
		this.key=k;
		this.Location=l;
		this.Weight=w;
		this.Tag=t;



	}





	public node(int i) {
		this.key=i; 
	}





	public node(int i, Point3D p) {
		this.key=i;
		this.Location=p;
	}





	/**
	 * Return the key (id) associated with this node.
	 * @return
	 */
	@Override
	public int getKey() {

		return this.key;
	}

	/** Return the location (of applicable) of this node, if
	 * none return null.
	 * 
	 * @return
	 */

	@Override
	public Point3D getLocation() {

		return this.Location;
	}



	/** Allows changing this node's location.
	 * 
	 * @param p - new new location  (position) of this node.
	 */

	@Override
	public void setLocation(Point3D p) {
		this.Location=p;

	}


	/**
	 * Return the weight associated with this node.
	 * @return
	 */

	@Override
	public double getWeight() {

		return this.Weight;
	}



	/**
	 * Allows changing this node's weight.
	 * @param w - the new weight
	 */

	@Override
	public void setWeight(double w) {
		this.Weight=w;

	}
	/**
	 * return the remark (meta data) associated with this node.
	 * @return
	 */
	@Override
	public String getInfo() {
		return this.Info;
		//return"The key is:"+ this.key+"\n"+"The Location is:"+this.Location.toString()+"\n"+"The weight is:"+this.Weight+"\n"+"The tag is:"+this.Tag;
	}


	/**
	 * Allows changing the remark (meta data) associated with this node.
	 * @param s
	 */
//לבדוק אם נקבל סטרינג מהצורה (key,(Location),weight,tag)
	@Override
	public void setInfo(String s) {
//		String[] arr;
//
//		
//		//get (key,(Location),weight,tag)
//		arr =  s.split(" ");		
//		this.key=Integer.parseInt( arr[0].substring(1, arr[0].length()));
//		double x = Double.parseDouble( arr[1].substring(1, arr[1].length())); 
//		double y =Double.parseDouble( arr[2]); 
//		double z=Double.parseDouble(arr[3].substring(0, arr[3].length()-1)); 
//		this.Location= new Point3D(x,y,z);
//		this.Weight=Double.parseDouble( arr[4]);
//		this.Tag=this.key=Integer.parseInt( arr[5].substring(0, arr[5].length()-1));
	
		this.Info=s;

	
	}
	
	
	@Override
	public String toString() {
		return "node [key=" + key + ", Location=" + Location + ", Weight=" + Weight + ", Info=" + Info + ", Tag=" + Tag
				+ "]";
	}





	/**
	 * Temporal data (aka color: e,g, white, gray, black) 
	 * which can be used be algorithms 
	 * @return
	 */
	@Override
	public int getTag() {

		return this.Tag;
	}


	/** 
	 * Allow setting the "tag" value for temporal marking an node - common 
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	@Override
	public void setTag(int t) {
		this.Tag=t;

	}






















}
