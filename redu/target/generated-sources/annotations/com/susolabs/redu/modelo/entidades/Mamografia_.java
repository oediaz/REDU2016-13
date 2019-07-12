package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.MamografiaPK;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Resultadosmamografia;
import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-10T12:28:38")
@StaticMetamodel(Mamografia.class)
public class Mamografia_ { 

    public static volatile SingularAttribute<Mamografia, String> patronparenquimagrandularm;
    public static volatile SingularAttribute<Mamografia, Screening> screening;
    public static volatile ListAttribute<Mamografia, Resultadosmamografia> resultadosmamografiaList;
    public static volatile SingularAttribute<Mamografia, String> protocolomamografia;
    public static volatile SingularAttribute<Mamografia, MamografiaPK> mamografiaPK;
    public static volatile SingularAttribute<Mamografia, String> caracteristicapredominantem;
    public static volatile SingularAttribute<Mamografia, Laboratorio> laboratorio;
    public static volatile SingularAttribute<Mamografia, String> observacionesprotocolom;
    public static volatile SingularAttribute<Mamografia, Responsableimagen> responsableimagen;
    public static volatile SingularAttribute<Mamografia, Date> fechamamografia;
    public static volatile SingularAttribute<Mamografia, String> patrondensidadm;
    public static volatile SingularAttribute<Mamografia, String> estimacionvisualdensidadm;
    public static volatile SingularAttribute<Mamografia, String> patrongrasam;

}