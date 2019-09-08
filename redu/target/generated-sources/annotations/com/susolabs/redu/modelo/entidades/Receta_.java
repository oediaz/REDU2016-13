package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Medicacion;
import com.susolabs.redu.modelo.entidades.Medicamento;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:26:23")
@StaticMetamodel(Receta.class)
public class Receta_ { 

    public static volatile SingularAttribute<Receta, String> frecuenciamedicacion;
    public static volatile SingularAttribute<Receta, BigDecimal> docismedicamento;
    public static volatile SingularAttribute<Receta, Medicamento> idmedicamento;
    public static volatile SingularAttribute<Receta, Medicacion> idmedicacion;
    public static volatile SingularAttribute<Receta, Integer> idreceta;

}