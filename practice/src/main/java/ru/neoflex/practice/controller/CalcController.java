package ru.neoflex.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/plus/{a}/{b}")
    public Integer Sum(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return a + b;                                                                           // вычисление суммы чисел
    }

    @GetMapping("/minus/{a}/{b}")
    public Integer Minus(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {  
        return a - b;                                                                           // вычисление разности чисел
    }
    @GetMapping("/vacation/{CountDaysWork}/{SalaryInYear}/{CountDaysVacation}")
    public String VacationPayment(@PathVariable("CountDaysWork") Integer countDaysW,            // количесто отработанных дней за год
                                   @PathVariable("SalaryInYear") Double salaryInYear,           // количествно зарплаты за год
                                   @PathVariable("CountDaysVacation") Integer countDaysV ) {    // количество дней отпуска для расчёта
        Double avgSalaryInDay = salaryInYear / countDaysW;      // Средний дневной заработок для оплаты отпускных — это доход за расчетный период, поделенный на количество отработанных дней.
        Double result = avgSalaryInDay * countDaysV;            // Отпускные = среднедневной заработок × количество дней отпуска
        String resultString = String.format("%.2f",result);     // округление результатов вычисления
        return "За отпуск "+countDaysV+" дней сотрудник получит "+resultString+" руб.";         // возвращение результата вычисления 
    }

}
