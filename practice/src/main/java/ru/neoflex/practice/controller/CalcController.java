package ru.neoflex.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    /** вычисление суммы чисел
     *
     * @param a - первое число
     * @param b - второе число
     * @return  - сумма чисел
     */
    @GetMapping("/plus/{a}/{b}")
    public Integer sum(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return a + b;
    }

    /** вычисление разности чисел
     *
     * @param a - первое число
     * @param b - второе число
     * @return  - разность чисел
     */
    @GetMapping("/minus/{a}/{b}")
    public Integer minus(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return a - b;
    }

    /**
     *
     * @param countDaysW    - количесто отработанных дней за год
     * @param salaryInYear  - количество зарплаты за год
     * @param countDaysV    - количество дней отпуска для расчёта
     * @return              - Отпускные = среднедневной заработок × количество дней отпуска
     * avgSalaryInDay       - среднедневной заработок — это доход за расчетный период, поделенный на количество отработанных дней
     */
    @GetMapping("/vacation/{countDaysWork}/{salaryInYear}/{countDaysVacation}")
    public String vacationPayment(@PathVariable("countDaysWork") Integer countDaysW,
                                   @PathVariable("salaryInYear") Double salaryInYear,
                                   @PathVariable("countDaysVacation") Integer countDaysV ) {
        Double avgSalaryInDay = salaryInYear / countDaysW;
        Double result = avgSalaryInDay * countDaysV;//
        String resultString = String.format("%.2f",result);
        return "За отпуск "+countDaysV+" дней сотрудник получит "+resultString+" руб.";
    }
}