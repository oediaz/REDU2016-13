package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Biopsia;
import com.susolabs.redu.modelo.entidades.Birads;
import com.susolabs.redu.modelo.entidades.Cirugia;
import com.susolabs.redu.modelo.entidades.Examinacion;
import com.susolabs.redu.modelo.entidades.Medicacion;
import com.susolabs.redu.modelo.entidades.Quimioterapia;
import com.susolabs.redu.modelo.entidades.Radioterapia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-11T11:22:23")
@StaticMetamodel(Tratamientocancermama.class)
public class Tratamientocancermama_ { 

    public static volatile SingularAttribute<Tratamientocancermama, Date> fechainiciotcm;
    public static volatile SingularAttribute<Tratamientocancermama, String> descripciontcm;
    public static volatile SingularAttribute<Tratamientocancermama, String> observaciontcm;
    public static volatile ListAttribute<Tratamientocancermama, Biopsia> biopsiaList;
    public static volatile SingularAttribute<Tratamientocancermama, Birads> idbirads;
    public static volatile ListAttribute<Tratamientocancermama, Quimioterapia> quimioterapiaList;
    public static volatile ListAttribute<Tratamientocancermama, Cirugia> cirugiaList;
    public static volatile ListAttribute<Tratamientocancermama, Examinacion> examinacionList;
    public static volatile ListAttribute<Tratamientocancermama, Medicacion> medicacionList;
    public static volatile ListAttribute<Tratamientocancermama, Radioterapia> radioterapiaList;
    public static volatile SingularAttribute<Tratamientocancermama, Integer> idtrtamientocm;

}