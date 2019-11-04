package zhuo.ssm_test.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverterUtils implements Converter<String,Date> {

    /**
     * 进行类型转换的方法
     */
    public Date convert(String source) {
        // 判断
        if(source == null) {
            throw new RuntimeException("参数不能为空");
        }
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            // 解析字符串
            Date date = df.parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("类型转换错误");
        }
    }
}

