package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Resultadosecografia;
import com.susolabs.redu.modelo.entidades.Resultadosmamografia;
import com.susolabs.redu.modelo.entidades.Resultadosmamografiaep;
import com.susolabs.redu.modelo.entidades.Resultadosresonanciamagnetica;
import com.susolabs.redu.modelo.entidades.Tratamientocancermama;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-02T07:07:35")
@StaticMetamodel(Birads.class)
public class Birads_ { 

    public static volatile SingularAttribute<Birads, Integer> idbirads;
    public static volatile SingularAttribute<Birads, String> definicionbirads;
    public static volatile SingularAttribute<Birads, Integer> categoriabirads;
    public static volatile SingularAttribute<Birads, String> evaluacionbirads;
    public static volatile SingularAttribute<Birads, String> porcentajecancerbirads;
    public static volatile ListAttribute<Birads, Tratamientocancermama> tratamientocancermamaList;
    public static volatile SingularAttribute<Birads, Resultadosmamografiaep> idresultadosmep;
    public static volatile SingularAttribute<Birads, String> descripcionbirads;
    public static volatile SingularAttribute<Birads, Resultadosecografia> idresultadoe;
    public static volatile SingularAttribute<Birads, Resultadosmamografia> idresultadom;
    public static volatile SingularAttribute<Birads, Resultadosresonanciamagnetica> idresultadorm;
    public static volatile SingularAttribute<Birads, Date> fechabirads;
    public static volatile SingularAttribute<Birads, String> recomendacionbirads;
    public static volatile SingularAttribute<Birads, String> razonbirads;

}