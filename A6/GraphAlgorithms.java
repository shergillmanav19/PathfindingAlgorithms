/*
	Name:
	Student ID: 
*/ 

import java.awt.Color;
import java.util.*;
import java.util.Stack;

public class GraphAlgorithms{

	/* FloodFillDFS(v, writer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour){

		Stack<PixelVertex> stack = new Stack<PixelVertex>();
		PixelVertex cur = new PixelVertex(v.getX(),v.getY());
		LinkedList<PixelVertex> neighbours_of_cur = new LinkedList<PixelVertex>();
		LinkedList<PixelVertex> visited = new LinkedList<PixelVertex>();

		stack.push(v);
		while(!stack.empty()){
			cur = stack.pop();
			if(!visited.contains(cur)){
				writer.setPixel(cur.getX(), cur.getY(), fillColour);
				visited.add(cur);
				neighbours_of_cur = cur.getNeighbours();
				for(int i =0;i<neighbours_of_cur.size();i++){
					stack.push(neighbours_of_cur.get(i));
				}
			}
		}



	
	}
	
	/* FloodFillBFS(v, writer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, PixelWriter writer, Color fillColour){
		Queue<PixelVertex> queue = new LinkedList<PixelVertex>();
		LinkedList<PixelVertex> neighbours_of_v= new LinkedList<PixelVertex>();
		LinkedList<PixelVertex> visited = new LinkedList<PixelVertex>();

		queue.add(v);
		visited.add(v);
		while(!queue.isEmpty()){
			v = queue.remove();
			writer.setPixel(v.getX(), v.getY(), fillColour);
			neighbours_of_v = v.getNeighbours();
			for(int i =0;i<neighbours_of_v.size();i++){
					if(!visited.contains(neighbours_of_v.get(i))){
						writer.setPixel(neighbours_of_v.get(i).getX(), neighbours_of_v.get(i).getY(), fillColour);
						visited.add(neighbours_of_v.get(i));
						queue.add(neighbours_of_v.get(i));
					}
				
				}
		}


	}
	
}