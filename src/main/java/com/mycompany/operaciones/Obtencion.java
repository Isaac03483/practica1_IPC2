package com.mycompany.operaciones;

import com.mycompany.baseDeDatos.Select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.enums.EstadoMueble;
import com.mycompany.enums.TipoUsuario;
import com.mycompany.objetos.administracion.Usuario;
import com.mycompany.objetos.fabrica.Mueble;
import com.mycompany.objetos.fabrica.Pieza;
import com.mycompany.objetos.ventas.Caja;
import com.mycompany.objetos.ventas.Cliente;
import com.mycompany.objetos.ventas.Compra;
import com.mycompany.objetos.ventas.Devolucion;
import com.mycompany.objetos.ventas.MuebleEnsamblado;

public class Obtencion {
    
    private Select select;

    public Obtencion(){
        select = new Select();
    }

    public List<Mueble> getMuebles(){
        List<Mueble> muebles = new ArrayList<>();
        ResultSet datosMuebles = select.selectMueblesAll();

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
        ResultSet datosPiezas = select.selectCantidadPiezasOrdenadas(orden);

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
        ResultSet listaMuebles = select.selectTodosMueblesEnsamblados(orden);

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
        ResultSet listaPiezas = select.selectPiezas();

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
        ResultSet busqueda = select.selectUsuario(nombreUsuario);

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
        ResultSet listaUsuarios = select.selectUsuariosActivos();

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
        ResultSet listaMuebles = select.selectMueblesDisponibles(ensamblado);

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
        ResultSet resultadoMueble = select.selectMueble(nombreMueble);

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
        ResultSet resultadoMueble = select.selectMuebleSeleccionado(id);

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
        ResultSet resultadoCliente = select.selectCliente(nit);

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
        ResultSet resultadoCliente = select.selectClientes();

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
        ResultSet resultadoCompras = select.selectCompras(nit, fechaInicial,fechaFinal);

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("registro_compra"),resultadoCompras.getString("nombre_usuario"), resultadoCompras.getString("identificador_mueble"), resultadoCompras.getString("nit"), resultadoCompras.getDate("fecha_compra"), resultadoCompras.getBigDecimal("total")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        return compras;
    }

    public List<Compra> getVentasDia(){
        List<Compra> compras = new ArrayList<>();
        ResultSet resultadoCompras = select.selectComprasDia();

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("registro_compra"),resultadoCompras.getString("nombre_usuario"), resultadoCompras.getString("identificador_mueble"), resultadoCompras.getString("nit"), resultadoCompras.getDate("fecha_compra"), resultadoCompras.getBigDecimal("total")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return compras;
    }

    public Compra getCompra(int numeroCompra){
        Compra compra = null;
        ResultSet resultadoBusqueda = select.selectCompra(numeroCompra);

        try {
            if(resultadoBusqueda.next()){
                compra = new Compra(resultadoBusqueda.getInt("registro_compra"), resultadoBusqueda.getString("nombre_usuario"), resultadoBusqueda.getString("identificador_mueble"), resultadoBusqueda.getString("nit"), resultadoBusqueda.getDate("fecha_compra"), resultadoBusqueda.getBigDecimal("total"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return compra;
    }

    public List<Devolucion> getDevoluciones(String nit, String fechaInicial, String fechaFinal){
        List<Devolucion> devolucion = new ArrayList<>();
        ResultSet resultadoDevolucion = select.selectDevoluciones(nit, fechaInicial,fechaFinal);

        try {

            while(resultadoDevolucion.next()){
                devolucion.add(new Devolucion(resultadoDevolucion.getInt("registro_devolucion"),resultadoDevolucion.getString("nit"), resultadoDevolucion.getString("identificador_mueble"), resultadoDevolucion.getDate("fecha_devolucion"), resultadoDevolucion.getBigDecimal("perdida")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return devolucion;
    }

    public List<Pieza> getPiezasPorAcabar(){
        List<Pieza> piezas = new ArrayList<>();

        ResultSet listaPiezas = select.selectPiezasPorAcabar();

        try {
            while(listaPiezas.next()){
                piezas.add(new Pieza(listaPiezas.getString("tipo_pieza"), listaPiezas.getInt("total")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return piezas;
    }

    public MuebleEnsamblado getMuebleMasVendido(){
        MuebleEnsamblado muebleMasVendido = null;

        ResultSet resultadoMueble = select.selectMuebleMasVendido();

        try {
            if(resultadoMueble.next()){
                muebleMasVendido = new MuebleEnsamblado(resultadoMueble.getString("nombre_mueble"), resultadoMueble.getInt("cantidad"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(NullPointerException e){
            System.err.println("error reporte 1");
        }

        return muebleMasVendido;
    }

    public MuebleEnsamblado getMuebleMenosVendido(){
        MuebleEnsamblado muebleMasVendido = null;

        ResultSet resultadoMueble = select.selectMuebleMenosVendido();

        try {
            if(resultadoMueble.next()){
                muebleMasVendido = new MuebleEnsamblado(resultadoMueble.getString("nombre_mueble"), resultadoMueble.getInt("cantidad"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NullPointerException e){

        }

        return muebleMasVendido;
    }

    public List<Compra> getFacturaMuebleV(String nombreMueble, String fechaInicial, String fechaFinal){
        List<Compra> compras = new ArrayList<>();
        ResultSet resultadoCompras = select.selectFacturaMuebleV(nombreMueble, fechaInicial,fechaFinal);

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("registro_compra"),resultadoCompras.getString("nombre_usuario"), resultadoCompras.getString("identificador_mueble"), resultadoCompras.getString("nit"), resultadoCompras.getDate("fecha_compra"), resultadoCompras.getBigDecimal("total")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return compras;
    }

    public List<Compra> getReporteVentas(String fechaInicial, String fechaFinal){
        List<Compra> compras = new ArrayList<>();
        ResultSet resultadoCompras = select.selectReporteVentas(fechaInicial,fechaFinal);

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("registro_compra"),resultadoCompras.getString("nombre_usuario"), resultadoCompras.getString("identificador_mueble"), resultadoCompras.getString("nit"), resultadoCompras.getDate("fecha_compra"), resultadoCompras.getBigDecimal("total")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return compras;
    }

    public List<Devolucion> getReporteDevolucion(String fechaInicial, String fechaFinal){
        List<Devolucion> devolucion = new ArrayList<>();
        ResultSet resultadoDevolucion = select.selectReporteDevolucion(fechaInicial,fechaFinal);

        try {

            while(resultadoDevolucion.next()){
                devolucion.add(new Devolucion(resultadoDevolucion.getInt("registro_devolucion"),resultadoDevolucion.getString("nit"), resultadoDevolucion.getString("identificador_mueble"), resultadoDevolucion.getDate("fecha_devolucion"), resultadoDevolucion.getBigDecimal("perdida")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        return devolucion;
    }

    public List<Caja> getReporteGanancia(String fechaInicial, String fechaFinal){
        List<Caja> ganancia = new ArrayList<>();
        ResultSet resultadoGanancia = select.selectReporteGanancia(fechaInicial,fechaFinal);

        try {

            while(resultadoGanancia.next()){
                ganancia.add(new Caja(resultadoGanancia.getInt("registro_caja"),resultadoGanancia.getString("nombre_usuario"), resultadoGanancia.getString("identificador_mueble"),resultadoGanancia.getDate("fecha_registro"), resultadoGanancia.getBigDecimal("ganancia")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        return ganancia;
    }

    public List<Caja> getReporteUsuarioGanancias(String fechaInicial, String fechaFinal){
        List<Caja> ganancia = new ArrayList<>();
        ResultSet resultadoGanancia = select.selectReporteUsuarioGanancias(fechaInicial,fechaFinal);

        try {

            while(resultadoGanancia.next()){
                ganancia.add(new Caja(resultadoGanancia.getInt("caja.registro_caja"), resultadoGanancia.getString("caja.nombre_usuario"), resultadoGanancia.getString("mueble_ensamblado.nombre_mueble"), resultadoGanancia.getBigDecimal("caja.ganancia"), resultadoGanancia.getDate("fecha_registro")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        return ganancia;
    }

    public List<Compra> getReporteUsuarioVentas(String fechaInicial, String fechaFinal){
        List<Compra> compras = new ArrayList<>();
        ResultSet resultadoCompras = select.selectReporteUsuarioVentas(fechaInicial,fechaFinal);

        try {

            while(resultadoCompras.next()){
                compras.add(new Compra(resultadoCompras.getInt("compra.registro_compra"), resultadoCompras.getString("compra.nombre_usuario"), resultadoCompras.getString("mueble_ensamblado.nombre_mueble"), resultadoCompras.getBigDecimal("compra.total"), resultadoCompras.getDate("fecha_compra")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return compras;
    }
}
