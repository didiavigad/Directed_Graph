package dataStructure;

import utils.Point3D;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//src=
		DGraph g = new DGraph();
		node_data n1= new node(0,new Point3D(1,2,3),20,10);
		node_data n2= new node(1,new Point3D(1,2,4),1,10);
		node_data n3= new node(2,new Point3D(1,6,5),23,10);
		node_data n4= new node(3,new Point3D(1,5,6),4,10);
		node_data n5= new node(4,new Point3D(1,2,7),12,10);
		node_data n6= new node(5,new Point3D(5,2,8),45,10);
		node_data n7= new node(6,new Point3D(2,2,9),6,10);
		node_data n8= new node(7,new Point3D(4,2,10),8,10);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		//System.out.println(n1.getKey());
		//System.out.println(n7.getKey());
		//System.out.println(n3.getKey());
		//System.out.println(n4.getKey());
        //System.out.println(g.getNode(1));
        //System.out.println(g.getNode(2));		
        //System.out.println(g.getNode(3));
		//edge_data e1=new edge(0,1,120.3,5);
		//edge_data e2=new edge(0,2,345.67,6);
		//edge_data e3=new edge(0,3,109.1,6);
		//edge_data e4=new edge(1,2,56.576,3);
		//edge_data e5 =new edge(2,1,5.576,3);
		//edge_data e6 =new edge(2,0,6.576,4);
		//edge_data e7 =new edge(3,4,12.4,2);
		//edge_data e8 =new edge(4,5,71.65,3);
g.connect(0,2,30.56);
g.connect(1,6,3.42);
g.connect(6,3,15.87656);
g.connect(5,2,0.56);
g.connect(2,1,30.56);
g.connect(1,5,30.56);
//g.getE(1);
//System.out.println(g.getE(1));
//System.out.println(g.getV());
//System.out.println(g.getNode(1));
//g.removeEdge(6, 3);
g.removeNode(1);
g.removeEdge(6, 3);
g.getMC();
g.edgeSize();
System.out.println(g.edgeSize());
//System.out.println(g.getNode(1));

System.out.println(g.getEdge(1,6));
//System.out.println("////"+g.rem);
//System.out.println(g.edgeSize());


//g.getEdge(src, dest)
		
		
		
		
	}

}
