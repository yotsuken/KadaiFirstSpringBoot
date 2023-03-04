package com.techacademy;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloSpringBootController {

    @GetMapping("/")
    public String index() {
        return "abc";
    }

    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {


    // 年・月を取得する
    int y = Integer.parseInt(yyyymmdd.substring(0, 4));
    int m = Integer.parseInt(yyyymmdd.substring(4, 6)) - 1;
    int d = Integer.parseInt(yyyymmdd.substring(6, 8));

    // 取得した年月の最終年月日を取得する
    Calendar cal = Calendar.getInstance();
    cal.set(y, m, d);

    // 曜日を得る
    switch (cal.get(Calendar.DAY_OF_WEEK)) {
    case Calendar.SUNDAY:
    return "Sunday";
    case Calendar.MONDAY:
    return "Monday";
    case Calendar.TUESDAY:
    return "Tuesday";
    case Calendar.WEDNESDAY:
    return "Wednesday";
    case Calendar.THURSDAY:
    return "Thursday";
    case Calendar.FRIDAY:
    return "Friday";
    case Calendar.SATURDAY:
    return "Saturday";
    }
    return "曜日が判断できませんでした";

    }

    // ----- 足し算 -----
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果："+ res;
    }

    // ----- 引き算 -----
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果："+ res;
    }

    // ----- 掛け算 -----
    @GetMapping("times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果："+ res;
    }

    // ----- 割り算 -----
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果："+ res;
    }




    }



