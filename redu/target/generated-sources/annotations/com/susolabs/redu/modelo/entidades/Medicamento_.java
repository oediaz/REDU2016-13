package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Receta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T16:44:19")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, String> nombremedicamento;
    public static volatile SingularAttribute<Medicamento, Integer> idmedicamento;
    public static volatile ListAttribute<Medicamento, Receta> recetaList;
    public static volatile SingularAttribute<Medicamento, String> presentacionmedicamento;
    public static volatile SingularAttribute<Medicamento, String> nombregenericomedicamento;
    public static volatile SingularAttribute<Medicamento, String> descripcionmedicamento;

}