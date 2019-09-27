package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Ecografia;
import com.susolabs.redu.modelo.entidades.Mamografia;
import com.susolabs.redu.modelo.entidades.Mamografiaemisionpositrones;
import com.susolabs.redu.modelo.entidades.Resonanciamagnetica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-27T07:02:15")
@StaticMetamodel(Laboratorio.class)
public class Laboratorio_ { 

    public static volatile SingularAttribute<Laboratorio, String> direccionlaboratorio;
    public static volatile ListAttribute<Laboratorio, Mamografia> mamografiaList;
    public static volatile SingularAttribute<Laboratorio, String> fonolaboratorio;
    public static volatile SingularAttribute<Laboratorio, String> nombrelaboratorio;
    public static volatile SingularAttribute<Laboratorio, Integer> idlaboratorio;
    public static volatile ListAttribute<Laboratorio, Ecografia> ecografiaList;
    public static volatile ListAttribute<Laboratorio, Resonanciamagnetica> resonanciamagneticaList;
    public static volatile ListAttribute<Laboratorio, Mamografiaemisionpositrones> mamografiaemisionpositronesList;

}