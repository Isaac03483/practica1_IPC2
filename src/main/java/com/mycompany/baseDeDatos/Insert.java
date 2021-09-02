package com.mycompany.baseDeDatos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Insert {

    private PreparedStatement query;

    public Insert() {
        Conexion conexion = new Conexion();
    }

    protected void insertarCliente(com.mycompany.objetos.ventas.Cliente cliente)throws SQLException{

        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_CLIENTE);
        query.setString(1, volverMinuscula(cliente.getNit()));
        query.setString(2, volverMinuscula(cliente.getNombre()));
        query.setString(3, volverMinuscula(cliente.getDireccion()));
        query.setString(4, volverMinuscula(cliente.getMunicipio()));
        query.setString(5, volverMinuscula(cliente.getDepartamento()));
        query.executeUpdate();
    }

    protected void insertarUsuario(com.mycompany.objetos.administracion.Usuario usuario) throws SQLException{

        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_USUARIO);
        query.setString(1, usuario.getNombreUsuario());
        query.setString(2, usuario.getPassword());
        query.setString(3, usuario.getTipoUsuario().getArea());
        query.executeUpdate();
    }

    protected void insertarCompra(com.mycompany.objetos.ventas.Compra compra) throws SQLException{

        Date fecha = new Date();
        
        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_COMPRA);
        query.setString(1, compra.getNombreUsuario());
        query.setString(2, compra.getIdentificadorMueble());
        query.setString(3, volverMinuscula(compra.getNit()));
        query.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(compra.getFecha())));
        query.setBigDecimal(5, compra.getTotal());
        query.executeUpdate();
        
    }

    protected void insertarMueble(com.mycompany.objetos.fabrica.Mueble mueble) throws SQLException{

        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_MUEBLE);
        query.setString(1, volverMinuscula(mueble.getNombreMueble()));
        query.setBigDecimal(2, mueble.getPrecio());
        query.executeUpdate();
            
        
    }

    protected void insertarMuebleEnsamblado(com.mycompany.objetos.ventas.MuebleEnsamblado muebleE) throws SQLException{

        agregarMuebleEnsamblado(muebleE);
        
    }

    protected void insertarPieza(com.mycompany.objetos.fabrica.Pieza pieza) throws SQLException{

        agregarPieza(pieza);
        
    }

    protected void insertarEnsamble(com.mycompany.objetos.fabrica.EnsamblePieza ensamble) throws SQLException{

        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_ENSAMBLE_PIEZA);
        query.setString(1, volverMinuscula(ensamble.getNombreMueble()));
        query.setString(2, volverMinuscula(ensamble.getTipoPieza()));
        query.setInt(3, ensamble.getCantidadPieza());
        query.executeUpdate();
    }

    protected void insertarDevolucion(com.mycompany.objetos.ventas.Devolucion devolucion) throws SQLException{

        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_DEVOLUCION);
        query.setInt(1, devolucion.getRegistroDevolucion());
        query.setString(2, devolucion.getIdentificadorMueble());
        query.setDate(3, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(devolucion.getFecha())));
        query.setBigDecimal(4, devolucion.getPerdida());
        query.setString(5, devolucion.getNit());
        query.executeUpdate();
     
    }

    protected void insertarCaja(com.mycompany.objetos.ventas.Caja caja)throws SQLException{
        query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_CAJA);
        query.setString(1, caja.getIdentificador());
        query.setString(2, caja.getUsuario());
        query.setString(3, caja.getTipoRegistro().getTipo());
        query.setBigDecimal(4, caja.getGanancia());
        query.setBigDecimal(5, caja.getPerdida());
        query.setDate(6, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(caja.getFechaRegistro())));
        query.executeUpdate();
    }

    private void agregarPieza(com.mycompany.objetos.fabrica.Pieza pieza) throws SQLException{
        
        if(new Select().selectPiezasIndividuales(pieza.getTipoPieza(), pieza.getPrecio()).next()){

            Update update = new Update();
            update.updateAumentarCantidad(pieza.getCantidad(), volverMinuscula(pieza.getTipoPieza()), pieza.getPrecio());
            
        } else {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_PIEZA);
            query.setString(1, volverMinuscula(pieza.getTipoPieza()));
            query.setBigDecimal(2, pieza.getPrecio());
            query.setInt(3, pieza.getCantidad());
            query.executeUpdate();
        }
    }

    private void agregarMuebleEnsamblado(com.mycompany.objetos.ventas.MuebleEnsamblado muebleE) throws SQLException{

        Select select = new Select();
        ResultSet resultadoReceta = select.selectEnsamblePiezas(muebleE.getMuebleEnsamblar()); //obtenemos ResultSet de la entidad ensamble_pieza(nombre_mueble, tipo_pieza, cantidad)
        ArrayList<com.mycompany.objetos.fabrica.EnsamblePieza> piezasEnsamblar = new ArrayList<>();
        boolean ensamblePermitido = true;
        
        double costoMueble = 0;
        

        while(resultadoReceta.next()){ //recorremos el ResultSet que contiene todos los ingredientes para la elaboración de nuestro mueble y los agregamos a un arrayList
            piezasEnsamblar.add(new com.mycompany.objetos.fabrica.EnsamblePieza(resultadoReceta.getString("nombre_mueble"), resultadoReceta.getString("tipo_pieza"), resultadoReceta.getInt("cantidad_pieza")));
        }

        if(piezasEnsamblar.size() > 0){ //si el tamaño del array es mayor a 0 significa que si tiene una receta para su elaboración

            ArrayList<ResultSet> resultadoPiezasEnsamble = new ArrayList<>(); //array de ResultSet que contendra todas las piezas necesarias para la elaboración del mueble
            ArrayList<com.mycompany.objetos.fabrica.Pieza> piezas = new ArrayList<>();

            for(com.mycompany.objetos.fabrica.EnsamblePieza piezasEnsamble: piezasEnsamblar){
                
                resultadoPiezasEnsamble.add(select.selectPiezasParaEnsamble(piezasEnsamble.getTipoPieza())); //agregamos al array de ResultSet todas piezas necesarias, este ResultSet es de la entidad pieza
                
                
            }
            
            for(int i = 0; i < resultadoPiezasEnsamble.size(); i++){ //ciclo improvisado utilizado para almacenar todas las piezas que haya en los resultSet
                while(resultadoPiezasEnsamble.get(i).next()){
                    if(resultadoPiezasEnsamble.get(i).getInt("cantidad") > 0){
                        piezas.add(new com.mycompany.objetos.fabrica.Pieza(resultadoPiezasEnsamble.get(i).getString("tipo_pieza"), resultadoPiezasEnsamble.get(i).getBigDecimal("precio"), resultadoPiezasEnsamble.get(i).getInt("cantidad")));
                    }
                }
            }

            if(piezas.size() > 0){ //si las piezas son mayores a 0 significa que si se encuentran disponibles por lo que sí se puede verificar que se posean las piezas necesarias para la elaboración del mueble
                int piezasEncontradas = 0;
                for(com.mycompany.objetos.fabrica.EnsamblePieza receta: piezasEnsamblar){ //ciclo que recorre el recetario
                    int piezasFaltantes = receta.getCantidadPieza();
                    for(int i = 0; i < piezas.size(); i++){ //ciclo que recorre todas las piezas que serán utilizadas

                        if(receta.getTipoPieza().equals(piezas.get(i).getTipoPieza())){ //verificamos que los nombres de las piezas coincidan para poder comparar cantidades
                            System.out.println("Entra 1"); //mensaje prueba para ver en dónde fallaba el código dx
                            int piezasUtilizadas = 0;
                            
                            if(piezas.get(i).getCantidad() - piezasFaltantes >= 0){ //verificamos si basta con solo un registro de pieza para poder ensamblar el mueble
                                piezasUtilizadas = piezasFaltantes; //si la resta de las piezas en la BD con las piezas faltantes es mayor a 0 significa que se poseen más o igual cantidad de piezas necesarias, por lo que las piezas utilizadas serían igual a las piezas faltantes
                                piezas.get(i).setCantidad(piezas.get(i).getCantidad()-piezasFaltantes); //cambiamos el valor de las piezas restandole la cantidad de piezas faltantes
                                piezasFaltantes = 0; //ya que la resta es mayor o igual a 0 entonces inevitablemente la cantidad de piezas faltantes sería 0

                            } else if(piezasFaltantes - piezas.get(i).getCantidad() > 0 && piezas.get(i).getCantidad() > 0) { //de no ser así verificamos que la resta de las piezas necesarias y la de las piezas sea mayor a 0 (las piezas también deben ser mayor a 0)
                                piezasUtilizadas = piezas.get(i).getCantidad(); //las piezas utilizadas en este caso solo serían las piezas que posee esa tupla de piezas
                                piezas.get(i).setCantidad(0); //ya que se usan todas las piezas de esa tupla, se actualiza su valor a 0
                                piezasFaltantes = piezasFaltantes - piezasUtilizadas; //guardamos la cantidad de piezas faltantes para hacer las verificaciones
                            } else if(piezas.get(i).getCantidad() == 0){
                                break;
                            }

                            if(piezasFaltantes == 0 && ensamblePermitido == true){ //verificación para ver si ya se han encontrado todas las piezas faltantes
                                System.out.println("Entra 2"); //segundo mensaje de prueba
                                piezasEncontradas++; //ya que el valor de las piezas faltantes es 0 significa que se han encontrado todas y se puede aumentar el contador
                                costoMueble+=piezas.get(i).getPrecio().doubleValue()*piezasUtilizadas; //obtenemos el costo del mueble agregandole el precio de la pieza multiplicada por el número de piezas utilizadas
                                break;
                            } else if(piezasFaltantes > piezasUtilizadas && piezasUtilizadas > 0){ //si las piezas faltantes es mayor al número de piezas encontradas pero se han utilizado algunas piezas entonces aún así se debe agregar el costo de dicha pieza utilizada
                                costoMueble+=piezas.get(i).getPrecio().doubleValue()*piezasUtilizadas;//igual que arriba
                                continue; //utiliza continue ya que no se han encontrado todas las piezas y se debe seguir buscando
                            } else if(piezasFaltantes > 0 && ensamblePermitido == true && i == piezas.size()){ //si todavía hay piezas faltantes y el iterador ya ha llegado al último valor significa que no encontró el número de piezas necesarias para la elaboración del producto
                                ensamblePermitido = false;
                            }
                        }
                    } 
                    
                    if(ensamblePermitido == false){
                        break;
                    }
                }

                if(ensamblePermitido == true && piezasEncontradas == piezasEnsamblar.size()){ //hace el update e insert si el ensamble es permitido y el número de piezas encontradas es igual al número de piezas necesarias en la receta
                    Update update = new Update();
                    for(com.mycompany.objetos.fabrica.Pieza piezasActualizadas: piezas){
                        update.updateCantidadPiezas(piezasActualizadas.getCantidad(), volverMinuscula(piezasActualizadas.getTipoPieza()), piezasActualizadas.getPrecio());
                    }

                    query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.INSERT_MUEBLE_ENSAMBLADO);
                    query.setString(1, muebleE.getIdentificadorUnico());
                    query.setString(2, volverMinuscula(muebleE.getMuebleEnsamblar()));
                    query.setString(3, muebleE.getUsuarioEnsamblo());
                    query.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat(com.mycompany.operaciones.Constante.FORMATO_FECHA_SQL).format(muebleE.getFechaEnsamble())));
                    query.setBigDecimal(5, new BigDecimal(costoMueble));
                    query.setString(6, muebleE.getEstadoMueble().getEstado());
                    query.executeUpdate();
                } else {
                    System.err.println("\n\n\n\n\nNo posee todas las piezas para la elaboración del mueble. error 2");
                }
            }else {
                System.err.println("\n\n\n\n\nNo posee todas las piezas para la elaboración del mueble. error 1");
            }
        }
    }

    private String volverMinuscula(String dato){
        return dato.toLowerCase();
    }
    
}
