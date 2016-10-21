package suPropiedadRaiz.gestionBD;

import java.util.*;
import java.io.*;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.inmuebles.*;

public class GestionBD {
	
	public static void seriarPersona (ArrayList<Persona> lista, String nombreArchivo){
		File archivo;
		archivo = new File(nombreArchivo);
		ObjectOutputStream output;
		try{
			output = new ObjectOutputStream( new FileOutputStream(archivo) );
			output.writeObject(lista);
			output.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void seriarInmueble (ArrayList<Inmueble> lista, String nombreArchivo){
		File archivo;
		archivo = new File(nombreArchivo);
		ObjectOutputStream output;
		try{
			output = new ObjectOutputStream( new FileOutputStream(archivo) );
			output.writeObject(lista);
			output.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static ArrayList<Persona> deseriarPersonas(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		try{
			ObjectInputStream input = new ObjectInputStream( new FileInputStream(archivo) );
			ArrayList<Persona> objeto = (ArrayList<Persona>)input.readObject(); 
			input.close();
			return objeto;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<Inmueble> deseriarInmuebles(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		try{
			ObjectInputStream input = new ObjectInputStream( new FileInputStream(archivo) );
			ArrayList<Inmueble> objeto = (ArrayList<Inmueble>)input.readObject(); 
			input.close();
			return objeto;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}