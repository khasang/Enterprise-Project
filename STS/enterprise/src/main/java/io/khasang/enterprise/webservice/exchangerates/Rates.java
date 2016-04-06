package io.khasang.enterprise.webservice.exchangerates;

import io.khasang.enterprise.webservice.exchangerates.generated.ru.cbr.web.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

@Configuration
@EnableTransactionManagement
@ComponentScan({"io.khasang.enterprise.webservice"})
public class Rates {
    public Rates() {
    }

    public String getRate(String code) {
//        System.setProperty("http.proxyHost", "192.168.0.1");
//        System.setProperty("http.proxyPort", "3128");
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();
        XMLGregorianCalendar onDate = null;
        try {
            onDate = GetCursOnDateResultParser.getXMLGregorianCalendarNow();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        EnumValutesResponse.EnumValutesResult en = port.enumValutes(false);
        GetCursOnDateResponse.GetCursOnDateResult curs = port.getCursOnDate(onDate);
        onDate = port.getLatestDateTime();
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
        GetCursOnDateResultParser.Valute list = null;
        try {
            list = GetCursOnDateResultParser.getValuteByValuteCh(code, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list != null ? list.curs.setScale(2, BigDecimal.ROUND_DOWN).toString() : null;
    }
}