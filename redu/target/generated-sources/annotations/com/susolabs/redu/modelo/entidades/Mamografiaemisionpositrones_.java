package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.MamografiaemisionpositronesPK;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Resultadosmamografiaep;
import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-10T12:28:38")
@StaticMetamodel(Mamografiaemisionpositrones.class)
public class Mamografiaemisionpositrones_ { 

    public static volatile SingularAttribute<Mamografiaemisionpositrones, String> razonmamografiaep;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, Responsableimagen> responsableimagen;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, Date> fechamamografiaep;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, Screening> screening;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, MamografiaemisionpositronesPK> mamografiaemisionpositronesPK;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, String> diagnosticopreviomamografiaep;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, String> observacionesmetastasisep;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, String> sensibilidadmetastasisep;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, Laboratorio> laboratorio;
    public static volatile SingularAttribute<Mamografiaemisionpositrones, String> especificadadmetastasisep;
    public static volatile ListAttribute<Mamografiaemisionpositrones, Resultadosmamografiaep> resultadosmamografiaepList;

}