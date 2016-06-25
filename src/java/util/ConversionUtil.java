/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Provides methods helpful in making object conversions not provided for by the
 * Sun or MyFaces distributions.
 *
 * @author <a href="mailto:jholtzman@berkeley.edu">Josh Holtzman</a>
 *
 */
public class ConversionUtil {

    private static final SimpleDateFormat anoMesDiaformato = new SimpleDateFormat("yyyy.MM.dd");
    
    private static final SimpleDateFormat anoMesDiaHoraformato = new SimpleDateFormat("yyyy.MM.dd kk:mm:ss");
    
    private static final SimpleDateFormat mesDiaDiaformato = new SimpleDateFormat("MM.dd");

    private static final SimpleDateFormat horaCortaDiaformato = new SimpleDateFormat("H:mm a" ); 
            
    private static final SimpleDateFormat horaLargaDiaformato = new SimpleDateFormat("kk:mm:ss" ); 
    
    
    /**
     * convert into java.sql.Time (or into java.util.Calendar
     *
     * @param date --> The date containing the time.
     * @param am --> Whether this should be am (true) or pm (false)
     * @return
     */
    public static Time convertDateToTime(Date date, boolean am) {
        if (date == null) {
            return null;
        }

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);

        if (am) {
            // Check to make sure that the hours are indeed am hours
            if (hourOfDay > 11) {
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay - 12);
                date.setTime(cal.getTimeInMillis());
            }
        } else {
            // Check to make sure that the hours are indeed pm hours
            if (cal.get(Calendar.HOUR_OF_DAY) < 11) {
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay + 12);
                date.setTime(cal.getTimeInMillis());
            }
        }
        return new Time(date.getTime());
    }

    public static Time getTodayToTime(int hora, int min, int seg) {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, hora);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, seg);
        Date date = cal.getTime();
        return new Time(date.getTime());
    }
    
    public static Time getTodayToDate(int year, int month, int day) {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, year);
        cal.set(Calendar.MINUTE, month);
        cal.set(Calendar.SECOND, day);
        Date date = cal.getTime();
        return new Time(date.getTime());
    }
    
    public static String convertDateToHoraLarga(Date date) {
        if (date == null) {
            return null;
        }
        
        Calendar cal = new GregorianCalendar();
        
        cal.setTime(date);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        
        return String.format("%02d:%02d:%02d", hora, minuto,segundo);
    } 
    
    public static String convertDateToFechaLarga(Date date) {
        if (date == null) {
            return null;
        }
        
        Calendar cal = new GregorianCalendar();
        
        cal.setTime(date);
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        
        return String.format("%02d.%02d.%02d %02d:%02d:%02d", ano, mes, dia, hora, minuto,segundo);
    }

    public static String convertDateToFechaCorta(Date date) {
        if (date == null) {
            return null;
        }
        
        Calendar cal = new GregorianCalendar();
        
        cal.setTime(date);
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        
        return String.format("%02d.%02d.%02d", ano, mes, dia);
    }
    
    public static String timestampToAnoMesDia(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return anoMesDiaformato.format((java.util.Date) timestamp);
        }
    }

    public static String timeStampCurrentDateTime() {
        Date date = new Date();
        return anoMesDiaHoraformato.format(date);
    }
            
    public static String timestampToAnoMesDiaHoraMinSeg(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return anoMesDiaHoraformato.format((java.util.Date) timestamp);
        }
    }

    public static String timestampToMesDia(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return mesDiaDiaformato.format((java.util.Date) timestamp);
        }
    }

    public static java.sql.Timestamp getTimestamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
    
    public static String timestampToHoraLarga(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return horaLargaDiaformato.format((java.util.Date) timestamp);
          }
    }
    
    public static String timestampToHoraCorta(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return horaCortaDiaformato.format((java.util.Date) timestamp);
          }
    }
    
}