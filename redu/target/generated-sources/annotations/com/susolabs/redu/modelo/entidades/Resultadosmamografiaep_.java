package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Birads;
import com.susolabs.redu.modelo.entidades.Mamografiaemisionpositrones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-06T19:18:14")
@StaticMetamodel(Resultadosmamografiaep.class)
public class Resultadosmamografiaep_ { 

    public static volatile SingularAttribute<Resultadosmamografiaep, Mamografiaemisionpositrones> idmamografiaep;
    public static volatile SingularAttribute<Resultadosmamografiaep, String> causafalsopositivomep;
    public static volatile SingularAttribute<Resultadosmamografiaep, String> hallazgomep;
    public static volatile SingularAttribute<Resultadosmamografiaep, String> descripcionhallazgomep;
    public static volatile ListAttribute<Resultadosmamografiaep, Birads> biradsList;
    public static volatile SingularAttribute<Resultadosmamografiaep, Integer> idresultadosmep;
    public static volatile SingularAttribute<Resultadosmamografiaep, String> causafalsonegativomep;

}