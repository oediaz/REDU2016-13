package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Birads;
import com.susolabs.redu.modelo.entidades.Mamografia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-02T09:15:30")
@StaticMetamodel(Resultadosmamografia.class)
public class Resultadosmamografia_ { 

    public static volatile SingularAttribute<Resultadosmamografia, String> gradosospechahallazgorem;
    public static volatile SingularAttribute<Resultadosmamografia, String> descripciongradosospechahallazgorem;
    public static volatile SingularAttribute<Resultadosmamografia, Mamografia> idmamografia;
    public static volatile SingularAttribute<Resultadosmamografia, String> clasificaciondistribucionhallazgorem;
    public static volatile SingularAttribute<Resultadosmamografia, Integer> idresultadom;
    public static volatile ListAttribute<Resultadosmamografia, Birads> biradsList;
    public static volatile SingularAttribute<Resultadosmamografia, String> tipohallazgorem;
    public static volatile SingularAttribute<Resultadosmamografia, String> descripcionhallazgorem;

}