import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Point2Ds {
	private ArrayList<Point2D> points = new ArrayList<Point2D>();
	
	public Point2D getPoint(int i) {
		// Return the point object at index i 
		
		// Put your code here 
		Point2D point = points.get(i);
		
		
		
		
		return point;
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points 
		InputStream file = getClass().getResourceAsStream(filename);
		Scanner reader = new Scanner(file);
		reader.useDelimiter("%");
		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			String[] dataList = data.split(" ", 2);
			double x = Double.parseDouble(dataList[0]);
			double y = Double.parseDouble(dataList[1]);
			Point2D filePoint = new Point2D(x, y);
			points.add(filePoint);
		}
		reader.close();
	} 
	
		
		
		
		
		
		
		
		

	
	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin 
		
		// Put your code here 
		double distanceFromOrigin = 0;
		int count = 0;
		Point2D origin = new Point2D(0, 0);
		for (int j = 0; j < points.size(); j++) {
			if (j == 0) {
				distanceFromOrigin = origin.distance(points.get(0));
			} 
			double dis = origin.distance(points.get(j));
			if (distanceFromOrigin > dis) {
				count = j;
				distanceFromOrigin = dis;
			}
		}
		
		
		
		
		
		return points.get(count);
	}

	public Point2D getClosestPoint(double x,double y) {
		// Return the point that is closest to x,y 

		// Put your code here 
		
		double distanceFromPoint = 0;
		int count = 0;
		Point2D point = new Point2D(x, y);
		for (int j = 0; j < points.size(); j++) {
			if (j == 0) {
				distanceFromPoint = point.distance(points.get(0));
			} 
			double dis = point.distance(points.get(j));
			if (distanceFromPoint > dis) {
				count = j;
				distanceFromPoint = dis;
			}
		}
		
		
		
		
		
		return points.get(count);
	}
}
