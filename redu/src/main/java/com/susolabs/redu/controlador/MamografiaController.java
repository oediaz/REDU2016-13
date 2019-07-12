package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.MamografiaFacade;
import com.susolabs.redu.modelo.entidades.Mamografia;
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

@Named("mamografiaController")
@SessionScoped
public class MamografiaController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.MamografiaFacade ejbFacade;
    private List<Mamografia> items = null;
    private Mamografia selected;
    private List<Mamografia> seleccion;

    public MamografiaController() {
    }

    public List<Mamografia> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Mamografia> seleccion) {
        this.seleccion = seleccion;
    }

    
    
    public Mamografia getSelected() {
        return selected;
    }

    public void setSelected(Mamografia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getMamografiaPK().setIdlaboratorio(selected.getLaboratorio().getIdlaboratorio());
        selected.getMamografiaPK().setIdresponsablei(selected.getResponsableimagen().getIdresponsablei());
        selected.getMamografiaPK().setIdscreening(selected.getScreening().getIdscreening());
    }

    protected void initializeEmbeddableKey() {
        selected.setMamografiaPK(new com.susolabs.redu.modelo.entidades.MamografiaPK());
    }

    private MamografiaFacade getFacade() {
        return ejbFacade;
    }

    public Mamografia prepareCreate() {
        selected = new Mamografia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MamografiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MamografiaUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MamografiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Mamografia> getItems() {
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

    public Mamografia getMamografia(com.susolabs.redu.modelo.entidades.MamografiaPK id) {
        return getFacade().find(id);
    }

    public List<Mamografia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Mamografia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Mamografia.class)
    public static class MamografiaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MamografiaController controller = (MamografiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mamografiaController");
            return controller.getMamografia(getKey(value));
        }

        com.susolabs.redu.modelo.entidades.MamografiaPK getKey(String value) {
            com.susolabs.redu.modelo.entidades.MamografiaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.susolabs.redu.modelo.entidades.MamografiaPK();
            key.setIdscreening(Integer.parseInt(values[0]));
            key.setIdresponsablei(Integer.parseInt(values[1]));
            key.setIdlaboratorio(Integer.parseInt(values[2]));
            key.setIdmamografia(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(com.susolabs.redu.modelo.entidades.MamografiaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdscreening());
            sb.append(SEPARATOR);
            sb.append(value.getIdresponsablei());
            sb.append(SEPARATOR);
            sb.append(value.getIdlaboratorio());
            sb.append(SEPARATOR);
            sb.append(value.getIdmamografia());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Mamografia) {
                Mamografia o = (Mamografia) object;
                return getStringKey(o.getMamografiaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Mamografia.class.getName()});
                return null;
            }
        }

    }

}
