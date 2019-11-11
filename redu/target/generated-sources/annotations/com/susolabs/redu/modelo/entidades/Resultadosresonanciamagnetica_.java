package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Birads;
import com.susolabs.redu.modelo.entidades.Resonanciamagnetica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-11T12:39:57")
@StaticMetamodel(Resultadosresonanciamagnetica.class)
public class Resultadosresonanciamagnetica_ { 

    public static volatile SingularAttribute<Resultadosresonanciamagnetica, Resonanciamagnetica> idresonanciamagnetica;
    public static volatile SingularAttribute<Resultadosresonanciamagnetica, String> tipohallazgormm;
    public static volatile SingularAttribute<Resultadosresonanciamagnetica, String> descripcionhallazgorrm;
    public static volatile SingularAttribute<Resultadosresonanciamagnetica, Integer> idresultadorm;
    public static volatile ListAttribute<Resultadosresonanciamagnetica, Birads> biradsList;

}