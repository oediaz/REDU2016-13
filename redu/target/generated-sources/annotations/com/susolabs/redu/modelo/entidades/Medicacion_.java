package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.MedicacionPK;
import com.susolabs.redu.modelo.entidades.Medicamento;
import com.susolabs.redu.modelo.entidades.Tratamientocancermama;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T07:20:39")
@StaticMetamodel(Medicacion.class)
public class Medicacion_ { 

    public static volatile SingularAttribute<Medicacion, MedicacionPK> medicacionPK;
    public static volatile SingularAttribute<Medicacion, Tratamientocancermama> tratamientocancermama;
    public static volatile ListAttribute<Medicacion, Medicamento> medicamentoList;
    public static volatile SingularAttribute<Medicacion, Date> fechamedicacion;
    public static volatile SingularAttribute<Medicacion, String> descripcionmedicacion;

}