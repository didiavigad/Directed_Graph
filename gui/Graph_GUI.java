package gui;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import algorithms.Graph_Algo;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;
import java.util.Scanner; 
public class Graph_GUI  extends JFrame implements ActionListener      {

	graph _graph;
	


	public Graph_GUI() {
		_graph = (graph) new Graph_Algo();
	}
	
	

	public void menue() {
		
//		JFrame f=new JFrame("graph menue");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		JFrame frame = new JFrame("graph menue");
		

		JButton button,button1, button2, button3,button4;
		button = new JButton("Click to get a drawing of the graph");
		button1 = new JButton("Click to get a short est Path on the graph");
		button2 = new JButton("Click if you want a relatively short route that visits each node in the destination list");
		button3 = new JButton("Click if you want to save the geaph");
		button4 = new JButton("Click if you want to open file geaph");
		frame.add(button);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.setLayout(new GridLayout(2,3));
		frame.setSize(1000,1000);  
		frame.setVisible(true);  


		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		}
		
	public Graph_GUI (graph g){
		this._graph=g;
		 menue();
	}	

	public void init(String file_name) {
		Graph_Algo G = new Graph_Algo(_graph);
		G.init(file_name);
	}

	public void save(String f) {
		Graph_Algo G = new Graph_Algo(_graph);
		G.save(f);
	}


	public void drawGraph(graph graph) {
		StdDraw.setXscale(-100, 1010);
		StdDraw.setYscale(-100, 1010);
		Collection<node_data> nodes = graph.getV();
		for (node_data node : nodes) {
			Point3D p = node.getLocation();
			String str = Integer.toString(node.getKey()); 
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.textLeft(p.x()-25, p.y(), str);
			StdDraw.setPenRadius(0.015);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.point(p.x(), p.y());
			Collection<edge_data> edge = graph.getE(node.getKey());
			if(graph.getE(node.getKey())!=null) {
				for (edge_data edg : edge) {
					node_data n=graph.getNode(edg.getDest()); ;
					Point3D destLoction =n.getLocation();
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.setPenRadius(0.002);
					StdDraw.line(p.x(),p.y(),destLoction.x(),destLoction.y());
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.setPenRadius(0.02);
					StdDraw.point(((p.ix()*0.1)+(0.9*destLoction.ix()))+7,1+((p.iy()*0.1)+(0.9*destLoction.iy())));
					StdDraw.setPenColor(StdDraw.BLACK);
					String str1 = Double.toString(edg.getWeight());
					StdDraw.text((p.x()+destLoction.x())/2 , (p.y()+destLoction.y())/2, str1);


				}
			}

		}

	}

public void shortestPath(int src,int dest) {
	drawGraph(_graph);
	List<node_data> list= new ArrayList<node_data>() ;
	Graph_Algo g =new Graph_Algo(_graph);
	list = g.shortestPath(src, dest);
	for (int i = 0; i < list.size(); i++) {
		if(list.size()>(i+1)) {
		Point3D	s =list.get(i).getLocation();
		Point3D	d =list.get(i+1).getLocation();
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(s.x(),s.y(),d.x(),d.y());
		
		}
		
		}
double t=	g.shortestPathDist(src, dest);		
String str = " The length of the shortest path between " +src +" to "+ dest+ " is: "+t;	
StdDraw.setPenColor(StdDraw.BLACK);
	
StdDraw.text(400 , -50, str);
	}

 



public void TSP (List<Integer> t) {
	drawGraph(_graph);
	Graph_Algo g =new Graph_Algo(_graph);

	List<node_data> listTsp= new ArrayList<node_data>() ;
	listTsp=g.TSP(t);
	for (int i = 0; i < listTsp.size(); i++) {
		if(listTsp.size()>(i+1)) {
			Point3D	s =listTsp.get(i).getLocation();
			Point3D	d =listTsp.get(i+1).getLocation();
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.setPenRadius(0.005);
			StdDraw.line(s.x(),s.y(),d.x(),d.y());
		}
	}
		
		
		
		
		
		
		}



private void txtOpen() {
	String str =JOptionPane.showInputDialog(null, "Please write down the name of the file that you want to open" );
str+=".txt";
init(str); 
}


private void txtName() {
	String str =JOptionPane.showInputDialog(null, "Please write down the name of the file that you want to save" );
str+=".txt";
save(str);
}


private void stdf() {
	int size =Integer.parseInt(JOptionPane.showInputDialog(null, "Please list the number of places you would like to visit, you have " +_graph.nodeSize() +" point" ));

	List<Integer> listT= new ArrayList<Integer>() ;
	for (int i = 0; i < size; i++) {	
		int point =Integer.parseInt(JOptionPane.showInputDialog(null, "Please write down the point number that you want to visit"));	
		
		listT.add(point);
	
	}
	
		
	TSP(listT);
	
	}


public void stdd() {
int src =Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the source"));
int dest =Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the target"));	
shortestPath(src,dest);
	
}



@Override
public void actionPerformed(ActionEvent e) {

	String act = e.getActionCommand();
	switch (act) {
	case "Click to get a drawing of the graph": drawGraph(_graph);
		break;
	case "Click to get a short est Path on the graph": stdd(); //shortestPath();
	break;
	case "Click if you want a relatively short route that visits each node in the destination list":stdf() ;
	break;
	case "Click if you want to save the geaph":txtName();
	break;
	case"Click if you want to open file geaph":txtOpen();
	break;	

	default:
		break;
	}
}
}




	









