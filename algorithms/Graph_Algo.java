package algorithms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
	
	private graph _graph;

	Graph_Algo (graph g){

		this._graph=g;


	}





	/**
	 * Init this set of algorithms on the parameter - graph.
	 * @param g
	 */


	@Override
	public void init(graph g) {
		this._graph=g;

	}




	/**
	 * Init a graph from file
	 * @param file_name
	 */
	@Override
	public void init(String file_name) {

		BufferedInputStream _BufferedInputStream =null;

		try {

			_BufferedInputStream = new BufferedInputStream(new FileInputStream(file_name));
			ObjectInputStream  object = new ObjectInputStream ( _BufferedInputStream );
			_graph = (graph)object.readObject();
			_BufferedInputStream.close();
			object.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Saves the graph to a file.
	 * 
	 * @param file_name
	 */

	@Override
	public void save(String file_name) {
		BufferedOutputStream _BufferedOutputStream =null;

		try {

			_BufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file_name));
			ObjectOutputStream object = new ObjectOutputStream( _BufferedOutputStream );
			object.writeObject(_graph);
			_BufferedOutputStream.close();
			object.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Returns true if and only if (iff) there is a valid path from EVREY node to each
	 * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
	 * @return
	 */





	private void dsf(int nodekey) {

		if(!low.containsKey(nodekey)) {
			count++;
			low.put(nodekey, count);

		}
		else {
			count++;		
			low.replace(nodekey, low.get(nodekey), count);

		}
		_vis.put(nodekey, true);
		stack.push(nodekey); 	
		int min =low.get(nodekey);
		if(_graph.getE(nodekey)!=null) {
			Collection<edge_data> listedge=_graph.getE(nodekey);
			for ( edge_data i:listedge ) {
				int dest= i.getDest();
				if (_vis.get(dest)==null||_vis.get(dest)==false) {
					dsf(dest);
				}
				if (low.get(dest) < min) {
					min = low.get(dest);
				}
			}	
		}
		if (min < low.get(nodekey)) {
			low.replace(nodekey, min);
			return;
		}
		ArrayList  <Integer> component = new ArrayList<Integer>();
		int w;
		do
		{
			w = stack.pop();
			component.add(w);
			low.replace(w, _vis.size());
		}			
		while (w != nodekey);
		sccComp.add(component);

	}

	@Override

	public boolean isConnected() {
		Collection<node_data> listNode=_graph.getV();
		for ( node_data node:listNode ) {
			_vis.put(node.getKey(), false);
			if(!(_vis.get(node.getKey()))) {
				dsf(node.getKey());
			}
			Iterator<ArrayList<Integer>> iterator = sccComp.iterator();
			while (iterator.hasNext()){
				if (iterator.next().size() <= 1) {
					return false;
				}

			}

		}

		return true;
	}












	/**
	 * Returns true if and only if (iff) there is a valid path from EVREY node to each
	 * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
	 * @return
	 */
	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * returns the length of the shortest path between src to dest
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub

		return null;

	}

	/**
	 * returns the the shortest path between src to dest - as an ordered List of nodes:
	 * src--> n1-->n2-->...dest
	 * see: https://en.wikipedia.org/wiki/Shortest_path_problem
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * computes a relatively short path which visit each node in the targets List.
	 * Note: this is NOT the classical traveling salesman problem, 
	 * as you can visit a node more than once, and there is no need to return to source node - 
	 * just a simple path going over all nodes in the list. 
	 * @param targets
	 * @return
	 */
	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

	/////private metode.
	private  HashMap<Integer, Boolean> _vis  = new HashMap<>(); 
	private Stack<Integer>stack= new Stack<Integer>();
	private ArrayList<ArrayList<Integer>> sccComp = new ArrayList<ArrayList<Integer>>();
	private HashMap<Integer,Integer > low  = new HashMap<>(); 
	private int count;
	
	
	
	
}
