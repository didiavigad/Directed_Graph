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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import dataStructure.DGraph;
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

	public Graph_Algo (graph g){

		this._graph=g;


	}


	public Graph_Algo() {
		_graph = new DGraph();
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
	 * returns the length of the shortest path between src to dest
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	@Override
	public double shortestPathDist(int src, int dest) {
		List<node_data> shortListDist  = new LinkedList<node_data>();
		shortListDist = shortestPath(src, dest);
		if (shortListDist.size()==0) {
			return Double.POSITIVE_INFINITY;
		}
		double dist =0;
		for (node_data node: shortListDist) {

			dist+= node.getWeight();
		}
		return dist;
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
	public List<node_data> shortestPath(int src, int dest) {
		for (node_data node: this._graph.getV()) {
			node.setWeight(Double.POSITIVE_INFINITY); // set weight infinity
			node.setTag(0); // set unvisitied
		}


		_graph.getNode(src).setWeight(0.);
		_graph.getNode(src).setInfo(src +"");
		LinkedList<node_data> list_short = new LinkedList<node_data>() ;
		Comparator_list comp = new Comparator_list();
		//insert all nodes
		for (node_data node: this._graph.getV()) {
			list_short.add(node);
		}
		while (_graph.getNode(dest).getTag()==0 && list_short.size()!=0) {
			list_short.sort(comp);
			node_data first = list_short.get(0);
			if(_graph.getE(first.getKey())!=null) {
				for (edge_data edge : _graph.getE(first.getKey())) {
					node_data vEdge = _graph.getNode(edge.getDest());
					if (vEdge.getTag()==0) {
						double minEdge = first.getWeight()+edge.getWeight();


						if (minEdge<vEdge.getWeight()) {

							vEdge.setInfo(first.getInfo()+" "+ vEdge.getKey());
							vEdge.setWeight(edge.getWeight());
						}
					}
				}

			}
			first.setTag(1);
			list_short.remove(0);

		}
		// until here its algorithm

		String str = _graph.getNode(dest).getInfo();
		String [] strArr = str.split(" ");
		LinkedList<node_data> list = new LinkedList<node_data>();
		for (int i = 0; i < strArr.length; i++) {
			if(!strArr[i].isEmpty()) {
				int key = Integer.parseInt(strArr[i]);

				node_data node = _graph.getNode(key);
				list.add(node);
			}
		}
		return list;

	}
	class Comparator_list implements Comparator<node_data>{

		@Override
		public int compare(node_data o1, node_data o2) {
			return (int)(o1.getWeight()-o2.getWeight());
		}

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
	public List<node_data> TSP(List<Integer> targets) {
		List<node_data> TSP_list = new LinkedList<node_data>();
		node_data src  = _graph.getNode(targets.get(0));
		if (targets.size()==1)  {
			TSP_list.add(src);
			return TSP_list;
		}
		for (int i = 0; i < targets.size()-1; i++) {

			int dest = targets.get(i+1);
			node_data node = _graph.getNode(dest);
			if (TSP_list.contains(node)) i++;

			List<node_data> listPath = shortestPath(targets.get(i), targets.get(i+1));

			TSP_list.addAll(listPath);	
		}
		return TSP_list;
	}

	/** 
	 * Compute a deep copy of this graph.
	 * @return
	 */
	@Override
	public graph copy() {
		Graph_Algo g = new Graph_Algo(_graph) ;
		Collection<node_data> nodes = _graph.getV();
		for (node_data node : nodes) {
			node_data n =node;
			((graph) g).addNode(n);
			Collection<edge_data> edges = _graph.getE(n.getKey());
			for (edge_data edge : edges) {
				((graph) g).connect(edge.getSrc(), edge.getDest(), edge.getWeight());

			}
		}
		return (graph)g;
	}


	/////private metode.
	private  HashMap<Integer, Boolean> _vis  = new HashMap<>(); 
	private Stack<Integer>stack= new Stack<Integer>();
	private ArrayList<ArrayList<Integer>> sccComp = new ArrayList<ArrayList<Integer>>();
	private HashMap<Integer,Integer > low  = new HashMap<>(); 
	private int count;




}
