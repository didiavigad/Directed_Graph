package dataStructure;



public class edge implements edge_data {
	private int src;
	private int dest;
	private double weight;
	private int tag;
	
	public edge(int src,int dest) {
		
		
		this.src=src;
		this.dest=dest;
		//this.weight=weight;
		//this.tag=tag;
	}
	
public edge(int src,int dest,double weight,int tag) {
		
		this.src=src;
		this.dest=dest;
		this.weight=weight;
		this.tag=tag;
	}
	
	
	
	
	public edge() {
	// TODO Auto-generated constructor stub
}

	/**
	 * The id of the source node of this edge.
	 * @return
	 */
	@Override
	public int getSrc() {
		return this.src;
	}

	/**
	 * The id of the destination node of this edge
	 * @return
	 */
	
	@Override
	public int getDest() {
		return this.dest;
	}

	/**
	 * @return the weight of this edge (positive value).
	 */
	
	@Override
	public double getWeight() {
		return this.weight;
	}

	
	/**
	 * return the remark (meta data) associated with this edge.
	 * @return
	 */
	
	
	@Override
	//
	public String getInfo() {
		return"The source is:"+ this.src+"\n"+"The destination is:"+this.dest+"\n"+"The weight is:"+this.weight+"\n"+"The tag is:"+this.tag;
		
	}

	
	/**
	 * Allows changing the remark (meta data) associated with this edge.
	 * @param s
	 */
	
	//private int src;
	//private int dest;
	//private double weight;
	//private int tag;
	@Override
	public void setInfo(String s) {
String[] arr;
		//get (src,dest,weight,tag)
		arr =  s.split(",");		
		this.src=Integer.parseInt( arr[0].substring(1, arr[0].length()));
		this.dest= Integer.parseInt( arr[1]);
		this.weight=Double.parseDouble(arr[2]);
		this.tag=Integer.parseInt( arr[3].substring(0, arr[3].length()-1));
		
	}
	/**
	 * Temporal data (aka color: e,g, white, gray, black) 
	 * which can be used be algorithms 
	 * @return
	 */
	@Override
	public int getTag() {
		return this.tag;
	}
	/** 
	 * Allow setting the "tag" value for temporal marking an edge - common 
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	@Override
	public void setTag(int t) {
		this.tag=t;
		
	}

}
