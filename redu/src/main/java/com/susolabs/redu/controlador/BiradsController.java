package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.BiradsFacade;
import com.susolabs.redu.modelo.entidades.Birads;
import com.susolabs.redu.controlador.util.JsfUtil;
import com.susolabs.redu.controlador.util.JsfUtil.PersistAction;
import com.susolabs.redu.modelo.entidades.Paciente;
import com.susolabs.redu.modelo.entidades.Screening;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.Resultadosecografia;
import com.susolabs.redu.modelo.entidades.Resultadosmamografia;
import com.susolabs.redu.modelo.entidades.Resultadosmamografiaep;
import com.susolabs.redu.modelo.entidades.Resultadosresonanciamagnetica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("biradsController")
@SessionScoped
public class BiradsController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.BiradsFacade ejbFacade;
    @EJB
    private com.susolabs.redu.modelo.facade.PacienteFacade ejbPaciente;

    @EJB
    private com.susolabs.redu.modelo.facade.ScreeningFacade ejbScreening;

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadosecografiaFacade ejbREcografia;

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadosmamografiaFacade ejbRMamografia;

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadosmamografiaepFacade ejbRMamografiaep;

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadosresonanciamagneticaFacade ejbRResonancia;

    private List<Birads> items = null;
    private Birads selected;
    private List<Birads> seleccion;
    private Paciente filtropaciente = new Paciente();
    private Screening filtroscreening = new Screening();
    private Responsableimagen filtroresponsablei = new Responsableimagen();
    private Laboratorio filtrolaboratorio = new Laboratorio();
    private List<Screening> screPaciente = null;
    private List<Resultadosecografia> resultadosecografia = null;
    private List<Resultadosmamografia> resultadosmamografia = null;
    private List<Resultadosmamografiaep> resultadosmamografiaep = null;
    private List<Resultadosresonanciamagnetica> resultadosrm = null;

    public BiradsController() {
    }

    public List<Birads> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Birads> seleccion) {
        this.seleccion = seleccion;
    }

    public Birads getSelected() {
        return selected;
    }

    public void setSelected(Birads selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BiradsFacade getFacade() {
        return ejbFacade;
    }

    public Birads prepareCreate() {
        selected = new Birads();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BiradsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BiradsUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BiradsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Birads> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Birads getBirads(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Birads> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Birads> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public Paciente getFiltropaciente() {
        return filtropaciente;
    }

    public void setFiltropaciente(Paciente filtropaciente) {
        this.filtropaciente = filtropaciente;
    }

    public Screening getFiltroscreening() {
        return filtroscreening;
    }

    public void setFiltroscreening(Screening filtroscreening) {
        this.filtroscreening = filtroscreening;
    }

    public Responsableimagen getFiltroresponsablei() {
        return filtroresponsablei;
    }

    public void setFiltroresponsablei(Responsableimagen filtroresponsablei) {
        this.filtroresponsablei = filtroresponsablei;
    }

    public Laboratorio getFiltrolaboratorio() {
        return filtrolaboratorio;
    }

    public void setFiltrolaboratorio(Laboratorio filtrolaboratorio) {
        this.filtrolaboratorio = filtrolaboratorio;
    }

    public void filtrarscreening() {
        screPaciente = ejbPaciente.find(filtropaciente.getIdpaciente()).getScreeningList();
    }

    public void filtrar() {
        resultadosecografia = new ArrayList<Resultadosecografia>();
        resultadosmamografia = new ArrayList<Resultadosmamografia>();
        resultadosmamografiaep = new ArrayList<Resultadosmamografiaep>();
        resultadosrm = new ArrayList<Resultadosresonanciamagnetica>();
        try {
            List<Resultadosecografia> resultado = ejbREcografia.findAll();
            for (int i = 0; i < resultado.size(); i++) {
                if (Objects.equals(resultado.get(i).getIdecografia().getIdlaboratorio().getIdlaboratorio(), filtrolaboratorio.getIdlaboratorio())) {
                    if (Objects.equals(resultado.get(i).getIdecografia().getIdresponsablei().getIdresponsablei(), filtroresponsablei.getIdresponsablei())) {
                        if (Objects.equals(resultado.get(i).getIdecografia().getIdscreening().getIdscreening(), filtroscreening.getIdscreening())) {
                            resultadosecografia.add(resultado.get(i));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        try {
            List<Resultadosmamografia> resultadom = ejbRMamografia.findAll();
            for (int i = 0; i < resultadom.size(); i++) {
                if (Objects.equals(resultadom.get(i).getIdmamografia().getIdlaboratorio().getIdlaboratorio(), filtrolaboratorio.getIdlaboratorio())) {
                    if (Objects.equals(resultadom.get(i).getIdmamografia().getIdresponsablei().getIdresponsablei(), filtroresponsablei.getIdresponsablei())) {
                        if (Objects.equals(resultadom.get(i).getIdmamografia().getIdscreening().getIdscreening(), filtroscreening.getIdscreening())) {
                            resultadosmamografia.add(resultadom.get(i));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        try {
            List<Resultadosmamografiaep> resultadomep = ejbRMamografiaep.findAll();
            for (int i = 0; i < resultadomep.size(); i++) {
                if (Objects.equals(resultadomep.get(i).getIdmamografiaep().getIdlaboratorio().getIdlaboratorio(), filtrolaboratorio.getIdlaboratorio())) {
                    if (Objects.equals(resultadomep.get(i).getIdmamografiaep().getIdresponsablei().getIdresponsablei(), filtroresponsablei.getIdresponsablei())) {
                        if (Objects.equals(resultadomep.get(i).getIdmamografiaep().getIdscreening().getIdscreening(), filtroscreening.getIdscreening())) {
                            resultadosmamografiaep.add(resultadomep.get(i));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        try {
            List<Resultadosresonanciamagnetica> resultadorm = ejbRResonancia.findAll();
            for (int i = 0; i < resultadorm.size(); i++) {
                if (Objects.equals(resultadorm.get(i).getIdresonanciamagnetica().getIdlaboratorio().getIdlaboratorio(), filtrolaboratorio.getIdlaboratorio())) {
                    if (Objects.equals(resultadorm.get(i).getIdresonanciamagnetica().getIdresponsablei().getIdresponsablei(), filtroresponsablei.getIdresponsablei())) {
                        if (Objects.equals(resultadorm.get(i).getIdresonanciamagnetica().getIdscreening().getIdscreening(), filtroscreening.getIdscreening())) {
                            resultadosrm.add(resultadorm.get(i));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

    }

    public List<Resultadosmamografia> getResultadosmamografia() {
        if (resultadosmamografia == null) {
            return ejbRMamografia.findAll();
        }
        return resultadosmamografia;
    }

    public void setResultadosmamografia(List<Resultadosmamografia> resultadosmamografia) {
        this.resultadosmamografia = resultadosmamografia;
    }

    public List<Resultadosmamografiaep> getResultadosmamografiaep() {
        if (resultadosmamografiaep == null) {
            return ejbRMamografiaep.findAll();
        }
        return resultadosmamografiaep;
    }

    public void setResultadosmamografiaep(List<Resultadosmamografiaep> resultadosmamografiaep) {
        this.resultadosmamografiaep = resultadosmamografiaep;
    }

    public List<Resultadosresonanciamagnetica> getResultadosrm() {
        if (resultadosrm == null) {
            return ejbRResonancia.findAll();
        }
        return resultadosrm;
    }

    public void setResultadosrm(List<Resultadosresonanciamagnetica> resultadosrm) {
        this.resultadosrm = resultadosrm;
    }

    public List<Resultadosecografia> getResultadosecografia() {
        if (resultadosecografia == null) {
            return ejbREcografia.findAll();
        }
        return resultadosecografia;
    }

    public void setResultadosecografia(List<Resultadosecografia> resultadosecografia) {
        this.resultadosecografia = resultadosecografia;
    }

    public List<Screening> getScrePaciente() {
        if (screPaciente == null) {
            return ejbScreening.findAll();
        }
        return screPaciente;
    }

    public void setScrePaciente(List<Screening> screPaciente) {
        this.screPaciente = screPaciente;
    }

    @FacesConverter(forClass = Birads.class)
    public static class BiradsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BiradsController controller = (BiradsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "biradsController");
            return controller.getBirads(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Birads) {
                Birads o = (Birads) object;
                return getStringKey(o.getIdbirads());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Birads.class.getName()});
                return null;
            }
        }

    }

}
