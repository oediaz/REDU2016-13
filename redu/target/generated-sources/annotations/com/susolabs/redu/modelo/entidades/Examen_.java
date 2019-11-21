package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Resultadosexamen;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-21T11:49:38")
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile SingularAttribute<Examen, String> nombreexamen;
    public static volatile ListAttribute<Examen, Resultadosexamen> resultadosexamenList;
    public static volatile SingularAttribute<Examen, String> descripcionexamen;
    public static volatile SingularAttribute<Examen, Integer> idexamen;

}