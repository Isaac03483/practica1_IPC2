package com.mycompany.baseDeDatos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.enums.EstadoMueble;
import com.mycompany.enums.TipoUsuario;
import com.mycompany.objetos.administracion.Usuario;
import com.mycompany.objetos.fabrica.Mueble;
import com.mycompany.objetos.fabrica.Pieza;
import com.mycompany.objetos.ventas.Cliente;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.objetos.ventas.MuebleEnsamblado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Select {
    
    private PreparedStatement query;

    public Select(){
        Conexion conexion = new Conexion();
    }

    public ResultSet selectMueblesDisponibles(String ensamblado){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE_DISPONIBLE);
            query.setString(1, ensamblado);
            resultado = query.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectTodosMueblesEnsamblados(String orden){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLES_ENSAMBLADOS+orden);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }
    
    public ResultSet    selectCantidadPiezasOrdenadas(String orden){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_ORDENADAS+orden);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch blockquery.setString(1, orden);
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectPiezasPorAcabar(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_ACABANDOSE);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectComprasDia(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_VENTAS_DEL_DIA);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCompras(String nit, String fechaInicial, String fechaFinal){

        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_COMPRA_CLIENTE);
            query.setString(1, nit);
            query.setString(2, fechaInicial);
            query.setString(3, fechaFinal);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectPiezasIndividuales(String tipoPieza, BigDecimal precio){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_INDIVIDUALES);
            query.setString(1, tipoPieza);
            query.setBigDecimal(2, precio);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectEnsamblePiezas(String nombre_mueble){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_ENSAMBLE_PIEZAS);
            query.setString(1, nombre_mueble);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    
    }

    public ResultSet selectMueble(String nombre_mueble){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE);
            query.setString(1, nombre_mueble);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    
    }

    public ResultSet selectPiezas(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    
    }

    public ResultSet selectPiezasParaEnsamble(String tipo_pieza){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_PIEZAS_PARA_ENSAMBLE);
            query.setString(1, tipo_pieza);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCantidadTotalPiezas(int cantidadPiezas){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_CANTIDAD_PIEZAS);
            query.setInt(1, cantidadPiezas);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectUsuario(String usuario){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_USUARIO);
            query.setString(1, usuario);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectUsuariosActivos(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_USUARIOS_ACTIVOS);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectCliente(String nit){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_CLIENTE);
            query.setString(1,nit);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectClientes(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_CLIENTES);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectMuebleSeleccionado(String id){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLE_SELECCIONADO);
            query.setString(1, id);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet selectMueblesAll(){
        ResultSet resultado = null;
        try {
            query = Conexion.conexion.prepareStatement(com.mycompany.operaciones.Constante.SELECT_MUEBLES);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public List<Mueble> getMuebles(){
        List<Mueble> muebles = new ArrayList<>();
        ResultSet datosMuebles = selectMueblesAll();

        try {
            while(datosMuebles.next()){
                muebles.add(new Mueble(datosMuebles.getString("nombre_mueble"), datosMuebles.getBigDecimal("precio")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return muebles;
    }

    public List<Pieza> getPiezasOrdenadas(String orden){

        List<Pieza> piezas = new ArrayList<>();
        ResultSet datosPiezas = selectCantidadPiezasOrdenadas(orden);

        try {
            while(datosPiezas.next()){
                piezas.add(new Pieza(datosPiezas.getString("tipo_pieza"), datosPiezas.getInt("Cantidad")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return piezas;
    }

    
    public List<MuebleEnsamblado> getMueblesCreados(String orden){
        List<MuebleEnsamblado> muebles = new ArrayList<>();
        ResultSet listaMuebles = selectTodosMueblesEnsamblados(orden);

        try {
            while(listaMuebles.next()){
                muebles.add(new MuebleEnsamblado(listaMuebles.getString("identificador_unico"), listaMuebles.getString("nombre_mueble"), listaMuebles.getString("usuario_ensamblo"),listaMuebles.getDate("fecha_ensamble"), listaMuebles.getBigDecimal("costo"), EstadoMueble.evaluar(listaMuebles.getString("estado"))));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return muebles;
    }

    public List<Pieza> getPiezasSeparadas(){
        List<Pieza> piezas = new ArrayList<>();
        ResultSet listaPiezas = selectPiezas();

        try {
            while(listaPiezas.next()){
                piezas.add(new Pieza(listaPiezas.getString("tipo_pieza"), listaPiezas.getBigDecimal("precio"), listaPiezas.getInt("cantidad")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return piezas;
    }

    public Usuario getUsuario(String nombreUsuario){
        Usuario usuario = null;
        ResultSet busqueda = selectUsuario(nombreUsuario);

        try {
            if(busqueda.next()){
                usuario = new Usuario(nombreUsuario, busqueda.getString("password"), TipoUsuario.evaluar(busqueda.getString("tipo")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usuario;
    }

    public List<Usuario> getUsuariosActivos(){

        List<Usuario> usuarios = new ArrayList<>();
        ResultSet listaUsuarios = selectUsuariosActivos();

        try {
            while(listaUsuarios.next()){
                usuarios.add(new Usuario(listaUsuarios.getString("nombre_usuario"), listaUsuarios.getString("password"), TipoUsuario.evaluar(listaUsuarios.getString("tipo"))));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usuarios;
    }

    public List<MuebleEnsamblado> getMueblesDisponibles(String ensamblado){
        List<MuebleEnsamblado> muebles = new ArrayList<>();
        ResultSet listaMuebles = selectMueblesDisponibles(ensamblado);

        try {
            while(listaMuebles.next()){
                muebles.add(new MuebleEnsamblado(listaMuebles.getString("identificador_unico"), listaMuebles.getString("nombre_mueble"), listaMuebles.getString("usuario_ensamblo"),listaMuebles.getDate("fecha_ensamble"), listaMuebles.getBigDecimal("costo"), EstadoMueble.evaluar(listaMuebles.getString("estado"))));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return muebles;
    }

    public Mueble getMueble(String nombreMueble){
        Mueble mueble=null;
        ResultSet resultadoMueble = selectMueble(nombreMueble);

        try {
            if(resultadoMueble.next()){
                mueble = new Mueble(resultadoMueble.getString("nombre_mueble"), resultadoMueble.getBigDecimal("precio"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        return mueble;
    }

    public MuebleEnsamblado getMuebleSelecionado(String id){
        MuebleEnsamblado mueble=null;
        ResultSet resultadoMueble = selectMuebleSeleccionado(id);

        try {
            if(resultadoMueble.next()){
                mueble = new MuebleEnsamblado(resultadoMueble.getString("identificador_unico"), resultadoMueble.getString("nombre_mueble"), resultadoMueble.getString("usuario_ensamblo"), resultadoMueble.getDate("fecha_ensamble"), 
                resultadoMueble.getBigDecimal("costo"), EstadoMueble.evaluar(resultadoMueble.getString("estado")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mueble;
    }
    
    public Cliente getCliente(String nit){
        Cliente cliente=null;
        ResultSet resultadoCliente = selectCliente(nit);

        try {
            if(resultadoCliente.next()){
                cliente = new Cliente(resultadoCliente.getString("nombre"), resultadoCliente.getString("nit"), resultadoCliente.getString("direccion"), resultadoCliente.getString("municipio"), resultadoCliente.getString("departamento"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return cliente;
    }

    public List<Cliente> getClientes(){
        List<Cliente> clientes = new ArrayList<>();
        ResultSet resultadoCliente = selectClientes();

        try {
            while(resultadoCliente.next()){
                clientes.add(new Cliente(resultadoCliente.getString("nombre"), resultadoCliente.getString("nit"), resultadoCliente.getString("direccion"), resultadoCliente.getString("municipio"), resultadoCliente.getString("departamento")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return clientes;
    }

    public List<Compra> getCompras(String nit, String fechaInicial, String fechaFinal){
        List<Compra> compras = new ArrayList<>();
        ResultSet resultadoCompras = selectCompras(nit, fechaInicial,fechaFinal);

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("registro_compra"),resultadoCompras.getString("nombre_usuario"), resultadoCompras.getString("identificador_mueble"), resultadoCompras.getString("nit"), resultadoCompras.getDate("fecha_compra"), resultadoCompras.getBigDecimal("total")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(NullPointerException e){
           System.err.println("Error nulo en fechas");
        }

        return compras;
    }

    public List<Compra> getVentasDia(){
        List<Compra> compras = new ArrayList<>();
        ResultSet resultadoCompras = selectComprasDia();

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("registro_compra"),resultadoCompras.getString("nombre_usuario"), resultadoCompras.getString("identificador_mueble"), resultadoCompras.getString("nit"), resultadoCompras.getDate("fecha_compra"), resultadoCompras.getBigDecimal("total")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(NullPointerException e){
           System.err.println("Error nulo en fechas");
        }

        return compras;
    }
    
}
