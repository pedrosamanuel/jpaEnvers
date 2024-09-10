package org.example;

import org.example.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Manuel");

        try {
            entityManager.getTransaction().begin();
            Articulo articulo = Articulo.builder()
                    .cantidad(10)
                    .denominacion("Coca")
                    .precio(1500)
                    .build();
            List<Categoria> categorias = new ArrayList<>();
            Categoria categoria = Categoria.builder()
                    .denominacion("Gaseosa")
                    .build();
            categorias.add(categoria);
            articulo.setCategorias(categorias);
            Cliente cliente = Cliente.builder()
                    .apellido("Pedrosa")
                    .nombre("Manuel")
                    .dni(34666777)
                    .build();
            Domicilio domicilio = Domicilio.builder()
                    .nombreCalle("Ayacucho")
                    .numero(710)
                    .build();
            cliente.setDomicilio(domicilio);
            Factura factura = Factura.builder()
                    .fecha("20/10/2024")
                    .numero(4)
                    .total(3000)
                    .build();
            List<DetalleFactura> detalles = new ArrayList<>();
            DetalleFactura detalleFactura = DetalleFactura.builder()
                    .cantidad(2)
                    .subtotal(3000)
                    .articulo(articulo)
                    .factura(factura)
                    .build();
            detalles.add(detalleFactura);
            factura.setDetalles(detalles);
            factura.setCliente(cliente);

            entityManager.persist(factura);

            entityManager.getTransaction().commit();



        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar");}


        entityManager.close();
        entityManagerFactory.close();
    }
}