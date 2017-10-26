package com.tmTransmiSurvey.view;

import com.tmTransmiSurvey.controller.PathFiles;
import com.tmTransmiSurvey.controller.Util;
import com.tmTransmiSurvey.controller.processor.ExportarDatosProcessor;
import sun.misc.resources.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name="reporteBean")
@ViewScoped
public class ReporteEncuestasBean {

    private String servicio;
    private List<String> serviciosRecords;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean visibleDescarga;

    @ManagedProperty(value="#{ExportarProcessor}")
    private ExportarDatosProcessor exportarDatosProcessor;

    @ManagedProperty("#{MessagesView}")
    private MessagesView messagesView;

    public ReporteEncuestasBean() {
    }

    @PostConstruct
    public void init() {
        visibleDescarga = false;
        servicio = "B11";
        serviciosRecords = new ArrayList<>();
        serviciosRecords.add("B11");
        serviciosRecords.add("K10");
        serviciosRecords.add("Todos");

    }

    public void exportarDatosEncuesta(){
        if(genracionValida()){
            boolean resultado= exportarDatosProcessor.exportarDatosEncuesta(fechaInicio,fechaFin,servicio);
            if(resultado) visibleDescarga = true;
        }else{

        }
    }

    private boolean genracionValida() {
        if(fechaInicio!=null && fechaFin!=null) return true;
        return false;
    }

    public void descargar(){
       String path = PathFiles.PATH+""+PathFiles.ASC_DES_TRONCAL;
        try {
            Util.descargarArchivo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public List<String> getServiciosRecords() {
        return serviciosRecords;
    }

    public void setServiciosRecords(List<String> serviciosRecords) {
        this.serviciosRecords = serviciosRecords;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isVisibleDescarga() {
        return visibleDescarga;
    }

    public void setVisibleDescarga(boolean visibleDescarga) {
        this.visibleDescarga = visibleDescarga;
    }

    public ExportarDatosProcessor getExportarDatosProcessor() {
        return exportarDatosProcessor;
    }

    public void setExportarDatosProcessor(ExportarDatosProcessor exportarDatosProcessor) {
        this.exportarDatosProcessor = exportarDatosProcessor;
    }

    public MessagesView getMessagesView() {
        return messagesView;
    }

    public void setMessagesView(MessagesView messagesView) {
        this.messagesView = messagesView;
    }
}
