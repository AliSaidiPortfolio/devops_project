package com.esprit.examen.services;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.esprit.examen.repositories.StockRepository;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
//	@Autowired
//	IStockService stockService;
	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl stockService;
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Stock s = new Stock("stock test",10,100 );
		Mockito.when(stockRepository.save(s)).thenReturn(s);
		Stock savedStock= stockService.addStock(s);
		System.out.println(savedStock.getIdStock());
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
//		assertNotNull(savedStock.getLibelleStock());
//		stockService.deleteStock(savedStock.getIdStock());
		
	}
//	@Test
//	public void testUpdateStock() {
//
//		Stock s = new Stock("stock test",10,100);
//		Stock savedStock= stockService.addStock(s);
//		Stock updateStock=stockService.updateStock(new Stock( "stock test",60,10));
//
//		assertNotNull(updateStock.getIdStock());
//		assertSame(60, updateStock.getQte());
//		assertTrue(updateStock.getQteMin()<11);
//		assertSame(savedStock.getIdStock(), updateStock.getQte());
//		stockService.deleteStock(savedStock.getIdStock());
//
//	}
//
//	@Test
//	public void testAddStockOptimized() {
//
//		Stock s = new Stock("stock test",10,100);
//		Stock savedStock= stockService.addStock(s);
//		assertNotNull(savedStock.getIdStock());
//		assertSame(10, savedStock.getQte());
//		assertTrue(savedStock.getQteMin()>0);
//		stockService.deleteStock(savedStock.getIdStock());
//
//	}
//
//	@Test
//	public void testDeleteStock() {
//		Stock s = new Stock("stock test",30,60);
//		Stock savedStock= stockService.addStock(s);
//		stockService.deleteStock(savedStock.getIdStock());
//		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
//	}
//
//	@Test
//	public void testRetrieveAllStocks(){
//		List<Stock> stocks = stockService.retrieveAllStocks();
//		int expected=stocks.size();
//		Stock s = new Stock("stock test",30,60);
//		Stock savedStock= stockService.addStock(s);
//		assertEquals(expected+1, stockService.retrieveAllStocks().size());
//		stockService.deleteStock(savedStock.getIdStock());
//	}
//
//	@Test
//	public void testRetrieveStockById(){
//
//		Stock s = new Stock("stock test",10,60);
//		Stock savedStock= stockService.addStock(s);
//		Stock stockGet=stockService.retrieveStock(savedStock.getIdStock());
//		assertNotNull(stockGet.getIdStock());
//		assertSame(10, stockGet.getQte());
//		assertTrue(stockGet.getQteMin()>0);
//		stockService.deleteStock(stockGet.getIdStock());
//	}

}
