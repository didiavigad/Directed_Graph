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
		node_data n2= new node(1,new Point3D(1,2),1,10);
		node_data n3= new node(2,new Point3D(1,6),23,10);
		node_data n4= new node(3,new Point3D(1,5),4,10);
		node_data n5= new node(4,new Point3D(1,2),12,10);
		node_data n6= new node(5,new Point3D(5,2),45,10);
		node_data n7= new node(6,new Point3D(2,2),6,10);
		//node_data n8= new node(7,new Point3D(4,2,10),8,10);
		
		
		//g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
	    g.addNode(n6);
	    g.addNode(n7);
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
//		
		//true
//		g.connect(1, 5, 30);
//		g.connect(5, 1, 30);
//		g.connect(2, 5, 30);
//		g.connect(5, 2, 30);
//		g.connect(3, 5, 30);
//		g.connect(5, 3, 30);
//		g.connect(4, 5, 30);
//		g.connect(5, 4, 30);
		
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
//		Graph_Algo g1= new Graph_Algo(g);
		//System.out.println(g1.isConnected());
	//g1.save("ge.txt");
//	Graph_Algo gg = new Graph_Algo();
//	gg.init("ge.txt");
//	System.out.println(gg.isConnected());
	
	
	
	//System.out.println(g1.isConnected());
		//g1.save("ggg.txt");
//		Graph_Algo gg = new Graph_Algo();
//		gg.init(g);
//		
//		//Graph_Algo g1= new Graph_Algo(g);
//		gg.init("ggg.txt");
//	System.out.println(gg.isConnected());
	
	
//	graph s = new DGraph();
//	s.addNode(new node(1));
//	s.addNode(new node(2));
//	s.addNode(new node(3));
//	s.addNode(new node(4));
//	s.addNode(new node(5));
//	s.addNode(new node(6));
//	s.addNode(new node(7));
//	s.addNode(new node(8));
//	s.connect(1, 2, 1);
//	s.connect(1, 3, 7);
//	s.connect(1, 4, 4);
//	s.connect(2, 3, 2);
//	s.connect(3, 4, 4);
//	s.connect(3, 5, 3);
//	s.connect(4, 5, 5);
//	s.connect(5, 6, 4);
//	s.connect(5, 7, 13);
//	s.connect(6, 7, 8);
//	s.connect(6, 8, 10);
//	s.connect(7, 8, 3);
//	Graph_Algo e = new Graph_Algo();
//	e.init(s);
//	System.out.println(e.shortestPathDist(1, 8));
//System.out.println(e.isConnected());	
	//e.shortestPathDist(1, 8);
	
	    graph_algorithms m = new Graph_Algo();

		DGraph h = new DGraph();
		m.init(h);
		node_data a = new node(1, new Point3D(3, 2, 4));
		node_data b = new node(2, new Point3D(4, 2, 4));
		node_data c = new node(3, new Point3D(4, 2, 4));
		node_data d = new node(4, new Point3D(4, 2, 4));
		node_data e = new node(5, new Point3D(4, 2, 4));
		node_data f = new node(6, new Point3D(4, 2, 4));

		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		h.addNode(d);
		h.addNode(e);
		h.addNode(f);
		
		h.connect(a.getKey(), b.getKey(), 1);
		h.connect(b.getKey(), c.getKey(), 1);
		h.connect(c.getKey(), d.getKey(), 1);
		h.connect(d.getKey(), e.getKey(), 1);
		h.connect(e.getKey(), f.getKey(), 1);
		h.connect(f.getKey(), a.getKey(), 5);
		h.connect(b.getKey(), e.getKey(), 1);
		h.connect(c.getKey(), f.getKey(), 3);
		h.connect(a.getKey(), e.getKey(), 4);
		h.connect(f.getKey(), b.getKey(), 7);
		System.out.println(m.shortestPathDist(a.getKey(), f.getKey()));
		
		//assertEquals(3, m.shortestPathDist(a.getKey(), f.getKey()));
	}

	
	
	
	
	}

