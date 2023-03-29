package ru.neoflex.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PracticeApplicationTest {

	@Autowired
	private MockMvc mockMvc;
	public Integer res;	// переменная для вычисления результата запроса

	/**
	 * Функция тестирования get запроса сложения
	 * тестовые значения a = 5, b = 2
	 * 1. Проверка статуса выполнения запроса
	 * 2. Проверка результата выполнения: результат запроса содержит 7
	 * @throws Exception
	 */
	@Test
	public void shouldReturnSum() throws Exception {
		res = 5 + 2;
		this.mockMvc
			.perform(get("/plus/5/2")) // perform a request that can be chained
			.andExpect(status().isOk())
		    .andExpect(result -> result.getRequest().toString().contains(res+"") );
	}

	/**
	 * Функция тестирования get запроса разности
	 * тестовые значения a = 5, b = 2
	 * 1. Проверка статуса выполнения запроса
	 * 2. Проверка результата выполнения: результат запроса содержит 3
	 * @throws Exception
	 */
	@Test
	public void shouldReturnMinus() throws Exception {
		res = 5 - 2;
		this.mockMvc
			.perform(get("/minus/5/2")) // perform a request that can be chained
			.andExpect(status().isOk())
			.andExpect(result -> result.getRequest().toString().contains(res+""));
	}
	
	/**
	 * Функция тестирования get запроса вычисления количества отпускных
	 * тестовые значения: countDaysWork = 321, salaryInYear = 350000, countDaysVacation = 20
	 * 1. Проверка статуса выполнения запроса
	 * 2. Проверка результата выполнения: результат запроса содержит 21806,85
	 * @throws Exception
	 */
	@Test
	public void shouldReturnVacation() throws Exception {
		Double resD = 350000 / 321.0 * 20;
		String resStr = String.format("%.2f",resD);
		this.mockMvc
			.perform(get("/vacation/321/350000/20"))
			.andExpect(status().isOk())
			.andExpect(result -> result.getRequest().toString().contains(resStr));
	}
}



