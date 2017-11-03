package com.tmTransmiSurvey.controller.servicios;

import com.tmTransmiSurvey.model.dao.CuadroEncuestaDao;
import com.tmTransmiSurvey.model.dao.RegistroEncuestaAscDescDao;
import com.tmTransmiSurvey.model.entity.CuadroEncuesta;
import com.tmTransmiSurvey.model.entity.RegistroEncuestaAscDesc;
import com.tmTransmiSurvey.model.entity.ServicioTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EncuestaAscDescServicio {

    @Autowired
    private CuadroEncuestaDao cuadroEncuestaDao;
    @Autowired
    private RegistroEncuestaAscDescDao registroEncuestaAscDescDao;

    public EncuestaAscDescServicio() {
    }

    public void addRegistroEncuestaAscDesc(RegistroEncuestaAscDesc registro) {
        registroEncuestaAscDescDao.addRegistroEncuestaAscDesc(registro);
    }

    public void addCuadroEncuesta(CuadroEncuesta cuadroEncuesta) {
        cuadroEncuestaDao.addCuadroEncuesta(cuadroEncuesta);
    }

    public CuadroEncuestaDao getCuadroEncuestaDao() {
        return cuadroEncuestaDao;
    }

    public void setCuadroEncuestaDao(CuadroEncuestaDao cuadroEncuestaDao) {
        this.cuadroEncuestaDao = cuadroEncuestaDao;
    }

    public RegistroEncuestaAscDescDao getRegistroEncuestaAscDescDao() {
        return registroEncuestaAscDescDao;
    }

    public void setRegistroEncuestaAscDescDao(RegistroEncuestaAscDescDao registroEncuestaAscDescDao) {
        this.registroEncuestaAscDescDao = registroEncuestaAscDescDao;
    }

    public List<CuadroEncuesta> getEncuestasByFechaAndServicio(Date fechaInicio, Date fechaFin, String servicio){
        return cuadroEncuestaDao.getEncuestasByFechaAndServicio(fechaInicio,fechaFin,servicio);
    }

    public List<RegistroEncuestaAscDesc> getRegistrosByEncuesta(CuadroEncuesta encuesta){
        return registroEncuestaAscDescDao.getRegistrosByEncuesta(encuesta);
    }


}
