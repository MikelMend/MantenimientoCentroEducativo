import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MantenimientoMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		boolean correcto = false;
		int opcion;
		Scanner sc= new Scanner(System.in);
		do {
			try {
				System.out.println("\n*********MENU PRINCIPAL********");
				System.out.println("\n1. Mantenimiento Cursos.");
				System.out.println("\n2. Mantenimiento Asignaturas");
				System.out.println("\n3. Mantenimiento Sucursales");
				System.out.println("\n4. Mantenimiento Bancos");
				System.out.println();
				System.out.println("Opcion seleccionada: ");
				opcion= sc.nextInt();
				
				switch(opcion) {
				case 0:
					System.out.println("\n^FIN DE APLICACIÓN^");
					correcto=true;
					break;
				case 1:
					boolean salirCursos = false;
					do {
						try {
						File ruta= new File("c:/ProyectoCentro");
						File f= new File(ruta,"cursos.txt");
						if(!f.exists()) {
							System.out.println("El fichero " + f.getName()+ " no existe.");
							if(!ruta.exists()) {
								System.out.println("El directorio "+ ruta.getName()+ " no existe");
								if(ruta.mkdir()) {
									System.out.println("La ruta "+ruta.getName()+" se ha creado correctamente");
									if(f.createNewFile()) {
										System.out.println("El fichero "+ f.getName()+" se ha creado correctamente");
									}else {
										System.out.println("No se ha podido crear "+f.getName());
									}
								}else {
									System.out.println("No se ha podido crear "+ruta.getName());
								}
							}else {// si la ruta existe creamos un fichero
								if(f.createNewFile()) {
									System.out.println("El fichero "+f.getName()+" se ha creado correctamente.");
								}else {
									System.out.println("No ha sido posible crear el fichero "+f.getName());
								}
							}
						}else {
							System.out.println("El directorio y fichero existen.");
						}
							
						
					
					System.out.println("\n*********MANTENIMIENTO CURSOS********");
					System.out.println("\n1. Alta Cursos.");
					System.out.println("\n2. Baja Cursos");
					System.out.println("\n3. Mostrar Cursos");
					System.out.println("\n0. Salir");
					System.out.println();
					System.out.println("Opcion Seleccionada: ");
					opcion= sc.nextInt();
					
						switch(opcion){
						case 0:
							salirCursos= true;
							break;
						case 1:
							System.out.println("----------------Alta Cursos----------------");
							String Curso,descripcion;
							boolean Cursocorrecto = false;
							try(	FileWriter fichero= new FileWriter("C:\\ProyectoCentro\\cursos.txt",true);
									PrintWriter insercion = new PrintWriter(fichero)) {
									sc.nextLine();
								do {
								System.out.println("Introduce el codigo del curso:");
								Curso=sc.nextLine();
								if(Curso.length()!=2) {
									System.out.println("Error! -El código de curso debe contener 2 carácteres.");
									Cursocorrecto=false;
									}else {
										Cursocorrecto=true;
									}
								}while(!Cursocorrecto);
	
								System.out.println("Introduce la descripcion del curso:");
								descripcion= sc.nextLine();
								insercion.println(Curso+", "+descripcion);
								insercion.flush();
								insercion.close();
								
							}catch(FileNotFoundException e) {
								System.out.println("Error! Fichero no encontrado.");
							}
							
							break;
						case 2:
							System.out.println("----------------Baja Cursos----------------");
							
							FileReader file = null;
					        String cadena,borrarCadena;
					        boolean borrarCurso=false;
					        sc.nextLine();
					        // datos para Auxiliar
					        
					        do {
					        System.out.println("Inserta el curso a borrar");
					        borrarCadena= sc.nextLine();
					        borrarCadena.toUpperCase();
					        if(borrarCadena.length()!=2) {
					        	System.out.println("Error! -El código de curso debe contener 2 carácteres.");
					        	borrarCurso=false;
					        }
					        	borrarCurso=true;
					        }while(!borrarCurso);
					        
					        			// leemos fichero cursos
					        try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\cursos.txt"))) {
					        	
					        	// creamos las rutas y los ficheros del auxiliar
					        
								PrintWriter insercion2 = new PrintWriter("C:\\ProyectoCentro\\cursos2.txt");
								
								
					            cadena = lectura.readLine();
					            boolean noEncontrado = false;
					            for(int i= 0; cadena!= null; i++) {
					            	String[] datos = cadena.split(",");
					            	if( borrarCadena.equalsIgnoreCase(datos[0])) {
					            		System.out.print("El curso eliminado es el siguiente--> ");
					            		System.out.println(datos[0]+ datos[1]);
					            		noEncontrado = true;
					            		
					            	}else {
					            		
					            		
											insercion2.println(datos[0]+", "+datos[1]);
											
					            	}
					            	cadena= lectura.readLine();
					            }
					            if(noEncontrado==false) System.out.println("El curso no existe .");
					            file.close();
					            
					            insercion2.flush();
					            insercion2.close();
					            
					            File ficheroBorrar= new File("C:\\ProyectoCentro\\cursos.txt");// localizamos fichero
								ficheroBorrar.delete(); // borramos el fichero
								
								File ficheroRenombrar = new File("C:\\ProyectoCentro\\cursos2.txt"); // cambiamos el nombre al fichero auxiliar
								ficheroRenombrar.renameTo(ficheroBorrar);
					            
					        }
					        catch (FileNotFoundException e) {
					            System.out.println("No se ha encontrado el fichero.");
					        }
					        catch (IOException e) {
					            System.out.println(e.getMessage());
					        }
							
							break;
						case 3:
							System.out.println("----------------Mostrar Cursos----------------");
					        try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\cursos.txt"))) {
					        	
					            cadena = lectura.readLine();
					            for(int i= 0; cadena!= null; i++) {
					            	String[] datos = cadena.split(",");
					            	System.out.println(datos[0]+ datos[1]);// Prueba de lectura
					            	cadena= lectura.readLine();
					            
					            }
					        }
					        catch (FileNotFoundException e) {
					            System.out.println("No se ha encontrado el fichero.");
					        }
					        catch (IOException e) {
					            System.out.println(e.getMessage());
					        }
							break;
						}
					
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}while(!salirCursos);
					break;
				case 2:
					
					boolean salirAsignaturas = false;
					do {
						try {
							File ruta= new File("c:/ProyectoCentro");
							File f= new File(ruta,"cursosAsignaturas.txt");
							if(!f.exists()) {
								System.out.println("El fichero " + f.getName()+ " no existe.");
								if(!ruta.exists()) {
									System.out.println("El directorio "+ ruta.getName()+ " no existe");
									if(ruta.mkdir()) {
										System.out.println("La ruta "+ruta.getName()+" se ha creado correctamente");
										if(f.createNewFile()) {
											System.out.println("El fichero "+ f.getName()+" se ha creado correctamente");
										}else {
											System.out.println("No se ha podido crear "+f.getName());
										}
									}else {
										System.out.println("No se ha podido crear "+ruta.getName());
									}
								}else {// si la ruta existe creamos un fichero
									if(f.createNewFile()) {
										System.out.println("El fichero "+f.getName()+" se ha creado correctamente.");
									}else {
										System.out.println("No ha sido posible crear el fichero "+f.getName());
									}
								}
							}else {
								System.out.println("El directorio y fichero existen.");
							}
					
					System.out.println("\n*********MANTENIMIENTO ASIGNATURAS********");
					System.out.println("\n1. Alta Asignaturas.");
					System.out.println("\n2. Baja Asignaturas");
					System.out.println("\n3. Mostrar Asignaturas");
					System.out.println("\n0. Salir");
					System.out.println();
					System.out.println("Opcion Seleccionada: ");
					opcion= sc.nextInt();
					
						switch(opcion){
						case 0:
							salirAsignaturas= true;
							break;
						case 1:
							System.out.println("----------------Alta Asignaturas----------------");
							String asignatura,descripcion, cadena;
							FileReader file= null;
							boolean asigcorrecto = false;
							try(	FileWriter ficheroAsig= new FileWriter("C:\\ProyectoCentro\\cursosAsignaturas.txt",true);
									PrintWriter insercion = new PrintWriter(ficheroAsig)) {
									sc.nextLine();
								do {
								System.out.println("Introduce el codigo de la asignatura:");
								asignatura=sc.nextLine();
								asignatura.toUpperCase();
								if(asignatura.charAt(0)<'0' || asignatura.charAt(0) >'9') throw new InputMismatchException ("ERROR -- > El primer caracter del CURSO debe ser NUMÉRICO.");
									
									
									asigcorrecto= true;
								}while(!asigcorrecto);
								do{
									asigcorrecto=false;
									System.out.println("Introduce la descripcion del curso:");
									descripcion= sc.nextLine();
									if(descripcion.length()==0) throw new Exception ("La descripción no puede quedar vacía");
									
									asigcorrecto=true;
								}while(!asigcorrecto);
								
								
								try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\cursos.txt"))) {
									
								
						        	
						            cadena = lectura.readLine();
						            boolean comprobar = false;
						            for(int i= 0; cadena!= null; i++) {
						            	String[] datos = cadena.split(",");
						            	String CodAsig= asignatura.substring(0, 2);
						            	
						            	if(CodAsig.compareToIgnoreCase(datos[0])==0)  {// compareTo devuelve 0 si es true, 1 si es false.
						            		insercion.println(asignatura+", "+descripcion);
						            		comprobar = true;
						            	}

						            	cadena= lectura.readLine();
						            }
						            if(comprobar== false)throw new Exception("El código introducido no existe en Cursos.");
						            
						            }catch(Exception e) {
						            	System.out.println(e.getMessage());
						            }
								
								file.close();
								insercion.flush();
								insercion.close();
								
								
							}catch(FileNotFoundException e) {
								System.out.println("Error! Fichero no encontrado.");
							}
							
							break;
						case 2:
							System.out.println("----------------Baja Asignaturas----------------");
							 file = null;
					        String borrarCadena;
					        boolean borrarAsignatura=false;
					        sc.nextLine();
					        // datos para Auxiliar
					        
					        do {
					        System.out.println("Inserta la asignatura a borrar");
					        borrarCadena= sc.nextLine();
					        borrarCadena.toUpperCase();
					        if(borrarCadena.length()==0) throw new Exception("\"Error! -El código de curso no puede estar vacío.\"") ;
					        	
					        if(borrarCadena.charAt(0)<'0' || borrarCadena.charAt(0) >'9') throw new InputMismatchException ("Error! -- > El primer caracter de la ASIGNATURA debe ser NUMÉRICO.");
					        	
					        
					        borrarAsignatura=true;
					        }while(!borrarAsignatura);
					        
					        			// leemos fichero cursosAsignaturas
					        try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\cursosAsignaturas.txt"))) {
					        	
					        	// creamos las rutas y los ficheros del auxiliar
					        
								PrintWriter insercion2 = new PrintWriter("C:\\ProyectoCentro\\cursosAsignaturas2.txt");
								
								// cadena no se ha declarado variable porque ya lo estaba en un case mas arriba
					            cadena = lectura.readLine();
					            boolean noEncontrado =false;
					            for(int i= 0; cadena!= null; i++) {
					            	String[] datos = cadena.split(",");
					            	if( borrarCadena.equalsIgnoreCase(datos[0])) {
					            		System.out.print("La asignatura eliminada es la siguiente--> ");
					            		System.out.println(datos[0]+ datos[1]);
					            		noEncontrado=true;
					            		
					            	}else {
					            		
					            		
											insercion2.println(datos[0]+", "+datos[1]);
											
					            	}
					            	cadena= lectura.readLine();
					            }
					            if(noEncontrado==false) System.out.println("La asignatura no existe .");
					            
					            file.close();
					            
					            insercion2.flush();
					            insercion2.close();
					            
					            File ficheroBorrar= new File("C:\\ProyectoCentro\\cursosAsignaturas.txt");// localizamos fichero
								ficheroBorrar.delete(); // borramos el fichero
								
								File ficheroRenombrar = new File("C:\\ProyectoCentro\\cursosAsignaturas2.txt"); // cambiamos el nombre al fichero auxiliar
								ficheroRenombrar.renameTo(ficheroBorrar);
					            
					        }
					        catch (FileNotFoundException e) {
					            System.out.println("No se ha encontrado el fichero.");
					        }
					        catch (IOException e) {
					            System.out.println(e.getMessage());
					        }
							
							break;
							
						case 3:
							System.out.println("----------------Mostrar Asignaturas----------------");
							try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\cursosAsignaturas.txt"))) {
					        	
					            cadena = lectura.readLine();
					            for(int i= 0; cadena!= null; i++) {
					            	String[] datos = cadena.split(",");
					            	System.out.println(datos[0]+ datos[1]);// Prueba de lectura
					            	cadena= lectura.readLine();
					            
					            }
					        }
					        catch (FileNotFoundException e) {
					            System.out.println("No se ha encontrado el fichero.");
					        }
					        catch (IOException e) {
					            System.out.println(e.getMessage());
					        }
							break;
						}
					
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}while(!salirAsignaturas);
					break;
				case 3:
					
					boolean salirSucursales = false;
					do {
						try {
							File ruta= new File("c:/ProyectoCentro");
							File f= new File(ruta,"sucursales.txt");
							if(!f.exists()) {
								System.out.println("El fichero " + f.getName()+ " no existe.");
								if(!ruta.exists()) {
									System.out.println("El directorio "+ ruta.getName()+ " no existe");
									if(ruta.mkdir()) {
										System.out.println("La ruta "+ruta.getName()+" se ha creado correctamente");
										if(f.createNewFile()) {
											System.out.println("El fichero "+ f.getName()+" se ha creado correctamente");
										}else {
											System.out.println("No se ha podido crear "+f.getName());
										}
									}else {
										System.out.println("No se ha podido crear "+ruta.getName());
									}
								}else {// si la ruta existe creamos un fichero
									if(f.createNewFile()) {
										System.out.println("El fichero "+f.getName()+" se ha creado correctamente.");
									}else {
										System.out.println("No ha sido posible crear el fichero "+f.getName());
									}
								}
							}else {
								System.out.println("El directorio y fichero existen.");
							}
					
					System.out.println("\n*********MANTENIMIENTO SUCURSALES********");
					System.out.println("\n1. Alta Sucursal.");
					System.out.println("\n2. Baja Sucursal");
					System.out.println("\n3. Mostrar Sucursales");
					System.out.println("\n0. Salir");
					System.out.println();
					System.out.println("Opcion Seleccionada: ");
					opcion= sc.nextInt();
					
						switch(opcion){
						case 0:
							salirSucursales= true;
							break;
						case 1:
							System.out.println("----------------Alta Sucursal----------------");
							String sucursal,descripcion, cadena;
							FileReader file= null;
							boolean sucurcorrecto = false;
							try(	FileWriter ficheroSucur= new FileWriter("C:\\ProyectoCentro\\sucursales.txt",true);
									PrintWriter insercion = new PrintWriter(ficheroSucur)) {
									sc.nextLine();
								do {
								System.out.println("Introduce el codigo de la sucursal:");
								sucursal=sc.nextLine();
								sucursal.toUpperCase();
								if(sucursal.length()!=8) throw new InputMismatchException ("Error! -- > El código de sucursal debe tener 8 carácteres númericos.");
									
									
									sucurcorrecto= true;
								}while(!sucurcorrecto);
								do{
									sucurcorrecto=false;
									System.out.println("Introduce la descripcion del curso:");
									descripcion= sc.nextLine();
									if(descripcion.length()==0) throw new Exception ("La descripción no puede quedar vacía");
									
									sucurcorrecto=true;
								}while(!sucurcorrecto);
								
								
								try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\entidades.txt"))) {
									
								
						        	
						            cadena = lectura.readLine();
						            boolean comprobar = false;
						            for(int i= 0; cadena!= null; i++) {
						            	String[] datos = cadena.split(",");
						            	String CodSucur= sucursal.substring(0, 4);
						            	//System.out.println(CodSucur);
						            	
						            	if(CodSucur.equalsIgnoreCase(datos[0]))  {// compareTo devuelve 0 si es true, 1 si es false.
						            		insercion.println(sucursal+", "+descripcion);
						            		comprobar = true;
						            	}

						            	cadena= lectura.readLine();
						            }
						            //if(comprobar==true) insercion.println(sucursal+", "+descripcion);
						            if(comprobar== false)throw new Exception("El código introducido no existe en Bancos.");
						            
						            }catch(Exception e) {
						            	System.out.println(e.getMessage());
						            }
								
								file.close();
								insercion.flush();
								insercion.close();
								
								
							}catch(FileNotFoundException e) {
								System.out.println("Error! Fichero no encontrado.");
							}
							break;
						case 2:
							System.out.println("----------------Baja Sucursal----------------");
							 file = null;
					        String borrarCadena;
					        boolean borrarSucursal=false;
					        sc.nextLine();
					        // datos para Auxiliar
					        
					        do {
					        System.out.println("Inserta la sucursal a borrar");
					        borrarCadena= sc.nextLine();
					        borrarCadena.toUpperCase();
					        if(borrarCadena.length()==0) throw new Exception("\"Error! -El código de sucursal no puede estar vacío.\"") ;
					        	
					        if(borrarCadena.length()!=8) throw new InputMismatchException ("Error! -- > El código de sucursal debe tener 8 carácteres númericos.");
					        	
					        
					        borrarSucursal=true;
					        }while(!borrarSucursal);
					        
					        			// leemos fichero sucursales
					        try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\sucursales.txt"))) {
					        	
					        	// creamos las rutas y los ficheros del auxiliar
					        
								PrintWriter insercion2 = new PrintWriter("C:\\ProyectoCentro\\sucursales2.txt");
								
								// cadena no se ha declarado variable porque ya lo estaba en un case mas arriba
					            cadena = lectura.readLine();
					            boolean noEncontrado=false;
					            for(int i= 0; cadena!= null; i++) {
					            	String[] datos = cadena.split(",");
					            	if( borrarCadena.equalsIgnoreCase(datos[0])) {
					            		noEncontrado=true;
					            		System.out.print("La sucursal eliminada es la siguiente--> ");
					            		System.out.println(datos[0]+ datos[1]);
					            		
					            	}else {
					            		
					            		
											insercion2.println(datos[0]+", "+datos[1]);
											
					            	}
					            	cadena= lectura.readLine();
					            	
					            }
					            if(noEncontrado==false) System.out.println("La sucursal no existe .");
					            file.close();
					            
					            insercion2.flush();
					            insercion2.close();
					            
					            File ficheroBorrar= new File("C:\\ProyectoCentro\\sucursales.txt");// localizamos fichero
								ficheroBorrar.delete(); // borramos el fichero
								
								File ficheroRenombrar = new File("C:\\ProyectoCentro\\sucursales2.txt"); // cambiamos el nombre al fichero auxiliar
								ficheroRenombrar.renameTo(ficheroBorrar);
					            
					        }
					        catch (FileNotFoundException e) {
					            System.out.println("No se ha encontrado el fichero.");
					        }
					        catch (IOException e) {
					            System.out.println(e.getMessage());
					        }
							
							break;
						case 3:
							System.out.println("----------------MostrarSucursales----------------");
							
								file= null;
								try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\sucursales.txt"))) {
					        	
					            cadena = lectura.readLine();
					            for(int i= 0; cadena!= null; i++) {
					            	String[] datos = cadena.split(",");
					            	System.out.println(datos[0]+ datos[1]);// Prueba de lectura
					            	cadena= lectura.readLine();
					            
					            }
					        }
					        catch (FileNotFoundException e) {
					            System.out.println("No se ha encontrado el fichero.");
					        }
					        catch (IOException e) {
					            System.out.println(e.getMessage());
					        }
							break;
							
						}
					
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}while(!salirSucursales);
					
					break;
				case 4:
					boolean salirBancos = false;
					do {
						try {
							File ruta= new File("c:/ProyectoCentro");
							File f= new File(ruta,"entidades.txt");
							if(!f.exists()) {
								System.out.println("El fichero " + f.getName()+ " no existe.");
								if(!ruta.exists()) {
									System.out.println("El directorio "+ ruta.getName()+ " no existe");
									if(ruta.mkdir()) {
										System.out.println("La ruta "+ruta.getName()+" se ha creado correctamente");
										if(f.createNewFile()) {
											System.out.println("El fichero "+ f.getName()+" se ha creado correctamente");
										}else {
											System.out.println("No se ha podido crear "+f.getName());
										}
									}else {
										System.out.println("No se ha podido crear "+ruta.getName());
									}
								}else {// si la ruta existe creamos un fichero
									if(f.createNewFile()) {
										System.out.println("El fichero "+f.getName()+" se ha creado correctamente.");
									}else {
										System.out.println("No ha sido posible crear el fichero "+f.getName());
									}
								}
							}else {
								System.out.println("El directorio y fichero existen.");
							}
					
					System.out.println("\n*********MANTENIMIENTO BANCOS********");
					System.out.println("\n1. Alta Banco.");
					System.out.println("\n2. Baja Banco");
					System.out.println("\n3. Mostrar Bancos");
					System.out.println("\n0. Salir");
					System.out.println();
					System.out.println("Opcion Seleccionada: ");
					opcion= sc.nextInt();
					
						switch(opcion){
						case 0:
							salirBancos= true;
							break;
						case 1:
							System.out.println("----------------Alta Bancos----------------");
							
							String Banco,descripcion;
							
							try(	FileWriter fichero= new FileWriter("C:\\ProyectoCentro\\entidades.txt",true);
									PrintWriter insercion = new PrintWriter(fichero)) {
									sc.nextLine();

								System.out.println("Introduce el código del Banco:");
								Banco=sc.nextLine();
								
								if(Banco.length()!=4) throw new Exception("Error! -El código de Banco debe contener 4 carácteres.");
								if(Banco.length()==0) throw new Exception ("Error! -El código de Banco no puede quedar vacío.");
								
									//FILTRO PARA COMPROBAR SI LOS CARACTERES DEL CODIGO BANCARIO SON NÚMERICOS.  
								for (int i=0;i< Banco.length(); i++) {
						            if (Character.isDigit(Banco.charAt(i)) == false)throw new Exception("Error! -El código únicamente puede ser númerico");
								}

	
								System.out.println("Introduce la descripcion del Banco:");
								descripcion= sc.nextLine();
								
								if(descripcion.length()==0) throw new Exception ("Error! -La descripción no puede quedar vacía.");
								
							
								
								insercion.println(Banco+", "+descripcion);
								insercion.flush();
								insercion.close();
								
							}catch(FileNotFoundException e) {
								System.out.println("Error! Fichero no encontrado.");
							}
							
							
							break;
						case 2:
							System.out.println("----------------Baja Bancos----------------");
							 FileReader file = null;
						        String borrarCadena;
						        boolean borrarBanco=false;
						        sc.nextLine();
						        // datos para Auxiliar
						        
						        do {
						        System.out.println("Inserta el Banco a borrar");
						        borrarCadena= sc.nextLine();
						        borrarCadena.toUpperCase();
						        if(borrarCadena.length()==0) throw new Exception("\"Error! -El código de Banco no puede estar vacío.\"") ;
						        	
						        if(borrarCadena.length()!=4) throw new InputMismatchException ("Error! -- > El código de Banco debe tener 4 carácteres númericos.");
						        	
						        
						        borrarBanco=true;
						        }while(!borrarBanco);
						        
						        			// leemos fichero entidades
						        try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\entidades.txt"))) {
						        	
						        	// creamos las rutas y los ficheros del auxiliar
						        
									PrintWriter insercion2 = new PrintWriter("C:\\ProyectoCentro\\entidades2.txt");
									
									// cadena no se ha declarado variable porque ya lo estaba en un case mas arriba
						            String cadena = lectura.readLine();
						            boolean noEncontrado= false;
						            for(int i= 0; cadena!= null; i++) {
						            	String[] datos = cadena.split(",");
						            	if( borrarCadena.equalsIgnoreCase(datos[0])) {
						            		noEncontrado =true;
						            		System.out.print("El banco eliminado es el siguiente--> ");
						            		System.out.println(datos[0]+ datos[1]);

						            	}else {
												insercion2.println(datos[0]+", "+datos[1]);
												
						            	}
						            	cadena= lectura.readLine();
						            }
						            if(noEncontrado==false) System.out.println("Banco no existe .");
						            file.close();
						            
						            insercion2.flush();
						            insercion2.close();
						            
						            File ficheroBorrar= new File("C:\\ProyectoCentro\\entidades.txt");// localizamos fichero
									ficheroBorrar.delete(); // borramos el fichero
									
									File ficheroRenombrar = new File("C:\\ProyectoCentro\\entidades2.txt"); // cambiamos el nombre al fichero auxiliar
									ficheroRenombrar.renameTo(ficheroBorrar);
						            
						        }
						        catch (FileNotFoundException e) {
						            System.out.println("No se ha encontrado el fichero.");
						        }
						        catch (IOException e) {
						            System.out.println(e.getMessage());
						        }
								
							break;
						case 3:
							System.out.println("----------------Mostrar Bancos----------------");
							
							 file=null;
							try(BufferedReader lectura = new BufferedReader(file = new FileReader("C:\\ProyectoCentro\\entidades.txt"))) {
				        	
				            String cadena = lectura.readLine();
				            for(int i= 0; cadena!= null; i++) {
				            	String[] datos = cadena.split(",");
				            	System.out.println(datos[0]+ datos[1]);// Prueba de lectura
				            	cadena= lectura.readLine();
				            
				            }
				        }
				        catch (FileNotFoundException e) {
				            System.out.println("No se ha encontrado el fichero.");
				        }
				        catch (IOException e) {
				            System.out.println(e.getMessage());
				        }
							break;
						}
					
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}while(!salirBancos);
					break;
				}
				
			}catch(Exception e) {
				System.out.println("Error! Introduce un número!!");
			}
			
		}while(!correcto);
		

	}

}
