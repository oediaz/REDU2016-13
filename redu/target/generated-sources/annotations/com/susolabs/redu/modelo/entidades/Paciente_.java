package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T07:20:39")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile ListAttribute<Paciente, Screening> screeningList;
    public static volatile SingularAttribute<Paciente, String> apellidopaciente;
    public static volatile SingularAttribute<Paciente, String> celularpaciente;
    public static volatile SingularAttribute<Paciente, String> direccionpaciente;
    public static volatile SingularAttribute<Paciente, Date> fechanacimientopaciente;
    public static volatile SingularAttribute<Paciente, String> cedulapaciente;
    public static volatile SingularAttribute<Paciente, String> fonopaciente;
    public static volatile SingularAttribute<Paciente, String> mailpaciente;
    public static volatile SingularAttribute<Paciente, Integer> idpaciente;
    public static volatile SingularAttribute<Paciente, String> nombrepaciente;

}