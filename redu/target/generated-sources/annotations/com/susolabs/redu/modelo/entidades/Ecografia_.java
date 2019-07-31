package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Resultadosecografia;
import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T10:01:04")
@StaticMetamodel(Ecografia.class)
public class Ecografia_ { 

    public static volatile SingularAttribute<Ecografia, String> protocoloecografia;
    public static volatile SingularAttribute<Ecografia, Integer> idecografia;
    public static volatile SingularAttribute<Ecografia, Date> fechaecografia;
    public static volatile ListAttribute<Ecografia, Resultadosecografia> resultadosecografiaList;
    public static volatile SingularAttribute<Ecografia, String> razonecografia;
    public static volatile SingularAttribute<Ecografia, String> descripcionecografia;
    public static volatile SingularAttribute<Ecografia, Laboratorio> idlaboratorio;
    public static volatile SingularAttribute<Ecografia, String> observacionesprotocoloe;
    public static volatile SingularAttribute<Ecografia, Screening> idscreening;
    public static volatile SingularAttribute<Ecografia, Responsableimagen> idresponsablei;
    public static volatile SingularAttribute<Ecografia, String> observacionecografia;

}