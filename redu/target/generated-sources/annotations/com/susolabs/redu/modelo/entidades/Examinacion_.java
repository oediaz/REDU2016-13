package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Examen;
import com.susolabs.redu.modelo.entidades.ExaminacionPK;
import com.susolabs.redu.modelo.entidades.Tratamientocancermama;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T07:20:39")
@StaticMetamodel(Examinacion.class)
public class Examinacion_ { 

    public static volatile SingularAttribute<Examinacion, String> descripcionexaminacion;
    public static volatile SingularAttribute<Examinacion, Tratamientocancermama> tratamientocancermama;
    public static volatile SingularAttribute<Examinacion, ExaminacionPK> examinacionPK;
    public static volatile ListAttribute<Examinacion, Examen> examenList;
    public static volatile SingularAttribute<Examinacion, String> observacionexaminacion;
    public static volatile SingularAttribute<Examinacion, Date> fechaexaminacion;

}