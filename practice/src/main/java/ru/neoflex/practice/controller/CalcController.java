package ru.neoflex.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/plus/{a}/{b}")
    public Integer Sum(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return a + b;                                                                      
    }

    @GetMapping("/minus/{a}/{b}")
    public Integer Minus(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {  
        return a - b;                                                                           
    }
    
    @GetMapping("/vacation/{countDaysWork}/{salaryInYear}/{countDaysVacation}")
    public String VacationPayment(@PathVariable("countDaysWork") Integer countDaysW,            
                                   @PathVariable("salaryInYear") Double salaryInYear,           
                                   @PathVariable("countDaysVacation") Integer countDaysV ) {    
        Double avgSalaryInDay = salaryInYear / countDaysW;      
        Double result = avgSalaryInDay * countDaysV;         
        String resultString = String.format("%.2f",result);    
        return "За отпуск "+countDaysV+" дней сотрудник получит "+resultString+" руб.";      
    }

}
