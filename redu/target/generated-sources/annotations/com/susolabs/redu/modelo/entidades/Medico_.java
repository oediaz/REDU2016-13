package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Screening;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-14T05:45:14")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile ListAttribute<Medico, Screening> screeningList;
    public static volatile SingularAttribute<Medico, String> fonomedico;
    public static volatile SingularAttribute<Medico, String> nombremedico;
    public static volatile SingularAttribute<Medico, String> tipomedico;
    public static volatile SingularAttribute<Medico, String> apellidomedico;
    public static volatile SingularAttribute<Medico, String> celularmedico;
    public static volatile SingularAttribute<Medico, Integer> idmedico;
    public static volatile SingularAttribute<Medico, String> direccionmedico;
    public static volatile SingularAttribute<Medico, String> mailmedico;
    public static volatile SingularAttribute<Medico, String> cedulamedico;

}