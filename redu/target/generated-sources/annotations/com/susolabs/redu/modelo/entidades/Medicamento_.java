package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Medicacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-10T12:28:38")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, String> nombremedicamento;
    public static volatile SingularAttribute<Medicamento, Integer> idmedicamento;
    public static volatile ListAttribute<Medicamento, Medicacion> medicacionList;
    public static volatile SingularAttribute<Medicamento, String> presentacionmedicamento;
    public static volatile SingularAttribute<Medicamento, String> nombregenericomedicamento;
    public static volatile SingularAttribute<Medicamento, String> descripcionmedicamento;

}