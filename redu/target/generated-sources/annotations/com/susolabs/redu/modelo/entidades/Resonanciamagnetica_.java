package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Resultadosresonanciamagnetica;
import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-21T11:49:38")
@StaticMetamodel(Resonanciamagnetica.class)
public class Resonanciamagnetica_ { 

    public static volatile SingularAttribute<Resonanciamagnetica, Integer> idresonanciamagnetica;
    public static volatile SingularAttribute<Resonanciamagnetica, Date> fecharm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> indicacionespecificidadrm;
    public static volatile SingularAttribute<Resonanciamagnetica, Screening> idscreening;
    public static volatile SingularAttribute<Resonanciamagnetica, String> descripcionrm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> patronreforzamientorm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> observacionrm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> razonrm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> observacionesprotocolorm;
    public static volatile SingularAttribute<Resonanciamagnetica, Laboratorio> idlaboratorio;
    public static volatile SingularAttribute<Resonanciamagnetica, String> protocolorm;
    public static volatile SingularAttribute<Resonanciamagnetica, Responsableimagen> idresponsablei;
    public static volatile ListAttribute<Resonanciamagnetica, Resultadosresonanciamagnetica> resultadosresonanciamagneticaList;

}