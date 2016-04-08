package io.khasang.enterprise.webservice.exchangerates;

import io.khasang.enterprise.webservice.exchangerates.generated.ru.cbr.web.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableTransactionManagement
@ComponentScan({"io.khasang.enterprise.webservice"})
public class Rates {
    private static DailyInfo service;

    public Rates() {
//        System.setProperty("http.proxyHost", "192.168.0.1");
//        System.setProperty("http.proxyPort", "3128");
    }

    public DailyInfoSoap getPort() {

        service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();
        return port;
    }

    public String getRate(String code) {
        DailyInfoSoap port = getPort();
        XMLGregorianCalendar onDate = port.getLatestDateTime();
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
        GetCursOnDateResultParser.Valute list = null;
        try {
            list = GetCursOnDateResultParser.getValuteByValuteCh(code, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list != null ? list.curs.setScale(2, BigDecimal.ROUND_DOWN).toString() : null;
    }

    public String getCurrentDay() {
        SimpleDateFormat currentDay = new SimpleDateFormat("dd.MM.yyyy");
        return currentDay.format(new Date()).toString();
    }
}