package controller.datos;

import java.io.*;

public class Datos {
	static public boolean guardarCatProductos(Object obj)
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("Empresa.bin");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			//Serialization:
			out.writeObject(obj);       
			out.close();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	static public Object recuperarCatProductos()
	{
		Object obj;
		try
		{
			FileInputStream fi = new FileInputStream("Empresa.bin");
			ObjectInputStream fs = new ObjectInputStream(fi);
			// Deserialazation:
			obj = fs.readObject();
			fs.close();
		}
		catch(Exception ex)
		{
			obj=null;
		}
		return obj;
	}
	
	static public boolean guardarRegVentas(Object obj)
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("Ventas.bin");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			//Serialization:
			out.writeObject(obj);       
			out.close();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	static public Object recuperarRegVentas()
	{
		Object obj;
		try
		{
			FileInputStream fi = new FileInputStream("Ventas.bin");
			ObjectInputStream fs = new ObjectInputStream(fi);
			// Deserialazation:
			obj = fs.readObject();
			fs.close();
		}
		catch(Exception ex)
		{
			obj=null;
		}
		return obj;
	}
}
