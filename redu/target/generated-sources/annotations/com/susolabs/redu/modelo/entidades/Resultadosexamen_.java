package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Examen;
import com.susolabs.redu.modelo.entidades.Examinacion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-02T07:07:35")
@StaticMetamodel(Resultadosexamen.class)
public class Resultadosexamen_ { 

    public static volatile SingularAttribute<Resultadosexamen, BigDecimal> datoelementoexamen;
    public static volatile SingularAttribute<Resultadosexamen, BigDecimal> valorminrefelemexamen;
    public static volatile SingularAttribute<Resultadosexamen, String> elementoexamen;
    public static volatile SingularAttribute<Resultadosexamen, Examinacion> idexaminacion;
    public static volatile SingularAttribute<Resultadosexamen, Integer> idresultadosexamen;
    public static volatile SingularAttribute<Resultadosexamen, BigDecimal> valormaxrefelemexamen;
    public static volatile SingularAttribute<Resultadosexamen, Examen> idexamen;

}