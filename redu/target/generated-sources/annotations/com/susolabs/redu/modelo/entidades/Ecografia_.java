package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.EcografiaPK;
import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Resultadosecografia;
import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-10T12:28:38")
@StaticMetamodel(Ecografia.class)
public class Ecografia_ { 

    public static volatile SingularAttribute<Ecografia, String> protocoloecografia;
    public static volatile SingularAttribute<Ecografia, Responsableimagen> responsableimagen;
    public static volatile SingularAttribute<Ecografia, Date> fechaecografia;
    public static volatile SingularAttribute<Ecografia, Screening> screening;
    public static volatile ListAttribute<Ecografia, Resultadosecografia> resultadosecografiaList;
    public static volatile SingularAttribute<Ecografia, EcografiaPK> ecografiaPK;
    public static volatile SingularAttribute<Ecografia, String> razonecografia;
    public static volatile SingularAttribute<Ecografia, String> descripcionecografia;
    public static volatile SingularAttribute<Ecografia, String> observacionesprotocoloe;
    public static volatile SingularAttribute<Ecografia, Laboratorio> laboratorio;
    public static volatile SingularAttribute<Ecografia, String> observacionecografia;

}