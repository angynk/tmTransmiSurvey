package com.tmTransmiSurvey.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name="menu")
@SessionScoped
public class MenuBean {

    public void refreshAscDescAbordo(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/secured/visualizarDatosEncuestas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshProcesamientoDatos(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/secured/procesarDatosEncuestas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshVisualizarReporte(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/secured/visualizarDatosEncuestas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
