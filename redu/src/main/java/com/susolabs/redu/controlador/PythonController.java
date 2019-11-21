package com.susolabs.redu.controlador;
import org.python.util.PythonInterpreter;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.Properties;

@Named("pythonController")
@SessionScoped
public class PythonController implements Serializable {

    private static final long serialVersionUID = 1L;

    public PythonController() {
    }

    public String codigo(String nombre){
    String valor="hola";
      PythonInterpreter interpreter = null;
    try{
            Properties p = new Properties();
           // p.setProperty("python.path", "PATH OF JYTHON");
           // p.setProperty("python.home", "PATH OF JYTHON");
           // p.setProperty("python.prefix", "PATH OF JYTHON");
            PythonInterpreter.initialize(System.getProperties(), p, new String[] {});
        interpreter = new PythonInterpreter();
        interpreter.execfile(nombre);
        valor=interpreter.get("x").toString();
    }catch(Exception ex){
        System.out.println("this exception");
        ex.printStackTrace();
    }
        return valor;
    }

}
