package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.ScreeningFacade;
import com.susolabs.redu.modelo.entidades.Screening;
import com.susolabs.redu.controlador.util.JsfUtil;
import com.susolabs.redu.controlador.util.JsfUtil.PersistAction;
import com.susolabs.redu.modelo.entidades.Paciente;

import java.io.Serializable;
import java.util.List;
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

@Named("screeningController")
@SessionScoped
public class ScreeningController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.ScreeningFacade ejbFacade;
    
    @EJB
    private com.susolabs.redu.modelo.facade.PacienteFacade ejbPaciente;
    
    private List<Screening> items = null;
    private List<Screening> screPaciente = null;
    private Screening selected;
    private Paciente filtro = new Paciente();
    private List<Screening> seleccion;

    public ScreeningController() {
    }

    public List<Screening> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Screening> seleccion) {
        this.seleccion = seleccion;
    }

    public Screening getSelected() {
        return selected;
    }

    public void setSelected(Screening selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ScreeningFacade getFacade() {
        return ejbFacade;
    }

    public Screening prepareCreate() {
        selected = new Screening();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ScreeningCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ScreeningUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ScreeningDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Screening> getItems() {
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

    public Screening getScreening(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Screening> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Screening> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Screening.class)
    public static class ScreeningControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ScreeningController controller = (ScreeningController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "screeningController");
            return controller.getScreening(getKey(value));
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
            if (object instanceof Screening) {
                Screening o = (Screening) object;
                return getStringKey(o.getIdscreening());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Screening.class.getName()});
                return null;
            }
        }

    }

    public Paciente getFiltro() {
        return filtro;
    }

    public void setFiltro(Paciente filtro) {
        this.filtro = filtro;
    }

    public void filtrar() {
        screPaciente = ejbPaciente.find(filtro.getIdpaciente()).getScreeningList();
    }

    public List<Screening> getScrePaciente() {
        if(screPaciente == null){
            return ejbFacade.findAll();
        }
        return screPaciente;
    }

    public void setScrePaciente(List<Screening> screPaciente) {
        this.screPaciente = screPaciente;
    }
    
    

}
