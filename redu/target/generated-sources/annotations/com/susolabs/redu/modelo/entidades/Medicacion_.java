package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Receta;
import com.susolabs.redu.modelo.entidades.Tratamientocancermama;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-27T07:02:15")
@StaticMetamodel(Medicacion.class)
public class Medicacion_ { 

    public static volatile SingularAttribute<Medicacion, Date> fechamedicacion;
    public static volatile SingularAttribute<Medicacion, Integer> idmedicacion;
    public static volatile ListAttribute<Medicacion, Receta> recetaList;
    public static volatile SingularAttribute<Medicacion, String> descripcionmedicacion;
    public static volatile SingularAttribute<Medicacion, Tratamientocancermama> idtrtamientocm;

}