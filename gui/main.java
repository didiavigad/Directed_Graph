package gui;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		graph g = new DGraph();
	
		//node_data n1= new node(0,new Point3D(6,5),20,10);
		node_data n2= new node(1,new Point3D(50,40),1,10);
		node_data n3= new node(2,new Point3D(220,100),23,10);
		node_data n4= new node(3,new Point3D(180,210),4,10);
		node_data n5= new node(4,new Point3D(564,542),12,10);
		node_data n6= new node(5,new Point3D(200,431),45,10);
		node_data n7= new node(6,new Point3D(452,324),6,10);
		node_data n8= new node(7,new Point3D(1000,542),8,10);
		
		
		//g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
	    g.addNode(n6);
	    g.addNode(n7);
		g.addNode(n8);
		

		
		//true
		g.connect(1, 2, 43.5);
		g.connect(1, 3, 76.4);
		g.connect(2, 3, 56.3);
		g.connect(2, 5, 123.4);
		g.connect(3, 2, 14.1);
		g.connect(4, 6, 34);
		g.connect(4, 5, 76);
		g.connect(5, 6, 86);
		g.connect(5, 7, 124);
		g.connect(6, 7, 435.6);
		g.connect(7, 1, 245.67);
	
	
	   // StdDraw.setPenRadius(0.05);
       // StdDraw.setPenColor(StdDraw.BLUE);
       /// StdDraw.point(0.5, 0.5);
        //StdDraw.setPenColor(StdDraw.MAGENTA);
        //StdDraw.line(0.2, 0.2, 0.8, 0.2);
	
	
	    Graph_GUI g1= new Graph_GUI(g);
	g1.drawGraph(g);
	//g1.save("fddr.jpg");
	}

}
