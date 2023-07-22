package org.top.informationunitconvertermvc.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@Service
public class InformationConverterImpl implements InformationConverter {

    @Override
    public String converter(String from, String to, String quantity) {
        BigDecimal outputValue = BigDecimal.valueOf(Long.parseLong(quantity));
        List<String> nameUnit = Arrays.asList("bits","Byte", "KB", "MB", "GB", "TB", "PB");
        List<Integer> valueUnit = Arrays.asList(0,8,1024,1024,1024,1024,1024);
        int indFrom = nameUnit.indexOf(from);
        int indTo = nameUnit.indexOf(to);
        String result="";
        if (indFrom < indTo)
            for (int i = indFrom+1; i <= indTo; i++)
                outputValue = outputValue.
                        divide(BigDecimal.valueOf(valueUnit.get(i))).
                        setScale(1, RoundingMode.HALF_UP);
        else
            for (int i = indFrom; i > indTo; i--)
                outputValue = outputValue.multiply(BigDecimal.valueOf(valueUnit.get(i))).
                        setScale(1, RoundingMode.HALF_UP);
        result = outputValue+" "+to;
        return result;
    }
}
