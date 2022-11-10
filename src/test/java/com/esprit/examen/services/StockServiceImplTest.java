package com.esprit.examen.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.esprit.examen.repositories.StockRepository;
import org.hibernate.type.TrueFalseType;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;

	@Test
	public void testAddStock() {
//		List<Stock> stocks = stockService.retrieveAllStocks();
//		      int expected=stocks.size();
		Stock s = new Stock("stock test",600,60);
		Stock savedStock= stockService.addStock(s);

		//      assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());

	}

	@Test
	public void testRetrieveStockById() {
		Stock s=stockService.retrieveStock(1L);
		assertNotNull(s);
		assertSame(100,s.getQte());
		assertSame(10, s.getQteMin());

//		assertTrue(savedStock.getQteMin()>0);
	//	stockService.deleteStock(savedStock.getIdStock());

	}
	@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",600,60);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(60, savedStock.getQteMin());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());

	}


	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",600,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
}
