package gui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import algorithms.Graph_Algo;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;
public class Graph_GUI extends JFrame implements ActionListener  {

	graph _graph;
	public Graph_GUI(){
		super("My First Frame");
		StdDraw.setFont();
	}


	public Graph_GUI() {
		_graph = (graph) new Graph_Algo();
	}

	public Graph_GUI (graph g){
		
		this._graph=g;

	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	        public void save(String f) {
			Graph_Algo G = new Graph_Algo(_graph);
			G.save(f);
			
			System.out.println("Do yow want to save picther of this grap?");
			
			StdDraw.save(f);
		
		}
	

	public void drawGraph(graph graph) {
		///מגדיר כך על מנת שנוכל להכניס 10000 קודקודים
		StdDraw.setXscale(-10, 1010);
		StdDraw.setYscale(-10, 1010);
		Collection<node_data> nodes = graph.getV();
		for (node_data node : nodes) {
						
			Point3D p = node.getLocation();
			

			String str = Integer.toString(node.getKey()); 

			StdDraw.setPenColor(StdDraw.BLUE);

			StdDraw.textLeft(p.x()-5, p.y(), str);
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
					double m =(p.y()-destLoction.y())/(p.x()-destLoction.x());
						
					    StdDraw.setPenRadius(0.02);
						StdDraw.point(destLoction.x()+1,destLoction.y()-1);
						StdDraw.setPenColor(StdDraw.BLACK);
						
						
						String str1 = Double.toString(edg.getWeight());
						StdDraw.text((p.x()+destLoction.x())/2 , (p.y()+destLoction.y())/2, str1);

					
				}
			}

		}













	}


	


}
