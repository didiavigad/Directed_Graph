package algorithms;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Graph_Algo g= new Graph_Algo();
		//g.init("g.txt");
		graph g = new DGraph();
		
	//	node_data n1= new node(0,new Point3D(1,2,3),20,10);
		node_data n2= new node(1,new Point3D(1,2,4),1,10);
		node_data n3= new node(2,new Point3D(1,6,5),23,10);
		node_data n4= new node(3,new Point3D(1,5,6),4,10);
		node_data n5= new node(4,new Point3D(1,2,7),12,10);
		node_data n6= new node(5,new Point3D(5,2,8),45,10);
		//node_data n7= new node(6,new Point3D(2,2,9),6,10);
		//node_data n8= new node(7,new Point3D(4,2,10),8,10);
		
		
		//g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
	    g.addNode(n6);
	//g.addNode(n7);
		//g.addNode(n8);
		

		
		//true
//		g.connect(1, 2, 0);
//		g.connect(1, 3, 0);
//		g.connect(2, 4, 0);
//		g.connect(2, 5, 0);
//		g.connect(3, 2, 0);
//		g.connect(4, 6, 0);
//		g.connect(4, 5, 0);
//		g.connect(5, 6, 0);
//		g.connect(5, 7, 0);
//		g.connect(6, 7, 0);
//		g.connect(7, 1, 0);
		
		//true
		g.connect(1, 5, 30);
		g.connect(5, 1, 30);
		g.connect(2, 5, 30);
		g.connect(5, 2, 30);
		g.connect(3, 5, 30);
		g.connect(5, 3, 30);
		g.connect(4, 5, 30);
		g.connect(5, 4, 30);
		
	//false
//	    g.connect(1, 2, 30);
//		g.connect(2, 3, 30);
//		g.connect(3, 4, 30);
//		g.connect(4, 5, 30);
	    
	    
	    
	    
	    
		//fulse
//		g.connect(0, 1, 30);
//		g.connect(1, 2, 30);
//		g.connect(1, 3, 30);
//		g.connect(3, 4, 30);
//		g.connect(4, 5, 30);
//		g.connect(5, 3, 30);//
//		g.connect(5, 2, 30);
//		
		
		
		//true
//		g.connect(0, 1, 30);
//		g.connect(1, 2, 30);
//		g.connect(2, 3, 30);
//		g.connect(3, 2, 30);
//		g.connect(3, 7, 30);
//		g.connect(7, 3, 30);//
//		g.connect(2, 6, 30);
//		g.connect(7, 6, 30);
//		g.connect(5, 6, 30);//
//		g.connect(6, 5, 30);
//		g.connect(1, 5, 30);
//		g.connect(4, 5, 30);
//		g.connect(4, 0, 30);
//		g.connect(1, 4, 30);
				
		
		
		
		
		

////		s.addNode(new vertex(1));
////		s.addNode(new vertex(2));
////		s.connect(1, 2, 0);
		//Graph_Algo e = new Graph_Algo();
		//e.init(g);
		Graph_Algo g1= new Graph_Algo(g);
		System.out.println(g1.isConnected());
		
		
		
		
	}

}
