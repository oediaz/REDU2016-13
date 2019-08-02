package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Ecografia;
import com.susolabs.redu.modelo.entidades.Mamografia;
import com.susolabs.redu.modelo.entidades.Mamografiaemisionpositrones;
import com.susolabs.redu.modelo.entidades.Medico;
import com.susolabs.redu.modelo.entidades.Paciente;
import com.susolabs.redu.modelo.entidades.Resonanciamagnetica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-02T09:15:30")
@StaticMetamodel(Screening.class)
public class Screening_ { 

    public static volatile SingularAttribute<Screening, String> observacionscreening;
    public static volatile ListAttribute<Screening, Mamografia> mamografiaList;
    public static volatile SingularAttribute<Screening, String> descripcionscreening;
    public static volatile SingularAttribute<Screening, Integer> idscreening;
    public static volatile SingularAttribute<Screening, Date> fechascreening;
    public static volatile SingularAttribute<Screening, String> metodoscreening;
    public static volatile SingularAttribute<Screening, Medico> idmedico;
    public static volatile SingularAttribute<Screening, Paciente> idpaciente;
    public static volatile ListAttribute<Screening, Ecografia> ecografiaList;
    public static volatile ListAttribute<Screening, Resonanciamagnetica> resonanciamagneticaList;
    public static volatile ListAttribute<Screening, Mamografiaemisionpositrones> mamografiaemisionpositronesList;

}