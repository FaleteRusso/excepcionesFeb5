package com.corenetworks.excepcionesFeb5.controlador;

import com.corenetworks.excepcionesFeb5.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.excepcionesFeb5.modelo.Producto;
import com.corenetworks.excepcionesFeb5.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    @Autowired
    private IProductoServicio servicio;

    @GetMapping

    public ResponseEntity<List<Producto>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listasTodos(), HttpStatus.OK);
    }

    @PostMapping

    public ResponseEntity<Producto> insertar(@RequestBody Producto p)throws Exception {
        Producto p1 = servicio.insertar(p);
        return new ResponseEntity<>(p1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarUno(@PathVariable("id") int id)throws Exception {
        Producto p1 = servicio.listarUno(id);
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Producto> modificar(@RequestBody Producto p)throws  Exception {
        Producto p1 = servicio.listarUno(p.getIdProducto());
        if (p1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +p.getIdProducto());
        }
        return new ResponseEntity<>(servicio.modificar(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Producto p1 = servicio.listarUno(id);
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
