package com.corenetworks.excepcionesFeb5.servicio.impl;

import com.corenetworks.excepcionesFeb5.modelo.Producto;
import com.corenetworks.excepcionesFeb5.repository.IGenericoRepositorio;
import com.corenetworks.excepcionesFeb5.repository.IProductoRepositorio;
import com.corenetworks.excepcionesFeb5.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioImpl extends CRUDImpl<Producto,Integer>implements IProductoServicio {
    @Autowired
    private IProductoRepositorio repo;
    @Override
    protected IGenericoRepositorio<Producto, Integer> getRepo() {
        return repo;
    }
}
