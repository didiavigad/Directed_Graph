package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



import utils.Point3D;

public class DGraph implements graph{

	
	private node_data nodeData; 
	private edge_data edgeData ;
	//private node_data dest1; 
	//private int key;
	private  Map<Integer, node_data> _data  = new HashMap<>(); 
	private  Map<KeyEdge, edge_data> _egData  = new HashMap<>();
	//private Map<Integer, Map<Integer, edge_data>> _egData =new HashMap<>();
	//private  Map<edge, edge_data> _egData  = new HashMap<>();
	//private Point3D src1;
	//private static Integer dest1;
   // private node_data p=new node_data(src1,dest1);  
	//private static Map<Integer, Point3D> src  = new HashMap<>();
	//private static Map<Point3D,Integer > dest  = new HashMap<>();

//	public DGraph(Point3D src1,Point3D [] dest1) {
	//	this.src1=src1;
		//for (int i = 0; i < dest1.length; i++) {
		//this.dest1[i]=dest1[i];
		//}
	//}
	
	
	
	///אני מקבל את המפתח ואני רוצה להחזיר את המידע מטיפוס נאוד דאטא ולקבל את המידע על הנקודה נניח בקוקוד הראשון



	//אני רוצה לקבל מפתח ולקבל את שלושת הנקודות מוצא של אותו צומת ולקבל את כול הנקודות של יעיד הצומת 




	


	//public DGraph(node_data src1, node_data[] dest1) {
		//this.src1=src1;
	//	this.dest1=dest1;
//	}


	public static void main(String[] args) {
		int arr[]= {0,9,8,9};
		Point3D p1 =new Point3D(4,2,3);
		Point3D p2 =new Point3D(1,7,3);
		Point3D p3 =new Point3D(1,6,2);
		Point3D p4 =new Point3D(0,9,5);
		Point3D p5 =new Point3D(5,2,3);
		Point3D p6 =new Point3D(1,7,10);
		Point3D po[]= {p1,p2,p3};
		Point3D po1[]= {p1,p3,p4};
		Point3D po2[]= {p5,p4,p1};
		Point3D po3[]= {p6,p4,p3};
		Point3D po4[]= {p2,p3,p4};

		////////////////////////////////////////
		//src.put(1,new Point3D(5,3,2));
		//src.put(2,new Point3D(6,7,9));
		//src.put(3,new Point3D(4,5,8));
		//src.put(4,new Point3D(1,3,5));
		//src.put(5,new Point3D(6,3,2));
		//////////////////////////////////////// 
		//Point3D po1  =new Point3D (1,2,3); 


		//dest.put(new Point3D(6.0,7.0,9.0),2);
		//dest.put(new Point3D(1,3,5),2);
		//dest.put(new Point3D(4,5,8),2);
		//dest.put(new Point3D(1,3,5),po3);
		//dest.put(new Point3D(6,3,2),po4);
		//System.out.println(src);
		//System.out.println(dest);
	////////////////////////////////////
		//int key=2;
	//	Integer des1;
		//Point3D src1;
		//(6,7,9)
		//if (src.containsKey(key)){
		//src1 =  src.get(key);
		//System.out.println(src1);
		//
		//if (dest.containsKey(src1)){
			
		//	dest1+= dest.get(src1);
			//System.out.println(dest1);
		//}	
		//}	
		//	p1=new graph()
		
		
		//int key1=2;
		//((graph) p1).getNode( key1);
	//System.out.println(p1);
	}

	/**
	 * return the node_data by the node_id,
	 * @param key - the node_id
	 * @return the node_data by the node_id, null if none.
	 */
	//יוצא מנוקות הנחה שיש נקודה שאין לה שום נקודות חיבור במרחב כלומר נקודה זו קיימת אבל אין לה משקל לשום קודקוד אחר
	

	@Override
	public node_data getNode(int key) {
		
		if (_data.containsKey(key)){
		//אולי צריך גאט וסט ל די
			this.nodeData=  _data.get(key);
		return this.nodeData;
		}
		else return null;
	}
	/**
	 * return the data of the edge (src,dest), null if none.
	 * Note: this method should run in O(1) time.
	 * @param src
	 * @param dest
	 * @return
	 */



	@Override
	public edge_data getEdge(int src, int dest) {
		
		if (_egData.containsKey(new KeyEdge(src,dest))){
		this.edgeData=_egData.get(new KeyEdge(src,dest));
		return this.edgeData;
		}
		else 
			return null;
		
		
	}
	/**
	 * add a new node to the graph with the given node_data.
	 * Note: this method should run in O(1) time.
	 * @param n
	 */
	@Override
	public void addNode(node_data n) {
		int k=n.getKey();
		_data.put(k, n);

	}
	/**
	 * Connect an edge with weight w between node src to node dest.
	 * * Note: this method should run in O(1) time.
	 * @param src - the source of the edge.
	 * @param dest - the destination of the edge.
	 * @param w - positive weight representing the cost (aka time, price, etc) between src-->dest.
	 */
	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated method stub

	}
	/**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the nodes in the graph. 
	 * Note: this method should run in O(1) time.
	 * @return Collection<node_data>
	 */
	
	@Override
	public Collection<node_data> getV() {
		
		return _data.values();
	}
	/**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the edges getting out of 
	 * the given node (all the edges starting (source) at the given node). 
	 * Note: this method should run in O(1) time.
	 * @return Collection<edge_data>
	 */
	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Delete the node (with the given ID) from the graph -
	 * and removes all edges which starts or ends at this node.
	 * This method should run in O(n), |V|=n, as all the edges should be removed.
	 * @return the data of the removed node (null if none). 
	 * @param key
	 */
	@Override
	public node_data removeNode(int key) {
		
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		
		return _data.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
