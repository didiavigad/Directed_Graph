package dataStructure;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class DGraph implements graph{
	private int  sizeOfEdge=0;
	private int count=0;
	private  Map<Integer, node_data> _data  = new HashMap<>(); 
	private HashMap<Integer, HashMap<Integer, edge_data>> _edgeData = new HashMap<>() ;

	/**
	 * return the node_data by the node_id,
	 * @param key - the node_id
	 * @return the node_data by the node_id, null if none.
	 */


	@Override
	public node_data getNode(int key) {

		if (_data.containsKey(key)){
			node_data nodeData=  _data.get(key);
			return nodeData;
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

		if (_edgeData.containsKey(src)){
			edge_data edgeD=_edgeData.get(src).get(dest);

			return edgeD;
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
		_edgeData.put(k, new HashMap<Integer,edge_data>());
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
		_edgeData.get(src).put(dest,new edge(src, dest, w));
		this.sizeOfEdge++;
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

		return _edgeData.get(node_id).values();
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
		System.out.println(sizeOfEdge);
		for (int i = 0; i < _edgeData.size() ; i++) {
			if(i!=key){
				if(_edgeData.get(i).get(key)!=null) {
					_edgeData.get(i).remove(key);
					this.count++;	

				}

				if(_edgeData.get(i).isEmpty()) {
					this.sizeOfEdge--;


				}

			}  

		}
		//System.out.println(sizeOfEdge);
		_edgeData.remove(key);
		node_data node =_data.get(key);
		_data.remove(key);
		return  node;


	}

	@Override
	public edge_data removeEdge(int src, int dest) {


		if(_edgeData.get(src).get(dest)!=null) {
			edge_data edgeD = _edgeData.get(src).get(dest);
			_edgeData.get(src).remove(dest);
			this.sizeOfEdge--;
			this.count++;
			System.out.println(sizeOfEdge);
			return edgeD;
		}

		return null;
	}

	@Override
	public int nodeSize() {

		return _data.size();
	}

	@Override
	public int edgeSize() {

		return this.sizeOfEdge ;
	}
	/**
	 * return the Mode Count - for testing changes in the graph.
	 * @return
	 */
	@Override
	public int getMC() {
		//System.out.println(_connect);
		return this.count;
	}
}