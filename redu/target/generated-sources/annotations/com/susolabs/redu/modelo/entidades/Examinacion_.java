package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Resultadosexamen;
import com.susolabs.redu.modelo.entidades.Tratamientocancermama;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-02T09:56:22")
@StaticMetamodel(Examinacion.class)
public class Examinacion_ { 

    public static volatile SingularAttribute<Examinacion, String> descripcionexaminacion;
    public static volatile ListAttribute<Examinacion, Resultadosexamen> resultadosexamenList;
    public static volatile SingularAttribute<Examinacion, String> observacionexaminacion;
    public static volatile SingularAttribute<Examinacion, Integer> idexaminacion;
    public static volatile SingularAttribute<Examinacion, Date> fechaexaminacion;
    public static volatile SingularAttribute<Examinacion, Tratamientocancermama> idtrtamientocm;

}