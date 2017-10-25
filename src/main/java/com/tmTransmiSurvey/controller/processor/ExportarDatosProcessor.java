package com.tmTransmiSurvey.controller.processor;

import com.tmTransmiSurvey.controller.PathFiles;
import com.tmTransmiSurvey.controller.servicios.EncuestaAscDescServicio;
import com.tmTransmiSurvey.model.entity.CuadroEncuesta;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("ExportarProcessor")
public class ExportarDatosProcessor {

    @Autowired
    public EncuestaAscDescServicio encuestaAscDescServicio;

    public boolean exportarDatosEncuesta(Date fechaInicio, Date fechaFin, String servicio){
        List<CuadroEncuesta> encuestasByFechaAndServicio = encuestaAscDescServicio.getEncuestasByFechaAndServicio(fechaInicio, fechaFin, servicio);
        if(encuestasByFechaAndServicio.size()>0){
            createExcelDiaADia(encuestasByFechaAndServicio);
        }
        return true;
    }

    private void createExcelDiaADia(List<CuadroEncuesta> encuestas){
        try {
            File file = new File(PathFiles.PATH+""+PathFiles.ASC_DES_TRONCAL);
            file.createNewFile();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Datos");
            crearHeader(worksheet);
           // crearRowsIniciales(worksheet);
            //crearRowsContenido(worksheet,workbook,modo,tipologia,fechaInicio,fechaFin);
            FileOutputStream outFile =new FileOutputStream(PathFiles.PATH+""+PathFiles.ASC_DES_TRONCAL);
            workbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
    }

    private void crearHeader(HSSFSheet worksheet) {

    }

    private void crearRowsIniciales(HSSFSheet worksheet) {
        Row row = worksheet.createRow(0);
        createCellResultados(row,GoalReporteDEF.TI_FECHA,GoalReporteDEF.ID_FECHA);
        createCellResultados(row,GoalReporteDEF.TI_CUADRO,GoalReporteDEF.ID_CUADRO);
        createCellResultados(row,GoalReporteDEF.TI_TIPOLOGIA,GoalReporteDEF.ID_TIPOLOGIA);
        createCellResultados(row,GoalReporteDEF.TI_BUSES,GoalReporteDEF.ID_BUSES);
        createCellResultados(row,GoalReporteDEF.TI_KM_COMERCIAL_FIN,GoalReporteDEF.ID_KM_COMERCIAL_FIN);
        createCellResultados(row,GoalReporteDEF.TI_TIEMPO_EXP,GoalReporteDEF.ID_TIEMPO_EXP);
        createCellResultados(row,GoalReporteDEF.TI_KM_VACIO_FIN,GoalReporteDEF.ID_KM_VACIO_FIN);
        createCellResultados(row,GoalReporteDEF.TI_POR_VACIO_FIN,GoalReporteDEF.ID_POR_VACIO_FIN);
        createCellResultados(row,GoalReporteDEF.TI_LINEAS,GoalReporteDEF.ID_LINEAS);
        createCellResultados(row,GoalReporteDEF.TI_TIPO,GoalReporteDEF.ID_TIPO);
        createCellResultados(row,GoalReporteDEF.TI_RAZON,GoalReporteDEF.ID_RAZON);
    }

    private void createCellResultados(Row row, String valor, int num) {
        Cell resultadoHoraIni= row.createCell(num);
        resultadoHoraIni.setCellValue(valor);
        resultadoHoraIni.setCellType(Cell.CELL_TYPE_STRING);
        resultadoHoraIni.setCellValue(valor);
    }


    private void createCellNumberResultados(Row row, int valor,int num) {
        Cell resultadoHoraIni= row.createCell(num);
        resultadoHoraIni.setCellValue(valor);
        resultadoHoraIni.setCellType(Cell.CELL_TYPE_NUMERIC);
        resultadoHoraIni.setCellValue(valor);
    }
}
