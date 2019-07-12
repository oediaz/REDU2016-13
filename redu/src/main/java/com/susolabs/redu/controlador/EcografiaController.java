package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.EcografiaFacade;
import com.susolabs.redu.modelo.entidades.Ecografia;
import com.susolabs.redu.controlador.util.JsfUtil;
import com.susolabs.redu.controlador.util.JsfUtil.PersistAction;

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

@Named("ecografiaController")
@SessionScoped
public class EcografiaController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.EcografiaFacade ejbFacade;
    private List<Ecografia> items = null;
    private Ecografia selected;
    private List<Ecografia> seleccion;

    public EcografiaController() {
    }

    public List<Ecografia> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Ecografia> seleccion) {
        this.seleccion = seleccion;
    }

    
    public Ecografia getSelected() {
        return selected;
    }

    public void setSelected(Ecografia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEcografiaPK().setIdscreening(selected.getScreening().getIdscreening());
        selected.getEcografiaPK().setIdlaboratorio(selected.getLaboratorio().getIdlaboratorio());
        selected.getEcografiaPK().setIdresponsablei(selected.getResponsableimagen().getIdresponsablei());
    }

    protected void initializeEmbeddableKey() {
        selected.setEcografiaPK(new com.susolabs.redu.modelo.entidades.EcografiaPK());
    }

    private EcografiaFacade getFacade() {
        return ejbFacade;
    }

    public Ecografia prepareCreate() {
        selected = new Ecografia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EcografiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EcografiaUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EcografiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Ecografia> getItems() {
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

    public Ecografia getEcografia(com.susolabs.redu.modelo.entidades.EcografiaPK id) {
        return getFacade().find(id);
    }

    public List<Ecografia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ecografia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ecografia.class)
    public static class EcografiaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EcografiaController controller = (EcografiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ecografiaController");
            return controller.getEcografia(getKey(value));
        }

        com.susolabs.redu.modelo.entidades.EcografiaPK getKey(String value) {
            com.susolabs.redu.modelo.entidades.EcografiaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.susolabs.redu.modelo.entidades.EcografiaPK();
            key.setIdscreening(Integer.parseInt(values[0]));
            key.setIdresponsablei(Integer.parseInt(values[1]));
            key.setIdlaboratorio(Integer.parseInt(values[2]));
            key.setIdecografia(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(com.susolabs.redu.modelo.entidades.EcografiaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdscreening());
            sb.append(SEPARATOR);
            sb.append(value.getIdresponsablei());
            sb.append(SEPARATOR);
            sb.append(value.getIdlaboratorio());
            sb.append(SEPARATOR);
            sb.append(value.getIdecografia());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ecografia) {
                Ecografia o = (Ecografia) object;
                return getStringKey(o.getEcografiaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ecografia.class.getName()});
                return null;
            }
        }

    }

}
