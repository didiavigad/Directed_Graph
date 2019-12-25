package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import utils.Point3D;

public class DGraph implements graph{

	
	private node_data nodeData; 
	private edge_data edgeData ;
	private int count=0;
	private  Map<Integer, node_data> _data  = new HashMap<>(); 
	private  Map<KeyEdge, edge_data> _egData  = new HashMap<>();
	  private HashMap<node_data, HashMap<KeyEdge, edge_data>> _connect= new HashMap<>() ;	
    
    public DGraph() {
    	this._data=new HashMap<Integer, node_data>();
    	this._egData=new HashMap<KeyEdge, edge_data>();
    	this._connect= new HashMap<node_data, HashMap<KeyEdge, edge_data>>();    	
    	
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
		
		_connect.put(n, new HashMap<KeyEdge,edge_data>());
		
		this.count++;
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
   
		node_data n = _data.get(src);
	_egData.put(new KeyEdge(src,dest),new edge(src, dest, w) ); 
	//System.out.println(_egData.size());
	_connect.get(nodeData).put(new KeyEdge(src,dest),new edge(src, dest, w));
    //System.out.println(_egData);
	this.count++;
		
		
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

		nodeData= _data.get(node_id);
		return _connect.get(nodeData).values();
	}
	/**
	 * Delete the node (with the given ID) from the graph -
	 * and removes all edges which starts or ends at this node.
	 * This method should run in O(n), |V|=n, as all the edges should be removed.
	 * @return the data of the removed node (null if none). 
	 * @param key
	 */
	@Override
	///need to fix!!!
	public node_data removeNode(int key) {
		this.count++;
		node_data g=_data.get(key);
	for (int i = 0; i <_connect.size()+1 ; i++) {	
		edge_data k=_egData.get(i);
		node_data gc =_data.get(i);
		
		if(_egData.get(i)!=null) {
		if(k.getDest()==key) {
		
			
			
			//System.out.println(k.getDest());
			//System.out.println(_connect.get(g));
			
			 _connect.get(g).remove(k);
		//	System.out.println(_connect.get(g));
		
		}
		
		}
			
		
		
		
	}
	
		
		
		_connect.remove(g);
		//System.out.println(_connect.get(g));
		return _data.remove(key); 

	}

	
	@Override
	public edge_data removeEdge(int src, int dest) {
		this.count++;
		return null;
	}

	@Override
	public int nodeSize() {
		
		return _data.size();
	}

	@Override
	public int edgeSize() {
		
		return _egData.size() ;
	}
	/**
	 * return the Mode Count - for testing changes in the graph.
	 * @return
	 */
	@Override
	public int getMC() {
	System.out.println(_connect);
		return this.count;
	}
}