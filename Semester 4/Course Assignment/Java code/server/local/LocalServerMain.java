package server.local;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import models.Car;
import models.Part;
import server.Server;

public class LocalServerMain extends UnicastRemoteObject implements LocalServerInterface{

	private ArrayList<Car> cars;
	private Server server;
	
	public LocalServerMain() throws RemoteException {
		super();
		
		cars = new ArrayList<>();
		
		try 
		{
			this.server = (Server) Naming.lookup("rmi://localhost:1099/MServer");
		} 
		catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean registerCar(Car car) throws RemoteException 
	{
		cars.add(car);
		
		return server.registerCar(car);
	}
}
