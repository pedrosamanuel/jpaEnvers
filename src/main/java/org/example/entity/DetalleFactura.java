package org.example.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@Audited
public class DetalleFactura extends Base<Long> {
    private int cantidad;
    private int subtotal;
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

}
