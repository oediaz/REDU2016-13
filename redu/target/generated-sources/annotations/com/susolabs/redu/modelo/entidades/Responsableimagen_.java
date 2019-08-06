package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Ecografia;
import com.susolabs.redu.modelo.entidades.Mamografia;
import com.susolabs.redu.modelo.entidades.Mamografiaemisionpositrones;
import com.susolabs.redu.modelo.entidades.Resonanciamagnetica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-05T09:03:28")
@StaticMetamodel(Responsableimagen.class)
public class Responsableimagen_ { 

    public static volatile ListAttribute<Responsableimagen, Mamografia> mamografiaList;
    public static volatile SingularAttribute<Responsableimagen, String> fonoresponsablei;
    public static volatile SingularAttribute<Responsableimagen, String> mailresponsablei;
    public static volatile SingularAttribute<Responsableimagen, String> nombreresponsablei;
    public static volatile SingularAttribute<Responsableimagen, Integer> idresponsablei;
    public static volatile SingularAttribute<Responsableimagen, String> cedularesponsablei;
    public static volatile SingularAttribute<Responsableimagen, String> celularresponsablei;
    public static volatile ListAttribute<Responsableimagen, Ecografia> ecografiaList;
    public static volatile ListAttribute<Responsableimagen, Resonanciamagnetica> resonanciamagneticaList;
    public static volatile ListAttribute<Responsableimagen, Mamografiaemisionpositrones> mamografiaemisionpositronesList;

}